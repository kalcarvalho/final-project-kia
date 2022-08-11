package CamadaDados;

import CamadaNegocios.Data;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class CamadaDados extends JFrame {

  private JTable tab;
  private String instancia;
  private String url;
  private String usuario;
  private String senha;
  private Connection con;
  private static Statement stmt;
  private static String query;
  private static boolean statusConex = false;
  private static ResultSet rs;
  private Data dt;

  public CamadaDados() {
    dt = new Data();
  }

  public void criarInstancia(String strBD) {
    instancia = strBD;
    try {
      if (instancia == "mysql") Class.forName(
        "com.mysql.jdbc.Driver"
      ); else Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    } catch (ClassNotFoundException ex) {
      String msg;
      msg = ex.getMessage();
      JOptionPane.showMessageDialog(
        null,
        "Falha ao criar instancia.\nErro: " + msg
      );
      ex.printStackTrace();
    }
  }

  public void getUserPassword(String u, String s) {
    usuario = u;
    senha = s;
  }

  public void especificarBD() {
    //if(instancia == "mysql") url = "jdbc:mysql://127.0.0.1/distribuidora";
    //"jdbc:mysql://127.0.0.1/Distribuidora?user="+usuario+"&password="+senha;
    url = "jdbc:odbc:Distribuidora";
    this.abrirConexaoODBC();
  }

  public void especificarBD(String u) {
    url = u;
    this.abrirConexao();
  }

  public void abrirConexao() {
    try {
      con = DriverManager.getConnection(url);
      statusConex = true;
    } catch (SQLException ex) {
      String msg;
      msg = ex.getMessage();
      JOptionPane.showMessageDialog(
        null,
        "Falha ao abrir conexao com o Banco de Dados.\nErro: " + msg
      );
      ex.printStackTrace();
      statusConex = false;
    }
  }

  public void abrirConexaoODBC() {
    try {
      con = DriverManager.getConnection(url, usuario, senha);
      statusConex = true;
    } catch (SQLException ex) {
      String msg;
      msg = ex.getMessage();
      JOptionPane.showMessageDialog(
        null,
        "Falha ao abrir conexao com o Banco de Dados.\nErro: " + msg
      );
      ex.printStackTrace();
      statusConex = false;
      return;
    }
  }

  public void fecharConexao() {
    try {
      con.close();
      stmt.close();
      statusConex = false;
    } catch (SQLException ex) {
      String msg = ex.getMessage();
      JOptionPane.showMessageDialog(
        null,
        "Falha ao fechar conexao com o Banco de Dados.\nErro: " + msg
      );
    }
  }

  public static boolean getStatusConexao() {
    return (statusConex);
  }

  public void prepararSQL() {
    try {
      stmt = con.createStatement();
    } catch (SQLException ex) {
      String msg = ex.getMessage();
      JOptionPane.showMessageDialog(
        null,
        "Falha ao preparar consulta.\nErro: " + msg
      );
    }
  }

  public void chamarSQL(String QueryUrl) {
    query = QueryUrl;
  }

  public static ResultSet executarSQL() {
    if (query != null) {
      try {
        rs = stmt.executeQuery(query);
      } catch (SQLException ex) {
        String msg = ex.getMessage();
        JOptionPane.showMessageDialog(
          null,
          "Falha ao executar uma consulta.\nErro: " + msg
        );
      }
    }
    return (rs);
  }

  public static ResultSet inserirSQL() {
    if (query != null) {
      try {
        stmt.executeUpdate(query);
      } catch (SQLException ex) {
        String msg = ex.getMessage();
        JOptionPane.showMessageDialog(
          null,
          "Falha ao executar uma inserção.\nErro: " + msg
        );
      }
    }
    return (rs);
  }

  public static Vector getArrayRegistros(ResultSet res) {
    //    int tam;
    Vector Registro = new Vector(); //JAVA NAO PASSA ARRAY POR VALOR
    rs = res; //SÓ POR REFERÊNCIA, lembrar de DESTRUIR DEPOIS
    try {
      int i = 0;
      while (rs.next()) {
        Registro.addElement(rs.getString(1));
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        ex.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    } catch (NullPointerException nu) {
      nu.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        nu.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return Registro;
  }

  public static String getRegistros(ResultSet res) {
    String Registro = "";
    rs = res;
    try {
      while (rs.next()) {
        Registro = rs.getString(1);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        ex.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    } catch (NullPointerException nu) {
      nu.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        nu.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return Registro;
  }

  public static int getInt(ResultSet res) {
    int Registro = 0;
    rs = res;
    try {
      while (rs.next()) {
        Registro = rs.getInt(1);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        ex.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    } catch (NullPointerException nu) {
      nu.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        nu.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return Registro;
  }

  public static double getDouble(ResultSet res) {
    double Registro = 0;
    rs = res;
    try {
      while (rs.next()) {
        Registro = rs.getDouble(1);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        ex.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    } catch (NullPointerException nu) {
      nu.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        nu.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return Registro;
  }

  public static Vector getVetorColunas(ResultSet rsCols) {
    Vector Colunas = new Vector();
    ResultSetMetaData rsmCols;

    try {
      rsmCols = rsCols.getMetaData();
      for (int i = 1; i <= rsmCols.getColumnCount(); ++i) Colunas.addElement(
        rsmCols.getColumnName(i)
      );
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        ex.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    }

    return (Colunas);
  }

  public static Vector getVetorRegistroAtual(ResultSet rsReg) {
    rs = rsReg;
    Vector Registro = new Vector();
    ResultSetMetaData rsmReg;
    try {
      rsmReg = rs.getMetaData();
      for (int i = 1; i <= rsmReg.getColumnCount(); ++i) {
        switch (rsmReg.getColumnType(i)) {
          case Types.VARCHAR:
            Registro.addElement(rs.getString(i));
            break;
          case Types.DOUBLE:
            Registro.addElement(rs.getString(i));
            break;
          case Types.INTEGER:
            Registro.addElement(new Long(rs.getLong(i)));
            break;
          default:
            Registro.addElement(rs.getString(i));
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        ex.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return (Registro);
  }

  public static Vector getVetorRegistros(ResultSet rsRegs) {
    Vector Registros = new Vector();
    rs = rsRegs;
    try {
      for (int i = 0;; i++) {
        Registros.addElement(rs.getString(1)); //i  ??? 1 ok
        if (rs.isLast()) break;
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        ex.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return (Registros);
  }

  private Vector getProxLinha(ResultSet res, ResultSetMetaData rsmd)
    throws SQLException {
    rs = res;
    Vector linhaAtual = new Vector();
    String dat = new String();

    for (int i = 1; i <= rsmd.getColumnCount(); ++i) switch (
      rsmd.getColumnType(i)
    ) {
      case Types.VARCHAR:
        linhaAtual.addElement(rs.getString(i));
        break;
      case Types.DATE:
        dat = dt.parseDateInterface("dd/MM/yyyy", rs.getDate(i));
        linhaAtual.addElement(dat);
        break;
      //mudar para getTime
      case Types.TIME:
        linhaAtual.addElement(rs.getTime(i));
        break;
      case Types.INTEGER:
        linhaAtual.addElement(new Long(rs.getLong(i)));
        break;
      case Types.DOUBLE:
        linhaAtual.addElement(new Double(rs.getDouble(i)));
        break;
      default:
        System.out.println("Tipo de dados: " + rsmd.getColumnTypeName(i));
    }

    return linhaAtual;
  }

  public Vector selecionePorTabela(ResultSet res) throws SQLException {
    Vector table = new Vector();
    Vector linha = new Vector();
    Vector nomeCampo = new Vector();
    rs = res;
    boolean maisRegistros = rs.next();
    if (!maisRegistros) return table;
    try {
      ResultSetMetaData rsmd = rs.getMetaData();
      for (int i = 1; i <= rsmd.getColumnCount(); ++i) nomeCampo.addElement(
        rsmd.getColumnName(i)
      );
      do {
        linha.addElement(getProxLinha(rs, rsmd));
      } while (rs.next());
    } catch (SQLException sqlex) {
      sqlex.printStackTrace();
    }
    table.add(linha);
    table.add(nomeCampo);
    return table;
  }

  public Vector SelectFrom(ResultSet res) {
    Vector tmp = new Vector();
    rs = res;
    /** posição do primeiro registro*/
    boolean maisRegistros = false;
    try {
      maisRegistros = rs.next();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Vazio");
    }

    /** If there are no records, display a message*/
    if (!maisRegistros) {
      JOptionPane.showMessageDialog(null, "Nenhum Dado Cadastrado");
      return tmp;
    }

    Vector nomeCampo = new Vector();
    Vector linha = new Vector();

    try {
      // get column heads
      ResultSetMetaData rsmd = rs.getMetaData();

      for (int i = 1; i <= rsmd.getColumnCount(); ++i) nomeCampo.addElement(
        rsmd.getColumnName(i)
      );

      // get row data
      do {
        linha.addElement(getProxLinha(rs, rsmd));
      } while (rs.next());
    } catch (SQLException sqlex) {
      sqlex.printStackTrace();
    }
    return linha;
  }

  public static Vector getFromRegistros(ResultSet res, int numCampos) {
    Vector Registro = new Vector(); //JAVA NAO PASSA ARRAY POR VALOR
    rs = res; //SÓ POR REFERÊNCIA, lembrar de DESTRUIR DEPOIS
    try {
      while (rs.next()) {
        for (int i = 1; i <= numCampos; i++) Registro.addElement(
          rs.getString(i)
        );
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        ex.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    } catch (NullPointerException nu) {
      nu.printStackTrace();
      JOptionPane.showMessageDialog(
        null,
        nu.getMessage(),
        "Acesso a Dados",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return Registro;
  }

  //MÉTODOS REFEITOS MAIS ABAIXO
  //REMOVER SÓ DEPOIS QUE ATUALIZAR A CAMADA DE NEGÓCIOS

  /**
   * método genérico de inserção de dados na tabela
   * @param campo Vector carregado com os valores a serem inseridos
   * @param tabela String nome da tabela
   */
  public void G_inserir(Vector campo, String tabela) {
    String sql = "INSERT INTO " + tabela + " VALUES('" + campo.get(0) + "'";
    for (int i = 1; i < campo.size(); i++) sql += ",'" + campo.get(i) + "'";
    sql += ")";
    this.chamarSQL(sql);
    this.inserirSQL();
  }

  /**
   * método SELECT genérico para uma tabela, sem condições WHERE
   * @param campo Vector carregado com os campos a serem selecionados
   * @param tabela String tabela do bd
   * @return String
   */
  public String G_select(Vector campo, String tabela) {
    String sql = "SELECT " + campo.get(0);
    for (int i = 1; i < campo.size(); i++) sql += "," + campo.get(i);
    sql += " FROM " + tabela;
    return sql;
  }

  /**
   * método SELECT genérico para uma tabela, com condições WHERE e
   * com seleção de todos os campos = *
   * esse método é sobrecarregado, prestar atenção nos atributos
   * @param tabela String tabela do bd
   * @param clau1 String variável com o campo de condição da tabela
   * @param clau2 String varíavel com o valor a se verificado no campo
   * @return String sql
   */
  public String G_select(String tabela, String clau1, String clau2) {
    String sql =
      "SELECT * FROM " + tabela + " WHERE " + clau1 + "='" + clau2 + "'";
    return sql;
  }

  /**
   * método SELECT genérico para uma tabela, com 2 condições WHERE
   * esse método é sobrecarregado, prestar atenção nos atributos
   * @param campos Vector carreagado com os campos a serem selecionados
   * @param tabela String nome da tabela
   * @param clau1 String variável com o campo de condição da tabela da 1º
   * condição WHERE
   * @param clau2 String varíavel com o valor a se verificado no campo da 1º
   * clausula WHERE
   * @param clau3 String variável com o campo de condição da tabela da 2º
   * condição WHERE
   * @param clau4 String varíavel com o valor a se verificado no campo da 2º
   * clausula WHERE
   * @return String sql
   */
  public String G_select(
    Vector campos,
    String tabela,
    String clau1,
    String clau2,
    String clau3,
    String clau4
  ) {
    String sql = "SELECT " + campos.get(0);
    for (int i = 1; i < campos.size(); i++) sql += "," + campos.get(i);
    sql += " FROM " + tabela;
    sql += " WHERE " + clau1 + "='" + clau2 + "'";
    sql += " AND " + clau3 + "='" + clau4 + "'";
    return sql;
  }

  /**
   * método SELECT genérico para 3 tabelas
   * @param campos Vector carreagado com os campos a serem selecionados
   * @param tab1 String nome da 1º tabela
   * @param tab2 String nome da tabela associativa
   * @param tab3 String tabela 3
   * @param clau1 String variável com o campo de condição da tabela da tabela
   * @param clau2 String varíavel com o valor a se verificado no campo da tabela
   * @param keytab1 String chave primária da tabela1
   * @param keytab3 String chave primaria da tabela2
   * @param assoc1 String campo da associativa que faz referência a tabela1
   * @param assoc2 String campo da associativa que faz referência a tabela2
   * @return String sql
   */
  public String G_select(
    Vector campos,
    String tab1,
    String tab2,
    String tab3,
    String clau1,
    String clau2,
    String keytab1,
    String keytab3,
    String assoc1,
    String assoc2
  ) {
    String sql = "SELECT " + campos.get(0);
    for (int i = 1; i < campos.size(); i++) sql += "," + campos.get(i);
    sql += " FROM (" + tab1 + " INNER JOIN " + tab2 + " ON ";
    sql += tab1 + "." + keytab1 + "=" + tab2 + "." + assoc1 + ")";
    sql +=
      " INNER JOIN " + tab3 + " ON " + tab2 + "." + assoc2 + "=" + tab3 + ".";
    sql += keytab3 + " WHERE " + clau1 + "='" + clau2 + "'";
    return sql;
  }

  /**
   * método SELECT genérico para 3 tabelas, com 2 condições WHERE,
   * OBS. A tabela que vc considerar sendo a numero1, será a tabela
   * a ser selecionada os dados, caso vc queira selecionar dados de mais de uma
   * tabela terá que usar outro método
   * @param campos Vector carreagado com os campos a serem selecionados
   * @param tab1 String nome da 1º tabela
   * @param tab2 String nome da tabela associativa
   * @param tab3 String tabela 3
   * @param clau1 String variável com o campo de condição da tabela da 1º
   * condição WHERE
   * @param clau2 String varíavel com o valor a se verificado no campo da 1º
   * clausula WHERE
   * @param keytab1 String chave primária da tabela1
   * @param keytab3 String chave primaria da tabela2
   * @param assoc1 String campo da associativa que faz referência a tabela1
   * @param assoc2 String campo da associativa que faz referência a tabela2
   * @param clau3 String variável com o campo de condição da tabela da 2º
   * condição WHERE
   * @param clau4 String varíavel com o valor a se verificado no campo da 1º
   * clausula WHERE
   * @return String sql
   */
  public String G_select(
    Vector campos,
    String tab1,
    String tab2,
    String tab3,
    String clau1,
    String clau2,
    String keytab1,
    String keytab3,
    String assoc1,
    String assoc2,
    String clau3,
    String clau4
  ) {
    String sql = "SELECT " + tab1 + "." + campos.get(0);
    for (int i = 1; i < campos.size(); i++) sql +=
      "," + tab1 + "." + campos.get(i);
    sql += " FROM (" + tab1 + " INNER JOIN " + tab2 + " ON ";
    sql += tab1 + "." + keytab1 + "=" + tab2 + "." + assoc1 + ")";
    sql +=
      " INNER JOIN " + tab3 + " ON " + tab2 + "." + assoc2 + "=" + tab3 + ".";
    sql += keytab3 + " WHERE " + clau1 + "='" + clau2 + "'";
    sql += " AND " + clau3 + "='" + clau4 + "'";
    System.out.println(sql);
    return sql;
  }

  /**
   * método UPDATE genérico
   * @param tabela String nome da tabela
   * @param campo Vector carregado com nomes dos campos da tabela
   * @param valor Vector carregado com os valores a serem inseridos nos campos
   * @param clau1 String variável com o campo de condição da tabela
   * @param clau2 String varíavel com o valor a se verificado no campo
   */
  public void G_update(
    String tabela,
    Vector campo,
    Vector valor,
    String clau1,
    String clau2
  ) {
    String sql =
      "UPDATE " + tabela + " SET " + campo.get(0) + "='" + valor.get(0) + "'";
    for (int i = 1; i < campo.size(); i++) sql +=
      "," + campo.get(i) + "='" + valor.get(i) + "'";
    sql += " WHERE " + clau1 + "='" + clau2 + "'";
    this.chamarSQL(sql);
    this.inserirSQL();
  }

  /**
   * método delete genérico
   * @param tabela String nome da tabela
   * @param clau1 String variável com o campo de condição da tabela
   * @param clau2 String varíavel com o valor a se verificado no campo
   */

  public void G_delete(String tabela, String clau1, String clau2) {
    String sql =
      "DELETE FROM " + tabela + " WHERE " + clau1 + "='" + clau2 + "'";
    this.chamarSQL(sql);
    this.inserirSQL();
  }

  //REFACTORING
  //AQUI COMEÇA OS MÉTODOS GENÉRICOS DE QUERYS

  /**
   * método SELECT genérico
   * @param campo Vector carregado com os campos a serem selecionados
   * @param tabela String tabela ou tabelas do bd já com INNER JOIN
   * @return String sql
   */
  public void selecionar(Vector campo, String tabela) {
    String sql = "SELECT " + campo.get(0);
    for (int i = 1; i < campo.size(); i++) sql += "," + campo.get(i);
    sql += " FROM " + tabela;
    this.chamarSQL(sql);
  }

  /**
   * método Select Genérico com seleção de toda a tabela
   * @param tabela String nome da tabela
   * @return String sql
   */
  public void selecionar(String tabela) {
    String sql = "SELECT * FROM " + tabela;
    this.chamarSQL(sql);
  }

  /**
   * método Select Genérico com seleção de toda a tabela com clausula Where
   * @param tabela String nome da tabela
   * @param cond String condiçãso Where
   * @return String sql
   */
  public void selecionar(String tabela, String cond) {
    String sql = "SELECT * FROM " + tabela;
    sql += " WHERE " + cond;
    System.out.println(sql);
    this.chamarSQL(sql);
  }

  /**
   * método SELECT genérico com condição WHERE
   * @param campo Vector carregado com os campos a serem selecionados
   * @param tabela String tabela ou tabelas do bd já com INNER JOIN
   * @param cond String condiçao WHERE
   * @return String sql
   */
  public void selecionar(Vector campo, String tabela, String cond) {
    String sql = "SELECT " + campo.get(0);
    for (int i = 1; i < campo.size(); i++) sql += "," + campo.get(i);
    sql += " FROM " + tabela;
    sql += " WHERE " + cond;
    System.out.println(sql);
    this.chamarSQL(sql);
  }

  /**
   * método genérico de inserção de dados na tabela
   * @param campo Vector carregado com os valores a serem inseridos
   * @param tabela String nome da tabela
   */
  public void inserir(Vector campo, String tabela) {
    String sql = "INSERT INTO " + tabela + " VALUES('" + campo.get(0) + "'";
    for (int i = 1; i < campo.size(); i++) sql += ",'" + campo.get(i) + "'";
    sql += ")";
    System.out.println(sql);
    this.chamarSQL(sql);
    this.inserirSQL();
  }

  /**
   * método genérico de alteração
   * @param tabela String tabela(s) já com INNER JOIN se for o caso
   * @param campo Vector campos a serem atualizados
   * @param valor Vector valores a serem inseridos nos campos
   * @param cond String condição WHERE
   */
  public void atualizar(
    String tabela,
    Vector campo,
    Vector valor,
    String cond
  ) {
    String sql =
      "UPDATE " + tabela + " SET " + campo.get(0) + "='" + valor.get(0) + "'";
    for (int i = 1; i < campo.size(); i++) sql +=
      "," + campo.get(i) + "='" + valor.get(i) + "'";
    sql += " WHERE " + cond;
    System.out.println(sql);
    this.chamarSQL(sql);
    this.inserirSQL();
  }

  /**
   * método genérico de alteração sem condicao WHERE
   * @param tabela String tabela(s) já com INNER JOIN se for o caso
   * @param campo Vector campos a serem atualizados
   * @param valor Vector valores a serem inseridos nos campos
   */
  public void atualizar(String tabela, Vector campo, Vector valor) {
    String sql =
      "UPDATE " + tabela + " SET " + campo.get(0) + "='" + valor.get(0) + "'";
    for (int i = 1; i < campo.size(); i++) sql +=
      "," + campo.get(i) + "='" + valor.get(i) + "'";
    System.out.println(sql);
    this.chamarSQL(sql);
    this.inserirSQL();
  }

  /**
   * método genérico de inserção com clausula SET já montada
   * @param tabela String tabela(s) já com INNER JOIN se for o caso
   * @param sets Vector a clausula SET já montada
   * @param cond String condição WHERE
   */
  public void atualizar(String tabela, Vector sets, String cond) {
    String sql = "UPDATE " + tabela + " SET " + sets.get(0);
    for (int i = 1; i < sets.size(); i++) sql += "," + sets.get(i);
    sql += " WHERE " + cond;
    System.out.println(sql);
    this.chamarSQL(sql);
    this.inserirSQL();
  }

  /**
   * método genérico de remoção
   * @param tabela String nome da tabela
   * @param cond String condição WHERE
   */
  public void remover(String tabela, String cond) {
    String sql = "DELETE FROM " + tabela + " WHERE " + cond;
    System.out.println(sql);
    this.chamarSQL(sql);
    this.inserirSQL();
  }

  /**
   * método genérico de remoção - remove todos os dados da tabela
   * @param tabela String nome da tabela
   */
  public void remover(String tabela) {
    String sql = "DELETE FROM " + tabela;
    System.out.println(sql);
    this.chamarSQL(sql);
    this.inserirSQL();
  }

  public void statusBd(String comando) {
    String sql = "SELECT " + comando;
    this.chamarSQL(sql);
  }
}
