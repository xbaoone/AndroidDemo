package com.example.administrator.myapplication;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ListView mListView;
    private String[] names={ "seven", "蚊香蛙", "无内鬼","有外神","妙蛙种子","小火龙",
                             "喵喵", "皮卡丘", "胖丁 ","豌豆射手","杰尼龟","1"};
    private int[]  icons= { R.drawable.xiumin,R.drawable.luhan,R.drawable.kris,R.drawable.suho, R.drawable.lay,
                            R.drawable.boxian,R.drawable.chen,R.drawable.can,R.drawable.dou, R.drawable.tao, R.drawable.kai, R.drawable.sehun};
    private String[] introduces = {
            "宠物小精灵一号",
            "宠物小精灵一号",
            "宠物小精灵一号",
            "宠物小精灵一号",
            "宠物小精灵一号",
            "宠物小精灵一号",
            "宠物小精灵一号",
            "宠物小精灵一号",
            "宠物小精灵一号",
            "宠物小精灵一号",
            "宠物小精灵一号",
            "宠物小精灵一号"
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo);
        mListView = (ListView) findViewById(R.id.lv);
        MyBaseAdapter mAdapter = new MyBaseAdapter();
        mListView.setAdapter(mAdapter);
    }
    class MyBaseAdapter extends BaseAdapter{
        @Override
        public int getCount(){
            return  names.length;
        }
        @Override
        public Object getItem(int position){
            return names[position];
        }
        @Override
        public long getItemId (int position){
            return position;
        }
        @Override
        public View getView(int position, View converView, ViewGroup parent){
            ViewHolder holder = null;
            if(converView == null){
                converView = View.inflate(MainActivity.this,R.layout.list_item,null);
                holder = new ViewHolder();
                holder.name = (TextView)converView.findViewById(R.id.name);
                holder.introduce = (TextView)converView.findViewById(R.id.introduce);
                holder.iv = (ImageView) converView.findViewById(R.id.iv);
                converView.setTag(holder);
            }else{
                holder = (ViewHolder) converView.getTag();
            }
            holder.name.setText(names[position]);
            holder.introduce.setText(introduces[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return converView;
        }
    }

}
