package com.example.capture.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class LineChartView extends View {
    private Paint paint;
    private Path path;
    private List<Float> dataPoints = new ArrayList<>();
    private final int MAX_POINTS = 80;

    public LineChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.parseColor("#00FF00"));
        paint.setStrokeWidth(5f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        path = new Path();
    }

    public void addValue(float val) {
        dataPoints.add(val);
        if (dataPoints.size() > MAX_POINTS) dataPoints.remove(0);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (dataPoints.size() < 2) return;

        float w = getWidth();
        float h = getHeight();
        float xStep = w / MAX_POINTS;
        
        path.reset();
        path.moveTo(0, h/2 - (dataPoints.get(0) * 10));

        for (int i = 1; i < dataPoints.size(); i++) {
            path.lineTo(i * xStep, h/2 - (dataPoints.get(i) * 10));
        }
        canvas.drawPath(path, paint);
    }
}
