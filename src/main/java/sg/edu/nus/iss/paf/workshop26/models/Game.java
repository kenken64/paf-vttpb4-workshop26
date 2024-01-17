package sg.edu.nus.iss.paf.workshop26.models;


import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Game {
    private Integer gid;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer user_rated;
    private String url;
    private String image;

    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getRanking() {
        return ranking;
    }
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
    public Integer getUser_rated() {
        return user_rated;
    }
    public void setUser_rated(Integer user_rated) {
        this.user_rated = user_rated;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    

    @Override
    public String toString() {
        return "Game [gid=" 
                .concat("" + gid)
                .concat(", name=")
                .concat(name)
                .concat(", year=")
                .concat("" + year)
                .concat(", ranking=") 
                .concat(""+ ranking)
                .concat(", user_rated=")
                .concat("" + user_rated) 
                .concat(", url=")
                .concat(url) 
                .concat(", image=") 
                .concat(image) 
                .concat("]");
    }

    public JsonObject toJSON(){
        return Json.createObjectBuilder()
            .add("gid", getGid())
            .add("name", getName())
            .add("year", getYear())
            .add("ranking", getRanking())
            .add("user_rated", getUser_rated() != null? getUser_rated(): 0)
            .add("url", getUrl())
            .add("image", getImage())
            .build();
    }

    public static Game fromJSON(Document jsonObject){
        Game game = new Game();
        game.setGid(jsonObject.getInteger("gid"));
        game.setName(jsonObject.getString("name"));
        game.setYear(jsonObject.getInteger("year"));
        game.setRanking(jsonObject.getInteger("ranking"));
        game.setUser_rated(jsonObject.getInteger("user_rated"));
        game.setUrl(jsonObject.getString("url"));
        game.setImage(jsonObject.getString("image"));
        return game;
    }
    
    
}
