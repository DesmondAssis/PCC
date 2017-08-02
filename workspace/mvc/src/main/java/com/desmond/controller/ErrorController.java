package com.desmond.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by presleyli on 2017/7/14.
 */
@Controller
public class ErrorController {
    @RequestMapping("/_error")
    public ModelAndView render(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print("Error Page!");

        return null;
    }
}
