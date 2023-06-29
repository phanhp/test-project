package org.example;

import mvc.configuration.Config;
import mvc.entity.Obj;
import mvc.repository.ObjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    static ObjRepository objRepository = (ObjRepository) context.getBean("objRepository");
    @Autowired
    static ObjRepository objRepository1;

    public static void main(String[] args) {
        Main action = new Main();
//        action.createTestData();
//        action.findObjByName("3");
        action.printObjectList(objRepository1.findObjByListName(action.listNameTest()));



    }



    public void createTestData() {
        for (int i = 1; i <= 20; i++) {
            Obj obj = new Obj("obj_" + i, "data_" + i);
            objRepository.save(obj);
        }
    }

    public List<Obj> findObjByArrayName(String[] objName){
        List<Obj> objList = objRepository.findObjByArrayName(objName);
        return objList;
    }
    public List<Obj> findObjByListName(List<String> objName) {
        List<Obj> objList = objRepository.findObjByListName(objName);
        return objList;
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