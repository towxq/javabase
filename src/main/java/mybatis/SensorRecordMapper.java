package mybatis;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SensorRecordMapper {

    List<SensorRecord> selectByWarnData(Map<String, Object> params);

    int selectByWarnDataNum(@Param(value = "tableName") String tableName);

    int updataWarnData(@Param(value = "tableName") String tableName, @Param(value = "id") Integer id);

    int insert(Map<String, Object> params);

    int existTable(@Param(value = "tableName") String tableName);

    int dropTable(@Param(value = "tableName") String tableName);

    int createNewTable(Map<String, Object> params);

    Date selectNewDate(@Param(value = "tableName") String tableName);

    Date selectEndDate(@Param(value = "tableName") String tableName);

    List<SensorRecord> selectById(@Param(value = "tableName") String tableName,@Param(value = "ids")List<Integer> params);
}