package com.MahSinApi.controller.mainService;

import com.MahSinApi.common.ServerAddress;
import com.MahSinApi.model.entity.Goal;
import com.MahSinApi.model.entity.MainService;
import com.MahSinApi.model.entity.Policy;
import com.MahSinApi.model.entity.Service;
import com.MahSinApi.model.service.MainServiceService;
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
public class MainServiceController {
    @Autowired
    private MainServiceService mainServiceService;
    @Autowired
    private UserService userService;
    private static String UPLOAD_DIRECTORY = ServerAddress.getInstance().UPLOAD_DIRECTORY;
    private static String IMAGE_DIRECTORY=ServerAddress.getInstance().IMAGE_DIRECTORY;
    @RequestMapping(value = "/service/saveMainService.do",method = RequestMethod.POST)
    public Object saveMainService(@ModelAttribute MainService mainService,
                                  @RequestParam long userId,
                                  @RequestParam CommonsMultipartFile file){
        try {
            mainService.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(1)
                    .setState("active")
                    .setUser(userService.findOne(userId));
            mainServiceService.save(mainService);
            if (file.isEmpty()){}
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+mainService.getId()+".png"));
                System.out.println("main service picture has been saved");}
            System.out.println("main service has been saved");
            System.out.println(mainService.toString());
            return mainService;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping(value = "/service/updateMainService.do",method =RequestMethod.POST)
    public Object updateMainService(@ModelAttribute MainService mainService,
                               @RequestParam long userId,
                               @RequestParam final MultipartFile file){
        try {
            mainService.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(mainServiceService.findOne(mainService.getId()).getRecordControl())
                    .setUser(userService.findOne(userId))
                    .setDescription(mainService.getDescription())
                    .setServices(mainServiceService.findOne(mainService.getId()).getServices());
            mainServiceService.update(mainService);
            if (file.isEmpty()){}
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+mainService.getId()+".png"));
                System.out.println("main service picture has been updated");}
            System.out.println("main service has been updated");
            System.out.println(mainService.toString());
            return mainService;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOneMainService.do")
    public Object findOneOneService(@RequestParam long id){
        try {
            MainService mainService=mainServiceService.findOne(id);
            HashMap<String,Object> map=new HashMap<>();
            map.put("id",mainService.getId());
            map.put("title",mainService.getTitle());
            map.put("description",mainService.getDescription());
            map.put("services",mainService.getServices());
            map.put("date",mainService.getDate());
            map.put("state",mainService.getState());
            map.put("user",mainService.getUser());
            map.put("image",getMainServicePicture(mainService.getId()));
            System.out.println("main service has been fetched");
            System.out.println(mainService.toString());
            return map;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllMainServices.do")
    public Object findAllMainServices(){
        try {
            List<MainService> mainServiceList=mainServiceService.findAll();
            List<Object> mainSerices=new ArrayList<>();
            for(MainService m:mainServiceList){
                HashMap<String,Object> map=new HashMap<>();
                map.put("id",m.getId());
                map.put("title",m.getTitle());
                map.put("description",m.getDescription());
                map.put("services",m.getServices());
                map.put("date",m.getDate());
                map.put("state",m.getState());
                map.put("image",getMainServicePicture(m.getId()));
                map.put("user",m.getUser());
                mainSerices.add(map);
            }
            System.out.println("All main services have been fetched");
            return mainSerices;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/admin/deleteMainService.do")
    public Object deleteMainService(@RequestParam long mainServiceId){
        try {
            MainService mainService=mainServiceService.findOne(mainServiceId);
            mainServiceService.delete(mainService);
            File file=new File(UPLOAD_DIRECTORY+mainServiceId+".png");
            file.delete();
            System.out.println(mainService.toString());
            System.out.println("the mentioned main service has been deleted");
            return findAllMainServices();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping(value = "/guest/getMainServicPicture.do")
    public Object getMainServicePicture(@RequestParam long mainServiceId)
            throws IOException {
        File file = new File(UPLOAD_DIRECTORY+mainServiceId+".png");
        if(file.exists()) {
            return IMAGE_DIRECTORY+String.valueOf(mainServiceId)+".png";
        }
        else {
            return null;
        }
    }

}
