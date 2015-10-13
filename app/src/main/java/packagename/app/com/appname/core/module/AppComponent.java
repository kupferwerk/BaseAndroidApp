package packagename.app.com.appname.core.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import packagename.app.com.appname.SplashScreen;
import packagename.app.com.appname.core.BaseApplication;

@Singleton
@Component (modules = { ApplicationModule.class, WebserviceModule.class })
public interface AppComponent {

   BaseApplication application();

   Context context();

   void inject(SplashScreen splashScreen);
}
