package com.akbar.homear;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InformasiActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi);

        CurvedBottomNavigationView mView = findViewById(R.id.bottominfo);
        mView.inflateMenu(R.menu.bottom_menu);
        mView.setSelectedItemId(R.id.action_informasi);
        //getting bottom navigation view and attaching the listener
        mView.setOnNavigationItemSelectedListener(InformasiActivity.this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_listrumah:
                Intent intentmain = new Intent(this,MainActivity.class);
                startActivity(intentmain);
                break;
            case R.id.action_arcamera:
                Intent intent = new Intent(this, UnityPlayerActivity.class);
                intent.putExtra("arguments", "data from android");
                startActivity(intent);
                break;
            case R.id.action_informasi:
                Intent intentinfo = new Intent(this,InformasiActivity.class);
                startActivity(intentinfo);
                break;
        }
        return true;
    }


}
