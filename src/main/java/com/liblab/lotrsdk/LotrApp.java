package com.liblab.lotrsdk;

import com.liblab.lotrsdk.config.PageCriteria;
import com.liblab.lotrsdk.config.RestClient;
import com.liblab.lotrsdk.model.Movie;
import com.liblab.lotrsdk.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
public class LotrApp {

    private String apiKey;
    private static final String REST_URI = "https://the-one-api.dev/v2/movie";
    @Autowired
    private RestClient restClient;

    public LotrApp(String apiKey){
        this.apiKey = apiKey;
    }

    /**
     * method to fetch a movie by id from the LOTR one movie API
     * @param id
     * @return
     */
    public Movie getMovieById(int id, PageCriteria criteria) {
        return restClient.getClient()
                .target(REST_URI)
                .path(String.valueOf(id)).path(criteria.getCriteria())
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", apiKey)
                .get(Movie.class);
    }
    /**
     * method to fetch all quotes from a movie from the LOTR one movie API
     * @param id
     * @return
     */
    public List<String> getMovieQuote(int id, PageCriteria criteria) {
        return restClient.getClient()
                .target(REST_URI)
                .path(String.valueOf(id)).path(criteria.getCriteria())
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", apiKey)
                .get(Movie.class).getQuotes();
    }
    /**
     * method to fetch all movies from the LOTR one movie API
     * @return
     */
    public List<Movie> getAllMovies(PageCriteria criteria, Movie.MovieCriteria movieCriteria) {
            Response response = restClient.getClient()
                .target(REST_URI).path(criteria.getCriteria()).path(movieCriteria.getCriteria())
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", apiKey)
                .get();
            return response.readEntity(Movies.class).getMovies();
    }




}
