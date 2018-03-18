package com.example.hananurfauziah.hananurfauziah_1202150250_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button nama_mahasiswa;
    private Button cari_gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("AsyncTask");
    }

    public void nama_mahasiswa(View view) { // untuk berpindah ke halaman List Nama Mahasiswa
        Intent nama = new Intent(MainActivity.this, ListNama.class);
        startActivity(nama);
    }

    public void cari_gambar(View view) { // untuk berpindah ke halaman Cari Gambar
        Intent gambar = new Intent(MainActivity.this, CariGambar.class);
        startActivity(gambar);
    }
}
