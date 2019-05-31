package com.ecom.productcatalog.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Table(name = "products")
public class Product {

    @Id
    private String id;
    private String name;

    public Product() {

    }
}
