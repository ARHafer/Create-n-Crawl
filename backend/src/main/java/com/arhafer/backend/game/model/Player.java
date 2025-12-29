package com.arhafer.backend.game.model;

public class Player {
    private Room room; // The room the player currently occupies.

    public Player() {}

    public enum DoorResult {
        NO_DOOR,
        SUCCESS
    }

    public DoorResult enterDoor(String direction) {
        Door door = room.getDoor(direction);

        if (door == null) {
            return DoorResult.NO_DOOR;
        } else {
            setRoom(door.getOtherRoom(room));
            return DoorResult.SUCCESS;
        }
    }

    // Setters & Getters //
    public void setRoom(Room room) {
        this.room = room;
        room.setExplored();
    }

    public Room getRoom() {
        return room;
    }
    
}
