package com.arhafer.backend.game.dto;

import java.util.*;

/*
 * Collects all data about a room at a specific moment in time.
 * Used for task separation between classes. Room class provides data, DTO transports it.
 */

public class RoomDTO {
    private final String name, description;
    private final List<String> itemNames;
    private final Map<String, DoorDTO> doorInfo;
    private final boolean explored;

    public RoomDTO(String name, String description, List<String> itemNames, Map<String, DoorDTO> doorInfo, boolean explored) {
        this.name = name;
        this.description = description;
        this.itemNames = itemNames;
        this.doorInfo = doorInfo;
        this.explored = explored;
    }

    // Getters //
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    public Map<String, DoorDTO> getDoorInfo() {
        return doorInfo;
    }

    public boolean isExplored() {
        return explored;
    }
    
}
