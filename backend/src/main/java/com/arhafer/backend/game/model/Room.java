package com.arhafer.backend.game.model;

import java.util.*;

import com.arhafer.backend.game.dto.DoorDTO;
import com.arhafer.backend.game.dto.RoomDTO;

public class Room {
    private final String name, description;
    private final List<String> itemNames; // Just need the names for now.
    private Door north, south, east, west;
    private boolean explored;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        itemNames = new ArrayList<>();
        explored = false;
    }

    public void addItem(Item item) {
        itemNames.add(item.getName());
    }

    public RoomDTO convertToDTO() {
        return new RoomDTO(name, description, itemNames, getDoorInfo(), explored);
    }

    // Setters & Getters //
    public void setDoor(Door door, String direction) {

        switch (direction.toLowerCase()) {
            case "north" -> north = door;
            case "south" -> south = door;
            case "east" -> east = door;
            case "west" -> west = door;
        }

        door.setRoom(this);
    }

    public void setExplored() {
        explored = true;
    }

    public String getName() {
        return name;
    }

    public boolean isExplored() {
        return explored;
    }

    public Door getDoor(String direction) {
        return switch (direction.toLowerCase()) {
            case "north" -> north;
            case "south" -> south;
            case "east" -> east;
            case "west" -> west;
            default -> null;
        };
    }

    public Map<String, DoorDTO> getDoorInfo() {
        Map<String, DoorDTO> doorInfo = new HashMap<>();

        if (north != null) {
            doorInfo.put("north", new DoorDTO(north.getName(), north.getOtherRoom(this)));
        }

        if (south != null) {
            doorInfo.put("south", new DoorDTO(south.getName(), south.getOtherRoom(this)));
        }

        if (east != null) {
            doorInfo.put("east", new DoorDTO(east.getName(), east.getOtherRoom(this)));
        }

        if (west != null) {
            doorInfo.put("west", new DoorDTO(west.getName(), west.getOtherRoom(this)));
        }

        return doorInfo;
    }
    
}
