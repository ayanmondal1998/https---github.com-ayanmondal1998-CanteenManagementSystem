package com.hexaware.jdbccrudexample.Factory;


import com.hexaware.jdbccrudexample.Model.Item;
import com.hexaware.jdbccrudexample.Persistence.ItemDAO;
import java.util.List;


public class ItemFactory {

    public ItemDAO itDao = new ItemDAO();

    public void insertItem(int argItemId,String argItemName,float argItemPrice,
                                    int argItemQty,String argItemType){
        try {
            itDao.insertItem(argItemId,argItemName, argItemPrice, argItemQty, argItemType);
        }catch(Exception e){
                e.printStackTrace();
        }
    }  
    
    public List<Item> showItemList(){
        return itDao.showItemList();
    }
    
    public Item updateItem(int argItemId,float argItemPrice){
        return itDao.updateItem(argItemId,argItemPrice);
    }

    public Item deleteItem(int argItemId){
        return itDao.deleteItem(argItemId);
    }

    public Item showItemById(int argItemId){
        return itDao.showItemById(argItemId);
    }
}
