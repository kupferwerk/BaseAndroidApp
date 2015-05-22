package packagename.app.com.appname;

import android.os.Bundle;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import packagename.app.com.appname.core.BaseActivity;
import packagename.app.com.appname.core.CrashTracker;
import packagename.app.com.appname.core.Injector;
import retrofit.RestAdapter;

public class SplashScreen extends BaseActivity {

    @Inject
    Picasso picasso;

    @Inject
    RestAdapter restAdapter;

    @Inject
    CrashTracker crashTracker;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.inject(this);
    }
}
