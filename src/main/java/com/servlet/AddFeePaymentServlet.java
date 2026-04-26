package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/addPayment")
public class AddFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int studentID = Integer.parseInt(request.getParameter("studentID"));
            String name = request.getParameter("studentName");
            String date = request.getParameter("paymentDate");
            double amount = Double.parseDouble(request.getParameter("amount"));
            String status = request.getParameter("status");

            FeePayment fp = new FeePayment();
            fp.setStudentID(studentID);
            fp.setStudentName(name);
            fp.setPaymentDate(date);
            fp.setAmount(amount);
            fp.setStatus(status);

            FeePaymentDAO dao = new FeePaymentDAO();
            boolean result = dao.addPayment(fp);

            if(result) {
                request.setAttribute("msg", "Payment Added Successfully");
                request.setAttribute("type", "success");
            } else {
                request.setAttribute("msg", "Failed to Add Payment");
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