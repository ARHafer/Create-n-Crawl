package com.arhafer.backend.game.engine;

import com.arhafer.backend.game.dto.RoomDTO;
import com.arhafer.backend.game.model.Player;
import com.arhafer.backend.game.model.Player.DoorResult;
import com.arhafer.backend.game.text.TextBank;

public class CommandProcessor {
    private final Player player;

    public CommandProcessor(Player player) {
        this.player = player;
    }

    public String processCommand(String command) {
        command = command.trim().toLowerCase();

        if (command.equals("look")) {
            RoomDTO room = player.getRoom().convertToDTO();
            return TextBank.FeedbackText.describeRoom(room);
        }

        if (command.equals("north") || command.equals("south") || command.equals("east") || command.equals("west")) {
            return handleMovement(command);
        }

        else return TextBank.ErrorText.commandNotRecognized(command);
    }

    private String handleMovement(String direction) {
        DoorResult result = player.enterDoor(direction);
        RoomDTO room = player.getRoom().convertToDTO();

        return switch (result) {
            case SUCCESS -> TextBank.FeedbackText.describeRoom(room);
            case NO_DOOR -> TextBank.ErrorText.NO_DOOR;
        };
    }
    
}
