-- select team.*,team_detail.id_season from team inner join team_detail on team.id=team_detail.id_team where id_season= 1 ;
select * from team ;
select * from team_detail ;
-- lẩy ra tất cả các đội bóng thuộc session 1 
select team.* , team_detail.id_season from team inner join team_detail on team.id = team_detail.id_team ;
select team.*,team_detail.id_season from team inner join team_detail on team.id=team_detail.id_team where id_season= 1 ;
-- lẩy ra tát cả các trận đâu thuộc session 1 

select m.*, t.name, t.logo 
from match_detail m 
join team t on m.id_team = t.id 
join `match` on m.id_match = `match`.id 
where id_season = 1; 

select m.* , t.name , t.logo from match_detail m
join team t  on m.id_team = t.id 
 join `match` on m.id_match = `match`.id
 where id_seson =  1 ;
 
 
 select mywweb.team.id , mywweb.team.name , mywweb.match_detail.status ,mywweb.match_detail.score , mywweb.match_detail.id_match ,mywweb.match_detail.studium , mywweb.match.date ,mywweb.match.card , mywweb.match.id_season from mywweb.team
inner join mywweb.match_detail on mywweb.team.id = mywweb.match_detail.id_team
inner join mywweb.match on mywweb.match_detail.id_match = mywweb.match.id;