/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lojadacomp.modelo.dominio;

import java.math.BigDecimal;

/**
 *
 * @author PCUFRGS
 */
public class Produto {
    private long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;
    private Usuario usuario;
    private LocalDataTime dataHoraCriacao;

    public Produto() {
    }

    public Produto(long id, String nome, String descricao, BigDecimal preco, Integer quantidade, Usuario usuario, LocalDataTime dataHoraCriacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.usuario = usuario;
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDataTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDataTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }
    
    
    
}
