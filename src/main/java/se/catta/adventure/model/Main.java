package se.catta.adventure.model;

//Main klassen som intierar och startar spelet
public class Main {
    public static void main(String[] args) {
        Game game = new Game();//Skapar ne ny instans Game
        game.start();       //starta spelet
    }

}
//Main/klassen är ingångspunkten för programmet och ansvarar för att skapa en instans av spelet och starta det.