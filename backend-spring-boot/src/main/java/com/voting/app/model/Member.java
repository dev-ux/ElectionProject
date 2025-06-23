package com.voting.app.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private LocalDate birthDate;
    
    @Column(nullable = false)
    private boolean hasVoted = false;

    // Constructors
    public Member() {}
    
    public Member(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    // Getters
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthDate() { return birthDate; }
    public boolean isHasVoted() { return hasVoted; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setHasVoted(boolean hasVoted) { this.hasVoted = hasVoted; }
}
