package init.hackathon.com.inithackathon.rest;

import com.facebook.AccessToken;

import java.util.List;

import init.hackathon.com.inithackathon.models.MovieResponse;
import init.hackathon.com.inithackathon.models.RequestMovieData;
import init.hackathon.com.inithackathon.models.RequestMusicData;
import init.hackathon.com.inithackathon.models.ResponseMovieData;
import init.hackathon.com.inithackathon.models.ResponseMusicData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("me")
    Call<RequestMusicData> getMusicLiked(@Query("fields") String music, @Query("access_token") String accessToken);

    @GET("me")
    Call<RequestMovieData> getMovieLiked(@Query("fields") String music, @Query("access_token") String accessToken);

    @POST
    Call<List<ResponseMusicData>> getSimilarMusic(@Url String url);

    @POST
    Call<List<ResponseMovieData>> getSimilarMovie(@Url String url);

}
