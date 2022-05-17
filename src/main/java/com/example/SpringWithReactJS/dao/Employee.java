package com.example.SpringWithReactJS.dao;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1

    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    @Enumerated(EnumType.STRING)
    private Department department;

    public Employee(String firstName, String lastName, String mail, String password, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.department = department;
    }

    public boolean equals(int id) {
        return id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
