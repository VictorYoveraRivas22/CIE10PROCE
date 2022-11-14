package com.khs.cie10proce.model;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoCiePro {

@Query("SELECT * FROM CIE_PROC")
List<CIE_PROC> obtenercieS();

    @Query("SELECT * FROM CIE_PROC WHERE codigo=:USER")
    List<CIE_PROC> obtenercie(String USER);




}
