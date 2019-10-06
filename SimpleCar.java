import java.text.DecimalFormat;
/**
 * Simulating the functionality of a basic car.
 *
 * @author Alaine Banninga
 * @version 2/13/2018
 */
public class SimpleCar
{
    // instance variables  
    private String model;
    private int carMiles;
    private int mileage;
    private double gasInTank;
    private double mpg;
    private final int OIL_MILES = 5000;
    private final double FULL_TANK = 12.0;  

    /**
     * default constructor that initializes instance variables
     */
    public SimpleCar() {
        // instance variables
        mpg = 22.7;
        model = "Generic Car";
        gasInTank = 12.0;
        carMiles = 0;
        mileage = 0;
    }

    /**
     * Constructor that assigns model and mpg to respective parameters
     *
     *@param String model of the car
     *@param double miles per gallon of the car
     */
    public SimpleCar (String pmodel, double pmpg) {
        model = pmodel;
        mpg = pmpg;
    }

    /**
     * Method for returning the current number of miles on the car
     * 
     * @return miles on the car
     */
    public int checkOdometer () {
        return carMiles;
    }

    /**
     * Method for checking how much gas is left
     *
     *@return how much gas the car has
     *
     */
    public double checkGasGauge () {
        return gasInTank;
    }

    /** 
     * Method for returning the miles at which you'll need an oil change
     *
     * @return miles at which the driver should get the next oil change
     * 
     */
    public double checkNextOilChange () {
        return mileage;
    }

    /**Method that honks the car's horn*/
    public void honkHorn () {
        System.out.println(model + " says 'Beep beep!'");
    }

    /**Method that adds gas to tank
     *
     *@param amount of gas being added to tank
     *
     */
    public void addGas (double g) {
        DecimalFormat fmt = new DecimalFormat("0.00");
        if (g < 0){
            System.out.println("Warning: gas must be a positive number");
            System.out.println(model + " now has " + fmt.format(gasInTank) + " gallons of gas.");
        }
        else {
            if ((gasInTank + g) > FULL_TANK) {
                System.out.println("Warning: gas tank overflowed!");
                gasInTank = gasInTank + (FULL_TANK - gasInTank);
                System.out.println(model + " now has " + fmt.format(gasInTank) + " gallons of gas.");
            }
            else {
                gasInTank = gasInTank + g;
                System.out.println(model + " now has " + fmt.format(gasInTank) + " gallons of gas.");
            }
        }
    }

    /**Method that "drives" the car
     * 
     * @param miles being driven
     * 
     */
    public void drive (int miles) {
        DecimalFormat fmt2 = new DecimalFormat("0.00");
        if (miles < 0){
            System.out.println("Error --- miles must be positive");
            carMiles = carMiles;
        }
        else {
            if ((gasInTank - (miles/mpg)) <= 0) {
                System.out.println(model + " ran out of gas. " 
                    + model + " drove " + fmt2.format(gasInTank * mpg) + 
                    " miles before running out of gas.");
                carMiles = carMiles + (int)(gasInTank * mpg);
                gasInTank = 0.0;
            }
            else {
                System.out.println(model + " drove " + miles + " miles.");
                carMiles = carMiles + miles;    
                gasInTank = gasInTank - (miles / mpg);
            }
        }
    }

    /**Changes the car's oil and resets mileage for next oil change*/
    public void changeOil () {
        mileage = carMiles + OIL_MILES;
        System.out.println(model + " oil changed. Next oil change at " + mileage + " miles.");
    }

    /**Method that checks if oil should be changed*/
    public void checkOil () {
        if (mileage > carMiles) {
            System.out.println("Oil looks good.");
        }
        else {
            System.out.println("You should change the oil.");
        }
    }
}
