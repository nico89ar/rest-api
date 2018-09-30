package com.geopagos.rest_api.shapes;

public interface Shape {

    Double getBase();

    Double getHeight();

    Double getDiameter();

    Double getSurface();

    ShapeType getShapeType();
}
