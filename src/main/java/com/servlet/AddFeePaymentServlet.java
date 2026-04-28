package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/addPayment")
public class AddFeePaymentServlet extends HttpServlet {

    // 🔹 FETCH NAME (AJAX)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sid = request.getParameter("studentID");

        try {
            int studentID = Integer.parseInt(sid);

            FeePaymentDAO dao = new FeePaymentDAO();
            String name = dao.getStudentNameById(studentID);

            response.getWriter().write(name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 ADD PAYMENT
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String sid = request.getParameter("studentID");
            String name = request.getParameter("studentName");
            String date = request.getParameter("paymentDate");
            String amt = request.getParameter("amount");
            String status = request.getParameter("status");

            if (sid == null || name == null || date == null || amt == null) {
                throw new Exception("Form values missing");
            }

            int studentID = Integer.parseInt(sid);

            // VALIDATION
            if (studentID <= 0) {
                request.setAttribute("msg", "Invalid Student ID!");
                request.setAttribute("type", "fail");
                request.getRequestDispatcher("result.jsp").forward(request, response);
                return;
            }

            double amount = Double.parseDouble(amt);

            FeePayment fp = new FeePayment();
            fp.setStudentID(studentID);
            fp.setStudentName(name);
            fp.setPaymentDate(date);
            fp.setAmount(amount);
            fp.setStatus(status);

            FeePaymentDAO dao = new FeePaymentDAO();
            boolean result = dao.addPayment(fp);

            if (result) {
                request.setAttribute("msg", "Payment Added Successfully");
                request.setAttribute("type", "success");
            } else {
                request.setAttribute("msg", "Failed to Add Payment");
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