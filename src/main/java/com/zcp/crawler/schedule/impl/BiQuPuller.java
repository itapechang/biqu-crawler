package com.zcp.crawler.schedule.impl;

import com.zcp.crawler.schedule.CommonPuller;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashSet;


/**
 * @author zcp
 * @create 2019/12/17
 * @since 1.0.0
 *
 *
 */
@Component("biQuPuller")
@Slf4j
public class BiQuPuller implements CommonPuller {

    @Value("${book.biqu.url}")
    private String url;

    @Override
    public void pullNews() {
        log.info("开始拉取...");
        //1.获取首页
        Document html=null;
        try {
            html=getHtmlFromUrl(url, false);

        }catch (Exception e){
            log.error("拉取失败...url--->{}",url);
            return;
        }
        //获取首页中热点内容
        Elements hotBooks = html.select("div#main")
                .select("div#hotcontent")
                .select("div.l")
                .select("a[href~=^http://www.xbiquge.*]");
        HashSet<String> urls=new HashSet<>();
        hotBooks.forEach(item->{
            //小说的地址
            String href = item.attr("href");
            urls.add(href);
        });

        //爬取每一个小说,这里爬取了一篇小说,就break了,如果需要多篇热门小说打开break即可
        for (String s : urls) {
            pull(s);
            break;
        }


    }


    /**
     * 爬取每一篇小说的章节
     *
     */
    public void pull(String surl){


        log.info("开始拉取...");
        //1.获取首页
        Document html=null;
        try {
            html=getHtmlFromUrl(surl, false);

        }catch (Exception e){
            log.error("拉取失败...url--->{}",surl);
            return;
        }

        Elements elements = html.select("div#list").select("dl").select("dd > a");
        HashSet<String> zhangjieUrl=new HashSet<>();
        elements.forEach(element -> {
            String href = element.attr("href");
            String title = element.text();  //章节标题
            //章节链接
            href=url+href;
            System.out.println(title+"     -->    "+href);
            zhangjieUrl.add(href);
        });

        //爬取小说里每一个章节,这里爬取了一个章节,就break了,如果需要多篇热门小说打开break即可
        for (String s : zhangjieUrl) {
            pullContent(s);
            break;
        }
    }

    /**
     * 爬取每一章节内容
     * @param contentUrl
     */
    public void pullContent(String contentUrl){
        log.info("开始拉取...");
        Document html=null;
        try {
            html=getHtmlFromUrl(contentUrl, false);

        }catch (Exception e){
            log.error("拉取失败...url--->{}",contentUrl);
            return;
        }
        Elements content = html.select("div#content");
//        System.out.println(content);
        content.forEach(c->{
            //获取纯文字内容,不带标签  (章节内容)
            System.out.println(c.text());
        });

    }

}

