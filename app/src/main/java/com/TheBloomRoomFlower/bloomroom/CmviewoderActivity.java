package com.TheBloomRoomFlower.bloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.TheBloomRoomFlower.bloomroom.R;

import java.util.ArrayList;

public class CmviewoderActivity extends AppCompatActivity {

    private TableLayout tableLayout;

    private ArrayList<Cart> cart;

    private DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmviewoder);

        dbHandler.openDB();

        tableLayout = findViewById(R.id.tlayout);

        cart = (ArrayList<Cart>) dbHandler.getAllCartData();

        for (Cart data : cart) {
            TableRow tableRow = new TableRow(this);

            TextView textView1 = new TextView(this);
            textView1.setText(data.getFlowerName());
            tableRow.addView(textView1);

            TextView textView3 = new TextView(this);
            textView3.setText(data.getQty());
            tableRow.addView(textView3);

            TextView textView2 = new TextView(this);
            textView2.setText(data.getUserN());
            tableRow.addView(textView2);


            // Add more TextViews for additional columns if needed

            tableLayout.addView(tableRow);
        }
    }
}