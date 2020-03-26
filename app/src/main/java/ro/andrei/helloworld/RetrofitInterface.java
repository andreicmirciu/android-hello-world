package ro.andrei.helloworld;

import retrofit2.Call;
import retrofit2.http.GET;
import ro.andrei.helloworld.models.TmdbResponse;

public interface RetrofitInterface {
    @GET("discover/movie?primary_release_date.gte=2019-04-15&primary_release_date.lte=2019-05-16&api_key=fb2049f6e8fe9f273c6f2d894feced24")
    Call<TmdbResponse> getCurrentMovies();
}
