package com.salatosik.JCA.models.leagues;

import com.salatosik.JCA.models.IconUrls;

import java.util.List;

public class Leagues {
    public static class Item {
        public long id;
        public String name;
        public IconUrls iconUrls;
    }

    public List<Item> items;
}