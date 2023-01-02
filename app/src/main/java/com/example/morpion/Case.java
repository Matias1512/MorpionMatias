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
    public int couleur = Color.RED;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int hauteur = getMeasuredHeight();
        int largeur = getMeasuredWidth();

        Paint paint = new Paint();
        paint.setColor(couleur);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(largeur/2, hauteur/2, largeur/2, paint);
    }
}