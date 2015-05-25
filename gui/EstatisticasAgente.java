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
public class EstatisticasAgente extends javax.swing.JFrame {

    /**
     * Creates new form EstatisticasAgente
     */
    private Mundo a;
    private String nome;
    private int index;
    public EstatisticasAgente(Mundo a1, String nome1, int index1) {
        a = a1;
        nome = nome1;
        index = index1;
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

        jToggleButton5 = new javax.swing.JToggleButton();
        estatisticasAgenteLabel = new javax.swing.JLabel();
        distanciaPercorridaButton = new javax.swing.JToggleButton();
        objetosDiferentesButton = new javax.swing.JToggleButton();
        objetosAprendidosButton = new javax.swing.JToggleButton();
        voltarButton = new javax.swing.JToggleButton();

        jToggleButton5.setText("jToggleButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        estatisticasAgenteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estatisticasAgenteLabel.setText("Estatisticas do agente");

        distanciaPercorridaButton.setText("Distancias percorrida");
        distanciaPercorridaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distanciaPercorridaButtonActionPerformed(evt);
            }
        });

        objetosDiferentesButton.setText("Numero de objetos diferentes aprendidos");
        objetosDiferentesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objetosDiferentesButtonActionPerformed(evt);
            }
        });

        objetosAprendidosButton.setText("Numero de objetos aprendidos");
        objetosAprendidosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objetosAprendidosButtonActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estatisticasAgenteLabel)
                    .addComponent(voltarButton)
                    .addComponent(objetosAprendidosButton)
                    .addComponent(objetosDiferentesButton)
                    .addComponent(distanciaPercorridaButton))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {distanciaPercorridaButton, estatisticasAgenteLabel, objetosAprendidosButton, objetosDiferentesButton, voltarButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(estatisticasAgenteLabel)
                .addGap(29, 29, 29)
                .addComponent(distanciaPercorridaButton)
                .addGap(18, 18, 18)
                .addComponent(objetosDiferentesButton)
                .addGap(18, 18, 18)
                .addComponent(objetosAprendidosButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(voltarButton)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void distanciaPercorridaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distanciaPercorridaButtonActionPerformed
        DistanciaPercorrida novo = new DistanciaPercorrida(a,nome,index);
        novo.setVisible(true);
        dispose();
    }//GEN-LAST:event_distanciaPercorridaButtonActionPerformed

    private void objetosDiferentesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objetosDiferentesButtonActionPerformed
        ObjetosDiferentesAprendidos novo = new ObjetosDiferentesAprendidos(a,nome,index);
        novo.setVisible(true);
        dispose();
    }//GEN-LAST:event_objetosDiferentesButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        Menu novo = new Menu(a,nome);
        novo.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void objetosAprendidosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objetosAprendidosButtonActionPerformed
        ObjetosAprendidos novo = new ObjetosAprendidos(a,nome,index);
        novo.setVisible(true);
        dispose();
    }//GEN-LAST:event_objetosAprendidosButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton distanciaPercorridaButton;
    private javax.swing.JLabel estatisticasAgenteLabel;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton objetosAprendidosButton;
    private javax.swing.JToggleButton objetosDiferentesButton;
    private javax.swing.JToggleButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
