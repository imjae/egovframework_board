select * FROM temp_board;

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
WHERE user_email

CREATE SEQUENCE seq_tb_user_user_num;

INSERT INTO tb_user
VALUE(seq_tb_user_user_num.nextVal, 'jakeim1111@gmail.com', 'qwer1234!');

