package com.bolion.index.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bolion.common.TowerConfig;
import com.bolion.common.bean.GpsInfo;
import com.bolion.common.bean.Province;
import com.bolion.common.util.DataValidation;
import com.bolion.common.util.GpsUtil;
import com.bolion.index.bean.District;
import com.bolion.index.bean.IndexInfo;
import com.bolion.index.service.IndexService;
import com.bolion.tower.bean.TowerIndex;

@Controller
@RequestMapping("/index")
public class IndexWeb {

	@Autowired
	private IndexService indexService;

	@RequestMapping("/weGetCityList")
	@ResponseBody
	public Object getCitys() {

		List<Province> provinces = indexService.getProvinces();
		return provinces;
	}

	@RequestMapping("/weGetIndexInfoByGps")
	@ResponseBody
	public Object getIndexInfoByGps(String gpsx, String gpsy) {
		if (DataValidation.isNullOrEmpty(gpsx)
				|| DataValidation.isNullOrEmpty(gpsy))
			return new IndexInfo();
		GpsInfo gpsInfo=GpsUtil.getGpsInfo( gpsy,gpsx,TowerConfig.baidu_map_api);
		if(gpsInfo==null)
			gpsInfo=new GpsInfo();
		IndexInfo indexInfo = new IndexInfo();
		
		indexInfo.setCityid(gpsInfo.getCityid());
		indexInfo.setCityname(gpsInfo.getCity());
		indexService.getIndexInfo(indexInfo);
		return indexInfo;
	}

	@RequestMapping("/weGetIndexInfoByCityid")
	@ResponseBody
	public Object getIndexInfoByCityid(Integer cityid) {
		if (cityid == null || cityid == 0)
			return new IndexInfo();
		if(cityid>0&&cityid/100==0)
			cityid=cityid*100+1;
		IndexInfo indexInfo = new IndexInfo();
		indexInfo.setCityid(cityid);
		indexService.getIndexInfo(indexInfo);
		return indexInfo;
	}

	@RequestMapping("/weGetDistrictList")
	@ResponseBody
	public Object getweGetDistrictList(int cityid){
		if(cityid>0&&cityid/100==0)
			cityid=cityid*100+1;
		List<District> district = indexService.getDistricts(cityid);
		Map map = new HashMap();
		if(district == null){
			map.put("result", "查无数据");
			return map;
		}
		return district;
	}
	
	@RequestMapping("/weSearchIndexTowerInfo")
	@ResponseBody
	public Object weSearchIndexTowerInfo(int cityid,String content) {
		Map resultMap = new HashMap();
		if(content == null || content.equals("")){
			resultMap.put("result", "内容不能为空");
			return resultMap;
		}
		if (cityid == 0)
			return new IndexInfo();
		
		Map searchMap = new HashMap();
		searchMap.put("cityid", cityid);
		searchMap.put("content", content);
		searchMap.put("showcount",TowerConfig.index_show_tower_count);
		List<TowerIndex> towers = indexService.searchTowers(searchMap);
		resultMap.put("result", towers);
		return resultMap;
	}
	
}
