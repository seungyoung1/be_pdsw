/*------------------------------------------------------------------------------
 * NAME : PostCounselorStatusListResponseDto.java
 * DESC : 상담사 상태정보 리스트 항목 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2025 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/01/18  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.response.counselor;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nexus.pdsw.common.ResponseCode;
import com.nexus.pdsw.common.ResponseMessage;
import com.nexus.pdsw.dto.object.CounselorStatusListItem;
import com.nexus.pdsw.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class PostCounselorStatusListResponseDto extends ResponseDto {
  
  List<CounselorStatusListItem> counselorStatusList;
  
  /*  
   *  상담사 상태정보 리스트 가져오기(생성자)
   *  
   *  @param List<Map<String, String>> mapCounselorInfoList 반환할 상담사 리스트
   */
  private PostCounselorStatusListResponseDto(
    List<Map<String, Object>> mapCounselorStatusList
  ){

    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    this.counselorStatusList = CounselorStatusListItem.getCounselorStatusList(mapCounselorStatusList);
  }

  /*  
   *  상담사 상태정보 리스트 가져오기(성공)
   *  
   *  @param List<Map<String, String>> mapCounselorStatusList 반환할 상담사 상태 리스트
   *  @return ResponseEntity<PostCounselorStatusListResponseDto>
   */
  public static ResponseEntity<PostCounselorStatusListResponseDto> success(
    List<Map<String, Object>> mapCounselorStatusList
  ) {
    PostCounselorStatusListResponseDto result = new PostCounselorStatusListResponseDto(mapCounselorStatusList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  /*  
   *  상담사 상태정보 리스트 가져오기(테넌트ID가 없을 경우)
   *  
   *  @return ResponseEntity<ResponseDto>
   */
  public static ResponseEntity<ResponseDto> notExistTenantId() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_TENANTID, ResponseMessage.NOT_EXISTED_TENANTID);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  /*  
   *  상담사 상태정보 리스트 가져오기(캠페인ID가 존재하지 않을 경우)
   *  
   *  @return ResponseEntity<ResponseDto>
   */
  public static ResponseEntity<ResponseDto> notExistCampaignId() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_CAMPAIGNID, ResponseMessage.NOT_EXISTED_CAMPAIGNID);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  /*  
   *  상담사 상태정보 리스트 가져오기(API 인증 세션키가 없을 경우)
   *  
   *  @return ResponseEntity<ResponseDto>
   */
  public static ResponseEntity<ResponseDto> notExistSessionKey() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_SESSIONKEY, ResponseMessage.NOT_EXISTED_SESSIONKEY);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }  
}
