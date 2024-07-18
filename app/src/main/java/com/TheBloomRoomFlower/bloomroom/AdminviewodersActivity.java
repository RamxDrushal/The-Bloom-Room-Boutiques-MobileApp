package com.TheBloomRoomFlower.bloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.TheBloomRoomFlower.bloomroom.R;

import java.util.ArrayList;

public class AdminviewodersActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private ArrayList<Cart> cart;
    private DBHandler dbHandler = new DBHandler(this);
    private EditText usernameEditText;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminviewoders);

        dbHandler.openDB();

        tableLayout = findViewById(R.id.tble2);
        usernameEditText = findViewById(R.id.usernameEditText);
        deleteButton = findViewById(R.id.deleteButton);

        cart = (ArrayList<Cart>) dbHandler.getAllCartData();

        for (Cart data : cart) {
            addTableRow(data);
        }

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteSelectedRows();
            }
        });
    }

    private void addTableRow(Cart data) {
        TableRow tableRow = new TableRow(this);

        TextView textView2 = new TextView(this);
        textView2.setText(data.getUserN());
        tableRow.addView(textView2);

        TextView textView1 = new TextView(this);
        textView1.setText(data.getFlowerName());
        tableRow.addView(textView1);

        TextView textView3 = new TextView(this);
        textView3.setText(data.getQty());
        tableRow.addView(textView3);


        tableLayout.addView(tableRow);
    }

    private void deleteSelectedRows() {
        String inputUsername = usernameEditText.getText().toString().trim();

        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            View view = tableLayout.getChildAt(i);
            if (view instanceof TableRow) {
                TableRow row = (TableRow) view;
                TextView usernameTextView = (TextView) row.getChildAt(1);

                if (usernameTextView != null) {
                    String rowUsername = usernameTextView.getText().toString().trim();
                    if (rowUsername.equalsIgnoreCase(inputUsername)) {
                        tableLayout.removeView(row);
                        // Perform the necessary database delete operation
                        dbHandler.deleteCartData(rowUsername);
                    }
                }
            }
        }
    }
}