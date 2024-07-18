package com.TheBloomRoomFlower.bloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.TheBloomRoomFlower.bloomroom.R;

public class AddfloweradminActivity extends AppCompatActivity {

    private TextView flowerID;
    private TextView flowerName;
    private TextView flowerPrice;
    private TextView FlowerQuan;

    private DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfloweradmin);

        flowerID = (TextView)findViewById(R.id.FlowerID);
        flowerName = (TextView)findViewById(R.id.FlowerName);
        flowerPrice = (TextView)findViewById(R.id.FlowerPrice);
        FlowerQuan = (TextView)findViewById(R.id.Flowerquan);

        dbHandler.openDB();

        Button signupButton = findViewById(R.id.AddFlowers);
        signupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String flowerid = flowerID.getText().toString();
                String fname = flowerName.getText().toString();
                String fprice = flowerPrice.getText().toString();
                String fquan = FlowerQuan.getText().toString();

                Flower cupK = new Flower(flowerid,fname,fprice,fquan);
                dbHandler.insertflower(cupK);

                Intent intent = new Intent(AddfloweradminActivity.this, AdminActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),
                        "Done",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}