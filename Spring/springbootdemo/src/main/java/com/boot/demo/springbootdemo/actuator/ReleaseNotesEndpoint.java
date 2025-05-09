package com.boot.demo.springbootdemo.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Endpoint(id="releaseNotes")
public class ReleaseNotesEndpoint {

    @Autowired
    private ReleaseNotesDataRepository releaseNotesDataRepository;

    @ReadOperation
    public List<ReleaseNote> getReleaseNotes() {
        return releaseNotesDataRepository.getReleaseNoteList();
    }
    @WriteOperation
    public ReleaseNote addReleaseNote(String version, String changeLogData) {
        ReleaseNote releaseNote = new ReleaseNote(version, LocalDateTime.now(), changeLogData);
        return releaseNotesDataRepository.addReleaseNote(releaseNote);
    }
    @DeleteOperation
    public void deleteReleaseNote(@Selector String version) { 	releaseNotesDataRepository.deleteReleaseNote(version);
    }
}

