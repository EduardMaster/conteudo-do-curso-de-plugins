package net.eduard.curso.java.objetos;

public class FakeMaquina {
    private String dono;
    private FakeLocation local;

    public FakeLocation getLocal() {
        return local;
    }

    public void setLocal(FakeLocation local) {
        this.local = local;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }


}
