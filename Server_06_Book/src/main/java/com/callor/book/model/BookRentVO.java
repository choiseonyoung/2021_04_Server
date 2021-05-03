package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// INSERT와 UPDATE를 
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookRentVO {
	private Long br_seq;//	number
	private String br_sdate;//	nvarchar2(10 char)
	private String br_isbn;//	char(13 byte)
	private String br_bcode;//	char(5 byte)
	private String br_edate;//	nvarchar2(10 char)
	private Integer br_price;//	number
}
