package com.arhafer.backend.game.model;

public class Door {
    private final String name;
    private Room room1, room2;

    public Door(String name) {
        this.name = name;
    }

    // Setters & Getters //
    public void setRoom(Room room) {
        if (room1 == null) {
            room1 = room;
        } else {
            room2 = room;
        }
    }

    public String getName() {
        return name;
    }

    public Room getOtherRoom(Room room) {
        if (room == room1) {
            return room2;
        } else {
            return room1;
        }
    }
    
}
