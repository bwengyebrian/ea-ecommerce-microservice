package edu.mum.accountservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    private String email;

    private String username;

    private String password;
    @OneToOne
    private Address address;


}
