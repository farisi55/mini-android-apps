package com.example.banus.quizbanusalman;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class QuizPageFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_page_four);
    }
    //cara pindah halaman
    public void goBack(View v) {
        Intent intent = new Intent(this, QuizPageThree.class);
        finish ();
        this.startActivity(intent);
    }

    public void goNext(View v) {
        Intent intent = new Intent(this, QuizPageFive.class);

        //======================================
        //cara ngambil ke intent lain)
        int jwb  = getIntent().getIntExtra("jawab", 0);

        //cara membuat jawaban benar (cth B)
        RadioButton rb;

        int nilai;
        rb  = (RadioButton) findViewById(R.id.option_b);

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

        //cara ngirim variable ke intent
        intent.putExtra("jawab", jwb);
        ///==========================================
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
                        finish ();
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}
