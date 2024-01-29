package br.com.realestate.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.realestate.errors.InvalidValueException;
import br.com.realestate.errors.WeakPasswordException;
import br.com.realestate.utils.CheckContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Admin class represents an administrator with properties such as first name, last name, email,
 * password, and phone number, and includes validation methods for each property.
 */

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

    public void setFirstName(String firstName) throws InvalidValueException {
        if (firstName.length() < 2
        || firstName == null
        || !firstName.matches("[a-zA-Z]+")) {
            throw new InvalidValueException("first name", firstName);
        }
        this.firstName = firstName;
    }
    
        public void setLastName(String lastName) throws InvalidValueException {
            if (lastName.length() < 2
            || lastName == null
            || !lastName.matches("[a-zA-Z]+")) {
                throw new InvalidValueException("last name", lastName);
            }
            this.lastName = lastName;
        }
    
    
    public void setEmail(String email) throws InvalidValueException {
        if (email == null
        || !email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            throw new InvalidValueException("email", email);
        }
        this.email = email;
    }
    
    public void setPassword(String password) throws WeakPasswordException {
        CheckContent check = new CheckContent();

        if (password == null
        || password.length() < 8
        || !check.containsNumber(password)
        || !check.containsLetter(password)
        || !check.containsSpecialCharacter(password)
        || check.containsSpaces(password)) {
            throw new WeakPasswordException();
        }
        this.password = password;
    }

    public void setPhone(String phone) throws InvalidValueException {
        if (phone == null
        || !phone.matches("^[0-9]{10,11}$")) {
            throw new InvalidValueException("phone", phone);
        }
        this.phone = phone;
    }
}
