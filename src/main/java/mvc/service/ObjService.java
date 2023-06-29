package mvc.service;

import mvc.configuration.Config;
<<<<<<< HEAD
import mvc.entity.Obj;
import mvc.repository.ObjRepository;
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> origin/master
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;

@Service
public class ObjService {
=======
//@Service
//public class ObjService {
>>>>>>> origin/master
//    private JdbcTemplate jdbcTemplateObjectService;
//
//    private JdbcTemplate getJdbcTemplateObjectService() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        return (JdbcTemplate) context.getBean("jdbcTemplate");
//    }
<<<<<<< HEAD
    @Autowired
    ObjRepository objRepository;

    public List<Obj> findObjByListName(List<String> objName) {
        List<Obj> objList = objRepository.findObjByListName(objName);
        return objList;
    }
}
=======
//}
>>>>>>> origin/master
