package com.my.sb.utility;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtility {

	public static Pageable getPageableObj(Integer pgno, String sortingParam) {
		return new PageRequest(pgno, 2, Sort.Direction.DESC	, sortingParam);
	}
}
