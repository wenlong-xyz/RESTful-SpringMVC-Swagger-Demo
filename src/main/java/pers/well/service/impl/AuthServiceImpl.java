package pers.well.service.impl;

import org.springframework.stereotype.Service;
import pers.well.dao.RedisDAO;
import pers.well.model.Token;
import pers.well.service.AuthService;
import pers.well.util.EncoderHandler;

import javax.annotation.Resource;


@Service
public class AuthServiceImpl implements AuthService {
	@Resource(name="redisDao")
	RedisDAO redisDAO;

	public Token login(String name, String password) {
		if(name == password || name.equals(password)) {
			String str = name + System.currentTimeMillis();
			String tokenStr = EncoderHandler.encodeByMD5(str);
			redisDAO.set(name,tokenStr);

			return new Token(tokenStr);
		}
		else{
			return null;
		}
	}

	public boolean tokenCheck(String name, String token) {
		String tokenStr = redisDAO.get(name);
		if(tokenStr != null && tokenStr.equals(token)){
			return true;
		}
		return false;
	}

}
