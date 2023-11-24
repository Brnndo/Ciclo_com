package com.example.Ciclo_com.controllers;

import com.example.Ciclo_com.dtos.RouteRecordDto;
import com.example.Ciclo_com.models.RouteModel;
import com.example.Ciclo_com.repositories.RouteRepository;
import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class RouteController {

    @Autowired
    RouteRepository routeRepository;

    @PostMapping("/Route")
    public ResponseEntity<RouteModel> saveRoute(@RequestBody @Valid RouteRecordDto routeRecordDto) {
        var RouteModel = new RouteModel();
        BeanUtils.copyProperties(routeRecordDto, RouteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(routeRepository.save(RouteModel));


    }

    @GetMapping("/Route")
    public ResponseEntity <List<RouteModel>> getAllRoute(){
        return ResponseEntity.status(HttpStatus.OK).body(routeRepository.findAll());
    }

    @GetMapping("/Route/{id}")
    public ResponseEntity<Object> getOneRoute(@PathVariable(value = "id") UUID id){
        Optional<RouteModel> route0 = routeRepository.findById(id);
        if(route0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Route not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(route0.get());
    }

    @PutMapping("/Route/{id}")
    public ResponseEntity<Object> updateRoute(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid RouteRecordDto routeRecordDto){
        Optional<RouteModel> route0 = routeRepository.findById(id);
        if(route0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Route not found.");
        }
        var routeModel = route0.get();
        BeanUtils.copyProperties(routeRecordDto, routeModel);
        return ResponseEntity.status(HttpStatus.OK).body(routeRepository.save(routeModel));
    }

    @DeleteMapping("/Route/{id}")
    public ResponseEntity<Object> deleteRoute(@PathVariable(value = "id") UUID id){
        Optional<RouteModel> route0 = routeRepository.findById(id);
        if(route0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Route not found.");
        }
        routeRepository.delete(route0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Route deleted sucessfully.");
    }



}
