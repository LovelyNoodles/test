package com.sqyc.dingding.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version : 1.0
 * @Author : li_hao
 * @Description : 钉钉接口地址类
 * @Date : 2017-06-10 17:47
 **/
public class CommomUrl {
    private static Logger log = LoggerFactory.getLogger(CommomUrl.class);


    /** 注册事件回调接口（请求方式：post） */
    public static final String REGISTER_CALL_BACK = "https://oapi.dingtalk.com/call_back/register_call_back?access_token=ACCESS_TOKEN";

    /** 查询事件回调接口（请求方式：get） */
    public static final String GET_CALL_BACK = "https://oapi.dingtalk.com/call_back/get_call_back?access_token=ACCESS_TOKEN";

    /** 更新事件回调接口（请求方式：post） */
    public static final String UPDATE_CALL_BACK = "https://oapi.dingtalk.com/call_back/update_call_back?access_token=ACCESS_TOKEN";

    /** 删除事件回调接口（请求方式：get） */
    public static final String DELETE_CALL_BACK = "https://oapi.dingtalk.com/call_back/delete_call_back?access_token=ACCESS_TOKEN";

    /** 获取回调失败的结果 （请求方式：get）*/
    public static final String GET_CALL_BACK_FAILED_RESULT = "https://oapi.dingtalk.com/call_back/get_call_back_failed_result?access_token=ACCESS_TOKEN";

}