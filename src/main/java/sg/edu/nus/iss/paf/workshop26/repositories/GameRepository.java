package sg.edu.nus.iss.paf.workshop26.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf.workshop26.models.Game;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

@Repository
public class GameRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Game> search(Integer limit,
                                Integer offset)
    {
        final PageRequest pageable = PageRequest.of(offset, limit);
        Query query = new Query().with(pageable);

        return mongoTemplate.find(query, Document.class, "game")
                    .stream()
                    .map(t -> Game.fromJSON(t))
                    .toList();
    }

    public List<Game> getGamesByRank(){
        Query q= new Query();
        q.with(Sort.by(Sort.Direction.ASC, "ranking"));
        return mongoTemplate.find(q, Document.class, 
                    "game")
                    .stream()
                    .map(t -> Game.fromJSON(t))
                    .toList();
    }

    public Game getGameDetails(Integer gid){
        Query q= new Query();
        q.addCriteria(Criteria.where("gid").is(gid));
        return mongoTemplate.findOne(q, Game.class, 
                    "game");
    }
    
}
