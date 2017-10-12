package org.archenroot.integration.commons.archive_service.backend.controller;

import org.archenroot.integration.commons.archive_service.backend.repository.ArchiveConfigurationRepository;
import org.archenroot.integration.commons.archive_service.backend.repository.ArchiveGlobalConfigurationRepository;
import org.archenroot.integration.commons.archive_service.backend.domain.entity.ArchiveConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;

@RestController
@RequestMapping("/api/archive_entries")
public class ArchiveConfigurationController {

    private final ArchiveConfigurationRepository archiveConfigurationRepository;

    private final ArchiveGlobalConfigurationRepository archiveGlobalConfigurationRepository;

    @Autowired
    ArchiveConfigurationController(ArchiveConfigurationRepository archiveConfigurationRepository,
                                   ArchiveGlobalConfigurationRepository archiveGlobalConfigurationRepository) {
        this.archiveConfigurationRepository = archiveConfigurationRepository;
        this.archiveGlobalConfigurationRepository = archiveGlobalConfigurationRepository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addFile(@RequestBody ArchiveConfiguration archiveConfiguration) {

        return new ResponseEntity<>(archiveConfigurationRepository.save(archiveConfiguration), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<ArchiveConfiguration>> getAllArchiveEntries() {
        return new ResponseEntity<>(archiveConfigurationRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<ArchiveConfiguration> getArchiveConfigurationWithId(@PathVariable Long id) {
        return new ResponseEntity<>(archiveConfigurationRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"name"},
            method = RequestMethod.GET)
    public ResponseEntity<Collection<ArchiveConfiguration>>
    findFileWithName(
            @RequestParam(value = "name") String name) {
        return new ResponseEntity<>(archiveConfigurationRepository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<ArchiveConfiguration> updateArchiveConfiguration(@PathVariable("id") long id, @RequestBody ArchiveConfiguration archiveConfiguration) {

        ArchiveConfiguration currentArchiveConfiguration = archiveConfigurationRepository.findOne(id);
        currentArchiveConfiguration.setName(archiveConfiguration.getName());
        //currentArchiveConfiguration.setDescription(ArchiveConfiguration.getDescription());
        //currentFile.setTags(File.getTags());

        return new ResponseEntity<>(archiveConfigurationRepository.save(currentArchiveConfiguration), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteFileWithId(@PathVariable Long id) {
        archiveConfigurationRepository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllFiles() {
        archiveConfigurationRepository.deleteAll();
    }
}
