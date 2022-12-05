package com.minwonhaeso.esc.stadium.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor
@Document(indexName = "stadiums")
public class StadiumDocument {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Double)
    private Double starAvg;

    @Field(type = FieldType.Integer)
    private Integer weekdayPricePerHalfHour;

    @Field(type = FieldType.Integer)
    private Integer holidayPricePerHalfHour;

    public static StadiumDocument fromEntity(Stadium stadium) {
        return StadiumDocument.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .address(stadium.getAddress())
                .starAvg(stadium.getStarAvg())
                .weekdayPricePerHalfHour(stadium.getWeekdayPricePerHalfHour())
                .holidayPricePerHalfHour(stadium.getHolidayPricePerHalfHour())
                .build();
    }
}
