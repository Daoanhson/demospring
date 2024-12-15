package com.demospring.dto.response;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ResponseSuccess extends ResponseEntity<ResponseSuccess.Payload> {

// Constuctor show for API PUT, PATCH, DELETE (ko tra ve gi)
    public ResponseSuccess(HttpStatusCode status, String message) {
        super(new Payload(status.value(),message),HttpStatus.OK);
    }

// Constructor show for POST, GET,
    public ResponseSuccess(HttpStatusCode status, String message, Object data){
        super(new Payload(status.value(),message), HttpStatus.OK);
    }

    public static class Payload {
        private final int status;
        private final String message;
        private Object data;

        public Payload(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public Payload(int status, String message, Object data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public Object getData() {
            return data;
        }
    }
}
