package io.github.vitalij3.JCA.models.leagues;

import io.github.vitalij3.JCA.models.IconUrls;

import java.util.ArrayList;
import java.util.List;

public class Leagues {
    public static class Item {
        public long id = 0;
        public String name = "none";
        public IconUrls iconUrls = new IconUrls();
    }

    public List<Item> items = new ArrayList<>();
}
