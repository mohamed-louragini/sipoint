package com.sirocu.sipoint.exception;

/**
 * @author Mohamed Louragini
 * @version 1.0
 * @since 8/9/2024
 */
public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }

    public ApiException() {
        super("An error occurred");
    }
}
