/*------------------------------------------------------------------------------
 * NAME : ProcessStatusItem.java
 * DESC : Redis 9번방의 타 시스템 프로세스 상태정보 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/01/31  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProcessStatusItem {
  private String name;
  private long pid = 0L;
  private int state = 0;
  private String time;

  /*
   *  Redis 9번방의 타 시스템 프로세스 상태정보 DTO 생성자
	 * 
   *  @param Map<String, Object> mapMonitorProcess  타 시스템 프로세스 상태정보
	*/
  private ProcessStatusItem(
    Map<String, Object> mapMonitorProcess
  ) {
    this.name = mapMonitorProcess.get("name").toString();
    this.pid = (long) (int) mapMonitorProcess.get("pid");
    this.state = (int) mapMonitorProcess.get("state");
    this.time = mapMonitorProcess.get("time").toString();
  }

  /*
   *  Redis 9번방의 타 시스템 프로세스 상태정보 DTO로 변환하기
	 * 
   *  @param List<Map<String, String>> mapMonitorProcessList  프로세스 상태정보 리스트
	 *  @return List<ProcessStatusItem>
	*/
  public static List<ProcessStatusItem> getProcessStatusItemList(
    List<Map<String, Object>> mapMonitorProcessList
  ) {
    List<ProcessStatusItem> processStatusItemList = new ArrayList<>();

    for(Map<String, Object> mapMonitorProcess : mapMonitorProcessList) {
      ProcessStatusItem processStatusItem = new ProcessStatusItem(mapMonitorProcess);
      processStatusItemList.add(processStatusItem);
    }

    return processStatusItemList;
  }
}
