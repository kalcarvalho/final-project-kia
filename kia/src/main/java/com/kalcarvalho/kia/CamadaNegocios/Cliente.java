package CamadaNegocios;

import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Cliente extends CtrDados {

  private String cnpj;
  private String razaoSocial;
  private String inscEstadual;
  private String fantasia;
  private Endereco end;
  private Telefone tele;

  public Cliente() {
    end = new Endereco();
    tele = new Telefone();
  }

  public String inserirEndereco(
    String rua,
    String bairro,
    String cidade,
    String estado,
    String cep,
    String numero,
    String Email,
    String cnpj
  ) {
    return end.setEndereco(
      rua,
      bairro,
      cidade,
      estado,
      cep,
      numero,
      Email,
      cnpj,
      "endCliente"
    );
  }

  public void inserirTelefone(String t, String f, String cnpj) {
    tele.setTelefone(t, f, cnpj, "telCliente");
  }

  public void cadastrar(
    String cnp,
    String razaosoc,
    String inscest,
    String fant
  ) {
    Vector tmp = new Vector();
    tmp.addElement(cnp);
    tmp.addElement(razaosoc);
    tmp.addElement(inscest);
    tmp.addElement(fant);
    cmd.inserir(tmp, "Cliente");
    Logger.registrar(cnp, "Cliente/End/Tel", "Inserção");
  }

  public Vector getCliente() {
    Vector tmp;
    Vector tmp2 = new Vector();
    tmp2.addElement("razaoSocial");
    cmd.selecionar(tmp2, "Cliente");
    tmp = cmd.getArrayRegistros(cmd.executarSQL());
    if (tmp == null) {
      JOptionPane.showMessageDialog(null, "Não Existem Clientes Cadastrados.");
    }
    return tmp;
  }

  public String getCliente(String str) {
    String id = str;
    Vector tmp = new Vector();
    tmp.addElement("cnpj");
    cmd.selecionar(tmp, "Cliente", "razaoSocial='" + id + "'");
    cnpj = cmd.getRegistros(cmd.executarSQL());
    if (cnpj == null) {
      JOptionPane.showMessageDialog(null, "Não Existem Clientes Cadastrados.");
    }
    return cnpj;
  }

  public Vector preencherTelaCliente(String cnpj) {
    Vector tmp;
    Vector campo = new Vector();
    campo.addElement("cnpj");
    campo.addElement("razaoSocial");
    campo.addElement("inscEstadual");
    campo.addElement("fantasia");
    cmd.selecionar(campo, "Cliente", "cnpj='" + cnpj + "'");
    //o 2º parametro é o numero de campos na tabela
    tmp = cmd.getFromRegistros(cmd.executarSQL(), 4);
    if (tmp == null) {
      JOptionPane.showMessageDialog(null, "Não Existem Clientes Cadastrados.");
    }
    return tmp;
  }

  public Vector preencherTelaEnd(String cnpj) {
    return end.getEndereco(
      cnpj,
      "SELECT Endereco.idEndereco,rua, bairro, cidade, estado, cep, numero, Email FROM (Cliente INNER JOIN endCliente ON Cliente.cnpj=endCliente.idCliente) INNER JOIN Endereco ON endCliente.idEndereco=Endereco.idEndereco WHERE CNPJ='" +
      cnpj +
      "'"
    );
  }

  public Vector preencherTelaTel(String cnpj) {
    return tele.getTelefone(
      "SELECT Tel, Fax FROM (Cliente INNER JOIN telCliente ON Cliente.cnpj=telCliente.idCliente) INNER JOIN Telefone ON telCliente.idTelefone=Telefone.tel WHERE CNPJ='" +
      cnpj +
      "'"
    );
  }

  public void alterarCliente(
    String cnpj,
    String razaoSocial,
    String inscEstadual,
    String fantasia
  ) {
    Vector campo = new Vector();
    Vector valor = new Vector();
    campo.addElement("razaosocial");
    campo.addElement("inscestadual");
    campo.addElement("fantasia");
    valor.addElement(razaoSocial);
    valor.addElement(inscEstadual);
    valor.addElement(fantasia);
    cmd.atualizar("Cliente", campo, valor, "cnpj='" + cnpj + "'");
    Logger.registrar(cnpj, "Cliente/End/Tel", "Alteração");
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
    int idrota
  ) {
    end.alterarEnd(idEnd, rua, bairro, cidade, estado, cep, num, email, idrota);
  }

  public void alterarTel(String idTel, String tel, String fax) {
    tele.alterarTel(idTel, tel, fax, "telCliente");
  }

  public void removerCliente(String cnpj) {
    tele.removerTel(
      cnpj,
      "DELETE Telefone.*,telCliente.* FROM (Cliente INNER JOIN telCliente ON Cliente.cnpj=telCliente.idCliente) INNER JOIN Telefone ON telCliente.idTelefone=Telefone.tel WHERE cnpj='" +
      cnpj +
      "'"
    );
    cmd.remover("Cliente", "cnpj='" + cnpj + "'");
    Logger.registrar(cnpj, "Cliente", "Remoção");
  }

  public String getRazaoSocial(String str) {
    Vector tmp = new Vector();
    tmp.addElement("razaosocial");
    cmd.selecionar(tmp, "Cliente", "cnpj='" + str + "'");
    razaoSocial = cmd.getRegistros(cmd.executarSQL());
    if (razaoSocial == null) {
      JOptionPane.showMessageDialog(null, "Não Existem Clientes Cadastrados.");
    }
    return razaoSocial;
  }

  public Vector getCidades() {
    return end.getCidade();
  }

  public void atualizar(int idrota, String idEnd) {
    end.atualizar(idrota, idEnd);
  }

  public Vector selecionarPraca(String cidade) {
    return end.getPraca(cidade);
  }

  public void atualizarPraca(String praca, String idEnd) {
    end.atualizarPraca(praca, idEnd);
  }

  public Vector getRua(String cid) {
    return end.getRua(cid);
  }

  public Vector getId(String rua, String cidade) {
    return end.getId(rua, cidade);
  }

  public Vector getPracas() {
    return end.getPraca();
  }

  /**
   * método para selecionar os enderecos(rua) e idEnd dos clientes com venda em
   * aberto de acordo com a praca selecionada
   * @param praca String nome da praca
   * @return Vector com idEnd e rua
   */
  public Vector getVendaAberto(String praca) {
    String claus;
    Vector VidEnd = new Vector();
    Vector Vrua = new Vector();
    Vector campo = new Vector();
    Vector tmp = new Vector();

    if (praca.equalsIgnoreCase("Todas")) claus =
      "Venda.statusRota=0"; else claus =
      "Endereco.praca='" + praca + "' AND Venda.statusRota=0";
    campo.addElement("DISTINCT Endereco.idEndereco");

    cmd.selecionar(
      campo,
      "((Cliente INNER JOIN endCliente ON Cliente.cnpj=" +
      "endCliente.idCliente) INNER JOIN Endereco ON endCliente.idEndereco=" +
      "Endereco.idEndereco) INNER JOIN Venda ON Cliente.cnpj=Venda.idCliente",
      claus
    );
    VidEnd = cmd.getArrayRegistros(cmd.executarSQL());
    System.out.println("vector cnpj" + VidEnd);
    campo.removeAllElements();
    campo.addElement("DISTINCT Endereco.rua");
    cmd.selecionar(
      campo,
      "((Cliente INNER JOIN endCliente ON Cliente.cnpj=" +
      "endCliente.idCliente) INNER JOIN Endereco ON endCliente.idEndereco=" +
      "Endereco.idEndereco) INNER JOIN Venda ON Cliente.cnpj=Venda.idCliente",
      claus
    );
    Vrua = cmd.getArrayRegistros(cmd.executarSQL());
    System.out.println("vector rua" + Vrua);
    tmp.addElement(VidEnd);
    tmp.addElement(Vrua);
    if (tmp == null) {
      JOptionPane.showMessageDialog(null, "Não Há Entregas para essa Praça.");
    }
    System.out.println("venda " + tmp);
    return tmp;
  }

  public Vector exibirDetalhes(Vector idEnd) {
    Vector tmp = new Vector();
    Vector campo = new Vector();
    Vector corpo = new Vector();
    Vector exibir = new Vector();
    campo.addElement("Cliente.CNPJ");
    campo.addElement("Cliente.razaoSocial");
    campo.addElement("rua");
    campo.addElement("bairro");
    campo.addElement("cidade");
    campo.addElement("estado");
    campo.addElement("numero");
    cmd.selecionar(
      campo,
      "(Cliente INNER JOIN endCliente ON Cliente.cnpj=" +
      "endCliente.idCliente) INNER JOIN Endereco ON endCliente.idEndereco=Endereco.idEndereco",
      "Endereco.idEndereco='" + idEnd.get(0) + "'"
    );
    try {
      tmp = cmd.selecionePorTabela(cmd.executarSQL());
    } catch (SQLException ex) {}
    for (int i = 0; i < idEnd.size(); i++) {
      cmd.selecionar(
        campo,
        "(Cliente INNER JOIN endCliente ON Cliente.cnpj=" +
        "endCliente.idCliente) INNER JOIN Endereco ON endCliente.idEndereco=Endereco.idEndereco",
        "Endereco.idEndereco='" + idEnd.get(i) + "'"
      );
      corpo.addElement(cmd.getFromRegistros(cmd.executarSQL(), 7));
      System.out.println("copro " + corpo);
    }
    exibir.addElement(corpo);
    exibir.addElement(tmp.get(1));
    return exibir;
  }

  public void destrutor() throws Throwable {
    end.destrutor();
    tele.destrutor();
    this.finalize();
  }
}
