package com.hexaware.jdbccrudexample.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hexaware.jdbccrudexample.Model.Order;

public class OrderDAO {
    
    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    List<Order> listOfOrders = new ArrayList<Order>();

        /**
     * Call the data base connection.
     * 
     * @return the connection object.
     */
    public static void getDBConnection() {
        conn = DBConnection.getConnect();
        //return conn;
    }

    static{
        getDBConnection();
    }

    public void insertOrder(int argOrderId,int argVendorId,int argCustomerId,int argFoodId,
                                    int argItemQty,String argOrderStatus,float argOrderPrice,String argDate){
        try {
            //getDBConnection();
            String insertOrder = "insert into OrderT(OrderId,VendorId,CustomerId,FoodId,itemQty,OrderStatus,OrderPrice,OrderDate) values(?,?,?,?,?,?,?,?);";
            pstmt = conn.prepareStatement(insertOrder);
            pstmt.setInt(1, argOrderId);
            pstmt.setInt(2, argVendorId);
            pstmt.setInt(3, argCustomerId);
            pstmt.setInt(4, argFoodId);
            pstmt.setInt(5, argItemQty);
            pstmt.setString(6, argOrderStatus);
            pstmt.setFloat(7, argOrderPrice);
            pstmt.setString(8,argDate);
        
            int i =pstmt.executeUpdate();
            if(i!=0){
                System.out.println("Order added Successfully");
            }else{
                System.out.println("Order Not added");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
             
    }

    Order order = null;
    public List<Order> showOrderList(){
        try {
            //getDBConnection();
            String selectItems = "select * from OrderT";
            pstmt = conn.prepareStatement(selectItems);
            ResultSet OrderList = pstmt.executeQuery();
            while(OrderList.next()){
                order = new Order(OrderList.getInt(1), OrderList.getInt(2),OrderList.getInt(3),OrderList.getInt(4),
                                    OrderList.getInt(5),OrderList.getString(6),OrderList.getInt(7),OrderList.getString(8));
                listOfOrders.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfOrders;
    }
    
    public Order updateOrder(int argOrderId,float argOrderPrice){
        try {
            String updateorder = "update OrderT set OrderPrice = ? where OrderId = ?";
            pstmt = conn.prepareStatement(updateorder);
            pstmt.setFloat(1, argOrderPrice);
            pstmt.setInt(2, argOrderId);
           int i =  pstmt.executeUpdate();
           if(i!=0){
            System.out.println("Item updated Successfully");
            }else{
                System.out.println("Item Not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return order;
    }

    public Order deleteOrder(int argOrderId) {
        try {
            String deleteItem = "delete from  OrderT where Orderid = ?";
            pstmt = conn.prepareStatement(deleteItem);
            pstmt.setInt(1, argOrderId);
           int i =  pstmt.executeUpdate();
           if(i!=0){
            System.out.println("Item deleted Successfully");
            }else{
                System.out.println("Item Not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return order;
    }

    public Order showOrderById(int argOrderId) {
        try {
            //getDBConnection();
            String selectItemById = "select * from OrderT where Orderid = ?";
            pstmt = conn.prepareStatement(selectItemById);
            pstmt.setInt(1, argOrderId);
            ResultSet OrderList = pstmt.executeQuery();
            while(OrderList.next()){
                order = new Order(OrderList.getInt(1), OrderList.getInt(2),OrderList.getInt(3),OrderList.getInt(4),
                                    OrderList.getInt(5),OrderList.getString(6),OrderList.getInt(7),OrderList.getString(8));
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }




}

