package io.github.vitalij3.JCA.models.clans;

import io.github.vitalij3.JCA.models.League;

import java.util.ArrayList;
import java.util.List;

public class ClanMembers {
    public static class Item {
        public String tag = "none", name = "none", role = "none";
        public int expLevel = 0, trophies = 0, versusTrophies = 0, clanRank = 0, previousClanRank = 0, donations = 0, donationsReceived = 0;
        public League league = new League();
    }

    public List<Item> items = new ArrayList<>();
}
