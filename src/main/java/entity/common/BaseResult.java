package entity.common;

public class BaseResult {
    private String code = "0";
    private Object data = null;
    private String info = "default error info";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
        this.code = "1";
        if (data == null) {
            this.code = "0";
        }
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }


}
