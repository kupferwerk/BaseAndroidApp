package packagename.app.com.appname.core.module;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.jakewharton.picasso.OkHttp3Downloader;

import org.junit.Before;
import org.junit.Test;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class WebserviceModuleTest {

   private Context context;
   private WebserviceModule webserviceModule;

   @Before
   public void setUp() {
      context = InstrumentationRegistry.getTargetContext();
      webserviceModule = new WebserviceModule();
   }

   @Test
   public void testProvideHttpCache() {
      assertThat(webserviceModule.provideHttpCache(context), notNullValue());
   }

   @Test
   public void testProvideHttpClient() {
      final Cache cache = webserviceModule.provideHttpCache(context);
      assertThat(webserviceModule.provideHttpClient(cache, null), notNullValue());
   }

   @Test
   public void testProvideHttpLoggingInterceptor() {
      assertThat(webserviceModule.provideHttpLoggingInterceptor(), notNullValue());
   }

   @Test
   public void testProvidePicasso() {
      assertThat(webserviceModule.providePicasso(context, new OkHttp3Downloader(context)),
            notNullValue());
   }

   @Test
   public void testProvideRestAdapter() {
      assertThat(webserviceModule.provideRetrofit(context, new OkHttpClient()), notNullValue());
   }
}
