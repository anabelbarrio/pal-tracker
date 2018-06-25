package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(@Autowired TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public ResponseEntity<TimeEntry> create(TimeEntry timeEntry) {
        timeEntry = timeEntryRepository.create(timeEntry);
        return new ResponseEntity<>(timeEntry, HttpStatus.CREATED);
    }

    public ResponseEntity<TimeEntry> read(long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if (timeEntry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(timeEntry);
    }

    public ResponseEntity<List<TimeEntry>> list() {
        return ResponseEntity.ok(timeEntryRepository.list());
    }

    public ResponseEntity update(long id, TimeEntry timeEntry) {
        timeEntry = timeEntryRepository.update(id, timeEntry);
        if (timeEntry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(timeEntry);
    }

    public ResponseEntity<TimeEntry> delete(long id) {
        timeEntryRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
