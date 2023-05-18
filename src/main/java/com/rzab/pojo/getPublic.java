package com.rzab.pojo;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @author 热着爱吧
 * @create 2021-04-19 11:36
 **/

public class getPublic {
    //jsoup获取ip
    public static String getPublicIP() {
        String ip = "";
        try {
            Document doc = Jsoup.connect("http://www.ip138.com/ip2city.asp").ignoreContentType(false).get();
            Elements els = doc.select("center");
            for (org.jsoup.nodes.Element el : els) {
                ip = el.text();
            }
            ip = ip.replaceAll("[^0-9.]", "");
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {

        }
        return ip;
    }


    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    //将URL资源解析成json对象
    public static JSONObject readJsonFromUrl(String url) throws IOException {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = JSONObject.fromObject(jsonText);
            // System.out.println(json);
            return json;
        } finally {
            //关闭输入流
            is.close();
        }
    }

    //传入用户IP获取当地地址名
    public static String getAddrName(String IP) throws IOException {
        //这里调用百度的ip定位api服务 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm

        JSONObject json = readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=iTrwV0ddxeFT6QUziPQh2wgGofxmWkmg&ip=" + IP);
        /* 获取到的json对象：
         *         {"address":"CN|河北|保定|None|UNICOM|0|0",
         *        "content":{"address_detail":{"province":"河北省","city":"保定市","street":"","district":"","street_number":"","city_code":307},
         *        "address":"河北省保定市","point":{"x":"12856963.35","y":"4678360.5"}},
         *        "status":0}
         */
        //如果IP是本地127.0.0.1或者内网IP192.168则status分别返回1和2
        String status = json.opt("status").toString();
        if (!"0".equals(status)) {
            return "";
        }
        JSONObject content = ((JSONObject) json).getJSONObject("content");              //获取json对象里的content对象
        JSONObject addr_detail = ((JSONObject) content).getJSONObject("address_detail");//从content对象里获取address_detail
        String city = addr_detail.opt("city").toString();                             //获取市名，可以根据具体需求更改
        return city;
    }

}
