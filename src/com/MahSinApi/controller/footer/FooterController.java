package com.MahSinApi.controller.footer;
import com.MahSinApi.model.entity.Footer;
import com.MahSinApi.model.service.FooterService;
import com.MahSinApi.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class FooterController {
    @Autowired
    private FooterService footerService;
    @Autowired
    private UserService userService;
    /*@RequestMapping("/admin/saveFooter.do")
    public Object saveFooter(@ModelAttribute Footer footer,
                               @RequestParam long userId){
        try {
            footer.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(1)
                    .setState("active")
                    .setUser(userService.findOne(userId));
            footerService.save(footer);
            System.out.println("footer has been saved");
            System.out.println(footer.toString());
            return footer;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }*/
    @RequestMapping("/footer/updateFooter.do")
    public Object updateFooter(@ModelAttribute Footer footer,
                                 @RequestParam long userId){
        try {
            footer.setDate(new Date(System.currentTimeMillis()))
                    .setRecordControl(footerService.findOne(footer.getId()).getRecordControl())
                    .setUser(userService.findOne(userId));
            footerService.update(footer);
            System.out.println("footer has been updated");
            System.out.println(footer.toString());
            return footer;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findOneFooter.do")
    public Object findOneFooter(@RequestParam long id){
        try {
            Footer footer=footerService.findOne(id);
            System.out.println("footer has been fetched");
            System.out.println(footer.toString());
            return footer;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
    @RequestMapping("/guest/findAllFooters.do")
    public Object findAllFooters(){
        try {
            List<Footer> footerList=footerService.findAll();
            System.out.println("All footer list have been fetched");
            return footerList;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
}
