package io.github.vitalij3.JCA.models.locations;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public static class Item {
        public long id = 0L;
        public String name = "none";
        public boolean isCountry = false;
    }

    public List<Location.Item> items = new ArrayList<>();
}
