package com.bqtankiet.angiday.interfaces.http.v1.brand;

import com.bqtankiet.angiday.application.brand.usecase.GetAllBrand;
import com.bqtankiet.angiday.application.brand.usecase.GetBrandById;
import com.bqtankiet.angiday.interfaces.http.base.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bqtankiet
 */
@RestController
@RequestMapping("/api/v1/brands")
public class BrandController {

    private final GetAllBrand getAllBrand;
    private final GetBrandById getBrandById;
    private final BrandResponseMapper brandResponseMapper;

    @Autowired
    public BrandController(GetAllBrand getAllBrand, GetBrandById getBrandById, BrandResponseMapper brandResponseMapper) {
        this.getAllBrand = getAllBrand;
        this.getBrandById = getBrandById;
        this.brandResponseMapper = brandResponseMapper;
    }

    @GetMapping
    public ResponseEntity<?> getAllBrand() {
        var rs = getAllBrand.call();
        var dto = rs.brands().stream()
                .map(brandResponseMapper::modelToDto)
                .toList();
        ApiResponse<?> resp = ApiResponse.success(dto);
        resp.addMetadata("size", dto.size());
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBrandById(@PathVariable Long id) {
        var rs = getBrandById
                .call(String.valueOf(id));
        var dto = brandResponseMapper.modelToDto(rs);
        ApiResponse<?> resp = ApiResponse.success(dto);
        return ResponseEntity.ok(resp);
    }

}
