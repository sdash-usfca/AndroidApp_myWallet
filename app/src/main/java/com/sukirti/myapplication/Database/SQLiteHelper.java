package com.sukirti.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sukirti.myapplication.R;

import java.util.Map;
import java.util.logging.Logger;

public class SQLiteHelper extends SQLiteOpenHelper {

    SQLSyntax sqlSyntax;
    Context context;
    Logger logger;


    public SQLiteHelper(Context context) {
        super(context, context.getString(R.string.DATABASE_NAME), null, 1);

        this.context = context;
        logger = Logger.getLogger(SQLiteHelper.class.getName());
        sqlSyntax =  new SQLSyntax(context);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            logger.info("Inside On Create Method");
            logger.info("sqlSyntax value "+sqlSyntax);
            db.execSQL(sqlSyntax.createTableQuery());
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        logger.info("Inside onUpgrade Method");
        db.execSQL(sqlSyntax.dateleTableQuery());
        onCreate(db);
    }


    public boolean insertData(Map<String,String> registrationData){
        logger.info("Inside insertData Method");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(context.getString(R.string.EMAIL_ID),registrationData.get(context.getString(R.string.EMAIL_ID)));
        contentValues.put(context.getString(R.string.FIRST_NAME),registrationData.get(context.getString(R.string.FIRST_NAME)));
        contentValues.put(context.getString(R.string.LAST_NAME),registrationData.get(context.getString(R.string.LAST_NAME)));
        contentValues.put(context.getString(R.string.PHONE_NO),registrationData.get(context.getString(R.string.PHONE_NO)));
        contentValues.put(context.getString(R.string.PASSWORD),registrationData.get(context.getString(R.string.PASSWORD)));
        contentValues.put(context.getString(R.string.CONFIRM_PASSWORD),registrationData.get(context.getString(R.string.CONFIRM_PASSWORD)));
        contentValues.put(context.getString(R.string.DOB),registrationData.get(context.getString(R.string.DOB)));
        long output = db.insert(context.getString(R.string.TABLE_NAME),null,contentValues);
        return output!=-1;
    }


}
