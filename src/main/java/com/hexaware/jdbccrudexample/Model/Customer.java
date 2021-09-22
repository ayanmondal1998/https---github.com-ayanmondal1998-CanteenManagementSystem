package com.hexaware.jdbccrudexample.Model;

public class Customer {
    private int cusId;
    private String cusName;
    private String cusEmail;
    private String cusMobNo;
    private String cusCoupon;
    private float walletBill;
    public Customer() {
    }
    public Customer(int cusId, String cusName, String cusEmail, String cusMobNo, String cusCoupon, float walletBill) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusEmail = cusEmail;
        this.cusMobNo = cusMobNo;
        this.cusCoupon = cusCoupon;
        this.walletBill = walletBill;
    }
    public int getCusId() {
        return cusId;
    }
    public void setCusId(int cusId) {
        this.cusId = cusId;
    }
    public String getCusName() {
        return cusName;
    }
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
    public String getCusEmail() {
        return cusEmail;
    }
    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }
    public String getCusMobNo() {
        return cusMobNo;
    }
    public void setCusMobNo(String cusMobNo) {
        this.cusMobNo = cusMobNo;
    }
    public String getCusCoupon() {
        return cusCoupon;
    }
    public void setCusCoupon(String cusCoupon) {
        this.cusCoupon = cusCoupon;
    }
    public float getWalletBill() {
        return walletBill;
    }
    public void setWalletBill(float walletBill) {
        this.walletBill = walletBill;
    }
    @Override
    public String toString() {
        return "Customer [cusCoupon=" + cusCoupon + ", cusEmail=" + cusEmail + ", cusId=" + cusId + ", cusMobNo="
                + cusMobNo + ", cusName=" + cusName + ", walletBill=" + walletBill + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cusCoupon == null) ? 0 : cusCoupon.hashCode());
        result = prime * result + ((cusEmail == null) ? 0 : cusEmail.hashCode());
        result = prime * result + cusId;
        result = prime * result + ((cusMobNo == null) ? 0 : cusMobNo.hashCode());
        result = prime * result + ((cusName == null) ? 0 : cusName.hashCode());
        result = prime * result + Float.floatToIntBits(walletBill);
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
        Customer other = (Customer) obj;
        if (cusCoupon == null) {
            if (other.cusCoupon != null)
                return false;
        } else if (!cusCoupon.equals(other.cusCoupon))
            return false;
        if (cusEmail == null) {
            if (other.cusEmail != null)
                return false;
        } else if (!cusEmail.equals(other.cusEmail))
            return false;
        if (cusId != other.cusId)
            return false;
        if (cusMobNo == null) {
            if (other.cusMobNo != null)
                return false;
        } else if (!cusMobNo.equals(other.cusMobNo))
            return false;
        if (cusName == null) {
            if (other.cusName != null)
                return false;
        } else if (!cusName.equals(other.cusName))
            return false;
        if (Float.floatToIntBits(walletBill) != Float.floatToIntBits(other.walletBill))
            return false;
        return true;
    }
    
    
    
}
