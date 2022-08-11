package CamadaApresentacao;

import Controladoras.CtrCadastrarPraca;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * <p>Title: Cadastrar Praça</p>
 * <p>Description: Esta classe é uma interface com o usuário para cadastrar uma praca,<p>
 * Os itens selecionados no JList 1 com um clique são inseridos no JList 2,
 * ao clicar no botão gerar praça, é gerado uma praça com as respectivas cidades,
 * ou seja, é setado o campo praca da tabela endereco.
 * O obejtivo de cadastrar uma praca é para quando for gerar uma rota de entrega,
 * poder se escolhida uma praca, assim, vai entre no roteamento somente as
 * cidades referentes aquela praca.
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: AIK</p>
 * @author Alan, Ilson e Kal-el
 * @version 1.0
 */
public class frCadastrarPraca extends JFrame {

  ValidarCampo vc;
  CtrCadastrarPraca ccp;
  Vector cidade = new Vector();
  Vector praca = new Vector();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JSplitPane jSplitPane1 = new JSplitPane();
  JScrollPane jScrollPane1 = new JScrollPane();
  JList jlCidade;
  JLabel lbNome = new JLabel();
  JTextField tfNome = new JTextField();
  JLabel lbCidade = new JLabel();
  JButton btGerarPraca = new JButton();
  JButton btSair = new JButton();
  JButton btCancelar = new JButton();
  JScrollPane jScrollPane2 = new JScrollPane();
  JList jlPraca = new JList();

  public frCadastrarPraca() {
    try {
      jbInit();
      this.formatWindow();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    vc = new ValidarCampo();
    ccp = new CtrCadastrarPraca();
    cidade = ccp.getCidades();
    jlCidade = new JList(cidade);
    this.setResizable(false);
    this.setTitle("Cadastrar Praça");
    this.setSize(new Dimension(427, 331));
    this.getContentPane().setLayout(null);
    jPanel1.setBorder(BorderFactory.createEtchedBorder());
    jPanel1.setBounds(new Rectangle(3, 0, 423, 86));
    jPanel1.setLayout(null);
    jPanel2.setBorder(BorderFactory.createEtchedBorder());
    jPanel2.setBounds(new Rectangle(1, 84, 423, 156));
    jPanel2.setLayout(gridLayout1);
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    jPanel3.setBounds(new Rectangle(2, 239, 421, 61));
    jPanel3.setLayout(null);
    lbNome.setText("Nome:");
    lbNome.setBounds(new Rectangle(38, 27, 34, 15));
    tfNome.setText("");
    tfNome.setBounds(new Rectangle(88, 22, 139, 20));
    lbCidade.setText("Selecione as cidades:");
    lbCidade.setBounds(new Rectangle(37, 56, 114, 15));
    btGerarPraca.setBounds(new Rectangle(51, 19, 91, 23));
    btGerarPraca.setText("Gerar Praça");
    btGerarPraca.addActionListener(
      new frCadastrarPraca_btGerarPraca_actionAdapter(this)
    );
    btSair.setBounds(new Rectangle(251, 19, 71, 23));
    btSair.setText("Sair");
    btSair.addActionListener(new frCadastrarPraca_btSair_actionAdapter(this));
    btCancelar.setBounds(new Rectangle(158, 19, 77, 23));
    btCancelar.setText("Cancelar");
    btCancelar.addActionListener(
      new frCadastrarPraca_btCancelar_actionAdapter(this)
    );
    jlCidade.addMouseListener(new frCadastrarPraca_jlCidade_mouseAdapter(this));
    this.getContentPane().add(jPanel2, null);
    jPanel2.add(jSplitPane1, null);
    jSplitPane1.add(jScrollPane1, JSplitPane.LEFT);
    jSplitPane1.add(jScrollPane2, JSplitPane.RIGHT);
    jScrollPane2.getViewport().add(jlPraca, null);
    jScrollPane1.getViewport().add(jlCidade, null);
    jSplitPane1.setDividerLocation(200);
    this.getContentPane().add(jPanel3, null);
    this.getContentPane().add(jPanel1, null);
    jPanel1.add(lbNome, null);
    jPanel1.add(tfNome, null);
    jPanel1.add(lbCidade, null);
    jPanel3.add(btGerarPraca, null);
    jPanel3.add(btSair, null);
    jPanel3.add(btCancelar, null);
  }

  public void formatWindow() {
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

  /**
   * todas as distintas cidades  da tabela endereco é listada em JLCidade
   * com um clique no mouse neste JList, vc insere o item correspondente no JLpraca,
   * os item selecionados farão parte da nova praca
   * @param e MouseEvent
   */
  void jlCidade_mouseClicked(MouseEvent e) {
    int i = jlCidade.getSelectedIndex();
    praca.addElement(cidade.get(i));
    jlPraca.setListData(praca);
  }

  void btSair_actionPerformed(ActionEvent e) {
    try {
      ccp.destrutor();
      this.finalize();
      this.setVisible(false);
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
  }

  void btCancelar_actionPerformed(ActionEvent e) {
    praca.removeAllElements();
    jlPraca.setListData(praca);
  }

  /**
   * chama o metodo setPraca da controladora para cadastrar uma nova praca com itens
   * selecionados em JLpraca
   * @param e ActionEvent
   */
  void btGerarPraca_actionPerformed(ActionEvent e) {
    if (!vc.valNulo(tfNome.getText(), "Nome")) return;
    ccp.setPraca(tfNome.getText(), praca);
    JOptionPane.showMessageDialog(
      null,
      "Praça Cadastrada com Sucesso",
      "Gerar Praça",
      JOptionPane.INFORMATION_MESSAGE
    );
    praca.removeAllElements();
    jlPraca.setListData(praca);
  }
}

class frCadastrarPraca_jlCidade_mouseAdapter
  extends java.awt.event.MouseAdapter {

  frCadastrarPraca adaptee;

  frCadastrarPraca_jlCidade_mouseAdapter(frCadastrarPraca adaptee) {
    this.adaptee = adaptee;
  }

  public void mouseClicked(MouseEvent e) {
    adaptee.jlCidade_mouseClicked(e);
  }
}

class frCadastrarPraca_btSair_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarPraca adaptee;

  frCadastrarPraca_btSair_actionAdapter(frCadastrarPraca adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btSair_actionPerformed(e);
  }
}

class frCadastrarPraca_btCancelar_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarPraca adaptee;

  frCadastrarPraca_btCancelar_actionAdapter(frCadastrarPraca adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btCancelar_actionPerformed(e);
  }
}

class frCadastrarPraca_btGerarPraca_actionAdapter
  implements java.awt.event.ActionListener {

  frCadastrarPraca adaptee;

  frCadastrarPraca_btGerarPraca_actionAdapter(frCadastrarPraca adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btGerarPraca_actionPerformed(e);
  }
}
