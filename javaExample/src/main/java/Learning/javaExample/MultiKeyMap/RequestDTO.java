package Learning.javaExample.MultiKeyMap;

public class RequestDTO {

    private TransactionType transactionType;

    private TransactionSubType transactionSubType;

    public RequestDTO(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionSubType getTransactionSubType() {
        return transactionSubType;
    }

    public void setTransactionSubType(TransactionSubType transactionSubType) {
        this.transactionSubType = transactionSubType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public RequestDTO() {
    }
}
