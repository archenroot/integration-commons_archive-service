package org.archenroot.integration.commons.archive_service.backend.controller;

import eu.coreso.integration.common_archive_service.backend.domain.Item;
import org.archenroot.integration.commons.archive_service.backend.repository.ItemRepository;
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
@RequestMapping("/api/items")
public class ItemController {

    private ItemRepository itemRepository;

    @Inject
    public void setRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(
            method = RequestMethod.POST)
    public ResponseEntity<?> addItem(@RequestBody Item item) {

        return new ResponseEntity<>(itemRepository.save(item), HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Item>> getAllItemes() {
        return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET)
    public ResponseEntity<Item> getItemWithId(@PathVariable Long id) {
        return new ResponseEntity<>(itemRepository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(
            params = {"name"},
            method = RequestMethod.GET)
    public ResponseEntity<Collection<Item>>
    findItemWithName(
            @RequestParam(value = "name") String name) {
        return new ResponseEntity<>(itemRepository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Item> updateItemFromDB(@PathVariable("id") long id, @RequestBody Item item) {

        Item currentItem = itemRepository.findOne(id);
        currentItem.setName(item.getName());
        currentItem.setExtra(item.getExtra());
        //currentItem.set(item.getTags());

        return new ResponseEntity<>(itemRepository.save(currentItem), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteItemWithId(@PathVariable Long id) {
        itemRepository.delete(id);
    }

    @RequestMapping(
            method = RequestMethod.DELETE)
    public void deleteAllItemes() {
        itemRepository.deleteAll();
    }


}
