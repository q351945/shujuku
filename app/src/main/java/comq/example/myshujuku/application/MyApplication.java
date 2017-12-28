package comq.example.myshujuku.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import comq.example.myshujuku.DaoMaster;
import comq.example.myshujuku.DaoSession;

/**
 * Created by 囨囚囨図 on 2017/12/28.
 */

public class MyApplication extends Application {
    private static MyApplication application;
    private DaoSession daoSession;

    public static MyApplication getApplication(){
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        create();
    }

    private void create() {
        DaoMaster.OpenHelper openHelper=new DaoMaster.DevOpenHelper(application,"wocaoku");
        SQLiteDatabase sq = openHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(sq);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }

}
