package edu.mum.orderservice.model;

import lombok.Data;

import javax.persistence.*;

//@Entity
@Data
public class Account {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @Column(name = "First_Name")
    private String firstName;
//    @Column(name = "Last_Name")
    private String lastName;
    private String email;
//    @OneToOne
    private Address address;


}
