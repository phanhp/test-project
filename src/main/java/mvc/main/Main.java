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
//        action.printObjectList(objService.findAllList());
//        action.printObjectList(objService.findAllList());
//        action.printObjectList(objService.findObjByArrayName(action.arrayNameTest1()));
//        String searchValue = "3, 5 and 7 và 12 and___object";
//        String[] searchArray = searchValue.split("[^a-zA-Z0-9]+");
//        for (int i=0; i<searchArray.length;i++){
//            System.out.println(searchArray[i]);
//        }
        String a = "qeq qaa eq";
        String [] array = a.split(" ");
        for (int i=0; i<array.length;i++){
            System.out.println(array[i]);
        }

    }


    public List<Obj> findObjByArrayName(String[] objName) {
        List<Obj> objList = objRepository.findObjByArrayName(objName);
        return objList;
    }

    public List<Obj> findObjByListName(List<String> objName) {
        List<Obj> objList = objRepository.findObjByListName(objName);
        return objList;
    }

    public void createTestData() {
        for (int i = 1; i <= 20; i++) {
            Obj obj = new Obj("Object_Number_" + i, "Object_" + i + "_Data");
            objRepository.save(obj);
        }
    }

    public String[] arrayNameTest() {
        return new String[]{"Object_Number_4", "Object_Number_9", "Object_Number_12"};
    }

    public String[] arrayNameTest1() {
        return new String[]{"4", "9", "12"};
    }

    public List<String> listNameTest() {
        List<String> list = new ArrayList<>();
        list.add("obj_4");
        list.add("obj_9");
        list.add("obj_12");
        return list;
    }

    public void printObjectList(List<Obj> objList) {
        for (int i = 0; i < objList.size(); i++) {
            printObject(objList.get(i));
        }
    }

    public void printObject(Obj obj) {
        System.out.println("[ Obj_Id: " + obj.getObjId() + " | Obj_Name: " + obj.getObjName() + " | Obj_Data: " + obj.getObjData() + " ]");
        System.out.println("-----------------------------------------------------------------------");
    }
}