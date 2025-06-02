/*------------------------------------------------------------------------------
 * NAME : DialerChannelStatusItem.java
 * DESC : Redis 9번방의 장비별 채널할당 상태 정보 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/01/31  최상원                       초기작성
 * 2025/03/28  최상원                       DeviceId 추가
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
public class DialerChannelStatusItem {
  
  private String deviceId;
  private String id;
  private String state;
  private String event;
  private String assign_kind;
  private String campaign_id;
  private String dial_mode;
  private String dial_sequence;

  /*
   *  Redis 9번방의 장비별 채널할당 상태 정보 DTO 생성자
	 * 
   *  @param Map<String, Object> mapMonitorProcess  타 시스템 프로세스 상태정보
	*/
  private DialerChannelStatusItem(
    Map<String, Object> mapDialerChannelStatus
  ) {
    // log.info(">>>반환 값: {}", mapDialerChannelStatus.toString());
    this.deviceId = mapDialerChannelStatus.get("deviceId").toString();
    this.id = mapDialerChannelStatus.get("id").toString();
    this.state = mapDialerChannelStatus.get("state").toString();
    this.event = mapDialerChannelStatus.get("event").toString();
    this.assign_kind = mapDialerChannelStatus.get("assign_kind").toString();
    this.campaign_id = mapDialerChannelStatus.get("campaign_id").toString();
    this.dial_mode = mapDialerChannelStatus.get("dial_mode").toString();
    this.dial_sequence = mapDialerChannelStatus.get("dial_sequence").toString();
  }

  /*
   *  Redis 9번방의 장비별 채널할당 상태 정보 DTO로 변환하기
	 * 
   *  @param List<Map<String, String>> mapMonitorProcessList  프로세스 상태정보 리스트
	 *  @return List<ProcessStatusItem>
	*/
  public static List<DialerChannelStatusItem> getDialerChannelStatusList(
    List<Map<String, Object>> mapDialerChannelStatusList
  ) {
    List<DialerChannelStatusItem> dialerChannelStatusList = new ArrayList<>();

    for(Map<String, Object> mapDialerChannelStatus : mapDialerChannelStatusList) {
      DialerChannelStatusItem processStatusItem = new DialerChannelStatusItem(mapDialerChannelStatus);
      dialerChannelStatusList.add(processStatusItem);
    }

    return dialerChannelStatusList;
  }

}
