package com.MahSinApi.controller.reference;

import com.MahSinApi.model.entity.KeyWords;
import com.MahSinApi.model.entity.Post;
import com.MahSinApi.model.entity.Reference;
import com.MahSinApi.model.service.PostService;
import com.MahSinApi.model.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ReferenceController {
    @Autowired
    private ReferenceService referenceService;
    @Autowired
    private PostService postService;
    @RequestMapping("/blogger/saveReference.do")
    public Object saveReference(@ModelAttribute Reference reference,
                              @RequestParam long postId){
        try {

            Post post=postService.findOne(postId);
            post.getReferences().add(reference);
            referenceService.save(reference);
            postService.update(post);
            System.out.println("reference has been saved");
            System.out.println(reference.toString());
            return reference;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/blogger/updateReference.do")
    public Object updateReference(@ModelAttribute Reference reference)
    {
        try {
            referenceService.update(reference);
            System.out.println("reference has been updated");
            System.out.println(reference.toString());
            return findOneReference(reference.getId());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOneReference.do")
    public Object findOneReference(@RequestParam long id){
        try {
            Reference reference=referenceService.findOne(id);
            System.out.println("reference has been fetched");
            System.out.println(reference.toString());
            return reference;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllReferences.do")
    public Object findAllReferences(){
        try {
            List<Reference> referenceList=referenceService.findAll();
            System.out.println("All references have been fetched");
            return referenceList;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/blogger/deleteReference.do")
    public Object deleteReference(@RequestParam long referenceId){
        try {
            Reference reference=referenceService.findOne(referenceId);
            referenceService.delete(reference);
            System.out.println(reference.toString());
            System.out.println("the mentioned reference has been deleted");
            return new HashMap<>().put("message","reference was deleted");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
}

