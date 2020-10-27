package com.learning.springboot.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = State.TABLE_NAME_STATE)
public class State extends AbstractEntity {

    public static final String TABLE_NAME_STATE = "STATE";

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = COLUMN_ID, nullable = false)
    private int id;

    @Getter
    private String name;
}
