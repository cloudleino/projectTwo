package se.catta.adventure.model;    // Paketet där klasserna ligger

// Player-klassen representerar spelaren och ärver från GameCharacter
public class Player extends GameCharacter {

    // Konstruktor som initierar spelaren med specifika startvärden
    public Player() {
        super("Player", 12, 3); // Startvärden för hälsa och skada
    }

    // Override-metod för att hantera skada på spelaren
    @Override
    public void takeHit(int damage) {
        super.takeHit(damage); // Anropar basklassens takeHit för att minska hälsan
        if (this.health < 0) {
            this.health = 0; // Sätter hälsan till noll om den går under noll
        }
    }
}

// Player representerar spelaren i spelet.
// Den ärver egenskaper och metoder från Character
// och initierar spelaren med hälsa och skada.