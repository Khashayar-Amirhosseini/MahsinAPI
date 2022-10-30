package com.MahSinApi.controller.facility;

import com.MahSinApi.common.ServerAddress;
import com.MahSinApi.model.entity.Facility;
import com.MahSinApi.model.entity.MainService;
import com.MahSinApi.model.entity.Service;
import com.MahSinApi.model.service.FacilityService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class FacilityController {
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private UserService userService;
    private static  String UPLOAD_DIRECTORY = ServerAddress.getInstance().UPLOAD_DIRECTORY;
    private static  String IMAGE_DIRECTORY=ServerAddress.getInstance().IMAGE_DIRECTORY;
    @RequestMapping( value = "/facility/saveFacility.do",method = RequestMethod.POST)
    public Object saveFacility(@ModelAttribute Facility facility,
                               @RequestParam long userId,
                               @RequestParam CommonsMultipartFile file){
        try {
            facility.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(1)
                    .setState("active")
                    .setUser(userService.findOne(userId));
            facilityService.save(facility);
            if (file.isEmpty()){}
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+facility.getId()+".png"));
                System.out.println("main service picture has been saved");}
            System.out.println("facility has been saved");
            System.out.println(facility.toString());
            return findOneFacility(facility.getId());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping(value = "/facility/updateFacility.do",method = RequestMethod.POST)
    public Object updateFacility(@ModelAttribute Facility facility,
                                 @RequestParam long userId,
                                 @RequestParam CommonsMultipartFile file){
        try {
            facility.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(facilityService.findOne(facility.getId()).getRecordControl())
                    .setUser(userService.findOne(userId));
            facilityService.update(facility);
            if (file.isEmpty()){}
            else{
                FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+facility.getId()+".png"));
                System.out.println("main service picture has been updated");}
            System.out.println("facility has been updated");
            System.out.println(facility.toString());
            return findOneFacility(facility.getId());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOneFacility.do")
    public Object findOneFacility(@RequestParam long id){
        try {
            Facility facility=facilityService.findOne(id);
            HashMap<String,Object> map=new HashMap<>();
            map.put("id",facility.getId());
            map.put("name",facility.getName());
            map.put("utility",facility.getUtility());
            map.put("description",facility.getDescription());
            map.put("date",facility.getDate());
            map.put("state",facility.getState());
            map.put("user",facility.getUser());
            map.put("image",getMainFacilityPicture(facility.getId()));
            System.out.println("facility has been fetched");
            System.out.println(facility.toString());
            return facility;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllFacilities.do")
    public Object findAllFacility(){
        try {
            List<Facility> facilityList=facilityService.findAll();
            List<Object> facilities=new ArrayList<>();
            for(Facility f:facilityList){
                HashMap<String,Object> map=new HashMap<>();
                map.put("id",f.getId());
                map.put("name",f.getName());
                map.put("utility",f.getUtility());
                map.put("description",f.getDescription());
                map.put("date",f.getDate());
                map.put("state",f.getState());
                map.put("image",getMainFacilityPicture(f.getId()));
                map.put("user",f.getUser());
                facilities.add(map);
            }
            System.out.println("All facilities have been fetched");
            return facilities ;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/admin/deleteFacility.do")
    public Object deleteFacility(@RequestParam long facilityId){
        try {
            Facility facility=facilityService.findOne(facilityId);
            facilityService.delete(facility);
            File file=new File(UPLOAD_DIRECTORY+facilityId+".png");
            file.delete();
            System.out.println(facility.toString());
            System.out.println("the mentioned main facility has been deleted");
            return findAllFacility();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping(value = "/guest/getFacilityPicture.do")
    public Object getMainFacilityPicture(@RequestParam long facilityId)
            throws IOException {
        File file = new File(UPLOAD_DIRECTORY+facilityId+".png");
        if(file.exists()) {
            return IMAGE_DIRECTORY+String.valueOf(facilityId)+".png";
        }
        else {
            return null;
        }
    }
}
