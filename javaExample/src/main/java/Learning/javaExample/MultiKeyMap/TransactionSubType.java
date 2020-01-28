package Learning.javaExample.MultiKeyMap;

public enum TransactionSubType {

    NA("Not Applicable"),
    /**
     * The Payment File Sent NA.
     */
    PAYMENT_FILE_SENT_NA("Payment File Sent NA"),
    /**
     * The Test deposit.
     */
    TEST_DEPOSIT("Test Deposit");

    private String title;

    TransactionSubType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
