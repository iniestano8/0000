package com.dbdou.app.wechat.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbdou.app.wechat.message.response.NewsMessage;
import com.dbdou.app.wechat.message.response.TextMessage;
import com.dbdou.app.wechat.message.response.model.Article;
import com.dbdou.app.wechat.util.ConstantUtil;
import com.dbdou.app.wechat.util.MessageUtil;
import com.dbdou.app.wechat.util.SHA1;

/**
 * 微信开发者服务器配置
 * （详见接入指南：http://mp.weixin.qq.com/wiki/17/2d4265491f12608cd170a95559800f2d
 * .html）
 * 
 * @author 0000
 *
 */
@Controller
@RequestMapping("")
public class CheckWXController {

	@ResponseBody
	@RequestMapping(value = "/checkWX", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String replyMessage(HttpServletRequest request) {
		String back = null;
		try {
			back = dealResponseWeixin(request); // 仅处理微信服务端发的请求
		} catch (Exception e) {
			e.printStackTrace();
		}
		if ((back == null) || (back.trim().equals(""))) {
			back = "error";
		}
		return back;
	}

	@ResponseBody
	@RequestMapping(value = "/checkWX", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String initWeixinURL(HttpServletRequest request) {
		String echostr = request.getParameter("echostr");
		if (checkWeixinReques(request)) {
			return echostr;
		} else {
			return null;
		}
	}

	public boolean checkWeixinReques(HttpServletRequest req) {

		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		if ((signature != null) && (timestamp != null) && (nonce != null)) {
			String[] strSet = { ConstantUtil.TOKEN, timestamp, nonce };
			Arrays.sort(strSet);
			String key = "";
			for (String string : strSet) {
				key = key + string;
			}
			String pwd = SHA1.SHA1Digest(key);
			return pwd.equals(signature);
		}
		return false;
	}

	public String dealResponseWeixin(HttpServletRequest req) {

		String respXml = null;
		try {
			Map<String, String> requestMap = MessageUtil.parseXml(req); // 调用parseXml方法解析请求消息
			String fromUserName = requestMap.get("FromUserName"); // 发送方帐号openId
			String toUserName = requestMap.get("ToUserName"); // 开发者微信号
			String msgType = requestMap.get("MsgType"); // 消息类型
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) { // 事件推送
				String eventType = requestMap.get("Event"); // 事件类型
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { // 订阅
					textMessage.setContent("您好，欢迎关注。体验生活，从这里开始！");
					respXml = MessageUtil.textMessageToXml(textMessage);
				} else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { // 取消订阅
					// 暂不做处理
				} else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) { // 上报地理位置事件

				} else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) { // 自定义菜单点击事件
					String eventKey = requestMap.get("EventKey"); // 事件KEY值，与创建菜单时的key值对应
					// 根据key值判断用户点击的按钮
					if (eventKey.equals("key1")) {
						Article article = new Article();
						article.setTitle("图文消息跳转页面");
						article.setDescription("图文消息跳转页面\n\n图文消息跳转页面\n\n图文消息跳转页面。");
						article.setPicUrl("http://wk-weixin.99114.com/imgs/se.jpg");
						article.setUrl("http://wk-weixin.99114.com/member/index/");
						List<Article> articleList = new ArrayList<Article>();
						articleList.add(article);
						// 创建图文消息
						NewsMessage newsMessage = new NewsMessage();
						newsMessage.setToUserName(fromUserName);
						newsMessage.setFromUserName(toUserName);
						newsMessage.setCreateTime(new Date().getTime());
						newsMessage
								.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
						newsMessage.setArticleCount(articleList.size());
						newsMessage.setArticles(articleList);
						respXml = MessageUtil.newsToXml(newsMessage);
					} else if (eventKey.equals("key2")) {
						textMessage
								.setContent("文字消息带链接跳转。文字消息带链接跳转.文字消息带链接跳转.文字消息带链接跳转.文字消息带链接跳转\n\nhttp://wk-weixin.99114.com/member/index/");
						respXml = MessageUtil.textMessageToXml(textMessage);
					}
				}
			} else { // 当用户发文本消息时
				String respContent = "";
				if (msgType.equals("text")) {
					respContent = "您发送的是文本消息！";
				} else if (msgType.equals("image")) {
					respContent = "您发送的是图片消息！";
				} else if (msgType.equals("voice")) {
					respContent = "您发送的是语音消息！";
				} else if (msgType.equals("video")) {
					respContent = "您发送的是视频消息！";
				} else if (msgType.equals("shortvideo")) {
					respContent = "您发送的是小视频消息！";
				} else if (msgType.equals("location")) {
					respContent = "您发送的是地理位置消息！";
				} else if (msgType.equals("link")) {
					respContent = "您发送的是链接消息！";
				}
				textMessage.setContent(respContent);
				respXml = MessageUtil.textMessageToXml(textMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return respXml;
	}
}
