 package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FeePaymentDAO;
import com.model.FeePayment;

@WebServlet("/editPayment")
public class EditPaymentServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

int id = Integer.parseInt(request.getParameter("paymentID"));

FeePaymentDAO dao = new FeePaymentDAO();
FeePayment fp = null;

for(FeePayment f : dao.getAllPayments()){
if(f.getPaymentID()==id){
fp=f;
break;
}
}

request.setAttribute("fp", fp);
request.getRequestDispatcher("feepaymentupdate.jsp").forward(request,response);
}
}