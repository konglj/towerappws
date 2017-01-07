package com.bolion.index.mapper;

import java.util.List;

import com.bolion.index.bean.Banner;
import com.bolion.index.bean.District;

public interface IndexMapper {
	
	/**
	 * 获取首页的显示图片
	 * @return
	 */
	public List<Banner> getBanners();
	
	public List<District> getDistricts(int cityid);

}
