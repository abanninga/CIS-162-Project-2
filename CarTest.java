
/**
 * Testing the code from SimpleCar.
 *
 * @author Alaine Banninga
 * @version 2/13/2018
 */
public class CarTest {
    public static void main(String args[]){
        SimpleCar myCar = new SimpleCar();
        SimpleCar yourCar = new SimpleCar("15 Honda Accord", 23.5);
        int errors = 0;

        // test driving 100 miles
        myCar.drive(100);
        if(myCar.checkOdometer() != 100){
            System.out.println("ERROR! Odometer should have 100 miles.");
            errors++;
        }

        // test running out of gas
        myCar.drive(1000);
        if(myCar.checkGasGauge() < -0.01 || myCar.checkGasGauge() > 0.01){
            System.out.println("ERROR! Gas tank should be empty.");
            errors++;
        }   

        // test reading in odometer value before driving 
        if(yourCar.checkOdometer() != 0){
            System.out.println("Error! Odometer should be 0.");
            errors++;
        }

        // test reading gas gauge before adding gas
        if(yourCar.checkGasGauge() != 0){
            System.out.println("Error! Gas gauge should read 0.0 gallons");
            errors++;
        }

        // test next oil change
        if(yourCar.checkNextOilChange() > 5000){
            System.out.println("Error! Distance between oil changes should be 5000 miles or less");
            errors++;
        }

        // testing addGas method
        yourCar.addGas(-2);
        yourCar.addGas(13.0);
        
        // testing negative miles
        yourCar.drive(-1);
        
        // testing driving 50 miles
        yourCar.drive(50);
        
        // testing if 50 miles show up on odometer
        System.out.println(yourCar.checkOdometer());
                
        // honking the horn
        yourCar.honkHorn();
        
        // changing the oil
        yourCar.changeOil();
        
        // checking if next oil change is 50 (last oil change) + 5000
        System.out.println(yourCar.checkNextOilChange());
        
        // checking if an oil change is needed
        yourCar.checkOil();
        
        System.out.println("Testing complete with " + errors + " errors."); 
    }
}
