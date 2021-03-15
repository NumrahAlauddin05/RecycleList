package com.example.recyclelist;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class BookViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView name;
    TextView detail;

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);

         image=itemView.findViewById(R.id.bookImage);
         name=itemView.findViewById(R.id.bookName);
         detail=itemView.findViewById(R.id.bookDetail);
    }
}
