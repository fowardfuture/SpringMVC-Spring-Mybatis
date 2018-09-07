package com.action.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EveryController {
    @RequestMapping("/{formname}")
    public String logForm(@PathVariable String formname)
    {return formname;}
}
