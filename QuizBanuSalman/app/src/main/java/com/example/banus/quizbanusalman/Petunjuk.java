package com.example.banus.quizbanusalman;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by banus on 5/23/2017.
 */

public class Petunjuk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petunjuk);
    }

    public void goQuizPertama(View v) {
        Intent intent = new Intent(this, QuizPertama.class);
        finish ();
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
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }



}
