package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineshopping.databinding.FragmentCartBinding;
import com.example.onlineshopping.ui.home.HomeFragment;

public class LoginActivity extends AppCompatActivity {

    EditText mEmail,mPassword;
    Button mLogin;
    TextView mRegisterBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.email_login_et);
        mPassword = (EditText) findViewById(R.id.password_login_et);
        mLogin = (Button) findViewById(R.id.login_bt);
        mRegisterBack = (TextView) findViewById(R.id.pre_register_page);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(databaseHelper.checkUser(mEmail.getText().toString().trim(),mPassword.getText().toString().trim())){
                   Toast.makeText(LoginActivity.this, "home page", Toast.LENGTH_SHORT).show();
                   Intent i = new Intent(getApplicationContext(), DesignActivity.class);
                   i.putExtra("Email",mEmail.getText().toString());
                   i.putExtra("password",mPassword.getText().toString());
                   startActivity(i);
                   finish();
                   mEmail.setText("");
                   mPassword.setText("");
               }
               else{
                   Toast.makeText(LoginActivity.this, "incorrect", Toast.LENGTH_SHORT).show();
                   mPassword.setText("");
               }
            }

        });

        mRegisterBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FragmentCartBinding.class);
                startActivity(i);
                finish();
            }
        });
    }

}