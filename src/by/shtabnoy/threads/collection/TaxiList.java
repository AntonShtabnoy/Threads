package by.shtabnoy.threads.collection;

import by.shtabnoy.threads.action.PointAction;
import by.shtabnoy.threads.entity.Client;
import by.shtabnoy.threads.entity.Taxi;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;


public class TaxiList {

    private static TaxiList INSTANCE = null;
    private ArrayList<Taxi> taxiArrayList;
    private static ReentrantLock lock = new ReentrantLock();

    public TaxiList() {
        taxiArrayList = new ArrayList<>();
    }

    public static TaxiList getInstance() {
        lock.lock();
        if (INSTANCE == null) {
            INSTANCE = new TaxiList();
        }
        lock.unlock();
        return INSTANCE;
    }

    public void add(Taxi taxi) {
        taxiArrayList.add(taxi);
    }

    public Taxi get(int index) {
        return taxiArrayList.get(index);
    }

    public int size() {
        return taxiArrayList.size();
    }

    public Taxi call(Client client) {
        PointAction pointAction = new PointAction();
        Taxi neededTaxi;
        boolean isFind = false;
        double minLength = Double.MAX_VALUE;
        int nearestTaxiIndex = -1;
        double length;
        while (!isFind) {
            for (int i = 0; i < size(); i++) {
                length = pointAction.length(client.getPosition(), get(i).getPosition());
                if (!get(i).isBusy() && length < minLength) {
                    minLength = length;
                    nearestTaxiIndex = i;
                    isFind = true;
                }
            }
        }
        neededTaxi = get(nearestTaxiIndex);

        neededTaxi.call();
        return neededTaxi;
    }

}
