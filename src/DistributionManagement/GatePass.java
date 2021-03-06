/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistributionManagement;

import java.awt.Container;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static jdk.nashorn.internal.objects.NativeArray.map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;



/**
 *
 * @author Shali
 */
public class GatePass extends javax.swing.JPanel {

    /**
     * Creates new form GatePass
     */
    public GatePass() {
        initComponents();
        
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	   //get current date time with Date()
        Calendar cal = Calendar.getInstance();
	System.out.println(dateFormat.format(cal.getTime()));

        
        
        SQL gate= new SQL();
        gate.incID(jtxtF100,"gatepass","passNo",'G');
        
        //
//select Distinct deliveryId from delivery 
        //Fill Combo Box - Delivery Ids
      /*  SQL del= new SQL();
        del.fillComboBox(cmb120,"delivery","deliveryId");
  */  
      
      
      
      //Gets not delivered deliveries 
      SQL del= new SQL();
      del.NotDelivered(cmb120);
      
      
     
        //Fill Combo - Vehicle Nummber 
        SQL num= new SQL();
        num.fillComboBox(cmb156,"vehicle","vehicleNo");
        
        SQL dri= new SQL();
        dri.LoadDriver(cmb147);
        
     
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
        jtxtF100 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser100 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtF113 = new javax.swing.JTextField();
        txtF119 = new javax.swing.JTextField();
        cmb119 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cmb120 = new javax.swing.JComboBox<>();
        cmb156 = new javax.swing.JComboBox<>();
        cmb147 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(790, 590));

        jLabel1.setText("Gate-pass Number  ");

        jtxtF100.setEditable(false);
        jtxtF100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtF100ActionPerformed(evt);
            }
        });

        jLabel2.setText("Date");

        jLabel3.setText("Vehicle Number ");

        jLabel4.setText("Driver");

        jLabel5.setText("To");

        jLabel6.setText("From");

        jLabel7.setText("Visit Type ");

        txtF119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtF119ActionPerformed(evt);
            }
        });

        cmb119.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Official", "Un-official" }));
        cmb119.setSelectedIndex(-1);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Delivery Id");

        jButton3.setText("Demo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel3))
                            .addGap(26, 26, 26))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(38, 38, 38)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(69, 69, 69)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtF100)
                    .addComponent(jDateChooser100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtF113)
                    .addComponent(txtF119)
                    .addComponent(cmb119, 0, 130, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton2))
                    .addComponent(cmb120, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb156, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb147, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(117, 117, 117)
                .addComponent(jButton3)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtF100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmb156, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmb147, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser100, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtF113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtF119, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmb119, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmb120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(182, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtF100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtF100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtF100ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

/*
         DateFormat fmt1 = new SimpleDateFormat("yyyy/MM/dd");
         String date1= fmt1.format(this.jDateChooser100.getDate());
        
        // 
         
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
         Date dateq = new Date();
         
     
        
        String today = dateFormat.format(dateq);
        
         try{   
            Date d1 = fmt1.parse(date1);
            Date d2 = fmt1.parse(today);
         }
         catch (Exception i)
         {}
         
         
                
              */  
if((cmb156.getSelectedIndex()==-1)||(cmb147.getSelectedIndex()==-1)||(jDateChooser100.getDate()==null)||(txtF113.getText()==null)||(txtF119.getText()==null)||(cmb119.getSelectedIndex()==-1)||(cmb120.getSelectedIndex()==-1))
       {
            JOptionPane.showMessageDialog(null,"Invalid Entry / One or more fields are empty","Warning",JOptionPane.ERROR_MESSAGE);
                
       
       
       }
        
        else
        {
        
        //String gatepass = "src\\Reports\\GatePass_1.jasper";
         DateFormat fmt1 = new SimpleDateFormat("yyyy/MM/dd");
         String date1= fmt1.format(this.jDateChooser100.getDate());
        
        // 
         
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
         Date dateq = new Date();
         
     
        
        String today = dateFormat.format(dateq);
            try{   
            Date d1 = fmt1.parse(date1);
            Date d2 = fmt1.parse(today);
               
            
            if(d1.after(d2))
            {
            JOptionPane.showMessageDialog(null,"Invalid Date","Warning",JOptionPane.ERROR_MESSAGE);
            
            }
            
            else
            { 
               
        
          String gatepass = "src\\Reports\\GatePass_1.jasper";
         //String gatepass = "Kelani Cables\\src\\Reports\\GatePass_1.jasper";
        DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
        String date= fmt.format(this.jDateChooser100.getDate());
        
        
        
        
        
       
            
        
        HashMap<String,Object> param = new HashMap<>();
        Map<String, Object> map2 = new HashMap<String, Object>(param);
        
        
        
        map2.put("passno",jtxtF100.getText());
        map2.put("date",date);
        map2.put("v_no",cmb156.getSelectedItem());
        map2.put("d_name",cmb147.getSelectedItem());
        map2.put("from",txtF119.getText());
        map2.put("to",txtF113.getText());
        map2.put("type", cmb119.getSelectedItem());
        
        
        
        
        
        Report gate = new Report(gatepass,map2);
        gate.setVisible(true);
        
        
        
        
        SQL g= new SQL();
        g.AddGatepass(jtxtF100, cmb147, txtF113, txtF119, jDateChooser100, cmb156, cmb120, cmb119);
        
        GatePass gp = new GatePass();
        SetPanel p= new SetPanel();
        p.SetPanel(gp);
            }
        }
        
        catch(Exception o)
        {
            JOptionPane.showMessageDialog(null, "Error"+o);
        }
        
        
                
        
        }

        
        
    
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtF119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtF119ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtF119ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         
        GatePass gp1 = new GatePass();
        SetPanel p1= new SetPanel();
        p1.SetPanel(gp1);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        cmb156.setSelectedIndex(3);
        cmb147.setSelectedIndex(1);
        txtF113.setText("Colombo");
        txtF119.setText("Kandy");
        cmb119.setSelectedIndex(1);
        cmb120.setSelectedIndex(1);
        
        
        
        {
        
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed
    
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb119;
    private javax.swing.JComboBox<String> cmb120;
    private javax.swing.JComboBox<String> cmb147;
    private javax.swing.JComboBox<String> cmb156;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser100;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jtxtF100;
    private javax.swing.JTextField txtF113;
    private javax.swing.JTextField txtF119;
    // End of variables declaration//GEN-END:variables
}
