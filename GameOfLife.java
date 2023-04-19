import java.util.Scanner;

class GameOfLife{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hvor mange rader: ");
        int rader = scanner.nextInt();
        System.out.println("Hvor mange kolonner: ");
        int kolonner = scanner.nextInt();
        scanner.nextLine();
        Verden verden = new Verden(rader, kolonner);
        verden.tegn();
        boolean fortsett = true;
        while (fortsett){
            System.out.println("Skriv ja for aa lage ny generasjon");
            String svar = scanner.next();
            if (svar.equals("ja")){
                verden.oppdatering();
            } else {
                fortsett = false;
            }
        }
        System.out.println("Ferdig.");
    }
}