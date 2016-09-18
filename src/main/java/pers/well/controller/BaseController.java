/**
 * 
 */
package pers.well.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import pers.well.model.BaseResult;

public class BaseController
{
	protected static final int OK = 200,FORBIDDEN = 403;

	protected static final int NOT_FOUND = 404;
	
    SerializerFeature[] feature =
    { SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullBooleanAsFalse,
            SerializerFeature.WriteMapNullValue };

    /**
     * 构造成功返回结果
     * @param resultData
     *            : 需要返回的数据，可选
     * @return
     */
    protected String buildSuccessResultInfo(Object responseData)
    {
    	BaseResult result = new BaseResult();
    	result.setResponseCode(OK);
        result.setResponseData(responseData);
        result.setResponseMessage("success");
        return JSON.toJSONString(result, feature);
    }

    /**
     * @description: 构造失败返回结果
     * @author: Wind-spg
     * @param resultCode
     *            :任意非0数字，代表失败
     * @param failedMsg
     *            ：失败信息
     * @return
     */
    protected String buildFailedResultInfo(int responseCode, String failedMsg)
    {
    	BaseResult result = new BaseResult(responseCode, failedMsg);
        return JSON.toJSONString(result, feature);
    }

}
