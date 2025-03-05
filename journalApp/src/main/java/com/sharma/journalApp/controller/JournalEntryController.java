package com.sharma.journalApp.controller;

import com.sharma.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal1")
public class JournalEntryController {

//    private Map<Long, JournalEntry> je = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(je.values());
//    }
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntity){
//        je.put(myEntity.getId(), myEntity);
//        return true;
//    }
//    @GetMapping("id/{myID}")
//    public JournalEntry getByID(@PathVariable Long myID){
//        if(je.containsKey(myID)){
//            return je.get(myID);
//        }
//        else{
//            return null;
//        }
//    }
//
//    @DeleteMapping("id/{myID}")
//    public JournalEntry deleteByID(@PathVariable Long myID){
//        if(je.containsKey(myID)){
//            return je.remove(myID);
//        }
//        else return  null;
//    }

//    @PostMapping("id/{myID}")
//    public JournalEntry updateByID(@PathVariable Long myID, @RequestBody JournalEntry myEntity){
//        if(je.containsKey(myID)){
//            return je.put(myID, myEntity);
//        }
//        else return  null;
//    }

}
