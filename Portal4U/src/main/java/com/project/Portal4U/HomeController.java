package com.project.Portal4U;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    IssueRepo repeIssue;

    @RequestMapping({"/homePage", "/"})
    public ModelAndView homePage() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("status_code", '0');
        return new ModelAndView("homePage", model);
    }

    @RequestMapping("/about")
    public String about(){ return "about";}

    @PostMapping("/status=search")
    public ModelAndView status_search(@RequestParam("homesearch") int id){
        Issue issue = repeIssue.findById(id).orElse(null);
        if(issue==null)return new ModelAndView("redirect:/");
        else {
            System.out.print(issue.toString());
            Map<String, Object> model = new HashMap<String, Object>();
            issueItem tempItem = new issueItem();
            tempItem.setId(issue.getID());
            tempItem.setStatus(issue.getStatus());
            tempItem.setLocation("http://www.google.com/maps/place/"+issue.getLatitude()+","+issue.getLongitude());
            tempItem.setPing(issue.getPing());
            tempItem.setComment(issue.getComment());
            List<String> tempTags = new ArrayList<String>();
            if(issue.isWaste()) tempTags.add("Waste");
            if(issue.isSewage()) tempTags.add("Sewage");
            if(issue.isElectricity()) tempTags.add("Electricity");
            if(issue.isTraffic()) tempTags.add("Traffic");
            if(issue.isEnv()) tempTags.add("Environment");
            if(issue.isProp()) tempTags.add("Public Property");
            if(issue.isOther()) tempTags.add("Other");
            tempItem.setTags(tempTags);

            model.put("issueItem",tempItem);

            model.put("status_code", "1");
            return new ModelAndView("homePage", model);
        }
    }

    @RequestMapping("/status=close")
    public String status_close(){ return "redirect:/";}
}
