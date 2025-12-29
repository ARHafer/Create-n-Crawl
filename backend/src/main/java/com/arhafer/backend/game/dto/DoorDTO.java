package com.arhafer.backend.game.dto;

import com.arhafer.backend.game.model.Room;

public class DoorDTO {
    private final String name;
    private final Room otherRoom;

    public DoorDTO(String doorName, Room otherRoom) {
        this.name = doorName;
        this.otherRoom = otherRoom;
    }

    // Getters //
    public String getName() {
        return name;
    }

    public Room getOtherRoom() {
        return otherRoom;
    }
    
}
