package edu.mum.stockservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Category_Name")
    private String vendorName;
    //@OneToMany(mappedBy = "vendor")
    @Transient
    private List<Product> productList = new ArrayList<>();

   public void setProductList(Product product){
        productList.add(product);
    }

    public Vendor() {
    }

    public Vendor(String vendorName, List<Product> productList) {
        this.vendorName = vendorName;
        this.productList = productList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", vendorName='" + vendorName + '\'' +
                '}';
    }
}
