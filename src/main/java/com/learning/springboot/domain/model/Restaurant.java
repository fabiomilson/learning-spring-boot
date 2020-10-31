package com.learning.springboot.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Table(name = Restaurant.TABLE_NAME_RESTAURANT)
public class Restaurant extends AbstractEntity {

    public static final String TABLE_NAME_RESTAURANT = "RESTAURANT";
    public static final String COLUMN_SHIPPING_FEE = "SHIPPING_FEE";
    public static final String COLUMN_ID_KITCHEN = "ID_KITCHEN";

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    @Getter
    private int id;

    @Getter
    @Setter
    @Column(name = COLUMN_NAME, nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = COLUMN_SHIPPING_FEE, nullable = false)
    private BigDecimal shippingFee;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kitchen", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Kitchen kitchen;
}
