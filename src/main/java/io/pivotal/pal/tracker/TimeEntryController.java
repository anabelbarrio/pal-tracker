package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(@Autowired TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public ResponseEntity create(TimeEntry timeEntry) {
        return null;
    }

    public ResponseEntity<TimeEntry> read(long id) {
        return null;
    }

    public ResponseEntity<List<TimeEntry>> list() {
        return null;
    }

    public ResponseEntity update(long id, TimeEntry timeEntry) {
        return null;
    }

    public ResponseEntity<TimeEntry> delete(long id) {
        return null;
    }
}
