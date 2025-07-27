package org.kociemba.twophase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CubeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("cubeState", "UUUUUUUUURRRRRRRRRFFFFFFFFFDDDDDDDDDLLLLLLLLLBBBBBBBBB");
        return "cube";
    }

    @PostMapping("/scramble")
    public String scramble(Model model) {
        model.addAttribute("cubeState", Tools.randomCube());
        return "cube";
    }

    @PostMapping("/solve")
    public String solve(@RequestParam String cubeState, Model model) {
        String solution = Search.solution(cubeState, 21, 5000, false);
        model.addAttribute("cubeState", cubeState);
        model.addAttribute("solution", solution);
        return "cube";
    }
}