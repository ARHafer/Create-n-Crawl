package com.arhafer.backend.xml;

/*
 * Parses an XML file containing information stored in elements about the game map and the objects within.
 * Converts the XML elements into in-game objects, creating rooms and populating them with their respective objects.
 */

import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import com.arhafer.backend.game.model.Door;
import com.arhafer.backend.game.model.Item;
import com.arhafer.backend.game.model.Player;
import com.arhafer.backend.game.model.Room;

public class MapHandler extends DefaultHandler {
    private final Map<String, Room> rooms = new HashMap<>();
    private Room currentRoom;
    private Player player;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        switch (qName) {
            case "room" -> {
                String name = attributes.getValue("name");
                String description = attributes.getValue("description");

                currentRoom = new Room(name, description);
                rooms.put(name.toLowerCase(), currentRoom); // Names inserted in lowercase to ensure consistency.
            }

            case "door" -> {
                String direction = attributes.getValue("direction");
                String otherRoom = attributes.getValue("other_room");
                String name = attributes.getValue("name");

                // Prevents duplicate, unlinked doors from being created.
                if (!rooms.containsKey(otherRoom.toLowerCase())) {
                    Door newDoor = new Door(name);
                    currentRoom.setDoor(newDoor, direction);
                } else {
                    Door existingDoor = rooms.get(otherRoom.toLowerCase()).getDoor(getOppositeDirection(direction));
                    currentRoom.setDoor(existingDoor, direction);
                }
            }

            case "item" -> {
                String itemName = attributes.getValue("name");

                Item item = new Item(itemName);
                currentRoom.addItem(item);
            }

            case "player" -> {
                player = new Player();
                player.setRoom(currentRoom);
            }
        }
    }

    // Setters & Getters //
    public Player getPlayer() {
        return player;
    }

    private String getOppositeDirection(String direction) {
        return switch (direction.toLowerCase()) {
            case "north" -> "south";
            case "south" -> "north";
            case "east" -> "west";
            case "west" -> "east";
            default -> direction;
        };
    }

}
