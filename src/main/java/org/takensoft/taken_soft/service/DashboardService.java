package org.takensoft.taken_soft.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.takensoft.taken_soft.domain.*;
import org.takensoft.taken_soft.dto.*;
import org.takensoft.taken_soft.dto.property.LayoutWidgetProperty;
import org.takensoft.taken_soft.dto.request.CreateDashboardRequest;
import org.takensoft.taken_soft.dto.request.UpdateDashboardRequest;
import org.takensoft.taken_soft.dto.response.CreateDashboardResponse;
import org.takensoft.taken_soft.dto.response.SingleDashboardResponse;
import org.takensoft.taken_soft.repository.*;

import java.io.IOException;
import java.util.*;

@Slf4j
@Service
public class DashboardService {

    @Autowired
    private DashBoardRepository dashBoardRepository;

    @Autowired
    private LayoutRepository layoutRepository;




    /** 초기 대시보드 및 레이아웃 생성 */
    public CreateDashboardResponse createDashboard(CreateDashboardRequest createDashboardRequest) {
        /* createDashboardRequest 를 잘 분해하여 데이터베이스에 저장해주는 로직 작성 필요 */
        // 대시보드 타입
        String dashboardType = createDashboardRequest.getDashboardType();
        // 대시보드 순서
        Integer dashboardSequence = createDashboardRequest.getDashboardSequence();
        // 새로운 대시보드 생성
        Dashboard newDashboard = new Dashboard();
        newDashboard.setDashboardTitle("New Dashboard");
        newDashboard.setDashboardType(dashboardType);
        newDashboard.setDashboardSequence(dashboardSequence);

        // 대시보드 저장
        dashBoardRepository.save(newDashboard);

        // 레이아웃 생성
        int numLayouts=0;

        if (dashboardType.equals("2x2")) {
            numLayouts = 4;
        } else if (dashboardType.equals("2x4")) {
            numLayouts = 8;
        }
        // 레이아웃 저장 및 LayoutDTO 저장
        List<LayoutDto> layoutDtoList = new ArrayList<>();
        for (int i = 1; i <= numLayouts; i++) {
            Layout newLayout = new Layout();
            newLayout.setLayoutSequence(i);
            newLayout.setDashboard(newDashboard);
            layoutRepository.save(newLayout);

            LayoutDto newLayoutDto = new LayoutDto();
            newLayoutDto.setId(newLayout.getId());
            newLayoutDto.setLayoutSequence(newLayout.getLayoutSequence());
            layoutDtoList.add(newLayoutDto);

        }

        // CreateDashboardResponse 반환
        CreateDashboardResponse CDR = new CreateDashboardResponse();
        CDR.setDashboardId(newDashboard.getId());
        CDR.setLayoutDtos(layoutDtoList);
        return CDR;
    }

    /** 싱글 대시보드 반환 */
    public SingleDashboardResponse getSingleDashboardDTO(Integer board_id){
        /* DB에서 해당 대시보드 가져옴 */
        Dashboard dashboard = dashBoardRepository.findById(board_id).orElseThrow();
        /* 대시보드 -> 레이아웃 -> 레이아웃 위젯 -> 이벤트, 레이아웃_위젯_센서를 찾아 이를 전부 하나의 반환 DTO로 만들고 이를 반환해주는 로직 작성 필요 */

        // 샘플 (코드 오류 안나라고 넣어둠)
        SingleDashboardResponse singleDashboardDTO = SingleDashboardResponse.builder().build();



        return singleDashboardDTO;
    }


    /** 대시보드 이름 수정 */
    public Dashboard updateDashboardName(Integer board_id, String newDashboardTitle)
    {
        Dashboard dashboard = dashBoardRepository.findById(board_id).orElseThrow();
        dashboard.setDashboardTitle(newDashboardTitle);
        return dashBoardRepository.save(dashboard);
    }

    /** 대시보드 (값, 위젯 등) 업데이트 */
    public Dashboard updateDashboard(Integer board_id, UpdateDashboardRequest updateDashboardRequest)
    {
        Dashboard dashboard = dashBoardRepository.findById(board_id).orElseThrow();
        /* dashboardSaveDTO 안의 값을 이용해서 기존 dashboard의 값을 업데이트하는 로직 작성 필요 */

        // 샘플 ( 오류 안나라고...)
        return new Dashboard();
    }

    /** 대시보드 삭제 - 완료 */
    public void deleteDashboard(Integer dashboardId) {
        dashBoardRepository.deleteById(dashboardId);
    }


    /** 대시보드와 관련된 layout ~ event 까지 삭제 - 대시보드는 삭제되지 않음 */
    public void deleteLayoutsByDashboardId(Integer dashboardId) {
        Dashboard dashboard = dashBoardRepository.findById(dashboardId).orElseThrow();
        Set<Layout> layouts = dashboard.getLayouts();

        for (Layout layout : layouts) {
            Integer layout_id = layout.getId();
            log.info("레이아웃 아이디 : {}", layout_id);
            layoutRepository.deleteById(layout_id); // 레이아웃 삭제 (cascade에 의해 연관된 엔티티들도 자동으로 삭제됨)
        }
        layoutRepository.flush(); // 영속성 컨텍스트를 플러시하여 변경 사항을 데이터베이스에 즉시 반영
    }


    public List<Dashboard> getAllDashboards()
    {
        return dashBoardRepository.findAll();
    }

}

