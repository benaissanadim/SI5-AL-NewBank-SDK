package groupB.newbankV5.paymentprocessor.controllers.dto;



public class PaymentDetailsDTO {
    private String cardHolderName;
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private double amount;
    private String toAccountIBAN;
    private String toAccountBIC;

    public PaymentDetailsDTO() {
        // Default constructor
    }

    public PaymentDetailsDTO(String cardHolderName, String cardNumber, String expirationDate, String cvv, double amount, String toAccountIBAN, String toAccountBIC) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.amount = amount;
        this.toAccountIBAN = toAccountIBAN;
        this.toAccountBIC = toAccountBIC;
    }

    public String getToAccountIBAN() {
        return toAccountIBAN;
    }

    public void setToAccountIBAN(String toAccountIBAN) {
        this.toAccountIBAN = toAccountIBAN;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDetailsDTO{" +
                "cardHolderName='" + cardHolderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate=" + expirationDate +
                ", cvv='" + cvv + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getToAccountBIC() {
        return toAccountBIC;
    }

    public void setToAccountBIC(String toAccountBIC) {
        this.toAccountBIC = toAccountBIC;
    }
}