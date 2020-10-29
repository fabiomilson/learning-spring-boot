package com.learning.springboot.domain.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = Kitchen.TABLE_NAME_KITCHEN)
//@JsonRootName("kitchen")
public class Kitchen extends AbstractEntity {

    public static final String TABLE_NAME_KITCHEN = "KITCHEN";

    @Id
    @Getter
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = COLUMN_ID)
    private int id;

    @Getter
    @Column(name = COLUMN_NAME, nullable = false, unique = true)
    //@JsonIgnore
    //@JsonProperty("title")
    @Setter
    private String name;

    public Kitchen(String name) {
        super();
        this.name = name;
    }

    public static Kitchen ofName(String name){
        return new Kitchen(name);
    }

}
