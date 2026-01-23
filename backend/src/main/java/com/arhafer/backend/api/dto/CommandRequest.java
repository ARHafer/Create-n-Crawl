package com.arhafer.backend.api.dto;

/*
 * Represents a command sent by the client to be processed by the backend.
 */

public class CommandRequest {
    private String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

}
