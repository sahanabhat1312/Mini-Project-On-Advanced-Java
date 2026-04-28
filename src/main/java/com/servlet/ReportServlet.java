 package com.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.DBConnection;
import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String type = request.getParameter("type");

        if(type != null && type.equals("overdue")) {

            try {

                FeePaymentDAO dao = new FeePaymentDAO();
                List<FeePayment> list = dao.getOverduePayments();

                request.setAttribute("list", list);
                request.setAttribute("type", "overdue");

                request.getRequestDispatcher("report_result.jsp").forward(request, response);

            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}