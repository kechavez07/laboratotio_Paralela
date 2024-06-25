package org.example;

import javax.swing.*;
import java.awt.event.*;

public class Pantalla extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JProgressBar barraGeneral;
    private JProgressBar barraInfoPersonal;
    private JProgressBar barraIngresos;
    private JProgressBar barraEgresos;
    private JProgressBar barraReferencias;
    private JProgressBar barraMetPago;
    private JLabel ingresos;
    private JLabel infoPersonal;
    private JLabel egresos;
    private JLabel referencias;
    private JLabel metodoPago;
    private JLabel general;

    public JProgressBar getBarraGeneral(){
        return barraGeneral;
    }
    public JProgressBar getBarraInfoPersonal(){
        return barraInfoPersonal;
    }
    public JProgressBar getBarraIngresos(){
        return barraIngresos;
    }
    public JProgressBar getBarraEgresos(){
        return barraEgresos;
    }
    public JProgressBar getBarraReferencias(){
        return barraReferencias;
    }
    public JProgressBar getBarraMetPago(){
        return barraMetPago;
    }

    public Pantalla() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Pantalla dialog = new Pantalla();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
