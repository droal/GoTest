package com.example.gotest.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity (indices = {@Index(value = {"correo", "password"},
        unique = true)}, tableName = "userTable")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int userId;

    @NonNull
    @ColumnInfo(name = "tipoDocumento")
    private String tipoDocumento;

    @NonNull
    @ColumnInfo(name = "numeroIdentificacion")
    private Integer numeroIdentificacion;

    @NonNull
    @ColumnInfo(name = "nombres")
    private String nombres;

    @NonNull
    @ColumnInfo(name = "apellidos")
    private String apellidos;

    @NonNull
    @ColumnInfo(name = "telefonoMovil")
    private String telefonoMovil;

    @NonNull
    @ColumnInfo(name = "correo")
    private String correo;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    public User(@NonNull String tipoDocumento, @NonNull Integer numeroIdentificacion, @NonNull String nombres, @NonNull String apellidos, @NonNull String telefonoMovil, @NonNull String correo, @NonNull String password) {
        this.tipoDocumento = tipoDocumento;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefonoMovil = telefonoMovil;
        this.correo = correo;
        this.password = password;
    }

    //////////////////////////////


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @NonNull
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(@NonNull String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @NonNull
    public Integer getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(@NonNull Integer numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    @NonNull
    public String getNombres() {
        return nombres;
    }

    public void setNombres(@NonNull String nombres) {
        this.nombres = nombres;
    }

    @NonNull
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NonNull String apellidos) {
        this.apellidos = apellidos;
    }

    @NonNull
    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(@NonNull String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    @NonNull
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(@NonNull String correo) {
        this.correo = correo;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
