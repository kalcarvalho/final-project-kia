package CamadaNegocios;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Fornecedor extends CtrDados {

  private Vector razaosoc; //

  private String cnpj;
  private String razaosocial;
  private String inscestadual;
  private String fantasia;
  private String repVendas;
  //declaração de objetos
  private Endereco end;
  private Telefone tele;

  public Fornecedor() {
    tele = new Telefone();
    end = new Endereco();
  }

  public Vector getFornecedor() {
    Vector campo = new Vector();
    campo.addElement("razaosocial");
    cmd.selecionar(campo, "Fornecedor");
    razaosoc = cmd.getArrayRegistros(cmd.executarSQL());
    if (razaosoc == null) {
      JOptionPane.showMessageDialog(
        null,
        "Não Existem Fornecedores Cadastrados."
      );
    }
    return razaosoc;
  }

  public String getFornecedor(String str) {
    String id = str;
    Vector campo = new Vector();
    campo.addElement("cnpj");
    cmd.selecionar(campo, "Fornecedor", "razaosocial='" + id + "'");
    cnpj = cmd.getRegistros(cmd.executarSQL());
    if (cnpj == null) {
      JOptionPane.showMessageDialog(
        null,
        "Não Existem Fornecedores Cadastrados."
      );
    }
    return cnpj;
  }

  public void inserirEndereco(
    String rua,
    String bairro,
    String cidade,
    String estado,
    String cep,
    String numero,
    String Email,
    String cnpj
  ) {
    end.setEndereco(
      rua,
      bairro,
      cidade,
      estado,
      cep,
      numero,
      Email,
      cnpj,
      "endFornecedor"
    );
  }

  public void inserirTelefone(String t, String f, String cnpj) {
    tele.setTelefone(t, f, cnpj, "telFornecedor");
  }

  public String getCNPJ() {
    return cnpj;
  }

  public void cadastrar(
    String cnp,
    String razaosoc,
    String inscest,
    String fant,
    String repVe
  ) {
    Vector campo = new Vector();
    campo.addElement(cnp);
    campo.addElement(razaosoc);
    campo.addElement(inscest);
    campo.addElement(fant);
    campo.addElement(repVe);
    cmd.inserir(campo, "Fornecedor");
    Logger.registrar(cnp, "Fornecedor/End/Tel", "Inserção");
  }

  public Vector preencherTelaFornecedor(String cnpj) {
    Vector tmp;
    cmd.selecionar("Fornecedor", "cnpj='" + cnpj + "'");
    tmp = cmd.getFromRegistros(cmd.executarSQL(), 5);
    if (tmp == null) {
      JOptionPane.showMessageDialog(
        null,
        "Não existem Fornecedores cadastrados."
      );
    }
    return tmp;
  }

  public Vector preencherTelaEnd(String cnpj) {
    return end.getEndereco(
      cnpj,
      "SELECT Endereco.idEndereco,rua, bairro, cidade, estado, cep, numero, Email FROM (Fornecedor INNER JOIN endFornecedor ON Fornecedor.cnpj=endFornecedor.idFornecedor) INNER JOIN Endereco ON endFornecedor.idEndereco=Endereco.idEndereco WHERE CNPJ='" +
      cnpj +
      "'"
    );
  }

  public Vector preencherTelaTel(String cnpj) {
    return tele.getTelefone(
      "SELECT Tel, Fax FROM (Fornecedor INNER JOIN telFornecedor ON Fornecedor.cnpj=telFornecedor.idFornecedor) INNER JOIN Telefone ON telFornecedor.idTelefone=Telefone.tel WHERE CNPJ='" +
      cnpj +
      "'"
    );
  }

  public void alterarForn(
    String cnpj,
    String razaoSocial,
    String inscEstadual,
    String fantasia,
    String repVendas
  ) {
    Vector sets = new Vector();
    sets.addElement("cnpj='" + cnpj + "'");
    sets.addElement("razaosocial='" + razaoSocial + "'");
    sets.addElement("inscestadual='" + inscEstadual + "'");
    sets.addElement("fantasia='" + fantasia + "'");
    sets.addElement("repVendas='" + repVendas + "'");
    cmd.atualizar("Fornecedor", sets, "cnpj='" + cnpj + "'");
    Logger.registrar(cnpj, "Fornecedor/End/Tel", "Alteração");
  }

  public void alterarEnd(
    int idEnd,
    String rua,
    String bairro,
    String cidade,
    String estado,
    String cep,
    String num,
    String email
  ) {
    int idrota = 0;
    end.alterarEnd(idEnd, rua, bairro, cidade, estado, cep, num, email, idrota);
  }

  public void alterarTel(String idTel, String tel, String fax) {
    tele.alterarTel(idTel, tel, fax, "telFornecedor");
  }

  /**
   * remove todos os dados de fornecedor e chama o método removerTel para
   * remover o telefone e seus respectivos dados da tabela associativa TelFornecedor
   * @param cnpj
   */
  public void removerFornecedor(String cnpj) {
    tele.removerTel(
      cnpj,
      "DELETE Telefone.*,telFornecedor.* FROM (Fornecedor INNER JOIN telFornecedor ON Fornecedor.cnpj=telFornecedor.idFornecedor) INNER JOIN Telefone ON telFornecedor.idTelefone=Telefone.tel WHERE cnpj='" +
      cnpj +
      "'"
    );
    cmd.remover("Fornecedor", "cnpj='" + cnpj + "'");
    Logger.registrar(cnpj, "Fornecedor", "Remoção");
  }

  public String getRazaoSocial(String str) {
    Vector campo = new Vector();
    campo.addElement("razaosocial");
    cmd.selecionar(campo, "Fornecedor", "cnpj='" + str + "'");
    razaosocial = cmd.getRegistros(cmd.executarSQL());
    if (razaosocial == null) {
      JOptionPane.showMessageDialog(
        null,
        "Não Existem Fornecedores Cadastrados."
      );
    }
    return razaosocial;
  }

  public void destrutor() throws Throwable {
    tele.destrutor();
    end.destrutor();
    this.finalize();
  }
}
