/*------------------------------------------------------------------------------
 * NAME : CounselorStatusListItem.java
 * DESC : 상담사 상태정보 리스트 항목 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/01/18  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CounselorStatusListItem {

  private String counselorId;     //상담원 아이디
  private String counselorName;   //상담원 이름
  private String statusCode;      //상담원 로그인상태(201:LoggedOn(로그온), 202:LoggedOff(로그오프), 203:NotReady(휴식), 204:Ready(대기), 205:OtherWork(처리), 206:AfterCallWork(후처리))
  private String statusTime;      //상태유지시간
  
  /*
   *  상담사 상태정보 리스트 반환 DTO 생성자
	 * 
   *  @param Map<String, Object> mapCounselorStatus 반환할 상담사 상태정보
	*/
  private CounselorStatusListItem(
    Map<String, Object> mapCounselorStatus
  ) {

    this.counselorId = mapCounselorStatus.get("employee").toString();
    this.counselorName = mapCounselorStatus.get("name").toString();
    this.statusCode = mapCounselorStatus.get("state").toString();
    this.statusTime = mapCounselorStatus.get("state_time").toString();
  }

  /*
   *  상담사 상태정보 리스트 반환 DTO로 변환하기
	 * 
   *  @param List<Map<String, Object>> mapCounselorStatusList 반환할 상담사 상태정보 리스트
	 *  @return List<CounselorStatusListItem>
	*/
  public static List<CounselorStatusListItem> getCounselorStatusList(
    List<Map<String, Object>> mapCounselorStatusList
  ) {

    List<CounselorStatusListItem> counselorStatusList = new ArrayList<>();

    for (Map<String, Object> mapCounselorStatus : mapCounselorStatusList) {
      CounselorStatusListItem counselorInfo = new CounselorStatusListItem(mapCounselorStatus); 
      counselorStatusList.add(counselorInfo);
    }

    return counselorStatusList;
  }

}
