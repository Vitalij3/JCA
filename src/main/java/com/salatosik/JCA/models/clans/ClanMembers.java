package com.salatosik.JCA.models.clans;

import com.salatosik.JCA.models.League;

import java.util.List;

public class ClanMembers {
    public static class Item {
        public String tag, name, role;
        public int expLevel, trophies, versusTrophies, clanRank, previousClanRank, donations, donationsReceived;
        public League league;
    }

    public List<Item> items;
}
