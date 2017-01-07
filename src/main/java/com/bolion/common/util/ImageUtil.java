package com.bolion.common.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;




import com.bolion.common.Config;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ImageUtil {

	/**
	 * 读取流
	 * 
	 * @return
	 */
	public static byte[] readInputStream(FileInputStream inStream)
			throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		// 创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		// 每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len = 0;
		// 使用一个输入流从buffer里把数据读取出来
		while ((len = inStream.read(buffer)) != -1) {
			// 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
			outStream.write(buffer, 0, len);
		}
		// 关闭输入流
		inStream.close();
		// 把outStream里的数据写入内存
		return outStream.toByteArray();
	}
	
	//base64字符串转化成图片
	public static String byteChangeImage(HttpServletRequest request,String imgStr,String imagePath) {
		return byteChangeImage(request,imagePath,"");
	}
    public static String byteChangeImage(HttpServletRequest request,String imgStr,String imagePath,String oldimg){ 
    	String rootPath = new File(request.getRealPath("/")).getParent();
		// 生成二维码图像
		String pathRoot = rootPath + "/" + Config.getFilerootname();
		String imgFilePath="";
    	//对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null){ //图像数据为空
        	return "";
    	}
            
        BASE64Decoder decoder = new BASE64Decoder();
        try 
        {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0; i<b.length; ++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
//            if (oldimg != null && !oldimg.equals("") && 
//            		imgStr.equals(imageToBase64(path + oldimg.substring(oldimg.length() - 18,oldimg.length())))) {
//            	return oldimg;
//            }
            //生成jpeg图片
            String imageName =UUID.randomUUID().toString()+ ".png";
           // String imgFilePath = pathRoot + "/" + imageName;//新生成的图片
             imgFilePath="/"+imagePath+"/"+imageName;
             pathRoot="/"+imagePath+"/";
            
            // 判断路径是否存在，不存在则新建
            File savedir = new File(pathRoot); 
            if(!savedir.exists()){
            	savedir.mkdirs();
            }
            
            OutputStream out = new FileOutputStream(pathRoot+imageName);    
            out.write(b);
            out.flush();
            out.close();
            
            return imagePath;
        } 
        catch (Exception e) 
        {
            return "";
        }
    }
    
    /**
     * @Descriptionmap 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     * @author temdy
     * @Date 2015-01-26
     * @param path 图片路径
     * @return
     */
    public static String imageToBase64(String path) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }
	
	
	// 根据城市获取天气信息的java代码
	// cityName 是你要取得天气信息的城市的中文名字，如“北京”，“深圳”
	public static String getWeatherInform(String cityName) {

		// 百度天气API
		String baiduUrl = "http://api.map.baidu.com/telematics/v3/weather?location=北京&output=json&ak=6bbece6203b9f7418be6e3d037cf0978&qq-pf-to=pcqq.c2c";
		StringBuffer strBuf;

		try {
			// 通过浏览器直接访问http://api.map.baidu.com/telematics/v3/weather?location=北京&output=json&ak=5slgyqGDENN7Sy7pw29IUvrZ
			// 5slgyqGDENN7Sy7pw29IUvrZ 是我自己申请的一个AK(许可码)，如果访问不了，可以自己去申请一个新的ak
			// 百度ak申请地址：http://lbsyun.baidu.com/apiconsole/key
			// 要访问的地址URL，通过URLEncoder.encode()函数对于中文进行转码
			baiduUrl = "http://api.map.baidu.com/telematics/v3/weather?location="
					+ URLEncoder.encode(cityName, "utf-8")
					+ "&output=json&ak=6bbece6203b9f7418be6e3d037cf0978&qq-pf-to=pcqq.c2c";
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		strBuf = new StringBuffer();

		try {
			URL url = new URL(baiduUrl);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"));// 转码。
			String line = null;
			while ((line = reader.readLine()) != null)
				strBuf.append(line + " ");
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//取当前温度
		JSONObject jsonObj = JSONObject.fromObject(strBuf.toString());  
	            JSONArray array = JSONArray.fromObject(jsonObj.get("results").toString());  
	            JSONArray js = (JSONArray)array.getJSONObject(0).get("weather_data");
	            String te = JSONObject.fromObject(js.get(0)).getString("date").toString();
	            String [] tes = null;
	            if(te != null && !te.equals("")){
	            	tes = te.replace("(", "：").replace(")", "：").split("：");
	            }
	             
	            String returnStr = "";
	            if(tes.length > 2 && tes[2].length() > 0){
	            	returnStr = tes[2];
	            }
		
		return returnStr;
	}

}