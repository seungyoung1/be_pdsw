/*------------------------------------------------------------------------------
 * NAME : CounselorAffiliation.java
 * DESC : 상담사 소속부서 정보 항목 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/01/15  최상원                       초기작성
 * 2025/01/21  최상원                       부서명 추가
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CounselorAffiliation {
  private String affiliationDepth;          //소속 Depth
  private String affiliatedDepartmentId;    //소속 부서 아이디
  private String affiliatedDepartmentName;  //소속 부서 명

  /*
   *  상담사 소속부서리스트 반환 DTO 생성자
	 * 
   *  @param String key                   부서 Depth
   *  @param Object value                 부서 ID
   *  @param String affiliationGroupName  부서(그룹)명
   *  @param String affiliationTeamName   부서(팀)명
   *  @param String tanantId              테넌트ID
	*/
  private CounselorAffiliation (
    String key,
    Object value,
    String affiliationGroupName,
    String affiliationTeamName,
    String tanantId
  ) {
    this.affiliationDepth = key;
    this.affiliatedDepartmentId = value.toString();

    if (key.equals("1")) {
      this.affiliatedDepartmentName = affiliationGroupName;
    } else {
      this.affiliatedDepartmentName = affiliationTeamName;
    }
  }

  /*
   *  상담사 소속 부서정보 반환 DTO로 변환하기
	 * 
   *  @param Map<String, Object> mapCounselorAffiliation  반환할 상담사 소속 정보 Map
   *  @param String affiliationGroupName                  부서(그룹)명
   *  @param String affiliationTeamName                   부서(팀)명
   *  @param String tanantId                              테넌트ID
	 *  @return List<CounselorAffiliation>
	*/
  public static List<CounselorAffiliation> getCounselorAffiliationList(
    Map<String, Object> mapCounselorAffiliation,
    String affiliationGroupName,
    String affiliationTeamName,
    String tanantId
  ) {
    
    List<CounselorAffiliation> counselorAffiliationList = new ArrayList<>();

    mapCounselorAffiliation.forEach((key, value) -> {
      CounselorAffiliation counselorAffiliation = new CounselorAffiliation(key, value, affiliationGroupName, affiliationTeamName, tanantId);
      counselorAffiliationList.add(counselorAffiliation);
    });

    return counselorAffiliationList;
  }
}
