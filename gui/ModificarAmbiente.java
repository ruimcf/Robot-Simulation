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
public class ModificarAmbiente extends javax.swing.JFrame {

    private Mundo a;
    private String nome;
    
    public ModificarAmbiente(Mundo a, String nome1) {
        this.a = a;
        nome = nome1;
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

        modificarAmbienteLabel = new javax.swing.JLabel();
        adicionarEntidadeButton = new javax.swing.JToggleButton();
        apagarEntidadeLabel = new javax.swing.JToggleButton();
        voltarButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        modificarAmbienteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modificarAmbienteLabel.setText("Modificar ambiente");

        adicionarEntidadeButton.setText("Adicionar entidade");
        adicionarEntidadeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarEntidadeButtonActionPerformed(evt);
            }
        });

        apagarEntidadeLabel.setText("Apagar entidade");
        apagarEntidadeLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarEntidadeLabelActionPerformed(evt);
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
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificarAmbienteLabel)
                    .addComponent(apagarEntidadeLabel)
                    .addComponent(adicionarEntidadeButton)
                    .addComponent(voltarButton))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {adicionarEntidadeButton, apagarEntidadeLabel, modificarAmbienteLabel, voltarButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(modificarAmbienteLabel)
                .addGap(18, 18, 18)
                .addComponent(adicionarEntidadeButton)
                .addGap(18, 18, 18)
                .addComponent(apagarEntidadeLabel)
                .addGap(71, 71, 71)
                .addComponent(voltarButton)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarEntidadeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarEntidadeButtonActionPerformed
       AdicionarEntidade novo = new AdicionarEntidade(a,nome);
       novo.setVisible(true);
       dispose();
    }//GEN-LAST:event_adicionarEntidadeButtonActionPerformed

    private void apagarEntidadeLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarEntidadeLabelActionPerformed
       ApagarEntidade novo = new ApagarEntidade(a,nome);
       novo.setVisible(true);
       dispose();
    }//GEN-LAST:event_apagarEntidadeLabelActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        Menu novo = new Menu(a,nome);
        novo.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton adicionarEntidadeButton;
    private javax.swing.JToggleButton apagarEntidadeLabel;
    private javax.swing.JLabel modificarAmbienteLabel;
    private javax.swing.JToggleButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
