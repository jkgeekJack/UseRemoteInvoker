package com.jk.interactive;

import com.alibaba.fastjson.JSON;
import com.jk.model.ModuleModel;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * 调用远端方法的发起者
 */
public class InteractiveCallHelper {
    /**
     *
     * @param moduleId 模块Id
     * @param opeType 需要调用的具体的业务操作类型
     * @param mapParams 调用所需要传递的参数
     * @return 服务端返回的Json数据
     */
    public String call(String moduleId, String opeType, Map<String,Object>mapParams){
        //1.根据moduleId去获取到该模块部署的信息,理论上要根据moduleId去设置，这里写死
        ModuleModel moduleModel=new ModuleModel();
        moduleModel.setDeployIP("localhost");
        moduleModel.setDeployPort("8080");
        moduleModel.setIntereractiveUrl("/goods/call");

        //2.准备要传递的数据，把Map转换为JSON
        String paramStr= JSON.toJSONString(mapParams);
        //因为#在url里有特殊含义，所以将#替换为*
        paramStr=paramStr.replace("#","*");

        //3.拼接一个远程调用的URL
        String urlStr="http://"+ moduleModel.getDeployIP()+":"+moduleModel.getDeployPort()+moduleModel.getIntereractiveUrl()
                +"?jsonParam={opeType:"+opeType+",map:"+paramStr+"}";

        //4.使用URL进行远程调用，流式操作
        BufferedReader in =null;
        String retJson="";
        try {
            URL url=new URL(urlStr);
            URLConnection urlConnection=url.openConnection();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                retJson += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return retJson;
    }

    /**
     *
     * @param moduleId 模块Id
     * @param opeType 需要调用的具体的业务操作类型
     * @param mapParams 调用所需要传递的参数
     * @param cls 需要转的类型
     * @return  服务器返回的对象
     */
    public <T>T call(String moduleId, String opeType, Map<String,Object>mapParams,Class<T> cls){
        String json=call(moduleId,opeType,mapParams);
        return JSON.parseObject(json,cls);
    }

    /**
     * 测试方法
     * @param args
     */
    public static void main(String[]args){
        InteractiveCallHelper interactiveCallHelper=new InteractiveCallHelper();
        Map<String,Object>map=new HashMap<String,Object>();
        String str=interactiveCallHelper.call("goods","1",map);
        System.out.println(str);
    }
}
