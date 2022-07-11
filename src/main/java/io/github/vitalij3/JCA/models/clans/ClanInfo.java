package io.github.vitalij3.JCA.models.clans;

import io.github.vitalij3.JCA.models.BadgeUrls;
import io.github.vitalij3.JCA.models.leagues.WarLeague;
import io.github.vitalij3.JCA.models.ChatLanguage;

import java.util.ArrayList;
import java.util.List;

public class ClanInfo {
    public static class Location extends io.github.vitalij3.JCA.models.locations.Location.Item {
        public String countryCode = "none";
    }

    public static class Item {
        public String tag = "none", name = "none", type = "none", description = "none", warFrequency = "none";
        public Location location = new Location();
        public BadgeUrls badgeUrls = new BadgeUrls();

        public int clanLevel = 0, clanPoints = 0, clanVersusPoints = 0, requiredPoints = 0, requiredTrophies = 0, warWinStreak = 0,
                warWins = 0, members = 0, requiredVersusTrophies = 0, requiredTownhallLevel = 0;

        public boolean isWarLogPublic = false;
        public WarLeague.Item warLeague = new WarLeague.Item();
        public List<ClanMembers.Item> memberList = new ArrayList<>();

        public ChatLanguage chatLanguage = new ChatLanguage();
    }

    public List<Item> items = new ArrayList<>();
}
