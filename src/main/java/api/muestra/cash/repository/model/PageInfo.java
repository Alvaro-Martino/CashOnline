package api.muestra.cash.repository.model;

import lombok.Data;

@Data
public class PageInfo {
    private Integer page;
    private Integer size;
    private Long totalElements;
    private Integer totalPages;
}
