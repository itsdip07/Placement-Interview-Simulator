package service;

import model.Achievement;
import model.Candidate;

import java.util.ArrayList;
import java.util.List;

public class AchievementService {

    private List<Achievement> achievements;

    public AchievementService() {

        achievements =
                new ArrayList<>();

        achievements.add(
                new Achievement(
                        "First Step",
                        "Created your first candidate profile."
                )
        );

        achievements.add(
                new Achievement(
                        "Aptitude Survivor",
                        "Passed the aptitude round."
                )
        );

        achievements.add(
                new Achievement(
                        "Java Warrior",
                        "Scored 40+ in the technical round."
                )
        );

        achievements.add(
                new Achievement(
                        "HR Survivor",
                        "Passed the HR round."
                )
        );

        achievements.add(
                new Achievement(
                        "Placement God",
                        "Got selected in the final evaluation."
                )
        );
    }

    public void updateAchievements(
            Candidate candidate) {

        achievements.get(0).unlock();

        if (candidate.getAptitudeScore() >= 30) {

            achievements.get(1).unlock();
        }

        if (candidate.getTechnicalScore() >= 40) {

            achievements.get(2).unlock();
        }

        if (candidate.getHrScore() >= 12) {

            achievements.get(3).unlock();
        }

        if (candidate.isSelected()) {

            achievements.get(4).unlock();
        }
    }

    public void displayAchievements(
            Candidate candidate) {

        updateAchievements(candidate);

        System.out.println();

        System.out.println(
                "╔══════════════════════════════════════════════════╗"
        );

        System.out.println(
                "║                🏆 ACHIEVEMENTS                  ║"
        );

        System.out.println(
                "╠══════════════════════════════════════════════════╣"
        );

        boolean found = false;

        for (Achievement achievement :
                achievements) {

            if (achievement.isUnlocked()) {

                achievement.display();

                System.out.println();

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "🔒 No achievements unlocked yet."
            );
        }

        System.out.println(
                "╚══════════════════════════════════════════════════╝"
        );
    }
}