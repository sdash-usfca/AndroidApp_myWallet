package com.sukirti.myapplication.RegistrationInfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sukirti.myapplication.R;

import java.util.logging.Logger;

public class Login extends Activity implements View.OnClickListener {

    Button login;
    EditText userName;
    EditText password;
    Logger logger;
    TextView loginFailText,registerLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logger = Logger.getLogger(Login.class.getName());
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        login  = (Button) findViewById(R.id.login);
        loginFailText = (TextView) findViewById(R.id.loginFailResult);
        registerLink = (TextView) findViewById(R.id.registerLink);
        login.setOnClickListener(this);
        registerLink.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                logger.info(String.valueOf(R.string.string_loginFailedText));
                loginFailText.setText(R.string.string_loginFailedText);
                break;
            case R.id.registerLink:
                //TODO need to make this activity a fragment
                startActivity(new Intent(this,Registration.class));
                break;

            default:
                System.out.println("Default");
                break;
        }

    }
}
