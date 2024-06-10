package com.docinhos.WebDev.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
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
    
    @OneToMany
    @JoinColumn()
    /**
     * @return UUID return the idProduto
     */
    public UUID getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return float return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }


    /**
     * @return Date return the dtFabricacao
     */
    public Date getDtFabricacao() {
        return dtFabricacao;
    }

    /**
     * @param dtFabricacao the dtFabricacao to set
     */
    public void setDtFabricacao(Date dtFabricacao) {
        this.dtFabricacao = dtFabricacao;
    }

    /**
     * @return Date return the dtValidade
     */
    public Date getDtValidade() {
        return dtValidade;
    }

    /**
     * @param dtValidade the dtValidade to set
     */
    public void setDtValidade(Date dtValidade) {
        this.dtValidade = dtValidade;
    }
}
