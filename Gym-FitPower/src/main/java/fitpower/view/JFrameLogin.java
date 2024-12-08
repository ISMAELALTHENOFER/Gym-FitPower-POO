/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitpower.view;

import fitpower.controller.LoginController;
import fitpower.model.User;
import java.awt.event.KeyEvent;

/**
 *
 * @author Ismael
 */
public class JFrameLogin extends javax.swing.JFrame {

    private final LoginController controlador;
    private final User usuarioAuxiliar;
    private JFrameWelcome inicio;

    /**
     * Creates new form Login
     */
    public JFrameLogin() {
        initComponents();
        // instanciar controlador
        this.controlador = new LoginController();
        this.usuarioAuxiliar = new User();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbl_usuario = new javax.swing.JLabel();
        jtf_usuario = new javax.swing.JTextField();
        jlbl_password = new javax.swing.JLabel();
        jbtn_iniciarSesion = new javax.swing.JButton();
        jlbl_mensaje = new javax.swing.JLabel();
        jtf_password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jlbl_usuario.setText("Usuario: ");

        jtf_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_usuarioKeyReleased(evt);
            }
        });

        jlbl_password.setText("Password:");

        jbtn_iniciarSesion.setText("Iniciar Sesión");
        jbtn_iniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_iniciarSesionActionPerformed(evt);
            }
        });

        jlbl_mensaje.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jlbl_mensaje.setForeground(new java.awt.Color(255, 0, 51));

        jtf_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtf_passwordKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jlbl_usuario))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addGap(108, 108, 108)
                        .addComponent(jlbl_password)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbl_mensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtn_iniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtf_password)
                                .addComponent(jtf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(43, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbl_usuario)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jtf_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jlbl_password))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtn_iniciarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(jlbl_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_iniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_iniciarSesionActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_jbtn_iniciarSesionActionPerformed

    private void jtf_usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_usuarioKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciarSesion();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            iniciarSesion();
        }
    }//GEN-LAST:event_jtf_usuarioKeyReleased

    private void jtf_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf_passwordKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciarSesion();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            iniciarSesion();
        }
    }//GEN-LAST:event_jtf_passwordKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtn_iniciarSesion;
    private javax.swing.JLabel jlbl_mensaje;
    private javax.swing.JLabel jlbl_password;
    private javax.swing.JLabel jlbl_usuario;
    private javax.swing.JPasswordField jtf_password;
    private javax.swing.JTextField jtf_usuario;
    // End of variables declaration//GEN-END:variables

    public void arranca() {
        setLocationRelativeTo(null);// centra la ventana en la pantalla
        setVisible(true);// visualiza la ventana
    }

    public void limpiar() {
        this.jtf_usuario.setText("");
        this.jtf_password.setText("");
    }

    public javax.swing.JLabel getJlbl_mensaje() {
        return jlbl_mensaje;
    }

    public void setJlbl_mensaje(javax.swing.JLabel jlbl_mensaje) {
        this.jlbl_mensaje = jlbl_mensaje;
    }

    public javax.swing.JLabel getJlbl_password() {
        return jlbl_password;
    }

    public void setJlbl_password(javax.swing.JLabel jlbl_password) {
        this.jlbl_password = jlbl_password;
    }

    public javax.swing.JLabel getJlbl_usuario() {
        return jlbl_usuario;
    }

    public void setJlbl_usuario(javax.swing.JLabel jlbl_usuario) {
        this.jlbl_usuario = jlbl_usuario;
    }

    public javax.swing.JPasswordField getJtf_password() {
        return jtf_password;
    }

    public void setJtf_password(javax.swing.JPasswordField jtf_password) {
        this.jtf_password = jtf_password;
    }

    public javax.swing.JTextField getJtf_usuario() {
        return jtf_usuario;
    }

    public void setJtf_usuario(javax.swing.JTextField jtf_usuario) {
        this.jtf_usuario = jtf_usuario;
    }

    /**
     * Inicia Session
     */
    private void iniciarSesion() {
        /**
         * setear usuario con datos de la vista
         */
        usuarioAuxiliar.setUserName(getJtf_usuario().getText());
        usuarioAuxiliar.setPassword(new String(getJtf_password().getPassword()));

        if (controlador.startSession(usuarioAuxiliar) == true) {
            //Crea la pantalla principal del sistema
            this.inicio = new JFrameWelcome();
            inicio.setVisible(true);
            this.dispose();
        } else {
            this.getJlbl_mensaje().setText("ERROR: usuario o Password incorrecto");
            this.limpiar();
        }
    }

}
