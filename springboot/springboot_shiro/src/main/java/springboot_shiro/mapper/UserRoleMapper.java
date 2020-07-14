package springboot_shiro.mapper;

import java.util.List;

import springboot_shiro.pojo.UserRole;
import springboot_shiro.pojo.UserRoleExample;

public interface UserRoleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(UserRole record);

	int insertSelective(UserRole record);

	List<UserRole> selectByExample(UserRoleExample example);

	UserRole selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(UserRole record);

	int updateByPrimaryKey(UserRole record);
}