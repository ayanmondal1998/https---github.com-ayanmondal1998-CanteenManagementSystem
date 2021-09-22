package com.hexaware.jdbccrudexample.Persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.jdbccrudexample.Model.Vendor;
public class VendorDAO {
    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    List<Vendor> vendorList = new ArrayList<Vendor>();

    /**
     * Call the data base connection.
     * 
     * @return the connection object.
     */
    public static void getDBConnection() {
        conn = DBConnection.getConnect();
        //return conn;
    }

    public void insertVendor(int venId, String venName, String venPhone, String venEmail) {
       
        try {
            getDBConnection();
            String insertVen = "insert into vendor values(?,?,?,?)";
            pstmt = conn.prepareStatement(insertVen);
            pstmt.setInt(1, venId);
            pstmt.setString(2, venName);
            pstmt.setString(3, venEmail);
            pstmt.setString(4, venPhone);
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
    Vendor v = null;
    public List<Vendor> showVendorList() {
        try {
            getDBConnection();
            String selectVendors = "select * from vendor";
            pstmt = conn.prepareStatement(selectVendors);
            ResultSet venList = pstmt.executeQuery();
            while(venList.next()){
                v = new Vendor(venList.getInt(1),venList.getString(2),venList.getString(3),venList.getString(4));
                vendorList.add(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vendorList;
    }
    public Vendor updateVendor(int venId,String venName){
        try {
            String updateItem = "update vendor set venName = ? where venId = ?";
            pstmt = conn.prepareStatement(updateItem);
            pstmt.setString(1, venName);
            pstmt.setInt(2, venId);
           int i =  pstmt.executeUpdate();
           if(i!=0){
            System.out.println("Vendor updated Successfully");
            }else{
                System.out.println("vendor Not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public Vendor deleteVendor(int venId) {
        try {
            String deleteItem = "delete from  vendor where venId = ?";
            pstmt = conn.prepareStatement(deleteItem);
            pstmt.setInt(1, venId);
           int i =  pstmt.executeUpdate();
           if(i!=0){
            System.out.println("Vendor deleted Successfully");
            }else{
                System.out.println("Vendor Not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return v;
    }

    public Vendor showVendorById(int venId) {
        try {
            //getDBConnection();
            String selectItemById = "select * from vendor where venId = ?";
            pstmt = conn.prepareStatement(selectItemById);
            pstmt.setInt(1, venId);
            ResultSet venList = pstmt.executeQuery();
            while(venList.next()){
                v = new Vendor(venList.getInt(1),venList.getString(2),venList.getString(3),venList.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }


}
