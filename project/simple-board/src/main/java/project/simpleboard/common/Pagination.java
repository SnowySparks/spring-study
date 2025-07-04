package project.simpleboard.common;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagination {

    private Integer page;
    private Integer size;
    private Integer currentElements;
    private Integer totalPages;
    private Long totalElements;
}
