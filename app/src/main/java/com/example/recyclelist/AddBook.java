package com.example.recyclelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddBook extends AppCompatActivity {

    EditText nameEt;
    EditText detailEt;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        init();


    }

    private void init() {

        nameEt=findViewById(R.id.addBookName);
        detailEt=findViewById(R.id.addBookDetail);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("Book");
    }


    public void addBookBtn(View view) {
        String name=nameEt.getText().toString();
        String detail=detailEt.getText().toString();

        Book book=new Book(name,detail,R.drawable.book1);
        String key=reference.push().getKey();
        reference.child(key).setValue(book).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Intent listIntent = new Intent(AddBook.this, MainActivity.class);
                    startActivity(listIntent);
                }
            }
        });

    }
}
