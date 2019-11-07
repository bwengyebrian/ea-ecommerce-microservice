package edu.mum.stockservice.model;

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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Category_Name")
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();

    public void setProducts(Product product){
        products.add(product);
    }
}
