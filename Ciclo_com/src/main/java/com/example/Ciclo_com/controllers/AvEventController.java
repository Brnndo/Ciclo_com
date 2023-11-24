package com.example.Ciclo_com.controllers;

import com.example.Ciclo_com.dtos.AvEventRecordDto;
import com.example.Ciclo_com.dtos.EventRecordDto;
import com.example.Ciclo_com.models.AvEventModel;
import com.example.Ciclo_com.models.EventModel;
import com.example.Ciclo_com.repositories.AvEventRepository;
import com.example.Ciclo_com.repositories.EventRepository;
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
public class AvEventController {
    @Autowired
    AvEventRepository avEventRepository;


    @PostMapping("/Rating")
    public ResponseEntity<AvEventModel> saveAvaliacao(@RequestBody @Valid AvEventRecordDto avEventRecordDto) {
        var AvEventModel = new AvEventModel();
        BeanUtils.copyProperties(avEventRecordDto, AvEventModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(avEventRepository.save(AvEventModel));
    }

    @GetMapping("/Rating")
    public ResponseEntity <List<AvEventModel>> getAllAvaliacao(){
        return ResponseEntity.status(HttpStatus.OK).body(avEventRepository.findAll());
    }

    @GetMapping("/Rating/{id}")
    public ResponseEntity<Object> getOneAvaliacao(@PathVariable(value = "id") UUID id){
        Optional<AvEventModel> avEvent0 = avEventRepository.findById(id);
        if(avEvent0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rating not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(avEvent0.get());
    }

    @PutMapping("/Rating/{id}")
    public ResponseEntity<Object> updateAvaliacao(@PathVariable(value = "id") UUID id,
                                              @RequestBody @Valid AvEventRecordDto avEventRecordDto){
        Optional<AvEventModel> avEvent0 = avEventRepository.findById(id);
        if(avEvent0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rating not found.");
        }
        var avEventModel = avEvent0.get();
        BeanUtils.copyProperties(avEventRecordDto, avEventModel);
        return ResponseEntity.status(HttpStatus.OK).body(avEventRepository.save(avEventModel));
    }

    @DeleteMapping("/Rating/{id}")
    public ResponseEntity<Object> deleteAvaliacao(@PathVariable(value = "id") UUID id){
        Optional<AvEventModel> avEvent0 = avEventRepository.findById(id);
        if(avEvent0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rating not found.");
        }
        avEventRepository.delete(avEvent0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Rating deleted sucessfully.");
    }

}