package com.ptc.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nganh", catalog = "quanho_sql_exercise")
public class Nganh {
    @Id
    @Column(name = "manganh")
    private String maNganh;
    @Column(name = "tennganh")
    private String tenNganh;

    public Nganh() {
        super();
    }

    public Nganh(String maNganh, String tenNganh) {
        super();
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }
}
