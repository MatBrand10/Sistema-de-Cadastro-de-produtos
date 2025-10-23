package br.com.fiap.nano.produtos.view;

import javax.swing.*;
import br.com.fiap.nano.produtos.model.Categoria;
import br.com.fiap.nano.produtos.repository.CategoriaCollectionRepository;

public class CategoriaView {

    public static Categoria select(Categoria categoria) {
        Categoria ret = (Categoria) JOptionPane.showInputDialog(
                null, "Selecione uma categoria", "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                CategoriaCollectionRepository.findAll().toArray(),
                categoria == null ? 1 : categoria);
        return ret;
    }

    public static Categoria form() {
        String nome = JOptionPane.showInputDialog("Informe o nome da Categoria");
        return new Categoria(nome);
    }

    public void sucesso() {
        JOptionPane.showMessageDialog(null, "Categoria salva com sucesso!");
    }

    public void sucesso(Categoria categoria) {
        JOptionPane.showMessageDialog(null,
                "Categoria " + categoria.getNome().toUpperCase() + " salva com sucesso!");
    }
}