package com.example.hananurfauziah.hananurfauziah_1202150250_studycase4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;


public class CariGambar extends AppCompatActivity {

    ImageView gambar;
    EditText referensi;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_gambar);
        setTitle("AsyncTask");

        gambar = (ImageView) findViewById(R.id.imageView); // untuk memanggil variabel yang ada di layout
        referensi = (EditText) findViewById(R.id.editText); // untuk memanggil variabel yang ada di layout
    }

    public void cariGambar(View view) { // untuk loading gambar dari internet
        Picasso.with(CariGambar.this).load(referensi.getText().toString())
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(gambar);
    }
}