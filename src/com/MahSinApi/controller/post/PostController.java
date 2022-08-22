package com.MahSinApi.controller.post;


import com.MahSinApi.common.ServerAddress;
import com.MahSinApi.model.entity.Post;
import com.MahSinApi.model.service.LikeService;
import com.MahSinApi.model.service.PostService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private LikeService likeService;
    private static String UPLOAD_DIRECTORY = ServerAddress.UPLOAD_DIRECTORY_FOR_POST;
    private static String IMAGE_DIRECTORY=ServerAddress.IMAGE_DIRECTORY_FOR_POST;
    @RequestMapping(value = "/blogger/savePost.do",method = RequestMethod.POST)
    public Object savePost(@ModelAttribute Post post,
                           @RequestParam long userId,
                           @RequestParam CommonsMultipartFile file){
        try {
            post.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(1)
                    .setState("active")
                    .setUser(userService.findOne(userId));
            postService.save(post);
            System.out.println("post has been saved");
            if (file.isEmpty()){}
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+post.getId()+".png"));
                System.out.println("post main picture has been saved");}
            System.out.println(post.toString());
            return findOnePost(post.getId());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping(value = "/blogger/updatePost.do",method = RequestMethod.POST)
    public Object updatePost(@ModelAttribute Post post,
                             @RequestParam long userId,
                             @RequestParam final MultipartFile file){
        try {
            Post post1=postService.findOne(post.getId()).setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(postService.findOne(post.getId()).getRecordControl())
                    .setUser(userService.findOne(userId))
                    .setTitle(post.getTitle())
                    .setWriter(post.getWriter())
                    .setState(post.getState())
                    .setParagraph(post.getParagraph())
                    .setAbstractParagraph(post.getAbstractParagraph());
            postService.update(post1);
            System.out.println("post has been updated");
            if (file.isEmpty()){}
            else{FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+post.getId()+".png"));
                System.out.println("post main picture has been updated");}
            System.out.println(post1.toString());
            return post1;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOnePost.do")
    public Object findOnePost(@RequestParam long id){
        try {
            Post post=postService.findOne(id);
            HashMap<String,Object> map=new HashMap<>();
            map.put("id",post.getId());
            map.put("title",post.getTitle());
            map.put("abstract",post.getAbstractParagraph());
            map.put("date",post.getDate());
            map.put("keywords",post.getKeyWords());
            map.put("image",getPostPicture(post.getId()));
            map.put("paragraphs",post.getParagraph());
            map.put("writer",post.getWriter());
            map.put("references",post.getReferences());
            map.put("likes",likeService.findCountOfActionByPost(post,"like"));
            map .put("paragraphPics",post.getParagraphPics());
            map.put("state",post.getState());
            map.put("user",post.getUser());
            System.out.println("post has been fetched");
            System.out.println(post.toString());
            return map;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllPosts.do")
    public Object findAllPosts(){
        try {
            List<Post> postList=postService.findAll();
            List<Object> posts=new ArrayList<>();

            for(Post p:postList){
                HashMap<String,Object> map=new HashMap<>();
                map.put("id",p.getId());
                map.put("title",p.getTitle());
                map.put("abstract",p.getAbstractParagraph());
                map.put("date",p.getDate());
                map.put("keywords",p.getKeyWords());
                map.put("image",getPostPicture(p.getId()));
                map.put("paragraphs",p.getParagraph());
                map.put("writer",p.getWriter());
                map.put("references",p.getReferences());
                map.put("likes",likeService.findCountOfActionByPost(p,"like"));
                map .put("paragraphPics",p.getParagraphPics());
                map.put("state",p.getState());
                map.put("user",p.getUser());
                posts.add(map);
            }
            System.out.println("All posts have been fetched");
            return posts;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping(value = "/guest/getPostPicture.do")
    public Object getPostPicture(@RequestParam long postId)
            throws IOException {
        File file = new File(UPLOAD_DIRECTORY+postId+".png");
        if(file.exists()) {
            return IMAGE_DIRECTORY+String.valueOf(postId)+".png";
        }
        else {
            return null;
        }
    }
    @RequestMapping("/admin/deletePost.do")
    public Object deletePost(@RequestParam long postId){
        try {
            Post post=postService.findOne(postId);
            if(post.getParagraphPics().isEmpty() && post.getKeyWords().isEmpty()&& post.getReferences().isEmpty()){
            postService.delete(post);
            File file=new File(UPLOAD_DIRECTORY+postId+".png");
            file.delete();
            System.out.println("post has been deleted");
            System.out.println(post.toString());
            return findAllPosts() ;}
            else {
                return new HashMap<>().put("message","post is not empty");
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }

    }
}
