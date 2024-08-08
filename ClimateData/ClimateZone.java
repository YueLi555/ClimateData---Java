
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Implement your ClimateZone class in this file
public class ClimateZone{

    // private instance variables a variable named cityList that will store a reference to an ArrayList<City>
    private ArrayList<City> cityList;

    // default constructor 
    public ClimateZone(){

        // instantiate a new ArrayList object
        cityList = new ArrayList<>();
    }

   // overloaded constructor - one String argument
public ClimateZone(String fileName) throws IOException {
    // instantiate a new ArrayList object, store City reference
    cityList = new ArrayList<City>();

    // open the climate zone data file named in the parameter variable
    FileInputStream _open_file_name = new FileInputStream(fileName);
    // read in the data from this file
    Scanner _scanner = new Scanner(_open_file_name);

    // read in the data each line in the file
    // while loop for reading each line
    while (_scanner.hasNextLine()) {
        String _line = _scanner.nextLine().trim();

        // check if the line is not empty, if it has values inside, keep checking others
        if (!_line.isEmpty()) {

            // do something - to get another scanner
            Scanner _line_scanner = new Scanner(_line);
            if (_line_scanner.hasNext()) {
                // to get the name
                String _city_name = _line_scanner.next(); // to get the city name

                if (_line_scanner.hasNext()) {
                    String _state_name = _line_scanner.next(); // to get the state name

                    if (_line_scanner.hasNextDouble()) {
                        double _high_temp = _line_scanner.nextDouble();
                        if (_line_scanner.hasNextDouble()) {

                            double _low_temp = _line_scanner.nextDouble();

                            City _new_city = new City(_city_name, _state_name, _high_temp, _low_temp); // store in a new Class's object
                            cityList.add(_new_city); // add String, String , double , double to the new ArrayList

                            // printf it with format
                            System.out.printf("%s, %s (High = %.2f, Low = %.2f)\n", _city_name, _state_name, _high_temp, _low_temp);
                        }
                    }
                }
            }
            _line_scanner.close();
        }
    }

    // end of the file close the FileInputStream and Scanner
    _scanner.close();
    _open_file_name.close();
}


    // addCity()
    public   void  addCity(String _city_name, String _state_name, double _high_temp, double _low_temp){
       City _new_city = new City(_city_name, _state_name,_high_temp, _low_temp ); // store the value in new object
       cityList.add(_new_city); // update the _new_city to new ArratList<City>
       System.out.println("New city : " + getCityCount());
       
    }
    // getCityCount(); - no arguments
    public  int getCityCount(){
        return cityList.size();
    }

    // getCityByName(); - two String arguments - return City Reference 
    public  City  getCityByName(String _city_names, String _state_names){
       
        for(City _each : cityList ){
            if( (_each.getName().equals(_city_names)) && (_each.getState().equals(_each.getState()))){

                return _each; // return the found citys and states 
            }

        }
        return null;
    }

    // printHottestCities() - no arguments -  will not return anything 
    public void printHottestCities(){
       City _high_temp_1 = null;
       City _high_temp_2 = null;

       for (City _hottest_city : cityList) {
           //to check 
           if(_high_temp_1 == null || _hottest_city.getHighTemp() > _high_temp_1.getHighTemp()){
                _high_temp_2 = _high_temp_1; // keep updaing this _high_value
                _high_temp_1 = _hottest_city; // 
           }else if (_high_temp_2 == null || _hottest_city.getHighTemp() > _high_temp_2.getHighTemp()) {
            _high_temp_2 = _hottest_city;
           }
       }
       // call the printInfo() for printing;
       if(_high_temp_1 != null){ _high_temp_1.printInfo();}
       if(_high_temp_2 != null){ _high_temp_2.printInfo();}
    }

    // printColdestCitie(); - two objects with the lowest low temps < 

    public void printColdestCities(){
        City _low_temp_city_1 = null;
        City _low_temp_city_2 = null;
        // to check each temps
        for(City _lowest_temp : cityList){
            // if condition to compare the _lowest_temp and _low_city_1 first 
            if(_low_temp_city_1 == null || _lowest_temp.getLowTemp() < _low_temp_city_1.getLowTemp()){
                // to update value
                _low_temp_city_2 = _low_temp_city_1; // keep upding the _low_city_2
                _low_temp_city_1 = _lowest_temp; // keep updating the _low_city_1
            } else if( _low_temp_city_2 == null || _lowest_temp.getLowTemp() < _low_temp_city_2.getLowTemp()){
                _low_temp_city_2 = _lowest_temp;
            } // to compare the second one
        }
        // call the printInfo() function to print infomation
        if(_low_temp_city_1 != null){ _low_temp_city_1.printInfo();}
        if(_low_temp_city_2 != null) { _low_temp_city_2.printInfo();}
    }

    // printAllCities() - no arguments - not return anything
    public void printAllCities() {
            for (City _city : cityList) {
                _city.printInfo();
    }
}

}