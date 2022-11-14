package com.khs.cie10proce.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelperCIEPRO extends SQLiteOpenHelper {
    private  static  final int DATABASE_VERSION=1;
    private  static  final String DATABASE_NOMBRE="datakwhs.db";
    private  static  final String TABLA_CIE="t_cie";
    private final Context helperContext;


    public DBhelperCIEPRO(@Nullable Context context) {
        super(context,  DATABASE_NOMBRE,null, DATABASE_VERSION);

        helperContext=context;


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
