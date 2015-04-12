/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparc;

import comparc.Instruction.Instruction;
import comparc.Instruction.Register;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NewJFrame extends javax.swing.JFrame {

    int rd, rs, rt, opcode, pc = 0, func = 0;
    boolean proceed = true;
    String rdbin, rsbin, rtbin, opcodebin, temp = "", offsetbin, addressbin, instruction, labeladdress, addbin = "", funcbin, addresshex = "";
    Register register;
    Register initialregister;
    Register registerforSingle;

    // regex
    Pattern immediate = Pattern.compile("[^a-f0-9]", Pattern.CASE_INSENSITIVE);
    Pattern labelcheck = Pattern.compile("^[a-zA-Z]+[a-zA-Z0-9]*$", Pattern.CASE_INSENSITIVE);
    Pattern digitcheck = Pattern.compile("^[0-9]", Pattern.CASE_INSENSITIVE);
    Matcher m;

    Instruction tempinst = new Instruction();
    ArrayList<Instruction> instlist = new ArrayList<Instruction>();
    ArrayList<String> cyclelist = new ArrayList<String>();

    DefaultTableModel opcodemodel;
    DefaultTableModel datasegmentmodel;
    DefaultTableModel codesegmentmodel;
    DefaultTableModel pipelinemodel;
    DefaultTableModel fullmodel;
    DefaultTableModel singlemodel;

    ArrayList<String> datasegment = new ArrayList<String>();
    ArrayList<String> datasegmentinitial = new ArrayList<String>();
    ArrayList<String> datasegmentSingle = new ArrayList<String>();
    ArrayList<String> pipeline = new ArrayList<String>();

    public NewJFrame() {
        initComponents();
        jTextField6.setEditable(false);
        jTextField7.setEditable(false);
        jTextField8.setEditable(false);
        jTextField9.setEditable(false);
        jTextField10.setEditable(false);
        jTextField11.setEditable(false);
        jTextField12.setEditable(false);
        jTextField13.setEditable(false);
        jTextField14.setEditable(false);
        jTextField15.setEditable(false);
        jTextField16.setEditable(false);
        jTextField17.setEditable(false);
        jTextField18.setEditable(false);
        jTextField19.setEditable(false);
        jTextField20.setEditable(false);
        jTextField21.setEditable(false);
        jTextField22.setEditable(false);
        jTextField23.setEditable(false);
        jTextField24.setEditable(false);
        jTextField25.setEditable(false);
        jTextField26.setEditable(false);
        jTextField27.setEditable(false);
        jTextField28.setEditable(false);
        jTextField29.setEditable(false);
        jTextField30.setEditable(false);
        jTextField31.setEditable(false);
        jTextField32.setEditable(false);
        jTextField33.setEditable(false);
        jTextField34.setEditable(false);
        jTextField35.setEditable(false);
        jTextField36.setEditable(false);
        jTextField37.setEditable(false);
        jTextField38.setEditable(false);
        jTextField39.setEditable(false);
        jButton2.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);

        opcodemodel = (DefaultTableModel) jTable3.getModel();
        datasegmentmodel = (DefaultTableModel) jTable1.getModel();
        codesegmentmodel = (DefaultTableModel) jTable2.getModel();
        pipelinemodel = (DefaultTableModel) jTable4.getModel();
        fullmodel = (DefaultTableModel) jTable5.getModel();
        singlemodel = (DefaultTableModel) jTable6.getModel();

        InitializeCS();
        InitializeDS();

        register = new Register();
        initialregister = new Register();
        registerforSingle = new Register();
        register.setRegister(new ArrayList<String>(Collections.nCopies(32, "0000000000000000")));
        register.setHi("00000000");
        register.setLo("00000000");
        pipeline.add("IF");
        pipeline.add("ID");
        pipeline.add("EX");
        pipeline.add("MEM");
        pipeline.add("WB");

        TableColumn column = null;

        //set size for opcode table
        for (int i = 0; i < 6; i++) {
            column = jTable3.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(175);
            } else if (i == 5) {
                column.setPreferredWidth(150);
            } else {
                column.setPreferredWidth(50);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jComboBox7 = new javax.swing.JComboBox();
        jComboBox8 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jComboBox9 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jComboBox10 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jComboBox11 = new javax.swing.JComboBox();
        jComboBox12 = new javax.swing.JComboBox();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel58 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1284, 719));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 175));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setMinimumSize(new java.awt.Dimension(270, 70));
        jPanel3.setPreferredSize(new java.awt.Dimension(270, 50));
        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setToolTipText("");
        jPanel4.setMaximumSize(new java.awt.Dimension(270, 70));
        jPanel4.setMinimumSize(new java.awt.Dimension(270, 70));
        jPanel4.setPreferredSize(new java.awt.Dimension(270, 50));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(37, 27));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox3.setPreferredSize(new java.awt.Dimension(37, 27));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox4.setPreferredSize(new java.awt.Dimension(37, 27));

        jLabel1.setText("RD");

        jLabel2.setText("RS");

        jLabel3.setText("RT");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel3.add(jPanel4, "card2");

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setMaximumSize(new java.awt.Dimension(270, 70));
        jPanel5.setMinimumSize(new java.awt.Dimension(270, 70));
        jPanel5.setPreferredSize(new java.awt.Dimension(250, 50));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox5.setMaximumSize(new java.awt.Dimension(37, 27));
        jComboBox5.setMinimumSize(new java.awt.Dimension(37, 27));
        jComboBox5.setPreferredSize(new java.awt.Dimension(37, 27));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox6.setMinimumSize(new java.awt.Dimension(37, 27));
        jComboBox6.setPreferredSize(new java.awt.Dimension(37, 27));

        jLabel9.setText("RS");

        jLabel10.setText("RT");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox5, 0, 50, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox6, 0, 50, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 154, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, "card2");

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setMaximumSize(new java.awt.Dimension(270, 70));
        jPanel6.setMinimumSize(new java.awt.Dimension(270, 70));
        jPanel6.setPreferredSize(new java.awt.Dimension(250, 50));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox7.setPreferredSize(new java.awt.Dimension(37, 27));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox8.setMinimumSize(new java.awt.Dimension(37, 27));
        jComboBox8.setPreferredSize(new java.awt.Dimension(37, 27));

        jLabel4.setText("Label");

        jLabel11.setText("RS");

        jLabel13.setText("RT");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox7, 0, 50, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox8, 0, 50, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6, "card2");

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setMaximumSize(new java.awt.Dimension(270, 70));
        jPanel7.setMinimumSize(new java.awt.Dimension(270, 70));
        jPanel7.setPreferredSize(new java.awt.Dimension(250, 50));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox9.setPreferredSize(new java.awt.Dimension(37, 27));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel5.setText("Offset");

        jLabel14.setText("RD");

        jLabel15.setText("RS");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jTextField2)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7, "card2");

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setMaximumSize(new java.awt.Dimension(270, 70));
        jPanel8.setMinimumSize(new java.awt.Dimension(270, 70));
        jPanel8.setPreferredSize(new java.awt.Dimension(250, 50));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jComboBox11.setPreferredSize(new java.awt.Dimension(37, 27));

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel6.setText("immediate");

        jLabel16.setText("RD");

        jLabel17.setText("RS");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox11, 0, 50, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox12, 0, 50, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, "card2");

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setMaximumSize(new java.awt.Dimension(270, 70));
        jPanel9.setMinimumSize(new java.awt.Dimension(270, 70));
        jPanel9.setPreferredSize(new java.awt.Dimension(250, 50));

        jTextField4.setPreferredSize(new java.awt.Dimension(57, 27));

        jLabel7.setText("Label");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel9, "card2");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DSUBU", "DDIV", "AND", "DSRLV", "SLT", "BEQ", "LW", "LWU", "SW", "DADDIU", "ORI", "J" }));
        jComboBox1.setName("inst"); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel19.setText("Label (optional)");

        jLabel22.setText("Status");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1)
                            .addComponent(jTextField5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jComboBox1.getAccessibleContext().setAccessibleName("");

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        jButton4.setText("Generate Pipeline Map");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel20.setText("Opcode");

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Instruction", "Opcode", "IR0..5", "IR6..10", "IR11..15", "IR16..31"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(1).setResizable(false);
            jTable3.getColumnModel().getColumn(2).setResizable(false);
            jTable3.getColumnModel().getColumn(3).setResizable(false);
            jTable3.getColumnModel().getColumn(4).setResizable(false);
            jTable3.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));

        jLabel24.setText("Registers");

        jLabel25.setText("R1");

        jLabel26.setText("R2");

        jLabel27.setText("R3");

        jLabel28.setText("R4");

        jLabel29.setText("R5");

        jLabel30.setText("R6");

        jLabel31.setText("R7");

        jLabel32.setText("R8");

        jLabel33.setText("R9");

        jLabel34.setText("R10");

        jLabel35.setText("R11");

        jLabel36.setText("R12");

        jLabel37.setText("R13");

        jLabel38.setText("R14");

        jLabel39.setText("R15");

        jLabel40.setText("R16");

        jLabel41.setText("R17");

        jLabel42.setText("R18");

        jLabel43.setText("R19");

        jTextField6.setText("0000000000000000");
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });

        jTextField7.setText("0000000000000000");
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });

        jTextField8.setText("0000000000000000");
        jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField8MouseClicked(evt);
            }
        });

        jTextField9.setText("0000000000000000");
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField9MouseClicked(evt);
            }
        });

        jTextField10.setText("0000000000000000");
        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField10MouseClicked(evt);
            }
        });

        jTextField11.setText("0000000000000000");
        jTextField11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField11MouseClicked(evt);
            }
        });

        jTextField12.setText("0000000000000000");
        jTextField12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField12MouseClicked(evt);
            }
        });

        jTextField13.setText("0000000000000000");
        jTextField13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField13MouseClicked(evt);
            }
        });

        jTextField14.setText("0000000000000000");
        jTextField14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField14MouseClicked(evt);
            }
        });

        jTextField15.setText("0000000000000000");
        jTextField15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField15MouseClicked(evt);
            }
        });

        jTextField16.setText("0000000000000000");
        jTextField16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField16MouseClicked(evt);
            }
        });

        jTextField17.setText("0000000000000000");
        jTextField17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField17MouseClicked(evt);
            }
        });

        jTextField18.setText("0000000000000000");
        jTextField18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField18MouseClicked(evt);
            }
        });

        jTextField19.setText("0000000000000000");
        jTextField19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField19MouseClicked(evt);
            }
        });

        jTextField20.setText("0000000000000000");
        jTextField20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField20MouseClicked(evt);
            }
        });

        jTextField21.setText("0000000000000000");
        jTextField21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField21MouseClicked(evt);
            }
        });

        jTextField22.setText("0000000000000000");
        jTextField22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField22MouseClicked(evt);
            }
        });

        jTextField23.setText("0000000000000000");
        jTextField23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField23MouseClicked(evt);
            }
        });

        jTextField24.setText("0000000000000000");
        jTextField24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField24MouseClicked(evt);
            }
        });

        jLabel44.setText("R20");

        jLabel45.setText("R21");

        jLabel46.setText("R22");

        jLabel47.setText("R23");

        jLabel48.setText("R24");

        jLabel49.setText("R25");

        jLabel50.setText("R26");

        jLabel51.setText("R27");

        jLabel52.setText("R28");

        jLabel53.setText("R29");

        jLabel54.setText("R30");

        jLabel55.setText("R31");

        jLabel56.setText("HI");

        jLabel57.setText("LO");

        jTextField25.setText("0000000000000000");
        jTextField25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField25MouseClicked(evt);
            }
        });

        jTextField26.setText("0000000000000000");
        jTextField26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField26MouseClicked(evt);
            }
        });

        jTextField27.setText("0000000000000000");
        jTextField27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField27MouseClicked(evt);
            }
        });

        jTextField28.setText("0000000000000000");
        jTextField28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField28MouseClicked(evt);
            }
        });

        jTextField29.setText("0000000000000000");
        jTextField29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField29MouseClicked(evt);
            }
        });

        jTextField30.setText("0000000000000000");
        jTextField30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField30MouseClicked(evt);
            }
        });

        jTextField31.setText("0000000000000000");
        jTextField31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField31MouseClicked(evt);
            }
        });

        jTextField32.setText("0000000000000000");
        jTextField32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField32MouseClicked(evt);
            }
        });

        jTextField33.setText("0000000000000000");
        jTextField33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField33MouseClicked(evt);
            }
        });

        jTextField34.setText("0000000000000000");
        jTextField34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField34MouseClicked(evt);
            }
        });

        jTextField35.setText("0000000000000000");
        jTextField35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField35MouseClicked(evt);
            }
        });

        jTextField36.setText("0000000000000000");
        jTextField36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField36MouseClicked(evt);
            }
        });

        jTextField37.setText("0000000000000000");
        jTextField37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField37MouseClicked(evt);
            }
        });

        jTextField38.setText("0000000000000000");
        jTextField38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField38MouseClicked(evt);
            }
        });

        jLabel21.setText("R0");

        jTextField39.setText("0000000000000000");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(10, 10, 10)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField20)
                                .addComponent(jTextField19)
                                .addComponent(jTextField18)
                                .addComponent(jTextField17)
                                .addComponent(jTextField16)
                                .addComponent(jTextField15)
                                .addComponent(jTextField14)
                                .addComponent(jTextField13)
                                .addComponent(jTextField12)
                                .addComponent(jTextField11)
                                .addComponent(jTextField10)
                                .addComponent(jTextField9)
                                .addComponent(jTextField8)))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(11, 11, 11)))
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField6)
                                .addComponent(jTextField7)
                                .addComponent(jTextField39, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField35))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField34))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField33))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField23)
                                .addComponent(jTextField22)
                                .addComponent(jTextField21)))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField38, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField37)))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField36))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField32))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField31))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField30))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField29))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField28))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField27))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField25)
                                .addComponent(jTextField24)
                                .addComponent(jTextField26)))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField39, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField7)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField10)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField11)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField12)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField13)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField14)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField15)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField16)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField17)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField18)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField19)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField20)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField21)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField25)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField26)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField27)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField28)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField29)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField30)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField31)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField32)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField33)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField34)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField35)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jTextField36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jScrollPane2.setViewportView(jPanel12);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Address", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setUpdateSelectionOnSort(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel58.setText("Data Segment");

        jTextField40.setForeground(new java.awt.Color(153, 153, 153));
        jTextField40.setText("Search");
        jTextField40.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField40FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField40FocusLost(evt);
            }
        });
        jTextField40.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField40KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Address", "Representation", "Label", "Instruction"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel18.setText("Code Segment");

        jTextField41.setForeground(new java.awt.Color(153, 153, 153));
        jTextField41.setText("Search");
        jTextField41.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField41FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField41FocusLost(evt);
            }
        });
        jTextField41.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField41KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));

        jButton5.setText("Single");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Full");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel16.setLayout(new java.awt.CardLayout());

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setResizable(false);
            jTable5.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel17, "card2");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable6);
        if (jTable6.getColumnModel().getColumnCount() > 0) {
            jTable6.getColumnModel().getColumn(0).setResizable(false);
            jTable6.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton7.setText("NEXT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel16.add(jPanel18, "card2");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String padZeros(String str, int num) {
        temp = "";
        if (str.length() < num) {
            for (int i = 0; i < num - str.length(); i++) {
                temp = temp + '0';
            }
            str = temp + str;
        }
        return str;
    }

    private String signExtend(String str, int num, String format) {
        temp = "";
        String charStr;
        charStr = Character.toString(str.charAt(0));
        if (format.matches("hex")) {
            if (charStr.matches("8") || charStr.matches("9") || charStr.matches("A")
                    || charStr.matches("B") || charStr.matches("C")
                    || charStr.matches("D") || charStr.matches("E")
                    || charStr.matches("F")) {
                for (int i = 0; i < num - str.length(); i++) {
                    temp = temp + 'F';
                }
                str = temp + str;
            } else {
                for (int i = 0; i < num - str.length(); i++) {
                    temp = temp + '0';
                }
                str = temp + str;
            }
        } else if (format.matches("binary")) {
            if (charStr.matches("1")) {
                for (int i = 0; i < num - str.length(); i++) {
                    temp = temp + '1';
                }
                str = temp + str;
            } else {
                for (int i = 0; i < num - str.length(); i++) {
                    temp = temp + '0';
                }
                str = temp + str;
            }
        }
        if (str.length() > num) {
            str = str.substring(str.length() - num, str.length());
        }
        return str;
    }

    private void InitializeCS() {
        String addTemp = "", repTemp = "00000000";
        for (int i = 0; i < 8192; i += 4) { /////// dito dito
            addTemp = Integer.toHexString(i);
            addTemp = padZeros(addTemp, 4);
            Object[] obj = {addTemp, repTemp};
            codesegmentmodel.addRow(obj);
        }
    }

    private void InitializeDS() {
        String addTemp = "", repTemp = "00";
        for (int i = 8192; i < 16384; i++) {
            addTemp = Integer.toHexString(i);
            addTemp = padZeros(addTemp, 4);
            Object[] obj = {addTemp, repTemp};
            datasegmentmodel.addRow(obj);
        }

        for (int i = 0; i < 8192; i++) {
            datasegment.add("00");
        }
    }

    private void UpdateDS(ArrayList<String> datasegment) {
        datasegmentmodel.getDataVector().removeAllElements();
        datasegmentmodel.fireTableDataChanged();

        String addTemp = "", repTemp = "00";
        for (int i = 0; i < 8192; i++) {
            addTemp = Integer.toHexString(i + 8192);
            addTemp = padZeros(addTemp, 4);
            repTemp = datasegment.get(i);
            Object[] obj = {addTemp, repTemp};
            datasegmentmodel.addRow(obj);
        }
        datasegmentmodel.fireTableDataChanged();
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        instruction = jComboBox1.getSelectedItem().toString();

        //removing panel
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();

        if (instruction.matches("DSUBU") || instruction.matches("AND")
                || instruction.matches("DSRLV") || instruction.matches("SLT")) {
            jPanel3.add(jPanel4);
            jPanel3.repaint();
            jPanel3.revalidate();

        } else if (instruction.matches("DDIV")) {
            jPanel3.add(jPanel5);
            jPanel3.repaint();
            jPanel3.revalidate();

        } else if (instruction.matches("BEQ")) {
            jPanel3.add(jPanel6);
            jPanel3.repaint();
            jPanel3.revalidate();

        } else if (instruction.matches("LW") || instruction.matches("LWU") || instruction.matches("SW")) {
            jPanel3.add(jPanel7);
            jPanel3.repaint();
            jPanel3.revalidate();

        } else if (instruction.matches("DADDIU") || instruction.matches("ORI")) {
            jPanel3.add(jPanel8);
            jPanel3.repaint();
            jPanel3.revalidate();

        } else if (instruction.matches("J")) {
            jPanel3.add(jPanel9);
            jPanel3.repaint();
            jPanel3.revalidate();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void resetAddCommand() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jComboBox6.setSelectedIndex(0);
        jComboBox7.setSelectedIndex(0);
        jComboBox8.setSelectedIndex(0);
        jComboBox9.setSelectedIndex(0);
        jComboBox10.setSelectedIndex(0);
        jComboBox11.setSelectedIndex(0);
        jComboBox12.setSelectedIndex(0);
    }

    public void resetAll() {
        resetAddCommand();
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        instlist.clear();
        cyclelist.clear();
        instlist = new ArrayList<Instruction>();
        cyclelist = new ArrayList<String>();
        register = new Register();
        datasegment.clear();
        opcodemodel.getDataVector().removeAllElements();
        opcodemodel.fireTableDataChanged();
        pipelinemodel.getDataVector().removeAllElements();
        pipelinemodel.fireTableDataChanged();
        codesegmentmodel.getDataVector().removeAllElements();
        codesegmentmodel.fireTableDataChanged();
        datasegmentmodel.getDataVector().removeAllElements();
        datasegmentmodel.fireTableDataChanged();
        fullmodel.getDataVector().removeAllElements();
        fullmodel.fireTableDataChanged();
        singlemodel.getDataVector().removeAllElements();
        singlemodel.fireTableDataChanged();
        InitializeCS();
        InitializeDS();
        register.setRegister(new ArrayList<String>(Collections.nCopies(32, "0000000000000000")));
        for (int i = 0; i < 32; i++) {
            setRegister(i, register.getRegister(i), register);
        }
        register.setHi("00000000");
        jTextField37.setText(register.getHi());
        register.setLo("00000000");
        jTextField38.setText(register.getLo());
        jLabel23.setText("");
        pc = 0;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jButton2.setEnabled(true);
        instruction = jComboBox1.getSelectedItem().toString();
        tempinst = new Instruction();
        labeladdress = jTextField5.getText().toUpperCase();
        m = labelcheck.matcher(labeladdress);
        if (labeladdress.matches("")) {
            labeladdress = "NO LABEL";
            proceed = true;
        } else if (labeladdress.matches("DSUBU") || labeladdress.matches("AND") || labeladdress.matches("DSRLV")
                || labeladdress.matches("SLT") || labeladdress.matches("DDIV") || labeladdress.matches("BEQ")
                || labeladdress.matches("LW") || labeladdress.matches("LWU") || labeladdress.matches("SW")
                || labeladdress.matches("DADDIU") || labeladdress.matches("ORI") || labeladdress.matches("J")) {
            proceed = false;
        } else {
            if (!m.find()) { //check for special characters and digits at the beginning of the label
                proceed = false;
            } else {
                proceed = true;

                for (int i = 0; i < instlist.size(); i++) { //check if label exists
                    if (instlist.get(i).getLabel().matches(labeladdress)) {
                        proceed = false;
                    }
                }
            }
        }

        if (proceed) {
            if (instruction.matches("DSUBU") || instruction.matches("DDIV") || instruction.matches("AND")
                    || instruction.matches("DSRLV") || instruction.matches("SLT")) {

                //increment pc by 4
                pc = pc + 4;
                tempinst.setPc(padZeros(Integer.toHexString(pc), 16));

                if (instruction.matches("DDIV")) {
                    rs = jComboBox5.getSelectedIndex();
                    rt = jComboBox6.getSelectedIndex();
                    if (rt == 0) {
                        JOptionPane.showMessageDialog(null, "ERROR: Division by zero.");
                    }
                } else {
                    rd = jComboBox4.getSelectedIndex();
                    rs = jComboBox2.getSelectedIndex();
                    rt = jComboBox3.getSelectedIndex();
                }

                //opcode binary
                opcodebin = "000000";

                //rs binary
                rsbin = Integer.toBinaryString(rs);
                rsbin = padZeros(rsbin, 5);

                //rt binary
                temp = "";
                rtbin = Integer.toBinaryString(rt);
                rtbin = padZeros(rtbin, 5);

                //rd binary
                if (instruction.matches("DDIV")) {
                    rdbin = "00000";
                } else {
                    rdbin = Integer.toBinaryString(rd);
                    rdbin = padZeros(rdbin, 5);
                }

                //additional 5 bits
                addbin = "00000";

                //function
                if (instruction.matches("DSUBU")) {
                    func = 47;
                } else if (instruction.matches("DDIV")) {
                    func = 30;
                } else if (instruction.matches("AND")) {
                    func = 36;
                } else if (instruction.matches("DSRLV")) {
                    func = 22;
                } else if (instruction.matches("SLT")) {
                    func = 42;
                }
                funcbin = Integer.toBinaryString(func);
                funcbin = padZeros(funcbin, 6);

                //address in binary
                addressbin = opcodebin + rsbin + rtbin + rdbin + addbin + funcbin;

                //convert to hex
                addresshex = new BigInteger(addressbin, 2).toString(16);
                addresshex = padZeros(addresshex, 8);

                tempinst.setOpcode(addresshex.toUpperCase());
                tempinst.setLabel(labeladdress);

                if (instruction.matches("DDIV")) {
                    tempinst.setInst(instruction + " R" + rs + ", R" + rt);
                    //store dependency
                    if (rs == 0 && rt == 0) {
                        tempinst.setDependency("none");
                    } else if (rs == 0) {
                        tempinst.setDependency('R' + Integer.toString(rt));
                    } else if (rt == 0) {
                        tempinst.setDependency('R' + Integer.toString(rs));
                    } else {
                        tempinst.setDependency('R' + Integer.toString(rs) + ", R" + Integer.toString(rt));
                    }
                    tempinst.setAnswer("none");
                    if (labeladdress.matches("NO LABEL")) {
                        Object[] obj = {instruction + " R" + rs + ", R" + rt, ' '};
                        opcodemodel.addRow(obj);
                    } else {
                        Object[] obj = {labeladdress + ": " + instruction + " R" + rs + ", R" + rt, ' '};
                        opcodemodel.addRow(obj);
                    }
                } else {
                    tempinst.setInst(instruction + " R" + rd + ", R" + rs + ", R" + rt);
                    //store dependency
                    if (rs == 0 && rt == 0) {
                        tempinst.setDependency("none");
                    } else if (rs == 0) {
                        tempinst.setDependency('R' + Integer.toString(rt));
                    } else if (rt == 0) {
                        tempinst.setDependency('R' + Integer.toString(rs));
                    } else {
                        tempinst.setDependency('R' + Integer.toString(rs) + ", R" + Integer.toString(rt));
                    }
                    tempinst.setAnswer('R' + Integer.toString(rd));
                    if (labeladdress.matches("NO LABEL")) {
                        Object[] obj = {instruction + " R" + rd + ", R" + rs + ", R" + rt, ' '};
                        opcodemodel.addRow(obj);
                    } else {
                        Object[] obj = {labeladdress + ": " + instruction + " R" + rd + ", R" + rs + ", R" + rt, ' '};
                        opcodemodel.addRow(obj);
                    }
                }
                if (instlist.add(tempinst)) {
                    jLabel23.setText("Successfully added!");
                }
            } else if (instruction.matches("BEQ")) {
                m = labelcheck.matcher(jTextField1.getText());
                if (jTextField1.getText().matches("") || !m.find()) { //special characters or null
                    jLabel23.setText("Invalid Label");
                } else if (jTextField1.getText().matches("DSUBU") || jTextField1.getText().matches("AND") || jTextField1.getText().matches("DSRLV")
                        || jTextField1.getText().matches("SLT") || jTextField1.getText().matches("DDIV") || jTextField1.getText().matches("BEQ")
                        || jTextField1.getText().matches("LW") || jTextField1.getText().matches("LWU") || jTextField1.getText().matches("SW")
                        || jTextField1.getText().matches("DADDIU") || jTextField1.getText().matches("ORI") || jTextField1.getText().matches("J")) {
                    jLabel23.setText("Invalid Label");
                } else {
                    //increment pc by 4
                    pc = pc + 4;
                    tempinst.setPc(padZeros(Integer.toHexString(pc), 16));

                    rs = jComboBox7.getSelectedIndex();
                    rt = jComboBox8.getSelectedIndex();

                    opcodebin = "000100";

                    //rs binary
                    rsbin = Integer.toBinaryString(rs);
                    rsbin = padZeros(rsbin, 5);

                    //rt binary
                    rtbin = Integer.toBinaryString(rt);
                    rtbin = padZeros(rtbin, 5);

                    addressbin = opcodebin + rsbin + rtbin;

                    tempinst.setInst(instruction + " R" + jComboBox7.getSelectedItem() + ", R" + jComboBox8.getSelectedItem() + ", " + jTextField1.getText().toUpperCase());
                    if (labeladdress.matches("NO LABEL")) {
                        Object[] obj = {instruction + " R" + jComboBox7.getSelectedItem() + ", R" + jComboBox8.getSelectedItem() + ", " + jTextField1.getText().toUpperCase(), ' '};
                        opcodemodel.addRow(obj);
                    } else {
                        Object[] obj = {labeladdress + ": " + instruction + " R" + jComboBox7.getSelectedItem() + ", R" + jComboBox8.getSelectedItem() + ", " + jTextField1.getText().toUpperCase(), ' '};
                        opcodemodel.addRow(obj);
                    }
                    if (rs != 0 && rt != 0) {
                        tempinst.setDependency('R' + Integer.toString(rs) + ", R" + Integer.toString(rt));
                    } else if (rs != 0) {
                        tempinst.setDependency('R' + Integer.toString(rs));
                    } else if (rt != 0) {
                        tempinst.setDependency('R' + Integer.toString(rt));
                    } else {
                        tempinst.setDependency("none");
                    }

                    tempinst.setAnswer("none");
                    tempinst.setOpcode(addressbin);
                    tempinst.setLabel(labeladdress);
                    if (instlist.add(tempinst)) {
                        jLabel23.setText("Successfully added!");
                    }
                }

            } else if (instruction.matches("LW") || instruction.matches("LWU") || instruction.matches("SW")) {
                m = immediate.matcher(jTextField2.getText());
                if (jTextField2.getText().matches("") || jTextField2.getText().length() > 4 || m.find()) {
                    jLabel23.setText("Invalid Offset");
                } else {

                    if (Integer.parseInt(jTextField2.getText(), 16) < 8192 || Integer.parseInt(jTextField2.getText(), 16) > 16383) {
                        jLabel23.setText("Invalid Offset");
                    } else {
                        rd = jComboBox9.getSelectedIndex();
                        rs = jComboBox10.getSelectedIndex();

                        //increment pc by 4
                        pc = pc + 4;
                        tempinst.setPc(padZeros(Integer.toHexString(pc), 16));

                        //opcode binary
                        if (instruction.matches("LW")) {
                            opcode = 35;
                        } else if (instruction.matches("LWU")) {
                            opcode = 39;
                        } else if (instruction.matches("SW")) {
                            opcode = 43;
                        }

                        opcodebin = Integer.toBinaryString(opcode);
                        opcodebin = padZeros(opcodebin, 6);

                        //rd binary
                        rdbin = Integer.toBinaryString(rd);
                        rdbin = padZeros(rdbin, 5);

                        //rs binary
                        rsbin = Integer.toBinaryString(rs);
                        rsbin = padZeros(rsbin, 5);

                        offsetbin = Integer.toBinaryString(Integer.parseInt(jTextField2.getText(), 16));
                        offsetbin = padZeros(offsetbin, 16);

                        //address in binary
                        addressbin = opcodebin + rsbin + rdbin + offsetbin;

                        addresshex = new BigInteger(addressbin, 2).toString(16);
                        addresshex = padZeros(addresshex, 8);

                        tempinst.setOpcode(addresshex.toUpperCase());

                        tempinst.setInst(instruction + " R" + jComboBox9.getSelectedItem() + ", " + jTextField2.getText().toUpperCase() + "(R" + jComboBox10.getSelectedItem() + ")");
                        tempinst.setLabel(labeladdress);

                        if (labeladdress.matches("NO LABEL")) {
                            Object[] obj = {instruction + " R" + jComboBox9.getSelectedItem() + ", " + jTextField2.getText().toUpperCase() + "(R" + jComboBox10.getSelectedItem() + ")", ' '};
                            opcodemodel.addRow(obj);
                        } else {
                            Object[] obj = {labeladdress + ": " + instruction + " R" + jComboBox9.getSelectedItem() + ", " + jTextField2.getText().toUpperCase() + "(R" + jComboBox10.getSelectedItem() + ")", ' '};
                            opcodemodel.addRow(obj);
                        }

                        if (instruction.matches("SW")) {
                            //store dependency
                            if (rd == 0 && rs == 0) {
                                tempinst.setDependency("none");
                            } else if (rd == 0) {
                                tempinst.setDependency('R' + Integer.toString(rs));
                            } else if (rs == 0) {
                                tempinst.setDependency('R' + Integer.toString(rd));
                            } else {
                                tempinst.setDependency('R' + Integer.toString(rd) + ", R" + Integer.toString(rs));
                            }
                            tempinst.setAnswer("none");
                        } else {
                            if (rs != 0) {
                                tempinst.setDependency('R' + Integer.toString(rs));
                            } else {
                                tempinst.setDependency("none");
                            }
                            tempinst.setAnswer('R' + Integer.toString(rd));
                        }
                        if (instlist.add(tempinst)) {
                            jLabel23.setText("Successfully added!");
                        }
                    }
                }

            } else if (instruction.matches("DADDIU") || instruction.matches("ORI")) {
                m = immediate.matcher(jTextField3.getText());
                if (jTextField3.getText().matches("") || jTextField3.getText().length() > 4 || m.find()) {
                    jLabel23.setText("Invalid Offset");
                } else {
                    rd = jComboBox11.getSelectedIndex();
                    rs = jComboBox12.getSelectedIndex();

                    //increment pc by 4
                    pc = pc + 4;
                    tempinst.setPc(padZeros(Integer.toHexString(pc), 16));

                    if (instruction.matches("DADDIU")) {
                        opcode = 25;
                    } else if (instruction.matches("ORI")) {
                        opcode = 13;
                    }

                    opcodebin = Integer.toBinaryString(opcode);
                    opcodebin = padZeros(opcodebin, 6);

                    //rs binary
                    rsbin = Integer.toBinaryString(rs);
                    rsbin = padZeros(rsbin, 5);

                    //rd binary
                    rdbin = Integer.toBinaryString(rd);
                    rdbin = padZeros(rdbin, 5);

                    offsetbin = Integer.toBinaryString(Integer.parseInt(jTextField3.getText(), 16));
                    offsetbin = padZeros(offsetbin, 16);

                    //address in binary
                    addressbin = opcodebin + rsbin + rdbin + offsetbin;

                    //address in hex
                    addresshex = new BigInteger(addressbin, 2).toString(16);
                    addresshex = padZeros(addresshex, 8);

                    tempinst.setInst(instruction + " R" + jComboBox11.getSelectedItem() + ", R" + jComboBox12.getSelectedItem() + ", #" + jTextField3.getText().toUpperCase());

                    if (labeladdress.matches("NO LABEL")) {
                        Object[] obj = {instruction + " R" + jComboBox11.getSelectedItem() + ", R" + jComboBox12.getSelectedItem() + ", #" + jTextField3.getText().toUpperCase(), ' '};
                        opcodemodel.addRow(obj);
                    } else {
                        Object[] obj = {labeladdress + ": " + instruction + " R" + jComboBox11.getSelectedItem() + ", R" + jComboBox12.getSelectedItem() + ", #" + jTextField3.getText().toUpperCase(), ' '};
                        opcodemodel.addRow(obj);
                    }

                    //store dependency
                    if (rs == 0) {
                        tempinst.setDependency("none");
                    } else {
                        tempinst.setDependency('R' + Integer.toString(rs));
                    }
                    tempinst.setAnswer('R' + Integer.toString(rd));
                    tempinst.setOpcode(addresshex.toUpperCase());
                    tempinst.setLabel(labeladdress);

                    if (instlist.add(tempinst)) {
                        jLabel23.setText("Successfully added!");
                    }
                }

            } else if (instruction.matches("J")) {
                m = labelcheck.matcher(jTextField4.getText());
                if (jTextField4.getText().matches("") || !m.find()) { //special characters
                    jLabel23.setText("Invalid Offset");
                } else {

                    //increment pc by 4
                    pc = pc + 4;
                    tempinst.setPc(padZeros(Integer.toHexString(pc), 16));

                    opcodebin = "000010";
                    tempinst.setInst(instruction + " " + jTextField4.getText().toUpperCase());

                    if (labeladdress.matches("NO LABEL")) {
                        Object[] obj = {instruction + " " + jTextField4.getText().toUpperCase(), ' '};
                        opcodemodel.addRow(obj);
                    } else {
                        Object[] obj = {labeladdress + ": " + instruction + " " + jTextField4.getText().toUpperCase(), ' '};
                        opcodemodel.addRow(obj);
                    }
                    tempinst.setAnswer("none");
                    tempinst.setDependency("none");
                    tempinst.setOpcode(opcodebin);
                    tempinst.setLabel(labeladdress);
                    if (instlist.add(tempinst)) {
                        jLabel23.setText("Successfully Added!");
                    }
                }
            }
        } else {
            jLabel23.setText("Invalid label");
        }

        resetAddCommand();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jLabel23.setText("");
        opcodemodel.getDataVector().removeAllElements();
        opcodemodel.fireTableDataChanged();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton4.setEnabled(true);
        boolean proceed = true;
        int i, j, offset;
        String label;
        for (i = 0; i < instlist.size(); i++) {
            if (instlist.get(i).getInst().contains("BEQ")) {
                label = instlist.get(i).getInst().substring(instlist.get(i).getInst().lastIndexOf(", ") + 2);
                for (j = 0; j < instlist.size(); j++) {
                    if (instlist.get(j).getLabel().matches(label)) {
                        break;
                    }
                }
                if (j == instlist.size()) { //label not found
                    proceed = false;
                } else { //label above
                    offset = j - (i + 1);
                    if (offset > 0) {
                        offsetbin = Integer.toBinaryString(offset);
                        offsetbin = padZeros(offsetbin, 16);
                    } else {
                        offsetbin = Integer.toBinaryString(offset);
                        offsetbin = signExtend(offsetbin, 16, "binary");
                    }

                    offsetbin = instlist.get(i).getOpcode() + offsetbin;

                    addresshex = new BigInteger(offsetbin, 2).toString(16);
                    addresshex = padZeros(addresshex, 8);
                    instlist.get(i).setOpcode(addresshex.toUpperCase());
                }
            } else if (instlist.get(i).getInst().contains("J")) {
                int ctr = 0;
                label = instlist.get(i).getInst().substring(2);
                for (j = 0; j < instlist.size(); j++) {
                    if (instlist.get(j).getLabel().matches(label)) {
                        break;
                    }
                }
                if (j == instlist.size()) { //label not found
                    proceed = false;
                } else {
                    ctr = ((Integer.parseInt(instlist.get(j).getPc(), 16)) - 4) / 4;
                    offsetbin = Integer.toBinaryString(ctr);
                    offsetbin = padZeros(offsetbin, 26);
                    offsetbin = instlist.get(i).getOpcode() + offsetbin;

                    addresshex = new BigInteger(offsetbin, 2).toString(16);
                    addresshex = padZeros(addresshex, 8);
                    instlist.get(i).setOpcode(addresshex.toUpperCase());
                }
            }
        }

        if (proceed) {
            String binvalue = "";
            for (i = 0; i < instlist.size(); i++) {
                binvalue = new BigInteger(instlist.get(i).getOpcode(), 16).toString(2);
                binvalue = padZeros(binvalue, 32);
                if (instlist.get(i).getLabel().matches("NO LABEL")) {
                    Object[] obj = {instlist.get(i).getInst(), instlist.get(i).getOpcode(), binvalue.substring(0, 6), binvalue.substring(6, 11), binvalue.substring(11, 16), binvalue.substring(16, 20) + " " + binvalue.substring(20, 24) + " " + binvalue.substring(24, 28) + " " + binvalue.substring(28, 32)};
                    opcodemodel.addRow(obj);

                    codesegmentmodel.setValueAt(instlist.get(i).getOpcode(), i, 1);
                    codesegmentmodel.setValueAt(instlist.get(i).getInst(), i, 3);
                    codesegmentmodel.fireTableDataChanged();

                } else {
                    Object[] obj = {instlist.get(i).getLabel() + ": " + instlist.get(i).getInst(), instlist.get(i).getOpcode(), binvalue.substring(0, 6), binvalue.substring(6, 11), binvalue.substring(11, 16), binvalue.substring(16, 20) + " " + binvalue.substring(20, 24) + " " + binvalue.substring(24, 28) + " " + binvalue.substring(28, 32)};
                    opcodemodel.addRow(obj);

                    codesegmentmodel.setValueAt(instlist.get(i).getOpcode(), i, 1);
                    codesegmentmodel.setValueAt(instlist.get(i).getLabel(), i, 2);
                    codesegmentmodel.setValueAt(instlist.get(i).getInst(), i, 3);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Label not found", "Error", JOptionPane.ERROR_MESSAGE);
            resetAll();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        resetAll();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addCycle(int instnum, int at) {
        for (int i = 0; i < pipeline.size(); i++) {
            if (at < cyclelist.size()) {
                cyclelist.set(at, cyclelist.get(at) + ", Inst" + Integer.toString(instnum) + " " + pipeline.get(i));
            } else {
                cyclelist.add("Inst" + Integer.toString(instnum) + " " + pipeline.get(i));
            }
            at++;
        }
    }

    private void addIf(int instnum, int at) {
        cyclelist.set(at, cyclelist.get(at) + ", Inst" + Integer.toString(instnum) + " IF");
    }

    private void addStall(int instnum, int at, int range) {
        for (int i = 0; i < range + 1; i++) {
            if (at < cyclelist.size()) {
                cyclelist.set(at, cyclelist.get(at) + ", Inst" + Integer.toString(instnum) + " *");
            } else {
                cyclelist.add("Inst" + Integer.toString(instnum) + " *");
            }
            at++;
        }
    }

    private void addCont(int instnum, int at) {
        for (int i = 1; i < pipeline.size(); i++) {
            if (at < cyclelist.size()) {
                cyclelist.set(at, cyclelist.get(at) + ", Inst" + Integer.toString(instnum) + " " + pipeline.get(i));
            } else {
                cyclelist.add("Inst" + Integer.toString(instnum) + " " + pipeline.get(i));
            }
            at++;
        }
    }

    private void setRegister(int reg, String value, Register register) {
        value = padZeros(value, 16).toUpperCase();
        register.setRegister(reg, value);

        switch (reg) {
            case 0: {
                break;
            }
            case 1: {
                jTextField6.setText(value);
                break;
            }
            case 2: {
                jTextField7.setText(value);
                break;
            }
            case 3: {
                jTextField8.setText(value);
                break;
            }
            case 4: {
                jTextField9.setText(value);
                break;
            }
            case 5: {
                jTextField10.setText(value);
                break;
            }
            case 6: {
                jTextField11.setText(value);
                break;
            }
            case 7: {
                jTextField12.setText(value);
                break;
            }
            case 8: {
                jTextField13.setText(value);
                break;
            }
            case 9: {
                jTextField14.setText(value);
                break;
            }
            case 10: {
                jTextField15.setText(value);
                break;
            }
            case 11: {
                jTextField16.setText(value);
                break;
            }
            case 12: {
                jTextField17.setText(value);
                break;
            }
            case 13: {
                jTextField18.setText(value);
                break;
            }
            case 14: {
                jTextField19.setText(value);
                break;
            }
            case 15: {
                jTextField20.setText(value);
                break;
            }
            case 16: {
                jTextField21.setText(value);
                break;
            }
            case 17: {
                jTextField22.setText(value);
                break;
            }
            case 18: {
                jTextField23.setText(value);
                break;
            }
            case 19: {
                jTextField24.setText(value);
                break;
            }
            case 20: {
                jTextField25.setText(value);
                break;
            }
            case 21: {
                jTextField26.setText(value);
                break;
            }
            case 22: {
                jTextField27.setText(value);
                break;
            }
            case 23: {
                jTextField28.setText(value);
                break;
            }
            case 24: {
                jTextField29.setText(value);
                break;
            }
            case 25: {
                jTextField30.setText(value);
                break;
            }
            case 26: {
                jTextField31.setText(value);
                break;
            }
            case 27: {
                jTextField32.setText(value);
                break;
            }
            case 28: {
                jTextField33.setText(value);
                break;
            }
            case 29: {
                jTextField34.setText(value);
                break;
            }
            case 30: {
                jTextField35.setText(value);
                break;
            }
            case 31: {
                jTextField36.setText(value);
                break;
            }
        }

    }

    public void addIFtoWB(int index) {
        String IR = "", NPC = "", PC = "";
        String A = "", B = "", IMM = "", ALUOUTPUT = "", LMD = "", MEMALU = "";
        String charA, charB;
        int COND = 0, tempint;
        long templong, templo, temphi;
        String tempstr, tempA, tempB;

        //IF
        IR = instlist.get(index).getOpcode();
        NPC = instlist.get(index).getPc();
        PC = instlist.get(index).getPc();
        instlist.get(index).setIF(IR, NPC, PC);

        //ID
        tempstr = new BigInteger(instlist.get(index).getOpcode(), 16).toString(2);
        tempstr = padZeros(tempstr, 32);
        tempint = Integer.parseInt(tempstr.substring(6, 11), 2);
        A = register.getRegister(tempint);

        tempint = Integer.parseInt(tempstr.substring(11, 16), 2);
        B = register.getRegister(tempint);

        IMM = instlist.get(index).getOpcode().substring(4, 8);
        IMM = padZeros(IMM, 16);

        instlist.get(index).setID(A, B, IMM, IR);

        //EX
        if (instlist.get(index).getInst().contains("DSUBU")) {
            BigInteger difference;
            difference = new BigInteger(instlist.get(index).getID().getA(), 16).subtract(new BigInteger(instlist.get(index).getID().getB(), 16));

            if (difference.compareTo(new BigInteger("0", 10)) == -1) {
                ALUOUTPUT = Long.toHexString(difference.longValue());
                System.out.println(ALUOUTPUT);
            } else {
                ALUOUTPUT = difference.toString(16).toUpperCase();
            }

            COND = 0;
        } else if (instlist.get(index).getInst().contains("DDIV")) {
            System.out.println("here");
            BigInteger quotient, remainder;
            try {
                /*
                 templo = Long.parseLong(instlist.get(index).getID().getA(), 16) / Long.parseLong(instlist.get(index).getID().getB());
                 temphi = Long.parseLong(instlist.get(index).getID().getA(), 16) % Long.parseLong(instlist.get(index).getID().getB());
                
                 System.out.println(templo);
                 System.out.println(temphi);

                 register.setLo(padZeros(Long.toHexString(templo).toUpperCase(), 16));
                 register.setHi(padZeros(Long.toHexString(temphi).toUpperCase(), 16));
                 */

                System.out.println(new BigInteger(instlist.get(index).getID().getA(), 10));
                System.out.println(new BigInteger(instlist.get(index).getID().getB(), 10));
                quotient = new BigInteger(instlist.get(index).getID().getA(), 10).divide(new BigInteger(instlist.get(index).getID().getB(), 10));
                remainder = new BigInteger(instlist.get(index).getID().getA(), 10).mod(new BigInteger(instlist.get(index).getID().getB(), 10));

                if (quotient.compareTo(new BigInteger("0", 10)) == -1) {
                    ALUOUTPUT = Long.toHexString(quotient.longValue());
                    register.setLo(ALUOUTPUT);
                } else {
                    register.setLo(padZeros(quotient.toString(16).toUpperCase(), 16));
                }

                if (remainder.compareTo(new BigInteger("0", 10)) == -1) {
                    ALUOUTPUT = Long.toHexString(remainder.longValue());
                    register.setHi(ALUOUTPUT);
                } else {
                    register.setHi(padZeros(remainder.toString(16).toUpperCase(), 16));
                }

            } catch (Exception e) {
                register.setLo(padZeros("0", 16));
                register.setHi(padZeros("0", 16));
            }

            COND = 0;
        } else if (instlist.get(index).getInst().contains("AND")) {
            ALUOUTPUT = new BigInteger(A, 16).and(new BigInteger(B, 16)).toString(16);

            COND = 0;
        } else if (instlist.get(index).getInst().contains("DSRLV")) {
            String answer;
            tempA = Integer.toBinaryString(Integer.parseInt(A, 16));
            tempA = padZeros(tempA, 64);
            tempB = padZeros(new BigInteger(B, 16).toString(2), 64);
            tempB = tempB.substring(58, 64);
            tempint = Integer.parseInt(tempB, 2);
            answer = tempA.substring(0, 64 - tempint);
            answer = padZeros(answer, 64);            

            ALUOUTPUT = new BigInteger(answer, 2).toString(16);
            ALUOUTPUT = padZeros(ALUOUTPUT, 16);

            COND = 0;
        } else if (instlist.get(index).getInst().contains("SLT")) {
            Long cmpA, cmpB;
            String Abin, Bbin, sltalu = "";
            int m, in, ctr = 0;
            charA = "";
            charB = "";

            if (instlist.get(index).getID().getA().substring(0, 1).matches("8") || instlist.get(index).getID().getA().substring(0, 1).matches("9")
                    || instlist.get(index).getID().getA().substring(0, 1).matches("A") || instlist.get(index).getID().getA().substring(0, 1).matches("B")
                    || instlist.get(index).getID().getA().substring(0, 1).matches("C") || instlist.get(index).getID().getA().substring(0, 1).matches("D")
                    || instlist.get(index).getID().getA().substring(0, 1).matches("E") || instlist.get(index).getID().getA().substring(0, 1).matches("F")) {
                Abin = new BigInteger(instlist.get(index).getID().getA(), 16).toString(2);
                Abin = padZeros(Abin, 64);

                in = 63;
                for (m = 0; m < 64; m++) {
                    charA = Character.toString(Abin.charAt(in));
                    if (m == 0) {
                        if (charA.matches("0")) {
                            while (charA.matches("0")) {
                                sltalu = "0" + sltalu;
                                in--;
                                m++;
                                charA = Character.toString(Abin.charAt(in));
                            }
                            sltalu = "1" + sltalu;
                            in--;
                        } else {
                            sltalu = "1" + sltalu;
                            in--;
                        }
                    } else {
                        if (charA.matches("0")) {
                            sltalu = "1" + sltalu;
                        } else if (charA.matches("1")) {
                            sltalu = "0" + sltalu;
                        }
                        in--;
                    }
                }
                cmpA = 0 - new BigInteger(sltalu, 2).longValue();
            } else {
                cmpA = Long.parseLong(new BigInteger(instlist.get(index).getID().getA(), 16).toString(2), 2);
            }

            if (instlist.get(index).getID().getB().substring(0, 1).matches("8") || instlist.get(index).getID().getB().substring(0, 1).matches("9")
                    || instlist.get(index).getID().getB().substring(0, 1).matches("A") || instlist.get(index).getID().getB().substring(0, 1).matches("B")
                    || instlist.get(index).getID().getB().substring(0, 1).matches("C") || instlist.get(index).getID().getB().substring(0, 1).matches("D")
                    || instlist.get(index).getID().getB().substring(0, 1).matches("E") || instlist.get(index).getID().getB().substring(0, 1).matches("F")) {
                Bbin = new BigInteger(instlist.get(index).getID().getB(), 16).toString(2);
                Bbin = padZeros(Bbin, 64);

                in = 63;
                for (m = 0; m < 64; m++) {
                    charB = Character.toString(Bbin.charAt(in));
                    if (m == 0) {
                        if (charB.matches("0")) {
                            while (charB.matches("0")) {
                                sltalu = "0" + sltalu;
                                in--;
                                m++;
                                charA = Character.toString(Bbin.charAt(in));

                            }
                            sltalu = "1" + sltalu;
                            in--;
                        } else {
                            sltalu = "1" + sltalu;
                            in--;
                        }
                    } else {
                        if (charB.matches("0")) {
                            sltalu = "1" + sltalu;
                        } else {
                            sltalu = "0" + sltalu;
                        }
                        in--;
                    }
                }
                cmpB = 0 - new BigInteger(sltalu, 2).longValue();
            } else {
                cmpB = Long.parseLong(new BigInteger(instlist.get(index).getID().getB(), 16).toString(2), 2);
            }

            if (cmpA < cmpB) {
                ALUOUTPUT = padZeros("1", 16);
            } else {
                ALUOUTPUT = padZeros("0", 16);
            }

            COND = 0;
        } else if (instlist.get(index).getInst().contains("BEQ")) {
            templong = Long.parseLong(instlist.get(index).getIF().getNPC(), 16) + (Long.parseLong(IMM, 16) * 4);

            ALUOUTPUT = Long.toHexString(templong).toUpperCase();
            ALUOUTPUT = padZeros(ALUOUTPUT, 16);

            if (A.matches(B)) {
                COND = 1;
            } else {
                COND = 0;
            }
        } else if (instlist.get(index).getInst().contains("LWU")
                || instlist.get(index).getInst().contains("SW")
                || instlist.get(index).getInst().contains("LW")) {
            templong = Long.parseLong(instlist.get(index).getID().getA(), 16) + Long.parseLong(instlist.get(index).getID().getIMM(), 16);
            if (templong < 8192 || templong > 16383) {
                JOptionPane.showMessageDialog(null, "Data segment address not found", "Error", JOptionPane.ERROR_MESSAGE);
                resetAll();
            } else {
                ALUOUTPUT = Long.toHexString(templong).toUpperCase();
                ALUOUTPUT = padZeros(ALUOUTPUT, 16);
            }

            COND = 0;
        } else if (instlist.get(index).getInst().contains("DADDIU")) {
            templong = Long.parseLong(instlist.get(index).getID().getA(), 16) + Long.parseLong(instlist.get(index).getID().getIMM(), 16);
            ALUOUTPUT = Long.toHexString(templong).toUpperCase();
            ALUOUTPUT = padZeros(ALUOUTPUT, 16);

            COND = 0;
        } else if (instlist.get(index).getInst().contains("ORI")) {
            tempA = new BigInteger(A, 16).toString(2);
            tempB = new BigInteger(IMM, 16).toString(2);
            tempA = padZeros(tempA, 64);
            tempB = padZeros(tempB, 64);

            tempstr = "";
            for (int i = 0; i < 64; i++) {
                charA = Character.toString(tempA.charAt(i));
                charB = Character.toString(tempB.charAt(i));
                if (charA.matches("0") && charB.matches("0")) {
                    tempstr = tempstr + '0';
                } else {
                    tempstr = tempstr + '1';
                }
            }

            ALUOUTPUT = new BigInteger(tempstr, 2).toString(16).toUpperCase();
            ALUOUTPUT = padZeros(ALUOUTPUT, 16);

            COND = 0;
        } else if (instlist.get(index).getInst().contains("J")) {
            ALUOUTPUT = Long.toHexString(Long.parseLong(IMM, 16) * 4).toUpperCase();
            ALUOUTPUT = padZeros(ALUOUTPUT, 16);

            COND = 1;
        }

        instlist.get(index).setEX(IR, ALUOUTPUT, B, COND);

        //MEM
        IR = instlist.get(index).getOpcode();

        if (instlist.get(index).getInst().contains("DSUBU")
                || instlist.get(index).getInst().contains("DDIV")
                || instlist.get(index).getInst().contains("AND")
                || instlist.get(index).getInst().contains("DSRLV")
                || instlist.get(index).getInst().contains("SLT")
                || instlist.get(index).getInst().contains("DADDIU")
                || instlist.get(index).getInst().contains("ORI")) {
            ALUOUTPUT = instlist.get(index).getEX().getALUOUTPUT();

            LMD = "N/A";
            MEMALU = "N/A";
        } else if (instlist.get(index).getInst().contains("LW") || instlist.get(index).getInst().contains("LWU")) {
            temp = "";
            LMD = "";
            tempstr = ALUOUTPUT.substring(12, 16);
            for (int x = 0; x < 8192; x++) {
                if (LMD.length() != 8) {
                    if (tempstr.matches(Long.toHexString(x + 8192))) {
                        LMD = LMD + datasegment.get(x);
                        tempstr = Long.toHexString(Long.parseLong(tempstr, 16) + 1);
                    }
                } else {
                    break;
                }
            }
            LMD = LMD.toUpperCase();
            if (instlist.get(index).getInst().contains("LWU")) {
                LMD = padZeros(LMD, 16);
            } else if (instlist.get(index).getInst().contains("LW")) {
                LMD = signExtend(LMD, 16, "hex");
            }

            ALUOUTPUT = instlist.get(index).getEX().getALUOUTPUT();
            MEMALU = "N/A";
        } else if (instlist.get(index).getInst().contains("SW")) {
            tempstr = instlist.get(index).getEX().getALUOUTPUT().substring(12, 16);
            tempint = Integer.parseInt(tempstr, 16) - 8192;
            tempB = instlist.get(index).getID().getB().substring(8, 16);
            int from, to;
            from = 8;
            to = 10;

            for (int x = tempint; x < tempint + 4; x++) {
                tempB = instlist.get(index).getID().getB().substring(from, to);
                datasegment.set(x, tempB);
                from = from + 2;
                to = to + 2;
            }
            MEMALU = Integer.toHexString(tempint).toString() + "-" + Integer.toHexString(tempint + 4).toString();
            LMD = "N/A";
            ALUOUTPUT = instlist.get(index).getEX().getALUOUTPUT();
        } else if (instlist.get(index).getInst().contains("BEQ")
                || instlist.get(index).getInst().contains("J")) {

            LMD = "N/A";
            ALUOUTPUT = instlist.get(index).getEX().getALUOUTPUT();
            MEMALU = "N/A";
        }

        instlist.get(index).setMEM(IR, ALUOUTPUT, LMD, MEMALU);

        //WB
        tempstr = instlist.get(index).getAnswer().substring(1);

        if (tempstr.contains("one")) {
            if (instlist.get(index).getInst().contains("DDIV")) {
                instlist.get(index).setWB("N/A", "N/A", register.getHi(), register.getLo());
            } else {
                instlist.get(index).setWB("N/A", "N/A", "N/A", "N/A");
            }
        } else {
            tempint = Integer.parseInt(tempstr);

            if (instlist.get(index).getInst().contains("LW")
                    || instlist.get(index).getInst().contains("LWU")) {
                register.setRegister(tempint, LMD);
                instlist.get(index).setWB(Integer.toString(tempint), LMD, "N/A", "N/A");
            } else {
                register.setRegister(tempint, ALUOUTPUT);
                instlist.get(index).setWB(Integer.toString(tempint), ALUOUTPUT, "N/A", "N/A");
            }
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        initialregister = new Register(register);
        datasegmentinitial = new ArrayList<String>(datasegment);
        jButton4.setEnabled(false);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        String label;
        int startsat = 0;
        int depCheck = -1, j = 0;
        String IR, NPC, PC;

        ArrayList<Integer> endlist = new ArrayList<Integer>();
        for (int i = 0; i < instlist.size(); i++) {
            depCheck = -1;

            if (i == 0 || instlist.get(i - 1).getEX().getCOND() == 0) {
                if (instlist.get(i).getInst().contains("DSUBU") || instlist.get(i).getInst().contains("DDIV") || instlist.get(i).getInst().contains("AND")
                        || instlist.get(i).getInst().contains("DSRLV") || instlist.get(i).getInst().contains("SLT") || instlist.get(i).getInst().contains("LW")
                        || instlist.get(i).getInst().contains("LWU") || instlist.get(i).getInst().contains("SW") || instlist.get(i).getInst().contains("DADDIU")
                        || instlist.get(i).getInst().contains("ORI")) {
                    if (i == 0) {
                        addCycle(i + 1, startsat);
                        endlist.add(startsat + 4);
                        startsat++;
                    } else {
                        if (instlist.get(i).getDependency().matches("none")) {

                        } else {
                            for (j = 0; j < i; j++) {
                                if (instlist.get(i).getDependency().contains(instlist.get(j).getAnswer())) {
                                    depCheck = j;
                                }
                            }
                        }
                        if (depCheck == -1) {
                            addCycle(i + 1, startsat);
                            endlist.add(startsat + 4);
                            startsat++;
                        } else {
                            addIf(i + 1, startsat);
                            startsat++;
                            addStall(i + 1, startsat, endlist.get(depCheck) - startsat); //endlist.get(j)-startsat;
                            startsat = startsat + (endlist.get(depCheck) - startsat) + 1;
                            addCont(i + 1, startsat);
                            endlist.add(startsat + 3);
                        }
                    }
                } else if (instlist.get(i).getInst().contains("BEQ")) {
                    if (instlist.get(i).getDependency().matches("none")) {

                    } else {
                        for (j = 0; j < i; j++) {
                            if (instlist.get(i).getDependency().contains(instlist.get(j).getAnswer())) {
                                depCheck = j;
                            }
                        }
                    }
                    if (depCheck == -1 || i == 0) {
                        addCycle(i + 1, startsat);
                        endlist.add(startsat + 4);
                        startsat++;
                    } else {
                        addIf(i + 1, startsat);
                        startsat++;
                        addStall(i + 1, startsat, endlist.get(depCheck) - startsat); //endlist.get(j)-startsat;
                        startsat = startsat + (endlist.get(depCheck) - startsat) + 1;
                        addCont(i + 1, startsat);
                        endlist.add(startsat + 3);
                    }
                } else if (instlist.get(i).getInst().contains("J")) {
                    addCycle(i + 1, startsat);
                    endlist.add(startsat + 4);
                    startsat++;
                }
                addIFtoWB(i);
            } else {
                IR = instlist.get(i).getOpcode();
                if (instlist.get(i - 1).getInst().contains("BEQ")) {
                    label = instlist.get(i - 1).getInst().substring(instlist.get(i - 1).getInst().lastIndexOf(", ") + 2);
                } else {
                    label = instlist.get(i - 1).getInst().substring(instlist.get(i - 1).getInst().indexOf(" ") + 1);
                }
                addIf(i + 1, startsat);
                endlist.add(startsat);

                int index = 0;
                for (j = 0; j < instlist.size(); j++) {
                    if (label.matches(instlist.get(j).getLabel())) {
                        index = j - 1;
                        break;
                    }
                }

                NPC = instlist.get(index).getPc();
                NPC = padZeros(NPC, 16);
                PC = NPC;
                instlist.get(i).setIF(IR, NPC, PC);

                for (int y = i + 1; y < index + 1; y++) {
                    instlist.get(y).setEX("", "", "", 0);
                }

                i = index;
                for (int k = 0; k < j; k++) {
                    endlist.add(startsat);
                }
                startsat++;
            }
        }

        //display pipeline map
        pipelinemodel.setColumnCount(cyclelist.size() + 1);
        pipelinemodel.fireTableStructureChanged();

        JTableHeader th = jTable4.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(0);
        tc.setHeaderValue("Instruction");

        for (int i = 1; i <= cyclelist.size(); i++) {
            tc = tcm.getColumn(i);
            tc.setHeaderValue("Cycle " + i);
        }
        th.repaint();
        pipelinemodel.fireTableDataChanged();

        for (int i = 0; i < instlist.size(); i++) {
            Object[] obj = {instlist.get(i).getInst().toString()};
            pipelinemodel.addRow(obj);
        }
        int num;
        String[] data;
        String op;

        for (int i = 0; i < cyclelist.size(); i++) {
            data = cyclelist.get(i).split(", ");
            for (j = 0; j < data.length; j++) {
                num = Integer.parseInt(data[j].substring(4, data[j].indexOf(" ")));
                op = data[j].substring(data[j].indexOf(" ") + 1);
                pipelinemodel.setValueAt(op, num - 1, i + 1);
            }
        }

        pipelinemodel.fireTableDataChanged();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
        // TODO add your handling code here:
        try {
            String tempR1 = register.getRegister(1).toUpperCase();
            tempR1 = JOptionPane.showInputDialog("Enter R1", tempR1);
            m = immediate.matcher(tempR1);
            if (tempR1 == null || tempR1.matches("") || tempR1.length() > 16 || m.find()) { //error checking
            } else {
                setRegister(1, tempR1, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        // TODO add your handling code here:
        try {
            String tempR2 = register.getRegister(2).toUpperCase();
            tempR2 = JOptionPane.showInputDialog("Enter R2", tempR2);
            m = immediate.matcher(tempR2);
            if (tempR2.matches("") || tempR2.length() > 16 || m.find()) {

            } else {
                setRegister(2, tempR2, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
        // TODO add your handling code here:
        try {
            String tempR3 = register.getRegister(3).toUpperCase();
            tempR3 = JOptionPane.showInputDialog("Enter R3", tempR3);
            m = immediate.matcher(tempR3);
            if (tempR3.matches("") || tempR3.length() > 16 || m.find()) {

            } else {
                setRegister(3, tempR3, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField8MouseClicked

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        // TODO add your handling code here:
        try {
            String tempR4 = register.getRegister(4).toUpperCase();
            tempR4 = JOptionPane.showInputDialog("Enter R4", tempR4);
            m = immediate.matcher(tempR4);
            if (tempR4.matches("") || tempR4.length() > 16 || m.find()) {

            } else {
                setRegister(4, tempR4, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jTextField10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseClicked
        // TODO add your handling code here:
        try {
            String tempR5 = register.getRegister(5).toUpperCase();
            tempR5 = JOptionPane.showInputDialog("Enter R5", tempR5);
            m = immediate.matcher(tempR5);
            if (tempR5.matches("") || tempR5.length() > 16 || m.find()) {

            } else {
                setRegister(5, tempR5, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField10MouseClicked

    private void jTextField11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField11MouseClicked
        // TODO add your handling code here:
        try {
            String tempR6 = register.getRegister(6).toUpperCase();
            tempR6 = JOptionPane.showInputDialog("Enter R6", tempR6);
            m = immediate.matcher(tempR6);
            if (tempR6.matches("") || tempR6.length() > 16 || m.find()) {

            } else {
                setRegister(6, tempR6, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField11MouseClicked

    private void jTextField12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField12MouseClicked
        // TODO add your handling code here:
        try {
            String tempR7 = register.getRegister(7).toUpperCase();
            tempR7 = JOptionPane.showInputDialog("Enter R7", tempR7);
            m = immediate.matcher(tempR7);
            if (tempR7.matches("") || tempR7.length() > 16 || m.find()) {

            } else {
                setRegister(7, tempR7, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField12MouseClicked

    private void jTextField13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField13MouseClicked
        // TODO add your handling code here:
        try {
            String tempR8 = register.getRegister(8).toUpperCase();
            tempR8 = JOptionPane.showInputDialog("Enter R8", tempR8);
            m = immediate.matcher(tempR8);
            if (tempR8.matches("") || tempR8.length() > 16 || m.find()) {

            } else {
                setRegister(8, tempR8, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField13MouseClicked

    private void jTextField14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField14MouseClicked
        // TODO add your handling code here:
        try {
            String tempR9 = register.getRegister(9).toUpperCase();
            tempR9 = JOptionPane.showInputDialog("Enter R9", tempR9);
            m = immediate.matcher(tempR9);
            if (tempR9.matches("") || tempR9.length() > 16 || m.find()) {

            } else {
                setRegister(9, tempR9, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField14MouseClicked

    private void jTextField15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField15MouseClicked
        // TODO add your handling code here:
        try {
            String tempR10 = register.getRegister(10).toUpperCase();
            tempR10 = JOptionPane.showInputDialog("Enter R10", tempR10);
            m = immediate.matcher(tempR10);
            if (tempR10.matches("") || tempR10.length() > 16 || m.find()) {

            } else {
                setRegister(10, tempR10, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField15MouseClicked

    private void jTextField16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField16MouseClicked
        // TODO add your handling code here:
        try {
            String tempR11 = register.getRegister(11).toUpperCase();
            tempR11 = JOptionPane.showInputDialog("Enter R11", tempR11);
            m = immediate.matcher(tempR11);
            if (tempR11.matches("") || tempR11.length() > 16 || m.find()) {

            } else {
                setRegister(11, tempR11, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField16MouseClicked

    private void jTextField17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField17MouseClicked
        // TODO add your handling code here:
        try {
            String tempR12 = register.getRegister(12).toUpperCase();
            tempR12 = JOptionPane.showInputDialog("Enter R12", tempR12);
            m = immediate.matcher(tempR12);
            if (tempR12.matches("") || tempR12.length() > 16 || m.find()) {

            } else {
                setRegister(12, tempR12, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField17MouseClicked

    private void jTextField18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField18MouseClicked
        // TODO add your handling code here:
        try {
            String tempR13 = register.getRegister(13).toUpperCase();
            tempR13 = JOptionPane.showInputDialog("Enter R13", tempR13);
            m = immediate.matcher(tempR13);
            if (tempR13.matches("") || tempR13.length() > 16 || m.find()) {

            } else {
                setRegister(13, tempR13, register);
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jTextField18MouseClicked

    private void jTextField19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField19MouseClicked
        // TODO add your handling code here:
        try {
            String tempR14 = register.getRegister(14).toUpperCase();
            tempR14 = JOptionPane.showInputDialog("Enter R14", tempR14);
            m = immediate.matcher(tempR14);
            if (tempR14.matches("") || tempR14.length() > 16 || m.find()) {

            } else {
                setRegister(14, tempR14, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField19MouseClicked

    private void jTextField20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField20MouseClicked
        // TODO add your handling code here:
        try {
            String tempR15 = register.getRegister(15).toUpperCase();
            tempR15 = JOptionPane.showInputDialog("Enter R15", tempR15);
            m = immediate.matcher(tempR15);
            if (tempR15.matches("") || tempR15.length() > 16 || m.find()) {

            } else {
                setRegister(15, tempR15, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField20MouseClicked

    private void jTextField21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField21MouseClicked
        // TODO add your handling code here:
        try {
            String tempR16 = register.getRegister(16).toUpperCase();
            tempR16 = JOptionPane.showInputDialog("Enter R16", tempR16);
            m = immediate.matcher(tempR16);
            if (tempR16.matches("") || tempR16.length() > 16 || m.find()) {

            } else {
                setRegister(16, tempR16, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField21MouseClicked

    private void jTextField22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField22MouseClicked
        // TODO add your handling code here:
        try {
            String tempR17 = register.getRegister(17).toUpperCase();
            tempR17 = JOptionPane.showInputDialog("Enter R17", tempR17);
            m = immediate.matcher(tempR17);
            if (tempR17.matches("") || tempR17.length() > 16 || m.find()) {

            } else {
                setRegister(17, tempR17, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField22MouseClicked

    private void jTextField23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField23MouseClicked
        // TODO add your handling code here:
        try {
            String tempR18 = register.getRegister(18).toUpperCase();
            tempR18 = JOptionPane.showInputDialog("Enter R18", tempR18);
            m = immediate.matcher(tempR18);
            if (tempR18.matches("") || tempR18.length() > 16 || m.find()) {

            } else {
                setRegister(18, tempR18, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField23MouseClicked

    private void jTextField24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField24MouseClicked
        // TODO add your handling code here:
        try {
            String tempR19 = register.getRegister(19).toUpperCase();
            tempR19 = JOptionPane.showInputDialog("Enter R19", tempR19);
            m = immediate.matcher(tempR19);
            if (tempR19.matches("") || tempR19.length() > 16 || m.find()) {

            } else {
                setRegister(19, tempR19, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField24MouseClicked

    private void jTextField25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField25MouseClicked
        // TODO add your handling code here:
        try {
            String tempR20 = register.getRegister(20).toUpperCase();
            tempR20 = JOptionPane.showInputDialog("Enter R20", tempR20);
            m = immediate.matcher(tempR20);
            if (tempR20.matches("") || tempR20.length() > 16 || m.find()) {

            } else {
                setRegister(20, tempR20, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField25MouseClicked

    private void jTextField26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField26MouseClicked
        // TODO add your handling code here:
        try {
            String tempR21 = register.getRegister(21).toUpperCase();
            tempR21 = JOptionPane.showInputDialog("Enter R21", tempR21);
            m = immediate.matcher(tempR21);
            if (tempR21.matches("") || tempR21.length() > 16 || m.find()) {

            } else {
                setRegister(21, tempR21, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField26MouseClicked

    private void jTextField27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField27MouseClicked
        // TODO add your handling code here:
        try {
            String tempR22 = register.getRegister(22).toUpperCase();
            tempR22 = JOptionPane.showInputDialog("Enter R22", tempR22);
            m = immediate.matcher(tempR22);
            if (tempR22.matches("") || tempR22.length() > 16 || m.find()) {

            } else {
                setRegister(22, tempR22, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField27MouseClicked

    private void jTextField28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField28MouseClicked
        // TODO add your handling code here:
        try {
            String tempR23 = register.getRegister(23).toUpperCase();
            tempR23 = JOptionPane.showInputDialog("Enter R23", tempR23);
            m = immediate.matcher(tempR23);
            if (tempR23.matches("") || tempR23.length() > 16 || m.find()) {

            } else {
                setRegister(23, tempR23, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField28MouseClicked

    private void jTextField29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField29MouseClicked
        // TODO add your handling code here:
        try {
            String tempR24 = register.getRegister(24).toUpperCase();
            tempR24 = JOptionPane.showInputDialog("Enter R24", tempR24);
            m = immediate.matcher(tempR24);
            if (tempR24.matches("") || tempR24.length() > 16 || m.find()) {

            } else {
                setRegister(24, tempR24, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField29MouseClicked

    private void jTextField30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField30MouseClicked
        // TODO add your handling code here:
        try {
            String tempR25 = register.getRegister(25).toUpperCase();
            tempR25 = JOptionPane.showInputDialog("Enter R25", tempR25);
            m = immediate.matcher(tempR25);
            if (tempR25.matches("") || tempR25.length() > 16 || m.find()) {

            } else {
                setRegister(25, tempR25, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField30MouseClicked

    private void jTextField31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField31MouseClicked
        // TODO add your handling code here:
        try {
            String tempR26 = register.getRegister(26).toUpperCase();
            tempR26 = JOptionPane.showInputDialog("Enter R26", tempR26);
            m = immediate.matcher(tempR26);
            if (tempR26.matches("") || tempR26.length() > 16 || m.find()) {

            } else {
                setRegister(26, tempR26, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField31MouseClicked

    private void jTextField32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField32MouseClicked
        // TODO add your handling code here:
        String tempR27 = register.getRegister(27).toUpperCase();
        tempR27 = JOptionPane.showInputDialog("Enter R27", tempR27);
        m = immediate.matcher(tempR27);
        if (tempR27.matches("") || tempR27.length() > 16 || m.find()) {

        } else {
            setRegister(27, tempR27, register);
        }
    }//GEN-LAST:event_jTextField32MouseClicked

    private void jTextField33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField33MouseClicked
        // TODO add your handling code here:
        try {
            String tempR28 = register.getRegister(28).toUpperCase();
            tempR28 = JOptionPane.showInputDialog("Enter R28", tempR28);
            m = immediate.matcher(tempR28);
            if (tempR28.matches("") || tempR28.length() > 16 || m.find()) {

            } else {
                setRegister(28, tempR28, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField33MouseClicked

    private void jTextField34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField34MouseClicked
        // TODO add your handling code here:
        try {
            String tempR29 = register.getRegister(29).toUpperCase();
            tempR29 = JOptionPane.showInputDialog("Enter R29", tempR29);
            m = immediate.matcher(tempR29);
            if (tempR29.matches("") || tempR29.length() > 16 || m.find()) {

            } else {
                setRegister(29, tempR29, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField34MouseClicked

    private void jTextField35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField35MouseClicked
        // TODO add your handling code here:
        try {
            String tempR30 = register.getRegister(30).toUpperCase();
            tempR30 = JOptionPane.showInputDialog("Enter R30", tempR30);
            m = immediate.matcher(tempR30);
            if (tempR30.matches("") || tempR30.length() > 16 || m.find()) {

            } else {
                setRegister(30, tempR30, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField35MouseClicked

    private void jTextField36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField36MouseClicked
        // TODO add your handling code here:
        try {
            String tempR31 = register.getRegister(31).toUpperCase();
            tempR31 = JOptionPane.showInputDialog("Enter R31", tempR31);
            m = immediate.matcher(tempR31);
            if (tempR31.matches("") || tempR31.length() > 16 || m.find()) {

            } else {
                setRegister(31, tempR31, register);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jTextField36MouseClicked

    private void jTextField37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField37MouseClicked
        // TODO add your handling code here:
        String tempHI = register.getHi().toUpperCase();
        tempHI = JOptionPane.showInputDialog("Enter HI", tempHI);
        m = immediate.matcher(tempHI);
        if (tempHI.matches("") || tempHI.length() > 16 || m.find()) {

        } else {
            register.setHi(tempHI.toUpperCase());
            jTextField37.setText(tempHI);
        }
    }//GEN-LAST:event_jTextField37MouseClicked

    private void jTextField38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField38MouseClicked
        // TODO add your handling code here:
        String tempLO = register.getLo().toUpperCase();
        tempLO = JOptionPane.showInputDialog("Enter LO", tempLO);
        m = immediate.matcher(tempLO);
        if (tempLO.matches("") || tempLO.length() > 16 || m.find()) {

        } else {
            register.setLo(tempLO.toUpperCase());
            jTextField38.setText(tempLO);
        }
    }//GEN-LAST:event_jTextField38MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        String mem = "", value = "", newval = "";
        int temprow = jTable1.getSelectedRow();
        String actualmem = jTable1.getModel().getValueAt(jTable1.convertRowIndexToModel(temprow), 0).toString();
        int row = Integer.parseInt(actualmem, 16) - 8192;

        mem = Long.toHexString(row + 8192);

        //get value from arraylist data segment
        value = datasegment.get(row);
        value = padZeros(value, 2);

        newval = JOptionPane.showInputDialog(mem, value);

        m = immediate.matcher(newval);
        if (m.find() || newval.length() > 2 || newval.matches("")) {

        } else {

            newval = padZeros(newval, 2).toUpperCase();

            //store value to arraylist data segment
            datasegment.set(row, newval);

            datasegmentmodel.getDataVector().removeAllElements();
            datasegmentmodel.fireTableDataChanged();

            //display
            for (int i = 0; i < 8192; i++) {
                newval = "";
                mem = Long.toHexString(i + 8192);
                value = datasegment.get(i);
                newval = padZeros(value, 2).toUpperCase();
                Object[] obj = {mem, newval};
                datasegmentmodel.addRow(obj);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField40KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField40KeyReleased
        // TODO add your handling code here:
        String mem = jTextField40.getText();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(sorter);

        if (mem.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + mem));
        }
        jTextField40.setText(mem);
    }//GEN-LAST:event_jTextField40KeyReleased

    private void jTextField40FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField40FocusLost
        // TODO add your handling code here:
        if (jTextField40.getText().matches("")) {
            jTextField40.setText("Search");
        }
    }//GEN-LAST:event_jTextField40FocusLost

    private void jTextField41KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField41KeyReleased
        // TODO add your handling code here:
        String mem = jTextField41.getText();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(jTable2.getModel());
        jTable2.setRowSorter(sorter);

        if (mem.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + mem));
        }
        jTextField41.setText(mem);

    }//GEN-LAST:event_jTextField41KeyReleased

    private void jTextField41FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField41FocusGained
        // TODO add your handling code here:
        if (jTextField41.getText().contains("Search")) {
            jTextField41.setText("");
        }
    }//GEN-LAST:event_jTextField41FocusGained

    private void jTextField41FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField41FocusLost
        // TODO add your handling code here:
        if (jTextField41.getText().matches("")) {
            jTextField41.setText("Search");
        }
    }//GEN-LAST:event_jTextField41FocusLost

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jPanel16.removeAll();
        jPanel16.repaint();
        jPanel16.revalidate();

        jPanel16.add(jPanel18);
        jPanel16.repaint();
        jPanel16.revalidate();

        registerforSingle = new Register(initialregister);
        UpdateRegister(registerforSingle);

        datasegmentSingle = new ArrayList<String>(datasegmentinitial);
        UpdateDS(datasegmentSingle);

        jLabel8.setText("Cycle 1");
        SingleExecution();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jPanel16.removeAll();
        jPanel16.repaint();
        jPanel16.revalidate();

        jPanel16.add(jPanel17);
        jPanel16.repaint();
        jPanel16.revalidate();

        UpdateRegister(register);
        UpdateDS(datasegment);

        fullmodel.getDataVector().removeAllElements();
        fullmodel.fireTableDataChanged();

        int inst;
        String op;
        String[] data;
        String cycle;
        for (int i = 0; i < cyclelist.size(); i++) {
            cycle = "Cycle: " + (i + 1);
            fullmodel.addRow(new Object[]{cycle});
            data = cyclelist.get(i).split(", ");
            for (int j = 0; j < data.length; j++) {
                inst = Integer.parseInt(data[j].substring(4, cyclelist.get(i).indexOf(" "))) - 1;
                op = data[j].substring(cyclelist.get(i).indexOf(" ") + 1);

                if (op.matches("IF")) {
                    fullmodel.addRow(new Object[]{"IF"});
                    fullmodel.addRow(new Object[]{"IF/ID.IR", instlist.get(inst).getIF().getIR()});
                    fullmodel.addRow(new Object[]{"IF/ID.NPC", instlist.get(inst).getIF().getNPC()});
                    fullmodel.addRow(new Object[]{"IF/ID.PC", instlist.get(inst).getIF().getPC()});
                } else if (op.matches("ID")) {
                    fullmodel.addRow(new Object[]{"ID"});
                    fullmodel.addRow(new Object[]{"ID/EX.A", instlist.get(inst).getID().getA()});
                    fullmodel.addRow(new Object[]{"ID/EX.B", instlist.get(inst).getID().getB()});
                    fullmodel.addRow(new Object[]{"ID/EX.IMM", instlist.get(inst).getID().getIMM()});
                    fullmodel.addRow(new Object[]{"ID/EX.IR", instlist.get(inst).getID().getIR()});
                } else if (op.matches("EX")) {
                    fullmodel.addRow(new Object[]{"EX"});
                    fullmodel.addRow(new Object[]{"EX/MEM.ALUOUTPUT", instlist.get(inst).getEX().getALUOUTPUT()});
                    fullmodel.addRow(new Object[]{"EX/MEM.B", instlist.get(inst).getEX().getB()});
                    fullmodel.addRow(new Object[]{"EX/MEM.IR", instlist.get(inst).getEX().getIR()});
                    fullmodel.addRow(new Object[]{"EX/MEM.COND", instlist.get(inst).getEX().getCOND()});
                } else if (op.matches("MEM")) {
                    fullmodel.addRow(new Object[]{"MEM"});
                    fullmodel.addRow(new Object[]{"MEM/WB.ALUOUTPUT", instlist.get(inst).getMEM().getALUOUTPUT()});
                    fullmodel.addRow(new Object[]{"MEM/WB.IR", instlist.get(inst).getMEM().getIR()});
                    fullmodel.addRow(new Object[]{"MEM/WB.LMD", instlist.get(inst).getMEM().getLMD()});
                    fullmodel.addRow(new Object[]{"MEM/WB.MEMALU", instlist.get(inst).getMEM().getMEMALU()});
                } else if (op.matches("WB")) {
                    fullmodel.addRow(new Object[]{"WB"});
                    fullmodel.addRow(new Object[]{"R" + instlist.get(inst).getWB().getREG(), instlist.get(inst).getWB().getValue()});
                }
            }
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void UpdateRegister(Register register) {
        for (int i = 0; i < register.getRegister().size(); i++) {
            setRegister(i, register.getRegister(i), register);
        }
        jTextField37.setText(register.getHi());
        jTextField38.setText(register.getLo());
    }

    private void SingleExecution() {
        int cycle = Integer.parseInt(jLabel8.getText().substring(6)) - 1, inst;
        String[] data;
        String op, tempstr, tempB;
        int from, to, tempint;
        Long templo, temphi;

        singlemodel.getDataVector().removeAllElements();
        singlemodel.fireTableDataChanged();

        //UpdateRegister(registerforSingle);
        data = cyclelist.get(cycle).split(", ");
        for (int j = 0; j < data.length; j++) {
            inst = Integer.parseInt(data[j].substring(4, cyclelist.get(cycle).indexOf(" "))) - 1;
            op = data[j].substring(cyclelist.get(cycle).indexOf(" ") + 1);

            if (op.matches("IF")) {
                singlemodel.addRow(new Object[]{"IF"});
                singlemodel.addRow(new Object[]{"IF/ID.IR", instlist.get(inst).getIF().getIR()});
                singlemodel.addRow(new Object[]{"IF/ID.NPC", instlist.get(inst).getIF().getNPC()});
                singlemodel.addRow(new Object[]{"IF/ID.PC", instlist.get(inst).getIF().getPC()});
            } else if (op.matches("ID")) {
                singlemodel.addRow(new Object[]{"ID"});
                singlemodel.addRow(new Object[]{"ID/EX.A", instlist.get(inst).getID().getA()});
                singlemodel.addRow(new Object[]{"ID/EX.B", instlist.get(inst).getID().getB()});
                singlemodel.addRow(new Object[]{"ID/EX.IMM", instlist.get(inst).getID().getIMM()});
                singlemodel.addRow(new Object[]{"ID/EX.IR", instlist.get(inst).getID().getIR()});
            } else if (op.matches("EX")) {
                singlemodel.addRow(new Object[]{"EX"});
                singlemodel.addRow(new Object[]{"EX/MEM.ALUOUTPUT", instlist.get(inst).getEX().getALUOUTPUT()});
                singlemodel.addRow(new Object[]{"EX/MEM.B", instlist.get(inst).getEX().getB()});
                singlemodel.addRow(new Object[]{"EX/MEM.IR", instlist.get(inst).getEX().getIR()});
                singlemodel.addRow(new Object[]{"EX/MEM.COND", instlist.get(inst).getEX().getCOND()});
            } else if (op.matches("MEM")) {
                singlemodel.addRow(new Object[]{"MEM"});
                singlemodel.addRow(new Object[]{"MEM/WB.ALUOUTPUT", instlist.get(inst).getMEM().getALUOUTPUT()});
                singlemodel.addRow(new Object[]{"MEM/WB.IR", instlist.get(inst).getMEM().getIR()});
                singlemodel.addRow(new Object[]{"MEM/WB.LMD", instlist.get(inst).getMEM().getLMD()});
                singlemodel.addRow(new Object[]{"MEM/WB.MEMALU", instlist.get(inst).getMEM().getMEMALU()});

            } else if (op.matches("WB")) {
                singlemodel.addRow(new Object[]{"WB"});
                singlemodel.addRow(new Object[]{"R" + instlist.get(inst).getWB().getREG(), instlist.get(inst).getWB().getValue()});
                if (!instlist.get(inst).getWB().getREG().matches("N/A")) {
                    if (instlist.get(inst).getInst().contains("DDIV")) {
                        registerforSingle.setLo(instlist.get(inst).getWB().getLO());
                        registerforSingle.setHi(instlist.get(inst).getWB().getHI());
                        UpdateRegister(registerforSingle);
                    } else if (instlist.get(inst).getInst().contains("SW")) {
                        tempstr = instlist.get(inst).getEX().getALUOUTPUT().substring(12, 16);
                        tempint = Integer.parseInt(tempstr, 16) - 8192;
                        tempB = instlist.get(inst).getID().getB().substring(8, 16);
                        from = 8;
                        to = 10;

                        for (int x = tempint; x < tempint + 4; x++) {
                            tempB = instlist.get(inst).getID().getB().substring(from, to);
                            datasegment.set(x, tempB);
                            from = from + 2;
                            to = to + 2;
                        }
                        UpdateDS(datasegmentSingle);
                    } else {
                        registerforSingle.setRegister(Integer.parseInt(instlist.get(inst).getWB().getREG()), instlist.get(inst).getWB().getValue());
                        UpdateRegister(registerforSingle);
                    }
                }
            }
        }
    }


    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        int cycle = Integer.parseInt(jLabel8.getText().substring(6));
        if (cyclelist.size() < cycle + 1) {

        } else {
            jLabel8.setText("Cycle " + (cycle + 1));
            SingleExecution();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField40FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField40FocusGained
        // TODO add your handling code here:
        if (jTextField40.getText().matches("Search")) {
            jTextField40.setText("");
        }
    }//GEN-LAST:event_jTextField40FocusGained

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
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
