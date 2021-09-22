package com.hexaware.jdbccrudexample.Persistence;


    import java.sql.*;
import com.hexaware.jdbccrudexample.Model.PlaceOrder;

import java.util.ArrayList;
import java.util.List;
public class PlaceOrderDAO {
    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    List<PlaceOrder> listOfItem = new ArrayList<PlaceOrder>();

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

    public void insertOrder(String argcusName,String argfoodName,
                                    int argItemQty,String argplaceOrder){
        try {
            //getDBConnection();
            String insertItem = "insert into placeOrderC(cusName,foodName,itemQty,placeOrder) values(?,?,?,?);";
            pstmt = conn.prepareStatement(insertItem);
            pstmt.setString(1, argcusName);
            pstmt.setString(2, argfoodName);
            pstmt.setInt(3, argItemQty);
            pstmt.setString(4, argplaceOrder);
            int i =pstmt.executeUpdate();
            if(i!=0){
                System.out.println("Item added Successfully");
            }else{
                System.out.println("Item Not added");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
             
    }

    PlaceOrder item = null;
    public List<PlaceOrder> showOrderList(){
        try {
            //getDBConnection();
            String selectItems = "select * from placeOrderC";
            pstmt = conn.prepareStatement(selectItems);
            ResultSet itemList = pstmt.executeQuery();
            while(itemList.next()){
                item = new PlaceOrder(itemList.getString(1), itemList.getString(2),itemList.getInt(3),itemList.getString(4));
                listOfItem.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfItem;
    }
}
    
  

   