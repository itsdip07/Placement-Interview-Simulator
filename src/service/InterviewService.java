package service;

import interview.AptitudeRound;
import interview.HRRound;
import interview.InterviewRound;
import interview.TechnicalRound;

import model.Candidate;
import model.Company;

import util.ConsoleUtil;
import util.InputUtil;

public class InterviewService {

    private InputUtil input;

    private ScoreService scoreService;

    public InterviewService(
            InputUtil input) {

        this.input = input;

        this.scoreService =
                new ScoreService();
    }

    public void startInterview(
            Candidate candidate,
            Company company) {

        if (company == null) {

            System.out.println();

            System.out.println(
                    "❌ Please choose a company first."
            );

            input.waitForEnter();

            return;
        }

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "🚀 INTERVIEW PROCESS"
        );

        System.out.println();

        System.out.println(
                "Company: "
                        + company.getName()
        );

        System.out.println();

        System.out.println(
                "Candidate: "
                        + candidate.getName()
        );

        System.out.println();

        System.out.println(
                "Your interview is about to begin."
        );

        System.out.println(
                "Good luck! 🫡"
        );

        input.waitForEnter();

        // ======================================
        // APTITUDE
        // ======================================

        InterviewRound aptitude =
                new AptitudeRound(input);

        aptitude.conduct(candidate);

        if (candidate.getAptitudeScore() < 30) {

            System.out.println();

            System.out.println(
                    "❌ You did not clear aptitude."
            );

            System.out.println(
                    "Interview process terminated. 💀"
            );

            input.waitForEnter();

            return;
        }

        // ======================================
        // TECHNICAL
        // ======================================

        InterviewRound technical =
                new TechnicalRound(input);

        technical.conduct(candidate);

        if (candidate.getTechnicalScore() < 30) {

            System.out.println();

            System.out.println(
                    "❌ You did not clear technical."
            );

            input.waitForEnter();

            return;
        }

        // ======================================
        // HR
        // ======================================

        InterviewRound hr =
                new HRRound(input);

        hr.conduct(candidate);

        // ======================================
        // FINAL RESULT
        // ======================================

        boolean selected =
                scoreService.isSelected(
                        candidate
                );

        candidate.setSelected(
                selected
        );

        showFinalResult(
                candidate,
                company
        );
    }

    private void showFinalResult(
            Candidate candidate,
            Company company) {

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "🎯 FINAL VERDICT"
        );

        scoreService.displayReport(
                candidate
        );

        System.out.println();

        if (candidate.isSelected()) {

            double percentage =
                    scoreService.getPercentage(
                            candidate
                    );

            double packageRange =
                    company.getMaxPackage()
                            - company.getMinPackage();

            double offeredPackage =
                    company.getMinPackage()
                            + (
                            packageRange
                                    * percentage
                                    / 100
                    );

            if (offeredPackage
                    > company.getMaxPackage()) {

                offeredPackage =
                        company.getMaxPackage();
            }

            System.out.println(
                    "🏢 Company: "
                            + company.getName()
            );

            System.out.printf(
                    "💰 Package: ₹%.2f LPA%n",
                    offeredPackage
            );

            System.out.println();

            System.out.println(
                    "🎉 CONGRATULATIONS!"
            );

            System.out.println(
                    "You are officially placed!"
            );

        } else {

            System.out.println(
                    "❌ Unfortunately, you were not selected."
            );

            System.out.println();

            System.out.println(
                    "Don't worry."
            );

            System.out.println(
                    "Even experienced developers "
                            + "get rejected sometimes. 😎"
            );
        }

        input.waitForEnter();
    }
}