package infinitygalaxy1001.uz.infinitygalaxy1001.controller;

import infinitygalaxy1001.uz.infinitygalaxy1001.entity.Users;
import infinitygalaxy1001.uz.infinitygalaxy1001.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/getallusers")
    public void getAllUsers() {
        System.out.println(service.getAllUsers().toString());
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @GetMapping("/sign_up")
    public String signUp() {
        return "sign_up";
    }
    @GetMapping("/login")
    public String logIn() {
        return "form";
    }
    @PostMapping("/login")
    public String login(@RequestParam String firstName, @RequestParam String phoneNumber) {
        List<Users> allUsers = service.getAllUsers();
        for (Users x : allUsers) {
            if (x.getFirstName().equals(firstName) && x.getPhoneNumber().equals(phoneNumber)) {
                return "custom_page";
            }
        }
        return "login";
    }
    @PostMapping("/createuser")
    public String createUser(@RequestParam String firstName, @RequestParam String lastName,
                             @RequestParam String phoneNumber) {
        Users users = new Users();
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setPhoneNumber(phoneNumber);
        service.save(users);
        return "redirect:/api/login";
    }
}
