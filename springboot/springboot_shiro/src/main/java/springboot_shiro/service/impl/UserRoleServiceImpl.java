package springboot_shiro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot_shiro.mapper.PermissionMapper;
import springboot_shiro.mapper.RolePermissionMapper;
import springboot_shiro.mapper.UserRoleMapper;
import springboot_shiro.pojo.Permission;
import springboot_shiro.pojo.PermissionExample;
import springboot_shiro.pojo.Role;
import springboot_shiro.pojo.RolePermission;
import springboot_shiro.pojo.RolePermissionExample;
import springboot_shiro.pojo.User;
import springboot_shiro.pojo.UserRole;
import springboot_shiro.pojo.UserRoleExample;
import springboot_shiro.service.PermissionService;
import springboot_shiro.service.RoleService;
import springboot_shiro.service.UserRoleService;
import springboot_shiro.service.UserService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleMapper userRoleMapper;

	@Override
	public void setRoles(User user, long[] roleIds) {
		// 删除当前用户所有的角色
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUidEqualTo(user.getId());
		List<UserRole> urs = userRoleMapper.selectByExample(example);
		for (UserRole userRole : urs)
			userRoleMapper.deleteByPrimaryKey(userRole.getId());

		// 设置新的角色关系
		if (null != roleIds)
			for (long rid : roleIds) {
				UserRole userRole = new UserRole();
				userRole.setRid(rid);
				userRole.setUid(user.getId());
				userRoleMapper.insert(userRole);
			}
	}

	@Override
	public void deleteByUser(long userId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUidEqualTo(userId);
		List<UserRole> urs = userRoleMapper.selectByExample(example);
		for (UserRole userRole : urs) {
			userRoleMapper.deleteByPrimaryKey(userRole.getId());
		}
	}

	@Override
	public void deleteByRole(long roleId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andRidEqualTo(roleId);
		List<UserRole> urs = userRoleMapper.selectByExample(example);
		for (UserRole userRole : urs) {
			userRoleMapper.deleteByPrimaryKey(userRole.getId());
		}
	}

}