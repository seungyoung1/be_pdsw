/*------------------------------------------------------------------------------
 * NAME : GetProcessStatusInfoResponseDto.java
 * DESC : 타 시스템 프로세스 상태정보 가져오기 항목 DTO
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
package com.nexus.pdsw.dto.response.monitor;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nexus.pdsw.common.ResponseCode;
import com.nexus.pdsw.common.ResponseMessage;
import com.nexus.pdsw.dto.object.ProcessStatusItem;
import com.nexus.pdsw.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class GetProcessStatusInfoResponseDto extends ResponseDto {
  
  private List<ProcessStatusItem> processStatusList;

  /*  
   *  타 시스템 프로세스 상태정보 가져오기(생성자)
   *  
   *  @param List<Map<String, Object>> mapMonitorProcessList  프로세스 상태정보 리스트
   */
  private GetProcessStatusInfoResponseDto(
    List<Map<String, Object>> mapMonitorProcessList
  ) {
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    this.processStatusList = ProcessStatusItem.getProcessStatusItemList(mapMonitorProcessList);
  }

  /*  
   *  타 시스템 프로세스 상태정보 가져오기(성공)
   *  
   *  @param List<Map<String, Object>> mapMonitorProcessList  프로세스 상태정보 리스트
   *  @return ResponseEntity<GetProcessStatusInfoResponseDto>
   */
  public static ResponseEntity<GetProcessStatusInfoResponseDto> success(
    List<Map<String, Object>> mapMonitorProcessList
  ) {
    GetProcessStatusInfoResponseDto result = new GetProcessStatusInfoResponseDto(mapMonitorProcessList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

}
