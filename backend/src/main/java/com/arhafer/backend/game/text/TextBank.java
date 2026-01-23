package com.arhafer.backend.game.text;

import java.util.*;

import com.arhafer.backend.game.dto.DoorDTO;
import com.arhafer.backend.game.dto.RoomDTO;

/*
 * Converts game data into text that will be displayed by the frontend.
 */

public class TextBank {

     /*
      * Text that displays as feedback for the player's actions.
      */
    public static class FeedbackText {
        public static String describeRoom(RoomDTO room) {
            StringBuilder description = new StringBuilder();

            description.append("\n<").append(room.getName()).append(">\n").append(room.getDescription()).append("\n\nYou look around the room and see:\n");
            description.append(listItems(room)).append("\n").append(listDoors(room.getDoorInfo())).append("\n");

            return description.toString();
        }

        private static String listItems(RoomDTO room) {
            StringBuilder list = new StringBuilder();
            List<String> itemNames = room.getItemNames();
            int size = itemNames.size();

            // Code to ensure gramatical correctness //
            if (size > 1) {
                list.append(size).append(" Items: ");
            } else if (size == 1) {
                list.append("1 Item: ");
            } else {
                list.append("No items.");
                return list.toString();
            }

            if (size > 2) {
                int counter = size;

                for (String itemName : itemNames) {
                    list.append(itemName);
                    counter--;

                    if (counter > 1) {
                        list.append(", ");
                    } else if (counter == 1) {
                        list.append(", & ");
                    } else {
                        list.append(".");
                    }
                }
            } else if (size == 2) {
                list.append(itemNames.get(0)).append(" & ").append(itemNames.get(1)).append(".");
            } else {
                list.append(itemNames.get(0)).append(".");
            }

            return list.toString();
        }

        private static String listDoors(Map<String, DoorDTO> doorInfo) {
            StringBuilder list = new StringBuilder("\n<Doors>\n");

            if (doorInfo.get("north") != null) {
                DoorDTO north = doorInfo.get("north");
                list.append("North: ").append(north.getName());

                if (north.getOtherRoom().isExplored()) {
                    list.append(" (Leads to ").append(north.getOtherRoom().getName()).append(".)\n");
                } else {
                    list.append("\n");
                }
            }

            if (doorInfo.get("south") != null) {
                DoorDTO south = doorInfo.get("south");
                list.append("South: ").append(south.getName());

                if (south.getOtherRoom().isExplored()) {
                    list.append(" (Leads to ").append(south.getOtherRoom().getName()).append(".)\n");
                } else {
                    list.append("\n");
                }
            }

            if (doorInfo.get("east") != null) {
                DoorDTO east = doorInfo.get("east");
                list.append("East: ").append(east.getName());

                if (east.getOtherRoom().isExplored()) {
                    list.append(" (Leads to ").append(east.getOtherRoom().getName()).append(".)\n");
                } else {
                    list.append("\n");
                }
            }

            if (doorInfo.get("west") != null) {
                DoorDTO west = doorInfo.get("west");
                list.append("West: ").append(west.getName());

                if (west.getOtherRoom().isExplored()) {
                    list.append(" (Leads to ").append(west.getOtherRoom().getName()).append(".)\n");
                } else {
                    list.append("\n");
                }
            }

            return list.toString(); 
        }
    }

    /*
     * Text that displays when the player encounters an error, such as typing an unrecognized command or performing an invalid action.
     */
    public static class ErrorText {
        public static final String NO_DOOR = "\nThere isn't a door in that direction.\n\n";

        public static String commandNotRecognized(String command) {
            return "\n\"" + command + "\" is not a recognized command.\n\n";
        }
    }
    
}
