package com.arhafer.backend.api.dto;

/*
 * Represents a response sent by the backend to the client after processing a command.
 */

public class CommandResponse {
    private String output;

    public CommandResponse(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

}
