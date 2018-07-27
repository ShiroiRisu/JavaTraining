package ua.kpi.tef.util;

import ua.kpi.tef.model.UserMeal;
import ua.kpi.tef.model.UserMealWithExceed;
import ua.kpi.tef.util.TimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        List<UserMealWithExceed> result = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(20, 0), 2000);
        for (UserMealWithExceed temp : result)
            System.out.println(temp.toString());
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with correctly exceeded field

        List<UserMealWithExceed> result = new LinkedList<>();
        Map<LocalDate, Integer> dailyCalories = new HashMap<>();

        for (UserMeal temp : mealList) {
            //   if (dailyCalories.containsKey(temp.getDateTime().toLocalDate())) {
            dailyCalories.merge(temp.getDateTime().toLocalDate(), temp.getCalories(), (v1, v2) -> v1 + v2);
            //    }
        }

        for (UserMeal temp : mealList) {
            if (TimeUtil.isBetween(temp.getDateTime().toLocalTime(), startTime, endTime)) {
                result.add(new UserMealWithExceed(temp.getDateTime(), temp.getDescription(), temp.getCalories(),
                        dailyCalories.get(temp.getDateTime().toLocalDate()) > caloriesPerDay));
            }
        }

        return result;
    }
}
