package io.github.vitalij3.JCA.models.locations;

import java.util.List;

public class Location {
    public static class Item {
        public long id;
        public String name;
        public boolean isCountry;
    }

    public List<Location.Item> items;
}
