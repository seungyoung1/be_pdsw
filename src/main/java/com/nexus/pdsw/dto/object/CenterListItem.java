/*------------------------------------------------------------------------------
 * NAME : CenterListItem.java
 * DESC : 센터정보리스트 개체 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/05/23  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.object;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CenterListItem {
  
  private String centerId;                    //센터 ID
  private String centerName;                  //센터 명

  /*
   *  센터정보 리스트 반환 DTO 생성자
   * 
   *  @param JSONObject jsonObjCenter                       센터 정보
  */
  private CenterListItem(
    JSONObject jsonObjCenter
  ) {

    JSONObject jsonObjCentereData = (JSONObject) jsonObjCenter.get("Data");

    this.centerId = jsonObjCentereData.get("center_id").toString();
    this.centerName = jsonObjCentereData.get("name").toString();
  }

  /*
   *  센터정보 리스트 반환 DTO로 변환하기
	 * 
   *  @param JSONArray arrJsonCenter                        센터 정보
	 *  @return List<CenterListItem>
	*/
  public static List<CenterListItem> getCenterInfoList(JSONArray arrJsonCenter) {

    List<CenterListItem> centerInfoList = new ArrayList<>();

    for (Object jsonCenter : arrJsonCenter) {
      JSONObject jsonObjCenter = (JSONObject) jsonCenter;
      CenterListItem centerInfo = new CenterListItem(jsonObjCenter);
      centerInfoList.add(centerInfo);
    }

    return centerInfoList;
  }

}
