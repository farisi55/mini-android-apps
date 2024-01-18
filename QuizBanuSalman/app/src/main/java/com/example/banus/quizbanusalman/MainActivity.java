package com.example.banus.quizbanusalman;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void goQuizPertama(View v) {
        Intent intent = new Intent(this, QuizPertama.class);
        finish(); //clear history when pindah activity
        this.startActivity(intent);
    }

    public void goPetunjuk(View v) {
        Intent intent = new Intent(this, Petunjuk.class);
        finish(); //clear history when pindah activity
        this.startActivity(intent);
    }


    ///Cara buat tombol alert exut
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apa anda ingin Keluar?")
                .setCancelable(false)
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        //System.exit(0);
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }

    /*
   public boolean onCreateOptionsMenu(Menu menu) {
     // Inflate the menu; this adds items to the action bar if it is present. getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    */
    /////======
}
