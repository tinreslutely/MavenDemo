package com.awinq.maven.service.customer;

import com.awinq.Helpers.DatabaseHelper;
import com.awinq.Utilities.PropsUtil;
import com.awinq.maven.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);
    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static{
        Properties conf = PropsUtil.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");
        try{
            Class.forName(DRIVER);
        }catch(java.lang.ClassNotFoundException e){
            LOGGER.error("can not load jdbc driver",e);
        }
    }
    public List<Customer> getCustomerList(){
        Connection conn = null;
        try{
            List<Customer> customerList = new ArrayList<Customer>();
            String sql = "select * from customer";
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setContact(resultSet.getString("contract"));
                customer.setTelephone(resultSet.getString("telephone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setRemark(resultSet.getString("remark"));
                customerList.add(customer);
            }
            return customerList;
        }catch(SQLException e){
            LOGGER.error("execute sql failure",e);
        }finally{
            if(conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    LOGGER.error("close connection failure",e);
                }
            }
        }
        return null;
    }
    public Customer getCustomer(long id){
        return null;
    }
    public boolean createCustomer(Map<String, Object> filedMap){
        return DatabaseHelper.insertEntity(Customer.class,filedMap);
    }
}
