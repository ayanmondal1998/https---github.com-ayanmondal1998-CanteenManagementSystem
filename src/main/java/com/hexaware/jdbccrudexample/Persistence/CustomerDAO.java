package com.hexaware.jdbccrudexample.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.jdbccrudexample.Model.Customer;

public class CustomerDAO {

    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    List<Customer> custList = new ArrayList<Customer>();

    /**
     * Call the data base connection.
     * 
     * @return the connection object.
     */
    public static void getDBConnection() {
        conn = DBConnection.getConnect();
        //return conn;
    }

    public void insertCustomer(int cusId, String cusName, String cusPhone, String cusEmail, String cusCoupon,float cusBill) {
       
        try {
            getDBConnection();
            String insertVen = "insert into customer values(?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(insertVen);
            pstmt.setInt(1, cusId);
            pstmt.setString(2, cusName);
            pstmt.setString(3, cusEmail);
            pstmt.setString(4, cusPhone);
            pstmt.setString(5, cusCoupon);
            pstmt.setFloat(6, cusBill);
            int i = pstmt.executeUpdate();
            if(i!=0){
                System.out.println("Successful");
            }else{
                System.out.println("Not Successful");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    Customer v = null;
    public List<Customer> showCustomerList() {
        try {
            getDBConnection();
            String selectVendors = "select * from customer";
            pstmt = conn.prepareStatement(selectVendors);
            ResultSet venList = pstmt.executeQuery();
            while(venList.next()){
                v = new Customer(venList.getInt(1),venList.getString(2),venList.getString(3),venList.getString(4),venList.getString(5),venList.getFloat(6));
                custList.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return custList;
    }

    public Customer updateCustomer(int argcusId,float argcusBill){
        try {
            String updateItem = "update customer set cusBill = ? where cusid = ?";
            pstmt = conn.prepareStatement(updateItem);
            pstmt.setFloat(1, argcusBill);
            pstmt.setInt(2, argcusId);
           int i =  pstmt.executeUpdate();
           if(i!=0){
            System.out.println("Item updated Successfully");
            }else{
                System.out.println("Item Not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public Customer deleteCustomer(int argcusId) {
        try {
            String deleteItem = "delete from  customer where cusId = ?";
            pstmt = conn.prepareStatement(deleteItem);
            pstmt.setInt(1, argcusId);
           int i =  pstmt.executeUpdate();
           if(i!=0){
            System.out.println("Item deleted Successfully");
            }else{
                System.out.println("Item Not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public Customer showCustomerById(int argcusId) {
        try {
            //getDBConnection();
            String selectItemById = "select * from customer where cusId = ?";
            pstmt = conn.prepareStatement(selectItemById);
            pstmt.setInt(1, argcusId);
            ResultSet itemList = pstmt.executeQuery();
            while(itemList.next()){
                v = new Customer(itemList.getInt(1), itemList.getString(2),itemList.getString(3),itemList.getString(4),
                                    itemList.getString(5),itemList.getFloat(6));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }




}




    
