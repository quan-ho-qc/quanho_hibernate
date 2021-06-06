package com.ptc.hibernate.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptc.hibernate.entities.SinhVien;
import com.ptc.hibernate.utils.HibernateUtil;

public class DatabaseTest {
    public SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    @Test
    public void test_fetch_a_student_from_sinh_vien_table_success() {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            session.beginTransaction();
            String maSV = "SV1";
            SinhVien sinhvien = session.get(SinhVien.class, maSV);
            Assert.assertEquals(sinhvien.getMaSinhVien(), "SV1");
            Assert.assertEquals(sinhvien.getTenSinhVien(), "Ho Quan");
            Assert.assertEquals(sinhvien.getMaNganh(), "NG2");
            session.getTransaction().commit();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void test_add_a_student_to_sinh_vien_table_success() {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            session.beginTransaction();
            SinhVien sinhvien = new SinhVien("SV10", "Ho Van Quan 4", "NG1");
            session.save(sinhvien);
            String maSV = "SV10";
            SinhVien sinhvien1 = session.get(SinhVien.class, maSV);
            Assert.assertEquals(sinhvien1.getMaSinhVien(), "SV10");
            Assert.assertEquals(sinhvien1.getTenSinhVien(), "Ho Van Quan 4");
            Assert.assertEquals(sinhvien1.getMaNganh(), "NG1");
            session.getTransaction().commit();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void test_update_a_student_from_sinh_vien_table_success() {
        SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            session.beginTransaction();
            SinhVien sinhvien = new SinhVien();
            sinhvien.setMaSinhVien("SV1");
            sinhvien.setTenSinhVien("Ho Quan");
            sinhvien.setMaNganh("NG2");
            session.update(sinhvien);
            String maSV = "SV1";
            SinhVien sinhvien1 = session.get(SinhVien.class, maSV);
            Assert.assertEquals(sinhvien1.getMaSinhVien(), "SV1");
            Assert.assertEquals(sinhvien1.getTenSinhVien(), "Ho Quan");
            Assert.assertEquals(sinhvien1.getMaNganh(), "NG2");
            session.getTransaction().commit();
        } catch (Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
