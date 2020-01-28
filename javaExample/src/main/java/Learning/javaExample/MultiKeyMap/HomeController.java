package Learning.javaExample.MultiKeyMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private AdjustmentServiceFactory adjustmentServiceFactory;

    @RequestMapping("/home")
    private String home(@RequestBody RequestDTO requestDTO) {
        AdjustmentService adjustmentService = null;
        ResponseDTO responseDTO = null;
        adjustmentService = adjustmentServiceFactory.getAdjustmentService(requestDTO);
        if (adjustmentService == null) {
            responseDTO.setMessage("Invalid Combination Found");
        } else {
            responseDTO = adjustmentService.callMethod();
        }
        return responseDTO.getMessage();
    }
}
