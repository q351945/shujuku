package comq.example.myshujuku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import comq.example.myshujuku.application.MyApplication;
import comq.example.myshujuku.bean.MyBean;

public class CharuActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameku;
    private Button queding;
    private MyBeanDao beanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charu);
        beanDao = MyApplication.getApplication().getDaoSession().getMyBeanDao();
        initView();
    }


    private void initView() {
        nameku = (EditText) findViewById(R.id.nameku);
        queding = (Button) findViewById(R.id.queding);

        queding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.queding:
                String string = nameku.getText().toString();
                if (string.equals("")){
                    Toast.makeText(this, "输入信息有误", Toast.LENGTH_SHORT).show();
                }else{
                    MyBean myBean=new MyBean();
                    myBean.setName(string);
                    beanDao.insert(myBean);
                    finish();
                }
                break;
        }
    }

}
