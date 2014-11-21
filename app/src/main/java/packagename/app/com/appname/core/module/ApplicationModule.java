package packagename.app.com.appname.core.module;

import android.util.Log;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import packagename.app.com.appname.BuildConfig;
import packagename.app.com.appname.R;
import packagename.app.com.appname.core.BaseApplication;
import packagename.app.com.appname.core.CrashTracker;
import packagename.app.com.appname.core.SplashScreen;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

@Module (injects = {BaseApplication.class, SplashScreen.class})
public class ApplicationModule {
   public static final int CACHE_SIZE = 25 * 1024 * 1024;
   private BaseApplication app;

   public ApplicationModule(BaseApplication app) {
      this.app = app;
   }

   @Provides
   @Singleton
   public CrashTracker provideCrashTracker() {
      CrashTracker crashTracker = new CrashTracker(app);
      crashTracker.init();
      return crashTracker;
   }

   @Provides
   @Singleton
   public Picasso providePicasso() {
      Picasso.Builder imageLoaderBuilder = new Picasso.Builder(app);
      imageLoaderBuilder.executor(Executors.newSingleThreadExecutor());
      return imageLoaderBuilder.build();
   }

   @Provides
   @Singleton
   public RestAdapter provideRestAdapter() {
      RestAdapter.Builder builder = new RestAdapter.Builder();
      builder.setEndpoint(app.getString(R.string.base_url));
      if (BuildConfig.DEBUG) {
         builder.setLogLevel(RestAdapter.LogLevel.FULL);
      } else {
         builder.setLogLevel(RestAdapter.LogLevel.NONE);
      }
      OkHttpClient client = getHttpClient();
      builder.setClient(new OkClient(client));
      return builder.build();
   }

   private OkHttpClient getHttpClient() {
      File cacheDirectory = new File(app.getCacheDir().getAbsolutePath(), "HttpCache");
      Cache cache = null;
      try {
         cache = new Cache(cacheDirectory, CACHE_SIZE);
      } catch (IOException e) {
         Log.e(getClass().getSimpleName(), "Could not create http cache", e);
      }
      OkHttpClient client = new OkHttpClient();
      if (cache != null) {
         client.setCache(cache);
      }
      return client;
   }
}
