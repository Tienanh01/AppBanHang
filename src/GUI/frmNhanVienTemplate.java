/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.NhanVien;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zenter
 */
public class frmNhanVienTemplate extends javax.swing.JPanel {
    /**
     * Creates new form frmNhanVienTemplate
     */
    private DefaultTableModel defaultTableModel;
    NhanVien nv = new NhanVien();
//    frmLogin FrmLogin;
    ArrayList<NhanVien> listNV = new ArrayList<>();
    public frmNhanVienTemplate() {
        initComponents();
//        loadFile();
//        getData(listNV);
    }
    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listNV = new ArrayList<>(); //lưu ý
            fr = new FileReader("nhanvien.txt");
            br = new BufferedReader(fr);
            String s = null;
            
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    NhanVien nv = new NhanVien();
                    nv.setMaNhanVien(arr[0]);
                    nv.setHoTen(arr[1]);
                    nv.setSoDienThoai(arr[2]);
                    nv.setEmail(arr[3]);
                    nv.setMatKhau(arr[4]);
                    nv.setNhom(Integer.parseInt(arr[5]));
                    nv.setGioiTinh(arr[6]);
                    nv.setTrangThai(Integer.parseInt(arr[7]));
                    listNV.add(nv);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }

    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listNV.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listNV.get(i).getMaNhanVien() + "\t";
                row = row + listNV.get(i).getHoTen() + "\t";
                row = row + listNV.get(i).getSoDienThoai() + "\t";
                row = row + listNV.get(i).getEmail() + "\t";
                row = row + listNV.get(i).getMatKhau() + "\t";
                row = row + listNV.get(i).getNhom() + "\t";
                row = row + listNV.get(i).getGioiTinh() + "\t";
                row = row + listNV.get(i).getTrangThai() + "\n";
                data += row;
            }
            fw = new FileWriter("nhanvien.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmNhanVienTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
    private void getData(ArrayList<NhanVien> listNV) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã NV");
        defaultTableModel.addColumn("Họ tên NV");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("SĐT");
        defaultTableModel.addColumn("Nhóm");
        defaultTableModel.addColumn("Trạng Thái");

        for (NhanVien obj : listNV) {
            Vector vector = new Vector();
            vector.add(obj.getMaNhanVien());
            vector.add(obj.getHoTen());
            vector.add(obj.getGioiTinh());
            vector.add(obj.getEmail());
            vector.add(obj.getSoDienThoai());
            vector.add(obj.getNhom() == 1 ? "Quản lý" : "Nhân viên");
            vector.add(obj.getTrangThai() == 1 ? "Hoạt động" : "Đã khóa");
            defaultTableModel.addRow(vector);
        }
        tbl_nhanvien.setModel(defaultTableModel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nhanvien = new javax.swing.JTable();
        hello = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        tbl_nhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_nhanvien);

        hello.setText("jLabel1");

        jLabel1.setText("Đây là form nhân viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(hello))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(243, 243, 243)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(hello)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hello;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_nhanvien;
    // End of variables declaration//GEN-END:variables
}
