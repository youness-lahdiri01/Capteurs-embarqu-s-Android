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

public class StepCounterFragment extends Fragment implements SensorEventListener {
    private TextView tvSteps;
    private SensorManager sm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tvSteps = new TextView(getContext());
        tvSteps.setTextSize(30);
        tvSteps.setGravity(17);
        sm = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        return tvSteps;
    }

    @Override
    public void onResume() {
        super.onResume();
        Sensor s = sm.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (s != null) sm.registerListener(this, s, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        tvSteps.setText("Pas détectés : " + event.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor s, int i) {}
}
