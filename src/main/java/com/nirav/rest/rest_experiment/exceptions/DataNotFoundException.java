package com.nirav.rest.rest_experiment.exceptions;

public class DataNotFoundException extends RuntimeException
{

    public DataNotFoundException(String message_not_found) {
        super(message_not_found);
    }
}
