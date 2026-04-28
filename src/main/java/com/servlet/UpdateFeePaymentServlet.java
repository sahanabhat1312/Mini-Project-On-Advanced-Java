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

            String pid = request.getParameter("paymentID");
            String sid = request.getParameter("studentID");
            String name = request.getParameter("studentName");
            String date = request.getParameter("paymentDate");
            String amt = request.getParameter("amount");
            String status = request.getParameter("status");

            if (pid == null || sid == null || name == null || date == null || amt == null) {
                throw new Exception("Missing form values");
            }

            int paymentID = Integer.parseInt(pid);
            int studentID = Integer.parseInt(sid);

            // ✅ VALIDATION
            if (studentID <= 0) {
                request.setAttribute("msg", "Invalid Student ID! Only positive numbers allowed.");
                request.setAttribute("type", "fail");
                request.getRequestDispatcher("result.jsp").forward(request, response);
                return;
            }

            double amount = Double.parseDouble(amt);

            FeePayment fp = new FeePayment();
            fp.setPaymentID(paymentID);
            fp.setStudentID(studentID);
            fp.setStudentName(name);
            fp.setPaymentDate(date);
            fp.setAmount(amount);
            fp.setStatus(status);

            FeePaymentDAO dao = new FeePaymentDAO();

            boolean result = dao.updatePayment(fp);

            if (result) {
                request.setAttribute("msg", "Updated Successfully");
                request.setAttribute("type", "success");
            } else {
                request.setAttribute("msg", "Update Failed");
                request.setAttribute("type", "fail");
            }

            request.getRequestDispatcher("result.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("msg", "Error: " + e.getMessage());
            request.setAttribute("type", "fail");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
    }
}