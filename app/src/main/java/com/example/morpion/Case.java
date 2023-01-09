package com.example.morpion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Case extends View {

    public Case(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public int couleur = Color.BLACK;
    public symbole joueur = symbole.VIDE;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int hauteur = getMeasuredHeight();
        int largeur = getMeasuredWidth();
        Paint paint = new Paint();
        paint.setColor(couleur);
        if (joueur.equals(symbole.CROIX)) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawLine(0,0,hauteur,largeur, paint);
            canvas.drawLine(0,largeur,hauteur,0, paint);
            Log.w("APPX", "CROIX");
        }
        if (joueur.equals(symbole.CERCLE)) {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(largeur/2, hauteur/2, largeur/2, paint);
            Log.w("APPX", "CERCLE");
        }
        if(joueur.equals(symbole.VIDE)) {
            couleur = Color.WHITE;
            paint.setColor(couleur);
            Log.w("APPX", "VIDE");
        }
        Log.w("APPX", "dans CASE "+ joueur);
    }
}