package io.github.vitalij3.JCA.models.clans;

import io.github.vitalij3.JCA.models.BadgeUrls;
import io.github.vitalij3.JCA.models.leagues.WarLeague;
import io.github.vitalij3.JCA.models.ChatLanguage;

import java.util.List;

public class ClanInfo {
    public static class Location extends io.github.vitalij3.JCA.models.locations.Location.Item {
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
