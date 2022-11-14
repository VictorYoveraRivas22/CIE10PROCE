package com.khs.cie10proce.bd;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.khs.cie10proce.model.CIE_PROC;
import com.khs.cie10proce.model.DaoCiePro;

@Database(
        entities = {CIE_PROC.class},
        version = 1

)
public abstract class AppDataBase extends RoomDatabase {
    public  abstract DaoCiePro daoCiePro();

    


}
