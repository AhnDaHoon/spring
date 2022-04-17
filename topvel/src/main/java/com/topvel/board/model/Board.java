package com.topvel.board.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Board {

	private Integer boardSeq;
	private String id;
	private int hits;
	private String title;
	private String content;
}
