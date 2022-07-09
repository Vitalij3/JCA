package com.salatosik.models.clans;

import com.salatosik.models.BadgeUrls;
import com.salatosik.models.ChatLanguage;
import com.salatosik.models.leagues.WarLeague;

import java.util.List;

public class ClanInfo {
    public static class Location extends com.salatosik.models.locations.Location.Item {
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
