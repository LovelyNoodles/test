//package com.sqyc.dingding.callback;
//
//import com.alibaba.fastjson.JSONObject;
//import com.taobao.api.ApiException;
//
//import javax.servlet.ServletInputStream;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * <p>通讯录事件回调<p>
// *
// * @author li_hao
// * @version 1.0
// * @date 2017年12月21日
// */
//@WebServlet("/callbackreceive")
//public class CallBackServlet extends HttpServlet {
//
//    private static final long serialVersionUID = -1785796919047156450L;
//
//    public CallBackServlet() {
//        super();
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//        doGet(request, response);
//    }
//
//    /*
//     * 接收钉钉服务器的回调数据
//     *
//     */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            /** url中的签名 **/
//            String msgSignature = request.getParameter("signature");
//            /** url中的时间戳 **/
//            String timeStamp = request.getParameter("timestamp");
//            /** url中的随机字符串 **/
//            String nonce = request.getParameter("nonce");
//            /** 取得JSON对象中的encrypt字段     **/
//            String encrypt = "";
//
//            /** 获取post数据包数据中的加密数据 **/
//            ServletInputStream sis = request.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(sis));
//            String line = null;
//            StringBuilder sb = new StringBuilder();
//            while ((line = br.readLine()) != null) {
//                sb.append(line);
//            }
//            JSONObject jsonEncrypt = JSONObject.parseObject(sb.toString());
//            encrypt = jsonEncrypt.getString("encrypt");
//
//            String decodeEncrypt = decodeEncrypt(msgSignature, timeStamp, nonce, encrypt); //密文解密
//            JSONObject decodeEncryptJson = JSONObject.parseObject(decodeEncrypt);
//
//            String eventType = decodeEncryptJson.getString("EventType");  //回调类型
//            String UserIds = decodeEncryptJson.getString("UserId");  //用户发生变更的userid列表
//            String DeptIds = decodeEncryptJson.getString("DeptId");  //部门发生变更的deptId列表
//            String res = "success";  //res是需要返回给钉钉服务器的字符串，一般为success;"check_create_suite_url"和"check_update_suite_url"事件为random字段;(具体请查看文档或者对应eventType的处理步骤)
//
//            JSONObject jsonObjectData = new JSONObject();
//            //根据不同的回调类型，进行相应的操作
//            switch (eventType) {
//                case AddressListRegister.USER_ADD_ORG:
//                    //通讯录用户增加
//
//                    break;
//                case AddressListRegister.USER_MODIFY_ORG:
//                    //通讯录用户更改
//
//                    break;
//                case AddressListRegister.USER_LEAVE_ORG:
//                    //通讯录用户离职
//
//                    break;
//                case AddressListRegister.ORG_ADMIN_ADD:
//                    //通讯录用户被设为管理员
//
//                    break;
//                case AddressListRegister.ORG_ADMIN_REMOVE:
//                    //通讯录用户被取消设置管理员
//
//                    break;
//                case AddressListRegister.ORG_DEPT_CREATE:
//                    //通讯录企业部门创建
//
//                    break;
//                case AddressListRegister.ORG_DEPT_MODIFY:
//                    //通讯录企业部门修改
//
//                    break;
//                case AddressListRegister.ORG_DEPT_REMOVE:
//                    //通讯录企业部门删除
//
//                    break;
//                case AddressListRegister.ORG_REMOVE:
//                    //企业被解散
//
//                    break;
//                case AddressListRegister.ORG_CHANGE:
//                    //企业信息发生变更
//
//                    break;
//                case AddressListRegister.LABEL_USER_CHANGE:
//                    //员工角色信息发生变更
//
//                    break;
//                case AddressListRegister.LABEL_CONF_ADD:
//                    //增加角色或者角色组
//
//                    break;
//                case AddressListRegister.LABEL_CONF_DEL:
//                    //删除角色或者角色组
//
//                    break;
//                case AddressListRegister.LABEL_CONF_MODIFY:
//                    //修改角色或者角色组
//
//                    break;
//                case AddressListRegister.CHECK_URL:
//                    //测试回调接口事件类型
//
//                    System.out.println("测试回调接口！");
//                    break;
//                default: // do something
//                    break;
//            }
//            response.getWriter().append(codeEncrypt(res, timeStamp, nonce).toString()); //返回加密后的数据
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    /**
//     * 创建加密/解密 类
//     *
//     * @return
//     */
//    public DingTalkEncryptor createDingTalkEncryptor() {
//        DingTalkEncryptor dingTalkEncryptor = null;  //加密方法类
//        try {
//            dingTalkEncryptor = new DingTalkEncryptor(AddressListRegister.TOKEN, AddressListRegister.AES_KEY, AddressListRegister.CORPID);  //创建加解密类
//        } catch (DingTalkEncryptException e) {
//            e.printStackTrace();
//        }
//        return dingTalkEncryptor;
//    }
//
//    /**
//     * encrypt解密
//     *
//     * @param msgSignature
//     * @param timeStamp
//     * @param nonce
//     * @param encrypt      密文
//     * @return decodeEncrypt 解密后的明文
//     */
//    public String decodeEncrypt(String msgSignature, String timeStamp, String nonce, String encrypt) {
//        String decodeEncrypt = null;
//        try {
//            decodeEncrypt = createDingTalkEncryptor().getDecryptMsg(msgSignature, timeStamp, nonce, encrypt); //encrypt解密
//        } catch (DingTalkEncryptException e) {
//            e.printStackTrace();
//        }
//        return decodeEncrypt;
//    }
//
//
//    /**
//     * 对返回信息进行加密
//     *
//     * @param res
//     * @param timeStamp
//     * @param nonce
//     * @return
//     */
//    public JSONObject codeEncrypt(String res, String timeStamp, String nonce) {
//        long timeStampLong = Long.parseLong(timeStamp);
//        Map<String, String> jsonMap = null;
//        try {
//            jsonMap = createDingTalkEncryptor().getEncryptedMap(res, timeStampLong, nonce); //jsonMap是需要返回给钉钉服务器的加密数据包
//        } catch (DingTalkEncryptException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//        JSONObject json = new JSONObject();
//        json.putAll(jsonMap);
//        return json;
//    }
//
//
//    //测试方法
//    public static void main(String[] args) throws ApiException {
//        String accesstoken = "r";
//        String token = AddressListRegister.TOKEN;
//        String aesKey = AddressListRegister.AES_KEY;
//        String callBackUrl = "http://xxxx/callbackreceive";
//
//        List<String> listStr = new ArrayList<String>();
//        listStr.add("user_add_org");
//        listStr.add("user_modify_org");
//        listStr.add("user_leave_org");
//
//        listStr.add("org_dept_create");
//        listStr.add("org_dept_modify");
//        listStr.add("org_dept_remove");
//
//        JSONObject registerCallBack = DingTalkUtil.updateCallBack(accesstoken, listStr, token, aesKey, callBackUrl);
//        System.out.println("注册事件返回：" + registerCallBack);
//
//        JSONObject callBack = DingTalkUtil.getCallBack(accesstoken);
//        System.out.println("查询注册事件：" + callBack);
//
//
//    }
//
//}