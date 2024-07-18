package com.TheBloomRoomFlower.bloomroom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.TheBloomRoomFlower.bloomroom.R;


public class MainActivity extends AppCompatActivity {

    private EditText Uname;
    private EditText password;
    DBConnector mydb;

    private DBHandler dbHandler = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uname = (EditText) findViewById(R.id.Uname);
        password = (EditText) findViewById(R.id.password);
        dbHandler.openDB();
        mydb = new DBConnector(this);

        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(intent);
                String userName = Uname.getText().toString();
                String Password = password.getText().toString();

                if (userName.trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Username cannot be empty",
                            Toast.LENGTH_LONG).show();
                } else if (Password.trim().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Password cannot be empty",
                            Toast.LENGTH_LONG).show();
                } else if (userName.equals("Admin") && Password.equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                    startActivity(intent);
                } else {

                    boolean checkuserpass = mydb.checkusernamepassword(userName, Password);

                    if (checkuserpass == true) {
                        Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), CmActivity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(),
                                "Invalid username or password",
                                Toast.LENGTH_LONG).show();
                    }


                }
            }
        });

        Button sign = findViewById(R.id.Signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);


            }

        });



    }
}


