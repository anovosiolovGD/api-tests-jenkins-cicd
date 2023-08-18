package retrofit;

import api.BaseTest;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class BaseTestRetrofit extends BaseTest {

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.trello.com/1/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    protected final TrelloBoardService trelloBoardService = retrofit.create(TrelloBoardService.class);

}
