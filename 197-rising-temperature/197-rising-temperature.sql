# Write your MySQL query statement below

select distinct a.id as Id from Weather a, Weather b
where a.temperature > b.temperature and DATEDIFF(a.recordDate,b.recordDate) = 1;