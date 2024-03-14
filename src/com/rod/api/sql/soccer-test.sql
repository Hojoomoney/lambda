-- 001. 전체 축구팀 목록을 팀이름 오름차순으로 출력하시오.

select * from team order by team_name;

-- 002. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈공간으로 두시오.

select distinct position from player;

-- 003. 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입' 으로 기재하시오

select distinct
    case
        when position = '' then '신입' else position
    end
from player;

-- 004. 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.

select player_name from player where team_id = 'K02' and position = 'GK';

-- 004-1. (ID를 모를 경우)
select player_name from player where position = 'GK' and team_id = (select team_id from team where region_name = '수원');

select player_name from player left join team on player.team_id = team.team_id where position = 'GK' and region_name = '수원';

-- 005. 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원    팀 ID는 K02 입니다.

select * from player where team_id = 'K02' and player_name like '고%' and height >= 170;

-- 005-1. (ID를 모를 경우)

select * from player where player_name like '고%' and height >= 170 and team_id = (select team_id from team where region_name = '수원');

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
-- 키는 170 센티미터 이상이고 180 이하여야 한다.

select * from player where team_id in (select team_id from team where team_name = '삼성블루윙즈' or team_name = '드래곤즈') and position = 'MF' and height between 170 and 180;

-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?

select * from player where position = 'GK' and team_id = (select team_id from team where region_name = '수원');

-- 문제 8
-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오
-- 키와 몸무게가 없으면 "0" 으로 표시하시오
-- 키와 몸무게는 내림차순으로 정렬하시오

select player_name,
    case
        when height = '' then '0' else height
    end as height,
    case
        when weight = '' then '0' else weight
    end as weight
from player where team_id = (select team_id from team where region_name = '서울')  order by height desc;

select player_name, ifnull(nullif(height,''),'0') height, ifnull(nullif(weight,''),'0') weight
from player where team_id = (select team_id from team where region_name = '서울')  order by height,weight desc;

-- 문제 9
-- 서울팀 선수들 이름과 포지션과-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오
-- 단, 키와 몸무게가 없으면 "0" 표시하시오-- BMI는 "NONE" 으로 표시하시오(as bmi)-- 최종 결과는 이름내림차순으로 정렬하시오

select player_name, position, concat(ifnull(nullif(height,''),'0'),'cm') height, concat(ifnull(nullif(weight,''),'0'),'kg') weight, ifnull(nullif(round(weight / (height/100*height/100)),''),'NONE') bmi
from player where team_id = (select team_id from team where region_name = '서울')  order by player_name desc;

-- full scan
-- 4개의 테이블을 모두 조인하시오.
select count(*) count
from stadium s
    join team t on s.stadium_id = t.stadium_id
    join player p on t.team_id = p.team_id
    join schedule sc on s.stadium_id = sc.stadium_id;

-- 문제 10
-- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인
-- 선수를 출력하시오
-- 단 , 팀명, 선수명 오름차순 정렬하시오

select t.team_name, p.player_name, p.position
from team t
    join player p on p.team_id = t.team_id
where p.team_id in ('K02','K10') and p.position = 'GK'
order by t.team_name, p.player_name;

-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- [팀 명]             [홈구장]
-- 수원[ ]삼성블루윙즈 수원월드컵경기장

select concat(t.region_name, '[ ]', t.team_name) 팀명, s.stadium_name 홈구장
from stadium s
    join team t on s.stadium_id = t.stadium_id;

-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순

select p.height, t.team_name, p.player_name
from team t
    join player p on p.team_id = t.team_id
where t.team_id in ('K02','K10') and (p.height between 180 and 183)
order by p.height, t.team_name, p.player_name;

-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차순

select t.team_name, p.player_name, p.position
from team t
    join player p using(team_id)
where p.position = ''
order by t.team_name, p.player_name;

 -- 문제 14
-- 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.

select sc.sche_date 스케줄,
    (select team_name from team where team_id = sc.hometeam_id) 홈팀,
    s.stadium_name 스타디움,
    (select team_name from team where team_id = sc.awayteam_id) 어웨이팀
from stadium s
    join schedule sc using (stadium_id)
where sc.sche_date = '20120317';

-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)

select p.player_name 선수이름,
        p.position 포지션,
        concat(t.region_name,'[]',t.team_name) 팀명,
        s.stadium_name 스타디움,
        sc.sche_date 경기날짜
from stadium s
    join schedule sc on s.stadium_id = sc.stadium_id
    join team t on s.hometeam_id = t.team_id
    join player p on t.team_id = p.team_id
where sc.sche_date = '20120317' and t.team_name='스틸러스' and p.position = 'GK';

-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오

select stadium_name 경기장이름, sche_date 경기일정,
        (select team_name from team where sc.hometeam_id = team_id) 홈팀이름,
        (select team_name from team where sc.awayteam_id = team_id) 원정팀이름
from stadium s
    join schedule sc using(stadium_id)
where home_score - away_score >= 3;

-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 19
-- 힌트 : LEFT JOIN 사용해야함
-- 경기장 이름, 홈팀

select stadium_name,
        (select t.team_name from team t where t.stadium_id = s.stadium_id)
from stadium s;

select s.stadium_name, t.team_name
from stadium s left join team t using(stadium_id);

-- 문제 18 플레이어 테이블에서 최상단 5개 로우를 출력
select *
from player
order by 1 limit 0, 5;

-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 -- 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.

select team_id 팀ID,
        (select team_name from team where team_id = player.team_id) 팀명,
        ROUND(AVG(height), 2) 평균키
from player
where height != ''
group by team_id
having ROUND(AVG(height), 2) <
    (SELECT ROUND(AVG(height), 2)
    FROM player
    WHERE team_id = 'K04');

-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력

select (select team_name from team t where t.team_id = p.team_id) 소속팀명,
        player_name 선수명,
        back_no 백넘버
from player p
where position = 'MF';

-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키  값이 없으면 제외


select (select team_name from team t where t.team_id = p.team_id) 소속팀명,
        player_name 선수명,
        back_no 백넘버
from player p
order by height desc limit 5;

-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)
select team_id,round(avg(height),2) from player group by team_id;


SELECT player_name, height, team_id
FROM player p
WHERE height < (
    SELECT ROUND(AVG(height), 2)
    FROM player
    WHERE team_id = p.team_id
    GROUP BY team_id
);



-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장  조회

select distinct (select stadium_name from stadium where stadium_id = sc.stadium_id) 경기장이름
from schedule sc
where sc.sche_date between '20120501' and '20120531';