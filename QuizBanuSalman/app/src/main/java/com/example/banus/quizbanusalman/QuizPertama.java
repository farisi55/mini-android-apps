package com.example.banus.quizbanusalman;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by banus on 5/22/2017.
 */


public class QuizPertama extends AppCompatActivity {

    public int jwb = 0;
    public int nilai = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_pertama);

        /* kalau mau pakai format html
        TextView tv = (TextView) findViewById(R.id.tv_id1);
        tv.setText(Html.fromHtml("Managing Safely <b> End Of Course Theory Test </b> <font color='red'>simple</font>"));
        */
    }

    //cara pindah halaman
    public void goPetunjuk(View v) {
        Intent intent = new Intent(this, Petunjuk.class);
        this.startActivity(intent);
    }

    public void goNext(View v) {
        //var activity2 = new Intent (this, typeof(Activity2));
        RadioButton rb;

        rb  = (RadioButton) findViewById(R.id.option_a);

        if (rb.isChecked()) {
            nilai = 20;
            //Toast.makeText(QuizPertama.this, "jawaban kamu benar",
             //       Toast.LENGTH_SHORT).show();
        }
        else {
            nilai = 0 ;
            //Toast.makeText(QuizPertama.this, "jawaban kamu salah",
             //       Toast.LENGTH_SHORT).show();
        }
        jwb = jwb + nilai;
        Intent intent = new Intent(this, QuizPageTwo.class);
        intent.putExtra("jawab", jwb);
        finish ();
        this.startActivity(intent);
    }

    /*
    public void goCheck(View view) {
        RadioButton rb;

        rb  = (RadioButton) findViewById(R.id.option_a);

        if (rb.isChecked()) {
            jwb = jwb + 2 ;
            Toast.makeText(QuizPertama.this, "jawaban kamu benar",
            Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(QuizPertama.this, "jawaban kamu salah",
                    Toast.LENGTH_SHORT).show();
        }
    }
    */

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
