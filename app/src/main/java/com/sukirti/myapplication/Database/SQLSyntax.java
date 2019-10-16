package com.sukirti.myapplication.Database;

import android.content.Context;

import com.sukirti.myapplication.R;

public class SQLSyntax {

    private static String SQL_CREATE_ENTRIES = "";
    private static String SQL_DELETE_ENTRIES = "";
    Context context;

    public SQLSyntax(Context context){
        this.context  = context;
    }


    //create table query
    public String createTableQuery(){

         SQL_CREATE_ENTRIES = "CREATE TABLE IF NOT EXISTS " + context.getString(R.string.TABLE_NAME) + " (" +
                 context.getString(R.string.EMAIL_ID) + " TEXT PRIMARY KEY," + context.getString(R.string.FIRST_NAME) + " TEXT," +context.getString(R.string.LAST_NAME) + " TEXT," +
                 context.getString(R.string.PHONE_NO) + " TEXT," +context.getString(R.string.PASSWORD) + " TEXT," +context.getString(R.string.CONFIRM_PASSWORD) + " TEXT," +context.getString(R.string.DOB) + " TEXT)";

         return SQL_CREATE_ENTRIES;

    }



    public String dateleTableQuery(){
        SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + context.getString(R.string.TABLE_NAME);
        return SQL_DELETE_ENTRIES;

    }

    public String checkIfTableExist(){
        return "select DISTINCT tbl_name from sqlite_master where tbl_name = '"+R.string.TABLE_NAME+"'";
    }


}
