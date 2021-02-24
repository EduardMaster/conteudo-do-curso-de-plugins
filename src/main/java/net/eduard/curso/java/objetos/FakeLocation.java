package net.eduard.curso.java.objetos;

import net.eduard.curso.java.TesteVelocidadeArrayList;

import java.util.Objects;

public class FakeLocation {
    String world;
    int x;
    int y;
    int z;
    int hash;

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {


        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FakeLocation that = (FakeLocation) o;
        return x == that.x &&
                y == that.y &&
                z == that.z &&
                Objects.equals(world, that.world);
    }

    @Override
    public int hashCode() {
        if (hash == 0) {
            hash = Objects.hash(world, x, y, z);
        }

        return hash;
    }
}
