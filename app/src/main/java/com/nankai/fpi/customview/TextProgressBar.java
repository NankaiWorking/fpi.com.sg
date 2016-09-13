package com.nankai.fpi.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.nankai.fpi.R;

/**
 * Created by namIT on 9/13/2016.
 */
public class TextProgressBar extends ProgressBar {
    private String text;
    private Paint textPaint;

    public TextProgressBar(Context context) {
        super(context);
        text = getProgress() + "%";
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(getContext().getResources().getDimension(R.dimen.text_2_12sp));
    }

    public TextProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        text = getProgress() + "%";
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(getContext().getResources().getDimension(R.dimen.text_2_12sp));
    }

    public TextProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        text = getProgress() + "%";
        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(getContext().getResources().getDimension(R.dimen.text_2_12sp));
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        // First draw the regular progress bar, then custom draw our text
        super.onDraw(canvas);
        Rect bounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), bounds);
        int x = getWidth() / 2 - bounds.centerX();
        int y = getHeight() / 2 - bounds.centerY();
        canvas.drawText(text, x, y, textPaint);
    }

    public synchronized void setText(String text) {
        this.text = text;
        drawableStateChanged();
    }

    public void setTextColor(int color) {
        textPaint.setColor(color);
        drawableStateChanged();
    }
}