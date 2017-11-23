package com.example.evergistelova.listmenu;

import android.app.Fragment;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;


public class HandleSensorFragment extends Fragment implements SensorEventListener{

    SensorManager sensorManager;
    DecimalFormat df = new DecimalFormat("0.0");
    TextView accelerometerView;
    TextView gyroscopeView;
    TextView magnetometerView;
    TextView rotationView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sensorManager = (SensorManager) this.getActivity().getSystemService(Context.SENSOR_SERVICE);
        //sensors
        sensorManager.registerListener(this, sensorManager.getDefaultSensor
                (Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        sensorManager.registerListener(this, sensorManager.getDefaultSensor
                (Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_ORIENTATION);

        sensorManager.registerListener(this, sensorManager.getDefaultSensor
                (Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_NORMAL);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.sensor_view,container,false);
        accelerometerView = (TextView) layout.findViewById(R.id.accelerometer);
        accelerometerView.setText("nothing to show");
        gyroscopeView = (TextView) layout.findViewById(R.id.gyroscope);
        gyroscopeView.setText("nothing to show");
        magnetometerView = (TextView) layout.findViewById(R.id.magnetometer);
        magnetometerView.setText("nothing to show");
        return layout;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }
        else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            getGyroscope(event);
        }
        else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            getMagnetic(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;

        float x = values[0];
        float y = values[1];
        float z = values[2];
        accelerometerView.setText(" Accelerometer  (m/s2) " + df.format(x) + "    " + df.format(y) + "   " + df.format(z));
    }


    private void getMagnetic(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        magnetometerView.setText(" Gyroscope (rad/s)  " +df.format(x) + "    " + df.format(y) + "   " + df.format(z));
    }


    private void getGyroscope(SensorEvent event) {
        float[] values = event.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];
        gyroscopeView.setText(" Magnetometer (Mu(T)) " + df.format(x) + "  " + df.format(y) + "  " + df.format(z));
    }

}
