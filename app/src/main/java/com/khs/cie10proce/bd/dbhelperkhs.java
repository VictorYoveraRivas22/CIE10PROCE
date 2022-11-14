package com.khs.cie10proce.bd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.khs.cie10proce.crtlPerso.List_Element;
import com.khs.cie10proce.model.Cieandproc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class dbhelperkhs extends SQLiteOpenHelper {

    //public  static  final String BDNAME="hisdatakh.sqlite";
    public  static  final String BDNAME="hisdatakh.sqlite";
    public static  final  Integer BD_Version=1;
    public static final  String BDUbicacion="/data/data/com.khs.cie10proce/databases/";
    public Context mcontex2;
    private SQLiteDatabase mDataBase;
    private String db_path;

    public dbhelperkhs( Context context){
        super(context,BDNAME,null,BD_Version);
        this.mcontex2=context;
        db_path=this.mcontex2.getDatabasePath(BDNAME).getPath();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.disableWriteAheadLogging();
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // TODO Auto-generated method stub
    //    mDataBase.execSQL("DROP TABLE IF EXISTS t_cie");
    //    mDataBase.execSQL("DROP TABLE IF EXISTS var_eng");
      //  onCreate(mDataBase);
        Log.d("DB Upgrade", "Yes Upgrade");
    }
    /*
    public void createDB() throws IOException {

        this.getReadableDatabase();
        copyDB();
        Log.d("Database", "copy databse");
    }
    private boolean checkDB() {

        File cDB = new File(this.mcontex2.getDatabasePath(BDNAME).getPath());
        if (cDB.exists()) return true;
        if (!cDB.getParentFile().exists()) {
            cDB.getParentFile().mkdirs();
        }
        return false;
    }

        private void copyDB() throws IOException {
        InputStream inputFile = mcontex2.getAssets().open(BDNAME);
        String outFileName = db_path + BDNAME;
        OutputStream outFile = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputFile.read(buffer)) > 0) {
            outFile.write(buffer, 0, length);
        }
        outFile.flush();
        outFile.close();
        inputFile.close();
    }
*/

    Boolean opendata=false;

    public void OpenDataBase()
    {
        String dbPath= mcontex2.getDatabasePath(BDNAME).getPath();
        String dbPath2=BDUbicacion+BDNAME;
        if (mDataBase!=null && mDataBase.isOpen()){
            return;
        }
        opendata=true   ;
        mDataBase=SQLiteDatabase.openDatabase(dbPath2,null,SQLiteDatabase.OPEN_READWRITE);

    }



    public  void  CloseDataBase(){
        if(mDataBase!=null)
        {
        mDataBase.close();
        }
    }

    public List<Cieandproc> getListCIE(){
        Cieandproc cieandproc= null;
        List<Cieandproc> listcie = new ArrayList<>();
        OpenDataBase();

        Cursor cursor= mDataBase.rawQuery(" Select * from t_cie",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            // codigo, String descripcion, String fg_tipo, int edadMin, int edadMax, int sexo, int activo) {
            cieandproc = new Cieandproc(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6));
            listcie.add(cieandproc);
            cursor.moveToNext();
        }
        cursor.close();
        CloseDataBase();
        return  listcie;


    }

    public List<List_Element> getListCIEwhere(String Codigo, String Descripcion){
        List<List_Element> elementList;
        elementList=new ArrayList<>();
        this.getReadableDatabase();
        List<List_Element> listcie = new ArrayList<>();
        Cursor cursor=null;
        try {
           OpenDataBase();
             cursor= mDataBase.rawQuery("Select codigo,fg_tipo,descripcion from t_cie where codigo like '%"+Codigo+"%' or descripcion like '%"+Descripcion+"%';",null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
            while (!cursor.isAfterLast()){
                // codigo, String descripcion, String fg_tipo, int edadMin, int edadMax, int sexo, int activo) {
                // cieandproc = new Cieandproc(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6));
                // elementList.add(new List_Element("J039","CIEX","ADMIGDALITS",false));
                elementList.add(new List_Element(cursor.getString(0),cursor.getString(1),cursor.getString(2),false));
//            listcie.add(cieandproc);
                cursor.moveToNext();
            }
            cursor.close();
            CloseDataBase();
        } catch (Exception e) {
            Log.v("error", e.getMessage()   );
        }
        return  elementList;
    }

}
