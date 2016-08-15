package domain;

import javax.persistence.*;

/**
 * Created by Mars on 12.08.2016.
 */
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;


    private String region;
    private String prefixCity;
    private String city;
    private String prefixStreet;
    private String street;
    private String house;
    private String apartment;
}
