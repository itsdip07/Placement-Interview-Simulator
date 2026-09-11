package data;

import model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyDatabase {

    private List<Company> companies;

    public CompanyDatabase() {

        companies = new ArrayList<>();

        loadCompanies();
    }

    private void loadCompanies() {

        companies.add(
                new Company(
                        "TechNova",
                        6.5,
                        60,
                        60,
                        50,
                        5,
                        10
                )
        );

        companies.add(
                new Company(
                        "CodeCraft",
                        7.0,
                        65,
                        70,
                        55,
                        7,
                        14
                )
        );

        companies.add(
                new Company(
                        "InnovateX",
                        7.5,
                        70,
                        75,
                        60,
                        9,
                        18
                )
        );

        companies.add(
                new Company(
                        "FutureByte",
                        8.0,
                        75,
                        80,
                        65,
                        12,
                        22
                )
        );

        companies.add(
                new Company(
                        "DreamTech",
                        8.5,
                        80,
                        85,
                        70,
                        18,
                        30
                )
        );
    }

    public List<Company> getCompanies() {

        return new ArrayList<>(companies);
    }
}