package com.example.capture.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ActivityRecognitionFragment extends Fragment implements SensorEventListener {
    private SensorManager sm;
    private TextView tvActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tvActivity = new TextView(getContext());
        tvActivity.setTextSize(24);
        sm = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        return tvActivity;
    }

    @Override
    public void onResume() {
        super.onResume();
        Sensor s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (s != null) sm.registerListener(this, s, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        double magnitude = Math.sqrt(x*x + y*y + z*z);

        if (magnitude < 9.2) {
            tvActivity.setText("Activité : En mouvement (Chute / Saut)");
        } else if (magnitude > 11.5) {
            tvActivity.setText("Activité : Marche / Course");
        } else {
            tvActivity.setText("Activité : Immobile");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor s, int i) {}
}
