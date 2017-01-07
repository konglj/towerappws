package com.bolion.common.util;


import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.bolion.common.bean.GpsInfo;

public class GpsUtil {
	
	/**
	 * @param args
	 */
	public static String getAddress(String latitude, String longitude,String ak) {
		String str = HttpRequestUtil.sendGet("http://api.map.baidu.com/geocoder/v2/?ak="+ak+"&callback=renderReverse&location="
				+ latitude + "," + longitude + "&output=json&pois=0");
		System.out.println(str);
		String address = null;
		String sematic_description = null;

		String temp = "{\"result\":[{" + str.substring(51, str.length() - 2)
				+ "]}";
		try {
			JSONObject jo =JSONObject.fromObject(temp);
			JSONArray jsonArray = (JSONArray) jo.get("result");
			for (int i = 0; i < jsonArray.size(); ++i) {
				JSONObject o = (JSONObject) jsonArray.get(i);
				address = o.getString("formatted_address");
				sematic_description = o.getString("sematic_description");
				System.out.println("formatted_address:" + address
						+ sematic_description);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		if (sematic_description != null) {
			address += sematic_description;
		}
		if (address != null) {

		}
		System.out.println(temp);

		return address;
	}
	
	public static GpsInfo getGpsInfo(String latitude, String longitude,String ak) {
		String str = HttpRequestUtil.sendGet("http://api.map.baidu.com/geocoder/v2/?ak="+ak+"&callback=renderReverse&location="
				+ latitude + "," + longitude + "&output=json&pois=0");
		System.out.println(str);
		String address = null;
		String sematic_description = null;
		if(!str.startsWith("renderReverse&&renderReverse"))
			return new GpsInfo();
		String temp = "{\"result\":[{" + str.substring(51, str.length() - 2)
				+ "]}";
		try {
			JSONObject jo =  JSONObject.fromObject(temp);
			JSONArray jsonArray = (JSONArray) jo.get("result");
			for (int i = 0; i < jsonArray.size(); ++i) {
				JSONObject o = (JSONObject) jsonArray.get(i);
				JSONObject addressComponent=o.getJSONObject("addressComponent");
				GpsInfo gpsInfo=(GpsInfo)JSONObject.toBean(addressComponent, GpsInfo.class);
				if(gpsInfo==null)
					return new GpsInfo();
				return gpsInfo;
				
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return new GpsInfo();
	}

}
