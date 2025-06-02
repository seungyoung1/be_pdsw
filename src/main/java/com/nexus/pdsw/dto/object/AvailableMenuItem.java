/*------------------------------------------------------------------------------
 * NAME : AvailableMenuItem.java
 * DESC : 사용가능 메뉴 항목 DTO
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
package com.nexus.pdsw.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.nexus.pdsw.entity.MenuByRoleEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableMenuItem {

  private int menuId;
  private int upperMenuId;
  private String menuName;
  private String locationDistinctionCode;
  private String connectionType;
  private String connectionScreenId;
  
	/*
   * 생성자
	 * 
	 * @param MenuByRoleEntity menuByRole
	*/
  public AvailableMenuItem(
    MenuByRoleEntity menuByRole
  ) {
    this.menuId = menuByRole.getMenu().getMenuId();
    if (menuByRole.getMenu().getUpperMenuId() == null) {
      this.upperMenuId = 0;
    } else {
      this.upperMenuId = menuByRole.getMenu().getUpperMenuId();
    }
    this.menuName = menuByRole.getMenu().getMenuName();
    this.locationDistinctionCode = menuByRole.getMenu().getLocationDistinctionCode();
    this.connectionType = menuByRole.getMenu().getConnectionType();
    this.connectionScreenId = menuByRole.getMenu().getConnectionScreenId();
  }

  /*
   * 역할별 메뉴 리스트 가져오기
	 * 
	 * @param       List<MenuByRoleEntity> menuListByRole
	 * @return      List<AvailableMenuItem> availableMenuList
	*/
  public static List<AvailableMenuItem> getAvailableMenuList(
    List<MenuByRoleEntity> menuListByRole
  ) {

    List<AvailableMenuItem> availableMenuList = new ArrayList<>();

    for(MenuByRoleEntity menuByRole : menuListByRole) {
      AvailableMenuItem availableMenuItem = new AvailableMenuItem(menuByRole);
      availableMenuList.add(availableMenuItem);
    }

    return availableMenuList;

  }
}
