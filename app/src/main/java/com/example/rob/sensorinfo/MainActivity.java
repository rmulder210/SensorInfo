package com.example.rob.sensorinfo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private SensorManager mSensorManager;

    Button btTYPE_MAGNETIC_FIELD, btTYPE_ACCELEROMETER, btTYPE_AMBIENT_TEMPERATURE, btTYPE_GRAVITY, btTYPE_GYROSCOPE, btTYPE_LIGHT, btTYPE_LINEAR_ACCELERATION, btTYPE_ORIENTATION, btTYPE_PRESSURE, btTYPE_PROXIMITY, btTYPE_RELATIVE_HUMIDITY, btTYPE_ROTATION_VECTOR ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        initButtons();

    }

    
    private void initButtons() {
        
        btTYPE_MAGNETIC_FIELD      = (Button) findViewById( R.id.btTYPE_MAGNETIC_FIELD      ) ;
        btTYPE_ACCELEROMETER       = (Button) findViewById( R.id.btTYPE_ACCELEROMETER       ) ;
        btTYPE_AMBIENT_TEMPERATURE = (Button) findViewById( R.id.btTYPE_AMBIENT_TEMPERATURE ) ;
        btTYPE_GRAVITY             = (Button) findViewById( R.id.btTYPE_GRAVITY             ) ;
        btTYPE_GYROSCOPE           = (Button) findViewById( R.id.btTYPE_GYROSCOPE           ) ;
        btTYPE_LIGHT               = (Button) findViewById( R.id.btTYPE_LIGHT               ) ;
        btTYPE_LINEAR_ACCELERATION = (Button) findViewById( R.id.btTYPE_LINEAR_ACCELERATION ) ;
        btTYPE_ORIENTATION         = (Button) findViewById( R.id.btTYPE_ORIENTATION         ) ;
        btTYPE_PRESSURE            = (Button) findViewById( R.id.btTYPE_PRESSURE            ) ;
        btTYPE_PROXIMITY           = (Button) findViewById( R.id.btTYPE_PROXIMITY           ) ;
        btTYPE_RELATIVE_HUMIDITY   = (Button) findViewById( R.id.btTYPE_RELATIVE_HUMIDITY   ) ;
        btTYPE_ROTATION_VECTOR     = (Button) findViewById( R.id.btTYPE_ROTATION_VECTOR     ) ;

        // initially hide all buttons
        btTYPE_MAGNETIC_FIELD.setVisibility( View.GONE);
        btTYPE_ACCELEROMETER.setVisibility( View.GONE);
        btTYPE_AMBIENT_TEMPERATURE.setVisibility( View.GONE);
        btTYPE_GRAVITY.setVisibility( View.GONE);
        btTYPE_GYROSCOPE.setVisibility( View.GONE);
        btTYPE_LIGHT.setVisibility( View.GONE);
        btTYPE_LINEAR_ACCELERATION.setVisibility( View.GONE);
        btTYPE_ORIENTATION.setVisibility( View.GONE);
        btTYPE_PRESSURE.setVisibility( View.GONE);
        btTYPE_PROXIMITY.setVisibility( View.GONE);
        btTYPE_RELATIVE_HUMIDITY.setVisibility( View.GONE);
        btTYPE_ROTATION_VECTOR.setVisibility( View.GONE);

        if (mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD     ) != null) {
            btTYPE_MAGNETIC_FIELD.setVisibility( View.VISIBLE);
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER      ) != null) {
            zetkleur( btTYPE_ACCELEROMETER);
            btTYPE_ACCELEROMETER.setVisibility( View.VISIBLE);
            btTYPE_ACCELEROMETER.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent accelerometerIntent = new Intent( MainActivity.this, AccelerometerActivity.class);
                    startActivity( accelerometerIntent);
                }
            });



        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            btTYPE_AMBIENT_TEMPERATURE.setVisibility( View.VISIBLE);
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY            ) != null) {
            btTYPE_GRAVITY.setVisibility( View.VISIBLE);
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE          ) != null) {
            btTYPE_GYROSCOPE.setVisibility( View.VISIBLE);
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT              ) != null) {
            btTYPE_LIGHT.setVisibility( View.VISIBLE);
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) != null) {
            btTYPE_LINEAR_ACCELERATION.setVisibility( View.VISIBLE);
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION        ) != null) {
            btTYPE_ORIENTATION.setVisibility( View.VISIBLE);
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE           ) != null) {
            zetkleur(btTYPE_PRESSURE);
            btTYPE_PRESSURE.setVisibility( View.VISIBLE);
            btTYPE_PRESSURE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent pressureIntent = new Intent(MainActivity.this, PressureActivity.class);
                    startActivity(pressureIntent);
                }
            });
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY          ) != null) {
            btTYPE_PROXIMITY.setVisibility( View.VISIBLE);
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY  ) != null) {
            btTYPE_RELATIVE_HUMIDITY.setVisibility( View.VISIBLE);
        }
        if (mSensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR    ) != null) {
            btTYPE_ROTATION_VECTOR.setVisibility( View.VISIBLE);
        }

    }

    public void zetkleur( Button btn ) {
        btn.setBackgroundColor(0XFF95D1FF);
        btn.setTextColor(0XFFFFFFFF);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
