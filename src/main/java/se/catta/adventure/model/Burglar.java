package se.catta.adventure.model;

// Burglar klass representerar Tjuven och ärver från GameCharacter
public class Burglar extends GameCharacter {

    // Konstruktor som initierar inbrottstjuven med specifika startvärden
    public Burglar() {
        super("Burglar", 12, 4); // Startvärden för hälsa och skada
    }

    // Korrekt isConscious-metod som kontrollerar om hälsan är över 0
    @Override
    public boolean isConscious() {
        return this.health > 0;
    }
}
