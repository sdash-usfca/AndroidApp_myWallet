package com.sukirti.myapplication.RegistrationInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sukirti.myapplication.R;

import java.util.logging.Logger;

public class Registration extends Activity implements View.OnClickListener {


    EditText firstName,lastName,emilaID,phoneNo,password;
    EditText confirmPassword,dob;
    Button register;
    Logger logger;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        logger = Logger.getLogger(Login.class.getName());
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        emilaID = (EditText) findViewById(R.id.email);
        phoneNo = (EditText) findViewById(R.id.phoneNumber);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPasswordReg);

        register  = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                break;
            default:
                logger.info("Default call inside registration page");
                break;
        }
    }
}
