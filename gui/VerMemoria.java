/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import projectopoo.*;

/**
 *
 * @author HP
 */
public class VerMemoria extends javax.swing.JFrame {

    /**
     * Creates new form VerMemoria
     */
    private Mundo a;
    private String nome;
    private int index;
    public VerMemoria(Mundo a, String nome, int index) {
        this.nome = nome;
        this.a = a;
        this.index=index;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        verMemoriaLabel = new javax.swing.JLabel();
        objetosVisitadosButton = new javax.swing.JToggleButton();
        objetosVistosButton = new javax.swing.JToggleButton();
        voltarButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        verMemoriaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verMemoriaLabel.setText("Ver memória");

        objetosVisitadosButton.setText("Objetos visitados");
        objetosVisitadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objetosVisitadosButtonActionPerformed(evt);
            }
        });

        objetosVistosButton.setText("Objetos vistos");
        objetosVistosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objetosVistosButtonActionPerformed(evt);
            }
        });

        voltarButton.setText("Voltar para o Menu");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(voltarButton)
                    .addComponent(verMemoriaLabel)
                    .addComponent(objetosVistosButton)
                    .addComponent(objetosVisitadosButton))
                .addGap(145, 145, 145))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {objetosVisitadosButton, objetosVistosButton, verMemoriaLabel, voltarButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(verMemoriaLabel)
                .addGap(18, 18, 18)
                .addComponent(objetosVisitadosButton)
                .addGap(18, 18, 18)
                .addComponent(objetosVistosButton)
                .addGap(75, 75, 75)
                .addComponent(voltarButton)
                .addGap(0, 106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void objetosVisitadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objetosVisitadosButtonActionPerformed
        ObjetosVisitados novo = new ObjetosVisitados(a,nome,index);
        novo.setVisible(true);
        dispose();
    }//GEN-LAST:event_objetosVisitadosButtonActionPerformed

    private void objetosVistosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objetosVistosButtonActionPerformed
        ObjetosVistos novo = new ObjetosVistos(a,nome,index);
        novo.setVisible(true);
        dispose();
    }//GEN-LAST:event_objetosVistosButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        Menu novo = new Menu(a,nome);
        novo.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton objetosVisitadosButton;
    private javax.swing.JToggleButton objetosVistosButton;
    private javax.swing.JLabel verMemoriaLabel;
    private javax.swing.JToggleButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
