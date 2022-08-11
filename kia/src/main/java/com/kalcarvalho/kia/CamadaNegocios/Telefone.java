package CamadaNegocios;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Telefone extends CtrDados {

  private String telefone;
  private String fax;
  private String tmp;

  public Telefone() {}

  public void setTelefone(String t, String f, String cnpj, String tabela) {
    Vector campo = new Vector();
    telefone = t;
    fax = f;
    campo.addElement(telefone);
    campo.addElement(fax);
    cmd.inserir(campo, "Telefone");
    tmp = cnpj;
    this.setAssociativa(tabela);
  }

  public String getTel() {
    return telefone;
  }

  public String getFax() {
    return fax;
  }

  public void setAssociativa(String tabela) {
    Vector campo = new Vector();
    campo.addElement(this.getTel());
    campo.addElement(tmp);
    cmd.inserir(campo, tabela);
  }

  public Vector getTelefone(String sql) {
    Vector tmp;
    cmd.chamarSQL(sql);
    //o 2º parametro é o numero de campos nas tabelas
    tmp = cmd.getFromRegistros(cmd.executarSQL(), 2);
    if (tmp == null) {
      JOptionPane.showMessageDialog(null, "Não Existem Telefones Cadastrados.");
    }
    return tmp;
  }

  public void alterarTel(String idTel, String tel, String fax, String tabela) {
    Vector sets = new Vector();
    telefone = tel;
    this.fax = fax;
    sets.addElement("tel='" + telefone + "'");
    sets.addElement("fax='" + this.fax + "'");
    cmd.atualizar("Telefone", sets, "tel='" + idTel + "'");
    this.alterarAssociativa(tabela, idTel);
  }

  //rever esse método, acho que da pra fazer direto, como o remover
  public void alterarAssociativa(String tabela, String id) {
    Vector sets = new Vector();
    sets.addElement("idTelefone='" + telefone + "'");
    cmd.atualizar(tabela, sets, "idTelefone='" + id + "'");
  }

  public void removerTel(String cnpj, String sql) {
    cmd.chamarSQL(sql);
    cmd.inserirSQL();
  }

  public void destrutor() throws Throwable {
    this.finalize();
  }
}
