package com.example.uran;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;


public class Geodesia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geodesia);
    }

    public void geodataclicked(View view) {

        TextView textresult=(TextView)findViewById(R.id.textresult);
        TextView az1=(TextView)findViewById(R.id.az1);
        TextView az2=(TextView)findViewById(R.id.az2);

        EditText edt = (EditText)findViewById(R.id.editTextTextPersonName2);
        String edtext = edt.getText().toString();      //get a text from EditText
        EditText edt1 = (EditText)findViewById(R.id.editTextTextPersonName3);
        String edtext1 = edt1.getText().toString();      //get a text from EditText
        EditText edt2 = (EditText)findViewById(R.id.editTextTextPersonName4);
        String edtext2 = edt2.getText().toString();      //get a text from EditText
        EditText edt3 = (EditText)findViewById(R.id.editTextTextPersonName5);
        String edtext3 = edt3.getText().toString();      //get a text from EditText

        if(isNumeric(edtext) & isNumeric(edtext1) & isNumeric(edtext2) & isNumeric(edtext3) ){         //check for a number
          double  lat1=Double.parseDouble(edtext);
          double  lon1=Double.parseDouble(edtext1);
          double  lat2=Double.parseDouble(edtext2);
          double  lon2=Double.parseDouble(edtext3);

            GeodesicData task=Geodesic.WGS84.Inverse(lat1,lon1,lat2,lon2);

            textresult.setText(String.valueOf( task.s12+ "\t(метров)"));
            az1.setText(String.valueOf("Азимут 1: " +task.azi1+ "\tградусов"));
            az2.setText(String.valueOf("Азимут 2: " +task.azi2+ "\tградусов"));

        } else {
            textresult.setText("Ошибка при вводе данных");
            edt.getText().clear();
            edt1.getText().clear();
            edt2.getText().clear();
            edt3.getText().clear();

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

    public void radiobuttonclicked(View view) {

        switch(view.getId()) {
            case R.id.radioButton:
                Intent intent = new Intent(this, Geodesiastraight.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}