package com.rwt.controller;

import com.rwt.entity.Customer;
import com.rwt.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerServlet extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        super.init();
        customerService=new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        List<Customer> customerList=customerService.getCustomerList();
        req.setAttribute("CustomerList",customerList);
        req.getRequestDispatcher("/WEB-INF/JSP/customer.jsp").forward(req,resp);
    }
}
