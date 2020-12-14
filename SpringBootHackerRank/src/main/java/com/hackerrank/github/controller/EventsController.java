package com.hackerrank.github.controller;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventsController {

    @Autowired
    SampleService sampleService;

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public ResponseEntity<Event> insertWeather(@RequestBody Event event) {
        Optional<Event> optional=sampleService.getByIdEvent(event.getId());
        if(optional.isPresent()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        else {
            sampleService.insertEvent(event);
            return new ResponseEntity(HttpStatus.CREATED);
        }

    }

    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    public ResponseEntity<Event> getByIdEvent(@PathVariable Long id) {
        Optional<Event> optional=sampleService.getByIdEvent(id);
        if(optional.isPresent())
            return new ResponseEntity(optional.get(), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/events/repos/{repoId}", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getByIdRepos(@PathVariable Long repoId) {
        List<Event> list=sampleService.getByIdRepos(repoId);
        if(list.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list,HttpStatus.OK);
    }

    @RequestMapping(value = "/events/actors/{actorId}", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getByIdActor(@PathVariable Long actorId) {
        List<Event> list=sampleService.getByIdRepos(actorId);
        if(list.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list,HttpStatus.OK);
    }

    @RequestMapping(value = "/events/repos/{repoId}/actors/{actorId}", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getByIdActor(@PathVariable Long repoId,  @PathVariable Long actorId) {
        List<Event> list=sampleService.getByIdActorAndRepo(actorId,repoId);
        if(list.isEmpty())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list,HttpStatus.OK);
    }

    @RequestMapping(value = "/events/endpoint/select", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getAllEvent() {
        return new ResponseEntity(sampleService.getEvents(), HttpStatus.OK);
    }

}
