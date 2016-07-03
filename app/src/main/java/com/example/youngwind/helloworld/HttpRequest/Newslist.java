package com.example.youngwind.helloworld.HttpRequest;


/**
 * Created by youngwind on 16/7/4.
 * 新闻列表类
 * 坑!java这种强类型语言,对于写惯了js的人来说实在是有点难以转换.....
 */
public class Newslist {
    public int code;
    public String msg;
    public news[] newslist;

    class news {
        public String ctime;
        public String title;
        public String description;
        public String picUrl;
        public String url;
    }
}
