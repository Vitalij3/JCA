package com.github.salatosik.JCA.models.locations;

import java.util.List;

public class Location {
    public static class Item {
        public long id;
        public String name;
        public boolean isCountry;
    }

    public List<Location.Item> items;
}
