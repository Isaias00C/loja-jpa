package com.irede.loja.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", unique = true, nullable = false, length = 100)
    private String nome;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "sku", unique = true, nullable = false, length = 100)
    private String sku;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2) // precision corresponde a parte antes da vírgula (parte inteira) e scale corresponde aos dígitos depois das vírgulas (parte decimal)
    private BigDecimal preco;

    @Column(name = "quantidade_estoque", nullable = false)
    @ColumnDefault("0")
    private Integer quantidadeEstoque = 0;

    @Column(name = "ativo", nullable = false)
    @ColumnDefault("true")
    private Boolean ativo = true;

    public Produto() {
    }

    public Produto(String nome, String sku, BigDecimal preco) {
        this.nome = nome;
        this.sku = sku;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Produto{id=%d, nome='%s', sku='%s', preco=%s, estoque=%d, ativo=%s, descricao='%s'}"
                .formatted(id, nome, sku, preco, quantidadeEstoque, ativo, descricao);
    }
}
