package sg.edu.nus.iss.paf.workshop26.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf.workshop26.models.Comment;
import sg.edu.nus.iss.paf.workshop26.models.Game;
import sg.edu.nus.iss.paf.workshop26.repositories.CommentRepository;
import sg.edu.nus.iss.paf.workshop26.repositories.GameRepository;

@Service
public class SearchBGGService {
    @Autowired
    private GameRepository gameRepo;

    @Autowired CommentRepository commentRepo;

    public List<Game> searchGame(Integer limit, Integer offset){
        return gameRepo.search(limit, offset);
    }

    public List<Game> getGamesByRank(){
        return gameRepo.getGamesByRank();
    }

    public Game getGameDetails(Integer gid){
        return gameRepo.getGameDetails(gid);
    }

    public List<Comment> searchComment(String q, Float score, Integer limit, Integer offset) {
        List<String> includes = new LinkedList<>();
        List<String> excludes = new LinkedList<>();

        for (String w : q.split(" ")) {
            if (w.startsWith("-")) {
                String[] exW = w.split("-");
                excludes.add(exW[1]);
            } else {
                includes.add(w);
            }
        }
        System.out.println(excludes);
        System.out.println("--------------");
        System.out.println(includes);

        return commentRepo.search(includes, excludes, limit, offset);
    }

}
