/*------------------------------------------------------------------------------
 * NAME : GetAvailableMenuListResponseDto.java
 * DESC : 사용가능한 메뉴 리스트 항목 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/03/18  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.response.authority;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nexus.pdsw.common.ResponseCode;
import com.nexus.pdsw.common.ResponseMessage;
import com.nexus.pdsw.dto.object.AvailableMenuItem;
import com.nexus.pdsw.dto.response.ResponseDto;
import com.nexus.pdsw.entity.MenuByRoleEntity;

import lombok.Getter;

@Getter
public class GetAvailableMenuListResponseDto extends ResponseDto {

  private List<AvailableMenuItem> availableMenuList;
  
  /*  
   *  사용가능한 메뉴 리스트 가져오기(생성자)
   *  
   *  @param List<MenuByRoleEntity> menuListByRole  반환할 메뉴 리스트
   */
  private GetAvailableMenuListResponseDto(
    List<MenuByRoleEntity> menuListByRole
  ) {
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    this.availableMenuList = AvailableMenuItem.getAvailableMenuList(menuListByRole);
  }

  /*  
   *  사용가능한 메뉴 리스트 가져오기(성공)
   *  
   *  @param List<MenuByRoleEntity> menuListByRole  반환할 메뉴 리스트
   *  @return ResponseEntity<GetAvailableMenuListResponseDto>
   */
  public static ResponseEntity<GetAvailableMenuListResponseDto> success(
    List<MenuByRoleEntity> menuListByRole
  ) {

    GetAvailableMenuListResponseDto result = new GetAvailableMenuListResponseDto(menuListByRole);
    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  /*  
   *  사용가능한 메뉴 리스트 가져오기(존재하지 않는 역할)
   *  
	 * @return ResponseEntity<ResponseDto>
   */
    public static ResponseEntity<ResponseDto> notExistRole() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_ROLE, ResponseMessage.NOT_EXISTED_ROLE);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

  /*  
   *  사용가능한 메뉴 리스트 가져오기(존재하지 않는 메뉴)
   *  
	 * @return ResponseEntity<ResponseDto>
   */
  public static ResponseEntity<ResponseDto> notExistMenu() {
    ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_MENU, ResponseMessage.NOT_EXISTED_MENU);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
  }
}
