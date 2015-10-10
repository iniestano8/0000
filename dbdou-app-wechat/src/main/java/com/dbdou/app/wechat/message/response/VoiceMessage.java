package com.dbdou.app.wechat.message.response;

import com.dbdou.app.wechat.message.response.model.Voice;

/**
 * 语音消息
 * @ClassName: VoiceMessage  
 * @exception
 * @since 1.0
 */
public class VoiceMessage extends BaseMessage {
	
	// 语音
	private Voice Voice;

	public Voice getVoice() {
		return Voice;
	}
	public void setVoice(Voice voice) {
		Voice = voice;
	}
	
}