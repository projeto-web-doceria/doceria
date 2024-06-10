package com.docinhos.WebDev.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private Set<UsuarioModel> usuario =  new HashSet<>();

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
    public Set<UsuarioModel> getUsuario() {
        return usuario;
    }
    public void setUsuario(Set<UsuarioModel> usuario) {
        this.usuario = usuario;
    }

}
