package com.geopagos.rest_api.shapes.entity;

import com.geopagos.rest_api.shapes.ShapeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TRIANGLE")
public class Triangle extends BaseShape {

    private final Double base;
    private final Double height;

    // For serialization / deserialization only
    protected Triangle() {
        this.base = null;
        this.height = null;
    }

    public Triangle(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public Double getBase() {
        return this.base;
    }

    @Override
    public Double getHeight() {
        return this.height;
    }

    @Override
    public Double getDiameter() {
        return null;
    }

    @Override
    public Double getSurface() {
        return this.base * this.height / 2;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.TRIANGLE;
    }

}
