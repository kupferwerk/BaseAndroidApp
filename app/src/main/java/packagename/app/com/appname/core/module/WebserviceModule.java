package packagename.app.com.appname.core.module;

import android.content.Context;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.concurrent.Executors;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import packagename.app.com.appname.BuildConfig;
import packagename.app.com.appname.R;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
      OkHttpClient.Builder builder = new OkHttpClient.Builder();
      if (loggingInterceptor != null) {
         builder.addInterceptor(loggingInterceptor);
      }
      builder.cache(cache);
      return builder.build();
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
   OkHttpDownloader provideOkHttpDownloader(Context context) {
      return new OkHttpDownloader(context, CACHE_SIZE);
   }

   @Provides
   @Singleton
   Picasso providePicasso(Context context, OkHttpDownloader downloader) {
      return new Picasso.Builder(context).executor(Executors.newSingleThreadExecutor())
            .downloader(downloader)
            .indicatorsEnabled(BuildConfig.IS_IDE_BUILD)
            .build();
   }

   @Provides
   @Singleton
   Retrofit provideRetrofit(Context context, OkHttpClient client) {
      return new Retrofit.Builder().baseUrl(context.getString(R.string.base_url))
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();
   }
}


