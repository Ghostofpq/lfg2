package com.gop.lfg.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/events")
public class EventController {
    @Autowired
    private EventService eventService;

}
