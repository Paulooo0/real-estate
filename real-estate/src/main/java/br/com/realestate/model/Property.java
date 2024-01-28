package br.com.realestate.model;

import java.time.Instant;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.realestate.errors.InvalidValueException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The `Property` class represents a property with various attributes such as ID, address, category,
 * description, price, area, bathrooms, bedrooms, and more.
 */

@Document(collection = "properties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    private ObjectId id;

    private Long propertyId;

    private String cep;

    private String street;

    private Integer addressNumber;

    private String category;

    private String description;

    private List<String> characteristics;

    private Double price;

    private Integer area;

    private Integer bathrooms;

    private Integer bedrooms;

    private Integer carsQuantity;
    
    private List<String> images;

    private Instant createdAt = Instant.now();

    public void setCep(String cep) throws InvalidValueException {
        if (cep != null && cep.length() == 8) {
            this.cep = cep;
        } else {
            throw new InvalidValueException("Cep", cep);
        }
    }

    public void setAddressNumber(Integer addressNumber) throws InvalidValueException {
        if (addressNumber != null && addressNumber > 0) {
            this.addressNumber = addressNumber;
        } else {
            throw new InvalidValueException("Address number", addressNumber);
        }
    }

    public void setPrice(Double price) throws InvalidValueException {
        if (price != null && price > 0d) {
            this.price = price;
        } else {
            throw new InvalidValueException("Price", price);
        }
    }

    public void setArea(Integer area) throws InvalidValueException {
        if (area != null && area > 0) {
            this.area = area;
        } else {
            throw new InvalidValueException("Area", area);
        }
    }

    public void setBathrooms(Integer bathrooms) throws InvalidValueException {
        if (bathrooms != null) {
            this.bathrooms = bathrooms;
        } else {
            throw new InvalidValueException("Bathrooms", bathrooms);
        }
    }
}
