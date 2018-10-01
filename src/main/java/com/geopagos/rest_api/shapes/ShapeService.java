package com.geopagos.rest_api.shapes;

import com.geopagos.rest_api.shapes.db.ShapeRepository;
import com.geopagos.rest_api.shapes.entity.BaseShape;
import com.geopagos.rest_api.shapes.entity.Circle;
import com.geopagos.rest_api.shapes.entity.Rectangle;
import com.geopagos.rest_api.shapes.entity.Triangle;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class ShapeService {

    @Autowired
    ShapeRepository shapeRepository;

    public List<Circle> listCircles() {
        return shapeRepository.findAllCircles();
    }

    public Circle getCircleById(Long id) {
        BaseShape shape = shapeRepository.findOne(id);
        if (shape instanceof Circle) {
            return (Circle) shape;
        } else {
            return null;
        }
    }

    public Circle addCircle(Circle circle) {
       return shapeRepository.save(circle);
    }

    public List<Rectangle> listRectangles() {
        return shapeRepository.findAllRectangles();
    }

    public Rectangle getRectangleById(Long id) {
        BaseShape shape = shapeRepository.findOne(id);
        if (shape instanceof Rectangle) {
            return (Rectangle) shape;
        } else {
            return null;
        }
    }

    public Rectangle addRectangle(Rectangle rectangle) {
        return shapeRepository.save(rectangle);
    }

    public List<Triangle> listTriangles() {
        return shapeRepository.findAllTriangles();
    }

    public Triangle getTriangleById(Long id) {
        BaseShape shape = shapeRepository.findOne(id);
        if (shape instanceof Triangle) {
            return (Triangle) shape;
        } else {
            return null;
        }
    }

    public Triangle addTriangle(Triangle triangle) {
        return shapeRepository.save(triangle);
    }

}
