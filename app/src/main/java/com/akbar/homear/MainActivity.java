package com.akbar.homear;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private RecyclerView rvWisata;
    private ArrayList<Wisata> list = new ArrayList<>();
    private String title = "Visit Indonesia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvWisata = findViewById(R.id.rv_wisata);
        rvWisata.setHasFixedSize(true);
        list.addAll(WisataData.getListData());
        showRecyclerList();

        CurvedBottomNavigationView mView = findViewById(R.id.bottom);
        mView.inflateMenu(R.menu.bottom_menu);
        mView.setSelectedItemId(R.id.action_listrumah);
        //getting bottom navigation view and attaching the listener
        mView.setOnNavigationItemSelectedListener(MainActivity.this);


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
                break;
        }
        return true;
    }
}
