package com.motiky.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AcceleroMeterActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accelero_meter);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sensorManager != null) {
            Sensor accel_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accel_sensor != null) {
                sensorManager.registerListener(this, accel_sensor, SensorManager.SENSOR_DELAY_NORMAL);
            } else {
                Toast.makeText(this, "Oops, your accelerometer sensor is not working!!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Oops, sensor service not detected!!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            TextView textViewAccl = findViewById(R.id.textViewAccl);
            String data = "X : " + event.values[0] + "\n" + "Y : " + event.values[1] + "\n" + "Z : " + event.values[2] + "\n\n";
            textViewAccl.setText(data);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}