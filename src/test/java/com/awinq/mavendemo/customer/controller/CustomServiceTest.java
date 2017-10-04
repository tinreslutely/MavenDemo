package com.awinq.mavendemo.customer.controller;

import com.awinq.Helpers.DatabaseHelper;
import com.awinq.maven.model.Customer;
import com.awinq.maven.service.customer.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.rmi.server.ExportException;
import java.util.List;

public class CustomServiceTest {
    private  final CustomerService customerService;
    public  CustomServiceTest(){
        customerService = new CustomerService();
    }

    @Before
    public void init() throws Exception{
        DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }

    @Test
    public void getCustomerListTest() throws Exception{
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(1,customerList.size());
    }
}
