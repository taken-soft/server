package org.takensoft.taken_soft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.takensoft.taken_soft.dto.CreateDashboardRequest;
import org.takensoft.taken_soft.dto.UpdateDashboardRequest;
import org.takensoft.taken_soft.dto.ResponseSingleDashboardDTO;
import org.takensoft.taken_soft.domain.Dashboard;
import org.takensoft.taken_soft.repository.DashBoardRepository;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private DashBoardRepository dashBoardRepository;


    /**
     * 대시보드 생성
     */
    public Dashboard createDashboard(CreateDashboardRequest createDashboardRequest) {
        /* createDashboardRequest 를 잘 분해하여 데이터베이스에 저장해주는 로직 작성 필요 */


        // 샘플 (생성된 대시보드를 리턴해줄 것. 코드 오류 안나라고 넣어둠)
        return new Dashboard();
    }

    /** 싱글 대시보드 반환 */
    public ResponseSingleDashboardDTO getSingleDashboardDTO(Integer id){
        /* DB에서 해당 대시보드 가져옴 */
        Dashboard dashboard = dashBoardRepository.getOne(id);
        /* 대시보드 -> 레이아웃 -> 레이아웃 위젯 -> 이벤트, 레이아웃_위젯_센서를 찾아 이를 전부 하나의 반환 DTO로 만들고 이를 반환해주는 로직 작성 필요 */

        // 샘플 (코드 오류 안나라고 넣어둠)
        ResponseSingleDashboardDTO singleDashboardDTO = ResponseSingleDashboardDTO.builder().build();



        return singleDashboardDTO;
    }


    /** 대시보드 이름 수정 */
    public Dashboard updateDashboardName(Integer board_id, String newDashboardTitle)
    {
        Dashboard dashboard = dashBoardRepository.getOne(board_id);
        dashboard.setDashboardTitle(newDashboardTitle);
        return dashBoardRepository.save(dashboard);
    }

    /** 대시보드 (값, 위젯 등) 업데이트 */
    public Dashboard updateDashboard(Integer board_id, UpdateDashboardRequest updateDashboardRequest)
    {
        Dashboard dashboard = dashBoardRepository.getOne(board_id);
        /* dashboardSaveDTO 안의 값을 이용해서 기존 dashboard의 값을 업데이트하는 로직 작성 필요 */

        // 샘플 ( 오류 안나라고...)
        return new Dashboard();
    }


    /** 대시보드 삭제 */
    public void deleteDashboard(Integer board_id)
    {
        /* 이거 이렇게만 두면 연관관계 때문에 삭제 안됨. 장치/센서/센서 데이터 빼고는 CASCADE 되도록 해야함 */
        dashBoardRepository.deleteById(board_id);
    }

    public List<Dashboard> getAllDashboards()
    {
        return dashBoardRepository.findAll();
    }
}

