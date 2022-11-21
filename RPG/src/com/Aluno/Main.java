package com.Aluno;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        Warrior warriorStats = new Warrior(20, 20, 3, "Normal", 1, 1, 5, 5);
        Monster monsterStats = new Monster(24, 24, 4, "Normal", 6, 6);

        while (running) {
            System.out.println("-----------------------------------------------------");
            System.out.println("\t# Um monstro aparece! #\n");

            while (monsterStats.getHP() > 0) {

                System.out.println("*TURNO " + monsterStats.getTurno() + "*\n" +
                        "-------------------\n");
                warriorStats.checkStatus();
                System.out.println("##Stats do Warrior## \n" +
                        "Vida do Warrior: " + warriorStats.getHP() + "/" + warriorStats.getHPMAX() + "\n" +
                        "Poder de ataque do Warrior: " + warriorStats.getAtaque() + "\n" +
                        "Poções do Warrior: " + warriorStats.getPocaoCura() + "/" + warriorStats.getPocaoCuramax() + "\n" +
                        "Poder magico do Warrior: " + warriorStats.getPoderMagico() + "/" + warriorStats.getPoderMagicoMAX() + "\n" +
                        "Status do Warrior: " + warriorStats.getStatus() + "\n");

                monsterStats.checkStatus();
                System.out.println("##Stats do Monstro## \n" +
                        "Vida do Monstro: " + monsterStats.getHP() + "/" + monsterStats.getHPMAX() + "\n" +
                        "Poder de ataque do Monstro: " + monsterStats.getAtaque() + "\n" +
                        "Poder magico do Monstro: " + monsterStats.getPoderMagico() + "/" + monsterStats.getPoderMagicoMAX() + "\n" +
                        "Status do Monstro: " + monsterStats.getStatus() + "\n");

                System.out.println("Escolha sua ação: \n" +
                        "1) Atacar \n" +
                        "2) Beber poção \n" +
                        "3) Fortificar \n");

                String input = in.nextLine();
                if (input.equals("1")) {
                    warriorStats.atacar(warriorStats, monsterStats);
                    monsterStats.probabilidadeAcaoMonstro(warriorStats, monsterStats);

                    if ((warriorStats.getHP() < 1)) {
                        System.out.println("Você foi derrotado");
                        break;
                    }

                } else if (input.equals("2")) {
                    warriorStats.beberPocao(warriorStats);
                    monsterStats.probabilidadeAcaoMonstro(warriorStats, monsterStats);

                    if ((warriorStats.getHP() < 1)) {
                        System.out.println("Você foi derrotado");
                        break;
                    }

                } else if (input.equals("3")) {
                    warriorStats.fortificar(warriorStats);
                    monsterStats.probabilidadeAcaoMonstro(warriorStats, monsterStats);

                    if ((warriorStats.getHP() < 1)) {
                        System.out.println("Você foi derrotado");
                        break;
                    }

                } else {
                    System.out.println("Comando invalido");
                }
            }
            if ((warriorStats.getHP() < 1)) {
                System.out.println("GAME OVER");
                break;
            }
            System.out.println("-------------------\n");
            System.out.println("# O monstro foi derrotado #");
            System.out.println("GOOD JOB");
            break;

        }

    }
}