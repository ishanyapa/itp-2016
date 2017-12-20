/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManufacturingManagement;

import RootElement.MySqlConnect;
import com.lowagie.text.pdf.BarcodeEAN;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.print.Printable;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author User
 */
public class Barcode extends javax.swing.JFrame {

    PreparedStatement pst = null;
    Connection con = null;
    BufferedImage bffImg;
    String j;
    String mmid;
    String mid;
    String manx;
   String mm; 
   ManufacturingProcess pp;

    /**
     *
     */
    public Barcode() {
     String manx;
        initComponents();
        generatebarcodeno();
        con = MySqlConnect.ConnectDB();
        ManufacturingProcess pp = new ManufacturingProcess();
       

    }

    public Barcode(String manid) {
        this.mid = manid;
        System.out.println("ihi");
        System.out.println(mid);
        manx=mid;
        System.out.println(manx);
   }
    
    /* public String Barcode1(String manid) {
        this.mid = manid;
//        System.out.println("ihi");
        System.out.println(mid);
        manx=mid;
        System.out.println(manx);
    
         return manx;
   
    }*/
     
      public void setmid(String mm)
       {this.mm=this.manx;}
 public String getmid()
 {return mm;}
 
 
     

    public void GenBar() throws IOException {
        //   Barcode

        BarcodeEAN codeEAN = new BarcodeEAN();
        codeEAN.setCodeType(codeEAN.EAN13);
        codeEAN.setCode(generatebarcodeno()); //13 Characters Should be there + Only Digits (write a class to auto increment the Barcode for the product)
        Image code_img = codeEAN.createAwtImage(Color.black, Color.white);

        bffImg = new BufferedImage(code_img.getWidth(null) + 134, code_img.getHeight(null) + 58, BufferedImage.TYPE_3BYTE_BGR);

        /*
        int w=code_img.getWidth(null);
        int h=code_img.getHeight(null);
        System.out.println("w :"+w+"   H:"+h);
         */
        ImageIcon icon = new ImageIcon(bffImg);

        Graphics gr = bffImg.createGraphics();
        gr.drawImage(code_img, 0, 0, 229, 82, null);
        barcodeimage.setIcon(icon);


        /* try {
            // ImageIO.write(bffImg, "jpeg", new File("bar23.jpg"));  // TO save the image
            System.out.println("Bar code Generated ");
        } catch (Exception i) {
            System.out.println("Error :  " + i);
        }*/
    }

    public String generatebarcodeno() {

        int i = (int) (new Date().getTime() / 1000);

        long d = new Date().getTime();
        String j = String.valueOf(d);
        return j;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        barcodeimage = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Generate Barcode");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        id.setText("jTextField1");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(barcodeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 81, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(barcodeimage, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ManufacturingProcess s = new ManufacturingProcess();
        s.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            GenBar();

        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            /*  pp= new ManufacturingProcess();
            manx= pp.getmid();
            System.out.println("pleeaseeee");
            System.out.println("xxx:"+manx);*/

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bffImg, "jpg", baos);
            byte[] imageInByte = baos.toByteArray();
           // manx = this.mid;
             System.out.println(mid);
     //       String a = Barcode1(mid);
            String b= getmid();
             System.out.println("xx");
            System.out.println(b);
           
            mmid = "MP1133";
            Blob blob = con.createBlob();
            blob.setBytes(1, imageInByte);
            String sql = "UPDATE manufacturedproducts SET barcode='" + blob + "' WHERE manufactureId='" + b + "'";
            pst = con.prepareStatement(sql);

            System.out.println("ygiuv");
             System.out.println(mid);
           
            pst.execute();

            MessageDisplay.display("Barcode succesfully added");

        } catch (Exception e) {
            System.out.println("sr");
            System.out.println(e);
            MessageDisplay.display("Unable to add Barcode. Try Again");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barcode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barcodeimage;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
