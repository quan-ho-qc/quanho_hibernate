package com.ptc.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sinhvien", catalog = "quanho_sql_exercise")
public class SinhVien {
    @Id
    @Column(name = "masv")
    private String maSinhVien;
    @Column(name = "tensv")
    private String tenSinhVien;
    @Column(name = "manganh")
    private String maNganh;

    public SinhVien() {
        super();
    }

    public SinhVien(String maSinhVien, String tenSinhVien, String maNganh) {
        super();
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.maNganh = maNganh;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getMaNganh() {
        return maNganh;
    }
    
    @OneToMany
    @JoinColumn(name = "manganh", nullable = false)
    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }
}
