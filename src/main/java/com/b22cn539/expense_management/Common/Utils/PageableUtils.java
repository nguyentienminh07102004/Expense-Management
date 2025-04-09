package com.b22cn539.expense_management.Common.Utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageableUtils {
    public static Pageable pagination(Integer page, Integer limit) {
        if (page == null || page <= 0) page = 1;
        if (limit == null || limit <= 0) limit = 10;
        return PageRequest.of(page - 1, limit);
    }
}
