package by.shtabnoy.threads.creation;

import by.shtabnoy.threads.collection.ClientList;
import by.shtabnoy.threads.entity.Client;
import by.shtabnoy.threads.entity.Point;

import java.util.ArrayList;


public class ClientCreator {

    public ClientList createFromData(ArrayList<String> data) {
        ClientList clientList = ClientList.getInstance();
        for (String name : data) {
            Point position = new Point(Math.random(), Math.random());
            clientList.add(new Client(name, position));
        }
        return clientList;
    }

}
