package com.salatosik.models.locations;

import com.salatosik.models.BadgeUrls;
import com.salatosik.models.Clan;
import com.salatosik.models.players.Player;

import java.util.List;

public class RankingsPlayersVersus {
    public static class Item {
        public String tag, name;
        public int expLevel, rank, previousRank, versusRank, versusBattleWins;

        public Clan clan;
    }

    public List<RankingsPlayersVersus.Item> items;
}
