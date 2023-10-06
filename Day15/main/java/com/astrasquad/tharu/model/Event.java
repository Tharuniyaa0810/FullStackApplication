package com.astrasquad.tharu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.List;

import com.astrasquad.tharu.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cash")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;
    private String name;
    private Integer transaction;
    private String address;
    @Lob
    private String description;

    private List<String> images;

    @ManyToOne
    private User organizer;
    
    public Integer getOrganizerOrgID() {
        if (organizer != null) {
            return organizer.getOrgID();
        }
        return null; // Return null or handle as needed if the organizer is not set
    }

}
