package io.github.vitalij3.JCA.models.locations;

import java.util.List;

public class RankingsClans {
    public static class Item {
        public String tag = "none", name = "none";
        public LocationUpdated location = new LocationUpdated();
        public int clanLevel = 0, members = 0, clanPoints = 0, rank = 0, previousRank = 0;
    }

    public List<RankingsClans.Item> items;
}
