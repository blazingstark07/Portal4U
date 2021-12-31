package com.project.Portal4U;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class MuncipalController {
    private int login_code = 0;

    @Autowired
    IssueRepo repoIssue;

    @RequestMapping("/login")
    public ModelAndView login(){
        System.out.print(login_code);
        if(login_code==1)return new ModelAndView("redirect:/mun");

        String viewName = "login";
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("isError", "0");
        return new ModelAndView(viewName , model);

    }

    @PostMapping("/valid")
    public ModelAndView valid(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.print(username+password);
        if(username.equals("admin") && password.equals("admin")){
            login_code = 1;
            return new ModelAndView("redirect:/mun");
        }
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("isError", "1");
        return new ModelAndView("login" , model);
    }

    @PostMapping("/status=ongoing")
    public ModelAndView status_o(@RequestParam("id_o") int id){
        if(login_code==0)return new ModelAndView("redirect:/login");
        Issue issue = repoIssue.findById(id).orElse(null);
        if(issue!=null){
            issue.setStatus("ONGOING");
            repoIssue.save(issue);
        }
        return new ModelAndView("redirect:/mun");
    }

    @PostMapping("/status=solved")
    public ModelAndView status_s(@RequestParam("id_s") int id){
        if(login_code==0)return new ModelAndView("redirect:/login");
        Issue issue = repoIssue.findById(id).orElse(null);
        if(issue!=null){
            issue.setStatus("SOLVED");
            repoIssue.save(issue);
        }
        return new ModelAndView("redirect:/mun");
    }

    @PostMapping("/status=planning")
    public ModelAndView status_p(@RequestParam("id_p") int id){
        if(login_code==0)return new ModelAndView("redirect:/login");
        Issue issue = repoIssue.findById(id).orElse(null);
        if(issue!=null){
            issue.setStatus("PLANNING");
            repoIssue.save(issue);
        }
        return new ModelAndView("redirect:/mun");
    }

    @PostMapping("/update=comment")
    public ModelAndView update_comment(@RequestParam("id_comment") int id,@RequestParam("comment") String comment){
        if(login_code==0)return new ModelAndView("redirect:/login");
        Issue issue = repoIssue.findById(id).orElse(null);
        if(issue!=null){
            issue.setComment(comment);
            repoIssue.save(issue);
        }
        return new ModelAndView("redirect:/mun");
    }

    @RequestMapping("/mun")
    public ModelAndView mun(){
        if(login_code==0)return new ModelAndView("redirect:/login");

        List<issueItem> issueList = new ArrayList<issueItem>();

        Map<String, Object> model = new HashMap<String, Object>();

        for(Issue issue : repoIssue.findAll()) {
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
            issueList.add(tempItem);
            for(String t : tempTags)System.out.print(t);
        }

        for(int i=0;i<issueList.size();i++){
            for(int j=i;j<issueList.size();j++){
                if(issueList.get(j).getPing()>issueList.get(i).getPing()){
                    Collections.swap(issueList,i,j);
                }
            }
        }


        model.put("issueList",issueList);

        return new ModelAndView("issueList",model);
    }

    @RequestMapping("/logout")
    public String logout(){
        login_code = 0;
        return "redirect:/";
    }

    @RequestMapping("/news_update")
    public String news_update(){
        return "newsUpdate";
    }
}
