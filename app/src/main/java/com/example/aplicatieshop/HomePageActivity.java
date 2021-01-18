package com.example.aplicatieshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter recycleViewAdapter;
    RecyclerView.LayoutManager layoutManager;
//    EditText searchView;
//    CharSequence search="";
    //List<ProductData> productDataList;

    String products[], details[];
    String prices[];
    int images[] = {R.drawable.cana, R.drawable.ceas, R.drawable.ceas2, R.drawable.lumanari, R.drawable.oglinda, R.drawable.scaun, R.drawable.taburete, R.drawable.vaza, R.drawable.vaza2, R.drawable.vaza3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        products = getResources().getStringArray(R.array.products);
        details = getResources().getStringArray(R.array.details);
        prices = getResources().getStringArray(R.array.prices);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recycleViewAdapter = new RecyclerViewAdapter(this, products, details, images,prices);
        recyclerView.setAdapter(recycleViewAdapter);

      //searchView= findViewById(R.id.searchV);
//        searchView.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                recycleViewAdapter= new RecycleViewAdapter(productDataList);
//                recyclerView.setAdapter(recycleViewAdapter);
//                recycleViewAdapter.getFilter().filter(s);
//                search=s;
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });


    }
}