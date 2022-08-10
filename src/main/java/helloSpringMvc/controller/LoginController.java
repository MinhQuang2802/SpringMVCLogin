package helloSpringMvc.controller;

import helloSpringMvc.model.LoginBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response, Model model) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String message;
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);
        LoginBean bean = new LoginBean();
        bean.setName(userName);
        bean.setPassword(password);
        request.setAttribute("bean", bean);


    if(userName != null &&
                !userName.equals("")
                && userName.equals("quang") &&
                password != null &&
                !password.equals("") &&
                password.equals("123")){
            message = "Welcome " +userName + ".";
            return new ModelAndView("login-success",
                    "message", message);

        }else{
            message = "Wrong username or password.";
            return new ModelAndView("login-error",
                    "message", message);
        }
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login1(HttpServletRequest request,
                      HttpServletResponse response, Model model) throws ServletException, IOException {

        return "index";
    }
    @RequestMapping(value = "ajax", method = RequestMethod.GET,produces = { MimeTypeUtils.TEXT_PLAIN_VALUE })
    public ResponseEntity<String> ajax(HttpServletRequest request,
                         HttpServletResponse response, Model model) throws ServletException, IOException {
        ResponseEntity<String> responseEntity = new ResponseEntity<String>("Day la Ajax", HttpStatus.OK);

        return responseEntity;

    }
}