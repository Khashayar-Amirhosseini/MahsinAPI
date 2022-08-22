package com.MahSinApi.controller.goal;
import com.MahSinApi.common.ServerAddress;
import com.MahSinApi.model.entity.Goal;
import com.MahSinApi.model.service.GoalService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
public class GoalController {
    @Autowired
    private GoalService goalService;
    @Autowired
    private UserService userService;
    private static String UPLOAD_DIRECTORY = ServerAddress.UPLOAD_DIRECTORY;
    private static String IMAGE_DIRECTORY=ServerAddress.IMAGE_DIRECTORY;
    @RequestMapping(value = "/goal/saveGoal.do",method = RequestMethod.POST)
    public Object saveGoal(@ModelAttribute Goal goal,
                           @RequestParam long userId,
                           @RequestParam CommonsMultipartFile file){
        try {
            goal.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(1)
                    .setState("active")
                    .setUser(userService.findOne(userId));
            goalService.save(goal);
            System.out.println("goal has been saved");
            if (file.isEmpty()){}
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+goal.getId()+".png"));
                System.out.println("goal picture has been saved");}
            System.out.println(goal.toString());
            return goal;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping(value = "/goal/updateGoal.do",method = RequestMethod.POST)
    public Object updateGoal(@ModelAttribute Goal goal,
                             @RequestParam long userId,
                             @RequestParam final MultipartFile file){
        try {
            goal.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(goalService.findOne(goal.getId()).getRecordControl())
                    .setUser(userService.findOne(userId));
            goalService.update(goal);
            System.out.println("goal has been updated");
            if (file.isEmpty()){}
            else{FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+goal.getId()+".png"));
                System.out.println("doctor picture has been updated");}
            System.out.println(goal.toString());
            return goal;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOneGoal.do")
    public Object findOneGoal(@RequestParam long id){
        try {
            Goal goal=goalService.findOne(id);
            HashMap<String,Object> map=new HashMap<>();
            map.put("id",goal.getId());
            map.put("description",goal.getDescription());
            map.put("date",goal.getDate());
            map.put("state",goal.getState());
            map.put("user",goal.getUser());
            map.put("image",getGoalPicture(goal.getId()));
            System.out.println("goal has been fetched");
            System.out.println(goal.toString());
            return map;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllGoals.do")
    public Object findAllGoals(){
        try {
            List<Goal> goalList=goalService.findAll();
            List<Object> goals=new ArrayList<>();

            for(Goal g:goalList){
                HashMap<String,Object> map=new HashMap<>();
                map.put("id",g.getId());
                map.put("description",g.getDescription());
                map.put("date",g.getDate());
                map.put("state",g.getState());
                map.put("image",getGoalPicture(g.getId()));
                map.put("user",g.getUser());
                goals.add(map);
            }
            System.out.println("All goals have been fetched");
            return goals;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping(value = "/guest/getGoalPicture.do")
    public Object getGoalPicture(@RequestParam long goalId)
            throws IOException {
        File file = new File(UPLOAD_DIRECTORY+goalId+".png");
        if(file.exists()) {
            return IMAGE_DIRECTORY+String.valueOf(goalId)+".png";
        }
        else {
            return null;
        }
    }
    @RequestMapping("/admin/deleteGoal.do")
    public Object deleteGoal(@RequestParam long goalId){
        try {
            Goal goal=goalService.findOne(goalId);
            goalService.delete(goal);
            File file=new File(UPLOAD_DIRECTORY+goalId+".png");
            file.delete();
            System.out.println("goal has been deleted");
            System.out.println(goal.toString());
            return findAllGoals() ;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
}
