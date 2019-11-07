package edu.mum.orderservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Total_Amount")
    private double totalAmount;
    private boolean orderComplete = false;

    @OneToMany
    private List<Product> products = new ArrayList<>();
    @OneToOne
    private User user;


    public void setProducts(Product product){
        products.add(product);
    }
}
