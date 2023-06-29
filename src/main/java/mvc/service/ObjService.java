package mvc.service;

import mvc.configuration.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//@Service
//public class ObjService {
//    private JdbcTemplate jdbcTemplateObjectService;
//
//    private JdbcTemplate getJdbcTemplateObjectService() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        return (JdbcTemplate) context.getBean("jdbcTemplate");
//    }
//}
