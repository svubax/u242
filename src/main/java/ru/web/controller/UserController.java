package ru.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.web.model.User;
import ru.web.service.RoleService;
import ru.web.service.UserService;

import java.security.Principal;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private final UserService userService;
    private final RoleService roleService;
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping("/")
    public String index() {
        return "login";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/user")
    public String user(Model model, Principal principal){
        model.addAttribute("user", userService.getUser(principal.getName()));
        return "user";
    }
    @GetMapping("/admin")
    public String admin(@ModelAttribute("newUser") User newUser, Model model) {
        model.addAttribute("users", userService.getUsers());
        model.addAttribute("roles", roleService.getRoles());
        return "admin";
    }
    @PostMapping("/admin/add")
    public String create(User user, @RequestParam(value = "rolesAdd") String... roles){
        user.setRoles(Arrays.stream(roles).map(roleService::getRole).collect(Collectors.toSet()));
        userService.addUser(user);
        return "redirect:/admin";
    }
    @DeleteMapping("/admin/delete/{id}")
    public String delete(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }
    @GetMapping("/admin/update/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("roles", roleService.getRoles());
        return "update";
    }
    @PatchMapping("/admin/update")
    public String update(User user, @RequestParam(value = "rolesUpdate") String... roles){
        user.setRoles(Arrays.stream(roles).map(roleService::getRole).collect(Collectors.toSet()));
        userService.updateUser(user);
        return "redirect:/admin";
    }
}
