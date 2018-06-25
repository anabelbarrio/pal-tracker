package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private Map<Long, TimeEntry> timeEntries = new HashMap<>();
    private int counter = 0;

    private int getNextId() {
        return ++counter;
    }

    public TimeEntry create(TimeEntry timeEntry) {
        if (timeEntry == null) {
            return null;
        }
        timeEntry.setId(getNextId());
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    public TimeEntry find(long id) {
        return timeEntries.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<>(timeEntries.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (timeEntries.get(id) == null) {
            return null;
        }
        timeEntry.setId(id);
        timeEntries.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    public TimeEntry delete(long id) {
        return timeEntries.remove(id);
    }
}
