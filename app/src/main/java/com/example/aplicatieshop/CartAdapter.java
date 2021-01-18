//package com.example.aplicatieshop;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
//
//    Context context;
//    List<Products> itemsList;
//    String products[], details[];
//    int images[];
//
//    @NonNull
//    @Override
//    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//       View itemView= LayoutInflater.from(context).inflate(R.layout.cart_item_layout,parent,false);
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
//        holder.itemNameText.setText((products[position]));
//        holder.itemDetailsText.setText((details[position]));
//        holder.imageItem.setImageResource((images[position]));
//    }
//
//    @Override
//    public int getItemCount() {
//        return itemsList.size();
//    }
//
//    class CartViewHolder extends RecyclerView.ViewHolder {
//
//        ImageView imageItem;
//        TextView itemNameText,itemDetailsText;
//        public CartViewHolder(View itemview){
//            super(itemview);
//
//            imageItem=(ImageView)itemview.findViewById(R.id.imageItem);
//            itemNameText=(TextView)itemview.findViewById(R.id.itemNameText);
//            itemDetailsText=(TextView)itemview.findViewById(R.id.itemDetailsText);
//        }
//    }
//}
