package mybatis;

import java.io.Serializable;
import java.util.Date;

public class SensorRecord implements Serializable {

    private Integer id;

    private Date dataTime;

    private Date reportTime;

    private Object sensorValue;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Object getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(Object sensorValue) {
        this.sensorValue = sensorValue;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}