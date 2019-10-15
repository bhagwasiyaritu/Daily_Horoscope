package com.dailyhoroscope;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import static com.dailyhoroscope.MainActivity.rashi;

public class RashiResultActivity extends AppCompatActivity {

    TextView today,sign,result;
    ImageView zordic_img;
    RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rashi_result);

        today = findViewById(R.id.date) ;
        sign = findViewById(R.id.rashiSign);
        result = findViewById(R.id.rashiResult);
        zordic_img = findViewById(R.id.zordicImg);

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        String url = "http://horoscope-api.herokuapp.com/horoscope/today/";
        String rashiKey = rashi;

        switch(rashiKey){

            case "ARIES":
                zordic_img.setImageResource(R.drawable.aries);
                break;

            case "TAURUS":
                zordic_img.setImageResource(R.drawable.taurus);
                break;

            case "GEMINI":
                zordic_img.setImageResource(R.drawable.gemini);
                break;

            case "CANCER":
                zordic_img.setImageResource(R.drawable.cancer);
                break;

            case "LEO":
                zordic_img.setImageResource(R.drawable.leo);
                break;

            case "VIRGO   ":
                zordic_img.setImageResource(R.drawable.virgo);
                break;

            case "LIBRA":
                zordic_img.setImageResource(R.drawable.libra);
                break;

            case "SCORPIO":
                zordic_img.setImageResource(R.drawable.scorpio);
                break;

            case "SAGITTARIUS":
                zordic_img.setImageResource(R.drawable.sagittarius);
                break;

            case "CAPRICORN":
                zordic_img.setImageResource(R.drawable.capricorn);
                break;

            case "PISCES":
                zordic_img.setImageResource(R.drawable.pisces);
                break;

                default:
                    break;
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url + rashiKey, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    today.setText(response.getString("date"));
                    sign.setText(response.getString("sunsign"));
                    result.setText(response.getString("horoscope"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mRequestQueue.add(request);
    }
}
