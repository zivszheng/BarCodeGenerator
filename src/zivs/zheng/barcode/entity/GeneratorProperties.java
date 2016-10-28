package zivs.zheng.barcode.entity;

import java.io.Serializable;

import zivs.zheng.barcode.constant.BarCodeFormatEnum;

public class GeneratorProperties implements Serializable {
    /**
     * @Fields serialVersionUID : TODO
     */
    private static final long serialVersionUID = -8970018289028960764L;

    private String contents;
    
    private BarCodeFormatEnum codeFormat;
    
    private int height;
    
    private int width;
    
    private String imageFormat;
    
    private String saveUrl;
    
    private String codeName;

    public String getContents() {
        return contents;
    }
    

    public GeneratorProperties() {
        super();
        this.width = 200;
        this.height = 200;
        this.codeFormat = BarCodeFormatEnum.QR_CODE;
    }
    public GeneratorProperties(String contents, BarCodeFormatEnum codeFormat, int height, int width, String imageFormat, String saveUrl, String codeName) {
        super();
        this.contents = contents;
        this.codeFormat = codeFormat;
        this.height = height;
        this.width = width;
        this.imageFormat = imageFormat;
        this.saveUrl = saveUrl;
        this.codeName = codeName;
    }


    public void setContents(String contents) {
        this.contents = contents;
    }

    public BarCodeFormatEnum getCodeFormat() {
        return codeFormat;
    }

    public void setCodeFormat(BarCodeFormatEnum codeFormat) {
        this.codeFormat = codeFormat;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }

    public String getSaveUrl() {
        return saveUrl;
    }

    public void setSaveUrl(String saveUrl) {
        this.saveUrl = saveUrl;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }


    @Override
    public String toString() {
        return "GeneratorProperties [contents=" + contents + ", codeFormat=" + codeFormat + ", height=" + height + ", width=" + width
                + ", imageFormat=" + imageFormat + ", saveUrl=" + saveUrl + ", codeName=" + codeName + "]";
    }

}
