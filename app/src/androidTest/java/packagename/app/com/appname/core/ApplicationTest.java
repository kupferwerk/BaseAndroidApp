package packagename.app.com.appname.core;

import android.test.ApplicationTestCase;

public class ApplicationTest extends ApplicationTestCase<BaseApplication> {

   public ApplicationTest() {
      super(BaseApplication.class);
   }

   public void testCrashTracker() {
      BaseApplication application = getApplication();
      assertNotNull(application.crashTracker);
   }

   public void testPicasso() throws Exception {
      BaseApplication application = getApplication();
      assertNotNull(application.picasso);
   }

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      createApplication();
   }
}