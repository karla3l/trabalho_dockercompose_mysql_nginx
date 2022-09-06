package com.example.aula04.entidade;

import java.io.Serializable;
//import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Professor implements Serializable {
    
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nome;

    @ManyToOne

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(final int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }
     /*  public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getSenha() {
        return nome;
    }

    public void setSenha(final String senha) {
        this.senha = senha;
    } */

    public static Object getProfessores() {
        return null;
    }
}
