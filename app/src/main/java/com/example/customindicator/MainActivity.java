package com.example.customindicator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Data> dar;
    MyAdapter myAdapter;
    LinearLayoutManager linearLayoutManager;
    EditText edit,edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rec);
        edit=findViewById(R.id.edit);
        edit2=findViewById(R.id.edit2);
        dar=new ArrayList<>();
    }

    public void click(View view) {
        myAdapter.srcoll(Integer.parseInt(edit.getText().toString())-1);
    }

    public void click2(View view) {
        int num = Integer.parseInt(edit2.getText().toString());
        for(int i=0;i<num;i++){
            dar.add(new Data(R.drawable.unsel));
        }
        recyclerView.setVisibility(View.VISIBLE);
        myAdapter=new MyAdapter(num,dar);
        linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }
}