package springboot_shiro.mapper;

import java.util.List;

import springboot_shiro.pojo.User;
import springboot_shiro.pojo.UserExample;

public interface UserMapper {
	int deleteByPrimaryKey(Long id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}