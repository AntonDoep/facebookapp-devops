package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import java.util.List;

public class AppTest {

    private Main facebookApp;

    @BeforeEach
    public void setup() {
        facebookApp = new Main();
    }

    // Test valid profile link with friends
    @Test
    public void testProfileWithFriends() {
        List<String> friends = facebookApp.getFriendsList("https://facebook.com/cecci");
        Assertions.assertNotNull(friends, "Friends list should not be null"); //check that the list exists
        Assertions.assertFalse(friends.isEmpty(), "Profile should have friends"); // check that there are something in the list
        //Check that the specific friends (as well as amount) to "cecci" exist.
        Assertions.assertEquals(3, friends.size(), "Friends list should contain 3 friends");
        Assertions.assertTrue(friends.contains("Anton"), "Friends list should contain Anton");
        Assertions.assertTrue(friends.contains("Jessica"), "Friends list should contain Jessica");
        Assertions.assertTrue(friends.contains("Nea"), "Friends list should contain Nea");
        System.out.println("Ceccis friendslist is corect");
    }

    // Test valid profile link with a different set of friends
    @Test
    public void testAnotherProfileWithFriends() {
        List<String> friends = facebookApp.getFriendsList("https://facebook.com/saile");
        Assertions.assertNotNull(friends, "Friends list should not be null");
        Assertions.assertFalse(friends.isEmpty(), "Profile should have friends");
        Assertions.assertEquals(2, friends.size(), "Friends list should contain 2 friends");
        Assertions.assertTrue(friends.contains("Anton"), "Friends list should contain Anton");
        Assertions.assertTrue(friends.contains("Eedi"), "Friends list should contain Eedi");
        System.out.println("Sailes friendslist is correct");
    }

    // Test valid profile link with no friends
    @Test
    public void testProfileNoFriends() {
        List<String> friends = facebookApp.getFriendsList("https://facebook.com/notna");
        Assertions.assertNotNull(friends, "Friends list should not be null");
        Assertions.assertTrue(friends.isEmpty(), "Friends list should be empty for user with no friends");
        System.out.println("Notna has no friends");
    }

    // Test invalid profile link format
    @Test
    public void testInvalidProfileLink() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            facebookApp.getFriendsList("https://fejsbuuk.com/invalid");
        }, "Invalid profile link should throw IllegalArgumentException");
        //System.out.println("The link is invalid");
    }

    // Test null profile link
    @Test
    public void testGetFriendsList_NullProfileLink() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            facebookApp.getFriendsList(null);
        }, "Null profile link should throw IllegalArgumentException");
        //System.out.println("The link is null");

    }
}
