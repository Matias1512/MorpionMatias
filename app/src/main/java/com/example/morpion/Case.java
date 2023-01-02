package com.example.morpion;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Case extends View {

    public Case(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public int couleur = Color.WHITE;
    public String joueur = "Croix";
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int hauteur = getMeasuredHeight();
        int largeur = getMeasuredWidth();
        Paint paint = new Paint();
        paint.setColor(couleur);
        if (joueur == "Croix") {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawLine(0,0,hauteur,largeur, paint);
            canvas.drawLine(0,largeur,hauteur,0, paint);
        }
        if (joueur == "Cercle") {
            paint.setStyle(Paint.Style.FILL);
            canvas.drawLine(0,0,hauteur,largeur, paint);
            canvas.drawLine(0,largeur,hauteur,0, paint);
        }

        //paint.setStyle(Paint.Style.FILL);
        //canvas.drawCircle(largeur/2, hauteur/2, largeur/2, paint);
    }
}