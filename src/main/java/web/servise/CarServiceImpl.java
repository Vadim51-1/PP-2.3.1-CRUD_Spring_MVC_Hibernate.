package web.servise;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private static int cars_count;

    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car(++cars_count, "Mercedes", "VITO"));
        carList.add(new Car(++cars_count, "Mazda", "CX-7"));
        carList.add(new Car(++cars_count, "Opel", "Vectra"));
        carList.add(new Car(++cars_count, "Skoda", "Octavia"));
        carList.add(new Car(++cars_count, "Audi", "100"));
    }

    @Override
    public List<Car> printCarsParam(int count) {
        carList = count >= 5 ? carList : carList.stream().limit(count).collect(Collectors.toList());
        return carList;
    }
}
