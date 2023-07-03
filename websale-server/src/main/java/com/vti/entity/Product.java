package com.vti.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;
    @Column(name = "description", length = 1023, nullable = false)
    private String description;
    @Column(name = "thumbnail_url", nullable = false)
    private String thumbnailUrl;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "sold_quantity", nullable = false)
    private Double soldQuantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "sale_price", nullable = false)
    private Double salePrice;

    @Column(name = "status",length = 10)
    @ColumnDefault("TRUE")
    private Boolean status;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Cart> carts;
}
