package com.example.banus.quizbanusalman;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HasilTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_test);

        TextView hasil = (TextView)findViewById(R.id.txt_hasil);
        int jwb  = getIntent().getIntExtra("jawab", 0);
        hasil.setText(String.valueOf(jwb));
    }




    public void goHome(View v) {
        Intent intent = new Intent(this, MainActivity.class);
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
