package br.com.fiap.nano.produtos;

import br.com.fiap.nano.produtos.model.*;
import br.com.fiap.nano.produtos.repository.*;
import br.com.fiap.nano.produtos.view.*;
import javax.swing.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Opcao opcao;
        do {
            opcao = OpcaoView.select();
            switch (opcao) {
                case CADASTRAR_CATEGORIA -> cadastrarCategoria();
                case CADASTRAR_PRODUTO -> cadastrarproduto();
                case ALTERAR_PRODUTO -> alterarproduto();
                case CONSULTAR_PRODUTO_POR_ID -> consultarprodutoporid();
                case CONSULTAR_PRODUTO_POR_CATEGORIA -> consultarprodutoporcategoria();
            }
        } while (opcao != Opcao.ENCERRAR_SISTEMA);
    }

    private static void consultarprodutoporcategoria() {
        Categoria categoria = CategoriaView.select(null);
        List<Produto> produtos = ProdutoCollectionRepository.findByCategoria(categoria);
        if (produtos.isEmpty())
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
        produtos.forEach(ProdutoView::show);
    }

    private static void consultarprodutoporid() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("Informe o ID do produto"));
        Produto p = ProdutoCollectionRepository.findById(id);
        if (p != null) ProdutoView.show(p);
        else JOptionPane.showMessageDialog(null, "Produto não encontrado!");
    }

    private static void alterarproduto() {
        Produto produto = ProdutoView.select();
        ProdutoView.update(produto);
    }

    private static void cadastrarproduto() {
        Produto produto = ProdutoView.form();
        ProdutoCollectionRepository.save(produto);
        ProdutoView.sucesso(produto);
    }

    public static void cadastrarCategoria() {
        CategoriaView view = new CategoriaView();
        Categoria categoria = view.form();
        CategoriaCollectionRepository.save(categoria);
        view.sucesso(categoria);
    }
}