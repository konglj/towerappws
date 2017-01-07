package com.bolion.money.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bolion.money.bean.Bank;
import com.bolion.money.bean.Card;
import com.bolion.money.bean.MyMoney;
import com.bolion.money.bean.TxRecord;
import com.bolion.money.bean.TxSource;
import com.bolion.money.common.ParamerUtil;
import com.bolion.money.common.StrUtil;
import com.bolion.money.common.TimeUtil;
import com.bolion.money.service.impl.MoneyService;
import com.bolion.setting.common.MsgResult;

/**
 * 
 * @author sujw 我的钱包Controller
 * 
 */

@Controller
@RequestMapping("/money")
public class MoneyController {
	
	@Autowired
	private MoneyService moneyService;
	
	/**
	 * 获取我的钱包
	 */
	@RequestMapping("/weGetUserMoney")
	@ResponseBody
	public MsgResult weGetUserMoney(@RequestParam(value = "userid") int userid) {
		if(userid==0){
			return new MsgResult(2, "用户Id不能为0");
		}
		MyMoney myMoney = moneyService.getweGetUserMoney(userid);
		if(myMoney == null){
			return new MsgResult(1, "暂无数据");
		}
		return new MsgResult(0, myMoney);
	}

	/**
	 * 获取银行卡类型列表接口
	 */
	@RequestMapping("/weGetBankTypes")
	@ResponseBody
	public MsgResult weGetBankTypes(HttpServletRequest request) {
		List<Bank> list = moneyService.getBanks();
		if(list == null){
			return new MsgResult(1, "暂无数据");
		}
		for(int i=0;i<list.size();i++){
			String temp=StrUtil.FormatStr(list.get(i).getIcon());
			list.get(i).setIcon(temp);
		}
		return new MsgResult(0, list);
	}

	/**
	 * 获取用户银行卡列表接口
	 */
	@RequestMapping("/weGetBankList")
	@ResponseBody
	public MsgResult weGetBankList(@RequestParam(value = "userid") int userid) {
		if(userid==0){
			return new MsgResult(2, "用户Id不能为0");
		}
		List<Card> list = moneyService.weGetBankList(userid);
		if(list == null){
			return new MsgResult(1, "暂无数据");
		}
		for(int i=0;i<list.size();i++){
			String temp=StrUtil.FormatStr(list.get(i).getBankicon());
			list.get(i).setBankicon(temp);
		}
		return new MsgResult(0, list);
	}

	/**
	 * 获取银行卡详细信息接口
	 */
	@RequestMapping("/weGetBankInfo")
	@ResponseBody
	public MsgResult weGetBankInfo(@RequestParam(value = "id") int id) {
		if(id==0){
			return new MsgResult(2, "卡号Id不能为0");
		}
		Card card = moneyService.getCardInfo(id);
		if(card == null){
			return new MsgResult(1, "暂无数据");
		}
		String temp = StrUtil.FormatStr(card.getBankicon());
		card.setBankicon(temp);
		return new MsgResult(0, card);
	}

	/**
	 * 银行卡添加、修改接口
	 */
	@RequestMapping("/weUpdateCard")
	@ResponseBody
	public MsgResult weUpdateCard(@RequestParam(value = "id") int id,
			@RequestParam(value = "userid") int userid,
			@RequestParam(value = "bankaccount") String bankaccount,
			@RequestParam(value = "bankname") String bankname,
			@RequestParam(value = "bankopen") String bankopen,
			@RequestParam(value = "bankcardid") String bankcardid) {
		if(userid==0){
			return new MsgResult(2, "用户Id不能为0");
		}
		System.out.println(bankaccount+";"+bankname+";"+bankopen+";"+bankcardid+";"+id);
		Card card = new Card();
		card.setId(id);
		card.setUserid(userid);
		card.setWxid("testtest");
		card.setBankaccount(bankaccount);
		card.setBankname(bankname);
		card.setBankopen(bankopen);
		card.setBankcardid(bankcardid);
		int count=0;
		try {
			count=moneyService.updateCard(card);
		} catch (Exception e) {
			e.printStackTrace();
			return new MsgResult(0, "保存失败");
		}
		if(count==0){
			return new MsgResult(0, "保存失败");
		}
		return new MsgResult(0, "保存成功");
	}

	/**
	 * 删除银行卡
	 */
	@RequestMapping("/weDelCard")
	@ResponseBody
	public MsgResult weDelCard(@RequestParam(value = "id") int id) {
		if(id==0){
			return new MsgResult(2, "卡号Id不能为0");
		}
		int number = moneyService.deleteBankCard(id);
		if(number== 0){
			return new MsgResult(1, "删除失败");
		}else{
			return new MsgResult(0, "删除成功");
		}
	}

	/**
	 * 设置默认银行卡
	 */
	@RequestMapping("/weUpdateDefaultCard")
	@ResponseBody
	public MsgResult weUpdateDefaultCard(@RequestParam(value = "id") int id,
			@RequestParam(value="userid") int userid) {
		if(id== 0 || userid == 0){
			return new MsgResult(2, "卡号Id和用户Id都不能为0");
		}
		Map map=new HashMap();
		map.put("userid",userid);
		map.put("id",id);
		int count=0;
		try {
			count=moneyService.SetDefault(map);
		} catch (Exception e) {
			e.printStackTrace();
			return new MsgResult(1, "设置失败");
		}
		if(count==0)
			return new MsgResult(1, "设置失败");
		return new MsgResult(0, "设置成功");
	}

	/**
	 * 立即提现
	 */
	@RequestMapping("/weUpdateUserTx")
	@ResponseBody
	public MsgResult weUpdateUserTx(@RequestParam(value = "userid") int userid) {
		if(userid==0){
			return new MsgResult(2, "用户Id不能为0");
		}
		Map map=new HashMap();
		map.put("userid",userid);
		//获取金额信息
		MyMoney money=moneyService.getweGetUserMoney(userid);
		if(money.getGetnow()==0){
			return new MsgResult(4, "当前没有可提现金额!");
		}
		//生成提现编号
		//String txid=ParamerUtil.getOrderid(request, StrUtil.tx);
		String time = TimeUtil.getNNow();
		StringBuilder sb = new StringBuilder();
		sb.append(StrUtil.tx);
		sb.append(time);
		sb.append(ParamerUtil.numberFormat(userid, 6));
		String txid=sb.toString();
		map.put("txid",txid);
		int count=0;
		try {
			count=moneyService.txMoney(map);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		if(count==0)
			return new MsgResult(5, "提现失败!");
		if(count==-1)
			return new MsgResult(6, "没有设置默认银行卡，请先设置！");
		return new MsgResult(0, "提现成功");
	}

	/**
	 * 获取可提现列表
	 */
	@RequestMapping("/weGetGetNowMoenys")
	@ResponseBody
	public MsgResult weGetGetNowMoenys(
			@RequestParam(value = "userid") int userid) {
		List<TxSource> list = moneyService.weGetGetNowMoenys(userid);
		if(list == null){
			return new MsgResult(1,"暂无数据");
		}
		for(int i=0;i<list.size();i++){
			String temp = StrUtil.FormatStr(list.get(i).getTowertypeimg());
			list.get(i).setTowertypeimg(temp);
		}
		return new MsgResult(0, list);
	}

	/**
	 * 获取提现中列表
	 */
	@RequestMapping("/weGetGettingNowMoneys")
	@ResponseBody
	public MsgResult weGetGettingNowMoneys(
			@RequestParam(value = "userid") int userid) {
		List<TxRecord> list = moneyService.weGetGettingNowMoneys(userid);
		if(list == null){
			return new MsgResult(1,"暂无数据");
		}
		for(int i=0;i<list.size();i++){
			String temp = StrUtil.FormatStr(list.get(i).getTowertypeimg());
			list.get(i).setTowertypeimg(temp);
		}
		return new MsgResult(0, list);
	}

	/**
	 * 获取累计提现列表
	 */
	@RequestMapping("/weGetAllGettingMoenys")
	@ResponseBody
	public MsgResult weGetAllGettingMoenys(
			@RequestParam(value = "userid") int userid) {
		List<TxRecord> list = moneyService.weGetAllGettingMoenys(userid);
		if(list == null){
			return new MsgResult(1,"暂无数据");
		}
		for(int i=0;i<list.size();i++){
			String temp = StrUtil.FormatStr(list.get(i).getTowertypeimg());
			list.get(i).setTowertypeimg(temp);
		}
		return new MsgResult(0, list);
	}
	
	/**
	 * 确认到账
	 */
	@RequestMapping("/weUpdateTxState")
	@ResponseBody
	public MsgResult weUpdateTxState(@RequestParam(value = "txid") int txid) {
		Map map=new HashMap();
		map.put("id",txid);
		map.put("state", 5);
		int count=0;
		try {
			count=moneyService.updateTxRecodeState(map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(count==0){
			return new MsgResult(6, StrUtil.tx_recode_state_error);
		}
		return new MsgResult(0,"确认成功");
	}

}