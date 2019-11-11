package edu.mum.shippingservice.model;

import edu.mum.shippingservice.model.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "ordertb")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Total_Amount")

    private double totalAmount;
    private boolean orderComplete = false;
    @Column(name = "Payment_Type")
    private String paymentType;

    @OneToMany(mappedBy = "order")
    private List<Product> products = new ArrayList<>();

    private long userid;


    public void setProducts(Product product){
        products.add(product);
    }
}
