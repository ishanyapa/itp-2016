/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManufacturingManagement;

import RootElement.MySqlConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class ManufacturingProcess extends javax.swing.JPanel {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    String sdate = dateFormat.format(date);

    BufferedImage bffImg;
    String j;
    String mmid;
    String mid;
    String manx;
    String mm;
    String h;
    Double fweight;
    String productid;
    String id = null;
    double r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
    int qty;
    ComboKeyHandler ckh3;
    Barcode b;

    /**
     * /**
     * Creates new form ManufacturingProcess
     */
    public ManufacturingProcess() {
        initComponents();
        mdate.setText(sdate);
        con = MySqlConnect.ConnectDB();
        autogenerate();
        GenerateManID(manId);
        b = new Barcode(manId.getText());
        //b.Barcode1(manId.getText());

        FillCombo(productname, "name", "finishedproducts");

        ckh3 = new ComboKeyHandler(productname);

        productname.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                ckh3.keyTyped(e);
            }
        });

    }

    public void FillCombo(JComboBox cmb, String fieldName, String tableName) {
        try {
            Connection con;
            con = MySqlConnect.ConnectDB();
            Statement stmt;
            ResultSet rslt;

            stmt = con.createStatement();
            rslt = stmt.executeQuery("SELECT " + fieldName + " FROM " + tableName + " ");

            while (rslt.next()) {
                String fname = rslt.getString(fieldName);
                cmb.addItem(fname);
            }

            cmb.setSelectedIndex(-1);
            con.close();
            stmt.close();

        } catch (Exception e) {

        }
    }

    public void GenerateManID(JTextField f) {
        String mid = null;
        String a;
        int b;

        try {

            String q = "SELECT manufactureId FROM manufacturedproducts ORDER BY manufactureId";
            st = con.createStatement();
            rs = st.executeQuery(q);

            while (rs.next()) {
                mid = rs.getString("manufactureId");
            }

            a = mid.substring(0, 2);
            b = Integer.parseInt(mid.substring(2, 6));
            b = b + 1;
            h = a + String.valueOf(b);

            f.setText(h);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("xy");

        }

    }

    public void autogenerate() {

        String a;
        int b;

        try {

            String q = "SELECT batchId FROM manufacturedproducts ORDER BY batchId";
            st = con.createStatement();
            rs = st.executeQuery(q);

            while (rs.next()) {
                id = rs.getString("batchId");
            }

            a = id.substring(0, 2);
            b = Integer.parseInt(id.substring(2, 6));
            b = b + 1;
            String i = a + String.valueOf(b);
            batchid.setText(i);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("xx");
        }
    }

    public void generatepid() {

        try {
            String combo = String.valueOf(productname.getSelectedItem());
            String q = "SELECT productId FROM finishedproducts WHERE name='" + combo + "'";
            st = con.createStatement();
            rs = st.executeQuery(q);

            while (rs.next()) {
                id = rs.getString("productId");
            }

            pid.setText(id);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("uhgiteho");
        }
    }

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

    }

    public String generatebarcodeno() {

        int i = (int) (new Date().getTime() / 1000);

        long d = new Date().getTime();
        String j = String.valueOf(d);
        return j;
    }

    public void MTwinScreen() {
        r2 = Double.parseDouble(raw2.getText());
        r4 = Double.parseDouble(raw4.getText());
        r5 = Double.parseDouble(raw5.getText());
        r7 = Double.parseDouble(raw7.getText());
        r8 = Double.parseDouble(raw8.getText());

        double unit = r2 / 70;
        int u = (int) unit;

        double unit1 = r4 / 60;
        int u1 = (int) unit1;

        double unit2 = r5 / 10;
        int u2 = (int) unit2;

        double unit3 = r7 / 30;
        int u3 = (int) unit3;

        double unit4 = r8 / 30;
        int u4 = (int) unit4;

        int smallest = Math.min(u, Math.min(u1, Math.min(u2, Math.min(u3, u4))));
        double unitweight = 200;
        fweight = 200 * (double) smallest;

        count.setText(String.valueOf(smallest));
        weight.setText(String.valueOf(fweight));

    }

    public void M3CoreScreened() {
        r1 = Double.parseDouble(raw1.getText());
        r4 = Double.parseDouble(raw4.getText());
        r5 = Double.parseDouble(raw5.getText());
        r9 = Double.parseDouble(raw9.getText());
        r10 = Double.parseDouble(raw10.getText());

        double unit = r1 / 100;
        int u = (int) unit;

        double unit1 = r4 / 240;
        int u1 = (int) unit1;

        double unit2 = r5 / 60;
        int u2 = (int) unit2;

        double unit3 = r9 / 90;
        int u3 = (int) unit3;

        double unit4 = r10 / 140;
        int u4 = (int) unit4;

        int smallest = Math.min(u, Math.min(u1, Math.min(u2, Math.min(u3, u4))));
        double unitweight = 630;
        fweight = 630 * (double) smallest;

        count.setText(String.valueOf(smallest));
        weight.setText(String.valueOf(fweight));

    }

    public void M4CoreScreened() {
        r3 = Double.parseDouble(raw3.getText());
        r4 = Double.parseDouble(raw4.getText());
        r5 = Double.parseDouble(raw5.getText());
        r7 = Double.parseDouble(raw7.getText());
        r9 = Double.parseDouble(raw9.getText());
        double unit = r3 / 175;
        int u = (int) unit;

        double unit1 = r4 / 120;
        int u1 = (int) unit1;

        double unit2 = r5 / 100;
        int u2 = (int) unit2;

        double unit3 = r7 / 120;
        int u3 = (int) unit3;

        double unit4 = r9 / 100;
        int u4 = (int) unit4;

        int smallest = Math.min(u, Math.min(u1, Math.min(u2, Math.min(u3, u4))));

        double unitweight = 615;
        fweight = 615 * (double) smallest;

        count.setText(String.valueOf(smallest));
        weight.setText(String.valueOf(fweight));
    }

    public void M2CoreOutDoor() {
        r3 = Double.parseDouble(raw3.getText());
        r4 = Double.parseDouble(raw4.getText());
        r5 = Double.parseDouble(raw5.getText());
        r1 = Double.parseDouble(raw1.getText());
        r7 = Double.parseDouble(raw7.getText());
        double unit = r3 / 195;
        int u = (int) unit;

        double unit1 = r4 / 120;
        int u1 = (int) unit1;

        double unit2 = r5 / 100;
        int u2 = (int) unit2;

        double unit3 = r1 / 60;
        int u3 = (int) unit3;

        double unit4 = r7 / 80;
        int u4 = (int) unit4;

        int smallest = Math.min(u, Math.min(u1, Math.min(u2, Math.min(u3, u4))));

        double unitweight = 555;
        fweight = 555 * (double) smallest;

        count.setText(String.valueOf(smallest));
        weight.setText(String.valueOf(fweight));
    }

    public void M3CoreOutdoor() {
        r1 = Double.parseDouble(raw1.getText());
        r2 = Double.parseDouble(raw2.getText());
        r3 = Double.parseDouble(raw3.getText());
        r4 = Double.parseDouble(raw4.getText());
        r5 = Double.parseDouble(raw5.getText());
        double unit = r1 / 195;
        int u = (int) unit;

        double unit1 = r2 / 120;
        int u1 = (int) unit1;

        double unit2 = r3 / 130;
        int u2 = (int) unit2;

        double unit3 = r4 / 220;
        int u3 = (int) unit3;

        double unit4 = r5 / 60;
        int u4 = (int) unit4;

        int smallest = Math.min(u, Math.min(u1, Math.min(u2, Math.min(u3, u4))));

        double unitweight = 725;
        fweight = 725 * (double) smallest;

        count.setText(String.valueOf(smallest));
        weight.setText(String.valueOf(fweight));
    }

    public void M4CoreOutdoor() {
        r6 = Double.parseDouble(raw6.getText());
        r7 = Double.parseDouble(raw7.getText());
        r8 = Double.parseDouble(raw8.getText());
        r9 = Double.parseDouble(raw9.getText());
        r10 = Double.parseDouble(raw10.getText());
        double unit = r6 / 145;
        int u = (int) unit;

        double unit1 = r7 / 120;
        int u1 = (int) unit1;

        double unit2 = r8 / 90;
        int u2 = (int) unit2;

        double unit3 = r9 / 160;
        int u3 = (int) unit3;

        double unit4 = r10 / 140;
        int u4 = (int) unit4;

        int smallest = Math.min(u, Math.min(u1, Math.min(u2, Math.min(u3, u4))));

        double unitweight = 655;
        fweight = 655 * (double) smallest;
        count.setText(String.valueOf(smallest));
        weight.setText(String.valueOf(fweight));
    }

    public void M1CoreInsulated() {
        r2 = Double.parseDouble(raw2.getText());
        r4 = Double.parseDouble(raw4.getText());
        r6 = Double.parseDouble(raw6.getText());
        r8 = Double.parseDouble(raw8.getText());
        r10 = Double.parseDouble(raw10.getText());
        double unit = r2 / 142;
        int u = (int) unit;

        double unit1 = r4 / 160;
        int u1 = (int) unit1;

        double unit2 = r6 / 50;
        int u2 = (int) unit2;

        double unit3 = r8 / 130;
        int u3 = (int) unit3;

        double unit4 = r10 / 140;
        int u4 = (int) unit4;

        int smallest = Math.min(u, Math.min(u1, Math.min(u2, Math.min(u3, u4))));

        double unitweight = 622;
        fweight = 622 * (double) smallest;

        count.setText(String.valueOf(smallest));
        weight.setText(String.valueOf(fweight));
    }

    public void MNonsheathedIndoor() {
        r1 = Double.parseDouble(raw1.getText());
        r3 = Double.parseDouble(raw3.getText());
        r5 = Double.parseDouble(raw5.getText());
        r7 = Double.parseDouble(raw7.getText());
        r9 = Double.parseDouble(raw9.getText());
        double unit = r1 / 150;
        int u = (int) unit;

        double unit1 = r3 / 128;
        int u1 = (int) unit1;

        double unit2 = r5 / 40;
        int u2 = (int) unit2;

        double unit3 = r7 / 134;
        int u3 = (int) unit3;

        double unit4 = r9 / 100;
        int u4 = (int) unit4;

        int smallest = Math.min(u, Math.min(u1, Math.min(u2, Math.min(u3, u4))));

        double unitweight = 552;
        fweight = 552 * (double) smallest;

        count.setText(String.valueOf(smallest));
        weight.setText(String.valueOf(fweight));
    }

    public void M1CoreInsulatednSheathedIndoor() {
        r2 = Double.parseDouble(raw2.getText());
        r3 = Double.parseDouble(raw3.getText());
        r5 = Double.parseDouble(raw5.getText());
        r7 = Double.parseDouble(raw7.getText());
        r9 = Double.parseDouble(raw9.getText());
        double unit = r2 / 120;
        int u = (int) unit;

        double unit1 = r3 / 192;
        int u1 = (int) unit1;

        double unit2 = r5 / 75;
        int u2 = (int) unit2;

        double unit3 = r7 / 144;
        int u3 = (int) unit3;

        double unit4 = r9 / 150;
        int u4 = (int) unit4;

        int smallest = Math.min(u, Math.min(u1, Math.min(u2, Math.min(u3, u4))));

        double unitweight = 681;
        fweight = 681 * (double) smallest;

        count.setText(String.valueOf(smallest));
        weight.setText(String.valueOf(fweight));
    }

    public void MUnarmouredControl() {
        r4 = Double.parseDouble(raw4.getText());
        r3 = Double.parseDouble(raw3.getText());
        r5 = Double.parseDouble(raw5.getText());
        r7 = Double.parseDouble(raw7.getText());
        r8 = Double.parseDouble(raw8.getText());
        double unit = r4 / 120;
        int u = (int) unit;

        double unit1 = r3 / 142;
        int u1 = (int) unit1;

        double unit2 = r5 / 45;
        int u2 = (int) unit2;

        double unit3 = r7 / 144;
        int u3 = (int) unit3;

        double unit4 = r8 / 100;
        int u4 = (int) unit4;

        int smallest = Math.min(u, Math.min(u1, Math.min(u2, Math.min(u3, u4))));

        double unitweight = 551;
        fweight = 551 * (double) smallest;

        count.setText(String.valueOf(smallest));
        weight.setText(String.valueOf(fweight));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        productname = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        raw1 = new javax.swing.JTextField();
        raw2 = new javax.swing.JTextField();
        raw3 = new javax.swing.JTextField();
        raw4 = new javax.swing.JTextField();
        raw5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        finish = new javax.swing.JButton();
        err1 = new javax.swing.JLabel();
        proId = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        raw6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        raw7 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        raw8 = new javax.swing.JTextField();
        raw9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        raw10 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        manId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mdate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        batchid = new javax.swing.JTextField();
        pid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        count = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        weight = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        barcodeimage = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jLabel20.setText("kg");

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(769, 580));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setPreferredSize(new java.awt.Dimension(749, 558));

        jLabel1.setText("Product Type:");

        productname.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productnameItemStateChanged(evt);
            }
        });
        productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productnameActionPerformed(evt);
            }
        });
        productname.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                productnamePropertyChange(evt);
            }
        });

        jLabel2.setText("Fine Copper Rods:");

        jLabel3.setText(" Polyvinyl Chloride:");

        jLabel4.setText("Pure Polythene:");

        jLabel5.setText(" Aluminium Rods :");

        jLabel6.setText("Gal. Steel Wire:");

        raw1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raw1ActionPerformed(evt);
            }
        });
        raw1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                raw1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                raw1KeyTyped(evt);
            }
        });

        raw2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                raw2KeyTyped(evt);
            }
        });

        raw3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                raw3KeyTyped(evt);
            }
        });

        raw4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                raw4KeyTyped(evt);
            }
        });

        raw5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                raw5KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                raw5KeyTyped(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        finish.setText("Add Record");
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });

        jLabel13.setText("Pure Iron Rods:");

        raw6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                raw6KeyTyped(evt);
            }
        });

        jLabel14.setText("Super Cobalt:");

        raw7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                raw7KeyTyped(evt);
            }
        });

        jLabel15.setText("Nickel-Extra Strength:");

        raw8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                raw8KeyTyped(evt);
            }
        });

        raw9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                raw9KeyTyped(evt);
            }
        });

        jLabel16.setText("Low Carbon Steel:");

        jLabel17.setText("Rubber:");

        raw10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                raw10KeyTyped(evt);
            }
        });

        jLabel18.setText("kg");

        jLabel19.setText("kg");

        jLabel21.setText("kg");

        jLabel22.setText("kg");

        jLabel23.setText("kg");

        jLabel24.setText("kg");

        jLabel25.setText("kg");

        jLabel26.setText("kg");

        jLabel27.setText("kg");

        jLabel28.setText("kg");

        jLabel12.setText("ManufactureID:");

        jLabel11.setText("Product ID:");

        jLabel10.setText("Manufactured Date:");

        mdate.setEditable(false);
        mdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mdateActionPerformed(evt);
            }
        });

        jLabel8.setText("BatchID:");

        batchid.setEditable(false);

        jLabel7.setText("Expected Product Count:");

        jLabel9.setText("Total Weight:");

        jButton1.setText("Caculate Product Count");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel29.setText("kg");

        jLabel30.setText("Bar Code:");

        jButton2.setText("Generate Barcode");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Demo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Report");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(barcodeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(finish)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(69, 69, 69)
                                    .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(65, 65, 65))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(55, 55, 55))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(67, 67, 67)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel14)
                                                .addComponent(jLabel15)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel30))
                                            .addGap(38, 38, 38)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(107, 107, 107)
                                            .addComponent(jLabel26))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(raw3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(raw1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(raw5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(raw7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(raw9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel18)
                                                .addComponent(jLabel21)
                                                .addComponent(jLabel23)
                                                .addComponent(jLabel25)))
                                        .addComponent(manId, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(batchid, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel16)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(8, 8, 8)
                                                    .addComponent(jLabel17))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel3)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel5)
                                                        .addGap(8, 8, 8))))
                                            .addGap(69, 69, 69))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(93, 93, 93)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel10))
                                            .addGap(34, 34, 34)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(raw4, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .addComponent(raw6, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .addComponent(raw8, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                    .addComponent(raw2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel22)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(err1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel27)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(raw10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(proId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel29))
                            .addComponent(mdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addComponent(count, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(raw1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(raw2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(err1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(raw4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22)
                                .addComponent(jLabel21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(raw3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(proId, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(raw8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(raw10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel28)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(raw5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(raw6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(raw7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(raw9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(manId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(batchid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(mdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(finish)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(barcodeimage, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishActionPerformed
        /* if (raw1.getText().isEmpty()||raw2.getText().isEmpty()||raw3.getText().isEmpty()||raw4.getText().isEmpty()||raw5.getText().isEmpty()) {
            MessageDisplay.display("Fields Cannot be Empty");
        } */ if ((raw1.getText() == null) || (raw2.getText() == null) || (raw3.getText() == null) || (raw4.getText() == null) || (raw5.getText() == null)) {
            MessageDisplay.display("Fields Cannot be Empty");
            System.out.println("Null");
        } else {
            System.out.println("Null");

            String date = mdate.getText();
            try {
                Statement st = con.createStatement();
                String sql5 = "INSERT INTO manufacturedproducts(manufactureId,manufactureDate,quantity,weight,batchId,productId)VALUES('" + manId.getText() + "','" + mdate.getText() + "','" + count.getText() + "','" + weight.getText() + "','" + batchid.getText() + "','" + pid.getText() + "')";
                pst = con.prepareStatement(sql5);
                pst.execute();
                raw1.setText("");
                raw2.setText("");
                raw3.setText("");
                raw4.setText("");
                raw5.setText("");
                raw6.setText("");
                raw7.setText("");
                raw8.setText("");
                raw9.setText("");
                raw10.setText("");
                count.setText("");
                batchid.setText("");
                weight.setText("");
                //  manId.setText("");
                pid.setText("");
                productname.setSelectedIndex(-1);
                raw1.setEditable(true);
                raw2.setEditable(true);
                raw3.setEditable(true);
                raw4.setEditable(true);
                raw5.setEditable(true);
                raw6.setEditable(true);
                raw7.setEditable(true);
                raw8.setEditable(true);
                raw9.setEditable(true);
                raw10.setEditable(true);

                MessageDisplay.display("Record succesfully added");

            } catch (Exception e) {
                System.out.println(e);
                MessageDisplay.display("Unable to add record. Try Again");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_finishActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        raw1.setText("");
        raw2.setText("");
        raw3.setText("");
        raw4.setText("");
        raw5.setText("");
        raw6.setText("");
        raw7.setText("");
        raw8.setText("");
        raw9.setText("");
        raw10.setText("");
        count.setText("");
        pid.setText("");
        batchid.setText("");
        barcodeimage.setIcon(null);
        raw1.setEditable(true);
        weight.setText("");
        productname.setSelectedIndex(-1);
        raw2.setEditable(true);
        raw3.setEditable(true);
        raw4.setEditable(true);
        raw5.setEditable(true);
        raw6.setEditable(true);
        raw7.setEditable(true);
        raw8.setEditable(true);
        raw9.setEditable(true);
        raw10.setEditable(true);
        autogenerate();
        GenerateManID(manId);

        //  weight.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void raw5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw5KeyTyped
        if (raw5.getText().length() <= 6) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
                // err1.setText("!");

            }
        } else {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_raw5KeyTyped

    private void raw4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw4KeyTyped
        if (raw4.getText().length() <= 6) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
                // err1.setText("!");

            }
        } else {
            evt.consume();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_raw4KeyTyped

    private void raw3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw3KeyTyped

        if (raw3.getText().length() <= 6) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
                // err1.setText("!");

            }
        } else {
            evt.consume();
        }

    }//GEN-LAST:event_raw3KeyTyped

    private void raw2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw2KeyTyped
        // TODO add your handling code here:

        if (raw2.getText().length() <= 6) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
                // err1.setText("!");

            }
        } else {
            evt.consume();
        }

    }//GEN-LAST:event_raw2KeyTyped

    private void raw1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw1KeyTyped
        // TODO add your handling code here:
        if (raw1.getText().length() <= 6) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
                // err1.setText("!");

            }
        } else {
            evt.consume();
        }

    }//GEN-LAST:event_raw1KeyTyped

    private void raw1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw1KeyReleased
        // TODO add your handling code here:
        String pat = "^[1-9]";

    }//GEN-LAST:event_raw1KeyReleased

    private void raw1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raw1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raw1ActionPerformed

    private void productnamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_productnamePropertyChange
        raw1.setEditable(true);
        raw2.setEditable(true);
        raw3.setEditable(true);
        raw4.setEditable(true);
        raw5.setEditable(true);
        raw6.setEditable(true);
        raw7.setEditable(true);
        raw8.setEditable(true);
        raw9.setEditable(true);
        raw10.setEditable(true);

        /*   try{  Statement st = con.createStatement();
                String sql9 = "INSERT INTO manufacturedproducts(manufactureId)VALUES('" + manId.getText() + "')";
                pst = con.prepareStatement(sql9);}
        catch(Exception e){}*/
        String pt = String.valueOf(productname.getSelectedItem());
        switch (pt) {
            case "Twin-Screened":
                raw1.setEditable(false);
                raw3.setEditable(false);
                raw6.setEditable(false);
                raw9.setEditable(false);
                raw10.setEditable(false);

                generatepid();

                break;

            case "3-Core-Screened":
                raw2.setEditable(false);
                raw3.setEditable(false);
                raw6.setEditable(false);
                raw7.setEditable(false);
                raw8.setEditable(false);
                generatepid();

                break;
            case "4-Core-Screened":
                raw1.setEditable(false);
                raw2.setEditable(false);
                raw6.setEditable(false);
                raw8.setEditable(false);
                raw10.setEditable(false);
                generatepid();

                break;

            case "2-Core-Outdoor":
                raw2.setEditable(false);
                raw6.setEditable(false);
                raw8.setEditable(false);
                raw9.setEditable(false);
                raw10.setEditable(false);
                generatepid();

                break;

            case ("3-Core-Outdoor"):
                raw6.setEditable(false);
                raw7.setEditable(false);
                raw8.setEditable(false);
                raw9.setEditable(false);
                raw10.setEditable(false);
                generatepid();
                // M3CoreOutdoor();
                break;

            case "4-Core-Outdoor":
                raw1.setEditable(false);
                raw2.setEditable(false);
                raw3.setEditable(false);
                raw4.setEditable(false);
                raw5.setEditable(false);
                generatepid();
                // M4CoreOutdoor();
                break;

            case "1-Core Insulated":
                raw1.setEditable(false);
                raw3.setEditable(false);
                raw5.setEditable(false);
                raw7.setEditable(false);
                raw9.setEditable(false);
                generatepid();
                // M1CoreInsulated();

                break;
            case "Non-sheathed Indoor":
                raw2.setEditable(false);
                raw4.setEditable(false);
                raw6.setEditable(false);
                raw8.setEditable(false);
                raw10.setEditable(false);
                generatepid();
                //  MNonsheathedIndoor();
                break;

            case "1-Core Insulated & Sheathed Indoor":
                raw1.setEditable(false);
                raw4.setEditable(false);
                raw6.setEditable(false);
                raw8.setEditable(false);
                raw10.setEditable(false);
                generatepid();

                break;

            case "Unarmoured-Control":
                raw1.setEditable(false);
                raw2.setEditable(false);
                raw6.setEditable(false);
                raw9.setEditable(false);
                raw10.setEditable(false);
                generatepid();
                // MUnarmouredControl();
                break;

        }
    }//GEN-LAST:event_productnamePropertyChange

    private void productnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productnameActionPerformed

    }//GEN-LAST:event_productnameActionPerformed

    private void productnameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productnameItemStateChanged
        // TODO add your handling code here:

        //ProductIDgenerate(proId);

    }//GEN-LAST:event_productnameItemStateChanged

    private void mdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mdateActionPerformed

    private void raw5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_raw5KeyPressed

    private void raw6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw6KeyTyped

        if (raw2.getText().length() <= 6) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
                // err1.setText("!");

            }
        } else {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_raw6KeyTyped

    private void raw7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw7KeyTyped

        if (raw2.getText().length() <= 6) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
                // err1.setText("!");

            }
        } else {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_raw7KeyTyped

    private void raw9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw9KeyTyped

        if (raw2.getText().length() <= 6) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
                // err1.setText("!");

            }
        } else {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_raw9KeyTyped

    private void raw8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw8KeyTyped

        if (raw2.getText().length() <= 6) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
                // err1.setText("!");

            }
        } else {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_raw8KeyTyped

    private void raw10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_raw10KeyTyped

        if (raw2.getText().length() <= 6) {
            if (!(Character.isDigit(evt.getKeyChar()))) {
                evt.consume();
                // err1.setText("!");

            }
        } else {
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_raw10KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // if ((raw1.getText() == null) || (raw2.getText() == null) || (raw3.getText() == null) || (raw4.getText() == null) || (raw5.getText() == null)||(raw6.getText() == null) || (raw7.getText() == null) || (raw8.getText() == null) || (raw9.getText() == null) || (raw10.getText() == null)){ 

            String pt = productname.getSelectedItem().toString();
            System.out.println(pt);
            switch (pt) {
                case "Twin-Screened":

                    MTwinScreen();

                    break;

                case "3-Core-Screened":

                    M3CoreScreened();

                    break;
                case "4-Core-Screened":

                    M4CoreScreened();

                    break;

                case "2-Core-Outdoor":

                    M2CoreOutDoor();
                    break;

                case "3-Core-Outdoor":

                    M3CoreOutdoor();
                    break;

                case "4-Core-Outdoor":

                    M4CoreOutdoor();
                    break;

                case "1-Core Insulated":

                    M1CoreInsulated();

                    break;
                case "Non-sheathed Indoor":

                    MNonsheathedIndoor();
                    break;

                case "1-Core Insulated & Sheathed Indoor":

                    M1CoreInsulatednSheathedIndoor();
                    break;

                case "Unarmoured-Control":

                    MUnarmouredControl();
                    break;
            }
            // }
            // else
            // {MessageDisplay.display("Unable to calculate.Fill all relevant fields and try again");}

        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            GenBar();

        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {

            String m = manId.getText();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bffImg, "jpg", baos);
            byte[] imageInByte = baos.toByteArray();
            Blob blob = con.createBlob();
            blob.setBytes(1, imageInByte);
            String sql = "UPDATE manufacturedproducts SET barcode='" + blob + "' WHERE manufactureId='" + m + "'";
            pst = con.prepareStatement(sql);

            pst.execute();

            MessageDisplay.display("Barcode succesfully added");
            autogenerate();
            GenerateManID(manId);

        } catch (Exception e) {

            System.out.println(e);
            MessageDisplay.display("Unable to add Barcode. Try Again");
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        raw1.setText("");
        raw2.setText("");
        raw3.setText("");
        raw4.setText("");
        raw5.setText("");
        raw6.setText("");
        raw7.setText("");
        raw8.setText("");
        raw9.setText("");
        raw10.setText("");

        raw1.setEditable(true);

        productname.setSelectedIndex(-1);
        raw2.setEditable(true);
        raw3.setEditable(true);
        raw4.setEditable(true);
        raw5.setEditable(true);
        raw6.setEditable(true);
        raw7.setEditable(true);
        raw8.setEditable(true);
        raw9.setEditable(true);
        raw10.setEditable(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       /* productname.setSelectedIndex(1);
        raw1.setEditable(false);
        raw3.setEditable(false);
        raw6.setEditable(false);
        raw9.setEditable(false);
        raw10.setEditable(false);*/
        raw2.setText("540000");
        raw4.setText("230000");
        raw5.setText("125600");
        raw7.setText("450020");
        raw8.setText("100000");
      

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         try{
        Connection con=MySqlConnect.ConnectDB();
        String report="src\\ManufactureReports\\Weights.jasper";

        JasperPrint jp=JasperFillManager.fillReport(report, null,con);
       JasperViewer.viewReport(jp,false);

   
       }
       catch(Exception e){
           System.out.println(e);}
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barcodeimage;
    private javax.swing.JTextField batchid;
    private javax.swing.JTextField count;
    private javax.swing.JLabel err1;
    private javax.swing.JButton finish;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField manId;
    private javax.swing.JTextField mdate;
    private javax.swing.JTextField pid;
    private javax.swing.JLabel proId;
    private javax.swing.JComboBox<String> productname;
    private javax.swing.JTextField raw1;
    private javax.swing.JTextField raw10;
    private javax.swing.JTextField raw2;
    private javax.swing.JTextField raw3;
    private javax.swing.JTextField raw4;
    private javax.swing.JTextField raw5;
    private javax.swing.JTextField raw6;
    private javax.swing.JTextField raw7;
    private javax.swing.JTextField raw8;
    private javax.swing.JTextField raw9;
    private javax.swing.JTextField weight;
    // End of variables declaration//GEN-END:variables
}
