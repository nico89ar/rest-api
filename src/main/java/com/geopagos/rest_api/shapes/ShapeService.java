package com.geopagos.rest_api.shapes;

import com.geopagos.rest_api.shapes.db.ShapeRepository;
import com.geopagos.rest_api.shapes.entity.Circle;
import com.geopagos.rest_api.shapes.entity.Rectangle;
import com.geopagos.rest_api.shapes.entity.Triangle;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
public class ShapeService {

    @Autowired
    ShapeRepository shapeRepository;

    public List<Shape> listShapes() {
        return shapeRepository.findAll().stream()
                .map(baseShape -> (Shape) baseShape)
                .collect(Collectors.toList());
    }

    public Shape getShapeById(Long id) {
        return shapeRepository.findOne(id);
    }

    public Circle addCircle(Circle circle) {
       return shapeRepository.save(circle);
    }

    public Rectangle addRectangle(Rectangle rectangle) {
        return shapeRepository.save(rectangle);
    }

    public Triangle addTriangle(Triangle triangle) {
        return shapeRepository.save(triangle);
    }

}
