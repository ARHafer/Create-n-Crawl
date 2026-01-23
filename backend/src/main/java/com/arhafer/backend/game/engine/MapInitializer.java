package com.arhafer.backend.game.engine;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.stereotype.Component;

import com.arhafer.backend.game.model.Player;
import com.arhafer.backend.xml.MapHandler;

@Component
public class MapInitializer {
    private final CommandProcessor commandProcessor;

    public MapInitializer() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        InputStream mapFile = MapInitializer.class.getResourceAsStream("/maps/test_map.xml"); // Using a test file for now.

        try {
            SAXParser parser = factory.newSAXParser();
            MapHandler handler = new MapHandler();

            parser.parse(mapFile, handler);

            Player player = handler.getPlayer();
            commandProcessor = new CommandProcessor(player);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse map file: " + e.getMessage());
        }
    }

    public CommandProcessor getCommandProcessor() {
        return commandProcessor;
    }

}
