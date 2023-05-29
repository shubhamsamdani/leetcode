class ParkingSystem {

    int big, medium, small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1){
            if(big == 0){
                return false;
            }
            
            big-- ;
        }
        
        if(carType == 2){
            if(medium == 0){
                return false;
            }
            
            medium-- ;
        }
        
        if(carType == 3){
            if(small == 0){
                return false;
            }
            
            small-- ;
        }
        
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */