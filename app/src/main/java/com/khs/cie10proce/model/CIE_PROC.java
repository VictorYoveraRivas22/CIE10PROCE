package com.khs.cie10proce.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CIE_PROC {

    @PrimaryKey
    @NonNull
    public  String codigo;
    @NonNull
    public String descripcion;
    @NonNull
    public String fg_tipo;

    public Integer edadMin;
    public Integer edadMax;
    public Integer sexo;
    public Integer activo;
public CIE_PROC(@NonNull String codigo,
                @NonNull String descripcion,
                @NonNull String fg_tipo,
                Integer edadMin,
                Integer edadMax,
                Integer sexo,
                Integer activo) {

    this.codigo = codigo;
     this.descripcion=descripcion;
     this.fg_tipo=fg_tipo;
     this.edadMin=edadMin;
     this.edadMax=edadMax;
     this.sexo=sexo;
     this.activo=activo;

}


}
