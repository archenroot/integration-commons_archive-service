package org.archenroot.integration.commons.archive_service.backend.controller;

import eu.coreso.integration.common_archive_service.backend.domain.BusinessProcess;
import org.archenroot.integration.commons.archive_service.backend.repository.BusinessProcessRepository;
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
@RequestMapping("/api/business-processes")
public class BusinessProcessController {

    private BusinessProcessRepository businessProcessRepository;

    @Inject
    public void setRepository(BusinessProcessRepository businessProcessRepository) {
        this.businessProcessRepository = businessProcessRepository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addBusinessProcess(@RequestBody BusinessProcess businessProcess) {

        return new ResponseEntity<>(businessProcessRepository.save(businessProcess), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<BusinessProcess>> getAllBusinessProcesses() {
        return new ResponseEntity<>(businessProcessRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<BusinessProcess> getBusinessProcessWithId(@PathVariable Long id) {
        return new ResponseEntity<>(businessProcessRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"name"},
            method = RequestMethod.GET)
    public ResponseEntity<Collection<BusinessProcess>>
    findBusinessProcessWithName(
            @RequestParam(value = "name") String name) {
        return new ResponseEntity<>(businessProcessRepository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<BusinessProcess> updateBusinessProcessFromDB(@PathVariable("id") long id, @RequestBody BusinessProcess businessProcess) {

        BusinessProcess currentBusinessProcess = businessProcessRepository.findOne(id);
        currentBusinessProcess.setName(businessProcess.getName());
        currentBusinessProcess.setDescription(businessProcess.getDescription());
        //currentBusinessProcess.setTags(businessProcess.getTags());

        return new ResponseEntity<>(businessProcessRepository.save(currentBusinessProcess), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteBusinessProcessWithId(@PathVariable Long id) {
        businessProcessRepository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllBusinessProcesses() {
        businessProcessRepository.deleteAll();
    }
}
