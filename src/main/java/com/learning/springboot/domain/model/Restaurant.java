package com.learning.springboot.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private int id;

    @Column(name = COLUMN_NAME, nullable = false)
    private String name;

    @Column(name = COLUMN_SHIPPING_FEE, nullable = false)
    private BigDecimal shippingFee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_kitchen", nullable = false)
    private Kitchen kitchen;
}
