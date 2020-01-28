package Learning.javaExample.MultiKeyMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static Learning.javaExample.MultiKeyMap.TransactionSubType.NA;
import static Learning.javaExample.MultiKeyMap.TransactionType.PAID_AGAINST_MRR;
import static Learning.javaExample.MultiKeyMap.TransactionType.RECEIVED;

@Service
public class AdjustmentServiceFactory implements InitializingBean {

    private static MultiKeyMap<TransactionType, TransactionSubType, AdjustmentService> map = new MultiKeyMap<>();

    @Autowired
    private AdjustmentService receivedAdjustmentImpl;

    @Autowired
    private AdjustmentService pamAdjustmentImpl;

    @Override
    public void afterPropertiesSet()
    throws Exception {
        map.put(RECEIVED, NA, receivedAdjustmentImpl);
        map.put(PAID_AGAINST_MRR, NA, pamAdjustmentImpl);
    }

    public AdjustmentService getAdjustmentService(RequestDTO requestDTO) {
        AdjustmentService adjustmentService = map.get(requestDTO.getTransactionType(),
                                                      requestDTO.getTransactionSubType());
        return adjustmentService;
    }
}
