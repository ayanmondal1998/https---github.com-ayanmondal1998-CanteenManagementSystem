package com.hexaware.jdbccrudexample.Factory;




import java.util.List;

import com.hexaware.jdbccrudexample.Model.Vendor;

import com.hexaware.jdbccrudexample.Persistence.VendorDAO;

public class VendorFactory {

  
    public VendorDAO venDAO = new VendorDAO();



    /**
     * @param venId    to initialize vendor id
     * @param venEmail to initialize vendor Email.
     * @param venName  to initialize vendor username.
     * @param venPhone to initialize vendor Phone.
     * @return Vendor
     */
    public Vendor insertVendor(int venId,String venName,String venPhone,String VenEmail){
        Vendor v = new Vendor();
        venDAO.insertVendor(venId,venName,venPhone,VenEmail);
        return v;
    }


    public List<Vendor> showVendorList() {
        return venDAO.showVendorList();
    }

    public Vendor updateVendor(int venId,String venName){
        return venDAO.updateVendor(venId,venName);
    }

    public Vendor deleteVendor(int venId){
        return venDAO.deleteVendor(venId);
    }
    public Vendor showVendorById(int venId){
        return venDAO.showVendorById(venId);
    }

}
