package com.MahSinApi.controller.keyword;

import com.MahSinApi.model.entity.KeyWords;
import com.MahSinApi.model.entity.MainService;
import com.MahSinApi.model.entity.Post;
import com.MahSinApi.model.entity.Service;
import com.MahSinApi.model.service.KeywordService;
import com.MahSinApi.model.service.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class KeywordController {
    @Autowired
    private KeywordService keywordService;
    @Autowired
    private PostService postService;
    @RequestMapping("/blogger/saveKeyword.do")
    public Object saveKeyword(@ModelAttribute KeyWords keyWords,
                              @RequestParam long postId){
        try {

            Post post=postService.findOne(postId);
            post.getKeyWords().add(keyWords);
            keywordService.save(keyWords);
            postService.update(post);
            System.out.println("keyword has been saved");
            System.out.println(keyWords.toString());
            return keyWords;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/blogger/updateKeyword.do")
    public Object updateKeyword(@ModelAttribute KeyWords keyWords)
    {
        try {
            keywordService.update(keyWords);
            System.out.println("keyword has been updated");
            System.out.println(keyWords.toString());
            return findOneKeyword(keyWords.getId());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOneKeyword.do")
    public Object findOneKeyword(@RequestParam long id){
        try {
            KeyWords keyWords=keywordService.findOne(id);
            System.out.println("keyword has been fetched");
            System.out.println(keyWords.toString());
            return keyWords;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllKeywords.do")
    public Object findAllKeywords(){
        try {
            List<KeyWords> keyWordsList=keywordService.findAll();
            System.out.println("All keywords have been fetched");
            return keyWordsList;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/blogger/deleteKeyword.do")
    public Object deleteKeyword(@RequestParam long keywordId){
        try {
            KeyWords keyWords=keywordService.findOne(keywordId);
            keywordService.delete(keyWords);
            System.out.println(keyWords.toString());
            System.out.println("the mentioned keyword has been deleted");
            return findAllKeywords();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
}
