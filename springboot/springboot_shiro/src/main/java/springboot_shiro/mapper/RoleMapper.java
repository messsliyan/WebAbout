package springboot_shiro.mapper;

import java.util.List;

import springboot_shiro.pojo.Role;
import springboot_shiro.pojo.RoleExample;

public interface RoleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Role record);

	int insertSelective(Role record);

	List<Role> selectByExample(RoleExample example);

	Role selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);
}