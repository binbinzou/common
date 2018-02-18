package com.wifishared.common.data.otd.hotspot;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class HotSpotCommentRspBody {

	private String id;

	private Timestamp createTime;

	private String hotspotconfigId;

	private String orderHistoryId;

	private short speedScore;

	private short stableScore;

	private short strengthScore;

	
}
