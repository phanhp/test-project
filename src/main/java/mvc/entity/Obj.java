package mvc.entity;

import javax.persistence.*;

@Entity
@Table(name = "obj")
public class Obj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "obj_id")
    private int objId;

    @Column(name = "obj_name")
    private String objName;

    @Column(name = "obj_data")
    private String objData;

    public Obj(String objName, String objData) {
        this.objName = objName;
        this.objData = objData;
    }

    public int getObjId() {
        return objId;
    }

    public void setObjId(int objId) {
        this.objId = objId;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getObjData() {
        return objData;
    }

    public void setObjData(String objData) {
        this.objData = objData;
    }

    public Obj() {
    }

    public Obj(int objId, String objName, String objData) {
        this.objId = objId;
        this.objName = objName;
        this.objData = objData;
    }
}
