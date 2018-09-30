package com.geopagos.rest_api.shapes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

    @Entity
    @Inheritance(strategy= InheritanceType.SINGLE_TABLE)
    @DiscriminatorColumn(name="TYPE", discriminatorType= DiscriminatorType.STRING)
    @Table(name="SHAPE")
    public abstract class BaseShape {

        @Id
        @GeneratedValue
        private Long id;

        @JsonIgnore
        public Long getId() {
            return this.id;
        }
    }
