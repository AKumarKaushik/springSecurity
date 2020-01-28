package Learning.javaExample.MultiKeyMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("receivedAdjustmentImpl")
public class ReceivedAdjustment implements AdjustmentService {

    private static final Logger logger = LogManager.getLogger(ReceivedAdjustment.class);

    @Override
    public ResponseDTO callMethod() {
        ResponseDTO responseDTO = new ResponseDTO(Boolean.TRUE, "Received Adjustment Called");
        return responseDTO;
    }
}
