package edu.isgb.school.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "t_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_ADDRESS")
    private Integer idAddress;

    @Column(name = "cl_street")
    private String street;

    @Column(name = "cl_city")
    private String city;

    @Column(name = "cl_postal_Code")
    private String postalCode;



    public Address() {}
    public Address(String street, String city, String postalCode) {
        this.street = street; this.city = city; this.postalCode = postalCode;
    }

    public Integer getIdAddress() { return idAddress; }
    public void setIdAddress(Integer id) { this.idAddress = id; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String p) { this.postalCode = p; }
}