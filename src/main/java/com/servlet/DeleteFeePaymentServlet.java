package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.FeePaymentDAO;

@WebServlet("/deletePayment")
public class DeleteFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(request.getParameter("paymentID"));

            FeePaymentDAO dao = new FeePaymentDAO();
            boolean result = dao.deletePayment(id);

            if(result) {
                request.setAttribute("msg", "Payment Deleted Successfully");
                request.setAttribute("type", "success");
            } else {
                request.setAttribute("msg", "Delete Failed");
                request.setAttribute("type", "fail");
            }

            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch(Exception e) {
            request.setAttribute("msg", "Error: " + e);
            request.setAttribute("type", "fail");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}