/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author huyNguyen
 */
public class Don_Hang {
    Chi_Tiet_Don_Hang chi_Tiet_Don_Hang;
    Ao ao;
    int so_luong;
    float don_gia;
    float tong;

    public float getTong() {
        return tong;
    }

    public void setTong(float tong) {
        this.tong = tong;
    }
    
    public float getTotal()
    {
        return so_luong*don_gia;
    }

    public Chi_Tiet_Don_Hang getChi_Tiet_Don_Hang() {
        return chi_Tiet_Don_Hang;
    }

    public void setChi_Tiet_Don_Hang(Chi_Tiet_Don_Hang chi_Tiet_Don_Hang) {
        this.chi_Tiet_Don_Hang = chi_Tiet_Don_Hang;
    }

    public Ao getAo() {
        return ao;
    }

    public void setAo(Ao ao) {
        this.ao = ao;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public float getDon_gia() {
        return don_gia;
    }

    public void setDon_gia(float don_gia) {
        this.don_gia = don_gia;
    }
    
    
}
