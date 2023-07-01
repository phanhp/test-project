package mvc.service;

import mvc.configuration.Config;
import mvc.entity.Obj;
import mvc.repository.ObjRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ObjService {
    private JdbcTemplate jdbcTemplate;

    public ObjService(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    DataSource dataSource;

    public List<Obj> findAllList(){
        String sql = "select * from obj";
        List<Obj> objList = jdbcTemplate.query(sql, new RowMapper<Obj>() {
            @Override
            public Obj mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Obj obj = new Obj();
                obj.setObjId(resultSet.getInt("obj_id"));
                obj.setObjName(resultSet.getString("obj_name"));
                obj.setObjData(resultSet.getString("obj_data"));
                return obj;
            }
        });
        return objList;
    }

    public List<Obj> findObjByArrayName(String[]nameList){
        if(nameList.length==0){
            return null;
        }
        String sql = "select * from obj where obj_name like ";
        for (int i=0; i<nameList.length;i++){
            if(i==0){
                sql= sql+"?";
            }else{
                sql=sql+" or obj_name like ?";
            }
        }
        Connection connection = null;
        try{
            connection = dataSource.getConnection();
            PreparedStatement sttm = connection.prepareStatement(sql);
            for (int i=0; i<nameList.length;i++){
                sttm.setString(i+1,"%"+nameList[i]+"%");
            }
            ResultSet rs = sttm.executeQuery();
            List<Obj>objList = new ArrayList<>();
            while (rs.next()){
                Obj obj = new Obj();
                obj.setObjId(rs.getInt("obj_id"));
                obj.setObjName(rs.getString("obj_name"));
                obj.setObjData(rs.getString("obj_data"));
                objList.add(obj);
            }
            connection.close();
            return objList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

