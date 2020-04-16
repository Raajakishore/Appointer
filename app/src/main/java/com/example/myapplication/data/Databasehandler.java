package com.example.myapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.model.Patient;
import com.example.myapplication.util.constants;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Databasehandler extends SQLiteOpenHelper {
    public Databasehandler(@Nullable Context context) {
        super(context, constants.DATABASE_NAME, null, constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("eeeeee", "onCreate: ");
        String create_table = "CREATE TABLE " + constants.TABLE_NAME1 + "("
                + constants.KEY_ID + " INTEGER PRIMARY KEY,"
                + constants.KEY_USERNAME + " TEXT,"
                + constants.KEY_PATIENTNAME + " TEXT,"
                + constants.PASSWORD + " TEXT,"
                + constants.ADDRESS + " TEXT,"
                + constants.AGE + " TEXT,"
                + constants.GENDER + " TEXT,"
                + constants.BLOODGRP + " TEXT,"
                + constants.CONTACT + " TEXT);";
        db.execSQL(create_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

       db.execSQL("DROP TABLE IF EXISTS " + constants.TABLE_NAME1);
        onCreate(db);


    }

//        Log.d("deletion", "de: ");
//        db.execSQL("DROP TABLE IF EXISTS " + constants.TABLE_NAME1);
//    }

    public void addPatient(Patient patient) {
//        String create_table = "CREATE TABLE " + constants.TABLE_NAME1 + "("
//            + constants.KEY_ID + " INTEGER PRIMARY KEY,"
//            + constants.KEY_USERNAME + " TEXT,"
//            + constants.KEY_PATIENTNAME + " TEXT,"
//            + constants.PASSWORD + " TEXT,"
//            + constants.ADDRESS + " TEXT,"
//            + constants.AGE + " TEXT,"
//            + constants.GENDER + "TEXT,"
//            + constants.BLOODGRP + "TEXT,"
//            + constants.CONTACT + "TEXT);";

        SQLiteDatabase db = this.getWritableDatabase();
//   db.execSQL("DROP TABLE IF EXISTS " + constants.TABLE_NAME11);
//        db.execSQL(create_table);
        onUpgrade(db,5,6);
        ContentValues values = new ContentValues();
        values.put(constants.KEY_USERNAME, patient.getContact());
        values.put(constants.KEY_PATIENTNAME, patient.getPatientName());
        values.put(constants.PASSWORD, patient.getPassword());
        values.put(constants.ADDRESS, patient.getAddress());
        values.put(constants.AGE, patient.getDob());
        values.put(constants.GENDER, patient.getGender());
        values.put(constants.BLOODGRP, patient.getBloodgp());
        values.put(constants.CONTACT, patient.getContact());


        db.insert(constants.TABLE_NAME1, null, values);
        Log.d("inseeertion", "addPatient: "+values);
    }

    public Patient getPatient(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(constants.TABLE_NAME1,
                new String[]{constants.KEY_ID, constants.KEY_USERNAME, constants.KEY_PATIENTNAME, constants.PASSWORD,
                        constants.AGE, constants.CONTACT, constants.ADDRESS, constants.BLOODGRP, constants.GENDER},
                constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            Patient patient = new Patient();
            patient.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(constants.KEY_ID))));
            patient.setUserName(cursor.getString(cursor.getColumnIndex(constants.KEY_USERNAME)));
            patient.setPassword(cursor.getString(cursor.getColumnIndex(constants.PASSWORD)));
            patient.setPatientName(cursor.getString(cursor.getColumnIndex(constants.KEY_PATIENTNAME)));
            patient.setDob(cursor.getString(cursor.getColumnIndex(constants.AGE)));
            patient.setAddress(cursor.getString(cursor.getColumnIndex(constants.ADDRESS)));
            patient.setBloodgp(cursor.getString(cursor.getColumnIndex(constants.BLOODGRP)));
            patient.setGender(cursor.getString(cursor.getColumnIndex(constants.GENDER)));
            patient.setContact(cursor.getString(cursor.getColumnIndex(constants.CONTACT)));
            return patient;
        } else {
            return null;
        }
    }
    public List<Patient> getAllBooks(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Patient> patientlist = new ArrayList<>();

        Cursor cursor = db.query(constants.TABLE_NAME1,
                new String[]{constants.KEY_ID, constants.KEY_USERNAME, constants.KEY_PATIENTNAME, constants.PASSWORD,
                        constants.AGE, constants.CONTACT, constants.ADDRESS, constants.BLOODGRP, constants.GENDER}, null,
                 null, null, null, null);
        if(cursor.moveToFirst()){
                    do{
                        Patient patient = new Patient();
                        patient.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(constants.KEY_ID))));
                        patient.setUserName(cursor.getString(cursor.getColumnIndex(constants.KEY_USERNAME)));
                        patient.setPassword(cursor.getString(cursor.getColumnIndex(constants.PASSWORD)));
                        patient.setPatientName(cursor.getString(cursor.getColumnIndex(constants.KEY_PATIENTNAME)));
                        patient.setDob(cursor.getString(cursor.getColumnIndex(constants.AGE)));
                        patient.setAddress(cursor.getString(cursor.getColumnIndex(constants.ADDRESS)));
                        patient.setBloodgp(cursor.getString(cursor.getColumnIndex(constants.BLOODGRP)));
                        patient.setGender(cursor.getString(cursor.getColumnIndex(constants.GENDER)));
                        patient.setContact(cursor.getString(cursor.getColumnIndex(constants.CONTACT)));


                        patientlist.add(patient);


            }while (cursor.moveToNext());
        }

        return patientlist;


    }
    public int updatePatient(Patient patient){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(constants.KEY_USERNAME, patient.getContact());
        values.put(constants.KEY_PATIENTNAME, patient.getPatientName());
        values.put(constants.PASSWORD, patient.getPassword());
        values.put(constants.ADDRESS, patient.getAddress());
        values.put(constants.BLOODGRP, patient.getBloodgp());
        values.put(constants.GENDER, patient.getGender());
        values.put(constants.CONTACT, patient.getContact());
        values.put(constants.AGE, patient.getDob());




        return db.update(constants.TABLE_NAME1,values,constants.KEY_ID+"?=",new String[]{String.valueOf(patient.getId())});

    }
    public void deletePatient(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(constants.TABLE_NAME1,constants.KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }

    public int getCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        String s="SELECT * FROM "+constants.TABLE_NAME1;
        Cursor cursor= db.rawQuery(s,null);

        return cursor.getCount();
    }
    public Patient login(String username,String password){
        SQLiteDatabase db=this.getReadableDatabase();
        Patient patient=new Patient();
        Cursor cursor = db.query(constants.TABLE_NAME1,
                new String[]{constants.KEY_ID, constants.KEY_USERNAME, constants.KEY_PATIENTNAME, constants.PASSWORD,
                        constants.AGE, constants.CONTACT, constants.ADDRESS, constants.BLOODGRP, constants.GENDER},
                constants.KEY_USERNAME+ "=? "+"and " +constants.PASSWORD+"=?",
                new String[]{username,password}, null, null, null, null);

        if(cursor.moveToFirst()){

                patient.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(constants.KEY_ID))));
                patient.setUserName(cursor.getString(cursor.getColumnIndex(constants.KEY_USERNAME)));
                patient.setPassword(cursor.getString(cursor.getColumnIndex(constants.PASSWORD)));
                patient.setPatientName(cursor.getString(cursor.getColumnIndex(constants.KEY_PATIENTNAME)));
                patient.setDob(cursor.getString(cursor.getColumnIndex(constants.AGE)));
                patient.setAddress(cursor.getString(cursor.getColumnIndex(constants.ADDRESS)));
                patient.setBloodgp(cursor.getString(cursor.getColumnIndex(constants.BLOODGRP)));
                patient.setGender(cursor.getString(cursor.getColumnIndex(constants.GENDER)));
                patient.setContact(cursor.getString(cursor.getColumnIndex(constants.CONTACT)));
        }

         return patient;

    }
}