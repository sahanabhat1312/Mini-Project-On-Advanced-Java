package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.model.FeePayment;

public class FeePaymentDAO {

    // INSERT
    public boolean addPayment(FeePayment fp) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO FeePayments (StudentID, StudentName, PaymentDate, Amount, Status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, fp.getStudentID());
            ps.setString(2, fp.getStudentName());
            ps.setString(3, fp.getPaymentDate());
            ps.setDouble(4, fp.getAmount());
            ps.setString(5, fp.getStatus());

            int i = ps.executeUpdate();

            if (i > 0) status = true;

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // DISPLAY ALL
    public List<FeePayment> getAllPayments() {
        List<FeePayment> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM FeePayments";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FeePayment fp = new FeePayment();

                fp.setPaymentID(rs.getInt("PaymentID"));
                fp.setStudentID(rs.getInt("StudentID"));
                fp.setStudentName(rs.getString("StudentName"));
                fp.setPaymentDate(rs.getString("PaymentDate"));
                fp.setAmount(rs.getDouble("Amount"));
                fp.setStatus(rs.getString("Status"));

                list.add(fp);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // DELETE
    public boolean deletePayment(int id) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM FeePayments WHERE PaymentID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
            if (i > 0) status = true;

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // UPDATE
    public boolean updatePayment(FeePayment fp) {
        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE FeePayments SET StudentID=?, StudentName=?, PaymentDate=?, Amount=?, Status=? WHERE PaymentID=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, fp.getStudentID());
            ps.setString(2, fp.getStudentName());
            ps.setString(3, fp.getPaymentDate());
            ps.setDouble(4, fp.getAmount());
            ps.setString(5, fp.getStatus());
            ps.setInt(6, fp.getPaymentID());

            int i = ps.executeUpdate();
            if (i > 0) status = true;

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // REPORT: OVERDUE
    public List<FeePayment> getOverduePayments() {
        List<FeePayment> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM FeePayments WHERE Status='Overdue'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FeePayment fp = new FeePayment();

                fp.setPaymentID(rs.getInt("PaymentID"));
                fp.setStudentID(rs.getInt("StudentID"));
                fp.setStudentName(rs.getString("StudentName"));
                fp.setPaymentDate(rs.getString("PaymentDate"));
                fp.setAmount(rs.getDouble("Amount"));
                fp.setStatus(rs.getString("Status"));

                list.add(fp);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public double getTotalByDateRange(String from, String to) {

        double total = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT SUM(Amount) AS total FROM FeePayments " +
                         "WHERE DATE(PaymentDate) BETWEEN ? AND ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, java.sql.Date.valueOf(from));
            ps.setDate(2, java.sql.Date.valueOf(to));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble("total");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }
    public String getStudentNameById(int studentID) {
        String name = "";

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT StudentName FROM FeePayments WHERE StudentID=? LIMIT 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentID);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                name = rs.getString("StudentName");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return name;
    }
}