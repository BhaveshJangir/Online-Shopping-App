package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText mUsername, mEmail, mPassword, mConfirmPassword;
    Button mRegister;
    TextView mHaveAcTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (EditText) findViewById(R.id.username_et);
        mEmail = (EditText) findViewById(R.id.email_et);
        mPassword = (EditText) findViewById(R.id.password_et);
        mConfirmPassword = (EditText) findViewById(R.id.confim_password_et);
        mRegister = (Button) findViewById(R.id.register_bv);
        mHaveAcTv = (TextView) findViewById(R.id.have_ac_tv);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        //SQLiteDatabase db = databaseHelper.getReadableDatabase();

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mUsername.getText().toString();
                String email = mEmail.getText().toString();
                String passwrod = mPassword.getText().toString();
                String confirmPassword = mConfirmPassword.getText().toString();

                if (name.equals("") || email.equals("") || passwrod.equals("") || confirmPassword.equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Details", Toast.LENGTH_SHORT).show();
                } else if (!passwrod.equals(confirmPassword)) {
                    Toast.makeText(MainActivity.this, "Password is not same", Toast.LENGTH_SHORT).show();
                    mConfirmPassword.setText("");
                } else {
                    Boolean checkUser = databaseHelper.checkUser(email,passwrod);
                    if(checkUser==false){
                        Boolean insert = databaseHelper.inset_data(name, email, passwrod);
                        if (insert == true) {
                            Toast.makeText(MainActivity.this, "Succesful", Toast.LENGTH_SHORT).show();
                            Intent j = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(j);
                            mUsername.setText("");
                            mEmail.setText("");
                            mPassword.setText("");
                            mConfirmPassword.setText("");
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Your account already exists", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        mHaveAcTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });

    }


}