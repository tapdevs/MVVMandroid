package com.tapdevs.myapp.data;

import android.content.Context;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.data.remote.ApiCalls;
import com.tapdevs.myapp.injections.component.DaggerNetComponent;
import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.models.Article;
import com.tapdevs.myapp.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Func1;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

public class DataManager {

    @Inject
    protected ApiCalls apiCalls;
    @Inject protected Scheduler mSubscribeScheduler;

    public DataManager(Context context) {
        injectDependencies(context);
    }

    public DataManager(ApiCalls apiCalls,
                       Scheduler subscribeScheduler) {
        this.apiCalls = apiCalls;
        mSubscribeScheduler = subscribeScheduler;
    }

    protected void injectDependencies(Context context) {
//        DaggerNetComponent.builder()
//                .appModule(new AppModule((MyApp).get()))
//                .dataManagerModule(new NetModule(AppConstants.NEWS_API_KEY))
//                .build()
//                .inject(this);
    }

    public Scheduler getScheduler() {
        return mSubscribeScheduler;
    }

    public Observable<List<Article>> getTopStories(String newsPaperName) {
        return apiCalls.getTopStories(newsPaperName, AppConstants.NEWS_API_KEY);
//                .concatMap(new Func1<List<Long>, Observable<? extends Article>>() {
//                    @Override
//                    public Observable<? extends Article> call(List<Long> longs) {
//                        return getPostsFromIds(longs);
//                    }
//                });
    }

//    public Observable<Article> getPostsFromIds(List<Long> storyIds) {
//        return Observable.from(storyIds)
//                .concatMap(new Func1<Long, Observable<Post>>() {
//                    @Override
//                    public Observable<Post> call(Long aLong) {
//                        return apiCalls.getStoryItem(String.valueOf(aLong));
//                    }
//                }).flatMap(new Func1<Post, Observable<Post>>() {
//                    @Override
//                    public Observable<Post> call(Post post) {
//                        return post.title != null ? Observable.just(post) : Observable.<Post>empty();
//                    }
//                });
//    }


}
