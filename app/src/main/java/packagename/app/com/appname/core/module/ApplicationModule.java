package packagename.app.com.appname.core.module;

import com.squareup.picasso.Picasso;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import packagename.app.com.appname.core.BaseApplication;
import packagename.app.com.appname.core.CrashTracker;

@Module (injects = {BaseApplication.class, Picasso.class})
public class ApplicationModule {
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
}
