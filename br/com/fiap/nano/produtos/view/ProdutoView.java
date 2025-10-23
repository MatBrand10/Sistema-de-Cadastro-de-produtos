package br.com.fiap.nano.produtos.view;

import br.com.fiap.nano.produtos.model.Categoria;
import br.com.fiap.nano.produtos.model.Produto;
import br.com.fiap.nano.produtos.repository.CategoriaCollectionRepository;
import br.com.fiap.nano.produtos.repository.ProdutoCollectionRepository;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoView {

    public static Produto select() {
        Object[] produtos = ProdutoCollectionRepository.findAll().toArray();
        if (produtos.length == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
            return null;
        }
        Produto selecionado = (Produto) JOptionPane.showInputDialog(
                null,
                "Selecione o produto",
                "Produtos",
                JOptionPane.QUESTION_MESSAGE,
                null,
                produtos,
                produtos[0]);
        return selecionado;
    }

    public static Produto form() {
        String nome = JOptionPane.showInputDialog("Informe o nome do produto");
        String descricao = JOptionPane.showInputDialog("Informe a descrição do produto");

        Object[] categorias = CategoriaCollectionRepository.findAll().toArray();
        Categoria categoria = (Categoria) JOptionPane.showInputDialog(
                null,
                "Selecione a categoria",
                "Categoria",
                JOptionPane.QUESTION_MESSAGE,
                null,
                categorias,
                categorias[0]);

        String precoStr = JOptionPane.showInputDialog("Informe o preço do produto");
        BigDecimal preco = new BigDecimal(precoStr.replace(",", "."));

        Produto produto = new Produto()
                .setNome(nome)
                .setDescricao(descricao)
                .setCategoria(categoria)
                .setPreco(preco)
                .setDataCadastro(LocalDateTime.now());
        return produto;
    }

    public static void update(Produto produto) {
        if (produto == null) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return;
        }
        String nome = JOptionPane.showInputDialog("Nome", produto.getNome());
        String descricao = JOptionPane.showInputDialog("Descrição", produto.getDescricao());

        Object[] categorias = CategoriaCollectionRepository.findAll().toArray();
        Categoria categoria = (Categoria) JOptionPane.showInputDialog(
                null,
                "Categoria",
                "Categoria",
                JOptionPane.QUESTION_MESSAGE,
                null,
                categorias,
                produto.getCategoria());

        String precoStr = JOptionPane.showInputDialog("Preço", produto.getPreco().toString());
        BigDecimal preco = new BigDecimal(precoStr.replace(",", "."));

        produto.setNome(nome)
                .setDescricao(descricao)
                .setCategoria(categoria)
                .setPreco(preco);

        JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
    }

    public static void sucesso(Produto produto) {
        JOptionPane.showMessageDialog(null, "Produto " + produto.getNome() + " cadastrado com sucesso!");
    }

    public static void show(Produto produto) {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(produto.getId()).append("\n");
        sb.append("Nome: ").append(produto.getNome()).append("\n");
        sb.append("Descrição: ").append(produto.getDescricao()).append("\n");
        sb.append("Categoria: ").append(produto.getCategoria().getNome()).append("\n");
        sb.append("Preço: ").append(produto.getPreco()).append("\n");
        sb.append("Data de Cadastro: ").append(produto.getDataCadastro()).append("\n");
        JOptionPane.showMessageDialog(null, sb.toString(), "Detalhes do Produto", JOptionPane.INFORMATION_MESSAGE);
    }
}