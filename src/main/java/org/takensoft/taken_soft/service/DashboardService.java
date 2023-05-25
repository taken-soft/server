package org.takensoft.taken_soft.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.takensoft.taken_soft.domain.*;
import org.takensoft.taken_soft.dto.*;
import org.takensoft.taken_soft.dto.request.CreateDashboardRequest;
import org.takensoft.taken_soft.dto.request.UpdateDashboardRequest;
import org.takensoft.taken_soft.dto.response.CreateDashboardResponse;
import org.takensoft.taken_soft.dto.response.SingleDashboardResponse;
import org.takensoft.taken_soft.repository.*;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class DashboardService {
    private final WidgetRepository widgetRepository;
    private final LayoutWidgetRepository layoutWidgetRepository;
    private final SensorRepository sensorRepository;
    
    private final DashBoardRepository dashBoardRepository;
    private final LayoutRepository layoutRepository;

    /** 초기 대시보드 및 레이아웃 생성 */
    public CreateDashboardResponse createDashboard(CreateDashboardRequest createDashboardRequest) {
        log.info(String.valueOf(createDashboardRequest));
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
            newLayoutDto.setLayoutId(newLayout.getId());
            newLayoutDto.setLayoutSequence(newLayout.getLayoutSequence());
            layoutDtoList.add(newLayoutDto);

        }

        // CreateDashboardResponse 반환

        return new CreateDashboardResponse(newDashboard.getId(),layoutDtoList);
    }

    /** 싱글 대시보드 반환 */
    public SingleDashboardResponse getSingleDashboardDTO(Integer board_id){
        /* DB에서 해당 대시보드 가져옴 */
        Dashboard dashboard = dashBoardRepository.findById(board_id).orElseThrow(RuntimeException::new);
        
        Set<Layout> layouts = dashboard.getLayouts();//db에서 가져온 layout들
        log.info("레이아웃 : {}",layouts.toString());
        List<LayoutDto> layoutDtoList=new ArrayList<>();//layout들을 담을 dto
        for (Layout layout: layouts) {
            Set<LayoutWidget> layoutWidgets = layout.getLayoutWidgets();//db에서 가져온 layout widget들

            List<LayoutWidgetDto> layoutWidgetDtoList=new ArrayList<>();//layout widget들을 담을 dto
            for (LayoutWidget layoutWidget:layoutWidgets) {
                Set<LayoutWidgetSensor> layoutWidgetSensors = layoutWidget.getLayoutWidgetSensors();//db에서 가져온 layout widget sensor들
                List<LayoutWidgetSensorDto> layoutWidgetSensorDtoList=new ArrayList<>();// layout widget sensor들을 담을 dto
                for (LayoutWidgetSensor layoutWidgetSensor:layoutWidgetSensors) {
                    LayoutWidgetSensorDto layoutWidgetSensorDto = LayoutWidgetSensorDto.of(layoutWidgetSensor);
                    log.info("layoutWidgetSensorDto : {}", layoutWidgetSensorDto.toString());
                    layoutWidgetSensorDtoList.add(layoutWidgetSensorDto);//dto를 생성 및  layout widget sensor dto에 저장
                }
                Set<Event> events = layoutWidget.getEvents();//db에서 가져온 event들
                List<EventDto> eventDtoList=new ArrayList<>();//event들을 담을 dto
                for (Event event:events) {
                    EventDto eventDto = EventDto.of(event);
                    log.info("eventDto : {}", eventDto.toString());
                    eventDtoList.add(eventDto) ;//event들을 dto로 전환 후 event dto에 저장
                }
                
                layoutWidgetDtoList.add(LayoutWidgetDto.of(layoutWidget,eventDtoList,layoutWidgetSensorDtoList)) ;
            }
            layoutDtoList.add(LayoutDto.of(layout,layoutWidgetDtoList));
        }
        
        return new SingleDashboardResponse(dashboard, layoutDtoList);
    }


    /** 대시보드 이름 수정 */
    public Dashboard updateDashboardName(Integer board_id, String newDashboardTitle)
    {
        Dashboard dashboard = dashBoardRepository.findById(board_id).orElseThrow();
        dashboard.setDashboardTitle(newDashboardTitle);
        return dashBoardRepository.save(dashboard);
    }

    /** 대시보드 (값, 위젯 등) 업데이트 */
    public void updateDashboard(UpdateDashboardRequest updateDashboardRequest) throws NullPointerException{
        Dashboard dashboard = dashBoardRepository.findById(updateDashboardRequest.getDashboardId()).orElse(null);//대시보드&레이아웃까지만 생성됨
//        Set<Layout> layouts = Objects.requireNonNull(dashboard).getLayouts();
        deleteLayoutsByDashboardId(updateDashboardRequest.getDashboardId());
        Set<Layout> layouts= Objects.requireNonNull(dashboard).getLayouts();
        List<LayoutDto> layoutDtoList = updateDashboardRequest.getLayoutDtoList();
        for (LayoutDto layoutDto:layoutDtoList) {
            Set<LayoutWidget> layoutWidgets=new HashSet<>();
            
            Layout layout = new Layout();
            Objects.requireNonNull(layout).setDashboard(dashboard);
            layout.setLayoutSequence(layoutDto.getLayoutSequence());
            List<LayoutWidgetDto> layoutWidgetDtoList = layoutDto.getLayoutWidgetDtoList();
            for (LayoutWidgetDto layoutWidgetDto : layoutWidgetDtoList) {
                Set<Event> events=new HashSet<>();
                Widget widget = widgetRepository.findById(layoutWidgetDto.getWidgetId()).orElse(null);
                LayoutWidget layoutWidget=LayoutWidget.ofDto(layoutWidgetDto,widget,layout);
                List<EventDto> eventDtoList = layoutWidgetDto.getEventDtoList();
                for (EventDto eventDto: eventDtoList) {
                    events.add(Event.ofDto(eventDto,layoutWidget));
                }
                Set<LayoutWidgetSensor> layoutWidgetSensors=new HashSet<>();
                
                List<LayoutWidgetSensorDto> layoutWidgetSensorDtoList = layoutWidgetDto.getLayoutWidgetSensorDtoList();
                for (LayoutWidgetSensorDto layoutWidgetSensorDto: layoutWidgetSensorDtoList) {
                    LayoutWidgetSensor layoutWidgetSensor = LayoutWidgetSensor.ofDto(layoutWidgetSensorDto);
                    Sensor sensor = sensorRepository.findById(layoutWidgetSensorDto.getSensorId()).orElse(null);
                    layoutWidgetSensor.setSensor(sensor);
                    layoutWidgetSensor.setLayoutWidget(layoutWidget);
                    layoutWidgetSensors.add(layoutWidgetSensor);
                }
                layoutWidget.setLayoutWidgetSensors(layoutWidgetSensors);
                layoutWidget.setEvents(events);
                layoutWidgets.add(layoutWidget);
                //layoutWidgetDto.getWidgetId();
            }
            layout.setLayoutWidgets(layoutWidgets);
            layouts.add(layout);
        }
        Objects.requireNonNull(dashboard).setDashboardTitle(updateDashboardRequest.getDashboardTitle());
        dashboard.setLayouts(layouts);
        dashBoardRepository.saveAndFlush(dashboard);
    }

    /** 대시보드 삭제 - 완료 */
    public void deleteDashboard(Integer dashboardId) {
        dashBoardRepository.deleteById(dashboardId);
    }


    /** 대시보드와 관련된 layout ~ event 까지 삭제 - 대시보드는 삭제되지 않음 */
    public void deleteLayoutsByDashboardId(Integer dashboardId) {
        Dashboard dashboard = dashBoardRepository.findById(dashboardId).orElseThrow();
        Set<Layout> layouts = new HashSet<>(dashboard.getLayouts());
    
        for (Layout layout : layouts) {
            Integer layoutId = layout.getId();
            log.info("Layout ID: {}", layoutId);
            layoutRepository.deleteById(layoutId);
        }
        layoutRepository.deleteByDashboard(dashboard);
        
        dashBoardRepository.saveAndFlush(dashboard); // Save the modified dashboard
    }


    public List<Dashboard> getAllDashboards()
    {
        return dashBoardRepository.findAll();
    }

}

