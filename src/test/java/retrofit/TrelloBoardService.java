package retrofit;

import model.BoardData;
import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloBoardService {
    @GET("boards/{id}")
    Call<BoardData> getBoard(@Path("id") String boardId, @Query("key") String key, @Query("token") String token);

    @POST("boards/")
    Call<BoardData> createBoard(@Query("name") String boardName, @Query("key") String key, @Query("token") String token);

    @PUT("boards/{id}")
    Call<BoardData> changeBoardName(@Path("id") String boardId, @Query("key") String key, @Query("token") String token, @Query("name") String newBoardName);

    @DELETE("boards/{id}")
    Call<BoardData> deleteBoard(@Path("id") String boardId, @Query("key") String key, @Query("token") String token);
}
