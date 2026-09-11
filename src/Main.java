import model.Candidate;
import model.Company;

import service.AchievementService;
import service.CompanyService;
import service.InterviewService;
import service.ScoreService;

import util.ConsoleUtil;
import util.InputUtil;

import java.util.Scanner;

public class Main {

    private static Scanner scanner =
            new Scanner(System.in);

    private static InputUtil input =
            new InputUtil(scanner);

    private static Candidate candidate;

    private static Company selectedCompany;

    private static CompanyService companyService =
            new CompanyService(input);

    private static InterviewService interviewService =
            new InterviewService(input);

    private static ScoreService scoreService =
            new ScoreService();

    private static AchievementService achievementService =
            new AchievementService();

    public static void main(String[] args) {

        showWelcome();

        boolean running = true;

        while (running) {

            ConsoleUtil.clearScreen();

            showMenu();

            int choice =
                    input.getInt(
                            "Enter your choice: ",
                            0,
                            8
                    );

            switch (choice) {

                case 1:
                    createProfile();
                    break;

                case 2:
                    viewProfile();
                    break;

                case 3:
                    chooseCompany();
                    break;

                case 4:
                    startInterview();
                    break;

                case 5:
                    viewPerformance();
                    break;

                case 6:
                    viewAchievements();
                    break;

                case 7:
                    showAbout();
                    break;

                case 8:
                    resetCareer();
                    break;

                case 0:
                    running = false;
                    exitProgram();
                    break;

                default:
                    System.out.println(
                            "❌ Invalid choice."
                    );
            }
        }

        scanner.close();
    }

    // ============================================
    // WELCOME
    // ============================================

    private static void showWelcome() {

        ConsoleUtil.clearScreen();

        System.out.println();

        System.out.println(
                "╔══════════════════════════════════════════════════╗"
        );

        System.out.println(
                "║                                                  ║"
        );

        System.out.println(
                "║       🎓 PLACEMENT INTERVIEW SIMULATOR          ║"
        );

        System.out.println(
                "║                                                  ║"
        );

        System.out.println(
                "║       Your resume gets tested here.             ║"
        );

        System.out.println(
                "║       Your excuses don't. 💀                    ║"
        );

        System.out.println(
                "║                                                  ║"
        );

        System.out.println(
                "╚══════════════════════════════════════════════════╝"
        );

        System.out.println();

        System.out.println(
                "                 ☕ CORE JAVA PROJECT"
        );

        input.waitForEnter();
    }

    // ============================================
    // MAIN MENU
    // ============================================

    private static void showMenu() {

        System.out.println();

        System.out.println(
                "╔══════════════════════════════════════════════════╗"
        );

        System.out.println(
                "║                    MAIN MENU                     ║"
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        System.out.println(
                "║                                                  ║"
        );

        System.out.println(
                "║  [1] 👤 Create Candidate Profile                 ║"
        );

        System.out.println(
                "║  [2] 📄 View Candidate Profile                  ║"
        );

        System.out.println(
                "║  [3] 🏢 Choose Company                           ║"
        );

        System.out.println(
                "║  [4] 🚀 Start Interview                         ║"
        );

        System.out.println(
                "║  [5] 📊 Performance Report                       ║"
        );

        System.out.println(
                "║  [6] 🏆 Achievements                             ║"
        );

        System.out.println(
                "║  [7] ℹ️  About Project                            ║"
        );

        System.out.println(
                "║  [8] 🔄 Reset Career                             ║"
        );

        System.out.println(
                "║  [0] 🚪 Exit                                     ║"
        );

        System.out.println(
                "║                                                  ║"
        );

        System.out.println(
                "╚══════════════════════════════════════════════════╝"
        );
    }

    // ============================================
    // CREATE PROFILE
    // ============================================

    private static void createProfile() {

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "👤 CANDIDATE REGISTRATION"
        );

        System.out.println();

        String name =
                input.getString(
                        "Enter your name   : "
                );

        String branch =
                input.getString(
                        "Enter your branch : "
                );

        double cgpa =
                input.getDouble(
                        "Enter your CGPA   : ",
                        0,
                        10
                );

        String skills =
                input.getString(
                        "Enter your skills : "
                );

        candidate =
                new Candidate(
                        name,
                        branch,
                        cgpa,
                        skills
                );

        selectedCompany = null;

        System.out.println();

        System.out.println(
                "Creating candidate profile..."
        );

        System.out.println();

        System.out.println(
                "✅ Profile created successfully!"
        );

        candidate.displayProfile();

        input.waitForEnter();
    }

    // ============================================
    // VIEW PROFILE
    // ============================================

    private static void viewProfile() {

        ConsoleUtil.clearScreen();

        if (!checkCandidate()) {
            return;
        }

        candidate.displayProfile();

        if (selectedCompany != null) {

            System.out.println();

            System.out.println(
                    "🏢 Selected Company: "
                            + selectedCompany.getName()
            );
        }

        input.waitForEnter();
    }

    // ============================================
    // CHOOSE COMPANY
    // ============================================

    private static void chooseCompany() {

        if (!checkCandidate()) {
            return;
        }

        selectedCompany =
                companyService.chooseCompany(
                        candidate
                );
    }

    // ============================================
    // START INTERVIEW
    // ============================================

    private static void startInterview() {

        ConsoleUtil.clearScreen();

        if (!checkCandidate()) {
            return;
        }

        if (selectedCompany == null) {

            System.out.println();

            System.out.println(
                    "❌ Please choose a company first."
            );

            input.waitForEnter();

            return;
        }

        interviewService.startInterview(
                candidate,
                selectedCompany
        );
    }

    // ============================================
    // PERFORMANCE
    // ============================================

    private static void viewPerformance() {

        ConsoleUtil.clearScreen();

        if (!checkCandidate()) {
            return;
        }

        scoreService.displayReport(
                candidate
        );

        input.waitForEnter();
    }

    // ============================================
    // ACHIEVEMENTS
    // ============================================

    private static void viewAchievements() {

        ConsoleUtil.clearScreen();

        if (!checkCandidate()) {
            return;
        }

        achievementService
                .displayAchievements(
                        candidate
                );

        input.waitForEnter();
    }

    // ============================================
    // ABOUT
    // ============================================

    private static void showAbout() {

        ConsoleUtil.clearScreen();

        ConsoleUtil.title(
                "ℹ️ ABOUT PROJECT"
        );

        System.out.println();

        System.out.println(
                "Placement Interview Simulator"
        );

        System.out.println();

        System.out.println(
                "A funny console-based placement"
        );

        System.out.println(
                "simulation game built using Core Java."
        );

        System.out.println();

        System.out.println(
                "Core Java concepts used:"
        );

        System.out.println(
                "• Classes & Objects"
        );

        System.out.println(
                "• Encapsulation"
        );

        System.out.println(
                "• Interfaces"
        );

        System.out.println(
                "• Polymorphism"
        );

        System.out.println(
                "• Collections"
        );

        System.out.println(
                "• Exception Handling"
        );

        System.out.println(
                "• Randomization"
        );

        System.out.println(
                "• Modular Architecture"
        );

        System.out.println();

        System.out.println(
                "Made with ☕ Java and questionable confidence."
        );

        input.waitForEnter();
    }

    // ============================================
    // RESET CAREER
    // ============================================

    private static void resetCareer() {

        ConsoleUtil.clearScreen();

        if (!checkCandidate()) {
            return;
        }

        candidate = null;

        selectedCompany = null;

        System.out.println();

        System.out.println(
                "🔄 Career reset successfully."
        );

        System.out.println();

        System.out.println(
                "Time to pretend the previous interview"
        );

        System.out.println(
                "never happened. 💀"
        );

        input.waitForEnter();
    }

    // ============================================
    // CHECK CANDIDATE
    // ============================================

    private static boolean checkCandidate() {

        if (candidate == null) {

            System.out.println();

            System.out.println(
                    "❌ No candidate profile found."
            );

            System.out.println();

            System.out.println(
                    "Please create your profile first."
            );

            input.waitForEnter();

            return false;
        }

        return true;
    }

    // ============================================
    // EXIT
    // ============================================

    private static void exitProgram() {

        ConsoleUtil.clearScreen();

        System.out.println();

        System.out.println(
                "╔══════════════════════════════════════════════════╗"
        );

        System.out.println(
                "║                                                  ║"
        );

        System.out.println(
                "║             👋 GOOD LUCK, CANDIDATE             ║"
        );

        System.out.println(
                "║                                                  ║"
        );

        System.out.println(
                "║      May your code compile on the first         ║"
        );

        System.out.println(
                "║      attempt and your interviewer be nice. 🙏   ║"
        );

        System.out.println(
                "║                                                  ║"
        );

        System.out.println(
                "╚══════════════════════════════════════════════════╝"
        );
    }
}
