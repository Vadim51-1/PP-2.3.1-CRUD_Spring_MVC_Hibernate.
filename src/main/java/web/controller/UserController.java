package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.models.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("people")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("people", service.getAllUsers());
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", service.showUser(id));
        return "showUser";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("person") User user) {

        return "newUser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("person") @Valid User user,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newUser";

        service.saveUser(user);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", service.showUser(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("person") @Valid User user, BindingResult bindingResult,
                             @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "editUser";

        service.updateUser(id, user);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        service.deleteUser(id);
        return "redirect:/people";
    }
}