package com.sukirti.myapplication.RegistrationInfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sukirti.myapplication.Database.SQLiteHelper;
import com.sukirti.myapplication.R;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Registration extends Activity implements View.OnClickListener {


    EditText firstName,lastName,emilaID,phoneNo,password;
    EditText confirmPassword,dob;
    Button register;
    Logger logger;
    SQLiteHelper sqLiteHelper;
    Map<String,String> registrationDataMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        logger = Logger.getLogger(Login.class.getName());
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        emilaID = (EditText) findViewById(R.id.email);
        phoneNo = (EditText) findViewById(R.id.phoneNumber);
        password = (EditText) findViewById(R.id.passwordReg);
        confirmPassword = (EditText) findViewById(R.id.confirmPasswordReg);
        dob = (EditText) findViewById(R.id.dob);
        sqLiteHelper = new SQLiteHelper(this);
        registrationDataMap = new HashMap<>();

        register  = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                getAndStoreDataInMap();
                if(sqLiteHelper.insertData(registrationDataMap)) {
                    Toast.makeText(this,"Registration is Successful",Toast.LENGTH_LONG).show();
                    logger.info("Insertion intoTable is successful");
                    this.finish();
                }
                else {
                    logger.warning("Insertion has failed");
                    Toast.makeText(this,"Registration Failed",Toast.LENGTH_LONG).show();
                }

                break;
            default:
                logger.info("Default call inside registration page");
                break;
        }
    }

    public void getAndStoreDataInMap(){
        registrationDataMap.put(getString(R.string.FIRST_NAME),firstName.getText().toString());
        registrationDataMap.put(getString(R.string.LAST_NAME),lastName.getText().toString());
        registrationDataMap.put(getString(R.string.EMAIL_ID),emilaID.getText().toString());
        registrationDataMap.put(getString(R.string.PHONE_NO),phoneNo.getText().toString());
        registrationDataMap.put(getString(R.string.PASSWORD),password.getText().toString());
        registrationDataMap.put(getString(R.string.CONFIRM_PASSWORD),confirmPassword.getText().toString());
        registrationDataMap.put(getString(R.string.DOB),dob.getText().toString());
    }
}
