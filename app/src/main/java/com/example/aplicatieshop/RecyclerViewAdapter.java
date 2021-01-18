package com.example.aplicatieshop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    String products[], details[];
    String prices[];
    int images[];
    Context context;


    public RecyclerViewAdapter(Context context, String[] products, String[] details, int[] images, String[] prices) {
        this.context = context;
        this.products = products;
        this.details = details;
        this.images = images;
        this.prices = prices;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_products, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.titleText.setText((products[position]));
        holder.descriptionText.setText((details[position]));
        holder.elementImage.setImageResource((images[position]));
        holder.priceText.setText((prices[position]));
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ItemActivity.class);
                intent.putExtra("title", products[position]);
                intent.putExtra("details", details[position]);
                intent.putExtra("image", images[position]);
                intent.putExtra("price", prices[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.length;
    }

//    public Filter getFilter() {
//        return filterfunction;
//    }
//
//    private Filter filterfunction = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            String key = constraint.toString();
//            if (key.isEmpty()) {
//                filteredDataList = productDataList;
//            } else {
//                List<ProductData> listFiltered = new ArrayList<>();
//                for (ProductData prod : productDataList) {
//                    if (prod.getProducts().equals(key.toLowerCase())) {
//                        listFiltered.add(prod);
//                    }
//                }
//                filteredDataList = listFiltered;
//            }
//            FilterResults filterResults = new FilterResults();
//            filterResults.values = filteredDataList;
//            return filterResults;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
//            filteredDataList = (List<ProductData>) filterResults.values;
//            notifyDataSetChanged();
//        }
//    };

public static class MyViewHolder extends RecyclerView.ViewHolder {

    TextView titleText, descriptionText;
    TextView  priceText;
    ImageView elementImage;
    ConstraintLayout itemLayout;

    public MyViewHolder(View itemView) {
        super(itemView);
        titleText = itemView.findViewById(R.id.titleText);
        descriptionText = itemView.findViewById(R.id.descriptionText);
        elementImage = itemView.findViewById(R.id.elementImage);
        priceText = itemView.findViewById(R.id.priceText);
        itemLayout = itemView.findViewById(R.id.itemLayout);
    }
}
}
