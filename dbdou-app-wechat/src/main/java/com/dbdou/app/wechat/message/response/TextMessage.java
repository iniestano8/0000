package com.dbdou.app.wechat.message.response;

/**
 * 文本消息
 * @ClassName: TextMessage  
 * @exception
 * @since 1.0
 */
public class TextMessage extends BaseMessage {
	
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
}