package com.MahSinApi.controller.paragraphPic;
import com.MahSinApi.common.ServerAddress;
import com.MahSinApi.model.entity.ParagraphPic;
import com.MahSinApi.model.entity.Post;
import com.MahSinApi.model.service.ParagraphPicService;
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
import java.util.HashMap;
import java.util.List;

@RestController
public class ParagraphPicController {
    @Autowired
    private ParagraphPicService paragraphService;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    private static String UPLOAD_DIRECTORY = ServerAddress.getInstance().UPLOAD_DIRECTORY_FOR_PARAGRAPHS_PICTURE;
    private static String IMAGE_DIRECTORY=ServerAddress.getInstance().IMAGE_DIRECTORY_FOR_PARAGRAPHS_PICTURE;
    @RequestMapping(value = "/blogger/saveParaghraphPic.do",method = RequestMethod.POST)
    public Object saveParagraph(@ModelAttribute ParagraphPic paragraphPic,
                           @RequestParam long postId,
                           @RequestParam CommonsMultipartFile file){
        try {
            paragraphPic.setRecordControl(1);

            paragraphService.save(paragraphPic);
            Post post=postService.findOne(postId);
            post.getParagraphPics().add(paragraphPic);
            postService.update(post);
            if (file.isEmpty()){
                System.out.println("file is empty");
            }
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY + paragraphPic.getId() + ".png"));;
                System.out.println("paragraph picture has been saved");
               }
            System.out.println(paragraphPic.toString());
            HashMap<String,Object> map=new HashMap<String,Object>();
            map.put("id",paragraphPic.getId());
            map.put("link",IMAGE_DIRECTORY+paragraphPic.getId()+".png");
            return map;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }

    @RequestMapping("/guest/findOneParagraphPic.do")
    public Object findOneParagraph(@RequestParam long id){
        try {
            ParagraphPic paragraphPic=paragraphService.findOne(id);
            HashMap<String,Object> map=new HashMap<>();
            map.put("id",paragraphPic.getId());
            map.put("address",UPLOAD_DIRECTORY+paragraphPic.getId()+".png");
            System.out.println("paragraph has been fetched");
            System.out.println(paragraphPic.toString());
            return map;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllParagraphsPic.do")
    public Object findAllParagraphs(){
        try {
            List<ParagraphPic> paragraphList=paragraphService.findAll();
            List<Object> paragraphs=new ArrayList<>();

            for(ParagraphPic p:paragraphList){
                HashMap<String,Object> map=new HashMap<>();
                map.put("id",p.getId());
                map.put("address",IMAGE_DIRECTORY+p.getId()+".png");
                paragraphs.add(map);
            }
            System.out.println("All paragraphs have been fetched");
            return paragraphs;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }

    @RequestMapping("/blogger/deleteParagraphPic.do")
    public Object deleteParagraph(@RequestParam long paragraphId){
        try {
            ParagraphPic paragraphPic=paragraphService.findOne(paragraphId);
            paragraphService.delete(paragraphPic);
            File file=new File(UPLOAD_DIRECTORY+paragraphId+".png");
            file.delete();
            System.out.println("paragraph has been deleted");
            System.out.println(paragraphPic.toString());
            return findAllParagraphs() ;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
}
