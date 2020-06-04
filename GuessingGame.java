import java.util.Scanner;

public class GuessingGame {

    private Scanner reader;

    public GuessingGame() {
        // use only this scanner, otherwise the tests do not work
        this.reader = new Scanner(System.in);
    }

    public void play(int lowerLimit, int upperLimit) {
        instructions(lowerLimit, upperLimit);

        while (true) {
            int average = average(lowerLimit, upperLimit);
            boolean greater = isGreaterThan(average); //aparte variabele voor maken en niet direct in de if-statement plaatsen.

            if (greater) {
                lowerLimit = average + 1;

            } else upperLimit = average; //hier niet min 1, omdat er gevraagd word of een nummer GROTER is dan. dus als de nummer kleiner is,
            // dan telt die nummer nog mee. als het groter is, dan wordt het nummer + 1;

            if (upperLimit == lowerLimit) {
                System.out.println("The number you're thinking of is " + lowerLimit);
                break;
            }

        }
    }

    public boolean isGreaterThan(int value) {
        System.out.println("Is your number greater than " + value + "? y/n");
        if (reader.nextLine().equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    public int average (int firstNumber, int secondNumber){
        return (firstNumber + secondNumber) / 2;
    }

    public void instructions(int lowerLimit, int upperLimit) {
        int maxQuestions = howManyTimesHalvable(upperLimit - lowerLimit);

        System.out.println("Think of a number between " + lowerLimit + "..." + upperLimit + ".");

        System.out.println("I promise you that I can guess the number you are thinking with " + maxQuestions + " questions.");
        System.out.println("");
        System.out.println("Next I'll present you a series of questions. Answer them honestly.");
        System.out.println("");
    }

    // a helper method:
    public static int howManyTimesHalvable(int number) {
        // we create a base two logarithm  of the given value

        // Below we swap the base number to base two logarithms!
        return (int) (Math.log(number) / Math.log(2)) + 1;
    }
}
