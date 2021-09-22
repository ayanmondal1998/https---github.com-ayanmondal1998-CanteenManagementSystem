package com.hexaware.jdbccrudexample.Model;

public class PlaceOrder {
    private String cusName;
    private String foodName;
    private int foodQty;
    private String placeOrder;
    public String getCusName() {
        return cusName;
    }
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public int getFoodQty() {
        return foodQty;
    }
    public void setFoodQty(int foodQty) {
        this.foodQty = foodQty;
    }
    public String getPlaceOrder() {
        return placeOrder;
    }
    public PlaceOrder(String cusName, String foodName, int foodQty, String placeOrder) {
        this.cusName = cusName;
        this.foodName = foodName;
        this.foodQty = foodQty;
        this.placeOrder = placeOrder;
    }
    public void setPlaceOrder(String placeOrder) {
        this.placeOrder = placeOrder;
    }
    public PlaceOrder() {
    }
    @Override
    public String toString() {
        return "PlaceOrder [cusName=" + cusName + ", foodName=" + foodName + ", foodQty=" + foodQty + ", placeOrder="
                + placeOrder + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
       
        result = prime * result + ((foodName == null) ? 0 : foodName.hashCode());
        result = prime * result + foodQty;
        result = prime * result + ((placeOrder == null) ? 0 : placeOrder.hashCode());
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
        PlaceOrder other = (PlaceOrder) obj;
        if (cusName != other.cusName)
            return false;
        if (foodName == null) {
            if (other.foodName != null)
                return false;
        } else if (!foodName.equals(other.foodName))
            return false;
        if (foodQty != other.foodQty)
            return false;
        if (placeOrder == null) {
            if (other.placeOrder != null)
                return false;
        } else if (!placeOrder.equals(other.placeOrder))
            return false;
        return true;
    }
    
    
}

    