package dev.alperdonmez.javaCrudOperations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Users")
@Data
public class User {

    @Id
    int id;
    //@Id
    String username;

    String password;
    String firstName;
    String lastName;
}
