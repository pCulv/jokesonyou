package com.example;

import java.util.Random;

public class MyJokes {
    public static final String[] jokes =
            {
                    "My sister bet me a hundred dollars I couldn't build a car out of spaghetti." +
                            " You should've see the look on her face as I drove pasta!",
                    "How many South Americans does it take to change a lightbulb? A Brazilian.",
                    "What kind of bagel can fly? A plain bagel.",
                    "Where do animals go when their tails fall off? The retail store.",
                    "Why can't you hear a pterodactyl going to the bathroom? Because the P is silent.",
                    "How does a train eat? It goes chew chew.",
                    "What's Forrest Gump's password? 1Forrest1",
                    "What do you call a cow with no legs? Ground beef.",
                    "What does a nosy pepper do? Gets jalapeno business."
            };

    public static final Random random = new Random();

    public static String getJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
