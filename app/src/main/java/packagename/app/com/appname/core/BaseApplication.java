package packagename.app.com.appname.core;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;
import packagename.app.com.appname.core.module.ApplicationModule;

public class BaseApplication extends Application {

   private ObjectGraph objectGraph;
   @Inject
   CrashTracker crashTracker;

   @Override
   public void onCreate() {
      super.onCreate();
      objectGraph = ObjectGraph.create(getModules().toArray());
      objectGraph.inject(this);
   }

   private List<Object> getModules() {
      return Arrays.<Object>asList(new ApplicationModule(this));
   }
}
