package packagename.app.com.appname.core.module;

import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import packagename.app.com.appname.core.BaseApplication;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class ApplicationModuleTest {

   private BaseApplication application;
   private ApplicationModule applicationModule;

   @Before
   public void setUp() throws Exception {
      application = (BaseApplication) InstrumentationRegistry.getTargetContext()
            .getApplicationContext();
      applicationModule = new ApplicationModule(application);
   }

   @Test
   public void testProvideCrashTracker() {
      assertThat(applicationModule.provideCrashTracker(application), notNullValue());
   }
}
