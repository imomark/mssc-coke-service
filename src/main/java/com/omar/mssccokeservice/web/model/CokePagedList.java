package com.omar.mssccokeservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CokePagedList extends PageImpl<CokeDto> {
    public CokePagedList(List<CokeDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public CokePagedList(List<CokeDto> content) {
        super(content);
    }
}
