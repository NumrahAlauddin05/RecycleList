package com.example.recyclelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Book> books;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.bookRecycleList);

        books=new ArrayList<>();
        books.add(new Book("Programming Books","Detail 1",R.drawable.book1));
        books.add(new Book("Programming Books","Detail 2",R.drawable.book2));
        books.add(new Book("Programming Books","Detail 3",R.drawable.book3));
        books.add(new Book("Programming Books","Detail 4",R.drawable.book4));
        adapter=new BookAdapter(MainActivity.this,books);
        LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);

//        GridLayoutManager layoutManager=new GridLayoutManager(MainActivity.this,2);
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
