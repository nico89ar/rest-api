package com.geopagos.rest_api.shapes.db;

import com.geopagos.rest_api.shapes.entity.BaseShape;
import com.geopagos.rest_api.shapes.entity.Circle;
import com.geopagos.rest_api.shapes.entity.Rectangle;
import com.geopagos.rest_api.shapes.entity.Triangle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShapeRepository extends JpaRepository<BaseShape, Long> {

    @Query("select shape from BaseShape shape where TYPE = 'CIRCLE'")
    List<Circle> findAllCircles();

    @Query("select shape from BaseShape shape where TYPE = 'RECTANGLE'")
    List<Rectangle> findAllRectangles();

    @Query("select shape from BaseShape shape where TYPE = 'TRIANGLE'")
    List<Triangle> findAllTriangles();

}
