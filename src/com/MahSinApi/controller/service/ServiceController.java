package com.MahSinApi.controller.service;

import com.MahSinApi.model.entity.Doctor;
import com.MahSinApi.model.entity.MainService;
import com.MahSinApi.model.entity.Service;
import com.MahSinApi.model.service.MainServiceService;
import com.MahSinApi.model.service.ServiceService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private MainServiceService mainServiceService;
    @Autowired
    private UserService userService;
    @RequestMapping("/service/saveService.do")
    public Object saveService(@ModelAttribute Service service,
                              @RequestParam long mainServiceId,
                              @RequestParam long userId){
        try {

            service.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(1)
                    .setState("active")
                    .setUser(userService.findOne(userId));
            MainService mainService=mainServiceService.findOne(mainServiceId);
            mainService.getServices().add(service);
            serviceService.save(service);
            mainServiceService.update(mainService);
            System.out.println("service has been saved");
            System.out.println(service.toString());
            return service;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/service/updateService.do")
    public Object updateService(@ModelAttribute Service service,
                               @RequestParam long userId){
        try {
            service.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(serviceService.findOne(service.getId()).getRecordControl())
                    .setUser(userService.findOne(userId));
            serviceService.update(service);
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
            System.out.println("service has been fetched");
            System.out.println(service.toString());
            return service;
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
            System.out.println("All services have been fetched");
            return serviceList;
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
            System.out.println(service.toString());
            System.out.println("the mentioned service has been deleted");
            return findAllServices();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }




}
