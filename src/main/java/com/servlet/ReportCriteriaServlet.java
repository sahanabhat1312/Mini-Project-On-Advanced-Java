package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.FeePaymentDAO;

@WebServlet("/reportCriteria")
public class ReportCriteriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String from = request.getParameter("fromDate");
            String to = request.getParameter("toDate");

            FeePaymentDAO dao = new FeePaymentDAO();
            double total = dao.getTotalByDateRange(from, to);

            request.setAttribute("from", from);
            request.setAttribute("to", to);
            request.setAttribute("total", total);

            request.getRequestDispatcher("report_result.jsp").forward(request, response);

        } catch(Exception e) {
            request.setAttribute("msg", e.getMessage());
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}