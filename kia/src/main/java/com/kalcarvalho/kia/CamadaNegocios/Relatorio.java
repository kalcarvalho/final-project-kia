package CamadaNegocios;

import CamadaApresentacao.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;

public class Relatorio extends CtrDados {

  private frRelatorioPreco frp;
  private frRelatorioEstoque fre;
  private frRelatorioClientes frc;
  private frRelatorioFornecedor frf;
  private frRelatorioContasaPagar frcp;

  public Relatorio() {}

  public void gerarRelatorioPreco() {
    Vector campo = new Vector();
    Vector table = new Vector();
    campo.addElement("Descricao");
    campo.addElement("Unidade");
    campo.addElement("PrecoVenda");
    cmd.selecionar(campo, "Produto");
    try {
      table = cmd.selecionePorTabela(cmd.executarSQL());
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    frp = new frRelatorioPreco(table);
  }

  public void gerarRelatorioEstoque() {
    Vector table = new Vector();
    Vector campo = new Vector();
    campo.addElement("Produto.Descricao");
    campo.addElement("Estoque.Quantidade");
    campo.addElement("Produto.Unidade");
    campo.addElement("Estoque.Validade");
    cmd.selecionar(
      campo,
      "Estoque INNER JOIN Produto ON Estoque.idProduto=Produto.idProduto"
    );
    try {
      table = cmd.selecionePorTabela(cmd.executarSQL());
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    if (table.isEmpty()) JOptionPane.showMessageDialog(
      null,
      "Não há estoque cadastrado."
    ); else fre = new frRelatorioEstoque(table);
  }

  public void gerarRelatorioClientes() {
    Vector table = new Vector();
    Vector campo = new Vector();
    campo.addElement("Cliente.CNPJ");
    campo.addElement("Cliente.RazaoSocial");
    campo.addElement("Fantasia");
    campo.addElement("Rua");
    campo.addElement("Bairro");
    campo.addElement("Cidade");
    campo.addElement("Estado");
    campo.addElement("Numero");
    cmd.selecionar(
      campo,
      "(Cliente INNER JOIN endCliente ON Cliente.cnpj=" +
      "endCliente.idCliente) INNER JOIN Endereco ON endCliente.idEndereco=Endereco.idEndereco"
    );
    try {
      table = cmd.selecionePorTabela(cmd.executarSQL());
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    if (table.isEmpty()) JOptionPane.showMessageDialog(
      null,
      "Não há Clientes Cadastrados."
    ); else frc = new frRelatorioClientes(table);
  }

  public void gerarRelatorioFornecedor() {
    Vector table = new Vector();
    Vector campo = new Vector();
    campo.addElement("Fornecedor.CNPJ");
    campo.addElement("Fornecedor.RazaoSocial");
    campo.addElement("Fantasia");
    campo.addElement("Rua");
    campo.addElement("Bairro");
    campo.addElement("Cidade");
    campo.addElement("Estado");
    campo.addElement("Numero");
    cmd.selecionar(
      campo,
      "(Fornecedor INNER JOIN endFornecedor ON Fornecedor.cnpj=" +
      "endFornecedor.idFornecedor) INNER JOIN Endereco ON endFornecedor.idEndereco=Endereco.idEndereco"
    );
    try {
      table = cmd.selecionePorTabela(cmd.executarSQL());
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    if (table.isEmpty()) JOptionPane.showMessageDialog(
      null,
      "Não há Fornecedores Cadastrados."
    ); else frf = new frRelatorioFornecedor(table);
  }

  public void gerarRelatorioContasaPagar() {
    Vector table = new Vector();
    Vector campo = new Vector();

    //selecionar conta
    try {
      table = cmd.selecionePorTabela(cmd.executarSQL());
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    if (table.isEmpty()) JOptionPane.showMessageDialog(
      null,
      "Não há Fornecedores Cadastrados."
    ); else frcp = new frRelatorioContasaPagar(table);
  }
}
