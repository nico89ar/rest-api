package com.geopagos.rest_api.resources;

import com.geopagos.rest_api.shapes.ShapeService;
import com.geopagos.rest_api.shapes.entity.Circle;
import com.geopagos.rest_api.shapes.entity.Rectangle;
import com.geopagos.rest_api.shapes.entity.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping(value = "/shapes", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class ShapesResource {

    @Autowired
    ShapeService shapeService;

    @GetMapping("/circles")
    public Resources<Resource<Circle>> listCircles() {
        List<Resource<Circle>> circles = shapeService.listCircles().stream()
                .map(circle -> new Resource<>(circle,
                        linkTo(methodOn(ShapesResource.class).getCircle(circle.getId())).withSelfRel(),
                        linkTo(methodOn(ShapesResource.class).listCircles()).withRel("circles")))
                .collect(Collectors.toList());
        return new Resources<>(circles, linkTo(methodOn(ShapesResource.class).listCircles()).withSelfRel());
    }

    @GetMapping("/circles/{id}")
    public Resource<Circle> getCircle(@PathVariable("id") Long id) {
        Circle circle = shapeService.getCircleById(id);
        return new Resource<>(circle,
                linkTo(methodOn(ShapesResource.class).getCircle(circle.getId())).withSelfRel(),
                linkTo(methodOn(ShapesResource.class).listCircles()).withRel("circles"));
    }

    @PostMapping("/circles")
    public Resource<Circle> addCircle(@RequestBody Circle circle) {
        Circle addedCircle = shapeService.addCircle(circle);
        return new Resource<>(addedCircle,
                linkTo(methodOn(ShapesResource.class).getCircle(addedCircle.getId())).withSelfRel(),
                linkTo(methodOn(ShapesResource.class).listCircles()).withRel("circles"));
    }

    @GetMapping("/rectangles")
    public Resources<Resource<Rectangle>> listRectangles() {
        List<Resource<Rectangle>> rectangles = shapeService.listRectangles().stream()
                .map(rectangle -> new Resource<>(rectangle,
                        linkTo(methodOn(ShapesResource.class).getRectangle(rectangle.getId())).withSelfRel(),
                        linkTo(methodOn(ShapesResource.class).listRectangles()).withRel("rectangles")))
                .collect(Collectors.toList());
        return new Resources<>(rectangles, linkTo(methodOn(ShapesResource.class).listRectangles()).withSelfRel());
    }

    @GetMapping("/rectangles/{id}")
    public Resource<Rectangle> getRectangle(@PathVariable("id") Long id) {
        Rectangle rectangle = shapeService.getRectangleById(id);
        return new Resource<>(rectangle,
                linkTo(methodOn(ShapesResource.class).getRectangle(rectangle.getId())).withSelfRel(),
                linkTo(methodOn(ShapesResource.class).listRectangles()).withRel("rectangles"));
    }

    @PostMapping("/rectangles")
    public Resource<Rectangle> addRectangle(@RequestBody Rectangle rectangle) {
        Rectangle addedRectangle = shapeService.addRectangle(rectangle);
        return new Resource<>(addedRectangle,
                linkTo(methodOn(ShapesResource.class).getRectangle(addedRectangle.getId())).withSelfRel(),
                linkTo(methodOn(ShapesResource.class).listRectangles()).withRel("rectangles"));
    }

    @GetMapping("/triangles")
    public Resources<Resource<Triangle>> listTriangles() {
        List<Resource<Triangle>> triangles = shapeService.listTriangles().stream()
                .map(triangle -> new Resource<>(triangle,
                        linkTo(methodOn(ShapesResource.class).getTriangle(triangle.getId())).withSelfRel(),
                        linkTo(methodOn(ShapesResource.class).listTriangles()).withRel("triangles")))
                .collect(Collectors.toList());
        return new Resources<>(triangles, linkTo(methodOn(ShapesResource.class).listTriangles()).withSelfRel());
    }

    @GetMapping("/triangles/{id}")
    public Resource<Triangle> getTriangle(@PathVariable("id") Long id) {
        Triangle triangle = shapeService.getTriangleById(id);
        return new Resource<>(triangle,
                linkTo(methodOn(ShapesResource.class).getTriangle(triangle.getId())).withSelfRel(),
                linkTo(methodOn(ShapesResource.class).listTriangles()).withRel("triangles"));
    }

    @PostMapping("/triangles")
    public Resource<Triangle> addTriangle(@RequestBody Triangle triangle) {
        Triangle addedTriangle = shapeService.addTriangle(triangle);
        return new Resource<>(addedTriangle,
                linkTo(methodOn(ShapesResource.class).getTriangle(addedTriangle.getId())).withSelfRel(),
                linkTo(methodOn(ShapesResource.class).listTriangles()).withRel("triangles"));
    }
}
