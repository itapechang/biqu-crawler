package com.zcp.crawler.schedule;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public interface CommonPuller {

    void pullNews();

    default Document getHtmlFromUrl(String url, boolean useHtmlUnit) throws Exception{
        if(!useHtmlUnit){
            //模拟火狐浏览器
            return Jsoup.connect(url)
                    .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                    .get();
        }else{
            WebClient webClient=new WebClient(BrowserVersion.CHROME);
            //javascript
            webClient.getOptions().setJavaScriptEnabled(true);
            //css
            webClient.getOptions().setCssEnabled(false);
            //
            webClient.getOptions().setActiveXNative(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getOptions().setTimeout(10000);
            HtmlPage rootPage=null;
            try {
                rootPage = webClient.getPage(url);
                webClient.waitForBackgroundJavaScript(10000);
                String htmlString = rootPage.asXml();
                return Jsoup.parse(htmlString);
            }catch (Exception e){
                throw  e;
            }finally {
                webClient.close();
            }
        }

    }
}
