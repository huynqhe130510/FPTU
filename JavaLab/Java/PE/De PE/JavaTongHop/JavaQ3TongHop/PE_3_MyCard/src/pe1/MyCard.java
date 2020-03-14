package pe1.pkg3;

public class MyCard {

    String cardNumber;
    String typeNumber;

    public MyCard(String typeNumber, String cardNumber) {
        this.cardNumber = cardNumber;
        this.typeNumber = typeNumber;

    }
    

    public String getCardCode() {
        int size = cardNumber.length();
        String cardCode;

        if (size >= 4) {
            if ("credit".equals(typeNumber)) {
                cardCode = cardNumber.substring(0, 4);
            } else {
                cardCode = cardNumber.substring(size - 4, size);
            }
        } else {
            cardCode = cardNumber;
        }
        return cardCode;

    }

    public String getCardNumber() {
        Boolean check = null;
        for (int i = 0; i < cardNumber.length(); i++) {
            check = Character.isDigit(cardNumber.charAt(i));
        }
        if (check == true) {
            return cardNumber;
        } else {
            return "0000";
        }
    }

    public String getTypeNumber() {
        return typeNumber;
    }

    @Override
    public String toString() {
        return getCardNumber(); //To change body of generated methods, choose Tools | Templates.
    }

    public MyCard() {
    }
    
}
