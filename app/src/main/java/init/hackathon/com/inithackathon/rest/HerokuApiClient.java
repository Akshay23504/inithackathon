package init.hackathon.com.inithackathon.rest;


import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class HerokuApiClient {

    private static final String BASE_URL = "http://init-bored.herokuapp.com";
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
