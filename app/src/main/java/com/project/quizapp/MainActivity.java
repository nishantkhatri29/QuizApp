package com.project.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView list= findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C");
        final Intent intent= new Intent(this,JavaQ.class);
        final Intent intent1= new Intent(this,PythonQ.class);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String clickedItem =(String) list.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,clickedItem,Toast.LENGTH_LONG).show();
                if(clickedItem.equals("Java")){{
                    startActivity(intent);
                }}
                else if(clickedItem.equals("Python")){
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Bug in Code",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
