package com.example.Ciclo_com.controllers;


import com.example.Ciclo_com.dtos.EventRecordDto;
import com.example.Ciclo_com.models.EventModel;
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
public class EventController {
    @Autowired
    EventRepository eventRepository;


    @PostMapping("/Event")
    public ResponseEntity<EventModel> saveEvent(@RequestBody @Valid EventRecordDto eventRecordDto) {
        var EventModel = new EventModel();
        BeanUtils.copyProperties(eventRecordDto, EventModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventRepository.save(EventModel));
    }



    @GetMapping("/Event")
    public ResponseEntity <List<EventModel>> getAllEvent(){
        return ResponseEntity.status(HttpStatus.OK).body(eventRepository.findAll());
    }

    @GetMapping("/Event/{id}")
    public ResponseEntity<Object> getOneEvent(@PathVariable(value = "id") UUID id){
        Optional<EventModel> event0 = eventRepository.findById(id);
        if(event0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(event0.get());
    }

    @PutMapping("/Event/{id}")
    public ResponseEntity<Object> updateEvent(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid EventRecordDto eventRecordDto){
        Optional<EventModel> event0 = eventRepository.findById(id);
        if(event0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
        }
        var eventModel = event0.get();
        BeanUtils.copyProperties(eventRecordDto, eventModel);
        return ResponseEntity.status(HttpStatus.OK).body(eventRepository.save(eventModel));
    }

    @DeleteMapping("/Event/{id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable(value = "id") UUID id){
        Optional<EventModel> event0 = eventRepository.findById(id);
        if(event0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found.");
        }
        eventRepository.delete(event0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Event deleted sucessfully.");
    }



}
