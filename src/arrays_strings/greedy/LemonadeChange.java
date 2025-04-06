package arrays_strings.greedy;

public class LemonadeChange {
    public static void main(String[] args) {
        int customerWithDenomination[] = { 5, 5, 5, 10, 20 };
        LemonadeChange.sellLemonade(customerWithDenomination);
    }

    public static boolean sellLemonade(int[] customerWithDenomination) {
        // dont sort the array since customers order is important in returning change

        int five = 0, ten = 0, twenty = 0;
        for (int i = 0; i < customerWithDenomination.length; i++) {
            if (customerWithDenomination[i] == 5)
                five++;
            else if (customerWithDenomination[i] == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else
                    return false;
            } else {
                if (five > 3) {
                    twenty++;
                    five -= 3;
                } else if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                    twenty++;
                } else
                    return false;
            }
        }
        System.out.println("Total revenue: " + ((five * 5) + (ten * 10) + (twenty * 20)));
        return false;
    }
}
