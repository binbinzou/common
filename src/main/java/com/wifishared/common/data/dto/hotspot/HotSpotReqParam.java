package com.wifishared.common.data.dto.hotspot;

import java.util.List;
import lombok.Data;

@Data
public class HotSpotReqParam {
	
    private List<WifiReqParam> wifiReqParam;

    private LocationReqParam locationReqParam;

	
}
