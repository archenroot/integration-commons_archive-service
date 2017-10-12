package org.archenroot.integration.commons.archive_service.backend.controller;

import org.archenroot.integration.commons.archive_service.backend.domain.Archive;
import org.archenroot.integration.commons.archive_service.backend.repository.FileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Collection;

@RestController
@RequestMapping("/api/files")
public class ArchiveRegistryController {

    private FileRepository fileRepository;

    //@Inject
    public void setRepository(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addFile(@RequestBody Archive archive) {

        return new ResponseEntity<>(fileRepository.save(archive), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Archive>> getAllFilees() {
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Archive> getFileWithId(@PathVariable Long id) {
        return new ResponseEntity<>(fileRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"name"},
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Archive>>
    findFileWithName(
            @RequestParam(value = "name") String name) {
        return new ResponseEntity<>(fileRepository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Archive> updateFileFromDB(@PathVariable("id") long id, @RequestBody Archive archive) {

        //Archive currentRecord = fileRepository.findOne(id);
        //currentFile.setName(File.getName());
        //currentFile.setDescription(File.getDescription());
        //currentFile.setTags(File.getTags());

        return new ResponseEntity<>(fileRepository.save(archive), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteFileWithId(@PathVariable Long id) {
        fileRepository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllFiles() {
        fileRepository.deleteAll();
    }
}
