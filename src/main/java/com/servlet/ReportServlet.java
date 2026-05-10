package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FeePaymentDAO dao = new FeePaymentDAO();

        List<FeePayment> list = dao.getOverduePayments();

        request.setAttribute("list", list);

        request.getRequestDispatcher("report_result.jsp")
               .forward(request, response);
    }
}