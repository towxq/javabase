package mybatis;

import java.util.List;

public interface UserMapper {
    SysUser selectById(Long id);
    List<SysUser> selectAll();
    int insertUser(SysUser user);
    SysUser selectbyUserName(SysUser user);
    int updateById(SysUser user);
    List<SysUser> selectByIdList(List<Long> id);
    int insertUserList(List<SysUser> sysUsers);
    List<SysUser> selectUserAndRoleById(Long id);
    List<SysUser> selectUserAndRoleById2(Long id);
    List<SysUser> selectUserAndRoleById3(Long id);
    List<SysUser> selectUserAndRoleById4(Long id);
}
