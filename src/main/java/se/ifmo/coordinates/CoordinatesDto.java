package se.ifmo.coordinates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.ifmo.common.placemark.Dto;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatesDto implements Dto {
    private Integer id;
    private double x;
    private float y;
}
//public record CoordinatesDto(
//        Integer id,
//        double x,
//        float y
//) implements Dto {
//}
