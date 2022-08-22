package com.MahSinApi.controller.achievement;

import com.MahSinApi.model.entity.Achievement;
import com.MahSinApi.model.entity.Policy;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.service.AchievementService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AchievementController {
    @Autowired
    private AchievementService achievementService;
    @Autowired
    private UserService userService;
    @RequestMapping("/achievement/achievementSave.do")
    public Object achievementSave(@ModelAttribute Achievement achievement,
                                  @RequestParam long userId){
        try {
            User user=userService.findOne(userId);
            Date date=new Date(System.currentTimeMillis());
            achievement.setDate(date).setUser(user)
                    .setRecordControl(1)
                    .setState("active");
            achievementService.save(achievement);
            System.out.println("Achievement has been saved");
            System.out.println(achievement.toString());
            return achievement;
        }
        catch (Exception e){
            System.out.println(e.toString());
            return e;
        }
    }
    @RequestMapping("/achievement/achievementUpdate.do")
    public Object achievementUpdate(@ModelAttribute Achievement achievement,
                                    @RequestParam long userId){
        try {
            achievement.setUser(userService.findOne(userId))
                    .setRecordControl(achievementService.findOne(achievement.getId()).getRecordControl())
                    .setDate(new Date(System.currentTimeMillis()));
            System.out.println(achievement.toString());
            achievementService.update(achievement);
            System.out.println("achievement has been updated");
            System.out.println(achievement.toString());
            return achievement;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOneAchievement.do")
    public Object findOneAchievement(@RequestParam long id){
        try {
            Achievement achievement=achievementService.findOne(id);
            System.out.println("the achievement has been fetches");
            System.out.println(achievement.toString());
            return achievement;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllAchievement.do")
    public Object findAllAchievement(){
        try {
            List<Achievement> achievementList=achievementService.findAll();
            System.out.println("All Achievements have been fetched");
            return achievementList;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/admin/deleteAchievement.do")
    public Object deleteAchievement(@RequestParam long achievementId){
        try {
            Achievement achievement=achievementService.findOne(achievementId);
            achievementService.delete(achievement);
            System.out.println("achievement has been deleted");
            System.out.println(achievement.toString());
            return findAllAchievement() ;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }

}
