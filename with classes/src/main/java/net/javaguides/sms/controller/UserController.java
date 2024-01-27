package net.javaguides.sms.controller;

import net.javaguides.sms.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/teachers")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "teachers"; // Thymeleaf template name
    }

    @GetMapping("/teachers/{id}")
    public String deleteUser(@PathVariable Long id) {
        // Implement the logic to delete the user by ID
        userService.deleteUserById(id);
        return "redirect:/teachers"; // Redirect to the user list page after deletion
    }
}