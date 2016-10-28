package zivs.hubs1.test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import zivs.hubs1.barcode.constant.BarCodeFormatEnum;
import zivs.hubs1.barcode.entity.GeneratorProperties;
import zivs.hubs1.barcode.entity.ResultVo;
import zivs.hubs1.barcode.option.BarcodeOperation;

public class BarcodeOperationTest {
    BarcodeOperation  opt = new BarcodeOperation();
    /**
     * @Title: BarcodeOperationTest.java
     * @Description: 二维码生成
     * @throws
     */
    @Test
    public void testCreatBarCode() {
        GeneratorProperties propet = new GeneratorProperties();
        // 设置生成二维码或条码的类型  目前支持四中 AZTEC,CODE_128(条码), PDF_417, QR_CODE;
        propet.setCodeFormat(BarCodeFormatEnum.CODE_128);
        propet.setImageFormat("gif");
        propet.setWidth(200);
        propet.setHeight(70);
        propet.setSaveUrl("D:"+File.separator);
        propet.setContents("https://www.baidu.com");
        DateFormat df =new SimpleDateFormat("yyMMddhhmmssSSS");
        propet.setCodeName("rq-code-"+df.format(new Date()));
        ResultVo rs = opt.creatBarCode(propet);
        System.out.println(rs);
    }
    
    /**
     * @Title: BarcodeOperationTest.java
     * @Description: 二维码解析
     * @throws
     */
    @Test
    public void testParseBarCode() {
        File file = new File("D:\\rq-code-160126015250447.gif");
        ResultVo rs = opt.parseBarCode(file);
        System.out.println(rs);
    }

}
