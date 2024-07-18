package com.TheBloomRoomFlower.bloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import com.TheBloomRoomFlower.bloomroom.R;

public class CmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm);

        ImageButton orderCategories = findViewById(R.id.OderCatogories);
        orderCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CmActivity.this, CmcusoderActivity.class);
                startActivity(intent);
            }
        });

        ImageButton makeCusOrder = findViewById(R.id.MakeCusOder);
        makeCusOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CmActivity.this, CmcatoderActivity.class);
                startActivity(intent);
            }
        });

        ImageButton viewOrder = findViewById(R.id.ViewOder);
        viewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CmActivity.this, CmviewoderActivity.class);
                startActivity(intent);
            }
        });
    }
}