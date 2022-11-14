package com.khs.cie10proce.bd;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.khs.cie10proce.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class dbhelper extends SQLiteOpenHelper {
private  static  final int DATABASE_VERSION=1;
    private  static  final String DATABASE_NOMBRE="datakhs.db";
    private  static  final String TABLA_CIE="t_cie";
    private final Context helperContext;




    public dbhelper(@Nullable Context context) {
        super(context,  DATABASE_NOMBRE,null, DATABASE_VERSION);

        helperContext=context;


    }

    @Override
    public void onCreate(SQLiteDatabase mysqlite) {

        mysqlite.execSQL("CREATE TABLE " + TABLA_CIE + "("+
                "codigo TEXT PRIMARY KEY ,"+
                "descripcion TEXT NOT NULL, "+
                "fg_tipo TEXT NOT NULL," +
                "edadMin INTEGER," +
                "edadMax INTEGER," +
                "sexo INTEGER," +
                "activo  INTEGER NOT NULL)"
        );
    }

    //CREATE TABLE "t_cie" (
    //	"codigo"	TEXT NOT NULL,
    //	"descripcion"	TEXT NOT NULL,
    //	"fg_tipo"	TEXT NOT NULL,
    //	"edadMin"	INTEGER,
    //	"edadMax"	INTEGER,
    //	"sexo"	INTEGER,
    //	"activo"	INTEGER NOT NULL,
    //	PRIMARY KEY("codigo")
    //)


    @Override
    public void onUpgrade(SQLiteDatabase mysqlite, int i, int i1) {
       mysqlite.execSQL("DROP TABLE IF EXISTS "+ TABLA_CIE);
        onCreate(mysqlite);


    }




}
