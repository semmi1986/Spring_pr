package project.people.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.people.DAO.UserDAO;
import project.people.models.User;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String users(Model model){

        model.addAttribute("users", userDAO.getUsers());
        return "Users";

    };

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userDAO.getUserById(id));
//        System.out.println(id);
        return "UserId";
    }
    @GetMapping("/new")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "UserForm";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user){
        userDAO.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userDAO.getUserById(id));
        return "Edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user){
        userDAO.updateUserById(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userDAO.deleteUserById(id);
        return "redirect:/users";
    }

}
