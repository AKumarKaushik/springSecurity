package MultiKeyMap;

public enum TransactionType {

    NA("Not Applicable"),
    /**
     * The Received.
     */
    RECEIVED("Fund Received"),
    /**
     * The Paid against mrr.
     */
    PAID_AGAINST_MRR("Approved MRR");

    private String title;

    TransactionType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
