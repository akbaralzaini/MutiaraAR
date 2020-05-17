package com.akbar.homear;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private RecyclerView rvWisata;
    private ArrayList<Wisata> list = new ArrayList<>();
    private String title = "Visit Indonesia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setActionBarTitle(title);
        getSupportActionBar().setElevation(0);

        rvWisata = findViewById(R.id.rv_wisata);
        rvWisata.setHasFixedSize(true);
        list.addAll(WisataData.getListData());
        showRecyclerList();

        CurvedBottomNavigationView mView = findViewById(R.id.bottom);
        mView.inflateMenu(R.menu.bottom_menu);
        mView.setSelectedItemId(R.id.action_listrumah);
        //getting bottom navigation view and attaching the listener
        mView.setOnNavigationItemSelectedListener(MainActivity.this);

        LinearLayout denah = findViewById(R.id.denah);
        LinearLayout lokasi = findViewById(R.id.lokasi);
        LinearLayout kontak = findViewById(R.id.kontak);
        LinearLayout video = findViewById(R.id.video);
        FloatingActionButton CameraAr = findViewById(R.id.camera_ar);

        denah.setOnClickListener(this);
        lokasi.setOnClickListener(this);
        kontak.setOnClickListener(this);
        video.setOnClickListener(this);
        CameraAr.setOnClickListener(this);

    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showRecyclerList() {

        rvWisata.setLayoutManager(new LinearLayoutManager(this));
        ListWisataAdapter listWisataAdapter = new ListWisataAdapter(list);
        rvWisata.setAdapter(listWisataAdapter);

        listWisataAdapter.setOnItemClickCallback(new ListWisataAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Wisata data) {
                showSelectedWisata(data);
            }
        });
    }

    private void showSelectedWisata(Wisata wisata) {

        Intent moveWithDataIntent = new Intent(MainActivity.this, DetailActivity.class);
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_NAME, wisata.getName());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_LOCATION, wisata.getLocation());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_DETAIL, wisata.getDetail());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_IMAGE, wisata.getPhoto());
        startActivity(moveWithDataIntent);

        //Toast.makeText(this, "Kamu memilih " + wisata.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.profil:
                Intent moveIntent = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(moveIntent);
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_listrumah:
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.denah:
                Intent moveIntent = new Intent(MainActivity.this, DenahActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.lokasi:
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=-2.975687,104.700613(Mutiara+Barangan)");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                break;
            case R.id.kontak :
                Intent KontakIntent = new Intent(MainActivity.this, KontakActivity.class);
                startActivity(KontakIntent);
                break;
            case R.id.video:
                Intent videoIntent = new Intent(MainActivity.this, VideoActivity.class);
                startActivity(videoIntent);
                break;
            case R.id.camera_ar:
                Intent intent = new Intent(this, UnityPlayerActivity.class);
                intent.putExtra("arguments", "data from android");
                startActivity(intent);
                break;

        }
    }
}
