package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/updatePayment")
public class UpdateFeePaymentServlet extends HttpServlet {

    // FETCH DATA
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");

        String pid = request.getParameter("paymentID");

        if(pid == null || pid.trim().isEmpty()) {
            response.getWriter().write("");
            return;
        }

        try {

            int paymentID = Integer.parseInt(pid);

            FeePaymentDAO dao = new FeePaymentDAO();

            FeePayment fp = dao.getPaymentById(paymentID);

            if(fp != null) {

                String data =
                    fp.getStudentID() + "|" +
                    fp.getStudentName() + "|" +
                    fp.getPaymentDate() + "|" +
                    fp.getAmount() + "|" +
                    fp.getStatus();

                response.getWriter().write(data);

            } else {
                response.getWriter().write("");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
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

            if(result) {

                request.setAttribute("msg", "Payment Updated Successfully");
                request.setAttribute("type", "success");

            } else {

                request.setAttribute("msg", "Update Failed");
                request.setAttribute("type", "fail");
            }

            request.getRequestDispatcher("result.jsp")
                   .forward(request, response);

        } catch(Exception e) {

            request.setAttribute("msg", "Error");
            request.setAttribute("type", "fail");

            request.getRequestDispatcher("result.jsp")
                   .forward(request, response);
        }
    }
}