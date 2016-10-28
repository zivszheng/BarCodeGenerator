package zivs.zheng.barcode.entity;

import java.io.Serializable;

public class ResultVo implements Serializable {

    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = 266891898082855875L;

    private int status;
    
    private String message;
    
    private Object object;
    
    public ResultVo(){
        this.status = 200; //默认成功
    }

    public ResultVo(int status, String message, Object object) {
        super();
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResultVo [status=" + status + ", message=" + message + ", object=" + object + "]";
    }
    
}
