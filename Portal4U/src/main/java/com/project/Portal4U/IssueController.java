package com.project.Portal4U;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IssueController {
    @Autowired
    IssueLogRepo repoIssueLog;
    @Autowired
    IssueRepo repoIssue;

    @RequestMapping("/userIssue")
    public String userIssue() {
        return "userIssues";
    }

    @RequestMapping("/addIssue")
    public ModelAndView addIssue(UserIssue user_issue){
        if(user_issue.getName() == null)
            return new ModelAndView("redirect:/");
        String name = user_issue.getName();
        String email = user_issue.getEmail();
        String details = user_issue.getDetails();
        double longitude = Double.parseDouble(user_issue.getLongitude());
        double latitude = Double.parseDouble(user_issue.getLatitude());
        boolean waste = user_issue.getIssue1()!=null;
        boolean sewage = user_issue.getIssue2()!=null;
        boolean electricity = user_issue.getIssue3()!=null;
        boolean traffic = user_issue.getIssue4()!=null;
        boolean env = user_issue.getIssue5()!=null;
        boolean prop = user_issue.getIssue6()!=null;
        boolean other = user_issue.getIssue7()!=null;

//        System.out.print(user_issue.toString());
        boolean exists = false;
        Issue existed_issue = new Issue();
        int c_id;
        for(Issue issue : repoIssue.findAll()) {
            if(issue == null)
                break;
            if(Math.abs(longitude-Double.parseDouble(issue.getLongitude()))<0.01 && Math.abs(latitude-Double.parseDouble(issue.getLatitude()))<0.01
                    && details.equals(issue.getDetails()) && waste==issue.isWaste() &&
                    sewage==issue.isSewage() && electricity==issue.isElectricity() && traffic==issue.isTraffic() &&
                    env==issue.isEnv() && prop==issue.isProp() && other==issue.isOther()){
                existed_issue = issue;
                exists = true;
                break;
            }
        }
        if(exists)
        {
            Issue issue = repoIssue.findById(existed_issue.getID()).orElse(null);
            IssueLog issue_log = repoIssueLog.findById(existed_issue.getID()).orElse(null);
            c_id = existed_issue.getID();
            if(issue!=null){
                issue.increasePing(20);
                repoIssue.save(issue);
            }
            if(issue_log!=null)
            {
                issue_log.addName(name);
                issue_log.addEmail(email);
                repoIssueLog.save(issue_log);
            }
        }
        else {
            Issue issue = new Issue();
            IssueLog issue_log = new IssueLog();
            Issue.setCurrID(Issue.getCurrID()+1);
            issue.setID();
            issue.setDetails(details);
            issue.setLongitude(user_issue.getLongitude());
            issue.setLatitude(user_issue.getLatitude());
            issue.setWaste(waste);
            issue.setSewage(sewage);
            issue.setElectricity(electricity);
            issue.setTraffic(traffic);
            issue.setEnv(env);
            issue.setProp(prop);
            issue.setOther(other);
            issue.setPing(1);
            issue.setStatus("SEEN");
            issue.setComment("Comment");
            issue_log.setID(Issue.getCurrID());
            issue_log.addName(name);
            issue_log.addEmail(email);
            repoIssueLog.save(issue_log);
            repoIssue.save(issue);
            c_id=issue.getID();
        }
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("ID",c_id);
        return new ModelAndView("tick",model);
    }
}
