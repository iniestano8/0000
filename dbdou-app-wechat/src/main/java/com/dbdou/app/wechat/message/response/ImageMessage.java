package com.dbdou.app.wechat.message.response;

import com.dbdou.app.wechat.message.response.model.Image;

/**
 * 图片消息
 * @ClassName: ImageMessage  
 * @exception
 * @since 1.0
 */
public class ImageMessage extends BaseMessage {
	
	// 图片
	private Image Image;

	public Image getImage() {
		return Image;
	}
	public void setImage(Image image) {
		Image = image;
	}
	
}