package com.example.rob.sensorinfo;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AccelerometerActivity extends Activity implements SensorEventListener {

    private EditText etNotify;
    private TextView tvDX;
    private TextView tvDY;
    private TextView tvDZ;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    private float lastX = 0, lastY = 0, lastZ = 0;
    private float dX, dY, dZ;

    private float notifyvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        etNotify = (EditText) findViewById(R.id.etNotify);
        tvDX = (TextView) findViewById(R.id.tvDX);
        tvDY = (TextView) findViewById(R.id.tvDY);
        tvDZ = (TextView) findViewById(R.id.tvDZ);

        initText();

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        notifyvalue = mAccelerometer.getMaximumRange() / 2; // als de acceleratie boven deze waarde uitkomt, dan zou je een melding kunnen geven, in dit geval wordt dan de EditText etNotify gevuld.

    }


    private void initText() {
        etNotify.setText("");
        tvDX.setText("");
        tvDY.setText("");
        tvDZ.setText("");
    }


    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }


    @Override
    public final void onSensorChanged(SensorEvent event) {

        // waarden van de event-array uitlezen en op scherm zetten
        tvDX.setText("" + event.values[0]);
        tvDY.setText("" + event.values[1]);
        tvDZ.setText("" + event.values[2]);

        // vergelijk met de vorige waarden
        dX = Math.abs(lastX - event.values[0]);
        dY = Math.abs(lastY - event.values[1]);
        dZ = Math.abs(lastZ - event.values[2]);

        if (dX > notifyvalue || dY > notifyvalue || dZ > notifyvalue) {
            etNotify.setText("Sensorwaarde > " + notifyvalue);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAccelerometer != null) {
            mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mAccelerometer != null) {
            mSensorManager.unregisterListener(this);
        }
    }
}
