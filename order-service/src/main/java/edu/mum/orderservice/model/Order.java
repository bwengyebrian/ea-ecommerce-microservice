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
@Table(name = "ordertable")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Total_Amount")

    private double totalAmount;
    private boolean orderComplete = false;

    @OneToMany(mappedBy = "order")
    private List<Product> products = new ArrayList<>();

    private long userid;


    public void setProducts(Product product){
        products.add(product);
    }
}
