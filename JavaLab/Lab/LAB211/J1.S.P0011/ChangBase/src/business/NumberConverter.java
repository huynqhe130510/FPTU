package business;

public class NumberConverter {

    String baseDigits = "0123456789ABCDEF";

    /**
     * change decimal to other base
     *
     * @param input: value needs to change
     * @param base: type of base number changed
     * @return result of base
     */
    public String decimalToOtherBase(String input, int base) {
        String result = "";
        int inputInt = Integer.parseInt(input); //Chuyen String ve so int
        while (inputInt != 0) {
            result = baseDigits.charAt(inputInt % base) + result;
            inputInt /= base;
        }
        return result;
    }

    /**
     * change other base to decimal
     *
     * @param input: value needs to change
     * @param base: type of base number changed
     * @return number decimal
     */
    public String otherBaseToDecimal(String input, int base) {
        int result = 0;
        int n = input.length();
        for (int i = 0; i < n; i++) {
            result += baseDigits.indexOf(input.charAt(i)) * Math.pow(base, n - 1 - i);
        }
        return Integer.toString(result);
    }
}
