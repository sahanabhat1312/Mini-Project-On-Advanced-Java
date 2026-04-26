package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/updatePayment")
public class UpdateFeePaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int paymentID = Integer.parseInt(request.getParameter("paymentID"));
            int studentID = Integer.parseInt(request.getParameter("studentID"));
            String studentName = request.getParameter("studentName");
            String paymentDate = request.getParameter("paymentDate");
            double amount = Double.parseDouble(request.getParameter("amount"));
            String status = request.getParameter("status");

            FeePayment fp = new FeePayment();
            fp.setPaymentID(paymentID);
            fp.setStudentID(studentID);
            fp.setStudentName(studentName);
            fp.setPaymentDate(paymentDate);
            fp.setAmount(amount);
            fp.setStatus(status);

            FeePaymentDAO dao = new FeePaymentDAO();
            boolean result = dao.updatePayment(fp);
            response.setContentType("text/html");
            if (result) {
                response.getWriter().println("<h2 style='color:green;'>Updated Successfully</h2>");
            } else {
                response.getWriter().println("<h2 style='color:red;'>Update Failed</h2>");
            }

        } catch (Exception e) {
            response.getWriter().println("Error: " + e);
        }
    }
}