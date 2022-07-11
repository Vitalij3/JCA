package io.github.vitalij3.JCA.models.locations;

import io.github.vitalij3.JCA.models.Clan;

import java.util.ArrayList;
import java.util.List;

public class RankingsPlayersVersus {
    public static class Item {
        public String tag = "none", name = "none";
        public int expLevel = 0, rank = 0, previousRank = 0, versusRank = 0, versusBattleWins = 0;

        public Clan clan = new Clan();
    }

    public List<RankingsPlayersVersus.Item> items = new ArrayList<>();
}
