// Implement your City class in this file
public class City{

        // private instance variables
        private String name;
        private String state;
        private double highTemp;
        private double lowTemp;

        // public overloaded constructor - City class - 4 arguments
        public City( String _city_name, String _state_name, double _high_temp, double _low_temp){
                //  assign to private instance variables
                this.name = _city_name;
                this.state = _state_name;
                this.highTemp = _high_temp;
                this.lowTemp = _low_temp;
        }

        // City Class - public methods 

        //getName() - no arguments
        public  String getName(){
            // return String 
            return name;
        }

        //getState() - no aruguments - return String 
        public String getState(){

            return state;
        }
        //getHighTemp()- no arguments- return a double
        public double getHighTemp(){

            return highTemp;
        }
        //setHighTemp()-  one double argument- will not return anything
        public void setHighTemp(double _high_temp){
            this.highTemp = _high_temp;

        }

        //getLowTemp()- no arguments- return a double
        public double getLowTemp(){

            return lowTemp;
        }

        //setLowTemp()-  one double argument- will not return anything
        public void setLowTemp(double _low_temp){

            this.lowTemp = _low_temp;
        }
        // printInfo() - no arguments - will not return anything
        public void printInfo(){

            System.out.printf("%s, %s (High = %.2f, Low = %.2f)\n" , name, state, highTemp, lowTemp);
        }
}