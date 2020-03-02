package com.akbar.homear;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_LOCATION = "extra_location";
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_IMAGE = "1";
    private String title = "Detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setElevation(0);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setActionBarTitle(title);

        ImageView tvImageWisata = findViewById(R.id.foto);
        TextView tvNamaWisata = findViewById(R.id.tv_item_name);
        TextView tvLokasiWisata = findViewById(R.id.tv_item_location);
        TextView tvDetailWisata = findViewById(R.id.detail);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        String location = getIntent().getStringExtra(EXTRA_LOCATION);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL);
        int image = getIntent().getIntExtra(EXTRA_IMAGE,1);

        tvNamaWisata.setText(name);
        tvLokasiWisata.setText(location);
        tvDetailWisata.setText(detail);
        tvImageWisata.setImageResource(image);


    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
