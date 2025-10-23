package br.com.fiap.nano.produtos.view;

import java.util.Arrays;
import java.util.List;

public enum Opcao {
    CADASTRAR_CATEGORIA(1, "Cadastrar Categoria"),
    CADASTRAR_PRODUTO(2, "Cadastrar Produto"),
    ALTERAR_PRODUTO(3, "Alterar dados do Produto"),
    CONSULTAR_PRODUTO_POR_ID(4, "Consultar Produto por ID"),
    CONSULTAR_PRODUTO_POR_CATEGORIA(5, "Consultar Produto por Categoria"),
    ENCERRAR_SISTEMA(6, "Encerrar Sistema");

    private String nome;
    private int id;

    Opcao(int id, String nome) { this.id = id; this.nome = nome; }

    public String getNome() { return nome; }
    public int getId() { return id; }

    public static List<Opcao> getList() { return Arrays.asList(Opcao.values()); }

    @Override
    public String toString() { return nome; }
}