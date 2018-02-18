package com.wifishared.common.data.dto.hotspot;

import lombok.Data;

@Data
public class HotSpotCommentReqBody {

	private String hotspotconfigId;
	private String orderHistoryId;
	private float speedScore;
	private float stableScore;
	private float strengthScore;

}
