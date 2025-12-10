package com.talento.web.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")

public class Usuario {
    
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncremental
    private Long id;
    private String userName;
    private String pass;

    private static Long contador = 0L;

    public Usuario() {
    }    
    
    public Usuario(String user, String pass) {
        this.id = ++contador;
        this.userName = user;
        this.pass = pass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String user) {
        this.userName = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", user=" + userName + ", pass=" + pass + "]";
    }
    
}
