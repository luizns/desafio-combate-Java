package application;

import entities.Champion;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Champion championA = new Champion();
        Champion championB = new Champion();

        System.out.println("Digite os dados do primeiro campeão:");
        createChampionFromInput(championA);

        System.out.println("\nDigite os dados do segundo campeão:");
        createChampionFromInput(championB);

        int quantityShifts = askAndValidateIntInput("\nQuantos turnos você deseja executar? ");

        for (int shift = 0; shift < quantityShifts; shift++) {
            championA.takeDamage(championB);
            championB.takeDamage(championA);

            System.out.println("\nResultado do turno " + (shift + 1) + ":");
            System.out.println(championA.status());
            System.out.println(championB.status());

            if (championA.getLife() <= 0 || championB.getLife() <= 0) {
                break;
            }
        }

        System.out.println("\nFIM DO COMBATE");
        sc.close();
    }

    private static void createChampionFromInput(Champion champion) {
        System.out.print("Nome: ");
        String name = sc.nextLine();
        int vidaInicial = askAndValidateIntInput("Vida inicial: ");
        int ataque = askAndValidateIntInput("Ataque: ");
        int armadura = askAndValidateIntInput("Armadura: ");

        champion.setName(name);
        champion.setLife(vidaInicial);
        champion.setAttack(ataque);
        champion.setArmor(armadura);

        sc.nextLine();
    }

    private static int askAndValidateIntInput(String message) {
        System.out.print(message);
        while (!Program.sc.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
            Program.sc.next();
            System.out.print(message);
        }
        return Program.sc.nextInt();
    }
}
