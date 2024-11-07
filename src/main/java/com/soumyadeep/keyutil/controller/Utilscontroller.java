package com.soumyadeep.keyutil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soumyadeep.keyutil.service.UtilsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Utilscontroller {
    
    private final UtilsService utilsService;

    @GetMapping("/keyremove")
    public String responseString(){
        return utilsService.removeKeyJsonString();
    }

}
