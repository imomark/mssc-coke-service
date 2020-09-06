package com.omar.mssccokeservice.web.controller;

import com.omar.mssccokeservice.web.model.CokeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/coke")
public class CokeController {

    @GetMapping("/{cokeId}")
    public ResponseEntity<CokeDto> getCokeById(@PathVariable UUID cokeId){
        return new ResponseEntity<CokeDto>(CokeDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewCoke(@RequestBody  CokeDto cokeDto){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{cokeId}")
    public ResponseEntity updateCokeById(@PathVariable  UUID cokeId, @RequestBody  CokeDto cokeDto){
        return  new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
