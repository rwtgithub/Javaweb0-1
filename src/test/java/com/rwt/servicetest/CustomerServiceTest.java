package com.rwt.servicetest;

import com.rwt.entity.Customer;
import com.rwt.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @Before
    public void init(){
        //TODO初始化数据库
    }

    @Test
    public void getCustomerListTest(){
        List<Customer> list=customerService.getCustomerList();
        Assert.assertEquals(2,list.size());
    }
}
