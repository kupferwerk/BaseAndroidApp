package packagename.app.com.appname.core.module;

import android.test.AndroidTestCase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class ApplicationModuleTest extends AndroidTestCase {

   private ApplicationModule applicationModule;

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      applicationModule = new ApplicationModule();
   }

   public void testProvideCrashTracker(){
      assertThat(applicationModule.provideCrashTracker(
            (packagename.app.com.appname.core.BaseApplication) getContext()
                  .getApplicationContext()), notNullValue());
   }
}
