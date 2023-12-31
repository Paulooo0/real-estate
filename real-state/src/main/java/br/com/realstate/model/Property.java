package br.com.realstate.model;

import java.time.Instant;

import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "properties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {
    @Id
    private ObjectId id;

    private Long CEP;
    
    private Integer address_number;
    
    private String category;

    private String description;

    private Decimal128 price;

    private Integer area;

    private Integer bathrooms;

    private Integer bedrooms;

    private Integer cars_quantity;

    private Instant created_at;
}     
