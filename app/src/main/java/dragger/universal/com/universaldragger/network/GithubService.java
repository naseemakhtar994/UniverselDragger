package dragger.universal.com.universaldragger.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by naseem on 1/2/18.
 */

public interface GithubService {

    @GET("users/{username}/repos")
    Call<List<String>> getReposForUser(@Path("username") String username);

    @GET("repositories")
    Call<List<String>> getAllRepos();

    @GET("users/{username}")
    Call<String> getUser(@Path("username") String username);
}
