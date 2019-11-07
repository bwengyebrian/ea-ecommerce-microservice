package edu.mum.stockservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    @ManyToOne
    private Vendor vendor;
    @ManyToOne
    private Category category;


}
