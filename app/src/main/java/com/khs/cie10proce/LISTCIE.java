package com.khs.cie10proce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.Toast;

import com.khs.cie10proce.bd.AppDataBase;
import com.khs.cie10proce.bd.dbhelper;
import com.khs.cie10proce.bd.dbhelperkhs;
import com.khs.cie10proce.crtlPerso.ListAdapter;
import com.khs.cie10proce.crtlPerso.List_Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

    public class LISTCIE extends AppCompatActivity {
        Button btncrear,btnbuscar;
        EditText txtbuscar;
        TextView lbldescripc,lblNresul,txtDESCR;
        private dbhelperkhs mdbhelper;
        private List<List_Element> elementList;
        ListAdapter listAdapter; // de mi recycler


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listcie);



        btncrear= findViewById(R.id.btn);
        btnbuscar= findViewById(R.id.btn2);
        txtbuscar=findViewById(R.id.txtabuscar);
        lblNresul =findViewById(R.id.lblNresul);
        txtDESCR=findViewById(R.id.txtDESCR);

        String descCont= "CIEX: Clasificación Internacional de Enfermedades\n"+
                          "CPT: Procedimientos\n"+
                          "Dx Por Imagen\n"+
                          "Pruebas de Laboratorio";
            txtDESCR.setText(descCont);

        mdbhelper= new dbhelperkhs(LISTCIE.this);




        //Log.v("aqui","aui");
            goLoad();
        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // goLoad();

            }
        });

            btnbuscar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String busq= txtbuscar.getText().toString();

                    if (busq.length()>3) {


                        Toast.makeText(LISTCIE.this,"buscamos", Toast.LENGTH_SHORT).show();



                        init(busq,busq);
                    }else{
                        Toast.makeText(LISTCIE.this,"no buscamos", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            });




        }
    private Boolean copyDataBase(Context context){
        try {

            InputStream inputStream=context.getAssets().open(dbhelperkhs.BDNAME);
            String outFileName=dbhelperkhs.BDUbicacion+dbhelperkhs.BDNAME;
            OutputStream outputStream= new FileOutputStream(outFileName);
            byte[]buff= new byte[1024];
            int len=0;
            while ((len=inputStream.read(buff))>0) {
                outputStream .write(buff,0,len);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            Log.v("main","bd copy");

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


public  void goLoad(){
    Log.v("aqui","COPY DATAi");
    File database= getApplicationContext().getDatabasePath(dbhelperkhs.BDNAME);
//
    if(false==database.exists()){
        mdbhelper.getReadableDatabase();
        Log.v("UBICACION EN EL MAIN",mdbhelper.getReadableDatabase().getPath());
        if(copyDataBase(LISTCIE.this)){
            Toast.makeText(LISTCIE.this,"copy database succes", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(LISTCIE.this,"copy database error", Toast.LENGTH_SHORT).show();
            return;
        }

    }else{
       // mdbhelper.getReadableDatabase();
    }




}

    public void init(String codigo, String descr){

            elementList=new ArrayList<>();
            elementList= mdbhelper.getListCIEwhere(codigo,descr);
         //   elementList.add(new List_Element("J039","CIEX","ADMIGDALITS",false));
        //elementList.add(new List_Element("J039","CIEX","ADMIGDALITS",false));
       // elementList.add(new List_Element("J039","CIEX","ADMIGDALITS",false));
        String cantR= elementList.size() +" Resultados";
        lblNresul.setText( cantR);
         listAdapter= new ListAdapter(elementList,this);
        RecyclerView recyclerView= findViewById(R.id.myrecicl);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }



}