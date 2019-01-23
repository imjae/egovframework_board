select * FROM temp_board;
DESC temp_board;
DROP TABLE temp_board;

CREATE TABLE temp_board(
board_num NUMBER,
board_writer VARCHAR2(40),
board_title VARCHAR2(100),
board_content VARCHAR2(2000),
board_hit NUMBER DEFAULT 0,
board_reg_date DATE,
board_update_date DATE);


ALTER TABLE temp_board
DROP COLUMN board_hit;

commit;

ALTER TABLE temp_board
RENAME COLUMN board_subject to board_title;

ALTER TABLE temp_board
MODIFY board_content VARCHAR2(500);

DESC temp_board;

CREATE SEQUENCE seq_temp_board_num;
DROP SEQUENCE seq_temp_board_num;

INSERT INTO temp_board
VALUES
(seq_temp_board_num.nextVal,'testWriter', 'testTitle', 'testContentsss', 10, sysdate, sysdate);

SELECT seq_temp_board_num.nextval FROM dual;
SELECT seq_temp_board_num.nextval FROM dual;
DELETE temp_board WHERE board_num = 4;
COMMIT;


CREATE TABLE tb_user(
user_num NUMBER,
user_email VARCHAR2(60),
user_password VARCHAR2(30)
);

select * FROM tb_user;


CREATE SEQUENCE seq_tb_user_user_num;

INSERT INTO tb_user
VALUES(seq_tb_user_user_num.nextVal, 'jakeim1111@gmail.com', 'qwer1234!');
COMMIT;

DELETE tb_user;

SELECT b.rownum, a.board_title, a.board_writer, a.board_reg_date, a.board_update_date
FROM temp_board a, (SELECT rownum 
                    FROM temp_board) b
ORDER BY rownum DESC;


SELECT rownum, board_num, board_title, board_content, board_writer, board_reg_date, board_update_date
			FROM (SELECT /* +INDEX_DESC(temp_baord pk_bpard */
					rownum rn, board_num, board_title, board_content, board_writer, board_reg_date, board_update_date
				FROM temp_board
				WHERE rownum <= 10
				) 
			WHERE rn > 0;

SELECT *
FROM (SELECT rownum rn, tu.*
      FROM (SELECT * 
            FROM temp_board
            ORDER BY board_num asc) tu
            )
WHERE rn BETWEEN 11 AND 20
ORDER BY rownum DESC;
                    

SELECT rownum, tu.*
FROM (SELECT * 
      FROM temp_board
      ORDER BY board_num asc) tu;
WHERE rownum >10;

SELECT *
FROM(
SELECT rownum rn, tt.* 
FROM(
SELECT * FROM temp_board
ORDER BY board_num)tt)
ORDER BY rn DESC);
WHERE BETWEEN rn 1 AND 10;

SELECT rownum rnrn, test.* 
FROM(
SELECT *
FROM(
SELECT rownum rn, tt.* 
FROM(
SELECT * FROM temp_board
ORDER BY board_num)tt)
ORDER BY rn DESC) test;
WHERE rn BETWEEN 1 AND 10;


SELECT * FROM (
SELECT rownum rnrn, ttt.* 
			FROM(
				SELECT *
				FROM(
					SELECT rownum rn, tt.* 
					FROM(
						SELECT * FROM temp_board
						ORDER BY board_num)tt)
				ORDER BY rn DESC)ttt )
WHERE rnrn BETWEEN 11 AND 20;




















