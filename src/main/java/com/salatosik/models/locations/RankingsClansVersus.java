package com.salatosik.models.locations;

import com.salatosik.models.BadgeUrls;

import java.util.List;

public class RankingsClansVersus {
    public static class Item {
        public String tag, name;
        public LocationUpdated location;
        public BadgeUrls badgeUrls;

        public int clanLevel, members, rank, previousRank, clanVersusPoints;
    }

    public List<Item> items;
}
