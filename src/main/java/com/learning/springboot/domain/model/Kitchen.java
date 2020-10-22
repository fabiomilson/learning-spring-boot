package com.learning.springboot.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = Kitchen.TABLE_NAME_KITCHEN)
public class Kitchen extends AbstractEntity {

    public static final String TABLE_NAME_KITCHEN = "KITCHEN";

    @Id
    @Getter
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private int id;

    @Column(name = COLUMN_NAME, nullable = false)
    private String name;

    public Kitchen(String name) {
        super();
        this.name = name;
    }

    public static Kitchen ofName(String name){
        return new Kitchen(name);
    }

}
