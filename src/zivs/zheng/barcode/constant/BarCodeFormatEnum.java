package zivs.zheng.barcode.constant;

/**
 * @ClassName: BarCodeFormatEnum
 * @Description: BarCode 格式类
 * @author Zivs.Zheng
 * @date 2016年1月26日 下午2:09:23
 * @version V0.0.1
 */
public enum BarCodeFormatEnum {
        AZTEC("AZTEC","AZTEC码"),
        CODE_128("CODE_128","CODE_128码"),
        PDF_417("PDF_417","PDF_417码"),
        QR_CODE("QR_CODE","QR_CODE码");

        private String code;
        private String name;
        
        BarCodeFormatEnum(String code, String name) {
            this.code = code;
            this.name = name;
        }
        
        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
}
