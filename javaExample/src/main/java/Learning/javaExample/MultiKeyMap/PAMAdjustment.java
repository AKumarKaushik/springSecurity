package Learning.javaExample.MultiKeyMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


@Service("pamAdjustmentImpl")
public class PAMAdjustment implements AdjustmentService {

    private static final Logger logger = LogManager.getLogger(PAMAdjustment.class);

    @Override
    public ResponseDTO callMethod() {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, "PAM Adjustment Called");
        return responseDTO;
    }
}
