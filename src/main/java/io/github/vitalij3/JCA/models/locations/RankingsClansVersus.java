package io.github.vitalij3.JCA.models.locations;

import io.github.vitalij3.JCA.models.BadgeUrls;

import java.util.ArrayList;
import java.util.List;

public class RankingsClansVersus {
    public static class Item {
        public String tag = "none", name = "none";
        public LocationUpdated location = new LocationUpdated();
        public BadgeUrls badgeUrls = new BadgeUrls();

        public int clanLevel = 0, members = 0, rank = 0, previousRank = 0, clanVersusPoints = 0;
    }

    public List<Item> items = new ArrayList<>();
}
