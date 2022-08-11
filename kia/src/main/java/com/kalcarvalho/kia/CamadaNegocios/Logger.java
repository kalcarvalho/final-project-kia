package CamadaNegocios;

import java.sql.SQLException;
import java.util.*;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Logger extends CtrDados {

  private static String matricula;
  private static Data dt;
  private String SO;
  private Backup bck;

  public Logger() {
    dt = new Data();
  }

  /**
   * método de inserir na tabela log
   * @param registro String contém a chave primária, caso a chave primária
   * seja incremental ele carrega uma função tipo MAX(, que deve ser
   * maíscula
   * @param tabela String tabela
   * @param acao String Inserção ou Remoção ou Alteração
   */
  public static void registrar(String registro, String tabela, String acao) {
    String max;
    Vector campo = new Vector();
    if (registro.startsWith("MAX(")) {
      campo.addElement(registro);
      cmd.selecionar(campo, tabela);
      max = String.valueOf(cmd.getInt(cmd.executarSQL()));
    } else {
      max = registro;
    }
    campo.removeAllElements();
    campo.addElement(""); //incremental
    campo.addElement(matricula);
    campo.addElement(dt.getCurrentDate("yyyy/MM/dd"));
    campo.addElement(dt.getCorrenteHora());
    campo.addElement(acao);
    campo.addElement(max);
    campo.addElement(tabela);
    cmd.inserir(campo, "Log");
    campo.removeAllElements();
    System.out.println(dt.getCorrenteHora());
  }

  public void setMat(String mat) {
    matricula = mat;
    System.out.println(matricula);
  }

  public String getMat() {
    return matricula;
  }

  public Vector gerarRelatorioLog() {
    Vector tmp = new Vector();
    Vector campo = new Vector();
    campo.addElement("Matricula");
    campo.addElement("Data");
    campo.addElement("Hora");
    campo.addElement("Acao");
    campo.addElement("Registro");
    campo.addElement("Tabela");
    cmd.selecionar(campo, "Log");
    try {
      tmp = cmd.selecionePorTabela(cmd.executarSQL());
    } catch (SQLException ex) {
      JOptionPane.showConfirmDialog(
        null,
        "Falha na linha 77 classe Logger",
        "Erro ao Executar SQL",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return tmp;
  }

  public Vector identificarPc() {
    bck = new Backup();
    Vector tmp = new Vector();
    String versaoBd;
    Properties p = System.getProperties();
    tmp.addElement(p.getProperty("os.name"));
    tmp.addElement(p.getProperty("java.runtime.name"));
    tmp.addElement(p.getProperty("java.vm.version"));
    tmp.addElement(p.getProperty("java.specification.vendor"));
    tmp.addElement(p.getProperty("user.name"));
    tmp.addElement(bck.getOrigem());
    tmp.addElement(bck.getDestino());
    tmp.addElement(p.getProperty("user.language"));
    tmp.addElement(p.getProperty("user.country"));
    tmp.addElement(super.getBd());
    cmd.statusBd("VERSION()");
    versaoBd = cmd.getRegistros(cmd.executarSQL());
    tmp.addElement(versaoBd);
    return tmp;
  }
}
