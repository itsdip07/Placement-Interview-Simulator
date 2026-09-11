package service;

import data.CompanyDatabase;
import model.Candidate;
import model.Company;
import util.ConsoleUtil;
import util.InputUtil;

import java.util.List;

public class CompanyService {

    private List<Company> companies;

    private InputUtil input;

    public CompanyService(
            InputUtil input) {

        this.input = input;

        CompanyDatabase database =
                new CompanyDatabase();

        companies =
                database.getCompanies();
    }

    public Company chooseCompany(
            Candidate candidate) {

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "🏢 COMPANY SELECTION"
        );

        System.out.println();

        for (int i = 0;
             i < companies.size();
             i++) {

            Company company =
                    companies.get(i);

            System.out.println(
                    "[" + (i + 1) + "] "
                            + company.getName()
            );

            System.out.println(
                    "    Minimum CGPA: "
                            + company.getMinCgpa()
            );

            System.out.println(
                    "    Package: ₹"
                            + company.getMinPackage()
                            + " - ₹"
                            + company.getMaxPackage()
                            + " LPA"
            );

            System.out.println();
        }

        System.out.println(
                "[0] Back"
        );

        System.out.println();

        int choice =
                input.getInt(
                        "Choose company: ",
                        0,
                        companies.size()
                );

        if (choice == 0) {
            return null;
        }

        Company selected =
                companies.get(choice - 1);

        if (!selected.isEligible(candidate)) {

            System.out.println();

            System.out.println(
                    "❌ You are not eligible for "
                            + selected.getName()
            );

            System.out.println();

            System.out.println(
                    "Your CGPA: "
                            + candidate.getCgpa()
            );

            System.out.println(
                    "Required CGPA: "
                            + selected.getMinCgpa()
            );

            input.waitForEnter();

            return null;
        }

        System.out.println();

        System.out.println(
                "✅ You are eligible for "
                        + selected.getName()
        );

        selected.displayDetails();

        input.waitForEnter();

        return selected;
    }
}