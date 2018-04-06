package by.shtabnoy.threads.collection;

import by.shtabnoy.threads.entity.Client;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;


public class ClientList {

    private static ClientList INSTANCE = null;
    private ArrayList<Client> clientArrayList;
    private static ReentrantLock lock = new ReentrantLock();

    private ClientList() {
        clientArrayList = new ArrayList<>();
    }

    public static ClientList getInstance() {
        lock.lock();
        try {
            if (INSTANCE == null) {
                INSTANCE = new ClientList();
            }
        } finally {
            lock.unlock();
        }
        return INSTANCE;
    }

    public int size() {
        return clientArrayList.size();
    }

    public void add(Client client) {
        clientArrayList.add(client);
    }

    public Client get(int index) {
        return clientArrayList.get(index);
    }
}
