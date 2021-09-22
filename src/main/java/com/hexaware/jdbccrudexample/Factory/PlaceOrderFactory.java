package com.hexaware.jdbccrudexample.Factory;

import java.util.List;

import com.hexaware.jdbccrudexample.Model.PlaceOrder;
import com.hexaware.jdbccrudexample.Persistence.PlaceOrderDAO;

public class PlaceOrderFactory {
    
    public PlaceOrderDAO itDao = new PlaceOrderDAO();

    public void insertOrder(String argcusName,String argfoodName,int argItemQty,String argplaceOrder){
        try {
            itDao.insertOrder(argcusName,argfoodName,argItemQty,argplaceOrder);
        }catch(Exception e){
                e.printStackTrace();
        }
    }  
    
    public List<PlaceOrder> showOrderList(){
        return itDao.showOrderList();
    }
}
