package com.MahSinApi.controller.user;

import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.entity.Like;
import com.MahSinApi.model.entity.Post;
import com.MahSinApi.model.entity.User;
import com.MahSinApi.model.service.DoctorService;
import com.MahSinApi.model.service.LikeService;
import com.MahSinApi.model.service.PostService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private PostService postService;


    @RequestMapping("user/userLikes.do")
    public Object userLikes(@RequestParam long userId,
                            @RequestParam long doctorId,
                            @RequestParam String actionName){
       try {
            User user= userService.findOne(userId);
            Doctor doctor= doctorService.findOne(doctorId);
            Date date=new Date(System.currentTimeMillis());
            Like like=new Like().setUser(user)
                    .setDoctor(doctor)
                    .setDate(date)
                    .setAction(actionName)
                    .setRecordControl(1);
           try {
                Like like2= likeService.findByUserAndDoctor(user,doctor).setAction(actionName);
                likeService.update(like2);
                System.out.println("user has updated like/dislike");
                System.out.println(like2.toStringDoctor());
                return like;
           }
            catch (Exception e){
                likeService.save(like);
                System.out.println("user has Liked the doctor");
                System.out.println(like.toStringDoctor());
                return like ;
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findLikesByDoctors.do")
    public Object findLikesByDoctors(@RequestParam long doctorId,
                                     @RequestParam String actionName){
        try {
            Doctor doctor=doctorService.findOne(doctorId);
            long countOfAction=likeService.findCountOfActionByDoctor(doctor,actionName);
            System.out.println("the number of "+actionName+"for doctor "+doctor.getId()+" is "+countOfAction );
            return countOfAction;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/admin/findAllLikes")
    public Object findAllLikes(){
        try {
            return likeService.findAll();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("user/userLikesPost.do")
    public Object userLikesPost(@RequestParam long userId,
                            @RequestParam long postId,
                            @RequestParam String actionName){
        try{
            User user= userService.findOne(userId);
            Post post= postService.findOne(postId);
            Date date=new Date(System.currentTimeMillis());
            Like like=new Like().setUser(user)
                    .setPost(post)
                    .setDate(date)
                    .setAction(actionName)
                    .setRecordControl(1);
            try {
                Like like2= likeService.findByUserAndPost(user,post).setAction(actionName);
                likeService.update(like2);
                System.out.println("user has updated like/dislike");
                System.out.println(like2.toStringPost());
                return like;
            }
            catch (Exception e){
                likeService.save(like);
                System.out.println("user has Liked the post");
                System.out.println(like.toStringPost());
                return like ;
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findLikesByPost.do")
    public Object findLikesByPost(@RequestParam long postId,
                                     @RequestParam String actionName){
        try {
            Post post=postService.findOne(postId);
            long countOfAction=likeService.findCountOfActionByPost(post,actionName);
            System.out.println("the number of "+actionName+"for post "+post.getId()+" is "+countOfAction );
            return countOfAction;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/viewer/findOneUser.do")
    public Object findOneUser(@RequestParam long userId){
        try {
            return userService.findOne(userId);
        }
        catch (Exception e){
            return e;
        }
    }
}
