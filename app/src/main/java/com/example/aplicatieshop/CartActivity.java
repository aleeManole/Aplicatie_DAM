package com.example.aplicatieshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.os.Bundle;

public class CartActivity extends AppCompatActivity {

    RecyclerView recycleCart;
    Button placeOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

//        recycleCart = (RecyclerView)findViewById(R.id.recycleCart);
//        recycleCart.setLayoutManager(new LinearLayoutManager(this));
//        recycleCart.setHasFixedSize(true);
//        placeOrder = (Button)findViewById(R.id.btnPlaceOrder);
    }
}