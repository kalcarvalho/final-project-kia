package CamadaNegocios;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Endereco extends CtrDados {

  private String tmp;

  public Endereco() {}

  public int getIdEndereco() {
    Vector tmp = new Vector();
    tmp.addElement("MAX(idEndereco)");
    cmd.selecionar(tmp, "Endereco");
    return cmd.getInt(cmd.executarSQL());
  }

  public String setEndereco(
    String rua,
    String bairro,
    String cidade,
    String estado,
    String cep,
    String numero,
    String Email,
    String cnpj,
    String tabela
  ) {
    String id;
    Vector campo = new Vector();

    //campo.addElement("count(*)");
    //cmd.selecionar(campo, "Endereco", "rua='"+rua+"' AND cidade='"+cidade+"'");
    //if(cmd.getInt(cmd.executarSQL()) == 0) {
    campo.addElement("");
    campo.addElement(rua);
    campo.addElement(bairro);
    campo.addElement(cidade);
    campo.addElement(estado);
    campo.addElement(cep);
    campo.addElement(numero);
    campo.addElement(Email);
    campo.addElement("");
    campo.addElement("");
    tmp = cnpj;
    cmd.inserir(campo, "Endereco");
    id = this.setAssociativa(tabela);
    //}
    return id;
  }

  /*   public String setLogradouro(String rua)
   {
      Vector campo = new Vector();
      Vector tmp = new Vector();
      String id;

      campo.addElement("");
      campo.addElement(rua);

      cmd.inserir(campo,"Logradouro");
      tmp.addElement("Max(idLogradouro)");
      cmd.selecionar(tmp,"Logradouro");
      id = (String) cmd.getFromRegistros(cmd.executarSQL(), 1).get(0);

      return  id;
   }*/

  public String setAssociativa(String tabela) {
    String id;
    Vector campo = new Vector();
    campo.addElement(String.valueOf(this.getIdEndereco()));
    id = (String) campo.get(0);
    campo.addElement(tmp);
    cmd.inserir(campo, tabela);
    return id;
  }

  public Vector getEndereco(String cnpj, String sql) {
    Vector tmp;
    cmd.chamarSQL(sql);
    tmp = cmd.getFromRegistros(cmd.executarSQL(), 8);
    if (tmp == null) {
      JOptionPane.showMessageDialog(null, "Não Existem Endereços Cadastrados.");
    }
    return tmp;
  }

  public void alterarEnd(
    int idEnd,
    String rua,
    String bairro,
    String cidade,
    String estado,
    String cep,
    String num,
    String email,
    int idRota
  ) {
    Vector campo = new Vector();
    Vector valor = new Vector();
    campo.addElement("rua");
    campo.addElement("bairro");
    campo.addElement("cidade");
    campo.addElement("estado");
    campo.addElement("cep");
    campo.addElement("numero");
    campo.addElement("Email");
    campo.addElement("idRota");
    valor.addElement(rua);
    valor.addElement(bairro);
    valor.addElement(cidade);
    valor.addElement(estado);
    valor.addElement(cep);
    valor.addElement(num);
    valor.addElement(email);
    valor.addElement(String.valueOf(idRota));
    cmd.atualizar("Endereco", campo, valor, "idEndereco='" + idEnd + "'");
  }

  /**
   * método que seleciona todas as cidades distintas da tabela endereco
   * @return Vector cidades distintas
   */
  public Vector getCidade() {
    Vector campo = new Vector();
    Vector cidades = new Vector();
    campo.addElement("DISTINCT Cidade");
    cmd.selecionar(campo, "Endereco");
    cidades = cmd.getArrayRegistros(cmd.executarSQL());
    if (cidades == null) {
      JOptionPane.showMessageDialog(null, "Não existem Endereços Cadastrados.");
    }
    return cidades;
  }

  /**
   * este método seta o campo praca da tabela endereco com o nome da praca
   * correspondente
   * @param praca String o nome da nova praca
   * @param cidade Vector nome da cidade
   */
  public void setPraca(String praca, Vector cidade) {
    Vector campo = new Vector();
    Vector valor = new Vector();
    campo.addElement("praca");
    valor.addElement(praca);
    for (int i = 0; i < cidade.size(); i++) {
      cmd.atualizar(
        "Endereco",
        campo,
        valor,
        "cidade='" + (String) cidade.get(i) + "'"
      );
      Logger.registrar((String) cidade.get(i), "Endereco", "Atualização praça");
    }
  }

  public Vector getRua(String cidade) {
    Vector campo = new Vector();
    Vector rua = new Vector();
    campo.addElement("DISTINCT rua");
    cmd.selecionar(campo, "Endereco", "cidade='" + cidade + "'");
    rua = cmd.getArrayRegistros(cmd.executarSQL());
    if (rua == null) {
      JOptionPane.showMessageDialog(null, "Não existem Endereços Cadastrados.");
    }
    return rua;
  }

  public Vector getId(String rua, String cidade) {
    Vector campo = new Vector();
    Vector id = new Vector();
    campo.addElement("Endereco.idEndereco");
    cmd.selecionar(
      campo,
      "(Cliente INNER JOIN endCliente ON Cliente.cnpj=" +
      "endCliente.idCliente) INNER JOIN Endereco ON endCliente.idEndereco=Endereco.idEndereco",
      "Endereco.rua='" + rua + "' AND cidade='" + cidade + "'"
    );
    id = cmd.getArrayRegistros(cmd.executarSQL());
    return id;
  }

  public void atualizar(int idrota, String idEnd) {
    Vector sets = new Vector();
    sets.addElement("idRota=" + idrota);
    cmd.atualizar("Endereco", sets, "idEndereco='" + idEnd + "'");
    Logger.registrar(idEnd, "Endereço", "Atualização idRota");
  }

  public void atualizarPraca(String pc, String id) {
    if (pc == null) return;
    Vector sets = new Vector();
    sets.addElement("praca='" + pc + "'");
    cmd.atualizar("Endereco", sets, "idEndereco='" + id + "'");
    Logger.registrar(pc, "Endereço", "Atualização Praça");
  }

  public Vector getPraca() {
    Vector campo = new Vector();
    Vector praca = new Vector();
    campo.addElement(" DISTINCT praca");
    cmd.selecionar(campo, "Endereco");
    praca = cmd.getArrayRegistros(cmd.executarSQL());
    if (praca == null) JOptionPane.showMessageDialog(
      null,
      "Não existem Praças Cadastradas."
    );
    return praca;
  }

  public Vector getPraca(String cidade) {
    Vector campo = new Vector();
    Vector praca = new Vector();
    campo.addElement("praca");
    cmd.selecionar(campo, "Endereco", "cidade='" + cidade + "'");
    cmd.selecionar(campo, "Endereco");
    praca = cmd.getArrayRegistros(cmd.executarSQL());
    return praca;
  }

  public void destrutor() throws Throwable {
    this.finalize();
  }
}
