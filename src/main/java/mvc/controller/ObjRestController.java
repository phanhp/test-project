package mvc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjRestController {
    @PostMapping(value = "${pageContext.request.contextPath}/obj-controller")
    public String objController(String objName) {
        String responseData = "";
        if (objName.equalsIgnoreCase("")) {
            responseData = "Null Object Name";
        } else {
            responseData = objName;
        }
        return responseData;
    }
}
