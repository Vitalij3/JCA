package com.github.salatosik.JCA.models.clans;

import com.github.salatosik.JCA.models.BadgeUrls;
import com.github.salatosik.JCA.models.leagues.WarLeague;
import com.github.salatosik.JCA.models.ChatLanguage;

import java.util.List;

public class ClanInfo {
    public static class Location extends com.github.salatosik.JCA.models.locations.Location.Item {
        public String countryCode;
    }

    public static class Item {
        public String tag, name, type, description, warFrequency;
        public Location location;
        public BadgeUrls badgeUrls;

        public int clanLevel, clanPoints, clanVersusPoints, requiredPoints, requiredTrophies, warWinStreak, warWins, members, requiredVersusTrophies, requiredTownhallLevel;
        public boolean isWarLogPublic;
        public WarLeague.Item warLeague;
        public List<ClanMembers.Item> memberList;

        public ChatLanguage chatLanguage;
    }

    public List<Item> items;
}