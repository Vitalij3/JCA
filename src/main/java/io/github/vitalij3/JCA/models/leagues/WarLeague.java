package io.github.vitalij3.JCA.models.leagues;

import java.util.ArrayList;
import java.util.List;

public class WarLeague {
    public static class Item {
        public long id = 0L;
        public String name = "none";
    }

    public List<Item> items = new ArrayList<>();
}
