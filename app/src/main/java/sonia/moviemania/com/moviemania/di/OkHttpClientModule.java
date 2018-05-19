package sonia.moviemania.com.moviemania.di;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import sonia.moviemania.com.moviemania.di.MovieApplicationScope;

@Module
public class OkHttpClientModule {

    @MovieApplicationScope
    @Provides
    public OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient().newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    public HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

}
