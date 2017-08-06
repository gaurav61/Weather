package com.example.android.weather;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView mi[],ma[],dates[],desc;
    private ImageView im[];
    private String pressure[],humidity[],wind[];
    private String weather_icon[],description[];
    public int checker;
    Toolbar mytoolbar;
    Spinner myspinner;
    String city="Delhi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checker=0;
        pressure=new String[5];
        humidity=new String[5];
        wind=new String[5];
        weather_icon=new String[5];
        description=new String[5];
        mi=new TextView[5];
        ma=new TextView[5];
        dates=new TextView[5];
        im=new ImageView[5];
        ma[0]=(TextView)findViewById(R.id.day1_max);
        ma[1]=(TextView)findViewById(R.id.day2_max);
        ma[2]=(TextView)findViewById(R.id.day3_max);
        ma[3]=(TextView)findViewById(R.id.day4_max);
        ma[4]=(TextView)findViewById(R.id.day5_max);
        mi[0]=(TextView)findViewById(R.id.day1_min);
        mi[1]=(TextView)findViewById(R.id.day2_min);
        mi[2]=(TextView)findViewById(R.id.day3_min);
        mi[3]=(TextView)findViewById(R.id.day4_min);
        mi[4]=(TextView)findViewById(R.id.day5_min);
        desc=(TextView)findViewById(R.id.day1_desc);
        dates[0]=(TextView)findViewById(R.id.day1_date);
        dates[1]=(TextView)findViewById(R.id.day2_date);
        dates[2]=(TextView)findViewById(R.id.day3_date);
        dates[3]=(TextView)findViewById(R.id.day4_date);
        dates[4]=(TextView)findViewById(R.id.day5_date);
        im[0]=(ImageView)findViewById(R.id.day1_image);
        im[1]=(ImageView)findViewById(R.id.day2_image);
        im[2]=(ImageView) findViewById(R.id.day3_image);
        im[3]=(ImageView)findViewById(R.id.day4_image);
        im[4]=(ImageView)findViewById(R.id.day5_image);
        mytoolbar=(Toolbar)findViewById(R.id.toolbar);
        myspinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String>myadapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.location));
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myadapter);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView t=(TextView)view;
                city=t.getText().toString();
                new JSONTask().execute("http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&cnt=5&&APPID=YOUR_KEY_HERE");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


      



        RelativeLayout rl = (RelativeLayout)findViewById(R.id.day1);
        rl.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(checker==1) {
                    Intent i = new Intent(MainActivity.this, Details.class);
                    i.putExtra("date", dates[0].getText().toString());
                    i.putExtra("max", ma[0].getText().toString());
                    i.putExtra("min", mi[0].getText().toString());
                    i.putExtra("icon", weather_icon[0]);
                    i.putExtra("desc", description[0]);
                    i.putExtra("humidity", humidity[0]);
                    i.putExtra("pressure", pressure[0]);
                    i.putExtra("wind", wind[0]);
                    i.putExtra("icon", weather_icon[0]);
                    startActivity(i);
                }
            }
        });

        RelativeLayout r2 = (RelativeLayout)findViewById(R.id.day2);
        r2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(checker==1) {
                    Intent i = new Intent(MainActivity.this, Details.class);
                    i.putExtra("date", dates[1].getText().toString());
                    i.putExtra("max", ma[1].getText().toString());
                    i.putExtra("min", mi[1].getText().toString());
                    i.putExtra("icon", weather_icon[1]);
                    i.putExtra("desc", description[1]);
                    i.putExtra("humidity", humidity[1]);
                    i.putExtra("pressure", pressure[1]);
                    i.putExtra("wind", wind[1]);
                    i.putExtra("icon", weather_icon[1]);
                    startActivity(i);
                }
            }
        });

        RelativeLayout r3 = (RelativeLayout)findViewById(R.id.day3);
        r3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(checker==1) {
                    Intent i = new Intent(MainActivity.this, Details.class);
                    i.putExtra("date", dates[2].getText().toString());
                    i.putExtra("max", ma[2].getText().toString());
                    i.putExtra("min", mi[2].getText().toString());
                    i.putExtra("icon", weather_icon[2]);
                    i.putExtra("humidity", humidity[2]);
                    i.putExtra("pressure", pressure[2]);
                    i.putExtra("wind", wind[2]);
                    i.putExtra("icon", weather_icon[2]);
                    startActivity(i);
                }
            }
        });

        RelativeLayout r4 = (RelativeLayout)findViewById(R.id.day4);
        r4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(checker==1) {
                    Intent i = new Intent(MainActivity.this, Details.class);
                    i.putExtra("date", dates[3].getText().toString());
                    i.putExtra("max", ma[3].getText().toString());
                    i.putExtra("min", mi[3].getText().toString());
                    i.putExtra("icon", weather_icon[3]);
                    i.putExtra("humidity", humidity[3]);
                    i.putExtra("pressure", pressure[3]);
                    i.putExtra("wind", wind[3]);
                    i.putExtra("icon", weather_icon[3]);
                    startActivity(i);
                }
            }
        });

        RelativeLayout r5 = (RelativeLayout)findViewById(R.id.day5);
        r5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(checker==1) {
                    Intent i = new Intent(MainActivity.this, Details.class);
                    i.putExtra("date", dates[4].getText().toString());
                    i.putExtra("max", ma[4].getText().toString());
                    i.putExtra("min", mi[4].getText().toString());
                    i.putExtra("icon", weather_icon[4]);
                    i.putExtra("humidity", humidity[4]);
                    i.putExtra("pressure", pressure[4]);
                    i.putExtra("wind", wind[4]);
                    i.putExtra("icon", weather_icon[4]);
                    startActivity(i);
                }
            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        new JSONTask().execute("http://api.openweathermap.org/data/2.5/forecast/daily?q"+city+"&cnt=5&&APPID=YOUR_KEY_HERE");

    }
    public class JSONTask extends AsyncTask<String,String,String>{
        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection=null;
            BufferedReader reader=null;
            try{
                URL url=new URL(params[0]);
                connection=(HttpURLConnection)url.openConnection();
                connection.connect();
                InputStream stream=connection.getInputStream();
                reader=new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer=new StringBuffer();
                String line="";
                while((line=reader.readLine())!=null){
                    buffer.append(line);
                }
                return buffer.toString();
            }
            catch (Exception e){

            }
            finally {
                if(connection!=null){
                    connection.disconnect();
                }
                try{
                    if(reader!=null){
                        reader.close();
                    }
                }
                catch (Exception e){

                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                JSONObject jobject=new JSONObject(s);
                JSONArray jarray=jobject.getJSONArray("list");
                JSONObject dup1=jarray.getJSONObject(0);
                JSONArray dup2=dup1.getJSONArray("weather");
                JSONObject dup3=dup2.getJSONObject(0);
                desc.setText(dup3.getString("main"));
                for(int i=0;i<jarray.length();i++){
                    try{
                        JSONObject j=jarray.getJSONObject(i);
                        pressure[i]=(int)j.getDouble("pressure")+"";
                        humidity[i]=j.getInt("humidity")+"";
                        wind[i]=(int)(j.getDouble("speed")*3.6)+"";
                        long time=j.getLong("dt");
                        JSONObject j2=j.getJSONObject("temp");
                        int temp_max=(int)(j2.getDouble("max")-273.15);
                        int temp_min=(int)(j2.getDouble("min")-273.15);

                        JSONArray j3=j.getJSONArray("weather");
                        JSONObject j4=j3.getJSONObject(0);
                        String icon=j4.getString("icon");
                        weather_icon[i]=j4.getString("icon");
                        time=time*1000;
                        Date d=new Date(time);
                        String tarik=d.toString();
                        String finaldate=tarik.substring(0,10);
                        ma[i].setText(temp_max +" "+ (char) 0x00B0+"C");
                        mi[i].setText(temp_min +" "+ (char) 0x00B0+"C");
                        dates[i].setText(finaldate);
                        if(icon.equals("01d")||icon.equals("01n")){
                            im[i].setImageResource(R.drawable.d01);
                        }
                        else if(icon.equals("02d")||icon.equals("02n")){
                            im[i].setImageResource(R.drawable.d02);
                        }
                        else if(icon.equals("03d")||icon.equals("03n")||icon.equals("04d")||icon.equals("04n")){
                            im[i].setImageResource(R.drawable.d03_4);
                        }
                        else if(icon.equals("09d")||icon.equals("09n")||icon.equals("10d")||icon.equals("10n")){
                            im[i].setImageResource(R.drawable.d09_10);
                        }
                        else if(icon.equals("11d")||icon.equals("11n")){
                            im[i].setImageResource(R.drawable.d11);
                        }
                        else if(icon.equals("13d")||icon.equals("13n")){
                            im[i].setImageResource(R.drawable.d13);
                        }
                        else if(icon.equals("50d")||icon.equals("50n")){
                            im[i].setImageResource(R.drawable.d01);
                        }
                        else{
                            im[i].setImageResource(R.drawable.d01);
                        }
                        checker=1;
                    }
                    catch (Exception e){

                    }
                }
            }
            catch (Exception e){

            }
        }
    }
}
