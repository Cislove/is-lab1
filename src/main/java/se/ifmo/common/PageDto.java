package se.ifmo.common;

import se.ifmo.common.placemark.Dto;

import java.util.List;

public record PageDto <TDto extends Dto>(
        List<TDto> content,
        int pageNumber,
        int pageSize,
        long totalSize

) implements Dto {
}
