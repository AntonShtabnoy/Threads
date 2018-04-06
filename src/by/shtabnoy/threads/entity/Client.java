package by.shtabnoy.threads.entity;

import by.shtabnoy.threads.collection.TaxiList;
import by.shtabnoy.threads.action.PointAction;
import by.shtabnoy.threads.util.AppConstant;

import java.util.concurrent.TimeUnit;


public class Client implements Runnable {

    private String name;
    private Point position;

    public Client(String name, Point position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (!name.equals(client.name)) return false;
        return position.equals(client.position);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }

    @Override
    public void run() {
        Point destination = new Point(Math.random(), Math.random());
        TaxiList taxiList = TaxiList.getInstance();
        Taxi clientTaxi = taxiList.call(this);
        PointAction pointAction = new PointAction();
        double time = (pointAction.length(clientTaxi.getPosition(), position) + pointAction.length(position, destination)) / AppConstant.TAXI_SPEED;
        try {
            TimeUnit.SECONDS.sleep((long) time);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        clientTaxi.setBusy(false);
        clientTaxi.setPosition(destination);
        System.out.println(toString() + " was delivered by taxi #" + clientTaxi.getId() + " to point " + destination);
        position = destination;
    }

    @Override
    public String toString() {
        return "Client " + name + " at point " + position;
    }

}
