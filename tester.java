import java.util.Scanner;
import java.text.DecimalFormat;

// Enumeration for BMI signals
enum Signal {
    ADJUST_DIET_AND_EXERCISE,
    CONSULT_HEALTH_PROFESSIONAL,
    MAINTAIN_HEALTHY_LIFESTYLE
}

// Class representing the BMI Calculator
class BMICalculator {

    private int height; // in centimeters
    private int weight; // in kilograms

    public BMICalculator() {
        this.height = 0;
        this.weight = 0;
    }

    public void setInitialBody(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public double calculateBMI() {
        return (double) weight / Math.pow((height / 100.0), 2);
    }

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

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
}

// Tester class for BMICalculator
class BMICalculatorTester {

    public static void main(String[] args) {
        char choice;
        Scanner scanner = new Scanner(System.in);
        BMICalculator bmiCalculator = new BMICalculator();

        do {
            System.out.println("\n\t\tBMICalculator Tester\n");
            System.out.println("1. Display BMI");
            System.out.println("2. Set Initial Body Measurements");
            System.out.println("3. Classify BMI");
            System.out.println("4. Quit");
            System.out.print("Enter choice 1-4: ");
            choice = scanner.next().charAt(0);
            System.out.println();

            switch (choice) {
                case '1':
                    option1(bmiCalculator);
                    break;
                case '2':
                    option2(bmiCalculator, scanner);
                    break;
                case '3':
                    option3(bmiCalculator);
                    break;
                default:
                    break;
            }
        } while (choice != '4');

        scanner.close();
    }

    private static void option1(BMICalculator bmiCalculator) {
        DecimalFormat df = new DecimalFormat("#.##");
        double bmi = bmiCalculator.calculateBMI();
        Signal result = bmiCalculator.classifyBMI();
        System.out.println("Calculated BMI: " + df.format(bmi));
        System.out.println("Classification: " + result);
    }

    private static void option2(BMICalculator bmiCalculator, Scanner scanner) {
        System.out.print("Enter height in centimeters: ");
        int height = scanner.nextInt();
        System.out.print("Enter weight in kilograms: ");
        int weight = scanner.nextInt();
        bmiCalculator.setInitialBody(height, weight);
    }

    private static void option3(BMICalculator bmiCalculator) {
        Signal result = bmiCalculator.classifyBMI();
        System.out.println("BMI Classification: " + result);
    }
}
