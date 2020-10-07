package com.example.gotest.api.establishment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Establishment {
    @SerializedName("idestablecimiento")
    @Expose
    private String idestablecimiento;
    @SerializedName("idasociado")
    @Expose
    private String idasociado;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("razonsocial")
    @Expose
    private Object razonsocial;
    @SerializedName("direccion")
    @Expose
    private String direccion;
    @SerializedName("latitud")
    @Expose
    private Object latitud;
    @SerializedName("longitud")
    @Expose
    private Object longitud;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("tarifaVehiculo")
    @Expose
    private String tarifaVehiculo;
    @SerializedName("tarifaMoto")
    @Expose
    private String tarifaMoto;
    @SerializedName("fechaCreacion")
    @Expose
    private Object fechaCreacion;
    @SerializedName("fechaActualizacion")
    @Expose
    private Object fechaActualizacion;
    @SerializedName("imageurl")
    @Expose
    private Object imageurl;
    @SerializedName("horario")
    @Expose
    private String horario;
    @SerializedName("telefono")
    @Expose
    private Object telefono;
    @SerializedName("ciudadestablecimiento")
    @Expose
    private String ciudadestablecimiento;
    @SerializedName("splitReceivers")
    @Expose
    private Object splitReceivers;
    @SerializedName("splitRule")
    @Expose
    private Object splitRule;
    @SerializedName("color")
    @Expose
    private Object color;
    @SerializedName("nit")
    @Expose
    private Object nit;
    @SerializedName("codigoEDS")
    @Expose
    private Object codigoEDS;
    @SerializedName("code")
    @Expose
    private Object code;

    public String getIdestablecimiento() {
        return idestablecimiento;
    }

    public void setIdestablecimiento(String idestablecimiento) {
        this.idestablecimiento = idestablecimiento;
    }

    public String getIdasociado() {
        return idasociado;
    }

    public void setIdasociado(String idasociado) {
        this.idasociado = idasociado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(Object razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Object getLatitud() {
        return latitud;
    }

    public void setLatitud(Object latitud) {
        this.latitud = latitud;
    }

    public Object getLongitud() {
        return longitud;
    }

    public void setLongitud(Object longitud) {
        this.longitud = longitud;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getTarifaVehiculo() {
        return tarifaVehiculo;
    }

    public void setTarifaVehiculo(String tarifaVehiculo) {
        this.tarifaVehiculo = tarifaVehiculo;
    }

    public String getTarifaMoto() {
        return tarifaMoto;
    }

    public void setTarifaMoto(String tarifaMoto) {
        this.tarifaMoto = tarifaMoto;
    }

    public Object getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Object fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Object getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Object fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Object getImageurl() {
        return imageurl;
    }

    public void setImageurl(Object imageurl) {
        this.imageurl = imageurl;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Object getTelefono() {
        return telefono;
    }

    public void setTelefono(Object telefono) {
        this.telefono = telefono;
    }

    public String getCiudadestablecimiento() {
        return ciudadestablecimiento;
    }

    public void setCiudadestablecimiento(String ciudadestablecimiento) {
        this.ciudadestablecimiento = ciudadestablecimiento;
    }

    public Object getSplitReceivers() {
        return splitReceivers;
    }

    public void setSplitReceivers(Object splitReceivers) {
        this.splitReceivers = splitReceivers;
    }

    public Object getSplitRule() {
        return splitRule;
    }

    public void setSplitRule(Object splitRule) {
        this.splitRule = splitRule;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

    public Object getNit() {
        return nit;
    }

    public void setNit(Object nit) {
        this.nit = nit;
    }

    public Object getCodigoEDS() {
        return codigoEDS;
    }

    public void setCodigoEDS(Object codigoEDS) {
        this.codigoEDS = codigoEDS;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }
}
