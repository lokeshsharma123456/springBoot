package com.sharma.journalApp.controller;

import com.sharma.journalApp.entity.JournalEntry;
import com.sharma.journalApp.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry>getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntity){
        try{
            journalEntryService.saveEntry(myEntity);
            return new ResponseEntity<>(myEntity, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("id/{myID}")
    public  ResponseEntity<JournalEntry> getByID(@PathVariable ObjectId myID){
        Optional<JournalEntry> journalEntry = Optional.ofNullable(journalEntryService.getEntryById(myID));
        if (journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myID}")
    public ResponseEntity<JournalEntry> deleteByID(@PathVariable ObjectId myID){
       journalEntryService.deleteByID(myID);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("id/{myID}")
    public ResponseEntity<JournalEntry> updateByID(@PathVariable ObjectId myID, @RequestBody JournalEntry myEntity){

        return  journalEntryService.updateByID(myID, myEntity);
    }

}
