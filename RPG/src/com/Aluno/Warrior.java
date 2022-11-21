package com.Aluno;

public class Warrior extends Character {
    private int pocaoCura;
    private int pocaoCuramax;

    Warrior(int HP, int HPMAX, int ataque, String status, int pocaoCura, int pocaoCuramax, int poderMagico, int poderMagicoMAX) {
        this.setHP(HP);
        this.setHPMAX(HPMAX);
        this.setAtaque(ataque);
        this.setStatus(status);
        this.setPoderMagico(poderMagico);
        this.setPoderMagicoMAX(poderMagicoMAX);
        this.pocaoCura = pocaoCura;
        this.pocaoCuramax = pocaoCuramax;
    }


    public int getPocaoCura() {
        return pocaoCura;
    }

    public void setPocaoCura(int pocaoCura) {
        this.pocaoCura = pocaoCura;
    }

    public int getPocaoCuramax() {
        return pocaoCuramax;
    }

    public void setPocaoCuramax(int pocaoCuramax) {
        this.pocaoCuramax = pocaoCuramax;
    }

    public void atacar(Warrior warrior, Monster monster) {
        int ataqueMonstroDuro;
        ataqueMonstroDuro = getAtaque() - 1;

        if (monster.getStatus() == "Normal") {
            System.out.println("Você deu " + getAtaque() + " de dano pro monstro");
            monster.setHP(monster.getHP() - getAtaque());
        } else {
            System.out.println("Você deu " + ataqueMonstroDuro + " de dano pro monstro");
            monster.setHP(monster.getHP() - ataqueMonstroDuro);
        }
    }

    public void beberPocao(Warrior vidaWarrior) {
        if (pocaoCura > 0) {
            vidaWarrior.setHP(getHP() + 10);
            if (vidaWarrior.getHP() > getHPMAX()) {
                vidaWarrior.setHP(getHPMAX());
            }
            vidaWarrior.setPocaoCura(getPocaoCura() - 1);
            System.out.println("Você bebeu uma poção curando 10 de HP");
            System.out.println("Agora você possui " + getPocaoCura() + " poções restantes");
        } else {
            System.out.println("Você não possui poções restantes");
        }
    }

    public void fortificar(Warrior statusWarrior) {
        if (getPoderMagico() > 4) {
            System.out.println("Você fica fortificado por 5 turnos");
            statusWarrior.setStatus("Fortificado");
            statusWarrior.setFortificado(true);
            statusWarrior.setStatusTurno(turno + 5);
            statusWarrior.setAtaque(getAtaque() + 2);
            setPoderMagico(getPoderMagico() - 5);
        } else {
            System.out.println("Voçê não tem poder mágico suficiente");
        }
    }

    public void checkStatus() {
        if (fortificado == true) {
            if (turno > statusTurno) {
                setStatus("Normal");
                setAtaque(getAtaque() - 2);
                System.out.println("Seu status voltou ao normal");
                setFortificado(false);
            }
        }
        turno++;
    }
}