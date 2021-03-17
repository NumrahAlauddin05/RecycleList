package com.example.recyclelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Book> books;
    BookAdapter adapter;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

       reference.addChildEventListener(new ChildEventListener() {
           @Override
           public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
               Book book=snapshot.getValue(Book.class);
               books.add(book);
               adapter.notifyDataSetChanged();
           }

           @Override
           public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

           }

           @Override
           public void onChildRemoved(@NonNull DataSnapshot snapshot) {

           }

           @Override
           public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });

        books.add(new Book("Programming Books", "Detail 1", R.drawable.book1));
        books.add(new Book("Programming Books", "Detail 2", R.drawable.book2));
        books.add(new Book("Programming Books", "Detail 3", R.drawable.book3));
        books.add(new Book("Programming Books", "Detail 4", R.drawable.book4));

//        LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
//        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        adapter = new BookAdapter(MainActivity.this, books);
        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        recyclerView = findViewById(R.id.bookRecycleList);
        books = new ArrayList<>();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("Book");

    }

    public void addBookAct(View view) {
        Intent addBookIntent = new Intent(MainActivity.this, AddBook.class);
        startActivity(addBookIntent);
    }
}
