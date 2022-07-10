package io.github.salatosik.JCA.models.labels;

import io.github.salatosik.JCA.models.IconUrls;

import java.util.List;

public class GeneralLabels {
    public static class Item {
        public String name;
        public long id;
        public IconUrls iconUrls;
    }

    public List<Item> items;
}
