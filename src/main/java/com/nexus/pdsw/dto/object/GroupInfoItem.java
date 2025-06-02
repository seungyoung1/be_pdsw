/*------------------------------------------------------------------------------
 * NAME : GroupInfoItem.java
 * DESC : 상담사 그룹조직 개체 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/02/18  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupInfoItem {
  
  private String groupId;                 //상담사 그룹ID
  private String groupName;               //상담사 그룹명
  private List<TeamInfoItem> teamInfo;    //상담사 팀정보

  /*
   *  상담사 그룹 조직 리스트 반환 DTO 생성자
   * 
   *  @param RedisTemplate<String, Object> redisTemplate1   레디스 개체
   *  @param String baseUrl                                 기본 URL
   *  @param String sessionKey                              세션 키
   *  @param String centerId                                센터ID
   *  @param String tenantId                                테넌트ID
   *  @param JSONObject jsonObjGroup                        그룹정보
  */
  private GroupInfoItem(
    RedisTemplate<String, Object> redisTemplate1,
    String baseUrl,
    String sessionKey,
    String centerId,
    String tenantId,
    JSONObject jsonObjGroup
  ) {
    
    JSONObject jsonObjGroupData = (JSONObject) jsonObjGroup.get("Data");

    this.groupId = jsonObjGroupData.get("id").toString();
    this.groupName = jsonObjGroupData.get("name").toString();

    this.teamInfo = TeamInfoItem.getTeamList(redisTemplate1, baseUrl, sessionKey, centerId, tenantId, jsonObjGroupData.get("id").toString());
  }

  /*
   *  상담사 그룹 조직 리스트 반환 DTO로 변환하기
	 * 
   *  @param RedisTemplate<String, Object> redisTemplate1   레디스 개체
   *  @param String baseUrl                                 기본 URL
   *  @param String sessionKey                              세션 키
   *  @param String centerId                                센터ID
   *  @param String tenantId                                테넌트ID
	 *  @return List<GroupInfoItem>
	*/
  public static List<GroupInfoItem> getGroupList(
    RedisTemplate<String, Object> redisTemplate1,
    String baseUrl,
    String sessionKey,
    String centerId,
    String tenantId
  ) {
    
    List<GroupInfoItem> groupList = new ArrayList<>();

    String redisKey = "master.group-emp-" + centerId + "-" + tenantId;

    HashOperations<String, Object, Object> hashOperations = redisTemplate1.opsForHash();

    JSONParser jsonParser = new JSONParser();

    //그룹정보
    Map<Object, Object> redisGroup = hashOperations.entries(redisKey);

    JSONArray arrJsonGroup = new JSONArray();

    try {
      arrJsonGroup = (JSONArray) jsonParser.parse(redisGroup.values().toString());
    } catch (ParseException e) {
      e.printStackTrace();
    }

    for (Object jsonGroup : arrJsonGroup) {
      JSONObject jsonObjGroup = (JSONObject) jsonGroup;
      GroupInfoItem groupInfo = new GroupInfoItem(redisTemplate1, baseUrl, sessionKey, centerId, tenantId, jsonObjGroup);
      groupList.add(groupInfo);
    }

    return groupList;
  }
}
