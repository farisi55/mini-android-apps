package com.example.banus.cookies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eatCookie(View view) {
        ImageView cookieBefore = (ImageView) findViewById(R.id.img_before);
        cookieBefore.setImageResource(R.drawable.after_cookie);
        ///===============================================
        TextView textView = (TextView) findViewById(R.id.text_before);
        textView.setText("Saya Kenyang");
        //textView.setText((CharSequence) findViewById(text_after));
    }

    /*
    public void puasaCookie(View view) {
        ImageView cookieBefore = (ImageView) findViewById(R.id.img_after);
        cookieBefore.setImageResource(R.drawable.before_cookie);
        ///===============================================
        TextView textView = (TextView) findViewById(text_after);
        textView.setText("Makan Kue");
    }
    */
}
