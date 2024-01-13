package br.com.realestate.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    @Id
    private ObjectId id;
    
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;
}
