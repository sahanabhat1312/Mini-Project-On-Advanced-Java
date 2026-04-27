package com.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.DBConnection;
import com.model.FeePayment;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");

        if(type != null && type.equals("overdue")) {

            List<FeePayment> list = new ArrayList<>();

            try {
                Connection con = DBConnection.getConnection();

                String sql = "SELECT * FROM FeePayments WHERE Status='Overdue'";
                PreparedStatement ps = con.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();

                while(rs.next()) {
                    FeePayment fp = new FeePayment();

                    fp.setPaymentID(rs.getInt("PaymentID"));
                    fp.setStudentName(rs.getString("StudentName"));
                    fp.setAmount(rs.getDouble("Amount"));
                    fp.setStatus(rs.getString("Status"));

                    list.add(fp);
                }

                con.close();

            } catch(Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("list", list);
            request.setAttribute("type", "overdue");

            request.getRequestDispatcher("report_result.jsp").forward(request, response);
        }
    }
}