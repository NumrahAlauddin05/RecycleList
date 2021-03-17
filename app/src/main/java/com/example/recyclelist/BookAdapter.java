package com.example.recyclelist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    Context context;
    ArrayList<Book> books;

    public BookAdapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false);
        BookViewHolder bookViewHolder = new BookViewHolder(view);
        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, final int position) {

        holder.image.setImageResource(books.get(position).getImage());
        holder.name.setText(books.get(position).getName());
        holder.detail.setText(books.get(position).getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent=new Intent(context,BookDetail.class);
                detailIntent.putExtra("name",books.get(position).getName());
                detailIntent.putExtra("detail",books.get(position).getDetail());
                detailIntent.putExtra("image",books.get(position).getImage());
                context.startActivity(detailIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
