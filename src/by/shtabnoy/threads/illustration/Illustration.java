package by.shtabnoy.threads.illustration;

import by.shtabnoy.threads.collection.ClientList;
import by.shtabnoy.threads.collection.TaxiList;
import by.shtabnoy.threads.creation.ClientCreator;
import by.shtabnoy.threads.creation.TaxiCreator;
import by.shtabnoy.threads.reader.ClientReader;

import java.util.ArrayList;


public class Illustration {

    public static void main(String[] args) {
        ClientReader reader = new ClientReader();
        ClientCreator clientCreator = new ClientCreator();
        ArrayList<String> data = reader.readClientData("input\\input.txt");
        ClientList clientList = clientCreator.createFromData(data);
        TaxiCreator taxiCreator = new TaxiCreator();
        TaxiList taxiList = taxiCreator.createTaxiList(clientList.size() - 1);
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println(clientList.get(i));
        }
        for (int i = 0; i < taxiList.size(); i++) {
            System.out.println(taxiList.get(i));
        }
        for (int i = 0; i < clientList.size(); i++) {
            new Thread(clientList.get(i), "Client " + i).start();
        }
    }
}
