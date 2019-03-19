package mybatis;

import java.util.List;

public interface UserMapper {
    SysUser selectById(Long id);
    List<SysUser> selectAll();
    int insertUser(SysUser user);
    SysUser selectbyUserName(SysUser user);
}
