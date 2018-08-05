package demo.dto;

/**
 * @author Created by: zhangbingbing
 * @date 2018/7/5
 **/
public class Information {

    private String name;//姓名
    private String telphone;//联系方式
    private String kuandaiNo;//账号
    private String address;//地址
    private String KDAddr;//安装地址
    private String begainDate;//开始时间
    private String endDate;//结束时间
    private String remark;//备注

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getKuandaiNo() {
        return kuandaiNo;
    }

    public void setKuandaiNo(String kuandaiNo) {
        this.kuandaiNo = kuandaiNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKDAddr() {
        return KDAddr;
    }

    public void setKDAddr(String KDAddr) {
        this.KDAddr = KDAddr;
    }

    public String getBegainDate() {
        return begainDate;
    }

    public void setBegainDate(String begainDate) {
        this.begainDate = begainDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Infomation{" +
                "name='" + name + '\'' +
                ", telphone='" + telphone + '\'' +
                ", kuandaiNo='" + kuandaiNo + '\'' +
                ", address='" + address + '\'' +
                ", KDAddr='" + KDAddr + '\'' +
                ", begainDate='" + begainDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
