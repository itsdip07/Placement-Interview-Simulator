package interview;

import java.util.Random;

public class Interviewer {

    private String name;
    private String personality;

    private Random random;

    public Interviewer(
            String name,
            String personality) {

        this.name = name;
        this.personality = personality;

        random = new Random();
    }

    public void introduce() {

        System.out.println();

        System.out.println(
                "👨‍💼 Interviewer: " + name
        );

        System.out.println(
                "Personality: " + personality
        );
    }

    public void react(
            boolean correct) {

        if (correct) {

            String[] reactions = {

                    "Good answer. 👍",

                    "Correct. Let's continue.",

                    "Impressive. 😎",

                    "Okay... you actually studied. 👀",

                    "That's correct."
            };

            System.out.println();

            System.out.println(
                    reactions[
                            random.nextInt(
                                    reactions.length
                            )
                    ]
            );

        } else {

            String[] reactions = {

                    "Interesting answer... but no. 💀",

                    "That's not quite right.",

                    "I hope that was a joke. 😂",

                    "Let's pretend that answer never happened.",

                    "Wrong. But confidence was impressive."
            };

            System.out.println();

            System.out.println(
                    reactions[
                            random.nextInt(
                                    reactions.length
                            )
                    ]
            );
        }
    }
}