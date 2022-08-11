package CamadaNegocios;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Estoque extends CtrDados {

  private double quantidade;
  private String validade;

  public Estoque() {
    quantidade = 0.0;
    validade = "";
  }

  public int getEstoque(int idcod) {
    cmd.chamarSQL(
      "SELECT SUM(Quantidade) FROM estoque " + "WHERE idProduto=" + idcod + ""
    );
    return cmd.getInt(cmd.executarSQL());
  }

  public void acrescentarEstoque(Vector est) {
    est.trimToSize();
    try {
      for (int i = 0; i < est.size(); i++) {
        cmd.chamarSQL(
          "UPDATE Estoque SET Quantidade=Quantidade+" +
          Double.parseDouble((String) est.get(i++)) +
          "WHERE idProduto=" +
          Integer.parseInt((String) est.get(i++)) +
          " AND Validade='" +
          (String) est.get(i) +
          "'"
        );
        cmd.inserirSQL();
      }
    } catch (NumberFormatException ex) {
      ex.printStackTrace();
    }
  }

  public void inserirEstoque(int codpro, double qtd, String vali) {
    quantidade = qtd;
    validade = vali;
    if (this.atualizarEstoque(codpro) == true) return;
    cmd.chamarSQL(
      "INSERT INTO Estoque VALUES(NULL," +
      qtd +
      "," +
      codpro +
      ",'" +
      vali +
      "')"
    );
    cmd.inserirSQL();
  }

  private boolean atualizarEstoque(int codpro) {
    Vector estoque = new Vector();
    cmd.chamarSQL(
      "SELECT * From Estoque WHERE idProduto=" +
      codpro +
      " AND Validade='" +
      validade +
      "'"
    );
    estoque = cmd.getArrayRegistros(cmd.executarSQL());
    estoque.trimToSize();
    if (estoque.capacity() == 0) return false;
    System.out.println(estoque.capacity());
    cmd.chamarSQL(
      "UPDATE ESTOQUE SET Quantidade=Quantidade+" +
      quantidade +
      " WHERE idProduto=" +
      codpro +
      " AND Validade='" +
      validade +
      "'"
    );
    cmd.inserirSQL();
    return true;
  }

  public void atualizarEstoque(int codpro, int qtd, String val) {
    Vector sets = new Vector();
    sets.addElement("Quantidade=Quantidade+" + qtd);
    sets.addElement("Validade='" + val + "'");
    cmd.atualizar("Estoque", sets, "idProduto=" + codpro);
    Logger.registrar(String.valueOf(codpro), "Estoque", "Alteração");
  }

  public void retirarEstoque(Vector est) {
    try {
      for (int i = 0; i < est.size(); i++) {
        cmd.chamarSQL(
          "UPDATE Estoque SET Quantidade=Quantidade-" +
          Double.parseDouble((String) est.get(i++)) +
          "WHERE idProduto=" +
          Integer.parseInt((String) est.get(i)) +
          "AND Validade='" +
          (String) est.get(i) +
          "'"
        );
        cmd.inserirSQL();
      }
    } catch (ArrayIndexOutOfBoundsException ex) {
      ex.printStackTrace();
    }
  }

  public void retirarEstoque(int idpro, double qtd, String val) {
    cmd.chamarSQL(
      "UPDATE Estoque SET Quantidade=Quantidade-" +
      qtd +
      " WHERE Validade='" +
      val +
      "' " +
      "AND idProduto=" +
      idpro
    );
    cmd.inserirSQL();

    cmd.chamarSQL("DELETE FROM Estoque WHERE Quantidade=0");
    cmd.inserirSQL();
  }

  public void cancelarEstoque(Vector est) {
    try {
      for (int i = 0; i < est.size(); i++) {
        cmd.chamarSQL(
          "UPDATE Estoque SET Quantidade=Quantidade-" +
          Double.parseDouble((String) est.get(i++)) +
          "WHERE idProduto=" +
          Integer.parseInt((String) est.get(i))
        );
        cmd.inserirSQL();
        Logger.registrar((String) est.get(i), "Estoque", "Atualização");
      }
    } catch (ArrayIndexOutOfBoundsException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * @param idcod - Código do produto
   * @param str - Data de Emissao
   * @return Vetor com produtos em determinada validade
   */
  public Vector getValidade(int idcod, String str) {
    try {
      Vector vali = new Vector();
      cmd.chamarSQL(
        "SELECT Validade FROM estoque " +
        "WHERE idProduto=" +
        idcod +
        " AND Validade > '" +
        str +
        "' " +
        "ORDER BY validade ASC"
      );
      vali = cmd.getArrayRegistros(cmd.executarSQL());
      return vali;
    } catch (Exception ex) {
      ex.printStackTrace();
      return null;
    }
  }

  /**
   * @param idcod Código do produto.
   * @param str Data de validade.
   * @return Quantidade de determinado produto em especificada validade.
   */
  public int getEstoquePorValidade(int idcod, String str) {
    cmd.chamarSQL(
      "SELECT Quantidade FROM estoque " +
      "WHERE Validade='" +
      str +
      "' AND idProduto='" +
      idcod +
      "' AND Quantidade > 0"
    );
    return cmd.getInt(cmd.executarSQL());
  }

  public Vector getEstoqueVal(int id) {
    Vector tmp = new Vector();
    Vector campo = new Vector();
    campo.addElement("Estoque.Quantidade");
    campo.addElement("Produto.Unidade");
    campo.addElement("Estoque.Validade");
    cmd.selecionar(
      campo,
      "Estoque INNER JOIN Produto ON Estoque.idProduto=Produto.idProduto",
      "Estoque.idProduto=" + id
    );
    try {
      tmp = cmd.selecionePorTabela(cmd.executarSQL());
    } catch (SQLException ex) {}
    if (tmp == null) {
      JOptionPane.showMessageDialog(null, "Não há estoque cadastrado.");
    }
    return tmp;
  }

  public void cadastrarID(int idProd) {
    Vector campo = new Vector();
    campo.addElement("");
    campo.addElement("0");
    campo.addElement(String.valueOf(idProd));
    campo.addElement("");
    cmd.inserir(campo, "Estoque");
  }

  public void destrutor() throws Throwable {
    this.finalize();
  }
}
