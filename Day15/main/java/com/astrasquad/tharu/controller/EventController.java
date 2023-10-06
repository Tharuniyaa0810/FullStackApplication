package com.astrasquad.tharu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.astrasquad.tharu.dto.EventRequestDTO;
import com.astrasquad.tharu.dto.EventResponseDTO;
import com.astrasquad.tharu.dto.UserDTO;
import com.astrasquad.tharu.model.Event;
import com.astrasquad.tharu.model.User;
import com.astrasquad.tharu.repository.UserRepository;
import com.astrasquad.tharu.service.EventService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exchange")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/post")
    public ResponseEntity<EventResponseDTO> createEvent(@RequestBody EventRequestDTO eventRequestDTO) {
		User organizer = userRepository.findById(eventRequestDTO.getOrganizer().getOrgID()).orElse(null);
        Event event = new Event();
        event.setName(eventRequestDTO.getName());
        event.setTransaction(eventRequestDTO.getTransaction());
        event.setDescription(eventRequestDTO.getDescription());
        event.setOrganizer(organizer);
        // Set other relevant fields

        // Call the service layer to create the event
        Event createdEvent = eventService.createEvent(event);

        // Map the created event entity to the response DTO within the controller method
        EventResponseDTO responseDTO = new EventResponseDTO();
        responseDTO.setUserID(createdEvent.getUserID());
        responseDTO.setName(createdEvent.getName());
        responseDTO.setTransaction(createdEvent.getTransaction());
        responseDTO.setDescription(createdEvent.getDescription());
        responseDTO.setOrganizer(mapUserToUserDTO(createdEvent.getOrganizer()));
        // Set other relevant fields

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/get/{eventID}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable Integer eventID) {
        // Call the service layer to retrieve the event by ID
        Event event = eventService.getEventById(eventID);

        // Map the event entity to the response DTO within the controller method
        EventResponseDTO responseDTO = new EventResponseDTO();
        responseDTO.setUserID(event.getUserID());
        responseDTO.setName(event.getName());
        responseDTO.setTransaction(event.getTransaction());
        responseDTO.setDescription(event.getDescription());
        responseDTO.setOrganizer(mapUserToUserDTO(event.getOrganizer()));
        // Set other relevant fields

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/get")
    public ResponseEntity<List<EventResponseDTO>> getAllEvents() {
        // Call the service layer to retrieve all events
        List<Event> events = eventService.getAllEvents();

        // Map the list of event entities to a list of response DTOs within the controller method
        List<EventResponseDTO> responseDTOs = events.stream()
                .map(event -> {
                    EventResponseDTO responseDTO = new EventResponseDTO();
                    responseDTO.setUserID(event.getUserID());
                    responseDTO.setName(event.getName());
                    responseDTO.setTransaction(event.getTransaction());
                    responseDTO.setDescription(event.getDescription());
                    responseDTO.setOrganizer(mapUserToUserDTO(event.getOrganizer()));
                    // Set other relevant fields
                    return responseDTO;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping("/put/{eventID}")
    public ResponseEntity<EventResponseDTO> updateEvent(@PathVariable Integer eventID, @RequestBody EventRequestDTO eventRequestDTO) {
        // Call the service layer to update the event by ID
        Event existingEvent = eventService.getEventById(eventID);

        // Update the existing event entity with the data from the DTO
        existingEvent.setName(eventRequestDTO.getName());
        existingEvent.setTransaction(eventRequestDTO.getTransaction());
        existingEvent.setDescription(eventRequestDTO.getDescription());
        // Update other relevant fields

        // Call the service layer to save the updated event
        Event updatedEvent = eventService.updateEvent(existingEvent);

        // Map the updated event entity to the response DTO within the controller method
        EventResponseDTO responseDTO = new EventResponseDTO();
        responseDTO.setUserID(updatedEvent.getUserID());
        responseDTO.setName(updatedEvent.getName());
        responseDTO.setTransaction(updatedEvent.getTransaction());
        responseDTO.setDescription(updatedEvent.getDescription());
        responseDTO.setOrganizer(mapUserToUserDTO(updatedEvent.getOrganizer()));
        // Set other relevant fields

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/del/{eventID}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer eventID) {
        // Call the service layer to delete the event by ID
        eventService.deleteEvent(eventID);

        return ResponseEntity.noContent().build();
    }

    private UserDTO mapUserToUserDTO(User user) {
        if (user == null) {
            return null; // Handle this case as needed
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setOrgID(user.getOrgID());
        userDTO.setName(user.getName());
        userDTO.setTransaction(user.getTransaction());
        // Map other user properties as needed
        return userDTO;
    }

}
