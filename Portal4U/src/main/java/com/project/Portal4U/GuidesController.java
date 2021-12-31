package com.project.Portal4U;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuidesController {

    @RequestMapping("/documents")
    public String documents(){
        return "guides";
    }

}
