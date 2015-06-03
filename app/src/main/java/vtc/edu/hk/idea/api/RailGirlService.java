package vtc.edu.hk.idea.api;

import java.util.List;

import retrofit.http.GET;
import vtc.edu.hk.idea.data.IdeaItem;


//http://square.github.io/retrofit/
public interface RailGirlService {

    @GET("/ideas.json")
    List<IdeaItem> listIdeas();

    @GET("/ideas/{id}.json")
    IdeaItem getIdea(int id);
}
