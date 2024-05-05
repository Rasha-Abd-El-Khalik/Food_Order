package Cart;
import login.*;
import Menu.*;
class CreditCard {
    private String CardId;
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    public CreditCard(String transactionId, String cardNumber, String expirationDate, String cvv) {
        this.CardId = transactionId;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public String getTransactionId() {
        return CardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }
}
