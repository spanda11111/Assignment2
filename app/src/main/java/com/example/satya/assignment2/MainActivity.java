package com.example.satya.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    //declare all variable
    EditText et1,et2,et3;
    Button bt1;
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String>aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize all variable
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        lv = (ListView) findViewById(R.id.lv);
        bt1 = (Button) findViewById(R.id.bt1);
        // initialise all invisible element
        al = new ArrayList<String>();
        //aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al);
        aa = new ArrayAdapter<String>(this,R.layout.row,al);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                       @Override
                                       public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                           //3rd parameter is important position of the element
                                           //al.get(i) is getting the data of thet postion
                                           //at the place of al.get(i) if we give only i then it will show only the postion
                                           Toast.makeText(MainActivity.this, "Position.."+al.get(i), Toast.LENGTH_SHORT).show();
                                       }
                                   }
        );
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= et1.getText().toString();
                String salary= et2.getText().toString();
                String design= et3.getText().toString();
                //add all leements into one array
                al.add(name+"\n"+salary+"\n"+design);
                Collections.sort(al);
                //tell to adpter
                aa.notifyDataSetChanged();
                //clean editText boxes
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et1.requestFocus();
            }
        });

    }
}
