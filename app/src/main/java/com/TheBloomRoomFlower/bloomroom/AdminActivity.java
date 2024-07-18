package com.TheBloomRoomFlower.bloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.TheBloomRoomFlower.bloomroom.R;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        ImageButton Addcusflowers = findViewById(R.id.Addcusflowers);
        Addcusflowers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AddfloweradminActivity.class);
                startActivity(intent);
            }
        });
        ImageButton AddCategories = findViewById(R.id.AddCategories);
        AddCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AddcatadminActivity.class);
                startActivity(intent);
            }
        });
        ImageButton viewOder = findViewById(R.id.viewOder);
        viewOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, AdminviewodersActivity.class);
                startActivity(intent);
            }
        });
    }
}