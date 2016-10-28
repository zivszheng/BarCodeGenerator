package zivs.zheng.barcode.option;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import zivs.zheng.barcode.entity.GeneratorProperties;
import zivs.zheng.barcode.entity.ResultVo;
import zivs.zheng.barcode.tools.BufferedImageLuminanceSource;
import zivs.zheng.barcode.tools.MatrixToImageWriter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class BarcodeOperation {
    /**
     * @Title: parseBarCode
     * @Description: 二维码的解析 
     * @param file
     * @return
     * @throws
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResultVo parseBarCode(File file) {  
        ResultVo res = new ResultVo();
        try {  
            MultiFormatReader formatReader = new MultiFormatReader();  
   
            if (!file.exists()) {
                res.setMessage("参数有误");
                res.setStatus(400);
                return res; 
            }  
   
            BufferedImage image = ImageIO.read(file);  
   
            LuminanceSource source = new BufferedImageLuminanceSource(image);  
            Binarizer binarizer = new HybridBinarizer(source);  
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
   
            Map hints = new HashMap();  
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
            Result result = formatReader.decode(binaryBitmap, hints);  
            res.setObject(result);
        } catch (Exception e) {  
            System.out.println(e);
            res.setMessage("服务异常");
            res.setStatus(500);
            return res;
        }  
        return res;
    } 
    
    /**
     * @Title: creatBarCode
     * @Description: 二维码的生成
     * @param propet
     * @return
     * @throws
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public ResultVo creatBarCode(GeneratorProperties propet){
        ResultVo res = new ResultVo();
        if (null == propet || null == propet.getCodeFormat() || null == propet.getCodeName() || null == propet.getContents() || 
                null == propet.getImageFormat()){
            res.setMessage("参数有误");
            res.setStatus(400);
            return res;
        }
        Hashtable hints = new Hashtable();
        //内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BarcodeFormat format = BarcodeFormat.QR_CODE;
            String codeform = propet.getCodeFormat().toString();
            if (BarcodeFormat.AZTEC.toString().equals(codeform)){
                format = BarcodeFormat.AZTEC;
            } else if (BarcodeFormat.QR_CODE.toString().equals(codeform)){
                format = BarcodeFormat.QR_CODE;
            } else if (BarcodeFormat.PDF_417.toString().equals(codeform)){
                format = BarcodeFormat.PDF_417;
            } else if (BarcodeFormat.CODE_128.toString().equals(codeform)){
                format = BarcodeFormat.CODE_128;
            }
            BitMatrix bm = new MultiFormatWriter().encode(propet.getContents(),format, propet.getWidth(), propet.getHeight());
            //生成二维码
            File outputFile = new File(propet.getSaveUrl()+propet.getCodeName()+"."+propet.getImageFormat());
            MatrixToImageWriter.writeToFile(bm, propet.getImageFormat(), outputFile);
            res.setMessage("生成成功！");
        } catch (Exception e) {
            System.out.println(e);
            res.setMessage("服务异常");
            res.setStatus(500);
            return res;            
        }
        return res;
    }

}
