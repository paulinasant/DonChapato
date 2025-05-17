package com.daw.DonChapato.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
    @Id
    @Column (name="idUsuario")
    private int idUsuario;
    @Column (name="nombre")
    private String nombre;
    @Column(name="apellidoP")
    private String apellidoP;
    @Column (name="apellidoS")
    private String apellidoS;
    @Column (name="telefono")
    private String telefono;
    @Column (name="correo")
    private String correo;
    @Column (name="rol")
    private char rol;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoS() {
        return apellidoS;
    }

    public void setApellidoS(String apellidoS) {
        this.apellidoS = apellidoS;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public char getRol() {
        return rol;
    }

    public void setRol(char rol) {
        this.rol = rol;
    }
}
