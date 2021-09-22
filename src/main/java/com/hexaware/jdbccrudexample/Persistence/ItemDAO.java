package com.hexaware.jdbccrudexample.Persistence;

import java.sql.*;
import com.hexaware.jdbccrudexample.Model.Item;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    public static Connection conn = null;
    public static PreparedStatement pstmt = null;
    List<Item> listOfItem = new ArrayList<Item>();

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

    public void insertItem(int argItemId,String argItemName,float argItemPrice,
                                    int argItemQty,String argItemType){
        try {
            //getDBConnection();
            String insertItem = "insert into Item(itemId,itemName,itemPrice,itemQty,itemType) values(?,?,?,?,?);";
            pstmt = conn.prepareStatement(insertItem);
            pstmt.setInt(1, argItemId);
            pstmt.setString(2, argItemName);
            pstmt.setFloat(3, argItemPrice);
            pstmt.setInt(4, argItemQty);
            pstmt.setString(5, argItemType);
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

    Item item = null;
    public List<Item> showItemList(){
        try {
            //getDBConnection();
            String selectItems = "select * from Item";
            pstmt = conn.prepareStatement(selectItems);
            ResultSet itemList = pstmt.executeQuery();
            while(itemList.next()){
                item = new Item(itemList.getInt(1), itemList.getString(2),itemList.getFloat(3),itemList.getInt(4),
                                    itemList.getString(5));
                listOfItem.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfItem;
    }
    
    public Item updateItem(int argItemId,float argItemPrice){
        try {
            String updateItem = "update item set itemprice = ? where itemid = ?";
            pstmt = conn.prepareStatement(updateItem);
            pstmt.setFloat(1, argItemPrice);
            pstmt.setInt(2, argItemId);
           int i =  pstmt.executeUpdate();
           if(i!=0){
            System.out.println("Item updated Successfully");
            }else{
                System.out.println("Item Not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return item;
    }

    public Item deleteItem(int argItemId) {
        try {
            String deleteItem = "delete from  item where itemid = ?";
            pstmt = conn.prepareStatement(deleteItem);
            pstmt.setInt(1, argItemId);
           int i =  pstmt.executeUpdate();
           if(i!=0){
            System.out.println("Item deleted Successfully");
            }else{
                System.out.println("Item Not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return item;
    }

    public Item showItemById(int argItemId) {
        try {
            //getDBConnection();
            String selectItemById = "select * from Item where itemid = ?";
            pstmt = conn.prepareStatement(selectItemById);
            pstmt.setInt(1, argItemId);
            ResultSet itemList = pstmt.executeQuery();
            while(itemList.next()){
                item = new Item(itemList.getInt(1), itemList.getString(2),itemList.getFloat(3),itemList.getInt(4),
                                    itemList.getString(5));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }




}
