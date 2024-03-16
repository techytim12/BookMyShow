package com.scaler.BookMyShow.controller;

import com.scaler.BookMyShow.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @Autowired
    private InitService initService;

    @GetMapping("/init")
    public ResponseEntity initApplication(){
        initService.initialize();
        return ResponseEntity.ok("Initialization Done");
    }
}
