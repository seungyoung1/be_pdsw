/*------------------------------------------------------------------------------
 * NAME : ProgressInfoItem.java
 * DESC : Redis 9번방의 캠페인 별 진행상태정보 DTO
 * VER  : V1.0
 * PROJ : 웹 기반 PDS 구축 프로젝트
 * Copyright 2024 Dootawiz All rights reserved
 *------------------------------------------------------------------------------
 *                               MODIFICATION LOG
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                       DESCRIPTION
 * ----------  ------  -----------------------------------------------------------
 * 2025/02/03  최상원                       초기작성
 *------------------------------------------------------------------------------*/
package com.nexus.pdsw.dto.object;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProgressInfoItem {

  private int TenantId;                   //테넌트ID
  private int CampId;                     //캠페인ID
  private int ReuseCnt;                   //캠페인 재사용 회수 : 1(최초발신), 2~(재발신)
  private int TotLstCnt;                  //총 리스트 건수
  private int TotDialCnt;                 //총 발신 건수
  private int NonTTCT;                    //순수 발신 건수
  private int SCCT;                       //발신 성공 건수
  private int BUCT;                       //통화 중 실패 건수
  private int NACT;                       //무응답 실패 건수
  private int FACT;                       //팩스/모뎀 실패 건수
  private int ACCT;                       //기계음 실패 건수
  private int ETCT;                       //기타 실패 건수
  private int TECT;                       //전화번호 오류 건수
  private int LineStopCnt;                //다이얼 실패 건수
  private int CustomerOnHookCnt;          //고객이 바로 끊은 건수
  private int DetectSilenceCnt;           //10초 동안 묵음 지속
  private int DialToneSilence;            //다이얼 톤이 안 들림
  private int AgentConnect;               //상담사 연결
  private int OverDial;                   //Over Dial
  private int ABCT;                       //포기 분배 실패
  private int AgentNoAnswerCnt;           //상담사 무응답
  private int AgentBusyCnt;               //상담사 통화 중
  private int AgentDropCnt;               //상담사 바로 끊음
  private int CustomerDropCnt;            //고객 포기
  private int NonServiceCnt;              //고객 최대시간 초과
  private int NoAgentCnt;                 //멘트 청취 후 상담사 미연결
  private String CampListQuery;           //List Query
  private int BlackList;                  //통화방지 리스트
  private int DeleteAfterDial;            //발신 후 삭제
  private int DeleteBeforeDial;           //미발신 삭제
  private int FirstCall;                  //최초 시도 콜(현재 버퍼에 남은 Call 중 최초시도 할 Call수)
  private int RetryCall;                  //재시도 콜(현재 버퍼에 남은 Call 중 재시도 할 Call수)
  private int RecallCnt;                  //예약 리스트(현재 남은 Call 중 남은 예약 Call수)
  private int TimeoutRecall;              //타임아웃 콜(시간이 지나서 발신하지 않은 예약 호)
  private int DialingCall;                //발신 중인 콜
  private int BlackListCall;              //통화방지 콜
  private int FileIndex;
  private int NOGDeleteGL;                //미발신 사유 코드 실시간 발신방지 건수
  private int NOGAddBL;                   //미발신 사유 코드 실시간 블랙리스트 추가
  private int NOGTimeOutCallback;         //미발신 사유 코드 콜백 Time over
  private int NOGTimeContradictory;       //미발신 사유 코드 발신방지, 예약시간 잘못 설정
  private int NOGBlockTime;               //미발신 사유 코드 발신방지 시각
  private int NOGNotDialReady;            //미발신 사유 코드 지정상담원이 Ready가 아닐 때
  private int NOGNotDialAgent;            //미발신 사유 코드 지정상담원이 Dial이 아닐 때
  private int NOGAutoPopNotDial;          //미발신 사유 코드 Autopreview시 Popup 수신후, 상담원 미발신 선택
  private int NOGAutoPopNoAnswer;         //미발신 사유 코드 Autopreview시 Popup 수신후, 발신여부 선택 안함
  private int NOGAutoPopNoReady;          //미발신 사유 코드 Autopreview시 Popup 수신후, 상담원 상태 변경
  private int NOGAutoPopFailMode;         //미발신 사유 코드 Autopreview시 Popup 수신후, 상담원 모드 변경
  private int NOGAutoDialNoReady;         //미발신 사유 코드 Autopreview시 CIDS->CIOD 발신 여부 확인전, 상담원 상태변경
  private int NOGAutoDialFailMode;        //미발신 사유 코드 Autopreview시 CIDS->CIOD 발신 여부 확인전, 상담원 모드변경
  private int NOGAutoNoEmployeeId;        //미발신 사유 코드 SystemPreview시 발신리스트에 상담원 이름이 입력되지 않음
  private int DetectMachineLineBusy;      //소리샘-통화중
  private int DetectMachineNoanswer;      //소리샘-무응답
  private int DetectMachinePowerOff;      //소리샘-전원꺼짐
  private int DetectMachineRoaming;       //해외로밍
  private int DetectMachineMissingNumber; //결번
  private int DetectMachineEtc;           //기타 기계음

  /*
   *  Redis 9번방의 캠페인별 진행정보 DTO(생성자)
	 * 
   *  @param Map<String, Object> mapProgressInfo  캠페인별 진행정보
	*/
  private ProgressInfoItem(
    Map<String, Object> mapProgressInfo
  ) {
    
    this.TenantId = (int) mapProgressInfo.get("TenantId");
    this.CampId = (int) mapProgressInfo.get("CampId");
    if (mapProgressInfo.get("ReuseCnt") == null) {
      this.ReuseCnt = 0;
    } else {
      this.ReuseCnt = (int) mapProgressInfo.get("ReuseCnt");
    }
    this.TotLstCnt = (int) mapProgressInfo.get("TotLstCnt");
    this.TotDialCnt = (int) mapProgressInfo.get("TotDialCnt");
    this.NonTTCT = (int) mapProgressInfo.get("NonTTCT");
    this.SCCT = (int) mapProgressInfo.get("SCCT");
    this.BUCT = (int) mapProgressInfo.get("BUCT");
    this.NACT = (int) mapProgressInfo.get("NACT");
    this.FACT = (int) mapProgressInfo.get("FACT");
    this.ACCT = (int) mapProgressInfo.get("ACCT");
    this.ETCT = (int) mapProgressInfo.get("ETCT");
    this.TECT = (int) mapProgressInfo.get("TECT");
    this.LineStopCnt = (int) mapProgressInfo.get("LineStopCnt");
    this.CustomerOnHookCnt = (int) mapProgressInfo.get("CustomerOnHookCnt");
    this.DetectSilenceCnt = (int) mapProgressInfo.get("DetectSilenceCnt");
    this.DialToneSilence = (int) mapProgressInfo.get("DialToneSilence");
    this.AgentConnect = (int) mapProgressInfo.get("AgentConnect");
    this.OverDial = (int) mapProgressInfo.get("OverDial");
    this.ABCT = (int) mapProgressInfo.get("ABCT");
    this.AgentNoAnswerCnt = (int) mapProgressInfo.get("AgentNoAnswerCnt");
    this.AgentBusyCnt = (int) mapProgressInfo.get("AgentBusyCnt");
    this.AgentDropCnt = (int) mapProgressInfo.get("AgentDropCnt");
    this.CustomerDropCnt = (int) mapProgressInfo.get("CustomerDropCnt");
    this.NonServiceCnt = (int) mapProgressInfo.get("NonServiceCnt");
    this.NoAgentCnt = (int) mapProgressInfo.get("NoAgentCnt");
    this.CampListQuery = mapProgressInfo.get("CampListQuery").toString();
    this.BlackList = (int) mapProgressInfo.get("BlackList");
    this.DeleteAfterDial = (int) mapProgressInfo.get("DeleteAfterDial");
    this.DeleteBeforeDial = (int) mapProgressInfo.get("DeleteBeforeDial");
    this.FirstCall = (int) mapProgressInfo.get("FirstCall");
    this.RetryCall = (int) mapProgressInfo.get("RetryCall");
    this.RecallCnt = (int) mapProgressInfo.get("RecallCnt");
    this.TimeoutRecall = (int) mapProgressInfo.get("TimeoutRecall");
    this.DialingCall = (int) mapProgressInfo.get("DialingCall");
    this.BlackListCall = (int) mapProgressInfo.get("BlackListCall");
    this.FileIndex = (int) mapProgressInfo.get("FileIndex");
    this.NOGDeleteGL = (int) mapProgressInfo.get("NOGDeleteGL");    
    this.NOGAddBL = (int) mapProgressInfo.get("NOGAddBL");
    this.NOGTimeOutCallback = (int) mapProgressInfo.get("NOGTimeOutCallback");
    this.NOGTimeContradictory = (int) mapProgressInfo.get("NOGTimeContradictory");
    this.NOGBlockTime = (int) mapProgressInfo.get("NOGBlockTime");
    this.NOGNotDialReady = (int) mapProgressInfo.get("NOGNotDialReady");
    this.NOGNotDialAgent = (int) mapProgressInfo.get("NOGNotDialAgent");
    this.NOGAutoPopNotDial = (int) mapProgressInfo.get("NOGAutoPopNotDial");
    this.NOGAutoPopNoAnswer = (int) mapProgressInfo.get("NOGAutoPopNoAnswer");
    this.NOGAutoPopNoReady = (int) mapProgressInfo.get("NOGAutoPopNoReady");
    this.NOGAutoPopFailMode = (int) mapProgressInfo.get("NOGAutoPopFailMode");
    this.NOGAutoDialNoReady = (int) mapProgressInfo.get("NOGAutoDialNoReady");
    this.NOGAutoDialFailMode = (int) mapProgressInfo.get("NOGAutoDialFailMode");
    this.NOGAutoNoEmployeeId = (int) mapProgressInfo.get("NOGAutoNoEmployeeId");
    this.DetectMachineLineBusy = (int) mapProgressInfo.get("DetectMachineLineBusy");
    this.DetectMachineNoanswer = (int) mapProgressInfo.get("DetectMachineNoanswer");
    this.DetectMachinePowerOff = (int) mapProgressInfo.get("DetectMachinePowerOff");
    this.DetectMachineRoaming = (int) mapProgressInfo.get("DetectMachineRoaming");
    this.DetectMachineMissingNumber = (int) mapProgressInfo.get("DetectMachineMissingNumber");
    this.DetectMachineEtc = (int) mapProgressInfo.get("DetectMachineEtc");

  }

  /*
   *  Redis 9번방의 캠페인별 진행정보 DTO로 변환하기
	 * 
   *  @param List<Map<String, String>> mapProgressInfoList  캠페인별 진행정보 리스트
	 *  @return List<ProgressInfoItem>
	*/
  public static List<ProgressInfoItem> getProgressInfo(
    List<Map<String, Object>> mapProgressInfoList
  ) {

    List<ProgressInfoItem> progressInfoList = new ArrayList<>();

    for(Map<String, Object> mapProgressInfo : mapProgressInfoList) {
      ProgressInfoItem progressInfoItem = new ProgressInfoItem(mapProgressInfo);
      progressInfoList.add(progressInfoItem);
    }

    return progressInfoList;
  }
}
