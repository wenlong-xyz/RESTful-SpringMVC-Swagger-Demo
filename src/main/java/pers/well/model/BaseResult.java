/**
 *
 */
package pers.well.model;

import java.io.Serializable;

/**
 * RESTful response中的基本数据结构
 *
 * @author wenlong
 */
public class BaseResult implements Serializable {


    private static final long serialVersionUID = -7978635757653362784L;

    // 返回码
    private int responseCode;

    // 返回描述消息
    private String responseMessage;

    // 返回数据
    private Object responseData;

    public BaseResult() {

    }

    public BaseResult(String responseMessage, Object responseData) {
        this.responseMessage = responseMessage;
        this.responseData = responseData;
    }

    public BaseResult(int responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "BaseResultVo [responseCode=" + responseCode + ", responseMessage=" + responseMessage
                + ", responseData=" + responseData + "]";
    }

}
