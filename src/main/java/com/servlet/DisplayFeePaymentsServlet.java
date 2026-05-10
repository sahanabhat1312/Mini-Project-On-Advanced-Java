package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/displayPayments")
public class DisplayFeePaymentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FeePaymentDAO dao = new FeePaymentDAO();

        List<FeePayment> list = dao.getAllPayments();

        request.setAttribute("list", list);

        request.getRequestDispatcher("feepaymentdisplay.jsp")
               .forward(request, response);
    }
}