package com.dbdou.app.wechat.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbdou.app.wechat.util.SHA1;

/**
 * 微信开发者服务器配置
 * （详见接入指南：http://mp.weixin.qq.com/wiki/17/2d4265491f12608cd170a95559800f2d.html）
 * @author 0000
 *
 */
@Controller
@RequestMapping("/checkWX")
public class CheckWXController {

	@ResponseBody
	@RequestMapping("")
	public String checkWX(String signature, String timestamp,
			String nonce, String echostr) {
		String str = "";
		String token = "weixin";
		String[] tmpArr = new String[]{token, timestamp, nonce};
		Arrays.sort(tmpArr);
		for(int i=0; i<tmpArr.length; i++) {
			str += tmpArr[i];
		}
		SHA1 sha1 = new SHA1();
		str = sha1.Digest(str);
		if(str.equals(echostr)) {
//			return true;
		}else{
//			return false;
		}
		return echostr;
	}

}
