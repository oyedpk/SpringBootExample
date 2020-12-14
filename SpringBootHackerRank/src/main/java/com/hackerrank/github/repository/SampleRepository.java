package com.hackerrank.github.repository;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByRepo(Repo repo);
    List<Event> findAllByActor(Actor actor);
    List<Event> findAllByActorAndRepo(Actor actor,Repo repo);


}
