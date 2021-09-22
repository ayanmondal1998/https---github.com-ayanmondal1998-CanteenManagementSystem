package com.hexaware.jdbccrudexample.Model;

import java.util.Date;

public class Order{
    private int OrderId;
    private int VendorId;
    private int CustomerId;
    private int FoodId;
    private int ItemQty;
    private String OrderStatus;
    private float OrderPrice;
    private String ordDate;
    public Order() {
    }
   
    public Order(int orderId, int vendorId, int customerId, int foodId, int itemQty, String orderStatus,
            float orderPrice, String ordDate) {
        OrderId = orderId;
        VendorId = vendorId;
        CustomerId = customerId;
        FoodId = foodId;
        ItemQty = itemQty;
        OrderStatus = orderStatus;
        OrderPrice = orderPrice;
        this.ordDate = ordDate;
    }
    public String getOrdDate() {
        return ordDate;
    }
    public void setOrdDate(String ordDate) {
        this.ordDate = ordDate;
    }
    public int getOrderId() {
        return OrderId;
    }
    public void setOrderId(int orderId) {
        OrderId = orderId;
    }
    public int getVendorId() {
        return VendorId;
    }
    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }
    public int getCustomerId() {
        return CustomerId;
    }
    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }
    public int getFoodId() {
        return FoodId;
    }
    public void setFoodId(int foodId) {
        FoodId = foodId;
    }
    public int getItemQty() {
        return ItemQty;
    }
    public void setItemQty(int itemQty) {
        ItemQty = itemQty;
    }
    public String getOrderStatus() {
        return OrderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }
    public float getOrderPrice() {
        return OrderPrice;
    }
    public void setOrderPrice(float orderPrice) {
        OrderPrice = orderPrice;
    }
    @Override
    public String toString() {
        return "Order [CustomerId=" + CustomerId + ", FoodId=" + FoodId + ", ItemQty=" + ItemQty + ", OrderId="
                + OrderId + ", OrderPrice=" + OrderPrice + ", OrderStatus=" + OrderStatus + ", VendorId=" + VendorId
                + ", ordDate=" + ordDate + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + CustomerId;
        result = prime * result + FoodId;
        result = prime * result + ItemQty;
        result = prime * result + OrderId;
        result = prime * result + Float.floatToIntBits(OrderPrice);
        result = prime * result + ((OrderStatus == null) ? 0 : OrderStatus.hashCode());
        result = prime * result + VendorId;
        result = prime * result + ((ordDate == null) ? 0 : ordDate.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (CustomerId != other.CustomerId)
            return false;
        if (FoodId != other.FoodId)
            return false;
        if (ItemQty != other.ItemQty)
            return false;
        if (OrderId != other.OrderId)
            return false;
        if (Float.floatToIntBits(OrderPrice) != Float.floatToIntBits(other.OrderPrice))
            return false;
        if (OrderStatus == null) {
            if (other.OrderStatus != null)
                return false;
        } else if (!OrderStatus.equals(other.OrderStatus))
            return false;
        if (VendorId != other.VendorId)
            return false;
        if (ordDate == null) {
            if (other.ordDate != null)
                return false;
        } else if (!ordDate.equals(other.ordDate))
            return false;
        return true;
    }
    

}
    
    