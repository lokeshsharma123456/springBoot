package com.sharma.journalApp.services;

import com.sharma.journalApp.entity.JournalEntry;
import com.sharma.journalApp.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepo.save(journalEntry);
    }

    public JournalEntry getEntryById(ObjectId Id){
        return journalEntryRepo.findById(Id).orElse(null);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public void deleteByID(ObjectId id){
        journalEntryRepo.deleteById(id);
    }


    public ResponseEntity<JournalEntry> updateByID(ObjectId id, JournalEntry myEntity){
        JournalEntry oldJournalEntity = journalEntryRepo.findById(id).orElse(null);
        if(null != oldJournalEntity){
            oldJournalEntity.setContent(myEntity.getContent() != null
                                        && myEntity.getContent() != "" ? myEntity.getContent() : oldJournalEntity.getContent());
            oldJournalEntity.setTitle(myEntity.getTitle() != null
                                        && myEntity.getTitle() != "" ? myEntity.getTitle() : oldJournalEntity.getTitle());
            saveEntry(oldJournalEntity);
            return  new ResponseEntity<>(oldJournalEntity,  HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
