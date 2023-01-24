package task2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VehicleTest {

    public Car car;
    public Motorcycle motorcycle;
    @BeforeEach
    void setUp() {
        car = new Car("Dodge", "Ram", 2010);
        motorcycle = new Motorcycle("Dodge", "Ram", 2010);
    }

    /**
     * 1. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * проверка того, что экземпляр объекта Car также является экземпляром транспортного средства; (instanceof)
     */
    @Test
    public void testCarIsInstanceOfVehicle() {

        assertTrue(car instanceof Vehicle);
    }

    /**
     * 2. проверка того, объект Car создается с 4-мя колесами
     */
    @Test
    public void checkingCarIsCreatedFourWheels(){

        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**
     * проверка того, объект Motorcycle создается с 2-мя колесами
     */

    @Test
    public void checkingMotorcycleIsCreatedTwoWheels(){

        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    /**
     *проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
     */
    @Test
    public void checkingCarIsTravelingInTestDriveMode(){

        car.testDrive();

        assertThat(car.getSpeed()).isEqualTo(60);
    }

    /**
     *проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
     */
    @Test
    public void checkingMotorcycleIsTravelingInTestDriveMode(){

        motorcycle.testDrive();

        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    /**
     * проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
     */

    @Test
    public void checkInParkingModeCarStops(){

        car.park();

        assertThat(car.getSpeed()).isEqualTo(0);
    }

    /**
     *проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
     */

    @Test
    public  void checkInParkingModeMotorcycleStops(){

        motorcycle.park();

        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}
