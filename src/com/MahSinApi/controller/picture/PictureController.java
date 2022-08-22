package com.MahSinApi.controller.picture;

import com.MahSinApi.common.ServerAddress;
import com.MahSinApi.model.entity.Picture;
import com.MahSinApi.model.service.PictureService;
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
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserService userService;
    private static String UPLOAD_DIRECTORY = ServerAddress.UPLOAD_DIRECTORY;
    private static String IMAGE_DIRECTORY=ServerAddress.IMAGE_DIRECTORY;
    @RequestMapping(value = "/picture/savePicture",method = RequestMethod.POST)
    public Object savePicture(@ModelAttribute Picture picture,
                             @RequestParam long userId,
                              @RequestParam CommonsMultipartFile file) {
        try {
            if (file.isEmpty()) {
                return null;
            } else {
                picture.setDate(new Date(System.currentTimeMillis()))
                        .setRecordControl(1)
                        .setState("active")
                        .setUser(userService.findOne(userId));
                pictureService.save(picture);
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY + picture.getId() + ".png"));
                System.out.println("picture has been saved");
                HashMap<String,Object> map=new HashMap<String,Object>();
                map.put("id",picture.getId());
                map.put("date",picture.getDate());
                map.put("user",picture.getUser());
                map.put("link",IMAGE_DIRECTORY+picture.getId()+".png");
                return map;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e;
        }
    }

    @RequestMapping("/guest/findOnePicture.do")
    public Object findOnePicture(@RequestParam long id){
        try {
            Picture picture=pictureService.findOne(id);
            System.out.println("policy has been fetched");
            System.out.println(picture.toString());
            HashMap<String,Object> map=new HashMap<String,Object>();
            map.put("id",picture.getId());
            map.put("date",picture.getDate());
            map.put("user",picture.getUser());
            map.put("link",IMAGE_DIRECTORY+picture.getId()+".png");
            return map;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllPictures.do")
    public Object findAllPicture(){
        try {
            List<Picture> pictureList=pictureService.findAll();
            System.out.println("All picture have been fetched");
            List<Object> pictures=new ArrayList<>();
            for (Picture p:pictureList){
            HashMap<String,Object> map=new HashMap<String,Object>();
            map.put("id",p.getId());
            map.put("date",p.getDate());
            map.put("user",p.getUser());
            map.put("link",IMAGE_DIRECTORY+p.getId()+".png");
            pictures.add(map);
            }
            return pictures;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/admin/deletePicture.do")
    public Object deletePicture(@RequestParam long pictureId){
        try {
            Picture picture=pictureService.findOne(pictureId);
            pictureService.delete(picture);
            System.out.println("picture has been deleted");
            System.out.println(picture.toString());
            File file=new File(UPLOAD_DIRECTORY+pictureId+".png");
            file.delete();
            return findAllPicture() ;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
}
