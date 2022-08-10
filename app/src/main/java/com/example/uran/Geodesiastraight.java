package com.example.uran;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;

public class Geodesiastraight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geodesiastraight);
    }

    public void radiobuttonclicked2(View view) {
        switch (view.getId()) {
            case R.id.radioButton4:
                Intent intent = new Intent(this, Geodesia.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void buttonstraighttask(View view) {

        TextView londot = (TextView) findViewById(R.id.londot); //initialize textviews in code to assign a result data
        TextView latdot = (TextView) findViewById(R.id.latdot);

        EditText lon1 = (EditText) findViewById(R.id.editTextNumberDecimal); //initialize EditTexts to get data
        EditText lat1 = (EditText) findViewById(R.id.editTextNumberDecimal2);
        EditText distance = (EditText) findViewById(R.id.editTextNumberDecimal3);
        EditText azimyth = (EditText) findViewById(R.id.editTextNumberDecimal4);

        String lon = lon1.getText().toString(); //Convert data to string
        String lat = lat1.getText().toString();
        String dist = distance.getText().toString();
        String az = azimyth.getText().toString();

        if (isNumeric(lon) & isNumeric(lat) & isNumeric(dist) & isNumeric(az)) {
            double  lont=Double.parseDouble(lon);
            double  latt=Double.parseDouble(lat);
            double  azi12=Double.parseDouble(dist);
            double  s12=Double.parseDouble(az);

            GeodesicData task= Geodesic.WGS84.Direct(lont,latt,azi12,s12);
            londot.setText(String.valueOf("Долгота:\t"+task.lon2));
            latdot.setText(String.valueOf("Широта:\t"+task.lat2));

        } else {
            londot.setText("Ошибка при вводе данных");
            lon1.getText().clear();
            lat1.getText().clear();
            distance.getText().clear();
            azimyth.getText().clear();

        }

    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}