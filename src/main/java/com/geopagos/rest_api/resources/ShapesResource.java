package com.geopagos.rest_api.resources;

import com.geopagos.rest_api.shapes.ShapeService;
import com.geopagos.rest_api.shapes.entity.Circle;
import com.geopagos.rest_api.shapes.entity.Rectangle;
import com.geopagos.rest_api.shapes.entity.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping(value = "/shapes", produces = {MediaType.APPLICATION_JSON_VALUE, "application/hal+json"})
public class ShapesResource {

    @Autowired
    ShapeService shapeService;

    @GetMapping("/circles")
    public ResponseEntity listCircles() {
        List<Resource<Circle>> circles = shapeService.listCircles().stream()
                .map(circle -> new Resource<>(circle,
                        linkTo(methodOn(ShapesResource.class).getCircle(circle.getId())).withSelfRel(),
                        linkTo(methodOn(ShapesResource.class).listCircles()).withRel("circles")))
                .collect(Collectors.toList());
        Resources<Resource<Circle>> responseBody = new Resources<>(circles, linkTo(methodOn(ShapesResource.class).listCircles()).withSelfRel());
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/circles/{id}")
    public ResponseEntity getCircle(@PathVariable("id") Long id) {
        Circle circle = shapeService.getCircleById(id);

        if (circle == null) {
            return ResponseEntity.notFound().build();
        } else {
            Resource<Circle> responseBody = new Resource<>(circle,
                    linkTo(methodOn(ShapesResource.class).getCircle(circle.getId())).withSelfRel(),
                    linkTo(methodOn(ShapesResource.class).listCircles()).withRel("circles"));
            return ResponseEntity.ok(responseBody);
        }
    }

    @PostMapping("/circles")
    public ResponseEntity addCircle(@RequestBody Circle circle) {
        Circle addedCircle = shapeService.addCircle(circle);

        Link selfLink = linkTo(methodOn(ShapesResource.class).getCircle(addedCircle.getId())).withSelfRel();
        Resource<Circle> responseBody =  new Resource<>(addedCircle,
                selfLink,
                linkTo(methodOn(ShapesResource.class).listCircles()).withRel("circles"));
        return ResponseEntity.created(URI.create(selfLink.getHref())).body(responseBody);
    }

    @GetMapping("/rectangles")
    public ResponseEntity listRectangles() {
        List<Resource<Rectangle>> rectangles = shapeService.listRectangles().stream()
                .map(rectangle -> new Resource<>(rectangle,
                        linkTo(methodOn(ShapesResource.class).getRectangle(rectangle.getId())).withSelfRel(),
                        linkTo(methodOn(ShapesResource.class).listRectangles()).withRel("rectangles")))
                .collect(Collectors.toList());
        Resources<Resource<Rectangle>> responseBody = new Resources<>(rectangles, linkTo(methodOn(ShapesResource.class).listRectangles()).withSelfRel());
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/rectangles/{id}")
    public ResponseEntity getRectangle(@PathVariable("id") Long id) {
        Rectangle rectangle = shapeService.getRectangleById(id);

        if (rectangle == null) {
            return ResponseEntity.notFound().build();
        } else {
            Resource<Rectangle> responseBody = new Resource<>(rectangle,
                    linkTo(methodOn(ShapesResource.class).getRectangle(rectangle.getId())).withSelfRel(),
                    linkTo(methodOn(ShapesResource.class).listRectangles()).withRel("rectangles"));
            return ResponseEntity.ok(responseBody);
        }
    }

    @PostMapping("/rectangles")
    public ResponseEntity addRectangle(@RequestBody Rectangle rectangle) {
        Rectangle addedRectangle = shapeService.addRectangle(rectangle);

        Link selfLink = linkTo(methodOn(ShapesResource.class).getRectangle(addedRectangle.getId())).withSelfRel();
        Resource<Rectangle> responseBody = new Resource<>(addedRectangle,
                selfLink,
                linkTo(methodOn(ShapesResource.class).listRectangles()).withRel("rectangles"));
        return ResponseEntity.created(URI.create(selfLink.getHref())).body(responseBody);
    }

    @GetMapping("/triangles")
    public ResponseEntity listTriangles() {
        List<Resource<Triangle>> triangles = shapeService.listTriangles().stream()
                .map(triangle -> new Resource<>(triangle,
                        linkTo(methodOn(ShapesResource.class).getTriangle(triangle.getId())).withSelfRel(),
                        linkTo(methodOn(ShapesResource.class).listTriangles()).withRel("triangles")))
                .collect(Collectors.toList());
        Resources<Resource<Triangle>> responseBody = new Resources<>(triangles, linkTo(methodOn(ShapesResource.class).listTriangles()).withSelfRel());
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/triangles/{id}")
    public ResponseEntity getTriangle(@PathVariable("id") Long id) {
        Triangle triangle = shapeService.getTriangleById(id);

        if (triangle == null) {
            return ResponseEntity.notFound().build();
        } else {
            Resource<Triangle> responseBody = new Resource<>(triangle,
                    linkTo(methodOn(ShapesResource.class).getTriangle(triangle.getId())).withSelfRel(),
                    linkTo(methodOn(ShapesResource.class).listTriangles()).withRel("triangles"));
            return ResponseEntity.ok(responseBody);
        }
    }

    @PostMapping("/triangles")
    public ResponseEntity addTriangle(@RequestBody Triangle triangle) {
        Triangle addedTriangle = shapeService.addTriangle(triangle);

        Link selfLink = linkTo(methodOn(ShapesResource.class).getTriangle(addedTriangle.getId())).withSelfRel();
        Resource<Triangle> responseBody = new Resource<>(addedTriangle,
                selfLink,
                linkTo(methodOn(ShapesResource.class).listTriangles()).withRel("triangles"));
        return ResponseEntity.created(URI.create(selfLink.getHref())).body(responseBody);
    }
}
