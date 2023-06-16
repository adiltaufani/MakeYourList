package com.example.signuplogintubes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ListingActivity extends AppCompatActivity {

    Button noteButton,shopButton,workButton,addListCatButton;
    ImageButton close;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        noteButton =findViewById(R.id.noteButton);

        noteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListingActivity.this,NoteListingActivity.class);
                startActivity(intent);
            }
        });

        shopButton =findViewById(R.id.shopButton);

        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListingActivity.this,ShopListingActivity.class);
                startActivity(intent);
            }
        });

        workButton =findViewById(R.id.workButton);

        workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListingActivity.this,WorkListingActivity.class);
                startActivity(intent);
            }
        });

        close =findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}