package comq.example.myshujuku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import comq.example.myshujuku.adapter.MyRecycAdapter;
import comq.example.myshujuku.application.MyApplication;
import comq.example.myshujuku.bean.MyBean;

public class ZhuActivity extends AppCompatActivity implements View.OnClickListener {
    private List<MyBean> mList = new ArrayList<>();
    private Button chaxun_btn;
    private Button charu_btn;
    private RecyclerView recyclerviews;
    private MyBeanDao beanDao;
    private MyRecycAdapter myRecycAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        beanDao = MyApplication.getApplication().getDaoSession().getMyBeanDao();
        initView();

    }

    private void initView() {
        chaxun_btn = (Button) findViewById(R.id.chaxun_btn);
        charu_btn = (Button) findViewById(R.id.charu_btn);
        recyclerviews = (RecyclerView) findViewById(R.id.recyclerviews);
        chaxun_btn.setOnClickListener(this);
        charu_btn.setOnClickListener(this);

        myRecycAdapter = new MyRecycAdapter(mList, this);
        recyclerviews.setAdapter(myRecycAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerviews.setLayoutManager(linearLayoutManager);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chaxun_btn:
                mList.clear();
                mList.addAll(beanDao.loadAll());
                myRecycAdapter.notifyDataSetChanged();
                break;
            case R.id.charu_btn:
                Intent intent = new Intent(this, CharuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
