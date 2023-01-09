package com.example.morpion;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MorpionActivity extends AppCompatActivity {
    public symbole joueur = null;

    private void setCase(DatabaseReference caseDataRef, Case c) {
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
                Log.w("APPX", "LA CASE "+value);
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
                caseDataRef.setValue(joueur.toString());
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
        final EditText editText = findViewById(R.id.editText);

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

        DatabaseReference[] caseRefArray = {case1DataRef, case2DataRef, case3DataRef, case4DataRef, case5DataRef, case6DataRef, case7DataRef, case8DataRef, case9DataRef};

        // attribution role (cercle ou croix) joueur
        CercleDataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                Log.d("APPX", "Value is: " + value);
                if(joueur == null){
                    if(value){
                        joueur = joueur.CROIX;
                        editText.setText(joueur.CROIX.toString());
                        CroixDataRef.setValue(true);
                    } else {
                        joueur = joueur.CERCLE;
                        editText.setText(joueur.CERCLE.toString());
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

        setCase(case1DataRef, case1);
        setCase(case2DataRef, case2);
        setCase(case3DataRef, case3);
        setCase(case4DataRef, case4);
        setCase(case5DataRef, case5);
        setCase(case6DataRef, case6);
        setCase(case7DataRef, case7);
        setCase(case8DataRef, case8);
        setCase(case9DataRef, case9);
    }
}