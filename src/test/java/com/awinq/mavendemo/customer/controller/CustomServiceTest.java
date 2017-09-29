package com.awinq.mavendemo.customer.controller;

import com.awinq.maven.service.customer.CustomerService;
import org.junit.Before;

public class CustomServiceTest {
    private  final CustomerService customerService;
    public  CustomServiceTest(){
        customerService = new CustomerService();
    }

    @Before
    public void init(){

    }
}
