package pooa20171.iff.br.trabp2.persistence;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by filipefds on 07/08/17.
 */

public class BDConfig extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(getApplicationContext());

        RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
        builder.name("Proprietario.realm");
        builder.schemaVersion(0);
        builder.deleteRealmIfMigrationNeeded();
        RealmConfiguration realmConfiguration = builder.build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}