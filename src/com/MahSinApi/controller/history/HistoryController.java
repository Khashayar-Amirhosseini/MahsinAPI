package com.MahSinApi.controller.history;

import com.MahSinApi.model.entity.History;
import com.MahSinApi.model.service.HistoryService;
import com.MahSinApi.model.service.UserService;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private UserService userService;
    @RequestMapping("/history/historySave.do")
    public Object saveHistory(@RequestParam String description,
                              @RequestParam long userId
                             ){
        try {
            List<History> historyList= historyService.findAll();

            History history=new History().setDescription(description).setId(historyList.get(0).getId());
            Date date=new Date(System.currentTimeMillis());
            history.setDate(date);
            history.setUser(userService.findOne(userId));
            history.setRecordControl(historyList.get(0).getRecordControl());
            historyService.update(history);
            System.out.println(userId);
            System.out.println(userService.findOne(userId));
            System.out.println("the history was saved");
            System.out.println(history.toString());
            return findAllHistory();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            HashedMap map=new HashedMap();
            map.put(e.toString(),e.getMessage());
            return map;
        }

    }

    @RequestMapping("/guest/findAllHistory.do")
    public Object findAllHistory(){
        try {
        List<History> historyList= historyService.findAll();
            System.out.println("All histeries were fetched");
        return historyList;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }

    @RequestMapping("/admin/historyDelete.do")
    public Object deleteHistory(){
        try {
            List<History>historyList=historyService.findAll();
            if (!historyList.isEmpty()){
               History history= historyList.get(historyList.size() - 1);
                System.out.println(history.toString());
                historyService.delete(history);
                System.out.println("the history was deleted");
            }
            return findAllHistory();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e;
        }
    }
}
