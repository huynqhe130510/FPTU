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
public class Ao {
    String ma_ao;
    San_Pham san_Pham;
    String ten_ao;
    Co_Ao co_Ao;
    int gia;
    String chat_lieu;

    public String getChat_lieu() {
        return chat_lieu;
    }

    public void setChat_lieu(String chat_lieu) {
        this.chat_lieu = chat_lieu;
    }
    Noi_Sx noi_Sx;
    int so_luong;
    Chat_Lieu chat_Lieu;

    public String getMa_ao() {
        return ma_ao;
    }

    public void setMa_ao(String ma_ao) {
        this.ma_ao = ma_ao;
    }

    public San_Pham getSan_Pham() {
        return san_Pham;
    }

    public void setSan_Pham(San_Pham san_Pham) {
        this.san_Pham = san_Pham;
    }

    public String getTen_ao() {
        return ten_ao;
    }

    public void setTen_ao(String ten_ao) {
        this.ten_ao = ten_ao;
    }

    public Co_Ao getCo_Ao() {
        return co_Ao;
    }

    public void setCo_Ao(Co_Ao co_Ao) {
        this.co_Ao = co_Ao;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public Noi_Sx getNoi_Sx() {
        return noi_Sx;
    }

    public void setNoi_Sx(Noi_Sx noi_Sx) {
        this.noi_Sx = noi_Sx;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public Chat_Lieu getChat_Lieu() {
        return chat_Lieu;
    }

    public void setChat_Lieu(Chat_Lieu chat_Lieu) {
        this.chat_Lieu = chat_Lieu;
    }
    
    
}
