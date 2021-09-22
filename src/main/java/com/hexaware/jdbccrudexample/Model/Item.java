package com.hexaware.jdbccrudexample.Model;

public class Item {
    
    private int itemId;
    private String itemName;
    private float itemPrice;
    private int itemQty;
    private String itemType;

    public Item() {
    }

   

    public Item(int itemId, String itemName, float itemPrice, int itemQty, String itemType) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQty = itemQty;
        this.itemType = itemType;
    }

    /**
     * @return int return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return String return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return float return the itemPrice
     */
    public float getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * @return int return the itemQty
     */
    public int getItemQty() {
        return itemQty;
    }

    /**
     * @param itemQty the itemQty to set
     */
    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    /**
     * @return String return the itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * @param itemType the itemType to set
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemQty=" + itemQty
                + ", itemType=" + itemType + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + itemId;
        result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
        result = prime * result + Float.floatToIntBits(itemPrice);
        result = prime * result + itemQty;
        result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
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
        Item other = (Item) obj;
        if (itemId != other.itemId)
            return false;
        if (itemName == null) {
            if (other.itemName != null)
                return false;
        } else if (!itemName.equals(other.itemName))
            return false;
        if (Float.floatToIntBits(itemPrice) != Float.floatToIntBits(other.itemPrice))
            return false;
        if (itemQty != other.itemQty)
            return false;
        if (itemType == null) {
            if (other.itemType != null)
                return false;
        } else if (!itemType.equals(other.itemType))
            return false;
        return true;
    }


    
    

}
