package mvc.controller;

import mvc.entity.Obj;
import mvc.main.Main;
import mvc.repository.ObjRepository;
import mvc.service.ObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeRestController {
    @Autowired
    ObjService objService;

    @PostMapping(value = "/homeSearchBox")
    public List<Obj> homeSearchBox(String searchValue) {
        if (searchValue.length() == 0) {
            List<Obj> objList = objService.findAllList();
            return objList;
        } else {
            String[] searchArray = searchValue.split("[^a-zA-Z0-9]+");
            List<Obj> objList = objService.findObjByArrayName(searchArray);
            return objList;
        }
    }

//    @PostMapping(value="/homeSearchBoxHello")
//    public String homeSearchBoxHello(String searchValue){
//        return "Hello";
//    }
}
