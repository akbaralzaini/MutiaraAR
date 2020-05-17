package com.akbar.homear;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class KontakActivity extends AppCompatActivity {

//    private EditText namaField;
//    private EditText alamatField;
//    private EditText pertanyaanField;
    //private String chat;
    //private Button btnKirim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        EditText namaField = findViewById(R.id.nama_rv);
        EditText alamatField = findViewById(R.id.alamat_rv);
        EditText pertanyaanField = findViewById(R.id.pertanyaan_rv);
        Button btnKirim = findViewById(R.id.kirim);

//        String nama = namaField.getText().toString();
//        String alamat = alamatField.getText().toString();
//        String pertanyaan = pertanyaanField.getText().toString();

        //String chat = ;


        btnKirim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_VIEW);
                String url = "https://api.whatsapp.com/send?phone=" + "+6281274131888" + "&text=" + "Selamat Siang Marketing muatiara barangan\nSaya " + namaField.getText().toString() + ", dari "+ alamatField.getText().toString() + "\n\n"+"ingin menanyakan : \n"+ pertanyaanField.getText().toString() +"\n\nTerimakasih";
                sendIntent.setData(Uri.parse(url));
                startActivity(sendIntent);
              //  Log.i("haha","Selamat Siang Marketing muatiara barangan\nSaya " + namaField.getText().toString() + ", dari "+ alamatField.getText().toString() + "\n\n"+"ingin menanyakan : \n"+ pertanyaanField.getText().toString() +"\n\nTerimakasih");
            }
        });
    }

}
