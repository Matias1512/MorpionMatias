package com.example.morpion;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MorpionActivity extends AppCompatActivity {
    public symbole joueur = null;
    public boolean monTour;

    private void setCase(DatabaseReference caseDataRef, Case c, DatabaseReference tourRef) {
        caseDataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                    c.couleur = Color.BLACK;
                    if (value.equals("CROIX")){
                        c.joueur = symbole.CROIX;
                    } else if (value.equals("CERCLE")){
                        c.joueur = symbole.CERCLE;
                    } else {
                        c.joueur = symbole.VIDE;
                    }
                    c.invalidate();
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("APPX", "Failed to read value.", error.toException());
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(monTour && ((Case)view).joueur.equals(symbole.VIDE)){
                    caseDataRef.setValue(joueur.toString());
                    if(joueur.equals(symbole.CROIX)){
                        tourRef.setValue("CERCLE");
                    } else {
                        tourRef.setValue("CROIX");
                    }
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morpion);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference CercleDataRef = database.getReference("Cercle");
        DatabaseReference CroixDataRef = database.getReference("Croix");
        final TextView afficheRole = findViewById(R.id.AfficheRole);
        final TextView afficheTour = findViewById(R.id.AfficheTour);

        Case case1 = findViewById(R.id.case1);
        Case case2 = findViewById(R.id.case2);
        Case case3 = findViewById(R.id.case3);
        Case case4 = findViewById(R.id.case4);
        Case case5 = findViewById(R.id.case5);
        Case case6 = findViewById(R.id.case6);
        Case case7 = findViewById(R.id.case7);
        Case case8 = findViewById(R.id.case8);
        Case case9 = findViewById(R.id.case9);

        Case[] caseArray = {case1, case2, case3, case4, case5, case6, case7, case8, case9};

        DatabaseReference case1DataRef = database.getReference("Case1");
        DatabaseReference case2DataRef = database.getReference("Case2");
        DatabaseReference case3DataRef = database.getReference("Case3");
        DatabaseReference case4DataRef = database.getReference("Case4");
        DatabaseReference case5DataRef = database.getReference("Case5");
        DatabaseReference case6DataRef = database.getReference("Case6");
        DatabaseReference case7DataRef = database.getReference("Case7");
        DatabaseReference case8DataRef = database.getReference("Case8");
        DatabaseReference case9DataRef = database.getReference("Case9");

        DatabaseReference tourRef = database.getReference("Tour");

        //definir le tour
        tourRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if(value.equals(joueur.toString())){
                    monTour = true;
                } else {
                    monTour = false;
                }
                afficheTour.setText("Au tour de : "+value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
            // Failed to read value
            Log.w("APPX", "Failed to read value.", error.toException());
            }
        });

        // attribution role (cercle ou croix) joueur
        CercleDataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                Log.d("APPX", "Value is: " + value);
                if(joueur == null){
                    if(value){
                        joueur = joueur.CROIX;
                        afficheRole.setText(joueur.CROIX.toString());
                        CroixDataRef.setValue(true);
                    } else {
                        joueur = joueur.CERCLE;
                        afficheRole.setText(joueur.CERCLE.toString());
                        CercleDataRef.setValue(true);
                    }
                    Log.d("APPX", "Value is: " + value);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("APPX", "Failed to read value.", error.toException());
            }
        });

        // initialisation tout les cases
        setCase(case1DataRef, case1, tourRef);
        setCase(case2DataRef, case2, tourRef);
        setCase(case3DataRef, case3, tourRef);
        setCase(case4DataRef, case4, tourRef);
        setCase(case5DataRef, case5, tourRef);
        setCase(case6DataRef, case6, tourRef);
        setCase(case7DataRef, case7, tourRef);
        setCase(case8DataRef, case8, tourRef);
        setCase(case9DataRef, case9, tourRef);
    }
}