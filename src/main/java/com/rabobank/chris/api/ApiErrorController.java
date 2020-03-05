package com.rabobank.chris.api;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = "/error")
    public String genericError() {
        return "Something went wrong. Check if the url is valid";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
