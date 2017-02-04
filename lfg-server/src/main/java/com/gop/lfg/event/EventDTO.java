package com.gop.lfg.event;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "event")
class EventDTO {
    @Id
    private String id;
    private int version;

    private String name;
    private String description;

    private long timestampStart;
    private long timestampEnd;

    private Set<String> games;
    private Set<String> participants;

    private GeoJsonPoint location;
}
