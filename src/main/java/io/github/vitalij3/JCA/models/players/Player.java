package io.github.vitalij3.JCA.models.players;

import io.github.vitalij3.JCA.models.BadgeUrls;
import io.github.vitalij3.JCA.models.IconUrls;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String tag = "none", name = "none", role = "none", warPreference = "none";
    public int townHallLevel = 0, expLevel = 0, trophies = 0, bestTrophies = 0, warStars = 0, attackWins = 0, defenceWins = 0, builderHallLevel = 0,
            versusTrophies = 0, bestVersusTrophies = 0, versusBattleWins = 0, donations = 0, donationsReceived = 0;

    public static class PlayerClan {
        public String tag = "none", name = "none";
        public int clanLevel = 0;
        public BadgeUrls badgeUrls = new BadgeUrls();
    }

    public PlayerClan clan = new PlayerClan();

    public static class Achievement {
        public String name = "none", info = "none", completionInfo = "none", village = "none";
        public int stars = 0, value = 0, target = 0;
    }

    public List<Achievement> achievements = new ArrayList<>();

    public int versusBattleWinCount = 0;

    public static class Label {
        public long id = 0L;
        public String name = "none";
        public IconUrls iconUrls = new IconUrls();
    }

    List<Label> labels = new ArrayList<>();

    public static class Troop {
        public String name = "none", village = "none";
        public int level = 0, maxLevel = 0;
    }

    public List<Troop> troops = new ArrayList<>();

    public static class PlayerHero {
        public String name = "none", village = "none";
        public int level = 0, maxLevel = 0;
    }

    public List<PlayerHero> heroes = new ArrayList<>();

    public static class Spell {
        public String name = "none", village = "none";
        public int level = 0, maxLevel = 0;
    }

    public List<Spell> spells = new ArrayList<>();
}
