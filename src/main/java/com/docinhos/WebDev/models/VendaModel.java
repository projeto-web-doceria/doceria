package com.docinhos.webdev.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "venda")
@Getter
@Setter
public class VendaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idVenda;
    @Column(nullable = false, unique = false)
    private float valor;
    @Column(nullable = false, unique = false)
    private Date dataVenda;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "venda_produto", 
        joinColumns = {
            @JoinColumn(name = "idVenda", referencedColumnName = "idVenda")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
        }
    )
    private Set<ProdutoModel> produto = new HashSet<>();

    
}
