package com.sharma.journalApp.controller;

import com.sharma.journalApp.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntity> je = new HashMap<>();

    @GetMapping
    public List<JournalEntity> getAll(){
        return new ArrayList<>(je.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntity myEntity){
        je.put(myEntity.getId(), myEntity);
        return true;
    }
    @GetMapping("id/{myID}")
    public JournalEntity getByID(@PathVariable Long myID){
        if(je.containsKey(myID)){
            return je.get(myID);
        }
        else{
            return null;
        }
    }

    @DeleteMapping("id/{myID}")
    public JournalEntity deleteByID(@PathVariable Long myID){
        if(je.containsKey(myID)){
            return je.remove(myID);
        }
        else return  null;
    }

    @PostMapping("id/{myID}")
    public JournalEntity updateByID(@PathVariable Long myID, @RequestBody JournalEntity myEntity){
        if(je.containsKey(myID)){
            return je.put(myID, myEntity);
        }
        else return  null;
    }

}
