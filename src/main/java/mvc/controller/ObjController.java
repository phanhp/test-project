package mvc.controller;

import mvc.entity.Obj;
import mvc.repository.ObjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller (value = "/")
public class ObjController {
    @Autowired
    ObjRepository objRepository;

    @RequestMapping(value = "/")
    public String homePage(Model model){
        List<Obj> objList = objRepository.findAll();
        model.addAttribute("objList", objList);
        return "home/home";
    }

    @RequestMapping(value = "/obj-page")
    public String objPage(){
        return "home/objPage";
    }

}
