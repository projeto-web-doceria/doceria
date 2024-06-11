package com.docinhos.webdev.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduto;
    @Column(nullable = false, unique = false)
    private String nome;
    @Column(nullable = false, unique = false) 
    private String descricao;
    @Column(nullable = false, unique = false)
    private float preco;
    @Column(nullable = false, unique = false)
    private Date dtFabricacao;
    @Column(nullable = false, unique = false)
    private Date dtValidade;
    
   @ManyToMany(mappedBy = "produto", fetch = FetchType.LAZY)
    private Set<VendaModel> vendaModel = new HashSet<>();
    
}
