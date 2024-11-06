package se.catta.adventure.model;

//importera karaktär/klasserna

import java.util.Scanner;

// Game-klassen innehåller spelets huvudlogik och flöde
public class Game {
    private Player resident;          //Skapar spelarobjekt
    private Burglar burglar;        //Skapar inbrottstjuven
    private boolean running;        // Flagga för att hålla spelet igång
    private boolean fryingPanFound; // Flagga för att kolla om stekpannan är hittad

    //Konstruktorn för Game/klassen, initierar spelet.
    public Game() {
        this.resident = new Player();
        this.burglar = new Burglar();
        this.running = true;
        this.fryingPanFound = false;
    }

    //Startmetod som kör spelets huvudloop
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Välkommen till äventyrspelet!");

        //Huvudloop för spelet, är running så länge spelar är vid liv
        while (running && resident.isConscious()) {
            System.out.println("Välj rum:vardagsrum, kök, sovrum, hall, kontor");
            String choice = scanner.nextLine().toLowerCase();

            //&& (logiskt "och"): Används för att kombinera två eller //flera villkor. Den utvärderar om båda uttrycken är sanna //(true).
            //Om båda är sanna returnerar den true.
            //Om ett eller båda är falska returnerar den false.
            //Användning i Loop
            //I loopen while (running && resident.isConscious()):
            //running: Om detta är true, är spelet aktivt.
            //player.isConscious(): Om detta returnerar true, är //spelaren vid medvetande vid liv.

            //Scanner-instans som är skapad tidigare i koden för
            // att läsa in användarens inmatning från konsolen.
            //scanner.nextLine() läser hela raden som användaren
            // skriver in och returnerar den som en sträng.
            //.toLowerCase() används för att omvandla den inmatade
            // strängen till små bokstäver. Detta säkerställer att
            // oavsett hur användaren skriver (t.ex. "Vardagsrum",
            // "vardagsrum", eller "VARDAGSRUM") så kommer det att bli
            // "vardagsrum" i den lagrade strängen. Det gör att
            // jämförelser senare i koden blir enklare och mer robusta,
            // eftersom man undviker problem med versaler och gemener.


            // Switch-sats för att hantera spelarens val av rum
            switch (choice) {
                case "vardagsrum":
                    System.out.println("Du är i vardagsrummet, central plats");
                    break;

                case "kök":
                    enterKitchen(); // Gå till köket
                    break;

                case "sovrum":
                    System.out.println("Sovrummet är lungt *chilla* inget händer här");
                    break;

                case "hall":
                    enterHall(); //Gå till hallen där striden startar
                    break;

                case "kontor":
                    enterOffice(scanner); // Gå till kontoret för att ringa polisen
                    break;

                default:
                    System.out.println("Ogiltigt val.");

            }
        }
        // Kontrollera om player vann eller förlorade spelet

        if (!resident.isConscious()) {
            System.out.println("***GAME-OVER***");
        } else if (!running) {
            System.out.println("Spelet är slut. Du är säker!");
        }
    }

    // Metod för att hantera köket där spelaren kan hitta stekpannan
    private void enterKitchen() {
        if (!fryingPanFound) { //Kolla att stekpannan inte redan är plockad
            System.out.println("Du hittar en stekpanna i köket. Vill du plocka upp den? (ja/nej)");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().toLowerCase().equalsIgnoreCase("ja")) {
                resident.addDamage(3);// öka spelaren skada med 3 poäng
                fryingPanFound = true; // Markera att stekpannan är plockad
                System.out.println("Du plockade upp stekpannan! Din skada är nu" + resident.getDamage());
            }
        } else {
            System.out.println("Det finns inga kvar att plocka upp i köket");
        }
    }

    //Metod för att hantera fighten med tjuven i hallen
    private void enterHall() {
        System.out.println("Du möter en inbrottstjuv i hallen!");

        //Fight-loop: spelaren och tjuven fightas tills ena blir utslagen
        while (resident.isConscious() && burglar.isConscious()) {
            resident.punch(burglar); //Spelaren attackerar tjuven

            if (burglar.isConscious()) {
                burglar.punch(resident); // Tjuven attackerar tillbaka om han är vid liv
            }
        }
        if (resident.isConscious()) {
            System.out.println("Du har besegrat inbrotjuven!");

        }
    }

    //Metoden för att ringa kontoret när tjuven är utslagen!
    private void enterOffice(Scanner scanner) {
        if (!burglar.isConscious()) { //kontrollera om tjuven är besegrad
            System.out.println("Du är i kontoret. Vill du ringa polisen? (ja/nej)");
            if (scanner.nextLine().toLowerCase().equalsIgnoreCase("ja")) {
                System.out.println("Du ringer polisen och du har vunnit spelet");
                running = false; //Avsluta spelet
            }
        } else {
            System.out.println("Du är för stressad för att tänka på att ringa polisen");
        }

    }
}


////Game-klassen innehåller spelets huvudlogik. Den definierar
// en loop som tillåter spelaren att navigera mellan olika rum
// och hantera spelets händelser.
////Metoderna enterKitchen, enterHall och enterOffice
// definierar vad som händer i varje rum. Speciellt
// enterKitchen ökar spelarens skada när stekpannan plockas upp.