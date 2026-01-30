package org.projekti.babai.controller.Babai;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    // Use mutable list to allow modifications
    private static final List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    // Example 1: simple GET
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Babai controller!";
    }

    // GET endpoint returning HTML with rainbow and sunshine
    @GetMapping(value = "/html", produces = "text/html")
    public String hello2() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>Babai Sunshine ☀️</title>
            <style>
                body {
                    height: 100vh;
                    margin: 0;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    background: linear-gradient(
                        90deg,
                        red, orange, yellow, green, cyan, blue, violet
                    );
                    font-family: Arial, sans-serif;
                    color: white;
                    text-shadow: 2px 2px 4px #000;
                }
                h1 {
                    font-size: 3rem;
                }
            </style>
        </head>
        <body>
            <h1>🌈 Hello from Babai Controller ☀️</h1>
        </body>
        </html>
        """;
    }

    // Example 2: POST endpoint
    @PostMapping("/echo")
    public String echo(@RequestBody String message) {
        return "You sent: " + message;
    }

    @GetMapping("/error")
    public String error() {
        return "Wow an error!";
    }

    // DELETE endpoint: remove max element from the list
    @DeleteMapping("/deleteMax")
    public List<Integer> deleteMaxElement() {
        return removeMax();
    }

    // Utility method
    private static List<Integer> removeMax() {
        if (Controller.list.isEmpty()) {
            return Collections.emptyList();
        }
        int max = Collections.max(Controller.list);
        Controller.list.remove((Integer) max); // remove first occurrence of max
        return new ArrayList<>(Controller.list); // return a copy
    }

    @GetMapping("/test")
    public String test() {
        return "Wow a test!";
    }
}

//janaqi eshte djale i mire