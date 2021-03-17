package com.example.recyclelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BookDetail extends AppCompatActivity {

    TextView nameTv;
    TextView detailTv;
    ImageView imageIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        nameTv=findViewById(R.id.detailname);
        detailTv=findViewById(R.id.detailDetail);
        imageIV=findViewById(R.id.detailImage);

        Bundle bundle=getIntent().getExtras();
        String name=bundle.getString("name");
        String detail=bundle.getString("detail");
        int image=bundle.getInt("image");

        nameTv.setText(name);
        detailTv.setText(detail);
        imageIV.setImageResource(image);
    }
}
