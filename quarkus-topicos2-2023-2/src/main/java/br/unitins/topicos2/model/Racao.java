package br.unitins.topicos2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Racao extends DefaultEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer estoque;

    @Column(nullable = false)
    private Double quantidadeQuilos;

    @Column(nullable = false)
    private String sabor;

    @Column(nullable = false)
    private String animal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Double getQuantidadeQuilos() {
        return quantidadeQuilos;
    }

    public void setQuantidadeQuilos(Double quantidadeQuilos) {
        this.quantidadeQuilos = quantidadeQuilos;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

}
