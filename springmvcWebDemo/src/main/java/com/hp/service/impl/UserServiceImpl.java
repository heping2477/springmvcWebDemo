package com.hp.service.impl;

import com.hp.mapper.IUserMapper;
import com.hp.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2018/2/1.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource
	private IUserMapper ium;
	public List<Map<String, Object>> queryUserList() {
		log.debug("UserServiceImpl-------");
		return ium.queryUserList();
	}
}
