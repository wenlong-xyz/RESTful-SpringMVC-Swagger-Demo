package pers.well.service;

import pers.well.model.Token;

/**
 * Created by wenlong on 2016/9/10.
 */
public interface AuthService {
    /**
     * 登陆
     * @param name -- 用户名
     * @param password -- 密码
     * @return 验证通过，返回token
     *         验证失败，返回null
     */
    public Token login(String name, String password);

    /**
     * 登陆
     * @param token
     * @return 验证通过，返回true
     *         验证失败，返回false
     */
    public boolean tokenCheck(String name, String token);

}
