package com.khs.cie10proce.crtlPerso;

public class List_Element {
    private String codigo, tipocie,descripcion;
    private String sexo,edadMin,edadMax, Activo;

    private Boolean favorito;

    public List_Element(String codigo, String tipocie, String descripcion, Boolean favorito) {
        this.codigo = codigo;
        this.tipocie = tipocie;
        this.descripcion = descripcion;
        this.favorito = favorito;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipocie() {
        return tipocie;
    }

    public void setTipocie(String tipocie) {
        this.tipocie = tipocie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdadMin() {
        return edadMin;
    }

    public void setEdadMin(String edadMin) {
        this.edadMin = edadMin;
    }

    public String getEdadMax() {
        return edadMax;
    }

    public void setEdadMax(String edadMax) {
        this.edadMax = edadMax;
    }

    public String getActivo() {
        return Activo;
    }

    public void setActivo(String activo) {
        Activo = activo;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }
}
