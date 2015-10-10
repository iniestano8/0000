package com.dbdou.app.wechat.message.response;

import com.dbdou.app.wechat.message.response.model.Music;

/**
 * 音乐消息
 * @ClassName: MusicMessage  
 * @exception
 * @since 1.0
 */
public class MusicMessage extends BaseMessage {
	
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}
	public void setMusic(Music music) {
		Music = music;
	}
	
}