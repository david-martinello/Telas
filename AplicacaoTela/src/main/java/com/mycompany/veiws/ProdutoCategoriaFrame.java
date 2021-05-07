/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.veiws;

import com.mycompany.controller.CategoriaController;
import com.mycompany.controller.ProdutoController;
import com.mycompany.controller.QuantidadeController;
import com.mycompany.modelo.Categoria;
import com.mycompany.modelo.Produto;
import com.mycompany.modelo.Quantidade;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david.pereira
 */
public class ProdutoCategoriaFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JLabel labelNome, labelDescricao, labelCategoria, labelQuantidade;
    private JTextField textoNome, textoDescricao, textQuantidade;
    private JComboBox<Categoria> comboCategoria;
    private JButton botaoSalvar, botaoEditar, botaoLimpar, botarApagar;
    private JTable tabela;
    private DefaultTableModel modelo;
    private ProdutoController produtoController;
    private CategoriaController categoriaController;
    private QuantidadeController quantidadeController;
   
    
    public ProdutoCategoriaFrame() {
        super("Produtos");
        Container container = getContentPane();
        setLayout(null);

        this.categoriaController = new CategoriaController();
        this.produtoController = new ProdutoController();

        labelNome = new JLabel("Nome do Produto");
        labelDescricao = new JLabel("Descrição do Produto");
        labelQuantidade = new JLabel("Quantidade");
        labelCategoria = new JLabel("Categoria do Produto");

        labelNome.setBounds(10, 10, 240, 15);
        labelDescricao.setBounds(10, 50, 240, 15);
        labelQuantidade.setBounds(10, 90, 240, 15);
        labelCategoria.setBounds(10, 130, 240, 15);

        labelNome.setForeground(Color.BLACK);
        labelDescricao.setForeground(Color.BLACK);
        labelQuantidade.setForeground(Color.BLACK);
        labelCategoria.setForeground(Color.BLACK);

        container.add(labelNome);
        container.add(labelDescricao);
        container.add(labelQuantidade);
        container.add(labelCategoria);

        textoNome = new JTextField();
        textoDescricao = new JTextField();
        textQuantidade = new JTextField();
        comboCategoria = new JComboBox<Categoria>();

        comboCategoria.addItem(new Categoria(0, "Selecione"));
        List<Categoria> categorias = this.listarCategoria();
        for (Categoria categoria : categorias) {
            comboCategoria.addItem(categoria);
        }

        textoNome.setBounds(10, 25, 265, 20);
        textoDescricao.setBounds(10, 65, 265, 20);
        textQuantidade.setBounds(10, 105, 265, 20);
        comboCategoria.setBounds(10, 145, 265, 20);

        container.add(textoNome);
        container.add(textoDescricao);
        container.add(textQuantidade);
        container.add(comboCategoria);

        botaoSalvar = new JButton("Salvar");
        botaoLimpar = new JButton("Limpar");

        botaoSalvar.setBounds(10, 185, 80, 20);
        botaoLimpar.setBounds(100, 185, 80, 20);

        container.add(botaoSalvar);
        container.add(botaoLimpar);

        tabela = new JTable();
        modelo = (DefaultTableModel) tabela.getModel();

        modelo.addColumn("Identificador do Produto");
        modelo.addColumn("Nome do Produto");
        modelo.addColumn("Descrição do Produto");

        preencherTabela();

        tabela.setBounds(10, 225, 760, 300);
        container.add(tabela);

        botarApagar = new JButton("Excluir");
        botaoEditar = new JButton("Alterar");

        botarApagar.setBounds(10, 550, 80, 20);
        botaoEditar.setBounds(100, 550, 80, 20);

        container.add(botarApagar);
        container.add(botaoEditar);

        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
                limparTabela();
                preencherTabela();
                
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        botarApagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletar();
                limparTabela();
                preencherTabela();
            }
        });

        botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterar();
                limparTabela();
                preencherTabela();
            }
        });
    }

    private void limparTabela() {
        modelo.getDataVector().clear();
    }

    private void alterar() {
        Object objetoDaLinha = (Object) modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
        if (objetoDaLinha instanceof Integer) {
            Integer id = (Integer) objetoDaLinha;
            String nome = (String) modelo.getValueAt(tabela.getSelectedRow(), 1);
            String descricao = (String) modelo.getValueAt(tabela.getSelectedRow(), 2);
            String quantidade = (String) modelo.getValueAt(tabela.getSelectedRow(), 3);
            this.produtoController.alterar(nome, descricao, id, quantidade);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
        }
    }

    private void deletar() {
        Object objetoDaLinha = (Object) modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
        if (objetoDaLinha instanceof Integer) {
            Integer id = (Integer) objetoDaLinha;
            this.produtoController.deletar(id);
            modelo.removeRow(tabela.getSelectedRow());
            JOptionPane.showMessageDialog(this, "Item excluido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
        }
    }

    private void preencherTabela() {
        List<Produto> produtos = listarProduto();
        try {
            for (Produto produto : produtos) {
                modelo.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getDescricao(), produto.getQuantidade()});
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private List<Categoria> listarCategoria() {
        return this.categoriaController.listar();
    }

    private void salvar() {
        if (!textoNome.getText().equals("") && !textoDescricao.getText().equals("") && !textQuantidade.getText().equals("")) {
            Produto produto = new Produto(textoNome.getText(), textoDescricao.getText());
            Quantidade quantidade = new Quantidade(textQuantidade.getText());
            Categoria categoria = (Categoria) comboCategoria.getSelectedItem();
            produto.setCategoriaId(categoria.getId());
            quantidade.setQuantidade(quantidade.getQuantidade());
            this.produtoController.salvar(produto);
            this.quantidadeController.salvar(produto);
            JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
            this.limpar();
        } else {
            JOptionPane.showMessageDialog(this, "Nome e Descrição devem ser informados.");
        }
    }

    private List<Produto> listarProduto() {
        return this.produtoController.listar();
    }

    private void limpar() {
        this.textoNome.setText("");
        this.textoDescricao.setText("");
        this.comboCategoria.setSelectedIndex(0);
        this.textQuantidade.setText("");
    }

}