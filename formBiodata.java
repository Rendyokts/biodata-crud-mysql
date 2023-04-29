import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class formBiodata extends javax.swing.JFrame {


    public Statement st;
    public ResultSet rs;
    Connection cn = koneksi.ConnectDatabase.BukaKoneksi();
    
     
    public formBiodata() {
        initComponents();
        TampilData();
    }
    
    private void Bersih(){
        txtNIK.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtTelepon.setText("");
        
        btnSimpan.setText("Simpan");
        txtNIK.setEditable(true);
    }
    
    private void CariData(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM biodata WHERE " +
                    cmbCari.getSelectedItem().toString() +
                    " LIKE '%" + txtCari.getText() + "%'");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No.");
            model.addColumn("NIK");
            model.addColumn("Nama");
            model.addColumn("Alamat");
            model.addColumn("Telepon");
            
            int no = 1;
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {
                    no++,
                  rs.getString("NIK"),
                  rs.getString("Nama"),
                  rs.getString("Alamat"),
                  rs.getString("Telepon")
                };
                model.addRow(data);
                tblData.setModel(model);
            }
            
        } catch (Exception e ){
            
        }
    }
    
    private void TampilData(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM biodata");
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No.");
            model.addColumn("NIK");
            model.addColumn("Nama");
            model.addColumn("Alamat");
            model.addColumn("Telepon");
            
            int no = 1;
            
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
                Object[] data = {
                    no++,
                  rs.getString("NIK"),
                  rs.getString("Nama"),
                  rs.getString("Alamat"),
                  rs.getString("Telepon")
                };
                model.addRow(data);
                tblData.setModel(model);
            }
            
        } catch (Exception e ){
            
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        labelNIK = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        labelAlamat = new javax.swing.JLabel();
        txtNIK = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        labelTelepon = new javax.swing.JLabel();
        txtTelepon = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        labelBiodataWarga = new javax.swing.JLabel();
        labelBiodata = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        labelCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        cmbCari = new javax.swing.JComboBox<>();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNIK.setText("NIK");

        labelNama.setText("Nama");

        labelAlamat.setText("Alamat");

        labelTelepon.setText("Telepon");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        labelBiodata.setText("Biodata Pengguna Sekitar");

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIK", "Nama", "Alamat", "Telepon"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        labelCari.setText("Cari Data");

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NIK", "Nama" }));
        cmbCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNIK)
                            .addComponent(labelNama)
                            .addComponent(labelAlamat)
                            .addComponent(labelTelepon))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBiodataWarga)
                            .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNIK, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCari)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(9, 9, 9))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelBiodata)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(labelBiodataWarga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelBiodata)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNIK)
                    .addComponent(txtNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelepon)
                    .addComponent(txtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCari)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void cmbCariActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        try{
            st = cn.createStatement();
            if(txtNIK.getText().equals("") || 
                    txtNama.getText().equals("") || 
                    txtTelepon.getText().equals("") || 
                    txtAlamat.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Data tidak boleh kosong","Valdasi Data", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            if(btnSimpan.getText() == "Simpan"){
                String cek = "SELECT * FROM biodata WHERE NIK = '" + txtNIK.getText() + "'";
                rs = st.executeQuery(cek);
                if (rs.next()){
                    JOptionPane.showMessageDialog(null, "NIK sudah terdaftar sebelumnya");
                } else {
                    String sql = "INSERT INTO biodata VALUES ('" + txtNIK.getText() + 
                            "','" + txtNama.getText()+
                            "','" + txtAlamat.getText()+
                            "','" + txtTelepon.getText()+ "')";
                    st.execute(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                    Bersih();
                }
            } else {
                // aksi ubah data
                String update = "UPDATE biodata SET Nama = '" + txtNama.getText()+
                        "', Alamat = '" + txtAlamat.getText() +
                        "', Telepon = '" + txtTelepon.getText() +
                        "' WHERE NIK = '" + txtNIK.getText() + "'";
                st.executeUpdate(update);
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                Bersih();
                TampilData();
                
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }                                         

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        txtNIK.setText(tblData.getValueAt(tblData.getSelectedRow(), 1).toString());
        txtNama.setText(tblData.getValueAt(tblData.getSelectedRow(), 2).toString());
        txtAlamat.setText(tblData.getValueAt(tblData.getSelectedRow(), 3).toString());
        txtTelepon.setText(tblData.getValueAt(tblData.getSelectedRow(), 4).toString());
        
        txtNIK.setEditable(false);
        btnSimpan.setText("Ubah");
    }                                    

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if(txtNIK.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silakan pilih data yang akan dihapus !");
        } else {
            int jawab = JOptionPane.showConfirmDialog(null, "Data ini akan dihapus, lanjutkan ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab == 0){
                try{
                    st = cn.createStatement();
                    String sql = "DELETE FROM biodata WHERE NIK = '" + txtNIK.getText() + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                    TampilData();
                    Bersih();
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null,e);
                    
                }
            }
        }
    }                                        

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        Bersih();
        
    }                                        

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {                                   
        // TODO add your handling code here:
        CariData();
    }                                  

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
            java.util.logging.Logger.getLogger(formBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formBiodata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formBiodata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbCari;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAlamat;
    private javax.swing.JLabel labelBiodata;
    private javax.swing.JLabel labelBiodataWarga;
    private javax.swing.JLabel labelCari;
    private javax.swing.JLabel labelNIK;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelTelepon;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTelepon;
    // End of variables declaration                   
}
