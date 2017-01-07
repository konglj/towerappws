package com.bolion.setting.web;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bolion.money.common.StrUtil;
import com.bolion.setting.bean.AppMessage;
import com.bolion.setting.bean.AppQuestion;
import com.bolion.setting.common.MsgResult;
import com.bolion.setting.service.impl.SetService;

/**
 * 
 * @author sujw 设置与帮助Controller
 * 
 */

@Controller
@RequestMapping("/setting")
public class SetController {
	
	@Autowired
	private SetService setService;
	
	/**
	 * 意见反馈
	 * 
	 * @return
	 */
	@RequestMapping("/weAddOpinion")
	@ResponseBody
	public MsgResult weAddOpinion(@RequestParam(value = "userid") int userid,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "contact") String contact) {
		AppQuestion appQuestion= new AppQuestion();
		appQuestion.setId(0);
		appQuestion.setType("YJ");
		appQuestion.setTypename("意见反馈");
		appQuestion.setUserid(userid);
		appQuestion.setContents(content);
		appQuestion.setContact(contact);
		int count = setService.addOpinion(appQuestion);
		System.out.println(userid+";"+content+";"+contact);
		if(count==1){
			return new MsgResult(0, "提交成功,感谢您的支持");
		}else{
			return new MsgResult(1, "提交失败");
		}
	}

	/**
	 * 关于app
	 */
	@RequestMapping("/weGetAbout")
	@ResponseBody
	public MsgResult weGetAbout(@RequestParam(value = "clienttype") int clienttype) {
		if(clienttype == 1 || clienttype == 2){
			AppMessage appMessage = setService.getAppAbout(clienttype);
			if(appMessage == null){
				return new MsgResult(0, "暂无数据");
			}
			String temp = StrUtil.FormatStr(appMessage.getQrcodeimg());
			appMessage.setQrcodeimg(temp);
			String url = StrUtil.FormatStr(appMessage.getUrl());
			appMessage.setUrl(url);
			String appimg = StrUtil.FormatStr(appMessage.getAppimg());
			appMessage.setAppimg(appimg);
			return new MsgResult(0, appMessage);
		}else{
			return new MsgResult(7, "请提交正确的类型");
		}
	}

	/**
	 * 版本更新
	 * 
	 */
	@RequestMapping("/weCheckVersion")
	@ResponseBody
	public MsgResult weCheckVersion(
			@RequestParam(value = "clienttype") int clienttype) {
		if(clienttype == 1 || clienttype == 2){
			AppMessage appMessage = setService.getAppAbout(clienttype);
			if(appMessage == null){
				return new MsgResult(0, "暂无数据");
			}
			String temp = StrUtil.FormatStr(appMessage.getQrcodeimg());
			appMessage.setQrcodeimg(temp);
			String url = StrUtil.FormatStr(appMessage.getUrl());
			appMessage.setUrl(url);
			String appimg = StrUtil.FormatStr(appMessage.getAppimg());
			appMessage.setAppimg(appimg);
			return new MsgResult(0, appMessage);
		}else{
			return new MsgResult(7, "请提交正确的类型");
		}
	}

	/**
	 * 抢单详情问题
	 */
	@RequestMapping("/weSiteFlow")
	@ResponseBody
	public MsgResult weSiteFlow(HttpServletRequest request) {
		Map map = new HashedMap();
		map.put("type","QD");
		List<AppQuestion> list = setService.weQdFlow(map);
		if(list == null){
			return new MsgResult(2, "暂无数据");
		}else{
			return new MsgResult(0, list);
		}
	}
	
	
	/**
	 * 常见问题
	 */
	@RequestMapping("/weCommonQuesions")
	@ResponseBody
	public MsgResult weCommonQuesions(HttpServletRequest request) {
		Map map = new HashedMap();
		map.put("type","CJ");
		List<AppQuestion> list = setService.weQdFlow(map);
		if(list == null){
			return new MsgResult(2, "暂无数据");
		}else{
			return new MsgResult(0, list);
		}
	}

	/**
	 * 获得问题详情
	 */
	@RequestMapping("/weCommonQuesionInfo")
	@ResponseBody
	public MsgResult weCommonQuesionInfo(@RequestParam(value = "id") int id) {
		AppQuestion appQuestion = setService.weCommonQuesionInfo(id);
		if(appQuestion == null){
			return new MsgResult(2, "暂无数据");
		}
		return new MsgResult(0, appQuestion);
	}

	/**
	 * app分享接口
	 */
	@RequestMapping("appShare")
	@ResponseBody
	public MsgResult weAppShare(@RequestParam(value = "userid") int userid){
		
		//settingService.appShare();
		return new MsgResult(0, "提交成功"+userid);
	}
	
}