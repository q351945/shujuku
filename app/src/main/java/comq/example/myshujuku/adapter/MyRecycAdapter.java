package comq.example.myshujuku.adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.List;

import comq.example.myshujuku.MyBeanDao;
import comq.example.myshujuku.R;
import comq.example.myshujuku.application.MyApplication;
import comq.example.myshujuku.bean.MyBean;

/**
 * Created by 囨囚囨図 on 2017/12/28.
 */

public class MyRecycAdapter extends RecyclerView.Adapter<MyRecycAdapter.Wangnima> {
    private List<MyBean> mList;
    private Context context;
    private MyBeanDao beanDao;
    private List<MyBean> myBeen;

    public MyRecycAdapter(List<MyBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public MyRecycAdapter.Wangnima onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyc_item, parent, false);
        beanDao = MyApplication.getApplication().getDaoSession().getMyBeanDao();
        myBeen = beanDao.loadAll();
        Wangnima wangnima=new Wangnima(view);
        return wangnima;
    }

    @Override
    public void onBindViewHolder(final MyRecycAdapter.Wangnima holder, final int position) {
        holder.recwenzi.setText(mList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public Button quxiao;
            public Button queding;
            @Override
            public void onClick(View view) {
                View view1 = LayoutInflater.from(context).inflate(R.layout.pop, null);
                queding =(Button)view1.findViewById(R.id.queding);
                quxiao=(Button) view1.findViewById(R.id.quxiao);
                final PopupWindow popupWindow=new PopupWindow(view1, GridView.LayoutParams.WRAP_CONTENT, GridView.LayoutParams.WRAP_CONTENT);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                popupWindow.setFocusable(false);
                popupWindow.showAtLocation(view1, Gravity.CENTER,0,0);
                queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Long id = myBeen.get(position).getId();
                        beanDao.deleteByKey(id);
                        mList.remove(holder.getLayoutPosition());
                        beanDao.loadAll();
                        notifyDataSetChanged();
                        popupWindow.dismiss();
                    }
                });
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty()?0:mList.size();
    }

    public class Wangnima extends RecyclerView.ViewHolder {
        private TextView recwenzi;

        public Wangnima(View itemView) {
            super(itemView);
            recwenzi =(TextView) itemView.findViewById(R.id.recwenzi);

        }
    }
}
