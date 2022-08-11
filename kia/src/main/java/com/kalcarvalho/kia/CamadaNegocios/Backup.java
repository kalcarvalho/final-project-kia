package CamadaNegocios;

import java.io.*;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Backup extends CtrDados {

  private String SO;

  public Backup() {}

  public Vector getOpcaoBackup() {
    Vector tmp = new Vector();
    cmd.selecionar("OpcaoBackup");
    return tmp = cmd.getFromRegistros(cmd.executarSQL(), 3);
  }

  public void setOpcaoBackup(Vector op) {
    Vector campo = new Vector();
    campo.addElement("Automatico");
    campo.addElement("SemBackup");
    cmd.atualizar("OpcaoBackup", campo, op);
    Logger.registrar("Op磯Backup", "OpcaoBackup", "Altera磯");
  }

  public void inserirOpcaoBackup(Vector dir) {
    System.out.println("vector origem e destino" + dir);
    cmd.inserir(dir, "OpcaoBackup");
    /**
     * par⭥tros: registro, tabela e a磯
     */
    Logger.registrar("Origem/Destino", "OpcaoBackup", "Atualiza磯");
  }

  public boolean validarDir(String origem, String destino) {
    File o = new File(origem);
    File d = new File(destino);
    if (!o.exists()) {
      JOptionPane.showMessageDialog(
        null,
        "Certifique-se que o banco de dados Distribuidora estᠮo caminho informado",
        "Diret󲩯 Origem Invᬩdo",
        JOptionPane.ERROR_MESSAGE
      );
      return false;
    }
    if (!d.exists()) {
      JOptionPane.showMessageDialog(
        null,
        "Certifique-se que existe o diret󲩯 especificado",
        "Diret󲩯 Destino Invᬩdo",
        JOptionPane.ERROR_MESSAGE
      );
      return false;
    }
    if (!origem.endsWith("Distribuidora")) {
      JOptionPane.showMessageDialog(
        null,
        "Certifique-se que o nome do banco de dados seja distribuidora",
        "Banco de Dados Invᬩdo",
        JOptionPane.ERROR_MESSAGE
      );
      return false;
    }
    return true;
  }

  public Vector formatarDir(String origem, String destino) {
    Vector dir = new Vector();
    dir.addElement("false");
    dir.addElement("true");
    dir.addElement("true");
    dir.addElement(this.formatarPath(origem));
    dir.addElement(this.formatarPath(destino));
    return dir;
  }

  public String getOrigem() {
    String o;
    Vector campo = new Vector();
    campo.addElement("origem");
    cmd.selecionar(campo, "OpcaoBackup");
    o = cmd.getRegistros(cmd.executarSQL());
    if (o == null) {
      JOptionPane.showMessageDialog(
        null,
        "Tabela OpcaoBackup Vazia.",
        "ERRO",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return o;
  }

  public String getDestino() {
    String o;
    Vector campo = new Vector();
    campo.addElement("destino");
    cmd.selecionar(campo, "OpcaoBackup");
    o = cmd.getRegistros(cmd.executarSQL());
    if (o == null) {
      JOptionPane.showMessageDialog(
        null,
        "Tabela OpcaoBackup Vazia.",
        "ERRO",
        JOptionPane.ERROR_MESSAGE
      );
    }
    return o;
  }

  public String formatarPath(String dir) {
    String o = "";
    int i = 0;
    while (i < dir.length()) {
      if (dir.indexOf('\\', i) != -1) {
        System.out.println("aqui");
        System.out.println("\n");
        o += dir.substring(i, (dir.indexOf('\\', i)) + 1);
        System.out.println("1" + o);
        o += "\\";
        System.out.println("2" + o);
        i = (dir.indexOf('\\', i)) + 1;
      } else break;
    }
    i = dir.lastIndexOf('\\', dir.length());
    o += dir.substring(i + 1, dir.length());
    return o;
  }

  public void copiar() {
    String origem = this.getOrigem();
    String destino = this.getDestino();
    destino += "\\bck.sql";
    JOptionPane.showMessageDialog(
      null,
      "<HTML><BODY>origem " + origem + " <BR>dest " + destino + "</BODY></HTML>"
    );
    Runtime run = Runtime.getRuntime();
    String cmd[] = new String[3];
    cmd[0] = "cmd.exe";
    cmd[1] = "\\D";
    cmd[2] = "gerarCopia.bat";

    try {
      //	Process process = run.exec("d:\\gerarCopia.bat");
      //	Process process = run.exec("D:\\gerarCopia.bat");
      //Process process = run.exec("C:\\mysql\\bin\\mysqldu --user=root --password=brancura distribuidora -F > D:backupBD.sql");
      Process process = run.exec("D:\\coles.xls");
      // 	 Process process = run.exec("D:\\Arquivos de programas\\Brasil 500\\BR_500.exe");
      System.out.println("ok");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public void removerOpcaoBackup() {
    cmd.remover("OpcaoBackup");
  }
}
