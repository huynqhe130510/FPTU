/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author huyNguyen
 */
public class Chi_Tiet_Don_Hang {

    int ma;
    Date ngay_ban;
    String ten;
    String sdt;
    String dia_chi;
    ArrayList<Don_Hang> don_Hangs = new ArrayList<>();

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public ArrayList<Don_Hang> getDon_Hangs() {
        return don_Hangs;
    }

    public void setDon_Hangs(ArrayList<Don_Hang> don_Hangs) {
        this.don_Hangs = don_Hangs;
    }

    public float getTotal() {
        float sum = 0;
        for (Don_Hang don_Hang : don_Hangs) {
            sum += don_Hang.getTotal();
        }
        return sum;
    }
    
    public int getQuantity(){
        int sum = 0;
        for (Don_Hang don_Hang : don_Hangs) {
            sum+= don_Hang.getSo_luong();
        }
        return sum;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public Date getNgay_ban() {
        return ngay_ban;
    }

    public void setNgay_ban(Date ngay_ban) {
        this.ngay_ban = ngay_ban;
    }
    
}
