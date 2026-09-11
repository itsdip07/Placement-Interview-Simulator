package model;

public class Company {

    private String name;
    private double minCgpa;

    private int aptitudeRequired;
    private int technicalRequired;
    private int hrRequired;

    private double minPackage;
    private double maxPackage;

    public Company(
            String name,
            double minCgpa,
            int aptitudeRequired,
            int technicalRequired,
            int hrRequired,
            double minPackage,
            double maxPackage) {

        this.name = name;
        this.minCgpa = minCgpa;
        this.aptitudeRequired = aptitudeRequired;
        this.technicalRequired = technicalRequired;
        this.hrRequired = hrRequired;
        this.minPackage = minPackage;
        this.maxPackage = maxPackage;
    }

    public String getName() {
        return name;
    }

    public double getMinCgpa() {
        return minCgpa;
    }

    public int getAptitudeRequired() {
        return aptitudeRequired;
    }

    public int getTechnicalRequired() {
        return technicalRequired;
    }

    public int getHrRequired() {
        return hrRequired;
    }

    public double getMinPackage() {
        return minPackage;
    }

    public double getMaxPackage() {
        return maxPackage;
    }

    public boolean isEligible(Candidate candidate) {

        return candidate.getCgpa() >= minCgpa;
    }

    public void displayDetails() {

        System.out.println();
        System.out.println(
                "╔══════════════════════════════════════════════════╗"
        );

        System.out.println(
                "║                 🏢 COMPANY DETAILS              ║"
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        System.out.println(
                "║ Company: " + name
        );

        System.out.println(
                "║ Minimum CGPA: " + minCgpa
        );

        System.out.println(
                "║ Aptitude Required: " + aptitudeRequired + "%"
        );

        System.out.println(
                "║ Technical Required: " + technicalRequired + "%"
        );

        System.out.println(
                "║ HR Required: " + hrRequired + "%"
        );

        System.out.println(
                "║ Package: ₹" + minPackage
                        + " - ₹" + maxPackage + " LPA"
        );

        System.out.println(
                "╚══════════════════════════════════════════════════╝"
        );
    }
}