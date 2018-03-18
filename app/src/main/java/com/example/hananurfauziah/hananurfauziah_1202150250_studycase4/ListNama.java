package com.example.hananurfauziah.hananurfauziah_1202150250_studycase4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class ListNama extends AppCompatActivity {

    ListView listMahasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nama);
        setTitle("AsyncTask");

        listMahasiswa = (ListView) findViewById(R.id.listView); // memanggil atribit yang ada pada layout
    }

    public void mulai(View view) {
        new getData(listMahasiswa).execute();
    } // memulai proses asynctask

    class getData extends AsyncTask<String, Integer, String> { // merupakan subclass dari asynctask
        ListView listMahasiswa;
        ArrayAdapter adapter;
        ArrayList<String> listNama;
        ProgressDialog dialog;

        public getData(ListView listMahasiswa) { // constructor saat asynctask diinisiasi
            this.listMahasiswa = listMahasiswa;
            dialog = new ProgressDialog(ListNama.this);
            listNama = new ArrayList<>();
        }

        @Override
        protected void onPreExecute() { // merupakan method ketika proses asynctask belum dimulai
            super.onPreExecute();
            dialog.setTitle("LOADING DATA"); // untuk menanpilkan proses dialog
            dialog.setIndeterminate(true);
            dialog.setProgress(0);
            dialog.setMax(100);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "CANCEL PROCESS", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                    getData.this.cancel(true);
                }
            });
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) { // merupakan method ketika proses asynctask dijalankan
            adapter = new ArrayAdapter<>(ListNama.this, android.R.layout.simple_list_item_1, listNama); // untuk membuat adapter

            String[] mahasiswa = getResources().getStringArray(R.array.NamaMahasiswa); // untuk menyimpan array pada sebuah variabel
            for (int a = 0; a < mahasiswa.length; a++) { // merupakan perulangan unruk menyimpan array
                final long persen = 100L * a / mahasiswa.length;
                final String nama = mahasiswa[a];
                try {
                    Runnable change = new Runnable() {
                        @Override
                        public void run() {
                            dialog.setMessage((int) persen + "% - Adding" + nama);
                        }
                    };
                    runOnUiThread(change);
                    Thread.sleep(300);
                    listNama.add(mahasiswa[a]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String b) { // merupakan method ketika proses asynctask sudah dijalankan
            super.onPostExecute(b);
            listMahasiswa.setAdapter(adapter);
            dialog.dismiss();

        }
    }
}