package io.github.salatosik.JCA.models.locations;

import io.github.salatosik.JCA.models.Clan;

import java.util.List;

public class RankingsPlayersVersus {
    public static class Item {
        public String tag, name;
        public int expLevel, rank, previousRank, versusRank, versusBattleWins;

        public Clan clan;
    }

    public List<RankingsPlayersVersus.Item> items;
}
