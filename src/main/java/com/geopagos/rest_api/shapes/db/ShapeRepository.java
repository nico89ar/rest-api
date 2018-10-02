package com.geopagos.rest_api.shapes.db;

import com.geopagos.rest_api.shapes.entity.BaseShape;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShapeRepository extends JpaRepository<BaseShape, Long> {
}
