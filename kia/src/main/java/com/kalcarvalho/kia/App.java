package com.kalcarvalho.kia;

import CamadaNegocios.Distribuidora;
import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App {

  public static Distribuidora dist;

  public App() {
    this.dist = new Distribuidora();
  }

  //main
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    new App();
  }
}
