package com.qa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A ticket with the entered ID does not exist.")
public class TicketNotFoundException extends RuntimeException {

}
