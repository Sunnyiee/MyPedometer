package com.example.edu.mypedometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    float threshold, previousY,currentY,steps,acceleration;
    SensorManager sensorManager;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        threshold = 3;
        previousY = currentY = steps = 0;
        acceleration = 0.0f;
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(
                Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        textView.findViewById(R.id.textView);
        currentY = y;
        if (Math.abs(currentY - previousY) > threshold) {
            steps++;
            textView.setText(String.valueOf(steps));

        }
        //textViewGx.setText(String.valueOf(x));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
