/*------------------------------------------------------------------------------
 * NAME : PostDialerChannelStatusInfoResponseDto.java
 * DESC : 장비별 채널 할당 상태정보 가져오기 항목 DTO
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
import com.nexus.pdsw.dto.object.DialerChannelStatusItem;
import com.nexus.pdsw.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class PostDialerChannelStatusInfoResponseDto extends ResponseDto {

  List<DialerChannelStatusItem> dialerChannelStatusList;
  
  /*  
   *  장비별 채널 할당 상태정보 가져오기(생성자)
   *  
   *  @param List<Map<String, Object>> mapDialerChannelStatusList  장비별 채널할당 상태정보 리스트
   */

  public PostDialerChannelStatusInfoResponseDto(
    List<Map<String, Object>> mapDialerChannelStatusList
  ) {
      super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
      this.dialerChannelStatusList = DialerChannelStatusItem.getDialerChannelStatusList(mapDialerChannelStatusList);
  }
  
  /*  
   *  장비별 채널 할당 상태정보 가져오기(성공)
   *  
   *  @param List<Map<String, Object>> mapDialerChannelStatusList  장비별 채널할당 상태정보 리스트
   *  @return ResponseEntity<GetDialerChannelStatusInfoResponseDto>
   */
  public static ResponseEntity<PostDialerChannelStatusInfoResponseDto> success(
    List<Map<String, Object>> mapDialerChannelStatusList
  ) {
    PostDialerChannelStatusInfoResponseDto result = new PostDialerChannelStatusInfoResponseDto(mapDialerChannelStatusList);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  /*  
   *  장비별 채널 할당 상태정보 가져오기(장비가 존재하지 않음)
   *  
   *  @return ResponseEntity<GetDialerChannelStatusInfoResponseDto>
   */
  public static ResponseEntity<ResponseDto> notExistDialerDevice() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_DIALER, ResponseMessage.NOT_EXISTED_DIALER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }

  /*  
   *  장비별 채널 할당 상태정보 가져오기(API 인증 세션키가 없을 경우)
   *  
   *  @return ResponseEntity<GetDialerChannelStatusInfoResponseDto>
   */
  public static ResponseEntity<ResponseDto> notExistSessionKey() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_SESSIONKEY, ResponseMessage.NOT_EXISTED_SESSIONKEY);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}
