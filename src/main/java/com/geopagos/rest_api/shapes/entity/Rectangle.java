package com.geopagos.rest_api.shapes.entity;

import com.geopagos.rest_api.shapes.Shape;
import com.geopagos.rest_api.shapes.ShapeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RECTANGLE")
public class Rectangle extends BaseShape implements Shape {

    private final Double base;
    private final Double height;

    // For serialization / deserialization only
    protected Rectangle() {
        this.base = null;
        this.height = null;
    }

    public Rectangle(Double base, Double height) {
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
        return this.base * this.height;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }

}
