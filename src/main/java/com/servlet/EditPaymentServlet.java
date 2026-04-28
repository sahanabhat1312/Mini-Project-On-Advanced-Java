 package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.*;
import com.model.*;

@WebServlet("/editPayment")
public class EditPaymentServlet extends HttpServlet {
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