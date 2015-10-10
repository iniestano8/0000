package com.dbdou.app.wechat.message.response;

import com.dbdou.app.wechat.message.response.model.Video;

/**
 * 视频消息
 * @ClassName: VideoMessage  
 * @exception
 * @since 1.0
 */
public class VideoMessage extends BaseMessage {
	
	// 视频
	private Video Video;

	public Video getVideo() {
		return Video;
	}
	public void setVideo(Video video) {
		Video = video;
	}
	
}