package com.example.student.db2017120702;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        ImageRequest request = new ImageRequest(
                "https://uc.udn.com.tw/photo/2017/12/07/realtime/4324210.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        ImageView img = (ImageView) findViewById(R.id.imageView);
                        img.setImageBitmap(response);
                    }
                },
                0,
                0,
                ImageView.ScaleType.FIT_XY,
                Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("NET", "Error:" + error.toString());
                    }
                }
        );
        queue.add(request);
        queue.start();
    }
}
