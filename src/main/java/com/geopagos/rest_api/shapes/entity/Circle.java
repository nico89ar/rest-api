package com.geopagos.rest_api.shapes.entity;

import com.geopagos.rest_api.shapes.Shape;
import com.geopagos.rest_api.shapes.ShapeType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CIRCLE")
public class Circle extends BaseShape implements Shape {

    private final Double diameter;

    // For serialization / deserialization only
    protected Circle() { this.diameter = null;}

    public Circle(Double base) {
        this.diameter = base;
    }

    @Override
    public Double getBase() {
        return null;
    }

    @Override
    public Double getHeight() {
        return null;
    }

    @Override
    public Double getDiameter() {
        return this.diameter;
    }

    @Override
    public Double getSurface() {
        Double radius = this.diameter / 2;
        return Math.PI * Math.pow(radius, 2);
    }


    @Override
    public ShapeType getShapeType() {
        return ShapeType.CIRCLE;
    }
}
