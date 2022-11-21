package com.Aluno;

import java.util.Random;

public class Monster extends Character {
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    private int numero;

    Monster(int HP, int HPMAX, int ataque, String status, int poderMagico, int poderMagicoMAX) {
        this.setHP(HP);
        this.setHPMAX(HPMAX);
        this.setAtaque(ataque);
        this.setStatus(status);
        this.setPoderMagico(poderMagico);
        this.setPoderMagicoMAX(poderMagicoMAX);
    }


    @Override
    public void atacar(Warrior warrior, Monster monster) {
        System.out.println("O monstro deu " + getAtaque() + " de dano para você");
        warrior.setHP(warrior.getHP() - getAtaque());
        turno++;
    }

    public void recuperacao(Monster vidaMonstro) {
        if (getPoderMagico() > 1) {
            vidaMonstro.setHP(getHP() + 2);
            if (vidaMonstro.getHP() > getHPMAX()) {
                vidaMonstro.setHP(getHPMAX());
                System.out.println("O monstro se cura por 2 de HP");
            }
            setPoderMagico(getPoderMagico() - 1);
            turno++;
        } else {
            System.out.println("O monstro não tem poder magico suficiente para se curar");
            turno++;
        }
    }

    public void endurecer(Monster statusMonstro) {
        if (getPoderMagico() > 1) {
            System.out.println("O monstro está endurecido");
            statusMonstro.setStatus("Endurecido");
            statusMonstro.setFortificado(true);
            statusMonstro.setStatusTurno(turno + 4);
            statusMonstro.setHP(getHP() + 1);
            setPoderMagico(getPoderMagico() - 5);
            turno++;
        } else {
            System.out.println("O monstro não tem poder mágico suficiente para endurecer");
            turno++;
        }
    }

    public void probabilidadeAcaoMonstro(Warrior warrior, Monster monster) {
        Random probabilidade = new Random();
        int chance = 9;
        int int_random = probabilidade.nextInt(chance);
        if (int_random < 7) {
            System.out.println("O Monstro ataca");
            atacar(warrior, monster);
        } else if (int_random == 7) {
            System.out.println("O Monstro se endurece por 4 turnos");
            endurecer(monster);
        } else if (int_random > 7) {
            recuperacao(monster);
            System.out.println("O Monstro se cura");
        }
        System.out.println("Numero gerado de 0 a 9: " + int_random);
        setNumero(int_random);
    }

    public void checkStatus() {
        if (fortificado == true) {
            if (turno > statusTurno) {
                setStatus("Normal");
                setHP(getHP() - 1);
                System.out.println("Seu status voltou ao normal");
                setFortificado(false);
            }
        }
    }
}
