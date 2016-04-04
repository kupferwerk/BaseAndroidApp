package packagename.app.com.appname.core.module;

import android.content.Context;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import packagename.app.com.appname.BuildConfig;
import packagename.app.com.appname.R;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

@Module
public class WebserviceModule {

   private static final int CACHE_SIZE = 25 * 1024 * 1024;
   private static final String OKHTTP_LOGGING_INTERCEPTOR = "OKHTTP_LOGGING_INTERCEPTOR";

   @Provides
   @Singleton
   Cache provideHttpCache(Context context) {
      final File cacheDirectory = new File(context.getCacheDir(), "HttpCache");
      return new Cache(cacheDirectory, CACHE_SIZE);
   }

   @Provides
   @Singleton
   OkHttpClient provideHttpClient(Cache cache,
         @Named (OKHTTP_LOGGING_INTERCEPTOR) Interceptor loggingInterceptor) {
      final OkHttpClient client = new OkHttpClient();
      client.setCache(cache);
      if (loggingInterceptor != null) {
         client.interceptors()
               .add(loggingInterceptor);
      }
      return client;
   }

   @Provides
   @Singleton
   @Named (OKHTTP_LOGGING_INTERCEPTOR)
   Interceptor provideHttpLoggingInterceptor() {
      HttpLoggingInterceptor httpLoggingInterceptor = null;
      if (BuildConfig.DEBUG) {
         httpLoggingInterceptor = new HttpLoggingInterceptor();
         httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      }
      return httpLoggingInterceptor;
   }

   @Provides
   @Singleton
   Picasso providePicasso(Context context, OkHttpClient client) {
      Picasso.Builder imageLoaderBuilder = new Picasso.Builder(context);
      imageLoaderBuilder.executor(Executors.newSingleThreadExecutor());
      imageLoaderBuilder.downloader(new OkHttpDownloader(client));
      imageLoaderBuilder.indicatorsEnabled(BuildConfig.IS_IDE_BUILD);
      return imageLoaderBuilder.build();
   }

   @Provides
   @Singleton
   Retrofit provideRetrofit(Context context, OkHttpClient client) {
      Retrofit.Builder builder =
            new Retrofit.Builder().baseUrl(context.getString(R.string.base_url))
                  .addConverterFactory(GsonConverterFactory.create());
      builder.client(client);
      return builder.build();
   }
}


