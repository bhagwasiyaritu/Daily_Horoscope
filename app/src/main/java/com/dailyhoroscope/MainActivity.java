package com.dailyhoroscope;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText getRashi;
    public static String rashi;
    String []rashis = {"ARIES","TAURUS","GEMINI","CANCER","LEO","VIRGO","LIBRA","SCORPIO","SAGITTARIUS","CAPRICORN","PISCES"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRashi = findViewById(R.id.enterRashi);
    }

    public void get_horoscope(View view) {
        rashi = getRashi.getText().toString().toUpperCase();

        String isCorrect = isValid(rashi);
        if(isCorrect!=null) {
            Toast.makeText(this,isCorrect,Toast.LENGTH_LONG).show();//sun bolo g
        }
        else {
            Intent i = new Intent(MainActivity.this, RashiResultActivity.class);
            startActivity(i);
        }
    }

    public String isValid(String rashi){
        if(rashi == null || rashi.length() == 0)
            return "Something Goes Wrong";
        boolean found = false;
        for(String r:rashis)
            if(rashi.equalsIgnoreCase(r))
            {
                found = true;
                break;
            }
        if(!found)
            return "Please Enter Correct Sunsign";

        return null;
    }
}
