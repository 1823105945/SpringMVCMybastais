package cn.itcast.ssm.po;

import javax.validation.constraints.Size;

public class ItemsWithBLOBs extends Items {
//    效验名称在1-30字符中间
//    message为错误的校验信息
    @Size(min = 1,max = 30,message = "{items.name.length.error}")
    private String name;

    private String detail;

    private String pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}