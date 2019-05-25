 class ParkingLot {
		   
		    int SpacesAvailable = 100; 
		   	enum Vehicle { TWOWHEELERS , CARS, TRUCK, BUS;}
		   	
		   	int spaceNeed (Vehicle cType) {
		   		switch(cType) {
		   		case 0: return 1;
		   		case 1:	return 1;
		   		case 2:	return 2;
		   		case 3: return 2;
		   		default : return 0;
		   		}
		   	}
		   	
		   	int isAvailable(Vehicle aVehicle) {
		   		if(!spaceNeed(aVehicle)) {
		   			park(aVehicle);
		   			return 1;
		   		} else {
		   			return -1; // Error Code , Space not found 
		   		}
		   	}
		   	
		   	int park() {
		   		
		   	}
	   }
	   
