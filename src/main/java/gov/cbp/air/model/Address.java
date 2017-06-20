/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 *
 * @author chrismoran
 */
public class Address implements Serializable
{
    private String street;
    private String district;
    private String city;
    private String state;
    private String postcode;
    private String countryCode;

    public Address() {
    }

    public Address(String street, String district, String city, String state, String postcode, String countryCode) {
        this.street = street;
        this.district = district;
        this.city = city;
        this.postcode = postcode;
        this.state = state;
        this.countryCode = countryCode;
    }
    

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnore
    public String getFulladdress ()
    {
        return this.street + " " + this.district + " " + this.city + " " + this.postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postcode='" + postcode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
