package CamadaApresentacao;

import Controladoras.CtrExcluirProduto;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;

public class frExcluirProduto extends JFrame {

  private CtrExcluirProduto cep;
  String cnpj;
  JPanel jPanel1 = new JPanel();
  Border border1;
  JLabel jLabel1 = new JLabel();
  JComboBox cbFornecedor;
  JLabel jLabel2 = new JLabel();
  JComboBox cbProduto;
  JPanel jPanel2 = new JPanel();
  JButton btRemover = new JButton();
  JButton brCancelar = new JButton();

  public frExcluirProduto() throws HeadlessException {
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    cep = new CtrExcluirProduto();
    border1 =
      new EtchedBorder(
        EtchedBorder.RAISED,
        Color.white,
        new Color(151, 145, 140)
      );
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(border1);
    jPanel1.setBounds(new Rectangle(2, 1, 370, 94));
    jPanel1.setLayout(null);

    cbFornecedor = new JComboBox(cep.preencherForn());
    jLabel1.setText("Selecione o Fornecedor:");
    jLabel1.setBounds(new Rectangle(9, 20, 134, 16));
    this.setResizable(false);
    this.setSize(new Dimension(380, 178));
    this.setTitle("Remover Produto");
    cbFornecedor.setBounds(new Rectangle(140, 15, 180, 21));
    cbFornecedor.addActionListener(
      new frExcluirProduto_cbFornecedor_actionAdapter(this)
    );
    jLabel2.setToolTipText("Selecione o produto a ser removido");
    jLabel2.setText("Produto:");
    jLabel2.setBounds(new Rectangle(85, 60, 47, 15));
    cbProduto = new JComboBox();
    cbProduto.setBounds(new Rectangle(141, 54, 179, 21));
    cbProduto.addActionListener(
      new frExcluirProduto_cbProduto_actionAdapter(this)
    );
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(3, 95, 370, 50));
    jPanel2.setLayout(null);
    btRemover.setBounds(new Rectangle(102, 14, 76, 23));
    btRemover.setText("Remover");
    btRemover.addActionListener(
      new frExcluirProduto_btRemover_actionAdapter(this)
    );
    brCancelar.setBounds(new Rectangle(189, 14, 77, 23));
    brCancelar.setText("Cancelar");
    brCancelar.addActionListener(
      new frExcluirProduto_brCancelar_actionAdapter(this)
    );
    jPanel1.add(jLabel1, null);
    jPanel1.add(cbFornecedor, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(cbProduto, null);
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(brCancelar, null);
    jPanel2.add(btRemover, null);
    this.getContentPane().add(jPanel1, null);
  }

  public void formatWindow() {
    this.validate();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    this.setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2
      );
    this.setVisible(true);
  }

  void cbFornecedor_actionPerformed(ActionEvent e) {
    Vector prods = new Vector();
    String razaoSocial = (String) cbFornecedor.getSelectedItem();
    cnpj = cep.selecionarFornecedor(razaoSocial);
    prods = cep.preencherProd(cnpj);
    prods.trimToSize();
    cbProduto.removeAllItems();
    for (int i = 0; i < prods.size(); i++) cbProduto.addItem(prods.get(i));
  }

  void cbProduto_actionPerformed(ActionEvent e) {}

  void btRemover_actionPerformed(ActionEvent e) {
    String descricao = (String) cbProduto.getSelectedItem();
    Object opt[] = { "Sim", "Não" };
    int result = JOptionPane.showOptionDialog(
      this,
      "Tem certeza que deseja remover este Produto?",
      "Confirmação de Remoção de Produto",
      JOptionPane.YES_NO_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      null,
      opt,
      opt[0]
    );
    if (result == JOptionPane.YES_OPTION) {
      try {
        cep.opcaoProduto(descricao, cnpj);
        cep.destrutor();
        this.finalize();
        this.setVisible(false);
        new frExcluirProduto();
      } catch (Throwable ex) {
        ex.printStackTrace();
      }
    } else {}
  }

  void brCancelar_actionPerformed(ActionEvent e) {
    this.setVisible(false);
    try {
      this.finalize();
    } catch (Throwable ex1) {
      ex1.printStackTrace();
    }
  }
}

class frExcluirProduto_cbFornecedor_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirProduto adaptee;

  frExcluirProduto_cbFornecedor_actionAdapter(frExcluirProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbFornecedor_actionPerformed(e);
  }
}

class frExcluirProduto_cbProduto_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirProduto adaptee;

  frExcluirProduto_cbProduto_actionAdapter(frExcluirProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.cbProduto_actionPerformed(e);
  }
}

class frExcluirProduto_btRemover_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirProduto adaptee;

  frExcluirProduto_btRemover_actionAdapter(frExcluirProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btRemover_actionPerformed(e);
  }
}

class frExcluirProduto_brCancelar_actionAdapter
  implements java.awt.event.ActionListener {

  frExcluirProduto adaptee;

  frExcluirProduto_brCancelar_actionAdapter(frExcluirProduto adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.brCancelar_actionPerformed(e);
  }
}
