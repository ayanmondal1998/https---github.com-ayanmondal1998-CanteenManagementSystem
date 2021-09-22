package com.hexaware.jdbccrudexample.Factory;

import java.sql.Date;
import java.util.List;

import com.hexaware.jdbccrudexample.Model.Order;
import com.hexaware.jdbccrudexample.Persistence.OrderDAO;

public class OrderFactory {
    public OrderDAO ordao=new OrderDAO();
    public void insertOrder(int argOrderId,int argVendorId,int argCustomerId,int argFoodId,
    int argItemQty,String argOrderStatus,float argOrderPrice,String argDate)
    {
        try {
            ordao.insertOrder(argOrderId,argVendorId,argCustomerId,argFoodId,argItemQty,argOrderStatus,argOrderPrice,argDate);
        }catch(Exception e){
                e.printStackTrace();
        }
    }  
    public List<Order> showOrderList(){
        return ordao.showOrderList();
    }
    
    public Order updateOrder(int argOrderId,float argOrderPrice){
        return ordao.updateOrder(argOrderId,argOrderPrice);
    }

    public Order deleteOrder(int argOrderId){
        return ordao.deleteOrder(argOrderId);
    }

    public Order showOrderById(int argOrderId){
        return ordao.showOrderById(argOrderId);
    }
}

    

    

