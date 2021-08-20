package com.openlab.controller;

import com.openlab.pojo.User;
import com.openlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/managerUser")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUserList(Model model){
        List<User> userList = userService.getUserList();
        model.addAttribute("page",userList);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd";  //跳转到userAdd页面
    }

    @RequestMapping("/add")
    public String createUser(User user){
        userService.createUser(user);
        return "redirect:/managerUser/";
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id")Long id){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "user/userEdit";  //跳转到userEdit.html
    }

    @RequestMapping("/edit")
    public String edit(User user){
        userService.updateUser(user.getId(),user);
        return "redirect:/managerUser/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        userService.delteById(id);
        return "redirect:/managerUser/";
    }

}
