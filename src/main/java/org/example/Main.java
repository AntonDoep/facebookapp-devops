package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public List<String> getFriendsList(String profileLink) {
        //Make sure it is a facebook link
        if (profileLink == null || !profileLink.startsWith("https://facebook.com/")){
            throw new IllegalArgumentException("Invalid Facebook profile link.");
        }

        // Harcoded links with friendlist
        if (profileLink.equals("https://facebook.com/cecci")) {
            return Arrays.asList("Anton", "Jessica", "Nea");
        } else if (profileLink.equals("https://facebook.com/saile")) {
            return Arrays.asList("Anton", "Eedi");
        }

        return Arrays.asList();
    }

    public static void main(String[] args) {
        Main facebookApp = new Main();

        // Example profile links to test
        String profileLink1 = "https://facebook.com/cecci";
        String profileLink2 = "https://facebook.com/saile";
        String invalidProfileLink = "https://fejsbuuk.com/invalid";

        System.out.println("Friends of Cecci: " + facebookApp.getFriendsList(profileLink1));
        System.out.println("Friends of Saile: " + facebookApp.getFriendsList(profileLink2));

        try {
            System.out.println(facebookApp.getFriendsList(invalidProfileLink));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
