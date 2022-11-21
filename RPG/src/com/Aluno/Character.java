package com.Aluno;

public abstract class Character {
    public int turno = 1;

    public int statusTurno = 0;

    public boolean fortificado = false;

    public int getStatusTurno() {
        return statusTurno;
    }

    public void setStatusTurno(int statusTurno) {
        this.statusTurno = statusTurno;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public boolean isFortificado() {
        return fortificado;
    }

    public void setFortificado(boolean fortificado) {
        this.fortificado = fortificado;
    }

    private int HP;
    private int HPMAX;
    private int ataque;
    private String status;
    private int poderMagico;
    private int poderMagicoMAX;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHPMAX() {
        return HPMAX;
    }

    public void setHPMAX(int HPMAX) {
        this.HPMAX = HPMAX;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    public int getPoderMagicoMAX() {
        return poderMagicoMAX;
    }

    public void setPoderMagicoMAX(int poderMagicoMAX) {
        this.poderMagicoMAX = poderMagicoMAX;
    }

    public abstract void atacar(Warrior warrior, Monster monster);

}