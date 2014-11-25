package packagename.app.com.appname.core.module;

import android.test.AndroidTestCase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class WebserviceModuleTest extends AndroidTestCase {

   private WebserviceModule webserviceModule;

   public void testProvidePicasso() {
      assertThat(webserviceModule.providePicasso(getContext()), notNullValue());
   }

   public void testProvideRestAdapter() {
      assertThat(webserviceModule.provideRestAdapter(getContext()), notNullValue());
   }

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      webserviceModule = new WebserviceModule();
   }
}
