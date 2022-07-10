package io.github.vitalij3.JCA.models.locations;

import io.github.vitalij3.JCA.models.Clan;
import io.github.vitalij3.JCA.models.League;

import java.util.List;

public class RankingsPlayers {
    public static class Item {
        public String tag, name;
        public int expLevel, trophies, attackWins, rank, previousRank;
        public Clan clan;
        public League league;
    }

    public List<Item> items;
}
