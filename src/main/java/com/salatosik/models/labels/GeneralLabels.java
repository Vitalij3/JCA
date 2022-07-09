package com.salatosik.models.labels;

import com.salatosik.models.IconUrls;

import java.util.List;

public class GeneralLabels {
    public static class Item {
        public String name;
        public long id;
        public IconUrls iconUrls;
    }

    public List<Item> items;
}
