package io.github.salatosik.JCA.models.locations;

import java.util.List;

public class RankingsClans {
    public static class Item {
        public String tag, name;
        public LocationUpdated location;
        public int clanLevel, members, clanPoints, rank, previousRank;
    }

    public List<RankingsClans.Item> items;
}
