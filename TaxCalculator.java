import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

abstract class TaxPayer {
    protected String name;
    protected double annualIncome;

    public TaxPayer(String name, double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public abstract double calculateTax();

    public String getName() {
        return name;
    }
}

class Individual extends TaxPayer {
    private double healthExpenditures;

    public Individual(String name, double annualIncome, double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double calculateTax() {
        double taxRate = (annualIncome < 20000.0) ? 0.15 : 0.25;
        double tax = annualIncome * taxRate;
        tax -= healthExpenditures * 0.5; 
        return Math.max(tax, 0); 
    }
}

class Company extends TaxPayer {
    private int numberOfEmployees;

    public Company(String name, double annualIncome, int numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double calculateTax() {
        double taxRate = (numberOfEmployees > 10) ? 0.14 : 0.16;
        return annualIncome * taxRate;
    }
}

public class TaxCalculator {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        List<TaxPayer> taxPayers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);
            sc.nextLine(); 

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double income = sc.nextDouble();

            if (type == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenses = sc.nextDouble();
                taxPayers.add(new Individual(name, income, healthExpenses));
            } else {
                System.out.print("Number of employees: ");
                int employees = sc.nextInt();
                taxPayers.add(new Company(name, income, employees));
            }
        }

        System.out.println("\nTAXES PAID:");
        double totalTaxes = 0;
        for (TaxPayer tp : taxPayers) {
            double tax = tp.calculateTax();
            System.out.printf("%s: $ %.2f%n", tp.getName(), tax);
            totalTaxes += tax;
        }

        System.out.printf("\nTOTAL TAXES: $ %.2f%n", totalTaxes);

        sc.close();
    }
}
