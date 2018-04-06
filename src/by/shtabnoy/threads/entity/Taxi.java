package by.shtabnoy.threads.entity;

import by.shtabnoy.threads.util.IdGenerator;

import java.util.concurrent.locks.ReentrantLock;


public class Taxi {

    private Long id;
    private Point position;
    private boolean isBusy;
    private ReentrantLock lock = new ReentrantLock();

    public Taxi(Point position) {
        this.id = IdGenerator.generate();
        this.position = position;
        this.isBusy = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Taxi taxi = (Taxi) o;

        if (isBusy != taxi.isBusy) return false;
        if (!id.equals(taxi.id)) return false;
        return position.equals(taxi.position);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + (isBusy ? 1 : 0);
        return result;
    }

    public boolean call() {
        lock.lock();
        try {
            if (isBusy) {
                return false;
            }
            isBusy = true;
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Taxi #" + id + " at point " + position;
    }
}
