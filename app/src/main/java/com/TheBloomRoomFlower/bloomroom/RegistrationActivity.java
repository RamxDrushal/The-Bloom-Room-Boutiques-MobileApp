package com.TheBloomRoomFlower.bloomroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.TheBloomRoomFlower.bloomroom.R;

public class RegistrationActivity extends AppCompatActivity {

    private TextView Uname;
    private TextView pass;
    private TextView email;
    private TextView fName;
    private TextView lName;
    private TextView contactNo;
    private DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fName = (TextView)findViewById(R.id.firstname);
        lName = (TextView)findViewById(R.id.lastname);
        pass = (TextView)findViewById(R.id.password);
        Uname = (TextView)findViewById(R.id.username);
        contactNo = (TextView)findViewById(R.id.contactnumber);
        email = (TextView)findViewById(R.id.email);
        dbHandler.openDB();

        Button signupButton = findViewById(R.id.create_account_button);
        signupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String fname = fName.getText().toString();
                String lname = lName.getText().toString();
                String uname = Uname.getText().toString();
                String cNo = contactNo.getText().toString();
                String mail = email.getText().toString();
                String pass1 = pass.getText().toString();

                User user2 = new User(fname,lname,uname,cNo,mail,pass1);
                dbHandler.insertUser(user2);
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),
                        "Registration success",
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}