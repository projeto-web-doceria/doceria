package com.docinhos.webdev.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario") 
public class UsuarioModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private UUID idUsuario; 

    @Column(nullable = false, length = 100) 
    private String nome;

    @Column(nullable = false, length = 14) 
    private String cpf;  

    @Column(nullable = false, length = 20) 
    private String telefone;  

    @Column(nullable = false, length = 255)
    private String endereco;

    @Column(nullable = false, length = 50)
    private String email; 

    @Column(nullable = false, length = 50)
    private String login; 

    @Column(nullable = false, length = 60) 
    private String senha;  
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPerfil")
    private PerfilModel perfil;
}
