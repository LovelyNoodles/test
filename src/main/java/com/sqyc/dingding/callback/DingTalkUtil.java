package com.sqyc.dingding.callback;

import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class DingTalkUtil {

    /**
     * 通讯录：注册事件回调接口
     * @param accesstoken 企业的accesstoken
     * @param callBackTag  需要监听的事件类型，共有20种（Array[String]）
     * @param token      加解密需要用到的token，ISV(服务提供商)推荐使用注册套件时填写的token，普通企业可以随机填写
     * @param aesKey      数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成，ISV(服务提供商)推荐使用注册套件时填写的EncodingAESKey
     * @param callBackUrl      接收事件回调的url
     * @return
     * @throws ApiException
     */
    public static JSONObject registerCallBack(String accesstoken,List<String> callBackTag,String token,String aesKey,String callBackUrl) throws ApiException{
        String url = CommomUrl.REGISTER_CALL_BACK.replace("ACCESS_TOKEN", accesstoken);
        JSONObject jsonReq = new JSONObject();
        jsonReq.put("call_back_tag", callBackTag);
        jsonReq.put("token", token);
        jsonReq.put("aes_key", aesKey);
        jsonReq.put("url", callBackUrl);

        System.out.println(jsonReq.toString());
        JSONObject jsonObject = doPostStr(url, jsonReq.toString());
        return jsonObject;
    }

    /**
     * 通讯录：查询事件回调接口
     * @param accesstoken  企业的accesstoken
     * @return
     */
    public static JSONObject getCallBack(String accesstoken){
        String url = CommomUrl.GET_CALL_BACK.replace("ACCESS_TOKEN", accesstoken);
        JSONObject jsonObject = doGetStr(url);
        return jsonObject;
    }

    /**
     * 通讯录：更新事件回调接口
     * @param accesstoken 企业的accesstoken
     * @param callBackTag  需要监听的事件类型，共有20种（Array[String]）
     * @param token      加解密需要用到的token，ISV(服务提供商)推荐使用注册套件时填写的token，普通企业可以随机填写
     * @param aesKey      数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成，ISV(服务提供商)推荐使用注册套件时填写的EncodingAESKey
     * @param callBackUrl      接收事件回调的url
     * @return
     * @throws ApiException
     */
    public static JSONObject updateCallBack(String accesstoken, List<String> callBackTag, String token, String aesKey, String callBackUrl) throws ApiException {
        String url = CommomUrl.UPDATE_CALL_BACK.replace("ACCESS_TOKEN", accesstoken);
        JSONObject jsonReq = new JSONObject();
        jsonReq.put("call_back_tag", callBackTag);
        jsonReq.put("token", token);
        jsonReq.put("aes_key", aesKey);
        jsonReq.put("url", callBackUrl);

        JSONObject jsonObject = doPostStr(url, jsonReq.toString());
        return jsonObject;
    }

    /**
     * 通讯录：删除事件回调接口
     * @param accesstoken  企业的accesstoken
     * @return
     */
    public static JSONObject deleteCallBack(String accesstoken){
        String url = CommomUrl.DELETE_CALL_BACK.replace("ACCESS_TOKEN", accesstoken);
        JSONObject jsonObject = doGetStr(url);
        return jsonObject;
    }

    /**
     * 通讯录：获取回调失败的结果
     * @param accesstoken  企业的accesstoken
     * @return
     */
    public static JSONObject getCallBackFailedResult(String accesstoken){
        String url = CommomUrl.GET_CALL_BACK_FAILED_RESULT.replace("ACCESS_TOKEN", accesstoken);
        JSONObject jsonObject = doGetStr(url);
        return jsonObject;
    }

    /**
     * get请求
     * @param url 为接口地址参数
     * @return
     */
    public static JSONObject doGetStr(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        JSONObject jsonObject = null;//接收结果
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();//从消息体里获取结果
            if(entity!=null){
                String result = EntityUtils.toString(entity,"UTF-8");
                jsonObject = JSONObject.parseObject(result);
            }
            EntityUtils.consume(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }

    /**
     * post请求
     * @param url 为接口地址参数
     * @param outStr
     * @return
     */
    public static JSONObject doPostStr(String url,String outStr){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = null;
        try {
            httpPost.setEntity(new StringEntity(outStr, "UTF-8"));
            HttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            jsonObject = JSONObject.parseObject(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
