package io.github.vitalij3.JCA.models.locations;

import io.github.vitalij3.JCA.models.Clan;
import io.github.vitalij3.JCA.models.League;

import java.util.ArrayList;
import java.util.List;

public class RankingsPlayers {
    public static class Item {
        public String tag = "none", name = "none";
        public int expLevel = 0, trophies = 0, attackWins = 0, rank = 0, previousRank = 0;
        public Clan clan = new Clan();
        public League league = new League();
    }

    public List<Item> items = new ArrayList<>();
}
