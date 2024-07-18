package com.TheBloomRoomFlower.bloomroom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.TheBloomRoomFlower.bloomroom.R;

import java.util.ArrayList;

public class CmcatoderActivity extends AppCompatActivity {

    private TextView cuname;
    private TextView fname;
    private TextView cqnty;

    private TableLayout tableLayout;

    private ArrayList<Flower> flower;

    private DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmcatoder);

        dbHandler.openDB();

        tableLayout = findViewById(R.id.tableLayout);

        cuname = findViewById(R.id.CartUname);
        fname = findViewById(R.id.CartCat);
        cqnty = findViewById(R.id.CartQuan);

        flower = (ArrayList<Flower>) dbHandler.getAllFlowerData();

        for (Flower data : flower) {
            TableRow tableRow = new TableRow(this);

            TextView textView1 = new TextView(this);
            textView1.setText(data.getFlowersName());
            // Add layout parameters if needed
            tableRow.addView(textView1);

            TextView textView2 = new TextView(this);
            textView2.setText(data.getPrice());
            // Add layout parameters if needed
            tableRow.addView(textView2);

            // Add more TextViews for additional columns if needed

            tableLayout.addView(tableRow);
        }

        Button addToCart = findViewById(R.id.addtocrt);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String crtName = cuname.getText().toString();
                String crtCat = fname.getText().toString();
                String crtQuan = cqnty.getText().toString();
                Cart cart = new Cart(crtName, crtCat, crtQuan);
                dbHandler.addToCart(cart);

                Intent intent = new Intent(CmcatoderActivity.this, CmActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),
                        "Inserted to cart",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
