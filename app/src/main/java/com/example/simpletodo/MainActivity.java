package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapters = new ArrayList<String>();
        lvItems = findViewById(R.id.screen);
        itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1
        , adapters);
        lvItems.setAdapter(itemsAdapter);
        deleteItem();
    }
    private ArrayList <String> adapters;
    private ListView lvItems;
    private ArrayAdapter<String> itemsAdapter;
    public void deleteItem(){
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                adapters.remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }

        });

    }
    public void addItem(View v){
        EditText e = findViewById(R.id.text);
        itemsAdapter.add(e.getText().toString());
        e.setText("");

    }
}
