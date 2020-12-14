package com.hackerrank.github.service;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Repo;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.ReposRepository;
import com.hackerrank.github.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class SampleService {

    @Autowired
    SampleRepository sampleRepository;
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    ReposRepository reposRepository;

    public void insertEvent(Event event) {
        sampleRepository.save(event);
    }


    public Optional<Event> getByIdEvent(Long id) {
        return sampleRepository.findById(id);
    }


    public void deleteAll() {
        sampleRepository.deleteAll();
    }

    public List<Event> getByIdRepos(Long id) {
        Optional<Repo> optional = reposRepository.findById(id);
        List<Event> list = new ArrayList<>();
        if(optional.isPresent()) {
            list = sampleRepository.findAllByRepo(optional.get());
        }
        return list;
    }

    public List<Event> getByIdActor(Long id) {
        Optional<Actor> optional = actorRepository.findById(id);
        List<Event> list = new ArrayList<>();
        if(optional.isPresent()) {
            list = sampleRepository.findAllByActor(optional.get());
        }
        return list;
    }

    public List<Event> getByIdActorAndRepo(Long actorId,Long repoId) {
        Optional<Actor> optional = actorRepository.findById(actorId);
        Optional<Repo> optional1 = reposRepository.findById(repoId);
        List<Event> list = new ArrayList<>();
        if(optional.isPresent() && optional1.isPresent()) {
            list = sampleRepository.findAllByActorAndRepo(optional.get(),optional1.get());
        }
        return list;
    }

    public List<Event> getEvents() {
        Comparator<Event> comparator=Comparator.comparing(Event::getId);
        return sampleRepository.findAll().stream().sorted(comparator).collect(Collectors.toList());
    }

}
