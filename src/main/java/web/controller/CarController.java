package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import web.servise.CarServiceImpl;

@Controller
public class CarController {

    private final CarServiceImpl carService;

    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCarsParam(Model model, @RequestParam(defaultValue = "5") int age) {
        model.addAttribute("car", carService.printCarsParam(age));
        return "cars";
    }
}
