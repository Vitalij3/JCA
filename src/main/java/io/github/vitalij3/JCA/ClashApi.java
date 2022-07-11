package io.github.vitalij3.JCA;

import com.google.gson.Gson;
import io.github.vitalij3.JCA.exception.api.*;
import io.github.vitalij3.JCA.models.clans.ClanInfo;
import io.github.vitalij3.JCA.models.clans.ClanMembers;
import io.github.vitalij3.JCA.models.goldpass.CurrentGoldPass;
import io.github.vitalij3.JCA.models.labels.GeneralLabels;
import io.github.vitalij3.JCA.models.leagues.LeagueSeason;
import io.github.vitalij3.JCA.models.leagues.Leagues;
import io.github.vitalij3.JCA.models.leagues.WarLeague;
import io.github.vitalij3.JCA.models.locations.*;
import io.github.vitalij3.JCA.models.players.Player;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

 /**
  * General class for controlling all Clash Of Clans API functional
  * @author Vitalij
  * @version 1.2.4
 */
public class ClashApi {
    private final String API_KEY;
    private final OkHttpClient CLIENT = new OkHttpClient();
    private static final Gson GSON = new Gson();

    private final String HOST, API_VERSION;

   /**
    * @param apiToken the copied Clash of Clans API from site
    */
    public ClashApi(String apiToken) {
        this.API_KEY = apiToken;
        this.HOST = "https://api.clashofclans.com";
        this.API_VERSION = "v1";
    }

   /**
    * @param apiToken the copied Clash of Clans API from site
    * @param apiHost the api host
    * @param apiVersion the api version
    */
    @Deprecated
    public ClashApi(String apiToken, String apiHost, String apiVersion) {
        this.API_KEY = apiToken;
        this.HOST = apiHost;
        this.API_VERSION = apiVersion;
    }

    private static String formatTag(String copiedTag) {
        if(copiedTag.toCharArray()[0] == '#') return copiedTag.replace("#", "%23");
        else return "%23" + copiedTag;
    }

    private static Response checkResponse(Response response) {
        if(response.isSuccessful()) return response;

        try {
            switch(response.code()) {
                case 400: throw new ProvidedIncorrectParametersException(GSON.fromJson(response.body().string(), ProvidedIncorrectParametersException.class).message);
                case 403: throw new AccessDeniedException();
                case 404: throw new ResourceNotFoundException();
                case 429: throw new RequestThrottledException();
                case 500: throw new UnknownErrorHappenedException();
                case 503: throw new ServiceTemprorarilyException();
            }

        } catch(Exception exception) { exception.printStackTrace(); }

        return null;
    }

    /**
     * @param other the other parameters for https request.
     * @return request body
     */
    public String get(String other) {
        Request request = new Request.Builder()
                .header("authorization", "Bearer [api_key]".replace("[api_key]", API_KEY))
                .url("[host]/[version]/[other]"
                        .replace("[host]", HOST)
                        .replace("[version]", API_VERSION)
                        .replace("[other]", other))
                .build();

        try(Response response = CLIENT.newCall(request).execute()) {
            Response verifiedResponse = checkResponse(response);
            if(verifiedResponse != null) { return verifiedResponse.body().string(); }

        } catch(IOException ioException) { ioException.printStackTrace(); }

        return null;
    }

    public Player getPlayerStats(String playerTag) {
        String responseBodyString = get("players/[tag]".replace("[tag]", formatTag(playerTag)));
        return GSON.fromJson(responseBodyString, Player.class);
    }

    public CurrentGoldPass getCurrentGoldPass() {
        return GSON.fromJson(get("goldpass/seasons/current"), CurrentGoldPass.class);
    }

    public List<GeneralLabels.Item> getLabels() {
        return GSON.fromJson(get("labels/clans"), GeneralLabels.class).items;
    }

    public List<Location.Item> getLocations() {
        return GSON.fromJson(get("locations"), Location.class).items;
    }

    public OneLocation getLocationById(Long locationId) {
        return GSON.fromJson(get("locations/" + locationId.toString()), OneLocation.class);
    }

    public List<RankingsPlayersVersus.Item> getRankingsPlayersVersus(Long locationId) {
        return GSON.fromJson(get("locations/[id]/rankings/players-versus".replace("[id]", locationId.toString())),
                RankingsPlayersVersus.class).items;
    }

    public List<RankingsClansVersus.Item> getRankingsClanVersus(Long locationId) {
        return GSON.fromJson(get("locations/[location]/rankings/clans-versus".replace("[location]", locationId.toString())), RankingsClansVersus.class).items;
    }

    public List<RankingsPlayers.Item> getRankingPlayers(Long locationId) {
        return GSON.fromJson(get("locations/[location]/rankings/players".replace("[location]", locationId.toString())), RankingsPlayers.class).items;
    }

    public List<RankingsClans.Item> getRankingClans(Long locationId) {
        return GSON.fromJson(get("locations/[location]/rankings/clans".replace("[location]", locationId.toString())), RankingsClans.class).items;
    }

    public List<Leagues.Item> getLeagues() {
        return GSON.fromJson(get("leagues"), Leagues.class).items;
    }

    @Deprecated
    public List<LeagueSeason.Item> getLeagueSeasons(Long leagueId) {
        return GSON.fromJson(get("leagues/[id]/seasons".replace("[id]", leagueId.toString())), LeagueSeason.class).items;
    }

    public List<LeagueSeason.Item> getLeagueSeasons() {
        return getLeagueSeasons(29000022L);
    }

    public LeagueSeason.Item getLeagueInfo(Long leagueId) {
        return GSON.fromJson(get("leagues/[id]".replace("[id]", leagueId.toString())), LeagueSeason.Item.class);
    }

    public List<WarLeague.Item> getWarLeagues() {
        return GSON.fromJson(get("warleagues"), WarLeague.class).items;
    }

    public WarLeague.Item getWarLeagueInfo(@NotNull Long warLeagueId) {
        return GSON.fromJson(get("warleagues/[id]".replace("[id]", warLeagueId.toString())), WarLeague.Item.class);
    }

    public List<ClanMembers.Item> getClanMembers(String clanTag) {
        return GSON.fromJson(get("clans/[tag]/members".replace("[tag]", formatTag(clanTag))), ClanMembers.class).items;
    }

    public ClanInfo.Item getClanInfo(String clanTag) {
        return GSON.fromJson(get("clans/[tag]".replace("[tag]", formatTag(clanTag))), ClanInfo.Item.class);
    }
}
