package cn.edu.swjtu.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.swjtu.demo.Pojo.UserInfo;
import cn.edu.swjtu.demo.Pojo.UserPermission;
import cn.edu.swjtu.demo.Pojo.UserType;
import cn.edu.swjtu.demo.Service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	// 获取全部用户信息
	@GetMapping(value = "getAllUsers")
	@ResponseBody
	public List<UserInfo> getAllUsers() {
		return adminService.getAllUsers();
	}

	// 按cookieid获取全部用户信息
	@GetMapping(value = "getUserInfoByCookieid")
	@ResponseBody
	public UserInfo getUserInfo(@RequestParam(required = true, value = "cookieid") String cookieid) {
		return adminService.getUserInfo(cookieid);
	}

	// 获取全部用户类型
	@GetMapping(value = "getAllUserType")
	@ResponseBody
	public List<UserType> getAllUserType() {
		return adminService.getAllUserType();
	}

	// 获取全部用户权限
	@GetMapping(value = "getAllUserPermission")
	@ResponseBody
	public List<UserPermission> getAllUserPermission() {
		return adminService.getAllUserPermission();
	}

	// 修改用户类型
	@GetMapping(value = "updateUserType")
	@ResponseBody
	public int updateUserType(@RequestParam(required = true, value = "cookieid") String cookieid,
			@RequestParam(required = true, value = "userTypeId") Long userTypeId) {
		return adminService.updateUserType(cookieid, userTypeId);
	}

	// 修改用户权限
	@GetMapping(value = "updateUserPermission")
	@ResponseBody
	public int updateUserPermission(@RequestParam(required = true, value = "cookieid") String cookieid,
			@RequestParam(required = true, value = "userPermissionId") Long userPermissionId) {
		return adminService.updateUserPermission(cookieid, userPermissionId);
	}
}