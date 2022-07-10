package com.salatosik.JCA.models.players;

import com.salatosik.JCA.models.BadgeUrls;
import com.salatosik.JCA.models.IconUrls;

import java.util.List;

public class Player {
    public String tag, name, role, warPreference;
    public int townHallLevel, expLevel, trophies, bestTrophies, warStars, attackWins, defenceWins, builderHallLevel, versusTrophies, bestVersusTrophies, versusBattleWins, donations, donationsReceived;

    public static class PlayerClan {
        public String tag, name;
        public int clanLevel;
        public BadgeUrls badgeUrls;
    }

    public PlayerClan clan;

    public static class Achievement {
        public String name, info, completionInfo, village;
        public int stars, value, target;
    }

    public List<Achievement> achievements;

    public int versusBattleWinCount;

    public static class Label {
        public long id;
        public String name;
        public IconUrls iconUrls;
    }

    List<Label> labels;

    public static class Troop {
        public String name, village;
        public int level, maxLevel;
    }

    public List<Troop> troops;

    public static class PlayerHero {
        public String name, village;
        public int level, maxLevel;
    }

    public List<PlayerHero> heroes;

    public static class Spell {
        public String name, village;
        public int level, maxLevel;
    }

    public List<Spell> spells;
}
