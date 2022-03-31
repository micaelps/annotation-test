package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @PostMapping("/teste")
    public  Map<String, String> valida_teste(@RequestBody @Valid CompradorRequest request){
        return new HashMap<>();
    }
}
