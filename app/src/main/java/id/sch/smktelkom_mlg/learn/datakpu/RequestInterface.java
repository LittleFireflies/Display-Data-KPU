package id.sch.smktelkom_mlg.learn.datakpu;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LittleFireflies on 10-Dec-16.
 */

public interface RequestInterface {
    @GET("api.php?cmd=candidacy&candidacy_id=")
    Call<JSONResponse> getJSON(@Query("candidacy_id") String id);
}
