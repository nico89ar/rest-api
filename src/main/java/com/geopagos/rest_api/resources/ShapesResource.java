package com.geopagos.rest_api.resources;

import com.geopagos.rest_api.shapes.Shape;
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

    @GetMapping
    public ResponseEntity listShapes() {
        List<Resource<Shape>> shapes = shapeService.listShapes().stream()
                .map(shape -> new Resource<>(shape,
                        linkTo(methodOn(ShapesResource.class).getShape(shape.getId())).withSelfRel(),
                        linkTo(methodOn(ShapesResource.class).listShapes()).withRel("shapes")))
                .collect(Collectors.toList());
        Resources<Resource<Shape>> responseBody = new Resources<>(shapes, linkTo(methodOn(ShapesResource.class).listShapes()).withSelfRel());
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity getShape(@PathVariable("id") Long id) {
        Shape shape = shapeService.getShapeById(id);

        if (shape == null) {
            return ResponseEntity.notFound().build();
        } else {
            Resource<Shape> responseBody = new Resource<>(shape,
                    linkTo(methodOn(ShapesResource.class).getShape(shape.getId())).withSelfRel(),
                    linkTo(methodOn(ShapesResource.class).listShapes()).withRel("shapes"));
            return ResponseEntity.ok(responseBody);
        }
    }

    @PostMapping("/circles")
    public ResponseEntity addCircle(@RequestBody Circle circle) {
        return buildAddShapeResponse(shapeService.addCircle(circle));
    }

    @PostMapping("/rectangles")
    public ResponseEntity addRectangle(@RequestBody Rectangle rectangle) {
        return buildAddShapeResponse(shapeService.addRectangle(rectangle));
    }

    @PostMapping("/triangles")
    public ResponseEntity addTriangle(@RequestBody Triangle triangle) {
        return buildAddShapeResponse(shapeService.addTriangle(triangle));
    }

    private ResponseEntity buildAddShapeResponse(Shape shape) {
        Link selfLink = linkTo(methodOn(ShapesResource.class).getShape(shape.getId())).withSelfRel();
        Resource<Shape> responseBody =  new Resource<>(shape,
                selfLink,
                linkTo(methodOn(ShapesResource.class).listShapes()).withRel("shapes"));
        return ResponseEntity.created(URI.create(selfLink.getHref())).body(responseBody);
    }
}
