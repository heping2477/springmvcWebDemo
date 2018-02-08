package com.hp.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2018/2/1.
 */
public interface IUserMapper {
	List<Map<String,Object>> queryUserList();
}
