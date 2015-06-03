package vtc.edu.hk.idea;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import vtc.edu.hk.idea.api.RailGirlService;
import vtc.edu.hk.idea.data.IdeaItem;

/**
 * Created by Administrator on 6/2/2015.
 */
//http://stackoverflow.com/questions/15386948/can-i-use-asynctask-inside-listfragment-or-should-i-use-asynctaskloader
public class IdeaLoader extends AsyncTaskLoader<IdeaItem[]> {

    //TODO: You should change it to settings!
    //http://developer.android.com/tools/devices/emulator.html#emulatornetworking
    public static final String API_URL = "http://10.0.2.2:3000/";

    public IdeaLoader(Context context) {
        super(context);
    }

    @Override
    public IdeaItem[] loadInBackground() {

        //https://guides.codepath.com/android/Consuming-APIs-with-Retrofit
        // Define the interceptor, add authentication headers
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                //TODO: It is used for API with Authentication Headers
                //request.addHeader("User-Agent", "Retrofit-Sample-App");
            }
        };

        // Create a very simple REST adapter which points the GitHub API endpoint.
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .setRequestInterceptor(requestInterceptor)
                .build();
        RailGirlService apiService =
                restAdapter.create(RailGirlService.class);


        List<IdeaItem> ideas =  apiService.listIdeas();

        //Convert List to array!
        return ideas.toArray(new IdeaItem[ideas.size()]);
    }
}
