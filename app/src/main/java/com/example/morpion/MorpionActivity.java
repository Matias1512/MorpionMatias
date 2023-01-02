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

public class MorpionActivity extends AppCompatActivity {
    public symbole joueur = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morpion);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference CercleDataRef = database.getReference("Cercle");
        final EditText editText = findViewById(R.id.editText);
        CercleDataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Boolean value = dataSnapshot.getValue(Boolean.class);
                Log.d("APPX", "Value is: " + value);
                if(joueur == null){
                    if(value){
                        joueur = joueur.CROIX;
                        editText.setText(joueur.CROIX.toString());
                    } else {
                        joueur = joueur.CERCLE;
                        editText.setText(joueur.CERCLE.toString());
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("APPX", "Failed to read value.", error.toException());
            }
        });
        Button button = findViewById(R.id.button);
        // bouton test
        DatabaseReference myRef = database.getReference("Case1_1");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Case1_1");
                //myRef.setValue(editText.getText().toString());
            }
        });
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("APPX", "Value is: " + value);
                //editText.setText(value);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("APPX", "Failed to read value.", error.toException());
            }
        });

        Case case1 = findViewById(R.id.case1);
        Case case2 = findViewById(R.id.case2);
        Case case3 = findViewById(R.id.case3);
        Case case4 = findViewById(R.id.case4);
        Case case5 = findViewById(R.id.case5);
        Case case6 = findViewById(R.id.case6);
        Case case7 = findViewById(R.id.case7);
        Case case8 = findViewById(R.id.case8);
        Case case9 = findViewById(R.id.case9);
        case1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
                myRef.setValue("ça marche");
            }
        });
        case2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
                myRef.setValue("ça marche");
            }
        });
        case3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
                myRef.setValue("ça marche");
            }
        });
        case4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
                myRef.setValue("ça marche");
            }
        });
        case5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
                myRef.setValue("ça marche");
            }
        });
        case6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
                myRef.setValue("ça marche");
            }
        });
        case7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
                myRef.setValue("ça marche");
            }
        });
        case8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
                myRef.setValue("ça marche");
            }
        });
        case9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Case)view).couleur = Color.BLACK;
                ((Case)view).joueur = joueur;
                view.invalidate();
                myRef.setValue("ça marche");
            }
        });
    }
}