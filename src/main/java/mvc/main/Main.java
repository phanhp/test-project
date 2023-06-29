package mvc.main;

import mvc.configuration.Config;
import mvc.entity.Obj;
import mvc.repository.ObjRepository;
import mvc.service.ObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    static ObjRepository objRepository = (ObjRepository) context.getBean("objRepository");
    static ObjService objService = (ObjService) context.getBean("objService");

    public static void main(String[] args) {
        Main action = new Main();
//        action.createTestData();
//        action.findObjByName("3");
        action.printObjectList(objService.findAllList());

    }


    public List<Obj> findObjByArrayName(String[] objName){
        List<Obj> objList = objRepository.findObjByArrayName(objName);
        return objList;
    }
    public List<Obj> findObjByListName(List<String> objName) {
        List<Obj> objList = objRepository.findObjByListName(objName);
        return objList;
    }

    public void createTestData() {
        for (int i = 1; i <= 20; i++) {
            Obj obj = new Obj("obj_" + i, "data_" + i);
            objRepository.save(obj);
        }
    }

    public String[] arrayNameTest(){
        return new String[] {"obj_4","obj_9","obj_12"};
    }

    public List<String> listNameTest(){
        List<String> list = new ArrayList<>();
        list.add("obj_4");
        list.add("obj_9");
        list.add("obj_12");
        return list;
    }

    public void printObjectList(List<Obj> objList){
        for (int i=0; i<objList.size();i++){
            printObject(objList.get(i));
        }
    }

    public void printObject(Obj obj){
        System.out.println("[ Obj_Name: "+obj.getObjName()+";   Obj_Data: "+obj.getObjData()+" ]");
    }
}