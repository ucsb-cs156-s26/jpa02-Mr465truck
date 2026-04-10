package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("s26-06");
        team.addMember("Aiden");
        team.addMember("Chaewon");
        team.addMember("Dongyi");
        team.addMember("Ethan");
        team.addMember("Prisha");
        team.addMember("Roy");
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("s26-06"));
    }

    @Test
    public void getTeam_returns_correct_team() {
        Team test = Developer.getTeam();
        assertEquals(6, test.getMembers().size());
        assertEquals("Aiden", test.getMembers().get(0));
        assertEquals("Chaewon", test.getMembers().get(1));
        assertEquals("Dongyi", test.getMembers().get(2));
        assertEquals("Ethan", test.getMembers().get(3));
        assertEquals("Prisha", test.getMembers().get(4));
        assertEquals("Roy", test.getMembers().get(5));
    }

    @Test
    // compare the same obj
    public void equals_returns_true_for_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    // compare versus non-team object
    public void equals_returns_false_for_non_team_object() {
        assertEquals(false, team.equals(new Object()));
    }

    @Test
    // compare two different objs with same values
    public void equals_returns_true_for_different_objects_with_same_values() {
        Team team2 = new Team("s26-06");
        team2.addMember("Aiden");
        team2.addMember("Chaewon");
        team2.addMember("Dongyi");
        team2.addMember("Ethan");
        team2.addMember("Prisha");
        team2.addMember("Roy");
        assertEquals(true, team.equals(team2));
    }

    @Test
    // compare two different objs with different team name
    public void equals_returns_false_for_different_team_names() {
        Team team2 = new Team("s26-05");
        team2.addMember("Aiden");
        team2.addMember("Chaewon");
        team2.addMember("Dongyi");
        team2.addMember("Ethan");
        team2.addMember("Prisha");
        team2.addMember("Roy");
        assertEquals(false, team.equals(team2));
    }

    @Test
    // compare two different objs with different team members
    public void equals_returns_false_for_different_team_members() {
        Team team2 = new Team("s26-06");
        team2.addMember("Aiden");
        team2.addMember("John");
        team2.addMember("Dongyi");
        team2.addMember("Ethan");
        team2.addMember("Prisha");
        team2.addMember("Roy");
        assertEquals(false, team.equals(team2));
    }


    @Test
    // string representation
    public void toString_returns_correct_string() {
        assertEquals("Team(name=s26-06, members=[Aiden, Chaewon, Dongyi, Ethan, Prisha, Roy])", team.toString());
    }

    @Test
    // hash representation
    // I ran the program and got -136369154, which I put in the test, but testing that the program outputs
    // what it outputs doesn't seem correct, so ask how to compute the hash?
    // update: I finished reading the assignment and mine is a little different, but he basically does what I do
    // ask at section if I'm good?
    public void hashCode_returns_correct_hash() {
        assertEquals(-136369154, team.hashCode());
    }


}
