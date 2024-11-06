package se.catta.adventure.model; //paket där karaktärklasserna ligger


//Abstract klass som fungerar som grundmall för alla karaktärer i hela spelet

public class GameCharacter {
    protected String role; //Karaktärens roll tex "Resident eller Burglar" String/text
    protected int health; //Karaktärens hälsa   int/
    protected int damage; //Skada som karaktären kan åstadkomma



    //Konstruktor som intierar rollen, hälsa och skadan för en karaktär
    public GameCharacter(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;

    }


    // Get/Metod för karaktärens roll
    public String getRole() {
        return role;
    }
    
    // Get/Metod för karaktärens hälsa
    public int getHealth() {
        return health;
        
    }

    //Get/Metod för karaktärens skada
    public int getDamage() {
        return damage;
    }

    //Metod för att öka skadan som karaktären kan ge
    public void addDamage(int damage) {
        this.damage += damage; //ökar karaktärens skada med den nya skadan
    }

    //Metod för att göra attacken mot den andra karaktären
    public void punch(GameCharacter toPunch){
        toPunch.takeHit(this.damage); // Anropar toPunch för att minska hälsan
    }

    //Metod för att ta emot skada
    public void takeHit(int damage){
        this.health -= damage; // Minskar hälsan med värdet på skada
    }

    //Metod för att veta om hälsa > 0
    public boolean isConscious(){
        return this.health > 0;



    }

}
//Character fungerar som en bas för alla karaktärer i spelet.
// Den definierar gemensamma attribut såsom roll, hälsa och skada,
// samt metoder för att utföra attacker och ta emot skada.
// Vi har nu lagt till en metod, addDamage, för att öka karaktärens skada,
// Vilket är en mer logisk lösning än att direkt sätta skadan i Player.