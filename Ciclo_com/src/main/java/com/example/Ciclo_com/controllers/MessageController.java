package com.example.Ciclo_com.controllers;

import com.example.Ciclo_com.dtos.MessageRecordDto;
import com.example.Ciclo_com.models.MessageModel;
import com.example.Ciclo_com.repositories.MessageRepository;
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
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @PostMapping("/Message")
    public ResponseEntity<MessageModel> saveMessage(@RequestBody @Valid MessageRecordDto messageRecordDto) {
        var MessageModel = new MessageModel();
        BeanUtils.copyProperties(messageRecordDto, MessageModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(messageRepository.save(MessageModel));
    }

    @GetMapping("/Message")
    public ResponseEntity <List<MessageModel>> getAllMessage(){
        return ResponseEntity.status(HttpStatus.OK).body(messageRepository.findAll());
    }

    @GetMapping("/Message/{id}")
    public ResponseEntity<Object> getOneMessage(@PathVariable(value = "id") UUID id){
        Optional<MessageModel> message0 = messageRepository.findById(id);
        if(message0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(message0.get());
    }

    @PutMapping("/Message/{id}")
    public ResponseEntity<Object> updateMessage(@PathVariable(value = "id") UUID id,
                                                @RequestBody @Valid MessageRecordDto messageRecordDto){
        Optional<MessageModel> message0 = messageRepository.findById(id);
        if(message0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        var messageModel = message0.get();
        BeanUtils.copyProperties(messageRecordDto, messageModel);
        return ResponseEntity.status(HttpStatus.OK).body(messageRepository.save(messageModel));
    }

    @DeleteMapping("/Message/{id}")
    public ResponseEntity<Object> deleteMessage(@PathVariable(value = "id") UUID id){
        Optional<MessageModel> message0 = messageRepository.findById(id);
        if(message0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Message not found.");
        }
        messageRepository.delete(message0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Message deleted sucessfully.");
    }

}