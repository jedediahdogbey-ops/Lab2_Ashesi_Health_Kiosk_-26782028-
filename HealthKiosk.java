import java.util.Scanner;

public class HealthKiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the Ashesi Health Kiosk");

        //Task 1 Service Router
        System.out.println("Enter service code (P/L/T/C): ");
        String serviceCode = input.next();
        char sCode = Character.toUpperCase(serviceCode.charAt(0));


        switch (sCode) {
            case 'P':
                System.out.println("Go to: Pharmacy Desk");
                break;
            case 'L':
                System.out.println("Go to: Lab Desk");
                break;
            case 'T':
                System.out.println("Go to: Triage Desk");
                break;
            case 'C':
                System.out.println("Go to: Counseling Desk");
                break;
            default:
                System.out.println("Invalid service code");
        }



        
        //Task 2 Mini Health Metric
        System.out.println("Kindly enter the health metric: 1 for BMI, 2 for Dosage round-up, 3 for simple trig helper.");
        int userMetric = input.nextInt();
        double fMV = 0.0; // fMV represents finalMetricValue
        int roundFMV = 0; // roundFMV represents roundFinalMetricValue
        String metricText = "";

        if (userMetric == 1) {
            //BMI calculation

            System.out.println("Kindly enter your weight(in kilograms): ");
            double uWeight = input.nextDouble();
            System.out.println("kindly enter your height (in meters): ");
            double uHeight = input.nextDouble();
            double userBmi = uWeight / (uHeight * uHeight);
            double roundedUserBmi = Math.round(userBmi * 10) / 10.0;
            System.out.println("Your BMI is: " + roundedUserBmi + " Category: ");

            if (roundedUserBmi < 18.5) {
                System.out.println("You are underweight");
            }
            else if (roundedUserBmi <= 24.9) {
                System.out.println("You have a normal weight");
            }
            else if (roundedUserBmi <= 29.9) {
                System.out.println("You are overweight");
            }
            else {
                System.out.println("You are Obese");
            }
            
            userMetric = roundFMV;
            roundFMV = (int) Math.round(userBmi);
            metricText = " BMI " + roundFMV;

        }

        else if (userMetric == 2) {
            // Dosage round-up

            System.out.println("Enter your specified dosage (in mili grams: )");
            double userDosage = input.nextDouble();
            double pTD = input.nextDouble(); // pTD represents phramacyTabDispensation
            int tablets = (int) pTD;
            System.out.println("Your number of tablets are " + tablets);
            userMetric = tablets;
            roundFMV = tablets;
            metricText = "Tablets = " + tablets;

        }

        else if (userMetric == 3){
            // Simple trig helper
            System.out.println("Kindly enter the angle (in degrees)");
            double angle = input.nextDouble();
            double radians = Math.toRadians(angle);
            double sin = Math.sin(radians);
            double cos = Math.cos(radians);
            double roundedSin = Math.round(sin * 1000) / 1000;
            double roundedCos = Math.round(cos * 1000) / 1000;
            System.out.println("sin: " + roundedSin + "Cos: " + roundedCos);
            roundFMV = (int) Math.round(sin * 100);
            metricText = "Sin" + roundedSin + "Cos = " + roundedCos;

        }


        //Taks 3: ID Sanity Check

        char randomCharacter = (char) ('A' + (int) (Math.random() * 26));
        int n1 = 3 + (int) (Math.random() * 7);
        int n2 = 3 + (int) (Math.random() * 7);
        int n3 = 3 + (int) (Math.random() * 7);
        int n4 = 3 + (int) (Math.random() * 7);
        String userID = "" + randomCharacter + n1 + n2 + n3 + n4;

        if (userID.length() != 5) {
            System.out.println("Invalid ID length");
        } 

        else if (!Character.isLetter(userID.charAt(0))) {
            System.out.println("Invalid ID: first char must be a letter");
        }

        else if (!Character.isDigit(userID.charAt(1)) || !Character.isDigit(userID.charAt(2)) ||
                   !Character.isDigit(userID.charAt(3)) || !Character.isDigit(userID.charAt(4))) {
            System.out.println("Invalid ID: last 4 characters must be digits");
        }

        else {
            System.out.println("ID is OK");
        }


        //Task 4: "Secure" Display Code
        System.out.println("Kindly enter your first name: ");
        String userName = input.next();
        char baseCode = Character.toUpperCase(userName.charAt(0));
        char charShift = (char) ('A' + (baseCode - 'A' + 2) % 26);
        String lastTwo = userID.substring(3, 5);
        String Code = "" + charShift + lastTwo + "-" + roundFMV;
        System.out.println("Display Code: " + Code);

        //Task 5;  Service Summary
        String serviceName = "";
        switch (serviceName) {
            case "P":
                serviceName = "PHARMACY";
                break;
            case "L":
                serviceName = "LAB";
                break;
            case "T":
                serviceName = "TRIAGE";
                break;
            case "C":
                serviceName = "COUNSELING";
                break;
            default:
                serviceName = "INVALID";

        }
        String summary = "Summary: " + serviceName + "| ID = " + userID;
        
        if (serviceName == "T") {
            summary += " | " + metricText;
        }
        summary += " | Code" + Code;
        System.out.println(summary);
            





    }
}