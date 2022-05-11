package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Hello World!";
    }

    @GetMapping("/read")
    public List<String> getFileContent(@RequestParam("path")String path) throws IOException {
        if(Files.exists(Paths.get(path))){
            return Files.readAllLines(Paths.get(path));
        }else{
            return Collections.singletonList("File "+path+" doesn't exist");
        }

    }
}
