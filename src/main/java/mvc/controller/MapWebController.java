package mvc.controller;

import mvc.entity.Obj;
import mvc.main.Main;
import mvc.repository.ObjRepository;
import mvc.service.ObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller (value = "/")
public class MapWebController {
    @Autowired
    ObjRepository objRepository;

    @Autowired
    ObjService objService;

    @RequestMapping(value = "/")
    public String homePage(Model model){
        Main act = new Main();
        List<Obj> objList = objService.findAllList();
//        String testSearchValue="12, 14, 19";
//        String[] searchArray = testSearchValue.split("[^a-zA-Z0-9]+");
//        List<Obj> objList = objService.findObjByArrayName(searchArray);
        model.addAttribute("objList", objList);
        return "home/home";
    }

    @RequestMapping(value = "/obj-page")
    public String objPage(){
        return "home/objPage";
    }

}
