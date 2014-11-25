package packagename.app.com.appname.core;

import android.content.Context;

import dagger.ObjectGraph;
import packagename.app.com.appname.core.module.TestModule;

public final class TestInjector {

   private static boolean initializedInjectorWithTestModule = false;

   public static void inject(final Context context, final Object target) {
      if (Injector.objectGraph == null || !initializedInjectorWithTestModule) {
         Injector.objectGraph = ObjectGraph.create(new TestModule(context));
         initializedInjectorWithTestModule = true;
      }
      Injector.objectGraph.inject(target);
   }

   public static <T> T resolve(Class<T> type) {
      return Injector.objectGraph.get(type);
   }
}
