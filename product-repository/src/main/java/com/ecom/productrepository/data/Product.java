package com.ecom.productrepository.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    private UUID id;
    private String name;

    public Product() {

    }

}
