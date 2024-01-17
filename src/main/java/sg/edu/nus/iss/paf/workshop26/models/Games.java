package sg.edu.nus.iss.paf.workshop26.models;

import java.util.List;

import org.joda.time.DateTime;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

public class Games {
    private List<Game> games;
    private Integer limit;
    private Integer offset;
    private Integer total;
    private DateTime timestamp;

    public List<Game> getGames() {
        return games;
    }
    public void setGames(List<Game> games) {
        this.games = games;
    }
    public Integer getLimit() {
        return limit;
    }
    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    public Integer getOffset() {
        return offset;
    }
    public void setOffset(Integer offset) {
        this.offset = offset;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public DateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }

    public JsonObject toJSON(){
        JsonArrayBuilder gamesBuilder = Json.createArrayBuilder();
        List<JsonObject> games = this.getGames()
            .stream()
            .map(t -> t.toJSON())
            .toList();
         
         for(JsonObject x: games)
            gamesBuilder.add(x);

        return Json.createObjectBuilder()
            .add("games", gamesBuilder)
            .add("limit", getLimit())
            .add("offset", getOffset())
            .add("total", getTotal())
            .add("timestamp", getTimestamp().toString())
            .build();
    }
}
