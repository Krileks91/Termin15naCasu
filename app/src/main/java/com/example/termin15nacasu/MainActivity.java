package com.example.termin15nacasu;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.GestureDescription;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        data = getNames();

       /* final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data);*/
        //Pozivamo da nam prikaze Elemente od 1-16
        final SongAdapter adapter = new SongAdapter(getSongs(), this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Kliknuli ste na pesmu " + adapter.getItem(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private List<String> getNames(){
        List<String> names = new ArrayList<>();
        for(int i = 1; i < 16; i++){
            names.add("Element "+ i);
        }
        return names;
    }
    private List<Song> getSongs(){
        List<Song> songs = new ArrayList<>();
        for(int i = 1; i < 16; i++){
            songs.add(new Song("Author " + i, "Names" + i));
        }
        return songs;
    }

}