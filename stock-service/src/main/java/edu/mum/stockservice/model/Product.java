package edu.mum.stockservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id;
    @Column(name = "Product_Name")
    private String productName;
    private double price;
    @Column(name = "Available_Items")
    private int availableItems;
    //@ManyToOne
    @OneToOne
    private Vendor vendor;
    //@ManyToOne
    @OneToOne
    private Category category;

    public Product() {
    }

    public Product(String productName, double price, int availableItems, Vendor vendor, Category category) {
        this.productName = productName;
        this.price = price;
        this.availableItems = availableItems;
        this.vendor = vendor;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(int availableItems) {
        this.availableItems = availableItems;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", availableItems=" + availableItems +
                '}';
    }
}
