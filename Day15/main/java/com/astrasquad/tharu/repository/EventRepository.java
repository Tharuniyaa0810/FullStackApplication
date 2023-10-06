package com.astrasquad.tharu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.astrasquad.tharu.model.Event;

public interface EventRepository  extends JpaRepository<Event, Integer>  {

}
