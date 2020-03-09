package com.example.securingweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomErrorController implements ErrorController {
	
	private static final String ERRORPATH = "/error";
	
	@RequestMapping(value = ERRORPATH)
	public ResponseEntity<String> error(HttpServletRequest request, HttpServletResponse response) {	
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		return new ResponseEntity<>("Error", HttpStatus.valueOf(statusCode));
	}

	@Override
	public String getErrorPath() {
		return ERRORPATH;
	}

}
