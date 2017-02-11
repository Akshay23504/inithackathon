package init.hackathon.com.inithackathon.rest;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiClient {

    //    private static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static final String BASE_URL = "https://graph.facebook.com/v2.8/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
