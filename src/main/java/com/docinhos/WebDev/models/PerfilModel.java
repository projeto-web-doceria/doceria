package com.docinhos.WebDev.models;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil")
public class PerfilModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPerfil;
    @Column(nullable = false, unique = false) 
    private String nome;

    @OneToOne(mappedBy = "perfil")
    private UsuarioModel usuario;

    public UUID getIdPerfil() {
        return idPerfil;
    }
    public void setIdPerfil(UUID idPerfil) {
        this.idPerfil = idPerfil;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

}
