package com.hexaware.jdbccrudexample.Model;

public class Vendor{

    private int venId;
    private String venName;
    private String venEmail;
    private String venMobNo;
    public Vendor() {
    }
    public Vendor(int venId, String venName, String venEmail, String venMobNo) {
        this.venId = venId;
        this.venName = venName;
        this.venEmail = venEmail;
        this.venMobNo = venMobNo;
    }
    public int getVenId() {
        return venId;
    }
    public void setVenId(int venId) {
        this.venId = venId;
    }
    public String getVenName() {
        return venName;
    }
    public void setVenName(String venName) {
        this.venName = venName;
    }
    public String getVenEmail() {
        return venEmail;
    }
    public void setVenEmail(String venEmail) {
        this.venEmail = venEmail;
    }
    public String getVenMobNo() {
        return venMobNo;
    }
    public void setVenMobNo(String venMobNo) {
        this.venMobNo = venMobNo;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((venEmail == null) ? 0 : venEmail.hashCode());
        result = prime * result + venId;
        result = prime * result + ((venMobNo == null) ? 0 : venMobNo.hashCode());
        result = prime * result + ((venName == null) ? 0 : venName.hashCode());
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
        Vendor other = (Vendor) obj;
        if (venEmail == null) {
            if (other.venEmail != null)
                return false;
        } else if (!venEmail.equals(other.venEmail))
            return false;
        if (venId != other.venId)
            return false;
        if (venMobNo == null) {
            if (other.venMobNo != null)
                return false;
        } else if (!venMobNo.equals(other.venMobNo))
            return false;
        if (venName == null) {
            if (other.venName != null)
                return false;
        } else if (!venName.equals(other.venName))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Vendor [venEmail=" + venEmail + ", venId=" + venId + ", venMobNo=" + venMobNo + ", venName=" + venName
                + "]";
    }
    
    

}