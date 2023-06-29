package mvc.repository;

import mvc.entity.Obj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjRepository extends JpaRepository<Obj, Integer> {
    @Query(value = "select * from obj where obj_name in (?1)", nativeQuery = true)
    List<Obj>findObjByArrayName(String[] objName);

    @Query(value = "select * from obj where obj_name in (?1)",nativeQuery = true)
    List<Obj>findObjByListName(List<String> objList);
}
