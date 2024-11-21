package cris.PawPetCare.microservicios.customers;

import java.util.List;

import cris.PawPetCare.microservicios.pets.Pet;

public class Customer {
    long id;
    long document;
    String firstName;
    String lastName;
    String gender;
    String email;
    String password;
    String address;
    long phoneNumber;
    List<Pet> pets;

    

    public Customer() {
    }


    public Customer(long document, String firstName, String lastName, String gender, String email, String password,
            String address, long phoneNumber) {
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    


    public Customer(long document, String firstName, String lastName, String gender, String email, String address,
            long phoneNumber) {
        this.document = document;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public Customer(long id, List<Pet> pets) {
        this.id = id;
        this.pets = pets;
    }


    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public List<Pet> getPets() {
        return pets;
    }
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }


    public long getDocument() {
        return document;
    }


    public void setDocument(long document) {
        this.document = document;
    }


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    
}
