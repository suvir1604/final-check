-- Include table data insertion, updation, deletion and select scripts
---- ---------------------------------------------------------------
---- Adding Movie Items in MovieItem Table
---- ---------------------------------------------------------------
INSERT INTO movie_item
values
	(1, 'Avatar', 278796508, 'Yes', '2017-03-15',
					'Science Fiction', 'Yes'),
	(2, 'The Avengers', 1518812988, 'Yes', '2017-12-23',
					'Super Hero', 'No'),
	(3, 'Titanic', 218746394, 'Yes', '2017-08-21',
					'Romance', 'No'),
	(4, 'Jurassic World', 1671713208, 'No',
					'2017-07-02', 'Science Fiction', 'Yes'),
	(5, 'Avengers:end game', 278285677, 'Yes',
					'2022-11-02', 'Super Hero', 'Yes');
                    
select
 m_id as "id",
 m_Title as "Title",
 m_Boxoffice as "Boxoffice",
 m_Active as "Active",
 m_dateofLaunch as "dateofLaunch",
 m_Genre as "Genre",
 m_HasTeaser as "HasTeaser" 
 from movie_item; 

---- ---------------------------------------------------------------
---- Updating movieitem in the MovieItem Table
---- ---------------------------------------------------------------

update movie_item
set  m_Title='infinity war',m_Boxoffice=12453080,m_Active='Yes',m_dateofLaunch='2020-04-14',m_Genre='Science Fiction',m_HasTeaser='No'
where m_id=1;
---- ---------------------------------------------------------------
---- Display Admin List------------------------------------------
---- ---------------------------------------------------------------

select
 m_id as "id",
 m_Title as "Title",
 m_Boxoffice as "Boxoffice",
 m_Active as "Active",
 m_dateofLaunch as "dateofLaunch",
 m_Genre as "Genre",
 m_HasTeaser as "HasTeaser" 
 from movie_item;

---- ---------------------------------------------------------------
---- Adding User Details into User Table------------------------------
---- ---------------------------------------------------------------
INSERT INTO user(us_id,us_name)
VALUES
(1,'Divya'),(2,'Dhilip');  

---- ---------------------------------------------------------------
---- Display User Details ------------------------------
---- ---------------------------------------------------------------
SELECT us_id as "User Id",
us_name as "User Name" 
FROM user;


---- ---------------------------------------------------------------
---- Customer Movie List------------------------------
---- ---------------------------------------------------------------

SELECT 
m_Title as "Title",
m_HasTeaser as "HasTeaser",
m_Boxoffice as "Boxoffice",
m_Genre as "Genre"
FROM movie_item
WHERE m_active='Yes' AND m_dateofLaunch < CURDATE();

---- ---------------------------------------------------------------
---- Display Customer Movie List------------------------------
---- ---------------------------------------------------------------
select * from movie_item;
---- ---------------------------------------------------------------
---- Adding Favorites in the favorite table------------------------------
---- ---------------------------------------------------------------
INSERT INTO 
favorite(fv_id,fv_us_id,fv_pr_id)
values
(101,1,1),(102,1,3),(103,1,2);

---- ---------------------------------------------------------------
---- Adding Favorites in the favorite table------------------------------
---- ---------------------------------------------------------------
SELECT 
fv_id as "Favorite Id",
fv_us_id as "Favorite UserId",
fv_pr_id as "Favorite Primary Id"
FROM  favorite; 

---- ---------------------------------------------------------------
----  view favorite table------------------------------
---- ---------------------------------------------------------------
SELECT 
m_Title as "Title",
m_Boxoffice as "Boxoffice",
m_Genre as "Genre"
FROM movie_item
inner join favorite
on fv_pr_id=m_id
where fv_us_id=1;

---- ---------------------------------------------------------------
----  Display No of Favorite------------------------------
---- ---------------------------------------------------------------
SELECT count(m_Boxoffice) as "No of Favorites"
FROM movie_item
inner join favorite
on fv_pr_id=m_id
where favorite.fv_us_id=1;


---- ---------------------------------------------------------------
----  Deletion in the favorite------------------------------
---- ---------------------------------------------------------------

delete from favorite 
where fv_us_id=1 
and fv_pr_id=2; 


---- ---------------------------------------------------------------
----  Deletion in the favorite------------------------------
---- ---------------------------------------------------------------

SELECT 
fv_id as "Favorite Id",
fv_us_id as "Favorite UserId",
fv_pr_id as "Favorite Primary Id"
FROM  favorite; 

