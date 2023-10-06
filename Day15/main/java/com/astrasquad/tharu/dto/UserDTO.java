package com.astrasquad.tharu.dto;

public class UserDTO {
    private Integer orgID;
    private String name;
    private Integer transaction;
    // Other relevant fields

    // Constructors, getters, setters, etc.

    // Default constructor
    public UserDTO() {
    }

    // Parameterized constructor
    public UserDTO(Integer orgID, String name, String type) {
        this.orgID = orgID;
        this.name = name;
        this.transaction = transaction;
        // Initialize other fields as needed
    }

    // Getters and setters
    public Integer getOrgID() {
        return orgID;
    }

    public void setOrgID(Integer orgID) {
        this.orgID = orgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTransaction() {
        return transaction;
    }

    public void setTransaction(Integer transaction) {
        this.transaction = transaction;
    }

    // Add getters and setters for other relevant fields
}

