/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.cbp.air.model;

/**
 *
 * @author chrismoran
 */
public class Entity  {
    private String name;
    private Address address;

    public Entity(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Entity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
