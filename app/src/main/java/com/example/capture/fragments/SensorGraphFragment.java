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
import com.example.capture.R;
import com.example.capture.views.LineChartView;

public class SensorGraphFragment extends Fragment implements SensorEventListener {
    private SensorManager sm;
    private LineChartView chart;
    private TextView tvInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_graph, container, false);
        chart = v.findViewById(R.id.chartView);
        tvInfo = v.findViewById(R.id.tvInfo);
        sm = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        register(Sensor.TYPE_AMBIENT_TEMPERATURE);
        register(Sensor.TYPE_RELATIVE_HUMIDITY);
        register(Sensor.TYPE_PROXIMITY);
        register(Sensor.TYPE_MAGNETIC_FIELD);
    }

    private void register(int type) {
        Sensor s = sm.getDefaultSensor(type);
        if (s != null) sm.registerListener(this, s, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float val = event.values[0];
        tvInfo.setText("Capteur : " + event.sensor.getName() + "\nValeur : " + val);
        chart.addValue(val);
    }

    @Override
    public void onAccuracyChanged(Sensor s, int i) {}
}
