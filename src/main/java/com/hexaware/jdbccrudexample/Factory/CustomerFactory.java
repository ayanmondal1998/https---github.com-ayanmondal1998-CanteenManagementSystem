package com.hexaware.jdbccrudexample.Factory;

import java.util.List;

import com.hexaware.jdbccrudexample.Model.Customer;
import com.hexaware.jdbccrudexample.Persistence.CustomerDAO;

public class CustomerFactory {
    
    public CustomerDAO cusDao = new CustomerDAO();

    public void insertCustomer(int argcusId, String argcusName, String argcusPhone, String argcusEmail, String argcusCoupon,float argcusBill)
    {
        try {
            cusDao.insertCustomer(argcusId,argcusName,argcusPhone,argcusEmail,argcusCoupon,argcusBill);
        }catch(Exception e){
                e.printStackTrace();
        }
    }  
    
    public List<Customer> showCustomerList(){
        return cusDao.showCustomerList();
    }
    
    public Customer updateCustomer(int argcusId,float argcusBill){
        return cusDao.updateCustomer(argcusId,argcusBill);
    }

    public Customer deletecCustomer(int argcusId){
        return cusDao.deleteCustomer(argcusId);
    }

    public Customer showCustomerById(int argcusId){
        return cusDao.showCustomerById(argcusId);
    }
}

