package com.MahSinApi.controller.service;

import com.MahSinApi.common.ServerAddress;
import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.entity.MainService;
import com.MahSinApi.model.entity.Service;
import com.MahSinApi.model.service.MainServiceService;
import com.MahSinApi.model.service.ServiceService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private MainServiceService mainServiceService;
    @Autowired
    private UserService userService;
    private static String UPLOAD_DIRECTORY = ServerAddress.getInstance().UPLOAD_DIRECTORY;
    private static String IMAGE_DIRECTORY=ServerAddress.getInstance().IMAGE_DIRECTORY;
    @RequestMapping(value = "/service/saveService.do",method = RequestMethod.POST)
    public Object saveService(@ModelAttribute Service service,
                              @RequestParam long mainServiceId,
                              @RequestParam long userId,
                              @RequestParam final MultipartFile file){
        try {

            service.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(1)
                    .setState("active")
                    .setUser(userService.findOne(userId));
            MainService mainService=mainServiceService.findOne(mainServiceId);
            mainService.getServices().add(service);
            serviceService.save(service);
            mainServiceService.update(mainService);
            if (file.isEmpty()){}
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+service.getId()+".png"));
                System.out.println("service picture has been updated");}
            System.out.println("service has been saved");
            System.out.println(service.toString());
            return service;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping(value = "/service/updateService.do",method = RequestMethod.OPTIONS)
    public Object updateService(@ModelAttribute Service service,
                               @RequestParam long userId,
                                @RequestParam final MultipartFile file){
        try {
            service.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(serviceService.findOne(service.getId()).getRecordControl())
                    .setUser(userService.findOne(userId));
            serviceService.update(service);
            if (file.isEmpty()){}
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+service.getId()+".png"));
                System.out.println("service picture has been updated");}
            System.out.println("service has been updated");
            System.out.println(service.toString());
            return service;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOneService.do")
    public Object findOneService(@RequestParam long id){
        try {
            Service service=serviceService.findOne(id);
            HashMap<String,Object> map=new HashMap<>();
            map.put("id",service.getId());
            map.put("title",service.getTitle());
            map.put("description",service.getDescription());
            map.put("date",service.getDate());
            map.put("state",service.getState());
            map.put("user",service.getUser());
            map.put("image",getServicePicture(service.getId()));
            System.out.println("service has been fetched");
            System.out.println(service.toString());
            return map;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllServices.do")
    public Object findAllServices(){
        try {
            List<Service> serviceList=serviceService.findAll();
            List<Object> services=new ArrayList<>();
            for(Service s:serviceList){
                HashMap<String,Object> map=new HashMap<>();
                map.put("id",s.getId());
                map.put("title",s.getTitle());
                map.put("description",s.getDescription());
                map.put("date",s.getDate());
                map.put("state",s.getState());
                map.put("image",getServicePicture(s.getId()));
                map.put("user",s.getUser());
                services.add(map);
            }
            System.out.println("All services have been fetched");
            return services;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/admin/deleteService.do")
    public Object deleteService(@RequestParam long serviceId){
        try {
            Service service=serviceService.findOne(serviceId);
            serviceService.delete(service);
            File file=new File(UPLOAD_DIRECTORY+serviceId+".png");
            file.delete();
            System.out.println(service.toString());
            System.out.println("the mentioned service has been deleted");
            return findAllServices();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping(value = "/guest/servicePicture.do")
    public Object getServicePicture(@RequestParam long serviceId)
            throws IOException {
        File file = new File(UPLOAD_DIRECTORY+serviceId+".png");
        if(file.exists()) {
            return IMAGE_DIRECTORY+String.valueOf(serviceId)+".png";
        }
        else {
            return null;
        }
    }




}
