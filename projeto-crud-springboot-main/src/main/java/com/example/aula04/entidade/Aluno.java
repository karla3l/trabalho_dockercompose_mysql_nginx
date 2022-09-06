package com.example.aula04.entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Aluno implements Serializable {
    
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int matricula;
    private String nome;
    private String email;
    private String senha;

    @ManyToOne

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(final int matricula) {
        this.matricula = matricula;
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
}

   