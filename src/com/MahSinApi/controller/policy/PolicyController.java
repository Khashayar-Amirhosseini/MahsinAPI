package com.MahSinApi.controller.policy;

import com.MahSinApi.model.entity.Achievement;
import com.MahSinApi.model.entity.Goal;
import com.MahSinApi.model.entity.Policy;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.service.PolicyService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
public class PolicyController {
    @Autowired
    private PolicyService policyService;
    @Autowired
    private UserService userService;
    @RequestMapping("/policy/savePolicy.do")
    public Object savePolicy(@ModelAttribute Policy policy,
                             @RequestParam long userId){
        try {
            policy.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(1)
                    .setState("active")
                    .setUser(userService.findOne(userId));
            policyService.save(policy);
            System.out.println("policy has been saved");
            System.out.println(policy.toString());
            return policy;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/policy/updatePolicy.do")
    public Object updatePolicy(@ModelAttribute Policy policy,
                             @RequestParam long userId){
        try {
            policy.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(policyService.findOne(policy.getId()).getRecordControl())
                    .setUser(userService.findOne(userId));
            policyService.update(policy);
            System.out.println("policy has been updated");
            System.out.println(policy.toString());
            return policy;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOnePolicy.do")
    public Object findOnePolicy(@RequestParam long id){
        try {
            Policy policy=policyService.findOne(id);
            System.out.println("policy has been fetched");
            System.out.println(policy.toString());
            return policy;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllPolicies.do")
    public Object findAllPolicies(){
        try {
            List<Policy> policyList=policyService.findAll();
            System.out.println("All policies have been fetched");
            return policyList;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/admin/deletePolicy.do")
    public Object deletePolicy(@RequestParam long policyId){
        try {
            Policy policy=policyService.findOne(policyId);
                policyService.delete(policy);
            System.out.println("policy has been deleted");
            System.out.println(policy.toString());
            return findAllPolicies() ;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }



}
