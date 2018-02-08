package com.hp.controller.sys;

import com.hp.annotation.test;
import com.hp.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by hp on 2018/1/29.
 */
@Controller
@RequestMapping(value="/Sys")
@test("aaaaaaaa")
@Api(value = "用户信息查询",description = "用户信息")
public class sysController {

	private static final Logger logger = LoggerFactory.getLogger(sysController.class);

	@Resource
	private IUserService ius;

	@ApiOperation(value = "查找用户",httpMethod = "GET")
	@RequestMapping(value="/user/list",produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String queryUserList(){
		test t = sysController.class.getAnnotation(test.class);
		logger.debug("测试日志：输出成功");
		System.out.println(t.value());
		List<Map<String,Object>> res = ius.queryUserList();
		if(res!=null){
			for(Map<String,Object> map:res){
				for(Map.Entry<String,Object> m:map.entrySet()){
					System.out.println(m.getKey()+m.getValue());
				}
			}
		}
		return "query user list";
	}
	@ApiOperation(value = "添加用户",httpMethod = "GET")
	@RequestMapping(value="/user/add",produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String insertUser(){
		return "insert user";
	}
	@ApiOperation(value = "修改用户信息",httpMethod = "GET")
	@RequestMapping(value = "/user/update",produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String updateUser(){
		return "update user";
	}
	@ApiOperation(value = "删除用户",httpMethod = "GET")
	@RequestMapping(value = "/user/delete",produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String deleteUser(){
		return "delete user";
	}
}
