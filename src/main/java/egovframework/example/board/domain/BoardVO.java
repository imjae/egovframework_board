package egovframework.example.board.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Long board_num;
	private String board_writer;
	private String board_title;
	private String board_content;
	private Date board_reg_date;
	private Date board_update_date;
}
