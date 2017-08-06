package com.example.android.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    private TextView date,min,max,desc,humidity,pressure,wind;
    private ImageView im;
    private String a,b,c,icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        a=" %";
        b=" mb";
        c=" Km/h";
        date=(TextView)findViewById(R.id.detail_date);
        max=(TextView)findViewById(R.id.detail_max);
        min=(TextView)findViewById(R.id.detail_min);
        desc=(TextView)findViewById(R.id.detail_desc);
        humidity=(TextView)findViewById(R.id.detail_humidity);
        pressure=(TextView)findViewById(R.id.detail_pressure);
        wind=(TextView)findViewById(R.id.detail_wind);
        im=(ImageView)findViewById(R.id.detail_image);
        Intent i=getIntent();
        date.setText(i.getStringExtra("date"));
        max.setText(i.getStringExtra("max"));
        min.setText(i.getStringExtra("min"));
        humidity.setText(i.getStringExtra("humidity")+a);
        pressure.setText(i.getStringExtra("pressure")+b);
        wind.setText(i.getStringExtra("wind")+c);
        icon=i.getStringExtra("icon");
        if(icon.equals("01d")||icon.equals("01n")){
            im.setImageResource(R.drawable.d01);
            desc.setText("Clear");
        }
        else if(icon.equals("02d")||icon.equals("02n")){
            im.setImageResource(R.drawable.d02);
            desc.setText("Few Clouds");
        }
        else if(icon.equals("03d")||icon.equals("03n")||icon.equals("04d")||icon.equals("04n")){
            im.setImageResource(R.drawable.d03_4);
            desc.setText("Heavy Clouds");
        }
        else if(icon.equals("09d")||icon.equals("09n")||icon.equals("10d")||icon.equals("10n")){
            im.setImageResource(R.drawable.d09_10);
            desc.setText("Rain");
        }
        else if(icon.equals("11d")||icon.equals("11n")){
            im.setImageResource(R.drawable.d11);
            desc.setText("Thunderstorm");
        }
        else if(icon.equals("13d")||icon.equals("13n")){
            im.setImageResource(R.drawable.d13);
            desc.setText("Snow");
        }
        else if(icon.equals("50d")||icon.equals("50n")){
            im.setImageResource(R.drawable.d01);
            desc.setText("Haze");
        }
        else{
            im.setImageResource(R.drawable.d01);
        }

    }
}
