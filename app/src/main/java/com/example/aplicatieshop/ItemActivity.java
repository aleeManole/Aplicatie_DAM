package com.example.aplicatieshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class ItemActivity extends AppCompatActivity {

    ImageView prodImage;
    TextView productName, description;
    Button eAddToCart;
    TextView productPrice;

    String title, details;
    String price;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        prodImage = findViewById(R.id.imageView);
        productName = findViewById(R.id.productNameText);
        description = findViewById(R.id.detailsText);
        eAddToCart= findViewById(R.id.cartBtn);
        productPrice = findViewById(R.id.productPriceText);

        getData();
        setData();

        eAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ItemActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

    }

    public void getData() {
        if (getIntent().hasExtra("image") && getIntent().hasExtra("title") && getIntent().hasExtra("details") && getIntent().hasExtra("price")) {
            title = getIntent().getStringExtra("title");
            details = getIntent().getStringExtra("details");
            image = getIntent().getIntExtra("image", 1);
            price = getIntent().getStringExtra("price");
        } else {
            Toast.makeText(this, "No info", Toast.LENGTH_SHORT).show();
        }
    }

    public void setData() {
        productName.setText(title);
        description.setText(details);
        prodImage.setImageResource(image);
        productPrice.setText(price);
    }


//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
//        View view = menu.findItem(R.id.cartMenu).getActionView();
//        cartIcon= (ImageView)view.findViewById(R.id.cartMenu);
//        cartIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(ItemActivity.this,CartActivity.class));
//            }
//        });
//        return true;
//    }
//
//    public boolean OnOptionItemSelected(MenuItem item) {
//        //handle action bar items
//        int id = item.getItemId();
//
//        if (id == R.id.cartMenu) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}