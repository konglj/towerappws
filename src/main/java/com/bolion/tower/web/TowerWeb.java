package com.bolion.tower.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bolion.common.TowerConfig;
import com.bolion.common.service.SettingService;
import com.bolion.common.util.ResultUtil;
import com.bolion.common.util.SettingKey;
import com.bolion.common.util.TowerUtil;
import com.bolion.index.bean.IndexInfo;
import com.bolion.tower.bean.Tower;
import com.bolion.tower.bean.TowerIndex;
import com.bolion.tower.bean.TowerInfo;
import com.bolion.tower.bean.TowerList;
import com.bolion.tower.bean.TowerPage;
import com.bolion.tower.common.util.StrUtil;
import com.bolion.tower.service.TowerService;
import com.bolion.user.service.UserService;

@Controller
@RequestMapping("/tower")
public class TowerWeb {

	@Autowired
	private TowerService towerService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private SettingService settingService;

	@RequestMapping("/weGetTowers")
	@ResponseBody
	public Object getTowers(TowerPage towerPage) {
		if (towerPage.getTowercity() == 0 || towerPage.getTowerstyle() == 0
				|| towerPage.getUserid() == 0)
			return new TowerList();
		int userlevel = userService.getUserLevel(towerPage.getUserid());
		if (userlevel == 0)
			return new TowerList();
		// towerPage.setUserlevel(userlevel);
		towerPage.setTowerlevel(TowerUtil.getTowerLevel(userlevel));
		System.out.println(towerPage.getTowercity());
		if(towerPage.getTowercity()>0&&towerPage.getTowercity()/100==0){
			towerPage.setTowercity(towerPage.getTowercity()*100+1);
		}
		System.out.println(towerPage.getTowercity());
		return towerService.getTowers(towerPage);
	}

	@RequestMapping("/weGetTowerInfo")
	@ResponseBody
	public Object getTowerInfo(Integer towerid, Integer userid) {
		if (towerid == null || towerid == 0 || userid == null || userid == 0)
			return new TowerInfo();
		Map map = new HashMap();
		map.put("towerid", towerid);
		map.put("userid", userid);
		return towerService.getTowerInfo(map);
	}

	@RequestMapping("/weUpdateFavourite")
	@ResponseBody
	public Object updateFavourite(Integer towerid, Integer userid,
			Integer isfavourite) {
		if (towerid == null || userid == null || isfavourite == null
				|| towerid == 0 || userid == 0) {
			return ResultUtil.generateResponseMsg(
					StrUtil.update_favourite_paramer);
		}
		if (isfavourite != 0 && isfavourite != 1)
			return ResultUtil.generateResponseMsg(
					StrUtil.update_favourite_paramer);
		int count = towerService.updateTowerFavourite(userid, towerid,
				isfavourite);
		if (count == 0) {
			if (isfavourite == 0)
				return ResultUtil.generateResponseMsg(
						StrUtil.update_unfavourite_error);
			else
				return ResultUtil.generateResponseMsg(
						StrUtil.update_favourite_error);
		}
		return ResultUtil.generateResponseMsg("1");

	}

	@RequestMapping("/weSearchBSTowerInfo")
	@ResponseBody
	public Object weSearchIndexTowerInfo(int cityid,String content,String userid) {
		Map resultMap = new HashMap();
		if(content == null || content.equals("")){
			resultMap.put("result", "内容不能为空");
			return resultMap;
		}
		if (cityid == 0)
			return new IndexInfo();
		
		Map searchMap = new HashMap();
		searchMap.put("userid",userid);
		if(cityid>0&&cityid/100==0)
			cityid=cityid*100+1;
		searchMap.put("cityid", cityid);	
		searchMap.put("content", content);
		searchMap.put("showcount",TowerConfig.index_show_tower_count);
		List<TowerIndex> towers = towerService.searchbsTowers(searchMap);
		resultMap.put("result", towers);
		return resultMap;
	}
	
	@RequestMapping("/weGetXy")
	@ResponseBody
	public Object weGetXy(String towercity){
		Map<String, String> map = new HashMap<String, String>();
		if(towercity==null || towercity.equals("")||towercity.length()<2){
			map.put("content", "");
			return map;
		}
		System.out.println("-----xy-----");
		System.out.println(towercity);
		towercity=towercity.substring(0,2);
		System.out.println(towercity);
		String xy = settingService.getSettingContent(String.format(SettingKey.orderxy,towercity));
		if (xy == null)
			xy = "";
		map.put("content", xy);
		System.out.println(xy);
		return map;
	}
	
}
