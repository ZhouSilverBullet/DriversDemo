package com.qianphone.driversdemo.bean;

import java.util.List;

/**
 * Created by 周周 on 2016/8/25.
 */
public class DetailBean  {

    /**
     * code : 1
     * msg : success
     * data : {"news":[{"article_id":496791,"article_content":"<p>使用电脑就离不开打字，而通过社交软件交流更是需要键指如飞。不过有时候也会遭遇尴尬，输入法犯二会导致莫名无法打出中文，为此很多人不得不重启电脑来进行恢复。<\/p><p>不过，下面这名台湾女生却将计就计，顺势用自己的\u201c台式英文\u201d与对方聊天，屏幕截图被上传网络后瞬间走红。<\/p><p>这名女生23日在Facebook上表示，由于时常发生打不出中文的情况，无奈只好硬打英文沟通，并附上与室友阿满聊天的窗口截图。<\/p><p>内容可以看到女生一开始写着：<\/p><p>\u201cI can&rsquo;t type Chinese again（我又不能打中文了）\u201d，之后在室友阿满的讥讽下，鼻妹开始写出台式英文，\u201cYou fat fat der（你肥肥的）\u201d，\u201cni za gan ma（你在干嘛）\u201d<\/p><p>前面的都还算容易理解，接下来还有比较难以一下理解的，比如\u201ccan in pan（看影片）\u201d、\u201cta whay fu fa（他会复发）\u201d等等。<\/p><p>不过，室友阿满倒是默契度爆表，对女生的\u201c台式英文\u201d秒懂，还可以马上回复。<\/p><p>对此，有内地网友表示，\u201c这算啥，我在无法输入中文又急于沟通时，也会用拼音字符告诉对方我们想要说的话，别告诉我你们没有这样做过。\u201d<\/p><p align=\"center\"><img onclick=\"javascript:window.news.setImages(setimageswwghttp://img1.mydrivers.com/img/20160825/a1c4eae3cee14bf392861792bfb94644.jpgsetimageswwg)\" src=\"http://img1.mydrivers.com/img/20160825/a1c4eae3cee14bf392861792bfb94644.jpg\"/><\/p>"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * article_id : 496791
         * article_content : <p>使用电脑就离不开打字，而通过社交软件交流更是需要键指如飞。不过有时候也会遭遇尴尬，输入法犯二会导致莫名无法打出中文，为此很多人不得不重启电脑来进行恢复。</p><p>不过，下面这名台湾女生却将计就计，顺势用自己的“台式英文”与对方聊天，屏幕截图被上传网络后瞬间走红。</p><p>这名女生23日在Facebook上表示，由于时常发生打不出中文的情况，无奈只好硬打英文沟通，并附上与室友阿满聊天的窗口截图。</p><p>内容可以看到女生一开始写着：</p><p>“I can&rsquo;t type Chinese again（我又不能打中文了）”，之后在室友阿满的讥讽下，鼻妹开始写出台式英文，“You fat fat der（你肥肥的）”，“ni za gan ma（你在干嘛）”</p><p>前面的都还算容易理解，接下来还有比较难以一下理解的，比如“can in pan（看影片）”、“ta whay fu fa（他会复发）”等等。</p><p>不过，室友阿满倒是默契度爆表，对女生的“台式英文”秒懂，还可以马上回复。</p><p>对此，有内地网友表示，“这算啥，我在无法输入中文又急于沟通时，也会用拼音字符告诉对方我们想要说的话，别告诉我你们没有这样做过。”</p><p align="center"><img onclick="javascript:window.news.setImages(setimageswwghttp://img1.mydrivers.com/img/20160825/a1c4eae3cee14bf392861792bfb94644.jpgsetimageswwg)" src="http://img1.mydrivers.com/img/20160825/a1c4eae3cee14bf392861792bfb94644.jpg"/></p>
         */

        private List<NewsBean> news;

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public static class NewsBean {
            private int article_id;
            private String article_content;

            public int getArticle_id() {
                return article_id;
            }

            public void setArticle_id(int article_id) {
                this.article_id = article_id;
            }

            public String getArticle_content() {
                return article_content;
            }

            public void setArticle_content(String article_content) {
                this.article_content = article_content;
            }
        }
    }
}
