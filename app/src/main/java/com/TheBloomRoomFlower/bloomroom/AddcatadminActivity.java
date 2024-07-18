package com.TheBloomRoomFlower.bloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.TheBloomRoomFlower.bloomroom.R;

public class AddcatadminActivity extends AppCompatActivity {

    private TextView catID;
    private TextView catName;
    private TextView catPrice;
    private TextView catQuan;
    private TextView catinclude;

    private DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcatadmin);

        catID = (TextView)findViewById(R.id.CatID);
        catName = (TextView)findViewById(R.id.Catname);
        catPrice = (TextView)findViewById(R.id.Catprice);
        catQuan = (TextView)findViewById(R.id.catquantity);
        catinclude = (TextView)findViewById(R.id.Includings);

        dbHandler.openDB();

        Button signupButton = findViewById(R.id.Addcat);
        signupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String ctid = catID.getText().toString();
                String ctname = catName.getText().toString();
                String ctprice = catPrice.getText().toString();
                String ctquan = catQuan.getText().toString();
                String ctincluding = catinclude.getText().toString();

                Category cat = new Category(ctid,ctincluding,ctname,ctprice,ctquan);
                dbHandler.insertCategory(cat);

                Intent intent = new Intent(AddcatadminActivity.this, AdminActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),
                        "Inserted category",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}