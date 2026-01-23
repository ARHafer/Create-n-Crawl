package com.arhafer.backend.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arhafer.backend.api.dto.CommandRequest;
import com.arhafer.backend.api.dto.CommandResponse;
import com.arhafer.backend.game.engine.CommandProcessor;
import com.arhafer.backend.game.engine.MapInitializer;

@RestController
@RequestMapping("/game")
public class GameController {
    private final CommandProcessor commandProcessor;

    public GameController(MapInitializer mapInitializer) {
        this.commandProcessor = mapInitializer.getCommandProcessor();
    }

    @PostMapping("/command")
    public CommandResponse processCommand(@RequestBody CommandRequest request) {
        String output = commandProcessor.processCommand(request.getCommand());
        return new CommandResponse(output);
    }

}
