package com.sukirti.myapplication.RegistrationInfo;

import android.app.Activity;
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
    TextView loginFailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logger = Logger.getLogger(Login.class.getName());
        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        login  = (Button) findViewById(R.id.login);
        loginFailText = (TextView) findViewById(R.id.loginFailResult);
        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        logger.info(String.valueOf(R.string.string_loginFailedText));
        loginFailText.setText(R.string.string_loginFailedText);
    }
}
