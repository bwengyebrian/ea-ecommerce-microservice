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
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Category_Name")
    private String vendorName;
    @OneToMany(mappedBy = "vendor")
    private List<Product> productList = new ArrayList<>();

   public void setProductList(Product product){
        productList.add(product);
    }
}
