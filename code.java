import java.util.Scanner;
import java.text.DecimalFormat;

public class BMICalculator {

    // Enumeration for BMI signals
    public enum Signal {
        ADJUST_DIET_AND_EXERCISE,
        CONSULT_HEALTH_PROFESSIONAL,
        MAINTAIN_HEALTHY_LIFESTYLE
    }

    // Body state variables
    private int height;  // in centimeters
    private int weight;  // in kilograms

    // Constants for valid height and weight ranges
    private static final int MAX_HEIGHT = 250;
    private static final int MIN_HEIGHT = 50;
    private static final int MAX_WEIGHT = 200;
    private static final int MIN_WEIGHT = 5;

    // Constructor to initialize the body state
    public BMICalculator() {
        this.height = 0;
        this.weight = 0;
    }

    // Setter method for setting the initial body state with validation
    public void setInitialBody(int height, int weight) {
        if (inRange(height, MIN_HEIGHT, MAX_HEIGHT) && inRange(weight, MIN_WEIGHT, MAX_WEIGHT)) {
            this.height = height;
            this.weight = weight;
        } else {
            System.out.println("Invalid input! Please provide height and weight within valid ranges.");
        }
    }

    // Invariant method to check if height and weight are within valid ranges
    private boolean inRange(int val, int min, int max) {
        return val >= min && val <= max;
    }

    // Method to calculate BMI
    public double calculateBMI() {
        return weight / Math.pow((height / 100.0), 2);
    }

    // Method to classify BMI into signals
    public Signal classifyBMI() {
        double bmi = calculateBMI();

        if (bmi > 25) {
            return Signal.ADJUST_DIET_AND_EXERCISE;
        } else if (bmi < 18.5) {
            return Signal.CONSULT_HEALTH_PROFESSIONAL;
        } else {
            return Signal.MAINTAIN_HEALTHY_LIFESTYLE;
        }
    }

    // Getter method for getting the current height
    public int getHeight() {
        return height;
    }

    // Getter method for getting the current weight
    public int getWeight() {
        return weight;
    }

    public static void main(String[] args) {
        BMICalculator bmiCalculator = new BMICalculator();
        Scanner scanner = new Scanner(System.in);

        // Set initial body state
        System.out.print("Enter height in centimeters between 50 to 250: ");
        int height = scanner.nextInt();
        System.out.print("Enter weight in kilograms between 5 to 200: ");
        int weight = scanner.nextInt();

        bmiCalculator.setInitialBody(height, weight);

        // Calculate BMI
        double bmi = bmiCalculator.calculateBMI();
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedBMI = df.format(bmi);

        // Classify BMI and get recommended action
        BMICalculator.Signal recommendedAction = bmiCalculator.classifyBMI();
        System.out.println("Recommended Action: " + recommendedAction);

        // Display current height and weight
        System.out.println("Current Height: " + bmiCalculator.getHeight() + " cm");
        System.out.println("Current Weight: " + bmiCalculator.getWeight() + " kg");

      

        // Display BMI with two decimal places
        System.out.println("BMI:" + formattedBMI);

        // Close the scanner
        scanner.close();
    }
}
