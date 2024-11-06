package se.catta.adventure.test;

import org.junit.jupiter.api.Test;
import se.catta.adventure.model.Burglar;
import se.catta.adventure.model.Player;

import static org.junit.jupiter.api.Assertions.*;

//JUnit-test för att testa metoder i character/klassen
public class CharacterTest {

    @Test
    public void testPunch() {
        Player player = new Player();//skapar en ny Spelare
        Burglar burglar = new Burglar();//Skapar en ny Burglar
        player.punch(burglar); //spelaren attackerar tjuven
        assertTrue(burglar.getHealth()<12);//Kontrollerar att Tjuven har blivit skadad
    }
    @Test // Anger att metoden är test

    public void testtakeHit(){
        Player player = new Player();
        player.takeHit(4); //Player tar emot 4 i skada
    }
@Test // Anger att metoden är test
    public void testIsConsious(){
        Player player = new Player(); //skapar en ny Player
        player.takeHit(12); //Player tar emot 12 skada anropar instansen player istället för klassen Player
        assertFalse(player.isConscious()); //Kontrollerar att Player är nedslagen
}

}