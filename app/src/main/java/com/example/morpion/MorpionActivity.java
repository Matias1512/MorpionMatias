package com.example.morpion;

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
    public String case1Attribution = null;
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
        // pour faire un boucle pour les cases
        Case[] caseArray = {case1, case2, case3, case4, case5, case6, case7, case8, case9};

        DatabaseReference case1DataRef = database.getReference("Case1");

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

        case1DataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                case1.couleur = Color.BLACK;
                if (value.equals("CROIX")){
                    case1.joueur = symbole.CROIX;
                } else if (value.equals("CERCLE")){
                    case1.joueur = symbole.CERCLE;
                } else {
                    case1.joueur = symbole.VIDE;
                }
                case1.invalidate();
                Log.w("APPX", "LA CASE "+value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("APPX", "Failed to read value.", error.toException());
            }
        });

        //initialisation case

        case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                case1DataRef.setValue(joueur.toString());
            }
        });
        case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
            }
        });
        case3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
            }
        });
        case4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
            }
        });
        case5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
            }
        });
        case6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
            }
        });
        case7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
            }
        });
        case8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
            }
        });
        case9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
            }
        });
    }
}