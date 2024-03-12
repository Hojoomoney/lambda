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