package web.servise;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    private static int CARS_COUNT;

    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car(++CARS_COUNT, "Mercedes", "VITO"));
        carList.add(new Car(++CARS_COUNT, "Mazda", "CX-7"));
        carList.add(new Car(++CARS_COUNT, "Opel", "Vectra"));
        carList.add(new Car(++CARS_COUNT, "Skoda", "Octavia"));
        carList.add(new Car(++CARS_COUNT, "Audi", "100"));
    }

    @Override
    public List<Car> printCarsParam(int count) {
        carList = count >= 5 ? carList : carList.stream().limit(count).collect(Collectors.toList());
        return carList;
    }
}
