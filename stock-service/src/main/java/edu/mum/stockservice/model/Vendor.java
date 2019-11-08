package edu.mum.stockservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Category_Name")
    private String vendorName;
    @OneToMany(mappedBy = "vendor", fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

   public void setProductList(Product product){
        getProducts().add(product);
    }
}
