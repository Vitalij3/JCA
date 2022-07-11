package io.github.vitalij3.JCA.models.labels;

import io.github.vitalij3.JCA.models.IconUrls;

import java.util.ArrayList;
import java.util.List;

public class GeneralLabels {
    public static class Item {
        public String name = "none";
        public long id = 0L;
        public IconUrls iconUrls = new IconUrls();
    }

    public List<Item> items = new ArrayList<>();
}
