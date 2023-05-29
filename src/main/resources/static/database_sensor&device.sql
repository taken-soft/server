INSERT INTO devices (device_id, device_name) VALUES
                                                 (1, '장비1'),
                                                 (2, '장비2'),
                                                 (3, '장비3'),
                                                 (4, '장비4');


-- 장비1
INSERT INTO sensors (sensor_id, sensor_name, sensor_unit, device_id) VALUES
                                                                         (1, '머신펌프 RPM', 'rpm', 1),
                                                                         (2, '머신펌프 부하율', '%', 1),
                                                                         (3, '사이로 온도', 'ºC', 1),
                                                                         (4, '팬펌프 RPM', 'RPM', 1),
                                                                         (5, '팬펌프 부하율', '%', 1),
                                                                         (6, '1차 1번 라모트 스크린 부하율', '%', 1),
                                                                         (7, '어테뉴에이터 탱크 레밸 측정값', 'mm', 1),
                                                                         (8, '슬라이스 버티칼 측정값', 'mm', 1),
                                                                         (9, '슬라이스 호리존탈 측정값', '%', 1),
                                                                         (10, 'JET WIRE RATIO', '%', 1);

-- 장비2
INSERT INTO sensors (sensor_id, sensor_name, sensor_unit, device_id) VALUES
                                                                         (11, '폼마스터 하이드로릭 오일 온도 설정값', '설정값', 2),
                                                                         (12, '폼마스터 하이드로릭 오일 온도 측정값', '실측값', 2),
                                                                         (13, '폼마스터 쉐이킹 주파수 측정값', 'HZ', 2),
                                                                         (14, '폼마스터 쉐이킹 스트로크 측정값', 'mm', 2),
                                                                         (15, '폼마스터 루브리케이션 압력 커플링', 'Mpa', 2),
                                                                         (16, '폼마스터 루브리케이션 압력 베어링', 'MPa', 2),
                                                                         (17, '폼마스터 루브리케이션 압력 플로트', 'MPa', 2),
                                                                         (18, '폼마스터 루브리케이션 압력 MESH', 'Mpa', 2),
                                                                         (19, '브레스트롤 윤활유량 운전측', 'l/min', 2),
                                                                         (20, '브레스트롤 윤활유량 전동측', 'l/min', 2);

-- 장비3
INSERT INTO sensors (sensor_id, sensor_name, sensor_unit, device_id)
VALUES (21, '슬라이스 버티칼', 'mm', 3),
       (22, '슬라이스 호리존탈', 'mm', 3),
       (23, 'JET RATIO', '%', 3),
       (24, '어테뉴에이터 레밸', '%', 3),
       (25, '라모트 스크린 가동상태', 'on/off', 3),
       (26, '라모트 스크린 모터 부하율', '%', 3),
       (27, '팬펌프 가동상태', 'on/off', 3),
       (28, '팬펌프 부하율', '%', 3),
       (29, '팬펌프 RPM', 'RPM', 3),
       (30, '사이로 온도', 'ºC', 3),
       (31, '머신펌프 부하율', '%', 3),
       (32, '머신펌프 RPM', 'rpm', 3);

-- 장비4
INSERT INTO sensors (sensor_id, sensor_name, sensor_unit, device_id)
VALUES (33, '라모트 스크린 가동상태', 'on/off', 4),
       (34, '라모트 스크린 모터 부하율', '%', 4),
       (35, '팬펌프 가동상태', 'on/off', 4),
       (36, '팬펌프 부하율', '%', 4),
       (37, '팬펌프 RPM', 'rpm', 4),
       (38, '사이로 온도', 'ºC', 4),
       (39, '머신펌프 부하율', '%', 4),
       (40, '머신펌프 RPM', 'rpm', 4);


INSERT INTO widget (widget_id, widget_type) VALUES (1, 'text');
INSERT INTO widget (widget_id, widget_type) VALUES (2, 'image');
INSERT INTO widget (widget_id, widget_type) VALUES (3, 'line graph');
INSERT INTO widget (widget_id, widget_type) VALUES (4, 'bar graph');
INSERT INTO widget (widget_id, widget_type) VALUES (5, 'rectangle');
INSERT INTO widget (widget_id, widget_type) VALUES (6, 'circle');
INSERT INTO widget (widget_id, widget_type) VALUES (7, 'circle graph');

