package dto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class RecordDto {
    int breaks;
    String currency;
    DateDto date;
    int hours;
    int id;
    String timeFrom;
    String timeTo;
    String title;
    int totalSalary;
    String type;
    int wage;


}
