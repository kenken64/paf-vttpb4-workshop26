package sg.edu.nus.iss.paf.workshop26.models;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Comment {
    private String user;
    private String text;
    private Integer rating;
    private Integer gameId;

    public Integer getGameId() {
        return gameId;
    }
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    @Override
    public String toString() {
        return "Comment [rating=" 
                + rating 
                + ", text=" 
                + text 
                + ", user=" 
                + user 
                + ", gameid=" 
                + gameId 
                + "]";
    }

    public JsonObject toJSON(){
        return Json.createObjectBuilder()
            .add("user", getUser())
            .add("text", getText() !=null? getText():"")
            .add("rating", getRating())
            .add("gid", getGameId())
            .build();
    }

    public static Comment fromJSON(Document json){
        Comment comment = new Comment();
        comment.setUser(json.getString("user"));
        comment.setText(json.getString("c_text"));
        comment.setRating(json.getInteger("rating"));
        comment.setGameId(json.getInteger("gid"));
        return comment;
    }


}
