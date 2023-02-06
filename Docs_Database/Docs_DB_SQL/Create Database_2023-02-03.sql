drop table player;
drop table TEAM;
drop table  STADIUM;
drop table schedule;
drop table  TEAM_HISTORY;
CREATE TABLE STADIUM (
STADIUM_ID    CHAR(3) ,
STADIUM_NAME  VARCHAR2(40) NOT NULL,
HOMETEAM_ID   CHAR(3),
SEAT_COUNT    NUMBER,
ADDRESS     VARCHAR2(1200),
DDD         VARCHAR2(6),
TEL         VARCHAR2(20),
CONSTRAINT STADIUM_PK PRIMARY KEY (STADIUM_ID)
);

CREATE TABLE TEAM (
TEAM_ID     CHAR(3) NOT NULL,
REGION_NAME VARCHAR2(8) NOT NULL,
TEAM_NAME   VARCHAR2(40) NOT NULL,
EEAM_NAME VARCHAR2(100),
ORIG_YYYY   CHAR(4),
STADIUM_ID  CHAR(3) NOT NULL,
ZIP_CODE1   CHAR(3),
ZIP_CODE2   CHAR(3),
ADDRESS     VARCHAR2(120),
DDD         VARCHAR2(6),
TEL         VARCHAR2(20),
FAX         VARCHAR2(20),
HOMEPAGE    VARCHAR2(100),
OWNER       VARCHAR2(20),
CONSTRAINT TEAM_PK PRIMARY KEY (TEAM_ID),
CONSTRAINT TEAM_FK FOREIGN KEY (STADIUM_ID) REFERENCES STADIUM(STADIUM_ID)
);


CREATE TABLE PLAYER (
PLAYER_ID     CHAR(7) NOT NULL,
PLAYER_NAME   VARCHAR2(40) NOT NULL,
TEAM_ID       CHAR(3) NOT NULL,
E_PLAYER_NAME VARCHAR2(80),
NICKNAME      VARCHAR2(60),
JOIN_YYYY     CHAR(4),
POSITION      VARCHAR2(20),
BACK_NO       NUMBER(2),
NATION        VARCHAR2(40),
BIRTH         DATE,
SOLAR         CHAR(1),
HEIGHT        NUMBER(3),
WEIGHT        NUMBER(3),
CONSTRAINT PLAYER_PK PRIMARY KEY (PLAYER_ID),
CONSTRAINT PLAYER_FK FOREIGN KEY (TEAM_ID) REFERENCES TEAM(TEAM_ID)
);

CREATE TABLE SCHEDULE (
GUBUN        CHAR(1) NOT NULL,
STADIUM_ID   VARCHAR2(10) NOT NULL,
SCHE_DATE    CHAR(8) NOT NULL,
HOMETEAM_ID  CHAR(3) NOT NULL,
AWAYTEAM_ID  CHAR(3) NOT NULL,
HOME_SCORE   NUMBER(2),
AWAY_SCORE   NUMBER(2),
CONSTRAINT SCHEDULE_PK PRIMARY KEY (GUBUN, STADIUM_ID, SCHE_DATE)
);

CREATE TABLE TEAM_HISTORY (
TEAM_ID  CHAR(3) NOT NULL,
YYYY     CHAR(4) NOT NULL,
SEQ      NUMBER  NOT NULL,
COMMENTS  VARCHAR2(200),
CONSTRAINT TEAM_HISTORY_PK PRIMARY KEY (TEAM_ID, YYYY, SEQ)
);


-------------------------------------------------------------------------
-- insert_stadium 
-------------------------------------------------------------------------


INSERT INTO stadium VALUES ('E01','한밭종합운동장','K10',30000,'대전 광역시 중구 부사동 162-1','042','221-2002');                                              
INSERT INTO stadium VALUES ('C02','부산구장','K06',30000,'부산광역시 서구 서대신동 3가 210번지','051','247-5771');                                             
INSERT INTO stadium VALUES ('B01','부천구장','K04',35000,'부천시 원미구 춘의동 산 19번지','031','666-0496');                                                   
INSERT INTO stadium VALUES ('B02','성남구장','K08',27000,'성남시 중원구 성남동 3110번지','031','753-3956');                                                    
INSERT INTO stadium VALUES ('B04','수원월드컵구장','K02',50000,'수원시 팔달구 우만1동 228번지','031','259-2150');                                              
INSERT INTO stadium VALUES ('B05','안양구장','K09',22500,'경기도 동안구 비산3동 1025번지','031','380-7212');                                                  
INSERT INTO stadium VALUES ('C04','울산문수구장','K01',46102,'울산광역시 남구 옥산 산5번지 울산체육공원','052','220-');                                        
INSERT INTO stadium VALUES ('D01','전남구장','K07',20009,'전남 광양시 금호동 700','061','792-5600');                                                           
INSERT INTO stadium VALUES ('D03','전북구장','K05',28000,'전북 덕진구 덕진동 1가 1220','063','273-1763');                                                      
INSERT INTO stadium VALUES ('C06','포항구장','K03',25000,'경북 포항시 남구 괴동 1번지','054','282-2002');                                                     
INSERT INTO stadium VALUES ('B03','수원구장','','','경기도 수원시','','');       
INSERT INTO stadium VALUES ('C01','김천구장','','','경북 김천시','','');         
INSERT INTO stadium VALUES ('C03','울산구장','','','울산광역시','','');          
INSERT INTO stadium VALUES ('C05','창원구장','','','경남 창원시','','');         
INSERT INTO stadium VALUES ('D02','전주구장','','','전북 전주시','','');         
INSERT INTO stadium VALUES ('E02','대전월드컵구장','',41000,'대전광역시 유성구 노은동 270번지','','');                                                         
INSERT INTO stadium VALUES ('A01','서울 월드컵경기장','',63930,'','','');      


-------------------------------------------------------------------------
--  inserteam.sql  
-------------------------------------------------------------------------


INSERT INTO team VALUES ('K10','대전','시티즌','TAEJON CITIZEN','1997','E02','301','030',
'대전광역시 중구 부사동 162-1 한밭운동장 내 ','42','252-2002','221-0669','http://www.tcfc.co.kr','');                                                
                                                                               
INSERT INTO team VALUES ('K06','부산','아이콘스','BUSAN ICONS','1983','C02','57 ','050',
'부산시 동래구 수안동 1-11번지 대신증권 B/D 9층','51','555-7101','555-7103','http://www.busanicons/co.kr','');                                        
                                                                                
INSERT INTO team VALUES ('K04','부천','SK','BUCHEON SK','1982','B01','110','728',
'서울 종로구 서린동 99번지 SK 빌딩 3층','2','2121-5271','2121-5276','http://www.skfc.com','');                                                               

INSERT INTO team VALUES ('K08','성남','일화천마','SEONGNAM ILHWA','1989','B02','462',
'130','경기도 성남시 중원구 성남동 3110번지 성남종합운동장 내','31','753-3956','753-4443','http://www.seongnamilhwafc.co.kr','');                        
                                                                                
INSERT INTO team VALUES ('K02','수원','삼성블루윙즈','SUWON SAMSUNG BLUEWINGS','1995','B04','440','220',
'수원시 장안구 조원동 601-1 수원시체육회관 3층','31','247-2002','257-0766','http://www.fcbluewings.com','');                          
                                                                                
INSERT INTO team VALUES ('K09','안양','LG치타스','ANYANG LG ','1983','B05','138','221',
'서울 송파구 잠실1동 10번지 종합운동장 내','2','2005-5746','2005-5802','http://www.lgfootball.com','');                                                
                                                                                
INSERT INTO team VALUES ('K01','울산','현대호랑이','ULSAN HYUNDAI HORANGI','1983','C04','682','060',
'울산광역시 동구 전하동 1번지','52','230-6141','230-6145','http://www.horanifc.co.kr','');                                                
                                                                                
INSERT INTO team VALUES ('K07','전남','드래곤즈','CHUNNAM DRAGONS','1994','D01','544','010',
'전남 동광양시 중동 1318-2번지 산업은행 B/D 5층','61','792-5600','792-5605','http://www.dragons.co.kr','');                                       
                                                                                
INSERT INTO team VALUES ('K05','전북','현대모터스','CHUNBUK HYUNDAI MOTORS','1994','D03','560','190',
'전북 전주시 덕진구 덕진동 1가 1220번지','63','273-1763','273-1762','http://www.hyundai-motors.com','');                                 
                                                                                
INSERT INTO team VALUES ('K03','포항','스틸러스','POHANG STEELERS','1973','C06','790','050',
'경북 포항시 죽도동 645-1 삼일 B/D 6층','54','282-2002','282-5955','http://www.steelers.co.kr','');                                               
 

-------------------------------------------------------------------------
--  insert_schedule.sql  
-------------------------------------------------------------------------


INSERT INTO schedule VALUES ('A','C02','20020501','K06','K10','2','0');       
INSERT INTO schedule VALUES ('A','B03','20020505','K02','K01','1','2');       
INSERT INTO schedule VALUES ('A','B05','20020505','K09','K08','1','3');       
INSERT INTO schedule VALUES ('A','B02','20020512','K08','K01','1','1');       
INSERT INTO schedule VALUES ('S','C02','20020707','K06','K01','1','2');       
INSERT INTO schedule VALUES ('S','B02','20020707','K08','K03','3','2');       
INSERT INTO schedule VALUES ('S','D03','20020707','K05','K09','2','1');       
INSERT INTO schedule VALUES ('S','D01','20020707','K07','K10','1','0');       
INSERT INTO schedule VALUES ('S','B04','20020710','K02','K01','2','1');       
INSERT INTO schedule VALUES ('S','D03','20020710','K05','K03','1','1');       
INSERT INTO schedule VALUES ('S','E02','20020710','K10','K04','0','2');       
INSERT INTO schedule VALUES ('S','C02','20020710','K06','K08','3','1');       
INSERT INTO schedule VALUES ('S','D01','20020710','K07','K09','0','0');       
INSERT INTO schedule VALUES ('S','C06','20020713','K03','K06','2','1');       
INSERT INTO schedule VALUES ('S','B05','20020714','K09','K02','3','0');       
INSERT INTO schedule VALUES ('S','B01','20020714','K04','K07','1','0');       
INSERT INTO schedule VALUES ('S','E02','20020714','K10','K08','1','1');       
INSERT INTO schedule VALUES ('S','D01','20020717','K07','K01','0','0');       
INSERT INTO schedule VALUES ('S','C06','20020717','K03','K02','2','0');       
INSERT INTO schedule VALUES ('S','B02','20020717','K08','K04','2','1');       
INSERT INTO schedule VALUES ('S','C02','20020717','K06','K05','1','2');       
INSERT INTO schedule VALUES ('S','B05','20020717','K09','K10','1','1');       
INSERT INTO schedule VALUES ('S','D01','20020720','K07','K03','1','1');       
INSERT INTO schedule VALUES ('S','B04','20020721','K02','K06','2','2');       
INSERT INTO schedule VALUES ('S','D03','20020721','K05','K08','2','2');       
INSERT INTO schedule VALUES ('S','B01','20020721','K04','K09','1','3');       
INSERT INTO schedule VALUES ('S','D03','20020724','K05','K02','1','1');       
INSERT INTO schedule VALUES ('S','E02','20020724','K10','K03','1','1');       
INSERT INTO schedule VALUES ('S','C02','20020724','K06','K07','0','1');       
INSERT INTO schedule VALUES ('S','B02','20020724','K08','K09','1','1');       
INSERT INTO schedule VALUES ('S','C06','20020727','K03','K04','2','1');       
INSERT INTO schedule VALUES ('S','D01','20020727','K07','K05','2','1');       
INSERT INTO schedule VALUES ('S','C02','20020727','K06','K10','3','0');       
INSERT INTO schedule VALUES ('S','B05','20020728','K09','K01','1','1');       
INSERT INTO schedule VALUES ('S','B04','20020728','K02','K08','2','2');       
INSERT INTO schedule VALUES ('S','B02','20020731','K08','K01','2','0');       
INSERT INTO schedule VALUES ('S','B05','20020731','K09','K03','3','1');       
INSERT INTO schedule VALUES ('S','E02','20020731','K10','K05','1','0');       
INSERT INTO schedule VALUES ('S','B01','20020731','K04','K06','3','2');       
INSERT INTO schedule VALUES ('S','B04','20020731','K02','K07','1','2');       
INSERT INTO schedule VALUES ('S','B02','20020803','K08','K07','1','0');       
INSERT INTO schedule VALUES ('S','C02','20020803','K06','K09','2','1');       
INSERT INTO schedule VALUES ('S','E02','20020804','K10','K02','0','3');       
INSERT INTO schedule VALUES ('S','D03','20020804','K05','K04','2','1');       
INSERT INTO schedule VALUES ('S','B01','20020811','K04','K02','0','2');       
INSERT INTO schedule VALUES ('S','B05','20020811','K09','K05','0','1');       
INSERT INTO schedule VALUES ('S','C06','20020811','K03','K08','2','0');       
INSERT INTO schedule VALUES ('S','D01','20020811','K07','K10','1','1');       
INSERT INTO schedule VALUES ('S','D03','20020818','K05','K01','0','2');       
INSERT INTO schedule VALUES ('S','C02','20020818','K06','K03','3','1');       
INSERT INTO schedule VALUES ('S','B01','20020818','K04','K07','1','0');       
INSERT INTO schedule VALUES ('S','B04','20020818','K02','K09','1','2');       
INSERT INTO schedule VALUES ('S','B02','20020818','K08','K10','3','1');       
INSERT INTO schedule VALUES ('S','B04','20020824','K02','K01','1','1');       
INSERT INTO schedule VALUES ('S','D03','20020824','K05','K03','3','3');       
INSERT INTO schedule VALUES ('S','B02','20020824','K08','K06','4','3');       
INSERT INTO schedule VALUES ('S','E02','20020825','K10','K04','1','1');       
INSERT INTO schedule VALUES ('S','B05','20020825','K09','K07','1','1');       
INSERT INTO schedule VALUES ('S','C06','20020828','K03','K02','0','0');       
INSERT INTO schedule VALUES ('S','C02','20020828','K06','K05','1','1');       
INSERT INTO schedule VALUES ('S','B01','20020828','K04','K08','2','3');       
INSERT INTO schedule VALUES ('S','B05','20020828','K09','K10','2','0');       
INSERT INTO schedule VALUES ('S','E02','20020901','K10','K01','2','3');       
INSERT INTO schedule VALUES ('S','D01','20020901','K07','K03','0','1');       
INSERT INTO schedule VALUES ('S','B04','20020901','K02','K06','1','1');       
INSERT INTO schedule VALUES ('S','D03','20020901','K05','K08','3','3');       
INSERT INTO schedule VALUES ('S','B01','20020901','K04','K09','2','1');       
INSERT INTO schedule VALUES ('S','D01','20020911','K07','K05','','');         
INSERT INTO schedule VALUES ('S','B05','20020911','K09','K01','','');         
INSERT INTO schedule VALUES ('S','B04','20020911','K02','K08','','');         
INSERT INTO schedule VALUES ('S','B01','20020911','K04','K03','','');         
INSERT INTO schedule VALUES ('S','E02','20020911','K10','K06','','');         
INSERT INTO schedule VALUES ('S','C02','20020914','K06','K04','','');         
INSERT INTO schedule VALUES ('S','C06','20020914','K03','K09','','');         
INSERT INTO schedule VALUES ('S','B02','20020914','K08','K01','','');         
INSERT INTO schedule VALUES ('S','D01','20020914','K07','K02','','');         
INSERT INTO schedule VALUES ('S','D03','20020915','K05','K10','','');         
INSERT INTO schedule VALUES ('S','E02','20020918','K10','K02','','');         
INSERT INTO schedule VALUES ('S','B02','20020918','K08','K07','','');         
INSERT INTO schedule VALUES ('S','B05','20020918','K09','K06','','');         
INSERT INTO schedule VALUES ('S','D03','20020918','K05','K04','','');         
INSERT INTO schedule VALUES ('S','B04','20020925','K02','K10','','');         
INSERT INTO schedule VALUES ('S','C06','20020925','K03','K01','','');         
INSERT INTO schedule VALUES ('S','B01','20020925','K04','K05','','');         
INSERT INTO schedule VALUES ('S','D01','20020925','K07','K08','','');         
INSERT INTO schedule VALUES ('S','B05','20020925','K09','K06','','');         
INSERT INTO schedule VALUES ('S','D01','20021019','K07','K02','','');         
INSERT INTO schedule VALUES ('S','C06','20021019','K03','K09','','');         
INSERT INTO schedule VALUES ('S','E02','20021020','K10','K05','','');         
INSERT INTO schedule VALUES ('S','C02','20021020','K06','K04','','');         
INSERT INTO schedule VALUES ('S','C06','20021023','K03','K04','','');         
INSERT INTO schedule VALUES ('S','D03','20021023','K05','K07','','');         
INSERT INTO schedule VALUES ('S','C02','20021023','K06','K10','','');         
INSERT INTO schedule VALUES ('S','B02','20021023','K08','K02','','');         
INSERT INTO schedule VALUES ('S','D01','20021026','K07','K06','','');         
INSERT INTO schedule VALUES ('S','E02','20021027','K10','K03','','');         
INSERT INTO schedule VALUES ('S','B01','20021027','K04','K01','','');         
INSERT INTO schedule VALUES ('S','B05','20021027','K09','K08','','');         
INSERT INTO schedule VALUES ('S','B04','20021027','K02','K05','','');         
INSERT INTO schedule VALUES ('S','B04','20021030','K02','K04','','');         
INSERT INTO schedule VALUES ('S','E02','20021030','K10','K08','','');         
INSERT INTO schedule VALUES ('S','C06','20021102','K03','K07','','');         
INSERT INTO schedule VALUES ('S','B05','20021103','K09','K04','','');         
INSERT INTO schedule VALUES ('S','C02','20021103','K06','K02','','');         
INSERT INTO schedule VALUES ('S','B02','20021103','K08','K05','','');         
INSERT INTO schedule VALUES ('S','D03','20021106','K05','K06','','');         
INSERT INTO schedule VALUES ('S','D01','20021106','K07','K01','','');         
INSERT INTO schedule VALUES ('S','E02','20021106','K10','K09','','');         
INSERT INTO schedule VALUES ('S','B01','20021106','K04','K08','','');         
INSERT INTO schedule VALUES ('S','B04','20021106','K02','K03','','');         
INSERT INTO schedule VALUES ('S','C06','20021109','K03','K05','','');         
INSERT INTO schedule VALUES ('S','B05','20021110','K09','K07','','');         
INSERT INTO schedule VALUES ('S','B01','20021110','K04','K10','','');         
INSERT INTO schedule VALUES ('S','B02','20021110','K08','K06','','');         
INSERT INTO schedule VALUES ('S','D01','20021113','K07','K04','','');         
INSERT INTO schedule VALUES ('S','C02','20021113','K06','K03','','');         
INSERT INTO schedule VALUES ('S','B04','20021113','K02','K09','','');         
INSERT INTO schedule VALUES ('S','D03','20021113','K05','K01','','');         
INSERT INTO schedule VALUES ('S','B05','20021117','K09','K05','','');         
INSERT INTO schedule VALUES ('S','E02','20021117','K10','K07','','');         
INSERT INTO schedule VALUES ('S','C06','20021117','K03','K08','','');         
INSERT INTO schedule VALUES ('S','B01','20021117','K04','K02','','');         
INSERT INTO schedule VALUES ('A','C04','20020508','K01','K08','1','3');       
INSERT INTO schedule VALUES ('S','C04','20020713','K01','K05','0','0');       
INSERT INTO schedule VALUES ('S','C04','20020720','K01','K10','0','0');       
INSERT INTO schedule VALUES ('S','C04','20020724','K01','K04','1','1');       
INSERT INTO schedule VALUES ('S','C04','20020803','K01','K03','3','0');       
INSERT INTO schedule VALUES ('S','C04','20020811','K01','K06','0','0');       
INSERT INTO schedule VALUES ('S','C04','20020828','K01','K07','0','1');       
INSERT INTO schedule VALUES ('S','C04','20020918','K01','K03','','');         
INSERT INTO schedule VALUES ('S','C04','20021019','K01','K08','','');         
INSERT INTO schedule VALUES ('S','C04','20021023','K01','K09','','');         
INSERT INTO schedule VALUES ('S','C04','20021102','K01','K10','','');         
INSERT INTO schedule VALUES ('S','C04','20021110','K01','K02','','');         
INSERT INTO schedule VALUES ('S','C04','20021117','K01','K06','','');         
INSERT INTO schedule VALUES ('A','C06','20020317','K03','K02','1','2');       
INSERT INTO schedule VALUES ('A','B02','20020317','K08','K04','6','0');       
INSERT INTO schedule VALUES ('A','E01','20020317','K10','K06','2','1');       
INSERT INTO schedule VALUES ('A','C03','20020317','K01','K09','2','2');       
INSERT INTO schedule VALUES ('A','D01','20020320','K07','K01','1','2');       
INSERT INTO schedule VALUES ('A','D02','20020320','K05','K03','1','0');       
INSERT INTO schedule VALUES ('A','B03','20020320','K02','K08','2','3');       
INSERT INTO schedule VALUES ('A','B05','20020320','K09','K10','2','0');       
INSERT INTO schedule VALUES ('A','B03','20020323','K02','K05','2','0');       
INSERT INTO schedule VALUES ('A','C02','20020324','K06','K01','1','2');       
INSERT INTO schedule VALUES ('A','B01','20020324','K04','K03','1','1');       
INSERT INTO schedule VALUES ('A','B05','20020324','K09','K07','1','0');       
INSERT INTO schedule VALUES ('A','D01','20020327','K07','K06','2','1');       
INSERT INTO schedule VALUES ('A','C06','20020327','K03','K08','1','0');       
INSERT INTO schedule VALUES ('A','C03','20020327','K01','K10','0','1');       
INSERT INTO schedule VALUES ('A','D02','20020406','K05','K04','3','2');       
INSERT INTO schedule VALUES ('A','B01','20020410','K04','K02','2','0');       
INSERT INTO schedule VALUES ('A','B02','20020410','K08','K05','2','1');       
INSERT INTO schedule VALUES ('A','E01','20020410','K10','K07','1','1');       
INSERT INTO schedule VALUES ('A','C02','20020410','K06','K09','1','4');       
INSERT INTO schedule VALUES ('A','C01','20020414','K10','K01','0','2');       
INSERT INTO schedule VALUES ('A','B02','20020414','K08','K03','1','1');       
INSERT INTO schedule VALUES ('A','B01','20020414','K04','K05','1','0');       
INSERT INTO schedule VALUES ('A','C02','20020414','K06','K07','2','0');       
INSERT INTO schedule VALUES ('A','D02','20020420','K05','K08','2','2');       
INSERT INTO schedule VALUES ('A','D01','20020420','K07','K10','0','1');       
INSERT INTO schedule VALUES ('A','B03','20020421','K02','K04','3','2');       
INSERT INTO schedule VALUES ('A','B05','20020421','K09','K06','1','0');       
INSERT INTO schedule VALUES ('A','B02','20020424','K08','K02','1','1');       
INSERT INTO schedule VALUES ('A','C06','20020424','K03','K05','1','2');       
INSERT INTO schedule VALUES ('A','C03','20020424','K01','K07','1','2');       
INSERT INTO schedule VALUES ('A','E01','20020424','K10','K09','1','3');       
INSERT INTO schedule VALUES ('A','C06','20020427','K03','K04','0','3');       
INSERT INTO schedule VALUES ('A','C03','20020427','K01','K06','5','2');       
INSERT INTO schedule VALUES ('A','D01','20020427','K07','K09','0','1');       
INSERT INTO schedule VALUES ('A','D02','20020428','K05','K02','1','2');       
INSERT INTO schedule VALUES ('A','B05','20020501','K09','K01','0','0');       
INSERT INTO schedule VALUES ('A','B03','20020501','K02','K03','1','2');       
INSERT INTO schedule VALUES ('A','B01','20020501','K04','K08','2','2');       
INSERT INTO schedule VALUES ('S','D02','20020904','K05','K02','1','2');       
INSERT INTO schedule VALUES ('S','B02','20020904','K08','K09','1','0');       
INSERT INTO schedule VALUES ('S','C05','20020904','K01','K04','2','2');       
INSERT INTO schedule VALUES ('S','C06','20020904','K03','K10','0','0');       
INSERT INTO schedule VALUES ('S','C02','20020904','K06','K07','2','2');       


-------------------
--insert player
-------------------


INSERT INTO player VALUES ('1999174','우르모브','K06','','','1999','DF','4','유고',TO_DATE('30-08-1977','dd-mm-yyyy'),'1','180','70');                         
INSERT INTO player VALUES ('1997188','윤희준','K06','','','1995','DF','15','',TO_DATE('01-11-1972','dd-mm-yyyy'),'1','180','74');                               
INSERT INTO player VALUES ('2002073','이규호','K06','','','2001','DF','23','',TO_DATE('13-07-1979','dd-mm-yyyy'),'1','177','72');                               
INSERT INTO player VALUES ('1997178','이민성','K06','','','','DF','20','',TO_DATE('23-06-1973','dd-mm-yyyy'),'1','182','73');                                   
INSERT INTO player VALUES ('1997191','이장관','K06','','배추도사,작은삼손','1997','DF','18','',TO_DATE('05-06-1974','dd-mm-yyyy'),'2','170','61');              
INSERT INTO player VALUES ('1998384','이정효','K06','','깜둥이,통키통','1998','DF','19','',TO_DATE('23-07-1975','dd-mm-yyyy'),'2','174','68');                  
INSERT INTO player VALUES ('1998395','장대일','K06','','달구','2000','DF','7','',TO_DATE('09-03-1975','dd-mm-yyyy'),'2','184','79');                            
INSERT INTO player VALUES ('2001050','정상수','K06','','꼬마홍길동','2001','DF','36','',TO_DATE('14-06-1978','dd-mm-yyyy'),'1','173','65');                     
INSERT INTO player VALUES ('1997189','김재영','K06','','제리','1996','MF','6','',TO_DATE('02-09-1973','dd-mm-yyyy'),'2','187','75');                            
INSERT INTO player VALUES ('2001049','김태민','K06','','킹카','2001','MF','38','',TO_DATE('25-05-1982','dd-mm-yyyy'),'1','180','71');                           
INSERT INTO player VALUES ('2000107','김현우','K06','','','2000','MF','37','',TO_DATE('04-06-1981','dd-mm-yyyy'),'1','178','70');                               
INSERT INTO player VALUES ('2001043','송종국','K06','','썰렁왕자','2001','MF','24','',TO_DATE('20-02-1979','dd-mm-yyyy'),'1','177','73');                       
INSERT INTO player VALUES ('2001044','오정석','K06','','서경석','2001','MF','13','',TO_DATE('08-09-1978','dd-mm-yyyy'),'1','178','74');                         
INSERT INTO player VALUES ('2002137','이고르','K06','이골 실바 데 페리이따스','이골','2002','MF','21','브라질',TO_DATE('25-10-1979','dd-mm-yyyy'),'1','181','76');                                                                              
INSERT INTO player VALUES ('1997199','이용하','K06','','용식이','1997','MF','26','',TO_DATE('15-12-1973','dd-mm-yyyy'),'2','173','66');                         
INSERT INTO player VALUES ('2002072','전상배','K06','','','2002','MF','14','',TO_DATE('22-03-1979','dd-mm-yyyy'),'1','176','67');                               
INSERT INTO player VALUES ('1999038','전우근','K06','','에너자이져','1999','MF','11','',TO_DATE('25-02-1977','dd-mm-yyyy'),'2','175','68');                     
INSERT INTO player VALUES ('1998365','최태성','K06','','','2001','MF','30','',TO_DATE('16-06-1977','dd-mm-yyyy'),'1','177','64');                               
INSERT INTO player VALUES ('2001047','황철민','K06','','사다리맨','2001','MF','35','',TO_DATE('20-11-1978','dd-mm-yyyy'),'1','175','68');                       
INSERT INTO player VALUES ('1998235','김관규','K06','','','','FW','39','',TO_DATE('10-10-1976','dd-mm-yyyy'),'1','178','71');                                   
INSERT INTO player VALUES ('2001048','김기종','K06','','','2001','FW','25','',TO_DATE('22-05-1975','dd-mm-yyyy'),'1','182','78');                               
INSERT INTO player VALUES ('2002074','김창오','K06','','임땡','2002','FW','27','',TO_DATE('10-01-1978','dd-mm-yyyy'),'1','186','82');                           
INSERT INTO player VALUES ('2002127','디디','K06','Sebastiao Pereira do Nascimento','','2002','FW','8','브라질',TO_DATE('24-02-1976','dd-mm-yyyy'),'1','179','78');                                                                             
INSERT INTO player VALUES ('1997182','마니치','K06','','바람의 아들','1996','FW','9','',TO_DATE('16-01-1972','dd-mm-yyyy'),'2','184','80');                     
INSERT INTO player VALUES ('1997195','우성용','K06','','따따','1996','FW','22','',TO_DATE('18-08-1973','dd-mm-yyyy'),'2','191','76');                           
INSERT INTO player VALUES ('2000103','장기봉','K06','','짝팔','2000','FW','12','',TO_DATE('08-07-1977','dd-mm-yyyy'),'1','180','71');                           
INSERT INTO player VALUES ('2002075','최광수','K06','','','2002','FW','29','',TO_DATE('25-09-1979','dd-mm-yyyy'),'1','177','73');                               
INSERT INTO player VALUES ('2000087','하리','K06','','','2000','FW','10','콜롬비아',TO_DATE('14-05-1974','dd-mm-yyyy'),'1','168','65');                         
INSERT INTO player VALUES ('1900017','정상남','K06','','','1998','FW','32','',TO_DATE('07-09-1975','dd-mm-yyyy'),'2','188','80');                               
INSERT INTO player VALUES ('1900018','빅토르','K06','','빅토르','2001','FW','28','나이지리아',TO_DATE('05-01-1975','dd-mm-yyyy'),'1','183','79');               
INSERT INTO player VALUES ('1900021','최윤겸','K04','CHOI, YOONGYUM','','1985','TM','','',TO_DATE('','dd-mm-yyyy'),'','178','80');                             
INSERT INTO player VALUES ('1900022','하재훈','K04','HA, JAEHON','','1986','TC','','',TO_DATE('','dd-mm-yyyy'),'','174','67');                                 
INSERT INTO player VALUES ('1900023','이충호','K04','LEE, CHUNGHO','','1999','TC','','',TO_DATE('','dd-mm-yyyy'),'','185','83');                               
INSERT INTO player VALUES ('1900024','임기한','K04','LIM, GIHAN','','1994','TC','','',TO_DATE('','dd-mm-yyyy'),'','177','85');                                 
INSERT INTO player VALUES ('1900025','이경태','K04','LEE, KYOUNGTAE','','','TD','','',TO_DATE('','dd-mm-yyyy'),'','','');                                      
INSERT INTO player VALUES ('2002054','남현우','K04','','','','GK','31','',TO_DATE('20-04-1979','dd-mm-yyyy'),'2','180','72');                                   
INSERT INTO player VALUES ('1998499','이충호','K04','','','','GK','60','',TO_DATE('04-07-1968','dd-mm-yyyy'),'2','185','83');                                   
INSERT INTO player VALUES ('2001021','최현','K04','','','','GK','1','',TO_DATE('07-11-1978','dd-mm-yyyy'),'2','192','85');                                      
INSERT INTO player VALUES ('2002052','한동진','K04','','','','GK','21','',TO_DATE('25-08-1979','dd-mm-yyyy'),'2','183','78');                                   
INSERT INTO player VALUES ('2002126','다오','K04','','','','DF','61','',TO_DATE('25-09-1982','dd-mm-yyyy'),'2','190','80');                                     
INSERT INTO player VALUES ('1998182','박철','K04','','','','DF','15','',TO_DATE('20-08-1973','dd-mm-yyyy'),'2','176','77');                                     
INSERT INTO player VALUES ('2000112','송창남','K04','','','','DF','23','',TO_DATE('31-12-1977','dd-mm-yyyy'),'2','175','67');                                   
INSERT INTO player VALUES ('1998424','신승호','K04','','','','DF','2','',TO_DATE('13-05-1975','dd-mm-yyyy'),'2','179','70');                                    
INSERT INTO player VALUES ('1998450','윤중희','K04','','','','DF','5','',TO_DATE('08-12-1975','dd-mm-yyyy'),'1','177','75');                                    
INSERT INTO player VALUES ('2001022','이범직','K04','','','','DF','25','',TO_DATE('11-02-1979','dd-mm-yyyy'),'1','182','75');                                   
INSERT INTO player VALUES ('2002053','이상홍','K04','','','','DF','30','',TO_DATE('04-02-1979','dd-mm-yyyy'),'1','178','68');                                   
INSERT INTO player VALUES ('1900001','이태호','K10','','','','TM','','',TO_DATE('29-01-1961','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900002','김상수','K10','KIM, SAMSOO','','','TC','','',TO_DATE('08-02-1963','dd-mm-yyyy'),'1','','');                               
INSERT INTO player VALUES ('1900003','유동우','K10','YOO, DONGWOO','','','TC','40','',TO_DATE('07-03-1968','dd-mm-yyyy'),'1','177','70');                       
INSERT INTO player VALUES ('1900004','전기현','K10','JEON, GIHYUN','','','TD','','',TO_DATE('06-06-1965','dd-mm-yyyy'),'1','','');                              
INSERT INTO player VALUES ('2002047','강성일','K10','KANG, SUNGIL','','2002','GK','30','',TO_DATE('04-06-1979','dd-mm-yyyy'),'1','182','80');                   
INSERT INTO player VALUES ('2000057','이승준','K10','LEE, SEUNG06','개구멍','2000','GK','1','',TO_DATE('01-09-1972','dd-mm-yyyy'),'1','183','77');             
INSERT INTO player VALUES ('1997298','최은성','K10','CHOI, EUNSUNG','수호천황','1997','GK','21','',TO_DATE('05-04-1971','dd-mm-yyyy'),'1','184','82');          
INSERT INTO player VALUES ('1997312','김대수','K10','KIM, DAESOO','','1997','DF','15','',TO_DATE('20-03-1975','dd-mm-yyyy'),'1','184','74');                    
INSERT INTO player VALUES ('2002051','김민기','K10','','','','DF','3','',TO_DATE('25-04-1978','dd-mm-yyyy'),'1','171','65');                                    
INSERT INTO player VALUES ('2000110','김성근','K10','KIM, SUNGKEUN','','2000','DF','33','',TO_DATE('20-06-1977','dd-mm-yyyy'),'1','180','73');                  
INSERT INTO player VALUES ('2001098','김영근','K10','KIM, YOUNGKWEN','','2001','DF','5','',TO_DATE('12-10-1978','dd-mm-yyyy'),'1','180','70');                                                                                                  
INSERT INTO player VALUES ('1997301','김정수','K10','KIM, 06GSOO','','1977','DF','36','',TO_DATE('17-01-1975','dd-mm-yyyy'),'2','180','74');                   
INSERT INTO player VALUES ('1997309','이창엽','K10','LEE, CHANGYUP','','1997','DF','6','',TO_DATE('19-11-1974','dd-mm-yyyy'),'2','174','64');                   
INSERT INTO player VALUES ('1997299','장철우','K10','01G, CHULWOO','폭주기관차','2000','DF','7','',TO_DATE('01-04-1971','dd-mm-yyyy'),'2','172','65');        
INSERT INTO player VALUES ('2001116','콜리','K10','O03 PAPA COLY','검은낙타(Black Camel)','2001','DF','29','세네갈',TO_DATE('20-05-1975','dd-mm-yyyy'),'1','182','75');                                                                        
INSERT INTO player VALUES ('1997313','홍광철','K10','HONG, KWANGCHUL','','1997','DF','4','',TO_DATE('09-10-1974','dd-mm-yyyy'),'2','172','65');                 
INSERT INTO player VALUES ('1998461','강정훈','K10','KANG, 06GHOON','','1998','MF','38','',TO_DATE('20-02-1976','dd-mm-yyyy'),'1','175','65');                 
INSERT INTO player VALUES ('1997306','공오균','K10','KONG, OHKYUN','CROW','1997','MF','22','',TO_DATE('10-08-1974','dd-mm-yyyy'),'2','177','72');               
INSERT INTO player VALUES ('2002049','김국진','K10','KIM, KOOKJIN','','2002','MF','16','',TO_DATE('09-02-1978','dd-mm-yyyy'),'1','172','62');                   
INSERT INTO player VALUES ('2001099','김동선','K10','KIM, DONGSUN','','2001','MF','9','',TO_DATE('15-03-1978','dd-mm-yyyy'),'1','170','65');                    
INSERT INTO player VALUES ('2000109','박경규','K10','PARK, KUNGGUY','','2000','MF','10','',TO_DATE('10-03-1977','dd-mm-yyyy'),'1','177','72');                  
INSERT INTO player VALUES ('2000111','박내철','K10','PARK, RAECHEOL','','2000','MF','24','',TO_DATE('20-08-1977','dd-mm-yyyy'),'1','177','71');                 
INSERT INTO player VALUES ('2002048','배성재','K10','BAE, SUNGJAE','','2002','MF','28','',TO_DATE('01-07-1979','dd-mm-yyyy'),'1','178','74');                   
INSERT INTO player VALUES ('2002121','샴','K10','','','','MF','25','',TO_DATE('30-04-1979','dd-mm-yyyy'),'1','174','69');                                       
INSERT INTO player VALUES ('2002136','오비나','K10','','','','MF','26','',TO_DATE('03-06-1980','dd-mm-yyyy'),'1','169','70');                                   
INSERT INTO player VALUES ('2000056','이관우','K10','LEE, KWANWOO','SIRIUS','2000','MF','8','',TO_DATE('25-02-1978','dd-mm-yyyy'),'1','175','69');              
INSERT INTO player VALUES ('2002050','이광진','K10','LEE, KWANGJIN','','2002','MF','13','',TO_DATE('27-05-1972','dd-mm-yyyy'),'1','175','75');                  
INSERT INTO player VALUES ('2000113','이상규','K10','LEE, SANGKYU','','2000','MF','27','',TO_DATE('05-09-1977','dd-mm-yyyy'),'1','175','65');                   
INSERT INTO player VALUES ('1999151','임영주','K10','LIM, YOUNGJOO','','1999','MF','23','',TO_DATE('08-03-1976','dd-mm-yyyy'),'2','176','68');                  
INSERT INTO player VALUES ('2001101','정영훈','K10','06G, YOUNGHOON','','2001','MF','12','',TO_DATE('01-05-1975','dd-mm-yyyy'),'1','174','73');                
INSERT INTO player VALUES ('1998178','한정국','K10','HAN, 06GKOOK','','2001','MF','19','',TO_DATE('19-07-1971','dd-mm-yyyy'),'1','179','71');                  
INSERT INTO player VALUES ('2002046','김광선','K10','KIM, KWANGSUN','','2002','FW','32','',TO_DATE('17-06-1983','dd-mm-yyyy'),'1','175','68');                  
INSERT INTO player VALUES ('1997315','김은중','K10','KIM, EUN06G','샤프(SHARP)','1997','FW','18','',TO_DATE('08-04-1979','dd-mm-yyyy'),'2','184','72');        
INSERT INTO player VALUES ('1999152','김찬중','K10','KIM. CHANJOONG','','1999','FW','17','',TO_DATE('14-06-1976','dd-mm-yyyy'),'2','182','72');                 
INSERT INTO player VALUES ('2001032','이석','K10','LEE, SEOK','','2002','FW','20','',TO_DATE('01-02-1979','dd-mm-yyyy'),'1','194','85');                        
INSERT INTO player VALUES ('2001100','탁준석','K10','TAK, 06SUK','','2001','FW','11','',TO_DATE('24-03-1978','dd-mm-yyyy'),'1','178','69');                    
INSERT INTO player VALUES ('1900011','김호곤','K06','','','2000','TM','','',TO_DATE('26-03-1951','dd-mm-yyyy'),'1','172','77');                                 
INSERT INTO player VALUES ('1900012','박경훈','K06','','','','TC','','',TO_DATE('19-01-1961','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900013','김동훈','K06','','','2000','TC','','',TO_DATE('11-06-1965','dd-mm-yyyy'),'1','180','88');                                 
INSERT INTO player VALUES ('1900014','김남표','K06','','','1995','TC','','',TO_DATE('27-01-1964','dd-mm-yyyy'),'2','180','77');                                 
INSERT INTO player VALUES ('1900015','김광재','K06','','','1995','TD','','',TO_DATE('30-05-1968','dd-mm-yyyy'),'2','180','75');                                 
INSERT INTO player VALUES ('1900016','권혁준','K06','','','1996','TD','','',TO_DATE('22-05-1970','dd-mm-yyyy'),'1','173','82');                                 
INSERT INTO player VALUES ('2001052','김경진','K06','','임꺽정','2001','GK','41','',TO_DATE('07-02-1978','dd-mm-yyyy'),'2','186','78');                         
INSERT INTO player VALUES ('2002076','김용대','K06','','','2002','GK','40','',TO_DATE('11-10-1979','dd-mm-yyyy'),'1','189','83');                               
INSERT INTO player VALUES ('2000108','김지혁','K06','','','2000','GK','31','',TO_DATE('22-11-1981','dd-mm-yyyy'),'1','187','77');                               
INSERT INTO player VALUES ('2000059','정유석','K06','','터프가이','2000','GK','1','',TO_DATE('10-06-1977','dd-mm-yyyy'),'2','186','78');                        
INSERT INTO player VALUES ('2001053','김진우','K06','','터프가이','2001','DF','33','',TO_DATE('28-02-1983','dd-mm-yyyy'),'1','180','76');                       
INSERT INTO player VALUES ('1997185','김학철','K06','','','1995','DF','3','',TO_DATE('07-11-1972','dd-mm-yyyy'),'2','176','73');                                
INSERT INTO player VALUES ('1997193','류병훈','K06','','','1995','DF','17','',TO_DATE('03-07-1976','dd-mm-yyyy'),'2','184','68');                               
INSERT INTO player VALUES ('2001055','박준홍','K06','','말머리','2001','DF','2','',TO_DATE('13-04-1978','dd-mm-yyyy'),'1','178','70');                          
INSERT INTO player VALUES ('2001046','서용혁','K06','','터프가이','2001','DF','34','',TO_DATE('02-07-1978','dd-mm-yyyy'),'1','183','79');                       
INSERT INTO player VALUES ('2000058','심재원','K06','','도날드 덕','2000','DF','5','',TO_DATE('11-03-1977','dd-mm-yyyy'),'1','184','77');                       
INSERT INTO player VALUES ('1997123','이임생','K04','','','','DF','20','',TO_DATE('17-11-1971','dd-mm-yyyy'),'1','183','80');                                   
INSERT INTO player VALUES ('1997022','장형석','K04','','','','DF','36','',TO_DATE('07-07-1972','dd-mm-yyyy'),'1','181','72');                                   
INSERT INTO player VALUES ('2002058','정진성','K04','','','','DF','35','',TO_DATE('10-08-1983','dd-mm-yyyy'),'1','184','76');                                   
INSERT INTO player VALUES ('1999125','최거룩','K04','','','','DF','4','',TO_DATE('26-06-1976','dd-mm-yyyy'),'1','183','77');                                    
INSERT INTO player VALUES ('2000001','최정민','K04','','','','DF','3','',TO_DATE('07-10-1977','dd-mm-yyyy'),'1','183','78');                                    
INSERT INTO player VALUES ('2002134','페르난도','K04','','','','DF','44','',TO_DATE('24-02-1978','dd-mm-yyyy'),'1','178','74');                                 
INSERT INTO player VALUES ('1900094','조무건','K03','CHO, MUGYUN','','','TC','','',TO_DATE('18-03-1961','dd-mm-yyyy'),'1','','');                               
INSERT INTO player VALUES ('1997001','김병지','K03','KIM, BYUNGJI','','2001','GK','1','',TO_DATE('08-04-1970','dd-mm-yyyy'),'1','184','77');                    
INSERT INTO player VALUES ('2001069','박주호','K03','PARK, JUHO','','2001','GK','51','',TO_DATE('16-07-1982','dd-mm-yyyy'),'1','185','75');                                                                                                     
INSERT INTO player VALUES ('1997130','이대희','K03','LEE, DAEHEE','','2000','GK','31','',TO_DATE('26-04-1974','dd-mm-yyyy'),'1','192','88');                    
INSERT INTO player VALUES ('1999133','조준호','K03','CHO, 06HO','','1999','GK','21','',TO_DATE('28-04-1973','dd-mm-yyyy'),'1','185','77');                     
INSERT INTO player VALUES ('2001065','허인무','K03','HEO, INMOO','','2001','GK','41','',TO_DATE('14-04-1978','dd-mm-yyyy'),'1','187','81');                     
INSERT INTO player VALUES ('2001056','강용','K03','KANG, YONG','','2001','DF','2','',TO_DATE('14-01-1979','dd-mm-yyyy'),'1','179','72');                        
INSERT INTO player VALUES ('1997080','고병운','K03','GO, BYUNGWOON','','1996','DF','16','',TO_DATE('28-09-1973','dd-mm-yyyy'),'1','180','73');                  
INSERT INTO player VALUES ('2002069','김광석','K03','KIM, KWANGSUK','','2002','DF','39','',TO_DATE('12-02-1983','dd-mm-yyyy'),'1','183','72');                  
INSERT INTO player VALUES ('1997002','김상훈','K03','KIM, SANGHUN','','1996','DF','13','',TO_DATE('08-06-1973','dd-mm-yyyy'),'1','183','76');                   
INSERT INTO player VALUES ('2002062','김석우','K03','KIM, SEOKWOO','','2002','DF','32','',TO_DATE('06-05-1983','dd-mm-yyyy'),'1','181','72');                   
INSERT INTO player VALUES ('1999139','김은석','K03','KIM, EUNSEOK','','1999','DF','5','',TO_DATE('14-03-1972','dd-mm-yyyy'),'1','185','80');                    
INSERT INTO player VALUES ('1999030','박민서','K03','PARK, MINSEO','','1999','DF','3','',TO_DATE('24-08-1976','dd-mm-yyyy'),'2','180','78');                    
INSERT INTO player VALUES ('2002064','성종현','K03','SUNG, JONGHUN','','2002','DF','34','',TO_DATE('02-04-1979','dd-mm-yyyy'),'1','178','74');                  
INSERT INTO player VALUES ('1998468','싸빅','K03','Jasenko Sabitovic%','','1997','DF','4','',TO_DATE('29-03-1973','dd-mm-yyyy'),'1','185','78');                 
INSERT INTO player VALUES ('1997277','오명관','K03','OH, MYUNGKWAN','','1998','DF','15','',TO_DATE('29-04-1974','dd-mm-yyyy'),'1','185','76');                  
INSERT INTO player VALUES ('2002063','이동식','K03','LEE, DONGSIK','','2002','MF','33','',TO_DATE('15-03-1979','dd-mm-yyyy'),'1','183','77');                   
INSERT INTO player VALUES ('2002067','이수길','K03','LEE, SOOKIL','','2002','DF','37','',TO_DATE('09-04-1979','dd-mm-yyyy'),'1','179','69');                    
INSERT INTO player VALUES ('1998444','이승엽','K03','LEE, SEUNGYUB','','1998','DF','12','',TO_DATE('12-10-1975','dd-mm-yyyy'),'1','180','74');                  
INSERT INTO player VALUES ('1997101','조종화','K03','','','','DF','25','',TO_DATE('04-04-1974','dd-mm-yyyy'),'1','182','76');                                   
INSERT INTO player VALUES ('1997190','하석주','K03','HA, SEOKJU','','2001','DF','17','',TO_DATE('20-02-1968','dd-mm-yyyy'),'1','174','71');                     
INSERT INTO player VALUES ('2000065','허제정','K03','HEO, JAE06G','','2000','DF','29','',TO_DATE('02-06-1977','dd-mm-yyyy'),'1','175','70');                   
INSERT INTO player VALUES ('1997096','홍명보','K03','HONG, MYUNGBO','','2002','DF','20','',TO_DATE('12-02-1969','dd-mm-yyyy'),'1','181','72');                  
INSERT INTO player VALUES ('1998472','김기남','K03','KIM, KINAM','','2000','MF','6','',TO_DATE('18-01-1971','dd-mm-yyyy'),'1','174','72');                      
INSERT INTO player VALUES ('2001059','김상록','K03','KIM, SANGROK','','2001','MF','14','',TO_DATE('25-02-1979','dd-mm-yyyy'),'1','173','63');                   
INSERT INTO player VALUES ('2001068','나희근','K03','NA, HEEKEUN','','2001','FW','22','',TO_DATE('05-05-1979','dd-mm-yyyy'),'1','178','72');                    
INSERT INTO player VALUES ('2002133','레오','K03','','','','MF','45','',TO_DATE('22-10-1974','dd-mm-yyyy'),'1','179','74');                                     
INSERT INTO player VALUES ('2002124','메도','K03','Medvid Ivan','','2002','MF','44','',TO_DATE('13-10-1977','dd-mm-yyyy'),'1','180','78');                      
INSERT INTO player VALUES ('2002068','박길영','K03','PARK, KILYOUNG','','2002','MF','38','',TO_DATE('04-02-1980','dd-mm-yyyy'),'1','172','64');                 
INSERT INTO player VALUES ('1998203','박상인','K03','PARK, SANGIN','','1995','DF','27','',TO_DATE('10-03-1976','dd-mm-yyyy'),'1','174','63');                   
INSERT INTO player VALUES ('2001131','옐라','K03','Josko Jelicic','','2002','MF','8','',TO_DATE('05-01-1971','dd-mm-yyyy'),'1','184','79');                     
INSERT INTO player VALUES ('2001061','유현구','K03','YOU, HYUNGOO','','2001','MF','26','',TO_DATE('25-01-1983','dd-mm-yyyy'),'1','170','68');                   
INSERT INTO player VALUES ('1999033','이기부','K03','LEE, KIBU','','1999','MF','18','',TO_DATE('16-03-1976','dd-mm-yyyy'),'2','183','76');                      
INSERT INTO player VALUES ('2002070','이상인','K03','LEE, SANGIN','','2002','DF','40','',TO_DATE('11-07-1979','dd-mm-yyyy'),'1','178','70');                    
INSERT INTO player VALUES ('2001062','이정운','K03','LEE, 06GWOON','','2001','MF','19','',TO_DATE('19-04-1978','dd-mm-yyyy'),'1','178','70');                  
INSERT INTO player VALUES ('2002071','이중규','K03','LEE, 06GJYU','','2002','MF','42','',TO_DATE('06-06-1979','dd-mm-yyyy'),'1','170','64');                   
INSERT INTO player VALUES ('2002066','이창호','K03','LEE, CHANGHO','','2002','MF','36','',TO_DATE('15-03-1981','dd-mm-yyyy'),'1','175','75');                   
INSERT INTO player VALUES ('2001063','최종범','K03','CHOI, JONGBUM','','2001','MF','24','',TO_DATE('27-03-1978','dd-mm-yyyy'),'1','178','68');                  
INSERT INTO player VALUES ('2002061','남익경','K03','NAM, IKKYUNG','','2002','MF','30','',TO_DATE('26-01-1983','dd-mm-yyyy'),'1','177','70');                   
INSERT INTO player VALUES ('2001064','윤보영','K03','YOON, BOYOUNG','','2001','FW','23','',TO_DATE('29-04-1978','dd-mm-yyyy'),'1','177','63');                  
INSERT INTO player VALUES ('1998443','이동국','K03','LEE, DONGGOOK','','1998','FW','10','',TO_DATE('29-04-1979','dd-mm-yyyy'),'1','185','80');                  
INSERT INTO player VALUES ('2002060','정종완','K03','06G, JONGWAN','','2002','DF','28','',TO_DATE('05-08-1983','dd-mm-yyyy'),'1','188','82');                  
INSERT INTO player VALUES ('2002059','조징요','K03','Jorge Claudio','','2001','FW','7','브라질',TO_DATE('01-10-1975','dd-mm-yyyy'),'1','174','70');             
INSERT INTO player VALUES ('2000044','최철우','K03','CHOI, CHULWOO','','2000','FW','9','',TO_DATE('30-11-1977','dd-mm-yyyy'),'1','185','78');                   
INSERT INTO player VALUES ('2001057','코난','K03','Goram Petreski','','2000','FW','11','',TO_DATE('23-05-1972','dd-mm-yyyy'),'1','180','76');                                                                                                   
INSERT INTO player VALUES ('1900095','김민규','K03','KIM, MINJYU','','2002','MF','35','',TO_DATE('29-09-1979','dd-mm-yyyy'),'1','178','71');                    
INSERT INTO player VALUES ('1900062','제형진','K01','JAE, HYUNGJIN','','2002','DF','38','',TO_DATE('25-06-1979','dd-mm-yyyy'),'1','179','75');                  
INSERT INTO player VALUES ('1900063','곽기훈','K01','KWAK, KIHOON','','2002','FW','33','',TO_DATE('05-11-1979','dd-mm-yyyy'),'1','177','72');                   
INSERT INTO player VALUES ('1900064','박민영','K01','PARK, MINYOUNG','','2000','FW','37','',TO_DATE('07-03-1981','dd-mm-yyyy'),'1','174','67');                 
INSERT INTO player VALUES ('1900071','이회택','K07','','','','TM','','',TO_DATE('11-10-1946','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900072','서현옥','K07','','','','TC','','',TO_DATE('27-10-1949','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900073','김상호','K07','','','','TC','','',TO_DATE('05-10-1964','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900074','박철우','K07','','','','TC','','',TO_DATE('29-09-1965','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('2002081','김영광','K07','','','','GK','41','',TO_DATE('28-06-1983','dd-mm-yyyy'),'1','185','80');                                   
INSERT INTO player VALUES ('1997227','박종문','K07','','','','GK','1','',TO_DATE('02-10-1970','dd-mm-yyyy'),'1','185','76');                                    
INSERT INTO player VALUES ('2002088','염동균','K07','','','','GK','31','',TO_DATE('06-09-1983','dd-mm-yyyy'),'1','189','83');                                   
INSERT INTO player VALUES ('2002089','이정래','K07','','','','GK','33','',TO_DATE('12-11-1979','dd-mm-yyyy'),'1','185','81');                                   
INSERT INTO player VALUES ('1998212','강철','K07','','','','DF','3','',TO_DATE('02-11-1971','dd-mm-yyyy'),'1','178','72');                                      
INSERT INTO player VALUES ('2002077','김강선','K07','','','','DF','37','',TO_DATE('23-05-1979','dd-mm-yyyy'),'1','180','73');                                   
INSERT INTO player VALUES ('2002083','김인호','K07','','','','DF','39','',TO_DATE('09-06-1983','dd-mm-yyyy'),'1','184','79');                                   
INSERT INTO player VALUES ('1997213','김태영','K07','','','','DF','7','',TO_DATE('08-11-1970','dd-mm-yyyy'),'1','180','74');                                    
INSERT INTO player VALUES ('1997209','김현수','K07','','','','DF','21','',TO_DATE('14-02-1973','dd-mm-yyyy'),'1','176','74');                                   
INSERT INTO player VALUES ('2002084','김형주','K07','','','','DF','42','',TO_DATE('23-06-1979','dd-mm-yyyy'),'1','','');                                        
INSERT INTO player VALUES ('2002085','김홍철','K07','','','','DF','36','',TO_DATE('02-06-1979','dd-mm-yyyy'),'1','181','69');                                   
INSERT INTO player VALUES ('1998359','마시엘','K07','','','','DF','24','',TO_DATE('15-03-1972','dd-mm-yyyy'),'1','177','70');                                   
INSERT INTO player VALUES ('2001034','이창원','K07','','','','DF','5','',TO_DATE('10-07-1975','dd-mm-yyyy'),'1','183','75');                                    
INSERT INTO player VALUES ('2002090','장경진','K07','','','','DF','34','',TO_DATE('31-08-1983','dd-mm-yyyy'),'1','184','82');                                   
INSERT INTO player VALUES ('1998425','주영호','K07','','','','DF','6','',TO_DATE('24-10-1975','dd-mm-yyyy'),'1','185','80');                                    
INSERT INTO player VALUES ('2002092','홍성요','K07','','','','DF','28','',TO_DATE('26-05-1979','dd-mm-yyyy'),'1','184','78');                                   
INSERT INTO player VALUES ('1999115','김경일','K07','','','','MF','49','',TO_DATE('30-08-1980','dd-mm-yyyy'),'1','170','65');                                   
INSERT INTO player VALUES ('2001035','김길식','K07','','','','MF','12','',TO_DATE('24-08-1978','dd-mm-yyyy'),'1','178','72');                                   
INSERT INTO player VALUES ('2000030','김남일','K07','','','','MF','4','',TO_DATE('14-03-1977','dd-mm-yyyy'),'1','182','76');                                    
INSERT INTO player VALUES ('2000032','김대욱','K07','','','','MF','18','',TO_DATE('02-04-1978','dd-mm-yyyy'),'1','182','73');                                   
INSERT INTO player VALUES ('1997210','김도근','K07','','','','MF','10','',TO_DATE('02-03-1972','dd-mm-yyyy'),'2','181','69');                                   
INSERT INTO player VALUES ('2002078','김동희','K07','','','','MF','38','',TO_DATE('06-05-1983','dd-mm-yyyy'),'1','174','64');                                   
INSERT INTO player VALUES ('1997102','김명곤','K07','','','','MF','2','',TO_DATE('15-04-1974','dd-mm-yyyy'),'1','177','73');                                    
INSERT INTO player VALUES ('2002079','김성진','K07','','','','MF','44','',TO_DATE('20-01-1979','dd-mm-yyyy'),'1','178','68');                                   
INSERT INTO player VALUES ('2002080','김승현','K07','','','','MF','26','',TO_DATE('17-08-1979','dd-mm-yyyy'),'1','181','71');                                   
INSERT INTO player VALUES ('2002082','김요환','K07','','','','MF','25','',TO_DATE('23-05-1977','dd-mm-yyyy'),'1','170','62');                                   
INSERT INTO player VALUES ('1999100','김정겸','K07','','','','MF','13','',TO_DATE('09-06-1976','dd-mm-yyyy'),'2','172','65');                                   
INSERT INTO player VALUES ('1998428','김종현','K07','','','','MF','11','',TO_DATE('10-07-1973','dd-mm-yyyy'),'1','173','68');                                   
INSERT INTO player VALUES ('2002086','노병준','K07','','','','MF','22','',TO_DATE('29-09-1979','dd-mm-yyyy'),'1','177','67');                                   
INSERT INTO player VALUES ('2002087','박종우','K07','','','','MF','43','',TO_DATE('11-04-1979','dd-mm-yyyy'),'1','176','69');                                   
INSERT INTO player VALUES ('1997305','신진원','K07','','','','MF','9','',TO_DATE('27-09-1974','dd-mm-yyyy'),'1','176','75');                                    
INSERT INTO player VALUES ('2002132','실바','K07','','','','MF','45','',TO_DATE('20-06-1977','dd-mm-yyyy'),'1','173','67');                                     
INSERT INTO player VALUES ('2000031','윤용구','K07','','','','MF','15','',TO_DATE('08-08-1977','dd-mm-yyyy'),'1','168','60');                                   
INSERT INTO player VALUES ('2001127','이반','K07','','','','MF','14','',TO_DATE('27-10-1974','dd-mm-yyyy'),'1','174','69');                                     
INSERT INTO player VALUES ('2001038','이영수','K07','','','','MF','30','',TO_DATE('30-07-1978','dd-mm-yyyy'),'1','175','65');                                   
INSERT INTO player VALUES ('1998423','임관식','K07','','','','MF','29','',TO_DATE('28-07-1975','dd-mm-yyyy'),'1','172','68');                                   
INSERT INTO player VALUES ('2001036','최정호','K07','','','','MF','23','',TO_DATE('06-04-1978','dd-mm-yyyy'),'1','176','71');                                   
INSERT INTO player VALUES ('2001039','하기윤','K07','','','','MF','32','',TO_DATE('10-03-1982','dd-mm-yyyy'),'1','180','65');                                   
INSERT INTO player VALUES ('2000003','김대철','K07','','','','FW','20','',TO_DATE('26-08-1977','dd-mm-yyyy'),'1','183','78');                                   
INSERT INTO player VALUES ('2000154','꼬레아','K07','','','','FW','16','',TO_DATE('23-08-74','dd-mm-yyyy'),'1','172','70');                                   
INSERT INTO player VALUES ('1997214','노상래','K07','','','','FW','8','',TO_DATE('15-12-1970','dd-mm-yyyy'),'1','175','74');                                    
INSERT INTO player VALUES ('1999149','성한수','K07','','','','FW','40','',TO_DATE('10-03-1976','dd-mm-yyyy'),'2','177','69');                                   
INSERT INTO player VALUES ('1999161','세자르','K07','','','','FW','17','',TO_DATE('09-12-1973','dd-mm-yyyy'),'1','180','78');                                   
INSERT INTO player VALUES ('2002032','신병호','K07','','','','FW','27','',TO_DATE('26-04-1977','dd-mm-yyyy'),'1','177','75');                                   
INSERT INTO player VALUES ('2001120','찌코','K07','','','','FW','27','',TO_DATE('26-01-1975','dd-mm-yyyy'),'1','180','67');                                     
INSERT INTO player VALUES ('2000037','하성룡','K07','','','','FW','35','',TO_DATE('03-02-1982','dd-mm-yyyy'),'1','179','68');                                   
INSERT INTO player VALUES ('2002091','홍복표','K07','','','','FW','19','',TO_DATE('28-10-1979','dd-mm-yyyy'),'1','182','73');                                   
INSERT INTO player VALUES ('1900081','조윤환','K05','','','','TM','','',TO_DATE('24-05-1961','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900082','김은철','K05','','','','TC','','',TO_DATE('26-05-1958','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900083','이경춘','K05','','','','TC','','',TO_DATE('14-04-1969','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900084','박동우','K05','','','','TC','','',TO_DATE('03-11-1970','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900085','전명구','K05','','','','TD','','',TO_DATE('16-03-1969','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900086','정경치','K05','','','','TD','','',TO_DATE('06-01-1969','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1997106','김이섭','K05','KIM, ISUB','쾌남','2002','GK','45','',TO_DATE('06-04-1974','dd-mm-yyyy'),'1','185','78');                  
INSERT INTO player VALUES ('2002007','박관민','K05','PARK, KWANMIN','','2002','GK','31','',TO_DATE('26-05-1979','dd-mm-yyyy'),'1','188','85');                  
INSERT INTO player VALUES ('1998179','박동우','K05','','','','GK','60','',TO_DATE('03-11-1970','dd-mm-yyyy'),'1','187','78');                                   
INSERT INTO player VALUES ('1998138','이용발','K05','LEE, YONGBAL','','1994','GK','18','',TO_DATE('15-03-1973','dd-mm-yyyy'),'1','183','77');                   
INSERT INTO player VALUES ('2002006','이창민','K05','LEE, CHANGMIN','고릴라','2002','GK','1','',TO_DATE('25-01-1980','dd-mm-yyyy'),'1','191','87');             
INSERT INTO player VALUES ('2000010','김대건','K05','KIM, DAEKEON','','2000','DF','26','',TO_DATE('27-04-1977','dd-mm-yyyy'),'1','183','78');                   
INSERT INTO player VALUES ('1997159','김봉현','K05','KIM, BONGHYUN','','1995','MF','23','',TO_DATE('07-07-1974','dd-mm-yyyy'),'1','188','74');                  
INSERT INTO player VALUES ('2002009','김창민','K05','KIM, CHANGMIN','야생마','2002','DF','36','',TO_DATE('22-09-1979','dd-mm-yyyy'),'1','181','68');            
INSERT INTO player VALUES ('2002005','박동혁','K05','PARK, DONGHYUK','백호','2002','DF','23','',TO_DATE('18-04-1979','dd-mm-yyyy'),'1','185','78');             
INSERT INTO player VALUES ('2002012','백인석','K05','BAEK, INSEOK','떡맨','2002','MF','40','',TO_DATE('08-08-1979','dd-mm-yyyy'),'1','179','72');               
INSERT INTO player VALUES ('1998391','서혁수','K05','SEO, HYUKSU','맷돌','1998','DF','6','',TO_DATE('01-10-1973','dd-mm-yyyy'),'1','178','77');                 
INSERT INTO player VALUES ('2002004','안광호','K05','AN, KWANGHO','왕깡','2002','DF','15','',TO_DATE('10-01-1979','dd-mm-yyyy'),'1','190','78');                
INSERT INTO player VALUES ('1999076','임종훈','K05','LIM, HONGHUN','꺼시','1999','DF','31','',TO_DATE('14-06-1976','dd-mm-yyyy'),'1','182','74');               
INSERT INTO player VALUES ('1997148','최진철','K05','CHOI, JINCHEUL','','1996','DF','4','',TO_DATE('26-03-1971','dd-mm-yyyy'),'1','187','75');                  
INSERT INTO player VALUES ('1999061','한종성','K05','HAN, JONGSUNG','','1999','DF','13','',TO_DATE('30-01-1977','dd-mm-yyyy'),'1','177','70');                  
INSERT INTO player VALUES ('1999160','호제리오','K05','Rogerio Prateat','저승사자','1999','DF','3','',TO_DATE('09-03-1973','dd-mm-yyyy'),'1','185','85');      
INSERT INTO player VALUES ('1997031','황승주','K05','','','','DF','98','',TO_DATE('09-05-1972','dd-mm-yyyy'),'1','176','68');                                   
INSERT INTO player VALUES ('2000023','고관영','K05','KO, KWANYOUNG','까우','2000','MF','32','',TO_DATE('07-12-1981','dd-mm-yyyy'),'1','180','72');              
INSERT INTO player VALUES ('1997155','김경량','K05','KIM, KYUNGRYANG','','1996','MF','19','',TO_DATE('22-12-1973','dd-mm-yyyy'),'1','173','65');                
INSERT INTO player VALUES ('2000025','김은익','K05','','','','MF','35','',TO_DATE('09-03-1981','dd-mm-yyyy'),'1','176','63');                                   
INSERT INTO player VALUES ('2002001','레오마르','K05','Leo03 Leiria','레오','2002','MF','5','',TO_DATE('26-06-1971','dd-mm-yyyy'),'1','183','77');             
INSERT INTO player VALUES ('1998269','명재용','K05','MYUNG, JAEYOENG','','1997','MF','7','',TO_DATE('26-02-1973','dd-mm-yyyy'),'2','173','63');                 
INSERT INTO player VALUES ('1997149','변재섭','K05','BYUN, JAESUB','작은탱크','1997','MF','11','',TO_DATE('17-09-1975','dd-mm-yyyy'),'2','170','63');           
INSERT INTO player VALUES ('2002002','보띠','K05','Raphael JoseBotti Zacarias Sena','Botti','2002','MF','10','',TO_DATE('23-02-1981','dd-mm-yyyy'),'1','174','68');                                                                             
INSERT INTO player VALUES ('2001123','비에라','K05','Vieira','','2001','MF','21','',TO_DATE('25-02-1974','dd-mm-yyyy'),'1','176','73');                         
INSERT INTO player VALUES ('1998460','서동원','K05','SEO, DONGWON','','1998','MF','22','',TO_DATE('14-08-1975','dd-mm-yyyy'),'1','184','78');                   
INSERT INTO player VALUES ('2000019','안대현','K05','AN, DAEHYUN','','2000','MF','25','',TO_DATE('20-08-1977','dd-mm-yyyy'),'1','179','72');                    
INSERT INTO player VALUES ('2000018','양현정','K05','YANG, HYUN06G','','2000','MF','14','',TO_DATE('25-07-1977','dd-mm-yyyy'),'1','176','72');                 
INSERT INTO player VALUES ('2000022','유원섭','K05','YOU, WONSUOB','앙마','2000','MF','37','',TO_DATE('24-05-1981','dd-mm-yyyy'),'1','180','77');               
INSERT INTO player VALUES ('2002008','이수철','K05','LEE, SUCHEUL','','2002','MF','34','',TO_DATE('26-05-1979','dd-mm-yyyy'),'1','171','68');                   
INSERT INTO player VALUES ('2002013','임다한','K05','LIM, DAHAN','달마','2002','DF','39','',TO_DATE('21-07-1979','dd-mm-yyyy'),'1','181','67');                 
INSERT INTO player VALUES ('1997087','전경준','K05','JEON, KYOUNGJOON','','1991','MF','16','',TO_DATE('10-09-1973','dd-mm-yyyy'),'1','178','68');               
INSERT INTO player VALUES ('2000021','최영훈','K05','CHOI, YOUNGHOON','깐돌이','2000','MF','27','',TO_DATE('18-03-1981','dd-mm-yyyy'),'1','178','71');          
INSERT INTO player VALUES ('2001028','추운기','K05','CHOO, WOONKI','코알라','2001','MF','17','',TO_DATE('03-04-1978','dd-mm-yyyy'),'1','173','69');             
INSERT INTO player VALUES ('1998393','하은철','K05','HA, EUNCHEUL','','1998','MF','29','',TO_DATE('23-06-1975','dd-mm-yyyy'),'1','176','69');                   
INSERT INTO player VALUES ('2001030','고민기','K05','GO, MINGI','','2001','FW','24','',TO_DATE('01-07-1978','dd-mm-yyyy'),'1','178','70');                      
INSERT INTO player VALUES ('1998143','김도훈','K05','KIM, DOHOON','폭격기','1995','FW','9','',TO_DATE('21-07-1970','dd-mm-yyyy'),'1','182','77');               
INSERT INTO player VALUES ('2002011','김연건','K05','KIM, YEONGUN','','2002','FW','44','',TO_DATE('12-03-1981','dd-mm-yyyy'),'1','188','77');                   
INSERT INTO player VALUES ('2001002','김현기','K05','KIM, HYUNKI','','2001','FW','28','',TO_DATE('19-03-1982','dd-mm-yyyy'),'1','190','82');                    
INSERT INTO player VALUES ('2001003','남궁도','K05','NAM, KUNGDO','','2001','FW','33','',TO_DATE('04-06-1982','dd-mm-yyyy'),'1','186','80');                    
INSERT INTO player VALUES ('2000101','문태혁','K05','MOON, TAEHYUK','','2002','FW','41','',TO_DATE('31-03-1983','dd-mm-yyyy'),'1','178','74');                  
INSERT INTO player VALUES ('1998392','박성배','K05','PARK, SUNGBAE','흑상어','1998','FW','8','',TO_DATE('28-11-1975','dd-mm-yyyy'),'2','181','76');             
INSERT INTO player VALUES ('2002125','에드밀손','K05','Edmilson','EDY','2002','FW','20','',TO_DATE('29-05-1968','dd-mm-yyyy'),'1','184','79');                  
INSERT INTO player VALUES ('2002003','쿠키','K05','','','','FW','99','',TO_DATE('30-04-1971','dd-mm-yyyy'),'1','170','76');                                     
INSERT INTO player VALUES ('1900087','김은익','K05','KIM, EUNIK','','2000','FW','35','',TO_DATE('09-03-1981','dd-mm-yyyy'),'1','176','65');                     
INSERT INTO player VALUES ('1900091','최순호','K03','CHOI, SOONHO','','','TM','','',TO_DATE('10-01-1962','dd-mm-yyyy'),'1','','');                              
INSERT INTO player VALUES ('1900092','유동관','K03','YU, DONGKWAN','','','TC','','',TO_DATE('12-05-1963','dd-mm-yyyy'),'1','','');                              
INSERT INTO player VALUES ('1900093','정기동','K03','CHUNG, GIDONG','','','TC','','',TO_DATE('13-05-1961','dd-mm-yyyy'),'1','','');                             
INSERT INTO player VALUES ('2001111','이반코비','K02','','','','MF','47','',TO_DATE('08-02-1975','dd-mm-yyyy'),'1','185','78');                                 
INSERT INTO player VALUES ('2002020','이선우','K02','LEE, SUNWOO','','','FW','33','',TO_DATE('01-04-1978','dd-mm-yyyy'),'1','174','68');                        
INSERT INTO player VALUES ('2001074','이여성','K02','LEE, YEOSUNG','','','MF','36','',TO_DATE('05-01-1983','dd-mm-yyyy'),'1','179','63');                       
INSERT INTO player VALUES ('1997064','이용우','K02','LEE, YONGWOO','','','FW','27','',TO_DATE('20-07-1977','dd-mm-yyyy'),'1','175','70');                       
INSERT INTO player VALUES ('2002019','이종민','K02','LEE, JONGMIN','','','MF','30','',TO_DATE('01-09-1983','dd-mm-yyyy'),'1','174','65');                       
INSERT INTO player VALUES ('1998437','정용훈','K02','06G, YONGHOON','','','MF','9','',TO_DATE('11-03-1979','dd-mm-yyyy'),'1','175','67');                      
INSERT INTO player VALUES ('1998436','조만근','K02','CHO, MANKEUN','','','FW','34','',TO_DATE('28-11-1977','dd-mm-yyyy'),'1','177','67');                       
INSERT INTO player VALUES ('1997070','조재민','K02','CHO, JAEMIN','','','MF','35','',TO_DATE('22-05-1978','dd-mm-yyyy'),'1','180','71');                        
INSERT INTO player VALUES ('1997043','조현두','K02','CHO, HYUNDOO','','','MF','12','',TO_DATE('23-11-1973','dd-mm-yyyy'),'1','176','68');                       
INSERT INTO player VALUES ('2002017','최성용','K02','CHOI, SUNGYONG','','','DF','20','',TO_DATE('25-12-1975','dd-mm-yyyy'),'1','173','70');                     
INSERT INTO player VALUES ('2002018','하태근','K02','HA, TAEKEUN','','','MF','29','',TO_DATE('01-07-1983','dd-mm-yyyy'),'1','182','75');                        
INSERT INTO player VALUES ('2002122','미트로','K02','Mitrovic Slavisa','','','FW','19','보스니아',TO_DATE('05-07-1977','dd-mm-yyyy'),'1','192','89');           
INSERT INTO player VALUES ('1997048','박건하','K02','PARK, KUNHA','','','FW','18','',TO_DATE('25-07-1971','dd-mm-yyyy'),'1','180','75');                        
INSERT INTO player VALUES ('2000168','산드로','K02','Sandro Cardoso Dos Santos','','','FW','13','브라질',TO_DATE('22-03-1980','dd-mm-yyyy'),'1','182','78');    
INSERT INTO player VALUES ('2002023','윤화평','K02','YUN, HWAPYUNG','','','FW','42','',TO_DATE('26-03-1983','dd-mm-yyyy'),'1','182','74');                      
INSERT INTO player VALUES ('2002022','이관희','K02','LEE, KWANHEE','','','FW','39','',TO_DATE('29-06-1983','dd-mm-yyyy'),'1','180','70');                       
INSERT INTO player VALUES ('1900051','조광래','K09','','','','TM','','',TO_DATE('19-03-1954','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900052','이춘석','K09','','','','TC','','',TO_DATE('03-02-1959','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900053','신재흠','K09','','','','TC','','',TO_DATE('26-03-1959','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900054','이영진','K09','','','','TC','','',TO_DATE('27-10-1963','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('1900055','김귀화','K09','','','','TC','','',TO_DATE('15-03-1970','dd-mm-yyyy'),'1','','');                                          
INSERT INTO player VALUES ('2002094','박동석','K09','','','','GK','1','',TO_DATE('03-05-1981','dd-mm-yyyy'),'1','190','89');                                    
INSERT INTO player VALUES ('2000125','백민철','K09','','','','GK','21','',TO_DATE('28-07-1977','dd-mm-yyyy'),'1','185','78');                                   
INSERT INTO player VALUES ('1997236','신의손','K09','','','','GK','44','',TO_DATE('12-01-1960','dd-mm-yyyy'),'1','192','87');                                   
INSERT INTO player VALUES ('2001018','우태식','K09','','','','GK','31','',TO_DATE('08-01-1983','dd-mm-yyyy'),'1','185','75');                                   
INSERT INTO player VALUES ('2000117','김동진','K09','','','','DF','4','',TO_DATE('29-01-1981','dd-mm-yyyy'),'1','182','74');                                    
INSERT INTO player VALUES ('1998414','김성일','K09','','','','DF','19','',TO_DATE('13-04-1974','dd-mm-yyyy'),'1','178','75');                                   
INSERT INTO player VALUES ('2002093','김치곤','K09','','','','DF','17','',TO_DATE('29-07-1983','dd-mm-yyyy'),'1','183','76');                                   
INSERT INTO player VALUES ('2002095','박요셉','K09','','','','DF','5','',TO_DATE('03-12-1980','dd-mm-yyyy'),'1','183','75');                                    
INSERT INTO player VALUES ('2000119','박용호','K09','','','','DF','14','',TO_DATE('25-03-1981','dd-mm-yyyy'),'1','182','69');                                   
INSERT INTO player VALUES ('1997068','박정석','K09','','','','DF','6','',TO_DATE('19-04-1977','dd-mm-yyyy'),'1','182','78');                                    
INSERT INTO player VALUES ('1997266','손현준','K09','','','','DF','45','',TO_DATE('20-03-1972','dd-mm-yyyy'),'1','175','70');                                   
INSERT INTO player VALUES ('2001012','안성훈','K09','','','','MF','2','',TO_DATE('11-09-1982','dd-mm-yyyy'),'1','176','63');                                    
INSERT INTO player VALUES ('1998420','이상헌','K09','','','','DF','25','',TO_DATE('11-10-1975','dd-mm-yyyy'),'2','185','80');                                   
INSERT INTO player VALUES ('2002102','정성호','K09','','','','DF','34','',TO_DATE('07-04-1986','dd-mm-yyyy'),'1','184','71');                                   
INSERT INTO player VALUES ('1997225','최윤열','K09','','','','DF','3','',TO_DATE('17-04-1974','dd-mm-yyyy'),'1','185','79');                                    
INSERT INTO player VALUES ('1999048','김도용','K09','','','','MF','40','',TO_DATE('28-05-1976','dd-mm-yyyy'),'1','168','68');                                   
INSERT INTO player VALUES ('2001072','김민성','K09','','','','MF','24','',TO_DATE('28-05-1982','dd-mm-yyyy'),'1','175','64');                                   
INSERT INTO player VALUES ('2001008','신재필','K09','','','','MF','41','',TO_DATE('25-05-1982','dd-mm-yyyy'),'1','180','70');                                   
INSERT INTO player VALUES ('2002096','신현국','K09','','','','MF','37','',TO_DATE('21-03-1983','dd-mm-yyyy'),'1','172','65');                                   
INSERT INTO player VALUES ('2000049','안드레','K09','','','','MF','18','브라질',TO_DATE('16-11-1972','dd-mm-yyyy'),'1','172','69');                             
INSERT INTO player VALUES ('2002097','안상현','K09','','','','MF','33','',TO_DATE('05-03-1986','dd-mm-yyyy'),'1','176','67');                                   
INSERT INTO player VALUES ('2002098','우진석','K09','','','','MF','39','',TO_DATE('26-08-1979','dd-mm-yyyy'),'1','176','70');                                                                                                                   
INSERT INTO player VALUES ('1997133','유상수','K09','','','','MF','43','',TO_DATE('28-08-1973','dd-mm-yyyy'),'2','175','67');                                   
INSERT INTO player VALUES ('2000048','이영표','K09','','','','MF','12','',TO_DATE('23-04-1977','dd-mm-yyyy'),'1','176','66');                                   
INSERT INTO player VALUES ('2002100','이준기','K09','','','','MF','36','',TO_DATE('25-04-1982','dd-mm-yyyy'),'1','183','74');                                   
INSERT INTO player VALUES ('2002101','이지남','K09','','','','MF','42','',TO_DATE('21-11-1984','dd-mm-yyyy'),'1','183','68');                                   
INSERT INTO player VALUES ('1998413','정광민','K09','','','','FW','23','',TO_DATE('08-01-1976','dd-mm-yyyy'),'1','180','70');                                   
INSERT INTO player VALUES ('1999051','정창근','K09','','','','MF','27','',TO_DATE('10-08-1983','dd-mm-yyyy'),'2','170','63');                                   
INSERT INTO player VALUES ('2000118','최원권','K09','','','','MF','13','',TO_DATE('08-11-1981','dd-mm-yyyy'),'1','173','65');                                   
INSERT INTO player VALUES ('2000120','김병채','K09','','','','FW','15','',TO_DATE('14-04-1981','dd-mm-yyyy'),'1','180','72');                                   
INSERT INTO player VALUES ('1999046','김성재','K09','','','','MF','8','',TO_DATE('17-09-1976','dd-mm-yyyy'),'2','178','72');                                    
INSERT INTO player VALUES ('2002119','뚜따','K09','','','','FW','99','브라질',TO_DATE('20-06-1974','dd-mm-yyyy'),'1','187','84');                               
INSERT INTO player VALUES ('2002105','마르코','K09','','','','FW','11','브라질',TO_DATE('03-12-1976','dd-mm-yyyy'),'1','175','77');                             
INSERT INTO player VALUES ('2001005','박성호','K09','','','','FW','30','',TO_DATE('27-07-1982','dd-mm-yyyy'),'1','187','73');                                   
INSERT INTO player VALUES ('2001108','박윤화','K09','','','','MF','16','',TO_DATE('13-06-1978','dd-mm-yyyy'),'1','175','67');                                   
INSERT INTO player VALUES ('1999047','박정환','K09','','','','FW','20','',TO_DATE('14-01-1977','dd-mm-yyyy'),'1','178','70');                                   
INSERT INTO player VALUES ('1999005','왕정현','K09','','','','FW','28','',TO_DATE('30-08-1976','dd-mm-yyyy'),'2','181','73');                                   
INSERT INTO player VALUES ('2002099','이정수','K09','','','','FW','7','',TO_DATE('08-01-1980','dd-mm-yyyy'),'1','184','74');                                    
INSERT INTO player VALUES ('2002103','조원광','K09','','','','FW','22','',TO_DATE('23-08-1985','dd-mm-yyyy'),'1','183','68');                                   
INSERT INTO player VALUES ('1999044','진순진','K09','','','','MF','26','',TO_DATE('01-03-1974','dd-mm-yyyy'),'2','180','78');                                   
INSERT INTO player VALUES ('2000053','최태욱','K09','','','','FW','9','',TO_DATE('13-03-1981','dd-mm-yyyy'),'1','173','66');                                    
INSERT INTO player VALUES ('2002104','한동원','K09','','','','FW','32','',TO_DATE('06-04-1986','dd-mm-yyyy'),'1','174','61');                                   
INSERT INTO player VALUES ('2001004','한정화','K09','','','','FW','29','',TO_DATE('31-10-1982','dd-mm-yyyy'),'1','173','63');                                   
INSERT INTO player VALUES ('2000164','히카르도','K09','','','','MF','10','브라질',TO_DATE('08-06-1976','dd-mm-yyyy'),'1','189','71');                           
INSERT INTO player VALUES ('2001082','권정혁','K01','KWON, 06GHYUK','','2001','GK','1','',TO_DATE('02-08-1978','dd-mm-yyyy'),'1','195','80');                  
INSERT INTO player VALUES ('1999070','박창주','K01','PARK, CHANGZOO','','1999','GK','40','',TO_DATE('30-09-1972','dd-mm-yyyy'),'1','187','86');                 
INSERT INTO player VALUES ('1997020','서동명','K01','SEO, DONGMYUNG','','2002','GK','21','',TO_DATE('04-05-1974','dd-mm-yyyy'),'1','196','94');                 
INSERT INTO player VALUES ('1998410','양지원','K01','YANG, JIWON','','1998','GK','45','',TO_DATE('28-04-1974','dd-mm-yyyy'),'1','181','75');                    
INSERT INTO player VALUES ('2002039','최무림','K01','CHOI, MOOLIM','','2002','GK','31','',TO_DATE('15-04-1979','dd-mm-yyyy'),'1','185','79');                   
INSERT INTO player VALUES ('2002034','김윤구','K01','KIM, YOONGOO','','2002','DF','20','',TO_DATE('01-09-1979','dd-mm-yyyy'),'1','182','75');                   
INSERT INTO player VALUES ('2001106','끌레베르','K01','Cleber Arild','','2001','DF','3','브라질',TO_DATE('21-01-1969','dd-mm-yyyy'),'1','186','79');            
INSERT INTO player VALUES ('2001080','박경삼','K01','PARK, JYUNGSAM','','2001','DF','25','',TO_DATE('06-06-1978','dd-mm-yyyy'),'1','188','74');                 
INSERT INTO player VALUES ('1997004','박종욱','K01','PARK, JONGWOOK','','1997','DF','29','',TO_DATE('11-01-1975','dd-mm-yyyy'),'1','185','74');                 
INSERT INTO player VALUES ('2002035','변성환','K01','BYUN, SUNGHWAN','','2002','DF','23','',TO_DATE('22-12-1979','dd-mm-yyyy'),'1','176','69');                 
INSERT INTO player VALUES ('1998366','손상호','K01','SON, SANGHO','','1997','DF','28','',TO_DATE('04-05-1974','dd-mm-yyyy'),'1','187','78');                    
INSERT INTO player VALUES ('2002044','유재형','K01','YOU, JAEHYUNG','','2002','DF','39','',TO_DATE('24-08-1977','dd-mm-yyyy'),'1','180','79');                  
INSERT INTO player VALUES ('2001077','조세권','K01','CHOI, SAEKWON','','2001','DF','4','',TO_DATE('26-06-1978','dd-mm-yyyy'),'1','184','80');                   
INSERT INTO player VALUES ('1999069','하성용','K01','HA, SUNGYONG','','1999','DF','43','',TO_DATE('05-10-1976','dd-mm-yyyy'),'1','179','75');                   
INSERT INTO player VALUES ('2000082','한정일','K01','HAN, JEUNGIL','','2000','DF','41','',TO_DATE('03-03-1977','dd-mm-yyyy'),'1','172','65');                   
INSERT INTO player VALUES ('2000054','김건형','K01','KIM, KUNHYUNG','','2000','MF','17','',TO_DATE('11-09-1979','dd-mm-yyyy'),'1','176','70');                  
INSERT INTO player VALUES ('1999058','김도균','K01','KIM, DOKYUN','','1999','MF','6','',TO_DATE('13-01-1977','dd-mm-yyyy'),'1','184','78');                     
INSERT INTO player VALUES ('2001083','박기욱','K01','PARK, KIWOOK','','2001','MF','18','',TO_DATE('22-12-1978','dd-mm-yyyy'),'1','175','68');                   
INSERT INTO player VALUES ('2002028','박진섭','K01','PARK, JINSUP','','2002','MF','2','',TO_DATE('11-03-1977','dd-mm-yyyy'),'1','179','68');                    
INSERT INTO player VALUES ('2001079','서덕규','K01','SEO, DOUKGUY','','2001','DF','5','',TO_DATE('22-10-1978','dd-mm-yyyy'),'1','182','72');                    
INSERT INTO player VALUES ('2002130','에디','K01','Edmilson Alves','','2002','MF','7','브라질',TO_DATE('17-02-1976','dd-mm-yyyy'),'1','182','70');              
INSERT INTO player VALUES ('1999055','이길용','K01','LEE, KILYONG','','1999','MF','22','',TO_DATE('30-03-1976','dd-mm-yyyy'),'2','183','78');                   
INSERT INTO player VALUES ('2002036','이윤섭','K01','LEE, YOONSUB','','2002','MF','26','',TO_DATE('30-07-1979','dd-mm-yyyy'),'1','184','77');                   
INSERT INTO player VALUES ('2002029','이천수','K01','LEE, CHUNSU','','2002','MF','9','',TO_DATE('09-07-1981','dd-mm-yyyy'),'1','174','65');                     
INSERT INTO player VALUES ('2002033','장성욱','K01','01G, SUNGWOOK','','2002','MF','19','',TO_DATE('01-09-1979','dd-mm-yyyy'),'1','174','71');                 
INSERT INTO player VALUES ('1997023','장철민','K01','01G, CHULMIN','','1997','MF','24','',TO_DATE('19-05-1972','dd-mm-yyyy'),'1','179','76');                  
INSERT INTO player VALUES ('2001084','전광철','K01','JEON, KWANGCHEOL','','2001','MF','34','',TO_DATE('16-07-1982','dd-mm-yyyy'),'1','186','74');               
INSERT INTO player VALUES ('2002045','전재운','K01','JEON, JAEWOON','','2002','MF','42','',TO_DATE('05-06-1981','dd-mm-yyyy'),'1','177','67');                  
INSERT INTO player VALUES ('1997008','정정수','K01','06G, JEONGSOO','','1993','MF','8','',TO_DATE('20-11-1969','dd-mm-yyyy'),'1','170','61');                  
INSERT INTO player VALUES ('2002042','정주영','K01','HUNG, HUYOUNG','','2002','MF','36','',TO_DATE('03-05-1979','dd-mm-yyyy'),'1','172','65');                  
INSERT INTO player VALUES ('2002040','조원희','K01','CHO, WONHEE','','2002','MF','32','',TO_DATE('17-04-1983','dd-mm-yyyy'),'1','178','71');                    
INSERT INTO player VALUES ('2002041','곽기훈','K01','','','','FW','33','',TO_DATE('05-11-1979','dd-mm-yyyy'),'1','177','72');                                   
INSERT INTO player VALUES ('1997010','김현석','K01','KIM, HYUNSEOK','','2001','FW','16','',TO_DATE('05-05-1967','dd-mm-yyyy'),'1','178','70');                  
INSERT INTO player VALUES ('2001105','마르코스','K01','03cos Antonio','','2001','FW','44','브라질',TO_DATE('07-04-1977','dd-mm-yyyy'),'1','170','73');         
INSERT INTO player VALUES ('2000045','박규선','K01','PARK, GYUSUN','','2000','FW','15','',TO_DATE('24-09-1981','dd-mm-yyyy'),'1','182','66');                   
INSERT INTO player VALUES ('2002129','알리송','K01','Alison Barros Moraes','','','FW','14','브라질',TO_DATE('30-06-1982','dd-mm-yyyy'),'1','171','60');         
INSERT INTO player VALUES ('2002038','이태유','K01','LEE, TAEYOO','','2002','FW','30','',TO_DATE('01-10-1979','dd-mm-yyyy'),'1','175','64');                    
INSERT INTO player VALUES ('2002030','정성훈','K01','','','','FW','10','',TO_DATE('04-07-1979','dd-mm-yyyy'),'1','187','83');                                   
INSERT INTO player VALUES ('2002037','최인석','K01','CHOI, INSUK','','2002','FW','27','',TO_DATE('07-08-1979','dd-mm-yyyy'),'1','181','74');                    
INSERT INTO player VALUES ('2001104','파울링뇨','K01','03cos Paulo Paulrini','','2001','FW','11','브라질',TO_DATE('04-03-1977','dd-mm-yyyy'),'1','174','75');  
INSERT INTO player VALUES ('2002031','현영민','K01','HYUN, YOUNGMIN','','2002','FW','13','',TO_DATE('25-12-1979','dd-mm-yyyy'),'1','179','73');                 
INSERT INTO player VALUES ('1900061','홍인기','K01','HONG, INKI','','1998','DF','35','',TO_DATE('15-03-79','dd-mm-yyyy'),'1','182','75');                     
INSERT INTO player VALUES ('1997114','김기동','K04','','','','MF','6','',TO_DATE('12-01-1971','dd-mm-yyyy'),'1','171','66');                                    
INSERT INTO player VALUES ('2000005','김기형','K04','','','','MF','19','',TO_DATE('10-07-1977','dd-mm-yyyy'),'1','173','64');                                   
INSERT INTO player VALUES ('2002055','김정현','K04','','','','MF','32','',TO_DATE('01-04-1979','dd-mm-yyyy'),'1','176','68');                                   
INSERT INTO player VALUES ('1997122','김한윤','K04','','','','MF','14','',TO_DATE('11-07-1974','dd-mm-yyyy'),'1','185','74');                                   
INSERT INTO player VALUES ('1997137','남기일','K04','','','','MF','29','',TO_DATE('17-08-1974','dd-mm-yyyy'),'1','177','69');                                   
INSERT INTO player VALUES ('2002131','무스타파','K04','','','','MF','77','',TO_DATE('08-01-1975','dd-mm-yyyy'),'1','180','73');                                                                                                                 
INSERT INTO player VALUES ('2002056','박정주','K04','','','','MF','33','',TO_DATE('26-06-1979','dd-mm-yyyy'),'1','177','73');                                   
INSERT INTO player VALUES ('2000004','신현호','K04','','','','MF','22','',TO_DATE('07-07-1977','dd-mm-yyyy'),'1','183','71');                                   
INSERT INTO player VALUES ('1997125','윤정춘','K04','','','','MF','17','',TO_DATE('18-02-1973','dd-mm-yyyy'),'1','173','66');                                   
INSERT INTO player VALUES ('2001103','장경호','K04','','','','MF','39','',TO_DATE('23-02-1983','dd-mm-yyyy'),'1','174','66');                                   
INSERT INTO player VALUES ('1998209','최문식','K04','','','','MF','10','',TO_DATE('23-10-1971','dd-mm-yyyy'),'1','173','66');                                   
INSERT INTO player VALUES ('1998457','곽경근','K04','GWAK, JYUNGKEUN','골든맨','1998','FW','9','',TO_DATE('10-10-1972','dd-mm-yyyy'),'1','184','81');           
INSERT INTO player VALUES ('2002120','다보','K04','Chelck Ou03 Dabo','','2002','FW','63','',TO_DATE('','dd-mm-yyyy'),'1','183','76');                         
INSERT INTO player VALUES ('1997126','박성철','K04','PARK, SUNGCHUL','코미디언','1997','FW','28','',TO_DATE('16-03-1975','dd-mm-yyyy'),'1','190','78');         
INSERT INTO player VALUES ('1997153','비탈리','K04','VITALIY','','2002','FW','24','',TO_DATE('04-05-1969','dd-mm-yyyy'),'1','183','74');                        
INSERT INTO player VALUES ('1999026','안승인','K04','AN, SEUNGIN','안뽕','1999','FW','13','',TO_DATE('14-03-1973','dd-mm-yyyy'),'1','182','75');                
INSERT INTO player VALUES ('2001019','윤원철','K04','','','','FW','8','',TO_DATE('06-01-1979','dd-mm-yyyy'),'1','184','75');                                    
INSERT INTO player VALUES ('1999027','이성재','K04','LEE, SUNGJAE','까치,돌쇠','1999','FW','11','',TO_DATE('16-05-1976','dd-mm-yyyy'),'1','178','67');          
INSERT INTO player VALUES ('1997135','이원식','K04','LEE, WONSHIK','뺀, 밥식이','1996','FW','27','',TO_DATE('16-05-1973','dd-mm-yyyy'),'1','172','64');         
INSERT INTO player VALUES ('2002057','이종민','K04','LEE, JONGMIN','','2002','FW','34','',TO_DATE('01-08-1983','dd-mm-yyyy'),'1','184','77');                   
INSERT INTO player VALUES ('2001020','정필석','K04','06G, PILSUK','장신','2001','FW','18','',TO_DATE('23-07-1978','dd-mm-yyyy'),'1','190','83');               
INSERT INTO player VALUES ('2000084','제프유','K04','JEFF JI YOUNG','','2001','FW','16','미국',TO_DATE('30-10-1978','dd-mm-yyyy'),'1','184','76');              
INSERT INTO player VALUES ('1900026','롤란','K04','','','2000','FW','','리투아니아',TO_DATE('','dd-mm-yyyy'),'','184','81');                                   
INSERT INTO player VALUES ('1900027','셀라하틴','K04','Selahattin','','2002','FW','11','이탈리아',TO_DATE('','dd-mm-yyyy'),'','180','75');                     
INSERT INTO player VALUES ('1900031','차경복','K08','','','1998','TM','','',TO_DATE('10-01-1937','dd-mm-yyyy'),'1','','');                                      
INSERT INTO player VALUES ('1900032','김학범','K08','','','','','','',TO_DATE('','dd-mm-yyyy'),'','','');                                                      
INSERT INTO player VALUES ('1900033','안익수','K08','','','','','','',TO_DATE('','dd-mm-yyyy'),'','','');                                                      
INSERT INTO player VALUES ('1900034','차상광','K08','','','','','','',TO_DATE('','dd-mm-yyyy'),'','','');                                                      
INSERT INTO player VALUES ('1999045','권찬수','K08','KWON, CHANSOO','','','GK','21','',TO_DATE('30-05-1974','dd-mm-yyyy'),'2','183','77');                      
INSERT INTO player VALUES ('2002107','김경두','K08','KIM, KYOUNGDOO','','','GK','41','',TO_DATE('','dd-mm-yyyy'),'1','194','76');                              
INSERT INTO player VALUES ('1997255','김해운','K08','KIM, HAEWOON','','','GK','1','',TO_DATE('25-12-1973','dd-mm-yyyy'),'2','185','79');                        
INSERT INTO player VALUES ('1999101','양영민','K08','YANG, YOUNGMIN','','','GK','31','',TO_DATE('19-07-1974','dd-mm-yyyy'),'1','190','80');                     
INSERT INTO player VALUES ('2001087','가이모토','K08','KAIMOTO KOJIRO','','','DF','3','',TO_DATE('14-10-1977','dd-mm-yyyy'),'1','182','77');                    
INSERT INTO player VALUES ('2002108','김두영','K08','KIM, DOYOUNG','','','DF','30','',TO_DATE('07-10-1980','dd-mm-yyyy'),'1','181','75');                       
INSERT INTO player VALUES ('2002118','김명휘','K08','KIM, MYONGHWI','','','DF','37','',TO_DATE('08-05-1981','dd-mm-yyyy'),'1','185','76');                      
INSERT INTO player VALUES ('1997329','김영철','K08','KIM, YOUNGCHUL','','','DF','5','',TO_DATE('30-06-1976','dd-mm-yyyy'),'1','183','80');                      
INSERT INTO player VALUES ('1997259','김정재','K08','KIM, 06GJAE','','','DF','13','',TO_DATE('22-05-1974','dd-mm-yyyy'),'2','184','80');                       
INSERT INTO player VALUES ('1997186','김현수','K08','KIM, HYUNSOO','','','DF','15','',TO_DATE('13-03-1973','dd-mm-yyyy'),'2','186','80');                       
INSERT INTO player VALUES ('1997089','노태경','K08','NO, TAEKYOUNG','','','DF','25','',TO_DATE('22-04-1972','dd-mm-yyyy'),'1','175','68');                      
INSERT INTO player VALUES ('1999098','문삼진','K08','MOON, SAMJIN','','','DF','2','',TO_DATE('03-03-1973','dd-mm-yyyy'),'1','173','68');                        
INSERT INTO player VALUES ('2002111','민경인','K08','MIN, KYUNGIN','','','DF','12','',TO_DATE('09-05-1979','dd-mm-yyyy'),'1','177','71');                       
INSERT INTO player VALUES ('2001091','박종남','K08','PARK, JONGNAM','','','DF','34','',TO_DATE('17-11-1976','dd-mm-yyyy'),'1','182','76');                      
INSERT INTO player VALUES ('1997055','박충균','K08','PARK, CHOONGKYUN','','','DF','20','',TO_DATE('20-06-1973','dd-mm-yyyy'),'1','184','70');                   
INSERT INTO player VALUES ('2000034','배진수','K08','BAE, JINSOO','','','DF','38','',TO_DATE('25-01-1976','dd-mm-yyyy'),'1','178','72');                        
INSERT INTO player VALUES ('1998471','이영진','K08','LEE, YOUNGJIN','','','DF','23','',TO_DATE('27-03-1972','dd-mm-yyyy'),'2','180','75');                      
INSERT INTO player VALUES ('1998399','임규식','K08','LIM, KYUSIK','','','DF','27','',TO_DATE('09-05-1975','dd-mm-yyyy'),'1','182','75');                        
INSERT INTO player VALUES ('2002106','곽치국','K08','KWAK, CHIGOOG','','','MF','32','',TO_DATE('22-04-1979','dd-mm-yyyy'),'1','170','68');                      
INSERT INTO player VALUES ('1999095','김상식','K08','KIM, SANGSIK','','','MF','4','',TO_DATE('17-12-1976','dd-mm-yyyy'),'1','184','71');                        
INSERT INTO player VALUES ('2001086','김용희','K08','KIM, YONGHEE','','','MF','18','',TO_DATE('15-10-1978','dd-mm-yyyy'),'1','178','70');                       
INSERT INTO player VALUES ('2002109','노규영','K08','','','','MF','33','',TO_DATE('29-04-1978','dd-mm-yyyy'),'1','180','83');                                   
INSERT INTO player VALUES ('2000126','박강조','K08','PARK, KANGJO','','','MF','6','',TO_DATE('24-01-1980','dd-mm-yyyy'),'1','165','57');                        
INSERT INTO player VALUES ('1998171','박남열','K08','PARK, NAMRYUL','','','MF','8','',TO_DATE('07-05-1970','dd-mm-yyyy'),'2','178','70');                       
INSERT INTO player VALUES ('2001088','백영철','K08','BACK, YOUNGCHUL','','','MF','22','',TO_DATE('11-11-1978','dd-mm-yyyy'),'1','177','71');                    
INSERT INTO player VALUES ('1997242','신태용','K08','SHIN, TAEYONG','','','MF','7','',TO_DATE('11-10-1970','dd-mm-yyyy'),'1','174','67');                       
INSERT INTO player VALUES ('2002117','올리베','K08','Alcir de Oliveira fonseca','','','MF','29','브라질',TO_DATE('14-11-1977','dd-mm-yyyy'),'1','175','73');    
INSERT INTO player VALUES ('2001128','이리네','K08','Ricardo Irineu','','','MF','26','브라질',TO_DATE('12-07-1977','dd-mm-yyyy'),'1','172','69');               
INSERT INTO player VALUES ('2002128','쟈스민','K08','Jasmin Mujidza','','','MF','33','크로아티아',TO_DATE('02-03-1974','dd-mm-yyyy'),'1','180','78');           
INSERT INTO player VALUES ('2002114','전재호','K08','CHUN, JAEHO','','','MF','14','',TO_DATE('08-08-1979','dd-mm-yyyy'),'1','168','64');                        
INSERT INTO player VALUES ('1998131','조진호','K08','CHO, JINHO','','','MF','11','',TO_DATE('02-08-1973','dd-mm-yyyy'),'1','174','68');                         
INSERT INTO player VALUES ('2002115','최낙훈','K08','CHOI, NAKHOON','','','MF','35','',TO_DATE('28-12-1979','dd-mm-yyyy'),'1','172','62');                      
INSERT INTO player VALUES ('1997100','홍도표','K08','HONG, DOPYO','','','MF','9','',TO_DATE('24-07-1973','dd-mm-yyyy'),'1','173','66');                         
INSERT INTO player VALUES ('2000127','김대의','K08','KIM, DAEEUI','','','FW','19','',TO_DATE('30-05-1977','dd-mm-yyyy'),'1','174','70');                        
INSERT INTO player VALUES ('1999084','김우재','K08','KIM, WOOJAE','','','FW','24','',TO_DATE('13-09-1976','dd-mm-yyyy'),'1','173','71');                        
INSERT INTO player VALUES ('1997192','샤샤','K08','Drakulic sasa','','','FW','10','',TO_DATE('28-08-1972','dd-mm-yyyy'),'1','190','84');                        
INSERT INTO player VALUES ('2002112','서관수','K08','SIO, KWANSOO','','','FW','17','',TO_DATE('25-02-1980','dd-mm-yyyy'),'1','179','74');                       
INSERT INTO player VALUES ('2001095','이성운','K08','LEE, SUNGWOON','','','FW','40','',TO_DATE('25-12-1978','dd-mm-yyyy'),'1','173','64');                      
INSERT INTO player VALUES ('2002113','이정운','K08','LEE, 06GWOON','','','FW','28','',TO_DATE('14-03-1983','dd-mm-yyyy'),'1','170','68');                      
INSERT INTO player VALUES ('2001094','장동현','K08','01G, DONGHYUN','','','FW','39','',TO_DATE('19-03-1982','dd-mm-yyyy'),'1','178','67');                     
INSERT INTO player VALUES ('1997250','황연석','K08','HWANG, YOUNSUCK','','','FW','16','',TO_DATE('17-10-1973','dd-mm-yyyy'),'1','192','81');                    
INSERT INTO player VALUES ('1900041','김호','K02','KIM, HO','','','TM','','',TO_DATE('24-11-1944','dd-mm-yyyy'),'1','','');                                     
INSERT INTO player VALUES ('1900042','왕선재','K02','WANG, SUNJAE','','','TC','','',TO_DATE('16-03-1959','dd-mm-yyyy'),'1','','');                              
INSERT INTO player VALUES ('1900043','코샤','K02','03co Antonio Alvarez Ferreira','','','TC','','브라질',TO_DATE('20-07-1960','dd-mm-yyyy'),'1','','');       
INSERT INTO player VALUES ('1900044','윤성효','K02','YOON, SUNGHYO','','','TC','','',TO_DATE('18-05-1962','dd-mm-yyyy'),'1','','');                             
INSERT INTO player VALUES ('1997067','김광수','K02','KIM, JWANGSOO','','','GK','41','',TO_DATE('10-03-1977','dd-mm-yyyy'),'1','182','79');                      
INSERT INTO player VALUES ('1999004','박호진','K02','PARK, HOJIN','','','GK','31','',TO_DATE('22-10-1976','dd-mm-yyyy'),'1','190','82');                        
INSERT INTO player VALUES ('1997203','신범철','K02','SIN, BUMCHUL','','','GK','21','',TO_DATE('27-09-1970','dd-mm-yyyy'),'2','185','85');                       
INSERT INTO player VALUES ('1997035','이운재','K02','LEE, WOONJAE','','','GK','1','',TO_DATE('26-04-1973','dd-mm-yyyy'),'1','182','82');                       
INSERT INTO player VALUES ('1998429','김영선','K02','KIM, YOUNGSUN','','','DF','16','',TO_DATE('03-04-1975','dd-mm-yyyy'),'1','184','81');                                                                                                      
INSERT INTO player VALUES ('2002021','김유진','K02','KIM, YOUJIN','','','DF','37','',TO_DATE('19-06-1983','dd-mm-yyyy'),'1','188','76');                                                                                                        
INSERT INTO player VALUES ('2001073','손승준','K02','SON, SEUNG06','','','DF','32','',TO_DATE('16-05-1982','dd-mm-yyyy'),'1','186','72');                      
INSERT INTO player VALUES ('1997007','신홍기','K02','SHIN, HONGGI','','','DF','15','',TO_DATE('04-05-1968','dd-mm-yyyy'),'1','175','66');                       
INSERT INTO player VALUES ('2002027','안동원','K02','AN, DONGWON','','','DF','49','',TO_DATE('27-09-1982','dd-mm-yyyy'),'1','184','78');                       
INSERT INTO player VALUES ('2002024','이강진','K02','LEE, KANGJIN','','','DF','43','',TO_DATE('25-04-1986','dd-mm-yyyy'),'1','181','65');                     
INSERT INTO player VALUES ('1997036','이병근','K02','LEE, BYOUNGKEUN','','','DF','3','',TO_DATE('28-04-1973','dd-mm-yyyy'),'1','175','63');                                                                                                   
INSERT INTO player VALUES ('2002026','이태권','K02','LEE, TAE-KWON','','','DF','46','',TO_DATE('14-07-1980','dd-mm-yyyy'),'1','180','75');                                                                                                      
INSERT INTO player VALUES ('2002014','조병국','K02','CHO, BYUNGKOOK','','','DF','2','',TO_DATE('01-07-1981','dd-mm-yyyy'),'1','183','78');                      
INSERT INTO player VALUES ('2001075','조성환','K02','CHO, SUNGHWAN','','','DF','5','',TO_DATE('09-04-1982','dd-mm-yyyy'),'1','183','75');                       
INSERT INTO player VALUES ('2002123','가비','K02','Gabriel Popescu','','','MF','10','루마니아',TO_DATE('25-12-1973','dd-mm-yyyy'),'1','177','74');              
INSERT INTO player VALUES ('2000089','강대희','K02','','','','MF','26','',TO_DATE('02-02-1977','dd-mm-yyyy'),'1','174','65');                                                                                                                   
INSERT INTO player VALUES ('1997051','고종수','K02','KO, JONGSU','','','MF','22','',TO_DATE('30-10-1978','dd-mm-yyyy'),'1','176','70');                         
INSERT INTO player VALUES ('2002015','고창현','K02','KO, CHANGHYUN','','','MF','8','',TO_DATE('15-09-1983','dd-mm-yyyy'),'1','170','64');                       
INSERT INTO player VALUES ('1999089','김기범','K02','KIM, KIBUM','','','MF','28','',TO_DATE('14-08-1976','dd-mm-yyyy'),'1','173','65');                         
INSERT INTO player VALUES ('1999083','김동현','K02','KIM, DONGHYUN','','','MF','25','',TO_DATE('17-08-1980','dd-mm-yyyy'),'1','175','72');                      
INSERT INTO player VALUES ('2001071','김두현','K02','KIM, DOOHYUN','','','MF','4','',TO_DATE('14-07-1982','dd-mm-yyyy'),'1','175','67');                        
INSERT INTO player VALUES ('2002025','김준','K02','KIM, 06','','','MF','44','',TO_DATE('09-12-1986','dd-mm-yyyy'),'1','170','65');                             
INSERT INTO player VALUES ('1997040','김진우','K02','KIM, JINWOO','','','DF','7','',TO_DATE('09-10-1975','dd-mm-yyyy'),'1','179','72');                         
INSERT INTO player VALUES ('1997069','데니스','K02','Laktio11 Denis','','','FW','11','러시아',TO_DATE('04-09-1977','dd-mm-yyyy'),'1','176','71');              
INSERT INTO player VALUES ('1997274','서정원','K02','SEO, 06GWON','','','FW','14','',TO_DATE('17-12-1970','dd-mm-yyyy'),'1','173','66');                       
INSERT INTO player VALUES ('2002016','손대호','K02','SON, DAEHO','','','DF','17','',TO_DATE('11-09-1981','dd-mm-yyyy'),'1','186','79');                         
INSERT INTO player VALUES ('2001070','오규찬','K02','OH, GUCHAN','','','MF','24','',TO_DATE('28-08-1982','dd-mm-yyyy'),'1','178','71');                         
INSERT INTO player VALUES ('2002135','윤원일','K02','','','','MF','45','',TO_DATE('31-03-1983','dd-mm-yyyy'),'1','176','70');                                   
INSERT INTO player VALUES ('1999131','이동욱','K02','LEE, DONGWOOK','','','MF','40','',TO_DATE('10-04-1976','dd-mm-yyyy'),'1','176','68');                      
 

----------------------


DROP TABLE EMP;
DROP TABLE DEPT;
DROP TABLE BONUS;
DROP TABLE SALGRADE;
DROP TABLE LOCATIONS;

CREATE TABLE DEPT
       (DEPTNO NUMBER(2) PRIMARY KEY,
        DNAME VARCHAR2(14),
        LOC_code VARCHAR2(2) );

INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'A1');
INSERT INTO DEPT VALUES (20, 'RESEARCH',   'B1');
INSERT INTO DEPT VALUES (30, 'SALES',      'C1');
INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'A1');
INSERT INTO DEPT VALUES (50, 'INSA', null);

CREATE TABLE EMP
       (EMPNO NUMBER(4) PRIMARY KEY,
        ENAME VARCHAR2(10),
        JOB VARCHAR2(9),
        MGR NUMBER(4),
        HIREDATE DATE,
        SAL NUMBER(7, 2),
        COMM NUMBER(7, 2),
        DEPTNO NUMBER(2) REFERENCES DEPT(DEPTNO));

INSERT INTO EMP VALUES
        (7369, 'SMITH',  'CLERK',     7902,
        TO_DATE('17-12-1980', 'DD-Mm-YYYY'),  800, NULL, 20);
INSERT INTO EMP VALUES
        (7499, 'ALLEN',  'SALESMAN',  7698,
        TO_DATE('20-02-1981', 'DD-mm-YYYY'), 1600,  300, 30);
INSERT INTO EMP VALUES
        (7521, 'WARD',   'SALESMAN',  7698,
        TO_DATE('22-02-1981', 'DD-Mm-YYYY'), 1250,  500, 30);
INSERT INTO EMP VALUES
        (7566, 'JONES',  'MANAGER',   7839,
        TO_DATE('2-04-1981', 'DD-Mm-YYYY'),  2975, NULL, 20);
INSERT INTO EMP VALUES
        (7654, 'M%%ARTIN', 'SALESMAN',  7698,
        TO_DATE('28-09-1981', 'DD-Mm-YYYY'), 1250, 1400, 30);
INSERT INTO EMP VALUES
        (7698, 'BLAKE',  'MANAGER',   7839,
        TO_DATE('1-05-1981', 'DD-Mm-YYYY'),  2850, NULL, 30);
INSERT INTO EMP VALUES
        (7782, 'CLARK',  'MANAGER',   7839,
        TO_DATE('9-01-1981', 'DD-Mm-YYYY'),  2450, NULL, 10);
INSERT INTO EMP VALUES
        (7788, 'SCOTT',  'ANALYST',   7566,
        TO_DATE('09-12-1982', 'DD-Mm-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES
        (7839, 'KING',   'PRESIDENT', NULL,
        TO_DATE('17-11-1981', 'DD-Mm-YYYY'), 5000, NULL, 10);
INSERT INTO EMP VALUES
        (7844, 'TURNER', 'SALESMAN',  7698,
        TO_DATE('8-09-1981', 'DD-Mm-YYYY'),  1500,    0, 30);
INSERT INTO EMP VALUES
        (7876, 'ADAMS',  'CLERK',     7788,
        TO_DATE('12-01-1983', 'DD-Mm-YYYY'), 1100, NULL, 20);
INSERT INTO EMP VALUES
        (7900, 'JAMES',  'CLERK',     7698,
        TO_DATE('3-12-1981', 'DD-Mm-YYYY'),   950, NULL, 30);
INSERT INTO EMP VALUES
        (7902, 'FORD',   'ANALYST',   7566,
        TO_DATE('3-12-1981', 'DD-Mm-YYYY'),  3000, NULL, 20);
INSERT INTO EMP VALUES
        (7934, 'MILLER', 'CLERK',     7782,
        TO_DATE('23-01-1982', 'DD-Mm-YYYY'), 1300, NULL, 10);

create table locations
(loc_code  varchar2(2),
 city	   varchar2(12) );
 
 insert into locations values ('A1','SEOUL');
 insert into locations values ('B1','DALLAS');
 insert into locations values ('C1','CHICAGO');
 insert into locations values ('D1','BOSTON');
 

CREATE TABLE BONUS
        (ENAME VARCHAR2(10),
         JOB   VARCHAR2(9),
         SAL   NUMBER,
         COMM  NUMBER);

CREATE TABLE SALGRADE
        (GRADE NUMBER(2),
         LOSAL NUMBER(8),
         HISAL NUMBER(8));

INSERT INTO SALGRADE VALUES (1,  700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999);



CREATE TABLE EMP_HISTORY
   (	NAME VARCHAR2(10), 
	TITLE VARCHAR2(9), 
	DEPTID NUMBER(2)  )  ;

Insert into EMP_HISTORY (NAME,TITLE,DEPTID) values ('CLARK','MANAGER',10);
Insert into EMP_HISTORY (NAME,TITLE,DEPTID) values ('SCOTT','ANALYST',20);
Insert into EMP_HISTORY (NAME,TITLE,DEPTID) values ('SPENCER','OPERATOR',20);
Insert into EMP_HISTORY (NAME,TITLE,DEPTID) values ('VANDYKE','MANAGER',10);
Insert into EMP_HISTORY (NAME,TITLE,DEPTID) values ('BALFORD','CLERK',20);
Insert into EMP_HISTORY (NAME,TITLE,DEPTID) values ('ALLEN','SALESMAN',20);
Insert into EMP_HISTORY (NAME,TITLE,DEPTID) values ('BRIC','PAYCLERK',30);
Insert into EMP_HISTORY (NAME,TITLE,DEPTID) values ('JEWELL','ANALYST',20);


COMMIT;

DROP TABLE EMP_MAST;
DROP TABLE EMPLOYEES;
DROP TABLE MGR_HISTORY;
DROP TABLE SAL_HISTORY;


CREATE TABLE EMPLOYEES 
   (	EMPLOYEE_ID NUMBER(6,0), 
	FIRST_NAME VARCHAR2(20 BYTE), 
	LAST_NAME VARCHAR2(25 BYTE) CONSTRAINT EMP_LAST_NAME_NN NOT NULL , 
	EMAIL VARCHAR2(25 BYTE) CONSTRAINT EMP_EMAIL_NN NOT NULL, 
	PHONE_NUMBER VARCHAR2(20 BYTE), 
	HIRE_DATE DATE CONSTRAINT EMP_HIRE_DATE_NN NOT NULL , 
	JOB_ID VARCHAR2(10 BYTE) CONSTRAINT EMP_JOB_NN NOT NULL , 
	SALARY NUMBER(8,2), 
	COMMISSION_PCT NUMBER(2,2), 
	MANAGER_ID NUMBER(6,0), 
	DEPARTMENT_ID NUMBER(4,0));

Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (100,'Steven','King','SKING','515.123.4567',to_date('03/06/17','RR/MM/DD'),'AD_PRES',24000,null,null,90);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (101,'Neena','Kochhar','NKOCHHAR','515.123.4568',to_date('05/09/21','RR/MM/DD'),'AD_VP',17000,null,100,90);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (102,'Lex','De Haan','LDEHAAN','515.123.4569',to_date('01/01/13','RR/MM/DD'),'AD_VP',17000,null,100,90);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (103,'Alexander','Hunold','AHUNOLD','590.423.4567',to_date('06/01/03','RR/MM/DD'),'IT_PROG',9000,null,102,60);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (104,'Bruce','Ernst','BERNST','590.423.4568',to_date('07/05/21','RR/MM/DD'),'IT_PROG',6000,null,103,60);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (105,'David','Austin','DAUSTIN','590.423.4569',to_date('05/06/25','RR/MM/DD'),'IT_PROG',4800,null,103,60);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (106,'Valli','Pataballa','VPATABAL','590.423.4560',to_date('06/02/05','RR/MM/DD'),'IT_PROG',4800,null,103,60);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (107,'Diana','Lorentz','DLORENTZ','590.423.5567',to_date('07/02/07','RR/MM/DD'),'IT_PROG',4200,null,103,60);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (108,'Nancy','Greenberg','NGREENBE','515.124.4569',to_date('02/08/17','RR/MM/DD'),'FI_MGR',12008,null,101,100);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (109,'Daniel','Faviet','DFAVIET','515.124.4169',to_date('02/08/16','RR/MM/DD'),'FI_ACCOUNT',9000,null,108,100);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (110,'John','Chen','JCHEN','515.124.4269',to_date('05/09/28','RR/MM/DD'),'FI_ACCOUNT',8200,null,108,100);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (111,'Ismael','Sciarra','ISCIARRA','515.124.4369',to_date('05/09/30','RR/MM/DD'),'FI_ACCOUNT',7700,null,108,100);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (112,'Jose Manuel','Urman','JMURMAN','515.124.4469',to_date('06/03/07','RR/MM/DD'),'FI_ACCOUNT',7800,null,108,100);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (113,'Luis','Popp','LPOPP','515.124.4567',to_date('07/12/07','RR/MM/DD'),'FI_ACCOUNT',6900,null,108,100);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (114,'Den','Raphaely','DRAPHEAL','515.127.4561',to_date('02/12/07','RR/MM/DD'),'PU_MAN',11000,null,100,30);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (115,'Alexander','Khoo','AKHOO','515.127.4562',to_date('03/05/18','RR/MM/DD'),'PU_CLERK',3100,null,114,30);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (116,'Shelli','Baida','SBAIDA','515.127.4563',to_date('05/12/24','RR/MM/DD'),'PU_CLERK',2900,null,114,30);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (117,'Sigal','Tobias','STOBIAS','515.127.4564',to_date('05/07/24','RR/MM/DD'),'PU_CLERK',2800,null,114,30);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (118,'Guy','Himuro','GHIMURO','515.127.4565',to_date('06/11/15','RR/MM/DD'),'PU_CLERK',2600,null,114,30);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (119,'Karen','Colmenares','KCOLMENA','515.127.4566',to_date('07/08/10','RR/MM/DD'),'PU_CLERK',2500,null,114,30);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (120,'Matthew','Weiss','MWEISS','650.123.1234',to_date('04/07/18','RR/MM/DD'),'ST_MAN',8000,null,100,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (121,'Adam','Fripp','AFRIPP','650.123.2234',to_date('05/04/10','RR/MM/DD'),'ST_MAN',8200,null,100,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (122,'Payam','Kaufling','PKAUFLIN','650.123.3234',to_date('03/05/01','RR/MM/DD'),'ST_MAN',7900,null,100,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (123,'Shanta','Vollman','SVOLLMAN','650.123.4234',to_date('05/10/10','RR/MM/DD'),'ST_MAN',6500,null,100,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (124,'Kevin','Mourgos','KMOURGOS','650.123.5234',to_date('07/11/16','RR/MM/DD'),'ST_MAN',5800,null,100,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (125,'Julia','Nayer','JNAYER','650.124.1214',to_date('05/07/16','RR/MM/DD'),'ST_CLERK',3200,null,120,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (126,'Irene','Mikkilineni','IMIKKILI','650.124.1224',to_date('06/09/28','RR/MM/DD'),'ST_CLERK',2700,null,120,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (127,'James','Landry','JLANDRY','650.124.1334',to_date('07/01/14','RR/MM/DD'),'ST_CLERK',2400,null,120,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (128,'Steven','Markle','SMARKLE','650.124.1434',to_date('08/03/08','RR/MM/DD'),'ST_CLERK',2200,null,120,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (129,'Laura','Bissot','LBISSOT','650.124.5234',to_date('05/08/20','RR/MM/DD'),'ST_CLERK',3300,null,121,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (130,'Mozhe','Atkinson','MATKINSO','650.124.6234',to_date('05/10/30','RR/MM/DD'),'ST_CLERK',2800,null,121,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (131,'James','Marlow','JAMRLOW','650.124.7234',to_date('05/02/16','RR/MM/DD'),'ST_CLERK',2500,null,121,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (132,'TJ','Olson','TJOLSON','650.124.8234',to_date('07/04/10','RR/MM/DD'),'ST_CLERK',2100,null,121,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (133,'Jason','Mallin','JMALLIN','650.127.1934',to_date('04/06/14','RR/MM/DD'),'ST_CLERK',3300,null,122,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (134,'Michael','Rogers','MROGERS','650.127.1834',to_date('06/08/26','RR/MM/DD'),'ST_CLERK',2900,null,122,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (135,'Ki','Gee','KGEE','650.127.1734',to_date('07/12/12','RR/MM/DD'),'ST_CLERK',2400,null,122,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (136,'Hazel','Philtanker','HPHILTAN','650.127.1634',to_date('08/02/06','RR/MM/DD'),'ST_CLERK',2200,null,122,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (137,'Renske','Ladwig','RLADWIG','650.121.1234',to_date('03/07/14','RR/MM/DD'),'ST_CLERK',3600,null,123,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (138,'Stephen','Stiles','SSTILES','650.121.2034',to_date('05/10/26','RR/MM/DD'),'ST_CLERK',3200,null,123,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (139,'John','Seo','JSEO','650.121.2019',to_date('06/02/12','RR/MM/DD'),'ST_CLERK',2700,null,123,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (140,'Joshua','Patel','JPATEL','650.121.1834',to_date('06/04/06','RR/MM/DD'),'ST_CLERK',2500,null,123,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (141,'Trenna','Rajs','TRAJS','650.121.8009',to_date('03/10/17','RR/MM/DD'),'ST_CLERK',3500,null,124,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (142,'Curtis','Davies','CDAVIES','650.121.2994',to_date('05/01/29','RR/MM/DD'),'ST_CLERK',3100,null,124,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (143,'Randall','Matos','RMATOS','650.121.2874',to_date('06/03/15','RR/MM/DD'),'ST_CLERK',2600,null,124,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (144,'Peter','Vargas','PVARGAS','650.121.2004',to_date('06/07/09','RR/MM/DD'),'ST_CLERK',2500,null,124,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (145,'John','Russell','JRUSSEL','011.44.1344.429268',to_date('04/10/01','RR/MM/DD'),'SA_MAN',14000,0.4,100,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (146,'Karen','Partners','KPARTNER','011.44.1344.467268',to_date('05/01/05','RR/MM/DD'),'SA_MAN',13500,0.3,100,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (147,'Alberto','Errazuriz','AERRAZUR','011.44.1344.429278',to_date('05/03/10','RR/MM/DD'),'SA_MAN',12000,0.3,100,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (148,'Gerald','Cambrault','GCAMBRAU','011.44.1344.619268',to_date('07/10/15','RR/MM/DD'),'SA_MAN',11000,0.3,100,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (149,'Eleni','Zlotkey','EZLOTKEY','011.44.1344.429018',to_date('08/01/29','RR/MM/DD'),'SA_MAN',10500,0.2,100,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (150,'Peter','Tucker','PTUCKER','011.44.1344.129268',to_date('05/01/30','RR/MM/DD'),'SA_REP',10000,0.3,145,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (151,'David','Bernstein','DBERNSTE','011.44.1344.345268',to_date('05/03/24','RR/MM/DD'),'SA_REP',9500,0.25,145,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (152,'Peter','Hall','PHALL','011.44.1344.478968',to_date('05/08/20','RR/MM/DD'),'SA_REP',9000,0.25,145,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (153,'Christopher','Olsen','COLSEN','011.44.1344.498718',to_date('06/03/30','RR/MM/DD'),'SA_REP',8000,0.2,145,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (154,'Nanette','Cambrault','NCAMBRAU','011.44.1344.987668',to_date('06/12/09','RR/MM/DD'),'SA_REP',7500,0.2,145,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (155,'Oliver','Tuvault','OTUVAULT','011.44.1344.486508',to_date('07/11/23','RR/MM/DD'),'SA_REP',7000,0.15,145,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (156,'Janette','King','JKING','011.44.1345.429268',to_date('04/01/30','RR/MM/DD'),'SA_REP',10000,0.35,146,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (157,'Patrick','Sully','PSULLY','011.44.1345.929268',to_date('04/03/04','RR/MM/DD'),'SA_REP',9500,0.35,146,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (158,'Allan','McEwen','AMCEWEN','011.44.1345.829268',to_date('04/08/01','RR/MM/DD'),'SA_REP',9000,0.35,146,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (159,'Lindsey','Smith','LSMITH','011.44.1345.729268',to_date('05/03/10','RR/MM/DD'),'SA_REP',8000,0.3,146,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (160,'Louise','Doran','LDORAN','011.44.1345.629268',to_date('05/12/15','RR/MM/DD'),'SA_REP',7500,0.3,146,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (161,'Sarath','Sewall','SSEWALL','011.44.1345.529268',to_date('06/11/03','RR/MM/DD'),'SA_REP',7000,0.25,146,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (162,'Clara','Vishney','CVISHNEY','011.44.1346.129268',to_date('05/11/11','RR/MM/DD'),'SA_REP',10500,0.25,147,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (163,'Danielle','Greene','DGREENE','011.44.1346.229268',to_date('07/03/19','RR/MM/DD'),'SA_REP',9500,0.15,147,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (164,'Mattea','Marvins','MMARVINS','011.44.1346.329268',to_date('08/01/24','RR/MM/DD'),'SA_REP',7200,0.1,147,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (165,'David','Lee','DLEE','011.44.1346.529268',to_date('08/02/23','RR/MM/DD'),'SA_REP',6800,0.1,147,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (166,'Sundar','Ande','SANDE','011.44.1346.629268',to_date('08/03/24','RR/MM/DD'),'SA_REP',6400,0.1,147,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (167,'Amit','Banda','ABANDA','011.44.1346.729268',to_date('08/04/21','RR/MM/DD'),'SA_REP',6200,0.1,147,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (168,'Lisa','Ozer','LOZER','011.44.1343.929268',to_date('05/03/11','RR/MM/DD'),'SA_REP',11500,0.25,148,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (169,'Harrison','Bloom','HBLOOM','011.44.1343.829268',to_date('06/03/23','RR/MM/DD'),'SA_REP',10000,0.2,148,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (170,'Tayler','Fox','TFOX','011.44.1343.729268',to_date('06/01/24','RR/MM/DD'),'SA_REP',9600,0.2,148,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (171,'William','Smith','WSMITH','011.44.1343.629268',to_date('07/02/23','RR/MM/DD'),'SA_REP',7400,0.15,148,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (172,'Elizabeth','Bates','EBATES','011.44.1343.529268',to_date('07/03/24','RR/MM/DD'),'SA_REP',7300,0.15,148,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (173,'Sundita','Kumar','SKUMAR','011.44.1343.329268',to_date('08/04/21','RR/MM/DD'),'SA_REP',6100,0.1,148,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (174,'Ellen','Abel','EABEL','011.44.1644.429267',to_date('04/05/11','RR/MM/DD'),'SA_REP',11000,0.3,149,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (175,'Alyssa','Hutton','AHUTTON','011.44.1644.429266',to_date('05/03/19','RR/MM/DD'),'SA_REP',8800,0.25,149,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (176,'Jonathon','Taylor','JTAYLOR','011.44.1644.429265',to_date('06/03/24','RR/MM/DD'),'SA_REP',8600,0.2,149,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (177,'Jack','Livingston','JLIVINGS','011.44.1644.429264',to_date('06/04/23','RR/MM/DD'),'SA_REP',8400,0.2,149,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (178,'Kimberely','Grant','KGRANT','011.44.1644.429263',to_date('07/05/24','RR/MM/DD'),'SA_REP',7000,0.15,149,null);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (179,'Charles','Johnson','CJOHNSON','011.44.1644.429262',to_date('08/01/04','RR/MM/DD'),'SA_REP',6200,0.1,149,80);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (180,'Winston','Taylor','WTAYLOR','650.507.9876',to_date('06/01/24','RR/MM/DD'),'SH_CLERK',3200,null,120,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (181,'Jean','Fleaur','JFLEAUR','650.507.9877',to_date('06/02/23','RR/MM/DD'),'SH_CLERK',3100,null,120,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (182,'Martha','Sullivan','MSULLIVA','650.507.9878',to_date('07/06/21','RR/MM/DD'),'SH_CLERK',2500,null,120,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (183,'Girard','Geoni','GGEONI','650.507.9879',to_date('08/02/03','RR/MM/DD'),'SH_CLERK',2800,null,120,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (184,'Nandita','Sarchand','NSARCHAN','650.509.1876',to_date('04/01/27','RR/MM/DD'),'SH_CLERK',4200,null,121,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (185,'Alexis','Bull','ABULL','650.509.2876',to_date('05/02/20','RR/MM/DD'),'SH_CLERK',4100,null,121,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (186,'Julia','Dellinger','JDELLING','650.509.3876',to_date('06/06/24','RR/MM/DD'),'SH_CLERK',3400,null,121,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (187,'Anthony','Cabrio','ACABRIO','650.509.4876',to_date('07/02/07','RR/MM/DD'),'SH_CLERK',3000,null,121,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (188,'Kelly','Chung','KCHUNG','650.505.1876',to_date('05/06/14','RR/MM/DD'),'SH_CLERK',3800,null,122,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (189,'Jennifer','Dilly','JDILLY','650.505.2876',to_date('05/08/13','RR/MM/DD'),'SH_CLERK',3600,null,122,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (190,'Timothy','Gates','TGATES','650.505.3876',to_date('06/07/11','RR/MM/DD'),'SH_CLERK',2900,null,122,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (191,'Randall','Perkins','RPERKINS','650.505.4876',to_date('07/12/19','RR/MM/DD'),'SH_CLERK',2500,null,122,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (192,'Sarah','Bell','SBELL','650.501.1876',to_date('04/02/04','RR/MM/DD'),'SH_CLERK',4000,null,123,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (193,'Britney','Everett','BEVERETT','650.501.2876',to_date('05/03/03','RR/MM/DD'),'SH_CLERK',3900,null,123,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (194,'Samuel','McCain','SMCCAIN','650.501.3876',to_date('06/07/01','RR/MM/DD'),'SH_CLERK',3200,null,123,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (195,'Vance','Jones','VJONES','650.501.4876',to_date('07/03/17','RR/MM/DD'),'SH_CLERK',2800,null,123,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (196,'Alana','Walsh','AWALSH','650.507.9811',to_date('06/04/24','RR/MM/DD'),'SH_CLERK',3100,null,124,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (197,'Kevin','Feeney','KFEENEY','650.507.9822',to_date('06/05/23','RR/MM/DD'),'SH_CLERK',3000,null,124,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (198,'Donald','OConnell','DOCONNEL','650.507.9833',to_date('07/06/21','RR/MM/DD'),'SH_CLERK',2600,null,124,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (199,'Douglas','Grant','DGRANT','650.507.9844',to_date('08/01/13','RR/MM/DD'),'SH_CLERK',2600,null,124,50);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (200,'Jennifer','Whalen','JWHALEN','515.123.4444',to_date('03/09/17','RR/MM/DD'),'AD_ASST',4400,null,101,10);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (201,'Michael','Hartstein','MHARTSTE','515.123.5555',to_date('04/02/17','RR/MM/DD'),'MK_MAN',13000,null,100,20);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (202,'Pat','Fay','PFAY','603.123.6666',to_date('05/08/17','RR/MM/DD'),'MK_REP',6000,null,201,20);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (203,'Susan','Mavris','SMAVRIS','515.123.7777',to_date('02/06/07','RR/MM/DD'),'HR_REP',6500,null,101,40);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (204,'Hermann','Baer','HBAER','515.123.8888',to_date('02/06/07','RR/MM/DD'),'PR_REP',10000,null,101,70);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (205,'Shelley','Higgins','SHIGGINS','515.123.8080',to_date('02/06/07','RR/MM/DD'),'AC_MGR',12008,null,101,110);
Insert into EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID) values (206,'William','Gietz','WGIETZ','515.123.8181',to_date('02/06/07','RR/MM/DD'),'AC_ACCOUNT',8300,null,205,110);

COMMIT;

create table emp_mast
as select * from emp
where job = 'SALESMAN';

CREATE TABLE SAL_HISTORY 
AS SELECT employee_id EMPID, HIRE_DATE hiredate, SALARY SAL FROM EMPLOYEES WHERE 1=2;

CREATE TABLE MGR_HISTORY 
AS SELECT employee_id EMPID, MANAGER_ID MGR, SALARY SAL FROM EMPLOYEES WHERE 1=2;

drop table tab1;
create table tab1
(a number, b number, c number);

insert into tab1 values(100,null,100);
insert into tab1 values(200,100,null);
insert into tab1 values(300,100,200);
insert into tab1 values(null,100,null);
insert into tab1 values(null,null,100);
insert into tab1 values(100,200,100);
insert into tab1 values(null,100,null);

commit;
