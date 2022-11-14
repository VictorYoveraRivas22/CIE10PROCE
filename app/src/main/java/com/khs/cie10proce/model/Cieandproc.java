package com.khs.cie10proce.model;

public class Cieandproc {
    private String codigo,descripcion,fg_tipo;
    private int edadMin,edadMax,sexo,activo;

    public Cieandproc(String codigo, String descripcion, String fg_tipo, int edadMin, int edadMax, int sexo, int activo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fg_tipo = fg_tipo;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
        this.sexo = sexo;
        this.activo = activo;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFg_tipo() {
        return fg_tipo;
    }

    public void setFg_tipo(String fg_tipo) {
        this.fg_tipo = fg_tipo;
    }

    public int getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(int edadMin) {
        this.edadMin = edadMin;
    }

    public int getEdadMax() {
        return edadMax;
    }

    public void setEdadMax(int edadMax) {
        this.edadMax = edadMax;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
