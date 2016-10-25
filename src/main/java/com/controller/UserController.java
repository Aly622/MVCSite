/**
 *
 */
package com.controller;

import com.model.User;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Oliver.Liu
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public HttpSession session;
    @Resource
    private IUserService userService;
    @RequestMapping(value = "/showUser",method = RequestMethod.GET)
    public ModelAndView showUser(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView("footer");
        long userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.findById(userId);
        mv.addObject("user", user);
        return mv;
    }
    @RequestMapping(value = { "" }, method = { RequestMethod.GET })
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("user/index");
        User user = new User();
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = { "create" }, method = { RequestMethod.GET })
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("user/create");
        User user = new User();
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = { "create" }, method = { RequestMethod.POST })
    public ModelAndView create(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView = new ModelAndView("user/create_success");
        this.userService.addUser(user);
        return modelAndView;
    }

    @RequestMapping(value = { "login" }, method = { RequestMethod.GET })
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("user/login");
        User user = new User();
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = { "login" }, method = { RequestMethod.POST })
    public void login(@ModelAttribute("user") User _user,
                      HttpServletResponse response) throws IOException {
        User user = this.userService.findByEmailAndPassword(_user.getEmail(),
                _user.getPassword());
        if (user == null) {
            response.sendRedirect("/user/login.action");
            session.setAttribute("login_error", "邮箱或密码错误");
            return;
        }
        session.setAttribute("sessionUser", user);
        response.sendRedirect("/user.action");
    }

    @RequestMapping(value = { "logout" }, method = { RequestMethod.GET })
    public void logout(HttpServletResponse response) throws IOException {
        session.removeAttribute("sessionUser");
        response.sendRedirect("/user.action");
    }
}
