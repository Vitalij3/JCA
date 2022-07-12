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
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

 /**
  * General class for controlling all Clash Of Clans API functional
  * @author Vitalij
  * @version 1.3.2
 */
public class ClashApi {
    private final String API_KEY;
    private final OkHttpClient CLIENT = new OkHttpClient();
    private static final Gson GSON = new Gson();

    private final String HOST, API_VERSION;

   /**
    * @param apiToken the copied Clash of Clans API from site
    */
    public ClashApi(String apiToken) throws ClashOfClansApiException {
        this.API_KEY = apiToken;
        this.HOST = "https://api.clashofclans.com";
        this.API_VERSION = "v1";

        if(!check()) throw new AccessDeniedException("Check result is not normal. Check the internet connection or the correctness of the api token.");
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

    @NotNull
    private static String formatTag(@NotNull String copiedTag) {
        if(copiedTag.toCharArray()[0] == '#') return copiedTag.replace("#", "%23");
        else return "%23" + copiedTag;
    }

    @Nullable
    private static Response checkResponse(@NotNull Response response) throws ClashOfClansApiException {
        if(response.isSuccessful()) return response;

        String incorrectParameterExceptionText = "not found";

        try { incorrectParameterExceptionText = response.body().string(); }
        catch(IOException ignored) {}

        switch(response.code()) {
            case 400: throw new ProvidedIncorrectParametersException(GSON.fromJson(incorrectParameterExceptionText, ProvidedIncorrectParametersException.class).message);
            case 403: throw new AccessDeniedException();
            case 404: throw new ResourceNotFoundException();
            case 429: throw new RequestThrottledException();
            case 500: throw new UnknownErrorHappenedException();
            case 503: throw new ServiceTemprorarilyException();
        }

        return null;
    }

    /**
     * @param other the other parameters for https request.
     * @return request body
     */
    public String get(String other) throws ClashOfClansApiException {
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

     /**
      * The method makes a normal https request to the server API to check the status.
      * @return status
      */
    public boolean check() {
        try { get("goldpass/seasons/current"); } catch(ClashOfClansApiException clashOfClansApiException) { return false; }
        return true;
    }

    public Player getPlayerStats(String playerTag) throws ClashOfClansApiException {
        String responseBodyString = get("players/[tag]".replace("[tag]", formatTag(playerTag)));
        return GSON.fromJson(responseBodyString, Player.class);
    }

    public CurrentGoldPass getCurrentGoldPass() throws ClashOfClansApiException {
        return GSON.fromJson(get("goldpass/seasons/current"), CurrentGoldPass.class);
    }

    public List<GeneralLabels.Item> getLabels() throws ClashOfClansApiException {
        return GSON.fromJson(get("labels/clans"), GeneralLabels.class).items;
    }

    public List<Location.Item> getLocations() throws ClashOfClansApiException {
        return GSON.fromJson(get("locations"), Location.class).items;
    }

    public OneLocation getLocationById(Long locationId) throws ClashOfClansApiException {
        return GSON.fromJson(get("locations/" + locationId.toString()), OneLocation.class);
    }

    public List<RankingsPlayersVersus.Item> getRankingsPlayersVersus(Long locationId) throws ClashOfClansApiException {
        return GSON.fromJson(get("locations/[id]/rankings/players-versus".replace("[id]", locationId.toString())),
                RankingsPlayersVersus.class).items;
    }

    public List<RankingsClansVersus.Item> getRankingsClanVersus(Long locationId) throws ClashOfClansApiException {
        return GSON.fromJson(get("locations/[location]/rankings/clans-versus".replace("[location]", locationId.toString())), RankingsClansVersus.class).items;
    }

    public List<RankingsPlayers.Item> getRankingPlayers(Long locationId) throws ClashOfClansApiException {
        return GSON.fromJson(get("locations/[location]/rankings/players".replace("[location]", locationId.toString())), RankingsPlayers.class).items;
    }

    public List<RankingsClans.Item> getRankingClans(Long locationId) throws ClashOfClansApiException {
        return GSON.fromJson(get("locations/[location]/rankings/clans".replace("[location]", locationId.toString())), RankingsClans.class).items;
    }

    public List<Leagues.Item> getLeagues() throws ClashOfClansApiException {
        return GSON.fromJson(get("leagues"), Leagues.class).items;
    }

    @Deprecated
    public List<LeagueSeason.Item> getLeagueSeasons(Long leagueId) throws ClashOfClansApiException {
        return GSON.fromJson(get("leagues/[id]/seasons".replace("[id]", leagueId.toString())), LeagueSeason.class).items;
    }

    public List<LeagueSeason.Item> getLeagueSeasons() throws ClashOfClansApiException {
        return getLeagueSeasons(29000022L);
    }

    public LeagueSeason.Item getLeagueInfo(Long leagueId) throws ClashOfClansApiException {
        return GSON.fromJson(get("leagues/[id]".replace("[id]", leagueId.toString())), LeagueSeason.Item.class);
    }

    public List<WarLeague.Item> getWarLeagues() throws ClashOfClansApiException {
        return GSON.fromJson(get("warleagues"), WarLeague.class).items;
    }

    public WarLeague.Item getWarLeagueInfo(@NotNull Long warLeagueId) throws ClashOfClansApiException {
        return GSON.fromJson(get("warleagues/[id]".replace("[id]", warLeagueId.toString())), WarLeague.Item.class);
    }

    public List<ClanMembers.Item> getClanMembers(String clanTag) throws ClashOfClansApiException {
        return GSON.fromJson(get("clans/[tag]/members".replace("[tag]", formatTag(clanTag))), ClanMembers.class).items;
    }

    public ClanInfo.Item getClanInfo(String clanTag) throws ClashOfClansApiException {
        return GSON.fromJson(get("clans/[tag]".replace("[tag]", formatTag(clanTag))), ClanInfo.Item.class);
    }
}
