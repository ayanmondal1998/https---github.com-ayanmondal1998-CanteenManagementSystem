package com.hexaware.jdbccrudexample.Util;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.jdbccrudexample.Model.Customer;
import com.hexaware.jdbccrudexample.Model.Item;
import com.hexaware.jdbccrudexample.Model.Order;
import com.hexaware.jdbccrudexample.Model.PlaceOrder;
import com.hexaware.jdbccrudexample.Model.Vendor;
import com.google.protobuf.ExtensionRegistry.ExtensionInfo;
import com.hexaware.jdbccrudexample.Factory.CustomerFactory;
import com.hexaware.jdbccrudexample.Factory.ItemFactory;
import com.hexaware.jdbccrudexample.Factory.OrderFactory;
import com.hexaware.jdbccrudexample.Factory.PlaceOrderFactory;
import com.hexaware.jdbccrudexample.Factory.VendorFactory;

public class CliMain {
   public  VendorFactory venFactory = new VendorFactory();
   Scanner sc = new Scanner(System.in);
   List<Vendor> vList = new ArrayList<Vendor>();
   List<Item> itemList = new ArrayList<Item>();
   List<Order> ordlist=new ArrayList<Order>();
   List<Customer>cusList=new ArrayList<Customer>();
   List<PlaceOrder> polist=new ArrayList<PlaceOrder>();
   static CliMain cm = new CliMain();
   public static void main(String[] args) {
       cm.mainZ();
       
   }
    public void mainZ() {
        String username,password;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to canteen");
        System.out.println("");
        System.out.println("Choose the belows Options");
        System.out.println("CustomerLogin");
        System.out.println("VendorLogin");
        String ac=sc.next();
        switch(ac){
            case "CustomerLogin":
            System.out.println("Enter the id");
            sc.nextLine();
            username=sc.nextLine();
            System.out.println("Enter the password");
            password=sc.nextLine();
            if(username.equals("customer")&&password.equals("cus123")){
                System.out.println("Authentication successful");
                cm.mainMenuT();
            }
            else{
                System.out.println("Authentication Failed");
            }
            break;
            case "VendorLogin":
            System.out.println("Enter the vendor id");
            sc.nextLine();
            username=sc.nextLine();
            System.out.println("Enter the password");
            password=sc.nextLine();
            if(username.equals("vendor")&&password.equals("ven123")){
                System.out.println("Authentication successful");
                cm.mainMenu();
            }
            else{
                System.out.println("Authentication Failed");
            }
            break;
            case "signout":
            break;

        }
       
    }
    public void mainMenuT(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(".....Welcome to Canteen Management System......");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Choose the transaction........");
        System.out.println("Customer :  Customer transactions");
        System.out.println("PlaceOrder: to place Order");

         lp:while(true)
         {
            String action = sc.next();
        switch (action) {
            case "Customer":
                cm.customerMenu();
                break;
            case "PlaceOrder" :
                cm.placeOrder();
                break;
            case "N":
            System.out.println("Returning to main menu");
               break lp;
            case "signout":
            cm.mainZ();
           default:
            System.out.println("Returning to your menu ....\n\n");
              cm.mainMenuT();
            
        }
    }
            
        
}

    

    public void mainMenu(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(".....Welcome to Canteen Management System......");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Choose the transaction........");
        System.out.println("Vendor :  Vendor transactions");
        System.out.println("Item :  Item operations");
        
        System.out.println("Order :  Order details");
    

         lp:while(true)
         {
            String action = sc.next();
        switch (action) {
            case "Vendor":
                cm.vendorMenu();
                break;
            case "Item":
                cm.ItemMenu();
                break;
            case "Order" :
               cm.OrderMenu();
                break;
            case "N":
            System.out.println("Press any key to return to main menu");
               break lp;

            case "signout":
            System.out.println("Returning to your menu ....\n\n");
              cm.mainZ();
            default:
            System.out.println("Returning to Vendor");
            cm.mainMenu();
            
        }
    }
            
        
}

            


    public void placeOrder()
    {
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Welcome to Order Management System......");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Choose the transaction........");
        System.out.println("addOrder : to place the Order");
        System.out.println("displayOrders : to show the Order");  
        String custTransaction=sc.next();
        switch (custTransaction) {
            case "addOrder":
                readPlaceOrderDetails();
                break;
            case "displayOrders":
                showPlaceOrderList();
                break;
            default :
                   System.out.println("Wrong choice");
                   break;
        }

    }
    public void OrderMenu(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Welcome to Item Management System......");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Choose the transaction........");
        System.out.println("addOrder : to insert the Order");
        System.out.println("deleteOrder : to delete the Order");
        System.out.println("updateOrder : to update the order");
        System.out.println("displayorder : to display the Order list");
        System.out.println("showOrder : to display the order using Id");
        String custTransaction = sc.next();

        switch (custTransaction) {
            case "addOrder":
                readOrderDetails();
                break;
            case "displayOrder":
                showOrderList();
                break;
            case "updateOrders":
                updateOrder();
                break; 
            case "deleteOrder":
                deleteOrder();
                break;  
            case "showOrder":
                showOrderById();
                break;    
            default:
                System.out.println("Wrong Option");
                break;
        }
    }

    
    public void ItemMenu(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Welcome to Item Management System......");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Choose the transaction........");
        System.out.println("addItem : to insert the Item");
        System.out.println("deleteItem : to delete the Item");
        System.out.println("updateItem : to update the Item");
        System.out.println("displayItems : to display the Item list");
        System.out.println("showItem : to display the Item using Id");
        String custTransaction = sc.next();

        switch (custTransaction) {
            case "addItem":
                readItemDetails();
                break;
            case "displayItems":
                showItemList();
                break;
            case "updateItem":
                updateItem();
                break; 
            case "deleteItem":
                deleteItem();
                break;  
            case "showItem":
                showItemById();
                break;    
            default:
                System.out.println("Wrong Option");
                break;
        }
    }

    public void customerMenu(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Welcome to Customer Management System......");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Choose the transaction........");
        System.out.println("addCustomer : to insert the Customer");
        System.out.println("deleteCustomer : to delete the Customer");
        System.out.println("updateCustomer : to update the Customer");
        System.out.println("displayCustomer : to display the Customer list");
        System.out.println("showCustomer : to display the Customer using Id");
        System.out.println("OrderStatus : see the order status");
        String custTransaction = sc.next();

        switch (custTransaction) {
            case "addCustomer":
            readCustomerDetails();
            break;
        case "displayCustomer":
            showCustomerList();
            break;
        case "updateCustomer":
            updateCustomer();
            break; 
        case "deleteCustomer":
            deleteCustomer();
            break;  
        case "showCustomer":
            showCustomerById();
            break; 
        case "OrderStatus":
           showOrderList();
           break;

            default:
            System.out.println("Wrong Option");
                break;
        }
    }

    public void vendorMenu(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Welcome to Vendor Management System......");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Choose the transaction........");
        System.out.println("addVendor : to insert the vendor");
        System.out.println("deleteVendor : to delete the vendor");
        System.out.println("updateVendor : to update the vendor");
        System.out.println("displayVendor : to display the vendor list");
        System.out.println("showVendorById : to display the vendor using Id");
        System.out.println("seeOrderList :SEE the Order list ");
        System.out.println("confirmOrder : To confirm the Order");
        
        String transaction = sc.next();

        switch (transaction) {
            case "addVendor":
                readVendorDetails();
                break;
            case "displayVendor":
                showVendorList();
                break;
            case "seeOrderList":
                 showPlaceOrderList();
            break;
            case "updateVendor" :
              updateVendor();
              break;
            case "deleteVendor":
                deleteVendor();
                break;
            case "showVendorById":
                 showVendorById();
                 break;
            case "confirmOrder" :
                  readOrderDetails();
                  break;
                  
        
            default:
            System.out.println("Wrong Option");
                break;
        }
    }
    
    private void showVendorList() {
        vList=venFactory.showVendorList();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("List of Vendors......................................");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("VendorId \t VendorName \t VendorEmail \t VendorMobno");
        for(int i =0;i<vList.size();i++){
        System.out.println(vList.get(i).getVenId()+"\t"+vList.get(i).getVenName()+"\t"+vList.get(i).getVenEmail()+"\t"+vList.get(i).getVenMobNo());
        }
    }

    public void readVendorDetails(){
            System.out.println("Enter the vendor details to register........");
            System.out.println("Enter the vendorId");
            int lvenId = sc.nextInt();
            System.out.println("Enter the vendorName");
            sc.nextLine();
            String lvenName = sc.nextLine();
            System.out.println("Enter the vendorEmail");
            //sc.nextLine();
            String lvenEmail = sc.nextLine();
            System.out.println("Enter the vendorMobNo");
            //sc.nextLine();
            String lvenMobNo = sc.nextLine(); 
            venFactory.insertVendor(lvenId, lvenName, lvenMobNo, lvenEmail);
    }
    public void updateVendor(){
        System.out.println("Enter the Vendor to update");
        int argItemId = sc.nextInt();
        System.out.println("Enter the vendor name to update");
        sc.nextLine();
        String argItemPrice = sc.nextLine();
        Vendor item = venFactory.updateVendor(argItemId,argItemPrice);
        if(item !=null){
            System.out.println("Vendor "+item+"vendor updated");
        }else{
            System.out.println("No Such vendor found");
        }
    }

    public void  deleteVendor(){
        System.out.println("Enter the vendorId to delete");
        int argItemId = sc.nextInt();
        Vendor item = venFactory.deleteVendor(argItemId);
        if(item !=null){
            System.out.println("Vendor "+item+"vendor deleted");
        }else{
            System.out.println("No Such vendor found");
        }
    }

    public void showVendorById(){
        System.out.println("Enter the vendorid to display");
        int argItemId = sc.nextInt();
        Vendor item = venFactory.showVendorById(argItemId);
        System.out.println(item.getVenId()+"\t"+item.getVenName()
                        +"\t"+item.getVenEmail()+"\t"+item.getVenMobNo());
        
    }

    ItemFactory itmFactory = new ItemFactory();
    public void readItemDetails(){
        System.out.println("Enter the Item details to add for Menu........");
        System.out.println("Enter the itemId");
        int litmId=sc.nextInt();
        System.out.println("Enter the ItemName");
        sc.nextLine();
        String litmName = sc.nextLine();
        System.out.println("Enter the ItemPrice");
        float litmPrice = sc.nextFloat();
        System.out.println("Enter the ItemQty");
        int litmQty = sc.nextInt();
        System.out.println("Enter the ItemType");
        sc.nextLine();
        String litmType = sc.nextLine();
        itmFactory.insertItem(litmId,litmName, litmPrice, litmQty, litmType);
    }

    
    public void showItemList(){
        itemList = itmFactory.showItemList();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("List of Items.........................................");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("ItemName \t ItemPrice \t ItemQty \t ItemType");
        for(int i =0;i<itemList.size();i++){
        System.out.println(itemList.get(i).getItemId()+"\t"+itemList.get(i).getItemName()+"\t"+itemList.get(i).getItemPrice()
                        +"\t"+itemList.get(i).getItemQty()+"\t"+itemList.get(i).getItemType());
        }
    }


    public void updateItem(){
        System.out.println("Enter the ItemId to update");
        int argItemId = sc.nextInt();
        System.out.println("Enter the ItemPrice to update");
        float argItemPrice = sc.nextFloat();
        Item item = itmFactory.updateItem(argItemId,argItemPrice);
        if(item !=null){
            System.out.println("Item "+item+"item updated");
        }else{
            System.out.println("No Such Item found");
        }
    }

    public void  deleteItem(){
        System.out.println("Enter the ItemId to delete");
        int argItemId = sc.nextInt();
        Item item = itmFactory.deleteItem(argItemId);
        if(item !=null){
            System.out.println("Item "+item+"item deleted");
        }else{
            System.out.println("No Such Item found");
        }
    }

    public void showItemById(){
        System.out.println("Enter the ItemId to delete");
        int argItemId = sc.nextInt();
        Item item = itmFactory.showItemById(argItemId);
        System.out.println(item.getItemName()+"\t"+item.getItemPrice()
                        +"\t"+item.getItemQty()+"\t"+item.getItemType());
        
    }
OrderFactory ordFactory = new OrderFactory();
public void readOrderDetails(){
    System.out.println("Enter the order details to add for Menu........");
    System.out.println("Enter the OrderId");
    int litmId=sc.nextInt();
    System.out.println("Enter the vendorid");
    int venid=sc.nextInt();
    System.out.println("Enter the customerid");
    int cusid=sc.nextInt();
    System.out.println("Enter the food id");
    int foodid=sc.nextInt();
    System.out.println("Enter the itemQty");
    int qty=sc.nextInt();
    System.out.println("Enter the OrderStatus");
    sc.nextLine();
    String litmType = sc.nextLine();
    System.out.println("Enter the price");
    float litmPrice = sc.nextFloat();
    System.out.println("Enter the date");
    sc.nextLine();
    String date=sc.nextLine();
    
   
    ordFactory.insertOrder(litmId,venid,cusid,foodid,qty,litmType,litmPrice,date);
}


public void showOrderList(){
     ordlist= ordFactory.showOrderList();
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("List of Orders.........................................");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("OrderId \t VendorId \t CustomerId \t FoodId \t itemQty \t orderStatus \t orderPrice \t orderdate");
    for(int i =0;i<ordlist.size();i++){
    System.out.println(ordlist.get(i).getOrderId()+"\t"+ordlist.get(i).getVendorId()+"\t"+ordlist.get(i).getCustomerId()
                    +"\t"+ordlist.get(i).getFoodId()+"\t"+ordlist.get(i).getItemQty()+"\t"+ordlist.get(i).getOrderStatus()+"\t"+ ordlist.get(i).getOrderPrice()+ "\t"+ordlist.get(i).getOrdDate());
    }
}


public void updateOrder(){
    System.out.println("Enter the orderid to update");
    int argItemId = sc.nextInt();
    System.out.println("Enter the orderPrice to update");
    float argItemPrice = sc.nextFloat();
    Order order = ordFactory.updateOrder(argItemId,argItemPrice);
    if(order !=null){
        System.out.println("Order "+order+"order updated");
    }else{
        System.out.println("No Such Item found");
    }
}

public void  deleteOrder(){
    System.out.println("Enter the OrderId to delete");
    int argItemId = sc.nextInt();
    Order order = ordFactory.deleteOrder(argItemId);
    if(order !=null){
        System.out.println("order "+order+"item deleted");
    }else{
        System.out.println("No Such Item found");
    }
}

public void showOrderById(){
    System.out.println("Enter the  order id");
    int argItemId = sc.nextInt();
    Object order = ordFactory.showOrderById(argItemId);
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("OrderId \t VendorId \t orderStatus \t CustomerId \t orderPrice");
    System.out.println(((Order) order).getOrderId()+"\t"+((Order) order).getVendorId()
                    +"\t"+(((Order) order).getOrderStatus())+"\t"+((Order) order).getCustomerId()+"\t"+((Order) order).getOrderPrice());
    
}
CustomerFactory cusFactory = new CustomerFactory();
public void readCustomerDetails(){
    System.out.println("Enter the customer details to add for Menu........");
    System.out.println("Enter the customerId");
    int litmId=sc.nextInt();
    System.out.println("Enter the customerName");
    sc.nextLine();
    String venid=sc.nextLine();
    System.out.println("Enter the customerEmail");
    String cusid=sc.nextLine();
    System.out.println("Enter the contact no");
    String mobid=sc.nextLine();
    System.out.println("Enter the coupon");
    String qty=sc.nextLine();
    System.out.println("Enter the wallet bill");
    float litmType = sc.nextFloat();
    
   
    cusFactory.insertCustomer(litmId,venid,cusid,mobid,qty,litmType);
}


public void showCustomerList(){
     cusList= cusFactory.showCustomerList();
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("List of Orders.........................................");
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("cusId \t cusName \t CustomerMob \t cusCoupon \t CusEmail \t cusWallet");
    for(int i =0;i<cusList.size();i++){
    System.out.println(cusList.get(i).getCusId()+"\t"+cusList.get(i).getCusName()+"\t"+cusList.get(i).getCusEmail()
                    +"\t"+cusList.get(i).getCusCoupon()+"\t"+cusList.get(i).getCusMobNo()+"\t"+cusList.get(i).getWalletBill());
    }
}


public void updateCustomer(){
    System.out.println("Enter the customerid to update");
    int argItemId = sc.nextInt();
    System.out.println("Enter the wallet to update");
    float argItemPrice = sc.nextFloat();
    Customer cus = cusFactory.updateCustomer(argItemId,argItemPrice);
    if(cus !=null){
        System.out.println("customer "+cus+"customer updated");
    }else{
        System.out.println("No Such customer found");
    }
}

public void  deleteCustomer(){
    System.out.println("Enter the customerId to delete");
    int argItemId = sc.nextInt();
    Customer cus = cusFactory.deletecCustomer(argItemId);
    if(cus !=null){
        System.out.println("order "+cus+"item deleted");
    }else{
        System.out.println("No Such customer found");
    }
}

public void showCustomerById(){
    System.out.println("Enter the CustomerId");
    int argItemId = sc.nextInt();
    Object customer = cusFactory.showCustomerById(argItemId);
    System.out.println(((Customer) customer).getCusId()+"\t"+((Customer) customer).getCusName()
                    +"\t"+((Customer) customer).getCusMobNo()+"\t"+(((Customer) customer).getWalletBill()));
    
}
PlaceOrderFactory oFactory = new PlaceOrderFactory();
public void readPlaceOrderDetails(){
    
    System.out.println("Enter the cusName");
    sc.nextLine();
    String litmName = sc.nextLine();
    System.out.println("Enter the foodname");
    String litmPrice = sc.nextLine();
    System.out.println("Enter the ItemQty");
    int litmQty = sc.nextInt();
    System.out.println("Do you Want to place order");
    sc.nextLine();
    String liType = sc.nextLine();
    oFactory.insertOrder(litmName, litmPrice, litmQty, liType);
}


public void showPlaceOrderList(){
    polist = oFactory.showOrderList();
    
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("cusName \t foodName \t ItemQty \t PlacingOrder");
    for(int i =0;i<polist.size();i++){
    System.out.println(polist.get(i).getCusName()+"\t"+polist.get(i).getFoodName()+"\t"+polist.get(i).getFoodQty()+"\t"+polist.get(i).getPlaceOrder());
    }
}




}




