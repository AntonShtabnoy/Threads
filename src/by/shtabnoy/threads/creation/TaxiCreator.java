package by.shtabnoy.threads.creation;

import by.shtabnoy.threads.collection.TaxiList;
import by.shtabnoy.threads.entity.Point;
import by.shtabnoy.threads.entity.Taxi;


public class TaxiCreator {

    public TaxiList createTaxiList(int size) {
        TaxiList taxiList = TaxiList.getInstance();
        for (int i = 0; i < size; i++) {
            taxiList.add(new Taxi(new Point(Math.random(), Math.random())));
        }
        return taxiList;
    }

}
